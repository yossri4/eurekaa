package discover.authservice1.config;

import discover.authservice1.model.User;

public class AccountNotActiveException extends RuntimeException {
    private final User.AccountStatus statut;

    public AccountNotActiveException(User.AccountStatus statut) {
        super("Compte non actif: " + statut);
        this.statut = statut;
    }

    public User.AccountStatus getStatut() {
        return statut;
    }
}