package pl.project.life_sperience.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.project.life_sperience.domain.User;
import pl.project.life_sperience.notification.NotificationService;
import pl.project.life_sperience.domain.Lvl;
import pl.project.life_sperience.service.CurrentUser;
import pl.project.life_sperience.service.LvlService;
import pl.project.life_sperience.service.UserService;

import javax.validation.Valid;


@Controller
@RequestMapping("/user")
public class UserController {

    private final
    LvlService lvlService;
    private final
    UserService userService;
    private final
    NotificationService notificationService;


    @Autowired
    public UserController(LvlService lvlService, UserService userService, NotificationService notificationService) {
        this.lvlService = lvlService;
        this.userService = userService;
        this.notificationService = notificationService;
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
        notificationService.sendNotification(user);
        return "redirect:/user/login";
    }

    @GetMapping(value = "/login", produces = "text/html; charset = utf-8")
    public String loginUser(Model model) {
//        model.addAttribute("user", )
        return "loginForm";
    }

    @PostMapping("/login")
    public String loginUser() {
        return "loginForm";
    }

}
