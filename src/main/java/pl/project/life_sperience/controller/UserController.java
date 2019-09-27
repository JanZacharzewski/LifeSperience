package pl.project.life_sperience.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.project.life_sperience.domain.PasswordResetToken;
import pl.project.life_sperience.domain.User;
import pl.project.life_sperience.notification.NotificationService;
import pl.project.life_sperience.domain.Lvl;
import pl.project.life_sperience.service.CurrentUser;
import pl.project.life_sperience.service.LvlService;
import pl.project.life_sperience.service.PasswordResetTokenService;
import pl.project.life_sperience.service.UserService;

import javax.mail.MessagingException;
import javax.validation.Valid;


@Controller
public class UserController {

    private final
    LvlService lvlService;
    private final
    UserService userService;
    private final
    NotificationService notificationService;
    private final PasswordResetTokenService passwordResetTokenService;


    @Autowired
    public UserController(LvlService lvlService, UserService userService, NotificationService notificationService, PasswordResetTokenService passwordResetTokenService) {
        this.lvlService = lvlService;
        this.userService = userService;
        this.notificationService = notificationService;
        this.passwordResetTokenService = passwordResetTokenService;
    }

    @GetMapping("/registration")
    public String saveUser(Model model) {
        model.addAttribute("user", new User());
        return "registrationForm";
    }

    @PostMapping("/registration")
    public String saveUser(@ModelAttribute @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "registrationForm";
        }
        Lvl lvl = new Lvl();
        lvl.setLvl_value(1);
        lvl.setXP_needed(1000);
        lvlService.saveLvl(lvl);
        user.setLvl(lvl);
        userService.saveUser(user);
        try {
            notificationService.sendNotification(user);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return "redirect:/login";
    }

    @GetMapping(value = "/login", produces = "text/html; charset = utf-8")
    public String loginUser(@RequestParam(value = "error", required = false) String error, Model model) {
        String errorMessage = null;
        if (error != null) {
            errorMessage = "Błędne dane logowania";
        }
        model.addAttribute("errorMessage", errorMessage);
        return "loginForm";
    }


    @GetMapping(value = "/forgot-password", produces = "text/html; charset=utf-8")
    public String displayResetPassword(Model model, User user) {
        return "forgotPassword";
    }

    @PostMapping(value = "/forgot-password", produces = "text/html; charset=utf-8")
    public String forgotUserPassword(Model model, User user) {
        User existingUser = userService.findByEmail(user.getEmail());
        if (existingUser != null) {
            // Create token
            PasswordResetToken passwordResetToken = new PasswordResetToken(existingUser);

            // Save it
            passwordResetTokenService.save(passwordResetToken);

            // Create the email
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(existingUser.getEmail());
            mailMessage.setSubject("Complete Password Reset!");
            mailMessage.setFrom("bromek42@gmail.com");
            mailMessage.setText("To complete the password reset process, please click here: "
                    + "http://localhost:8082/confirm-reset?token=" + passwordResetToken.getToken());

            // Send the email
            try {
                notificationService.sendForgotPasswordEmail(mailMessage);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }
        return "login";
    }
}




