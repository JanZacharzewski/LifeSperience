package pl.project.life_sperience.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.project.life_sperience.domain.Category;
import pl.project.life_sperience.domain.Difficulty;
import pl.project.life_sperience.domain.Exercise;
import pl.project.life_sperience.service.CategoryService;
import pl.project.life_sperience.service.DifficultyService;
import pl.project.life_sperience.service.ExerciseService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/exercise")
public class ExerciseController {

    private final
    ExerciseService exerciseService;
    private final DifficultyService difficultyService;

    private final CategoryService categoryService;

    @Autowired
    public ExerciseController(ExerciseService exerciseService, DifficultyService difficultyService, CategoryService categoryService) {
        this.exerciseService = exerciseService;
        this.difficultyService = difficultyService;
        this.categoryService = categoryService;
    }


    @GetMapping("/add")
    public String addExercise(Model model) {
        model.addAttribute("exercise", new Exercise());
        return "exerciseForm";
    }

    @PostMapping("/add")
    public String addExercise(@ModelAttribute @Valid Exercise exercise, BindingResult result) {
        if (result.hasErrors()) {
            return "exerciseForm";
        }
        exerciseService.saveExercise(exercise);
        return "redirect:/";
    }

    @GetMapping("/all")
    public String allExercises(Model model){
        List<Exercise> exercises = exerciseService.findAllExercises();
        model.addAttribute("exercises", exercises);
        return "allExercises";
    }


    @ModelAttribute("difficulties")
    public List<Difficulty> difficulties() {
        return difficultyService.findAllDifficulties();
    }

    @ModelAttribute("subcategories")
    public List<Category> subcategories() {
        return categoryService.findAllSubCategories();
    }


}
