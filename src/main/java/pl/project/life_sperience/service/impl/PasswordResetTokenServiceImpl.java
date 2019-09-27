package pl.project.life_sperience.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Transient;
import org.springframework.stereotype.Service;
import pl.project.life_sperience.domain.PasswordResetToken;
import pl.project.life_sperience.repository.PasswordResetTokenRepository;
import pl.project.life_sperience.service.PasswordResetTokenService;

import javax.transaction.Transactional;

@Service
@Transactional
public class PasswordResetTokenServiceImpl implements PasswordResetTokenService {


    private final PasswordResetTokenRepository passwordResetTokenRepository;

    @Autowired
    public PasswordResetTokenServiceImpl(PasswordResetTokenRepository passwordResetTokenRepository) {
        this.passwordResetTokenRepository = passwordResetTokenRepository;
    }


    @Override
    public PasswordResetToken save(PasswordResetToken passwordResetToken) {
        return passwordResetTokenRepository.save(passwordResetToken);
    }
}
