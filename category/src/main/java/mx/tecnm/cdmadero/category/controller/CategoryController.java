package mx.tecnm.cdmadero.category.controller;

import mx.tecnm.cdmadero.category.service.CategoryService;
import mx.tecnm.cdmadero.category.entity.Category;
import mx.tecnm.cdmadero.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping
    public String getAllCategories(Model model){
        Iterable<Category> categories = categoryService.getCategories();
        model.addAttribute("categories", categories);
        model.addAttribute("btnNew", true);
        return "categories";
    }

    @GetMapping("/edit/{categoryId}")
    public String getCategoryById(Model model, @PathVariable Integer categoryId){
        Optional<Category> category = this.categoryService.getCategoryById(categoryId);
        if (category.isPresent()) {
            model.addAttribute("category", category.get());
            return "category";
        }else {
            model.addAttribute("btnNew", true);
            return "categories";
        }
    }

    @GetMapping("/new")
    public String newCategory(Model model){
        Category category = new Category();
        model.addAttribute("category", category);
        return "category";
    }

    @PostMapping
    public String saveCategory(Model model, @ModelAttribute Category categoryAtt){
        this.categoryService.save(categoryAtt);
        return getAllCategories(model);
    }
}
