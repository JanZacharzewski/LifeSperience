package pl.project.life_sperience.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.project.life_sperience.service.CategoryService;


import java.util.List;

@RequestMapping("/category")
@Controller
public class CategoryController {

    private final
    CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/allCategories")
    public String AllCategories(Model model) {
        List categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "categories";
    }


    @GetMapping("/subCategories/{parent_id}")
    public String subCategoriesByParentId(@PathVariable int parent_id, Model model){
        List subCategories = categoryService.getAllSubCategoriesByParent(parent_id);
        model.addAttribute("subCategories", subCategories);
        return "subCategories";
    }
}
