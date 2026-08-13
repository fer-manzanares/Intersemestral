package mx.tecnm.cdmadero.product.controller

import mx.tecnm.cdmadero.product.service.ProductService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/products")
class ProductRestController(
    val productService: ProductService
) {
    @GetMapping
    fun getProducts() = this.productService.findProducts();

    @GetMapping("/references/{id}")
    fun getNumberProductsThatReference(@PathVariable id : Int) : String {
        val n = productService.getNumberOfReferencesByProduct(id);
        println("Numero de instancias: $n");
        return n.toString();
    }

}