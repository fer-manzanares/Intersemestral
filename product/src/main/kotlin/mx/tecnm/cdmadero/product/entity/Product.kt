package mx.tecnm.cdmadero.product.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.math.BigDecimal

@Entity
data class Product(
    @Id
    var productId : Int? = null,
    val productName : String,
    val quantityPerUnit : String,
    val unitPrice : BigDecimal,
    val unitsInStock : Int,
    val unitsOnOrder : Int,
    val reorderLevel : Int,
    val category : Int,
    val discontinued : Boolean
)
