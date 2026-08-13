package mx.tecnm.cdmadero.category.repository;

import mx.tecnm.cdmadero.category.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {
    Category findByCategoryName(String name);
}
