package mx.tecnm.cdmadero.product.repository

import mx.tecnm.cdmadero.product.entity.Product
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : CrudRepository<Product, Int>{
    fun countByCategory(id : Int) : Int
}