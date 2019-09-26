package pl.project.life_sperience.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.project.life_sperience.domain.Category;
import pl.project.life_sperience.service.CategoryService;

import javax.validation.Valid;
import java.util.List;


@RequestMapping("/admin/category")
@Controller
public class CategoryController {

    private final
    CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/add")
    public String saveCategory(Model model){
        model.addAttribute("category", new Category());
        return "categoryForm";
    }
    @PostMapping("/add")
    public String saveCategory(@ModelAttribute @Valid Category category, BindingResult result, Model model){
        if(result.hasErrors()) {
            return "categoryForm";
        }
        if (!categoryService.isCategoryNameUnique(category.getName())) {
            FieldError ssoError = new FieldError("category", "categoryId", "Podana kategoria już istnieje");
            result.addError(ssoError);
            model.addAttribute("error", ssoError);
            return "categoryForm";
        }
        category.setParent_id(0);
        categoryService.saveCategory(category);
        return "redirect:allCategories";
    }


    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoryService.findAllCategories();
    }

    @GetMapping("/allCategories")
    public String allCategories (Model model){
        List<Category> categories = categoryService.findAllCategories();
        model.addAttribute("categories", categories);
        return "allCategories";
    }

    @ModelAttribute("subcategories")
    public List<Category> subcategories(){return categoryService.findAllSubCategories();}

    @GetMapping("/allSubcategories")
    public String allSubcategories(Model model){
        List<Category> subCategories = categoryService.findAllSubCategories();
        model.addAttribute("subCategories", subCategories);
        return "allSubcategories";
    }








}
