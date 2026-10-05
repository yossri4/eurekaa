package discover.authservice1.service;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import discover.authservice1.config.*;
import discover.authservice1.dto.*;
import discover.authservice1.model.PasswordResetToken;
import discover.authservice1.model.User;
import discover.authservice1.repository.PasswordResetTokenRepository;
import discover.authservice1.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordResetTokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepository, PasswordResetTokenRepository tokenRepository,
                       PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.tokenRepository = tokenRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public RegisterResponseDto register(RegisterRequestDto request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new EmailAlreadyUsedException("Cet email est déjà utilisé.");
        }

        User user = new User();
        user.setPrenom(request.getPrenom());
        user.setNom(request.getNom());
        user.setEmail(request.getEmail());
        user.setMotDePasse(passwordEncoder.encode(request.getMotDePasse()));
        user.setRole(User.Role.valueOf(request.getRole()));

        // Statut selon le rôle (section 2.1 du cahier des charges)
        if (user.getRole() == User.Role.INVESTOR || user.getRole() == User.Role.INTERNATIONAL_COMPANY) {
            user.setStatut(User.AccountStatus.ACTIVE);
        } else {
            user.setStatut(User.AccountStatus.PENDING);
        }

        // Champs spécifiques
        user.setPaysResidence(request.getPaysResidence());
        user.setSecteursInteret(request.getSecteursInteret());
        user.setSpecialite(request.getSpecialite());
        user.setPays(request.getPays());
        user.setNomEntreprise(request.getNomEntreprise());
        user.setSecteurPrincipal(request.getSecteurPrincipal());
        user.setRegion(request.getRegion());
        user.setNomSociete(request.getNomSociete());
        user.setPaysOrigine(request.getPaysOrigine());
        user.setSecteur(request.getSecteur());

        userRepository.save(user);

        return new RegisterResponseDto("Compte créé avec succès");
    }

    public LoginResponseDto login(LoginRequestDto request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new InvalidCredentialsException("Email ou mot de passe incorrect"));

        if (!passwordEncoder.matches(request.getMotDePasse(), user.getMotDePasse())) {
            throw new InvalidCredentialsException("Email ou mot de passe incorrect");
        }

        if (user.getStatut() != User.AccountStatus.ACTIVE) {
            throw new AccountNotActiveException(user.getStatut());
        }

        String token = jwtService.generateToken(user.getEmail(), user.getRole().name());
        return new LoginResponseDto(token, user.getRole().name());
    }

    @Transactional
    public void forgotPassword(ForgotPasswordRequestDto request) {
        // Toujours répondre pareil, que l'email existe ou non (sécurité — cf. cahier des charges 2.3)
        userRepository.findByEmail(request.getEmail()).ifPresent(user -> {
            tokenRepository.deleteByUserEmail(user.getEmail());

            PasswordResetToken resetToken = new PasswordResetToken();
            resetToken.setToken(UUID.randomUUID().toString());
            resetToken.setUserEmail(user.getEmail());
            resetToken.setExpirationDate(LocalDateTime.now().plusHours(1));
            tokenRepository.save(resetToken);

            // TODO : envoyer un vrai email avec le lien contenant resetToken.getToken()
            // Ex: https://votre-site.com/reinitialiser-mot-de-passe?token=xxx
            System.out.println("Lien de réinitialisation (à envoyer par email): "
                    + "http://localhost:4200/reinitialiser-mot-de-passe?token=" + resetToken.getToken());
        });
    }

    public void resetPassword(ResetPasswordRequestDto request) {
        PasswordResetToken resetToken = tokenRepository.findByToken(request.getToken())
                .orElseThrow(() -> new TokenExpiredException("Token invalide"));

        if (resetToken.isExpired()) {
            throw new TokenExpiredException("Token expiré");
        }

        User user = userRepository.findByEmail(resetToken.getUserEmail())
                .orElseThrow(() -> new TokenExpiredException("Utilisateur introuvable"));

        user.setMotDePasse(passwordEncoder.encode(request.getNouveauMotDePasse()));
        userRepository.save(user);

        tokenRepository.delete(resetToken);
    }
}