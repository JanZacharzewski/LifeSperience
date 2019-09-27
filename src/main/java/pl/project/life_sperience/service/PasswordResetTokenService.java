package pl.project.life_sperience.service;

import pl.project.life_sperience.domain.PasswordResetToken;

public interface PasswordResetTokenService {
    PasswordResetToken save (PasswordResetToken passwordResetToken);
}
