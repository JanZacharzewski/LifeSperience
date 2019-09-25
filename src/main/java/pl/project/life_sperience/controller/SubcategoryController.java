package pl.project.life_sperience.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

@Controller
@RequestMapping("admin/subCategory")
public class SubcategoryController {

    private final
    CategoryService categoryService;

    @Autowired
    public SubcategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/add")
    public String addSubCategory(Model model) {
        model.addAttribute("subcategory", new Category());
        return "subCategoryForm";
    }

    @PostMapping("/add")
    public String addSubCategory(@ModelAttribute @Valid Category category, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "categoryForm";
        }
        if (!categoryService.isCategoryNameUnique(category.getName())) {
            FieldError ssoError = new FieldError("category", "categoryId", "Podana podkategoria już istnieje");
            result.addError(ssoError);
            model.addAttribute("error", ssoError);
            return "subCategoryForm";
        }

        categoryService.saveCategory(category);
        return "redirect:all";
    }


    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoryService.findAllCategories();
    }

    @ModelAttribute("subcategories")
    public List<Category> subcategories() {
        return categoryService.findAllSubCategories();
    }

    @GetMapping("/all")
    public String allSubcategories(Model model) {
        List<Category> subCategories = categoryService.findAllSubCategories();
        model.addAttribute("subCategories", subCategories);
        return "allSubcategories";
    }
}
