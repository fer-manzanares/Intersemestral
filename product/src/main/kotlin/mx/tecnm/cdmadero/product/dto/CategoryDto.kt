package mx.tecnm.cdmadero.product.dto

import java.math.BigDecimal

data class CategoryDto(
    val categoryId : Int,
    val categoryName : String,
    val description : String,
    val tax : BigDecimal,
    val picture : String
)
