package pl.project.life_sperience.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
