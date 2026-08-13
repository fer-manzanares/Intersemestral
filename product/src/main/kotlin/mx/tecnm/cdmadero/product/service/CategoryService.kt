package mx.tecnm.cdmadero.product.service

import mx.tecnm.cdmadero.product.dto.CategoryDto
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class CategoryService(
    val restTemplate: RestTemplate
) {
    fun getCategory(categoryId: Int): CategoryDto? {
        return restTemplate.getForObject<CategoryDto>(
            "http://localhost:8082/api/v1/categories/" + categoryId,
            CategoryDto::class.java
        )
    }
}