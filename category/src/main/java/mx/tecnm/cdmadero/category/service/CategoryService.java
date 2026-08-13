package mx.tecnm.cdmadero.category.service;

import mx.tecnm.cdmadero.category.entity.Category;
import mx.tecnm.cdmadero.category.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.Iterable;
import java.util.Optional;


@Service
public class CategoryService {
     @Autowired
    CategoryRepository categoryRepository;

     public Iterable<Category> getCategories(){
         return this.categoryRepository.findAll();
     }
     public Optional<Category> getCategoryById(Integer id){
         return this.categoryRepository.findById(id);
     }

     public Category save(Category category){
         if (category.getCategoryName().equals("")){
             return null;
         }

         return this.categoryRepository.save(category);
     }


}
