package pl.project.life_sperience.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.project.life_sperience.notification.NotificationService;
import pl.project.life_sperience.domain.User;
import pl.project.life_sperience.service.CurrentUser;


@Controller
public class HomeController {

    @GetMapping("/")
    public String home(@AuthenticationPrincipal CurrentUser customUser,Model model) {
        if(customUser!=null){
            model.addAttribute("user",customUser.getUser());
        }
        return "home";
    }

}
