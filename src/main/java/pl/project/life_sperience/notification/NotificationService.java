package pl.project.life_sperience.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import pl.project.life_sperience.domain.User;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class NotificationService {

    private final JavaMailSender javaMailSender;

    @Autowired
    public NotificationService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendNotification(User user) throws MessagingException  {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
        String htmlMsg = "<h3>Thanks for registration!</h3> <br> You can login here: <a href=\"http://localhost:8080/login\">KLIK</a>";
        helper.setText(htmlMsg, true);
        helper.setTo(user.getEmail());
        helper.setFrom("lifesperienceapp@gmail.com");
        helper.setSubject("Rejestracja na LifeSperience!");
        javaMailSender.send(mimeMessage);


    }
    public void sendForgotPasswordEmail(SimpleMailMessage messagePass) throws MessagingException{
        javaMailSender.send(messagePass);
    }

}
