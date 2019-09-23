package pl.project.life_sperience.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import pl.project.life_sperience.domain.User;

@Service
public class NotificationService {

    private final JavaMailSender javaMailSender;

    @Autowired
    public NotificationService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendNotification(User user) throws MailException {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(user.getEmail());
        mailMessage.setFrom("bromek42@gmail.com");
        mailMessage.setSubject("Rejestracja na LifeSperience!");
        mailMessage.setText("Thanks for registration! \n You can login here: <a href=\"http://localhost:8080/login\">KLIK</a>");

        javaMailSender.send(mailMessage);
    }

}
