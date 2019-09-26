package pl.project.life_sperience.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.project.life_sperience.domain.*;
import pl.project.life_sperience.service.CategoryService;
import pl.project.life_sperience.service.CurrentUser;
import pl.project.life_sperience.service.ExerciseService;
import pl.project.life_sperience.service.GoalService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user/goal")
public class GoalController {


    private final GoalService goalService;
    private final CategoryService categoryService;
    private final ExerciseService exerciseService;


    @Autowired
    public GoalController(GoalService goalService, CategoryService categoryService, ExerciseService exerciseService) {
        this.goalService = goalService;
        this.categoryService = categoryService;
        this.exerciseService = exerciseService;
    }

    @GetMapping("/add")
    public String addGoal(Model model) {
        model.addAttribute("goal", new Goal());
        return "goalForm";
    }

    @PostMapping("/add")
    public String addGoal(@ModelAttribute @Valid Goal goal, BindingResult result) {
        if(result.hasErrors()){
            return "goalForm";
        }
        goalService.saveGoal(goal);
        return "redirect:/";
    }

    @GetMapping("/delete/{goalId}")
    public String successGoal(@PathVariable Integer goalId, @AuthenticationPrincipal CurrentUser currentUser) {
        User user = currentUser.getUser();
        Lvl lvl = user.getLvl();
        Goal goal = goalService.getById(goalId);
        lvl.setXP_owned(goal.getXp_to_get());
        goalService.deleteGoalById(goalId);
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
