package pl.project.life_sperience.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.project.life_sperience.Notification.NotificationService;
import pl.project.life_sperience.lvl.Lvl;
import pl.project.life_sperience.lvl.LvlService;

@Controller
@RequestMapping("/user")
public class UserController {
    private final
    LvlService lvlService;
    private  final
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
    public String saveUser(Model model){
        model.addAttribute("user", new User());
        return "registrationForm";
    }

    @PostMapping("/registration")
    public String saveUser(@ModelAttribute User user, BindingResult result){
        if(result.hasErrors()) {
            return "registrationForm";
        }
        user.setLvl(lvlService.getLvl(1));
        userService.saveUser(user);
        notificationService.sendNotification(user);
        return "redirect:../login";
    }

    @GetMapping("/login")
    public String loginUser() {
        return "loginForm";
    }


    @GetMapping("/userLvl")
    @ResponseBody
    public String getUserLvl() {
        User user = new User();
        Lvl lvl = lvlService.getLvl(2);
        user.setLvl(lvl);
        return user.getLvl().toString();
    }


}
