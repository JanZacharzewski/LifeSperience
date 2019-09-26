package pl.project.life_sperience.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.project.life_sperience.service.CurrentUser;
import pl.project.life_sperience.service.GoalService;
import pl.project.life_sperience.service.LvlService;
import pl.project.life_sperience.service.UserService;


@Controller
public class HomeController {

    private final GoalService goalService;
    private final UserService userService;

    @Autowired
    public HomeController(GoalService goalService, UserService userService) {
        this.goalService = goalService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String home(@AuthenticationPrincipal CurrentUser customUser,Model model) {
        if(customUser!=null){
            customUser.getUser().setGoals(goalService.findAllByUser(customUser.getUser()));
            customUser.getUser().setLvl(userService.getUserLvl(customUser.getUser()));
            model.addAttribute("user",customUser.getUser());
        }
        return "home";
    }
}
