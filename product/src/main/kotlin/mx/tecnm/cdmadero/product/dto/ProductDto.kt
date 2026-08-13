package mx.tecnm.cdmadero.product.dto

import java.math.BigDecimal

data class ProductDto(
    val productId : Int,
    val productName : String,
    val quantityPerUnit : String,
    val unitPriceWithTax : BigDecimal,
    val unitsInStock : Int,
    val unitsOnReorder : Int,
    val reorderLevel : Int,
    val category : String,
    val discontinued : Boolean,
    val categoryPicture : String
)
