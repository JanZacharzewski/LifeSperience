package pl.project.life_sperience.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.project.life_sperience.notification.NotificationService;
import pl.project.life_sperience.domain.User;
import pl.project.life_sperience.service.CurrentUser;


@Controller
public class HomeControllerer {

    private Logger logger = LoggerFactory.getLogger(HomeControllerer.class);

    private final NotificationService notificationService;

    public HomeControllerer(NotificationService notificationService) {
        this.notificationService = notificationService;
    }


    @RequestMapping("/singup")
    @ResponseBody
    public String singup() {
        return "dzięki :D";
    }

    @RequestMapping("/singup-success")
    @ResponseBody
    public String success() {
        // create a user
        User user = new User();
        user.setEmail("noela.zdunek@gmail.com");
        // send notification
        try {
            notificationService.sendNotification(user);
        } catch (MailException e) {
            // catch error
            logger.info("Error: " + e.getMessage());
        }
        return "...";
    }

    @GetMapping("/about")
    @ResponseBody
    public String about(@AuthenticationPrincipal CurrentUser customUser){
        return "hha";
    }

    @GetMapping("/admin/dupa")
    @ResponseBody
    public String adminDupa(@AuthenticationPrincipal CurrentUser customUser){
        return "admin dupa";
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

}
