package mx.tecnm.cdmadero.product.service

import mx.tecnm.cdmadero.product.dto.ProductDto
import mx.tecnm.cdmadero.product.repository.ProductRepository
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class ProductService(
    val productRepository: ProductRepository,
    val categoryService: CategoryService
) {
    fun findProducts() : ArrayList<ProductDto>{
        val products = productRepository.findAll();
        val productsDto : ArrayList<ProductDto> = ArrayList<ProductDto>();
        for (product in products){
            val category = categoryService.getCategory(product.category)

            val productDto = ProductDto(
                product.productId!!,
                product.productName,
                product.quantityPerUnit,
                product.unitPrice.multiply(BigDecimal.ONE.add(category?.tax!!)).setScale(2),
                product.unitsInStock,
                product.unitsOnOrder,
                product.reorderLevel,
                category?.categoryName!!,
                product.discontinued,
                category?.picture!!
            );
            productsDto.add(productDto);
        }
        return productsDto;
    }

    fun getNumberOfReferencesByProduct(categoryId : Int) = this.productRepository.countByCategory(categoryId)
}