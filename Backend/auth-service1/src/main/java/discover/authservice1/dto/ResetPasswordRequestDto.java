package discover.authservice1.dto;

import lombok.Data;

@Data
public class ResetPasswordRequestDto {
    private String token;
    private String nouveauMotDePasse;
}