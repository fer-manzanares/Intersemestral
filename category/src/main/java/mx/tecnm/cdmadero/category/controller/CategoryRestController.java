package mx.tecnm.cdmadero.category.controller;

import mx.tecnm.cdmadero.category.entity.Category;
import mx.tecnm.cdmadero.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api/v1/categories")
public class CategoryRestController {
    @Autowired
    CategoryService categoryService;

    @GetMapping
    public ResponseEntity<Iterable<Category>> getAllCategories(){
        return ResponseEntity.ok(categoryService.getCategories());
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<Category> getCategory(@PathVariable Integer categoryId){
        Optional<Category> optCategory = this.categoryService.getCategoryById(categoryId);
        if (optCategory.isPresent()){
            return ResponseEntity.ok(optCategory.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Category> postCategory(@RequestBody Category category){
        if (category.getCategoryId() == null) {
            Category newCategory = categoryService.save(category);
            if (newCategory.getCategoryId() != null)
                return ResponseEntity.ok(newCategory);
            else
                return ResponseEntity.internalServerError().build();
        }
        else {
            try {
                Category updatedCategory = categoryService.save(category);
                return ResponseEntity.ok(updatedCategory);
            } catch (Exception e) {
                return ResponseEntity.internalServerError().build();
            }

        }
    }


}
