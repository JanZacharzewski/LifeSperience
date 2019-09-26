package pl.project.life_sperience.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.project.life_sperience.domain.*;
import pl.project.life_sperience.service.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user/goal")
public class GoalController {


    private final GoalService goalService;
    private final CategoryService categoryService;
    private final ExerciseService exerciseService;
    private final LvlService levelService;


    @Autowired
    public GoalController(GoalService goalService, CategoryService categoryService, ExerciseService exerciseService, LvlService levelService) {
        this.goalService = goalService;
        this.categoryService = categoryService;
        this.exerciseService = exerciseService;
        this.levelService = levelService;
    }

    @GetMapping("/add")
    public String addGoal(Model model) {
        model.addAttribute("goal", new Goal());
        return "goalForm";
    }

    @PostMapping("/add")
    public String addGoal(@ModelAttribute @Valid Goal goal, BindingResult result, @AuthenticationPrincipal CurrentUser currentUser) {
        if (result.hasErrors()) {
            return "goalForm";
        }
        User user = currentUser.getUser();
        goal.setUser(user);
        goalService.saveGoal(goal);
        return "redirect:/";
    }

    @GetMapping("/close/{goalId}")
    public String successGoal(@PathVariable Goal goalId, @AuthenticationPrincipal CurrentUser currentUser) {
        User user = currentUser.getUser();
        Lvl lvl = user.getLvl();
        if (goalId != null) {
            lvl.setXP_owned(lvl.getXP_owned() + goalId.getXp_to_get());
            levelService.saveLvl(lvl);
            goalService.close(currentUser.getUser(), goalId);
            while (lvl.getXP_owned() >= lvl.getXP_needed()) {
                lvl.setLvl_value(lvl.getLvl_value() + 1);
                lvl.setXP_owned(lvl.getXP_owned()-lvl.getXP_needed());
                lvl.setXP_needed((long) (lvl.getXP_needed()*1.5));
                lvl = levelService.saveLvl(lvl);
            }
        }

        return "redirect:/";
    }


    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoryService.findAllCategories();
    }

    @ModelAttribute("subcategories")
    public List<Category> subcategories() {
        return categoryService.findAllSubCategories();
    }


}
