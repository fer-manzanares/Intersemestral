package mx.tecnm.cdmadero.product.controller

import mx.tecnm.cdmadero.product.service.ProductService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/products")
class ProductController(
    val productService: ProductService
) {
    @GetMapping
    fun getProducts(model: Model) : String{
        model.addAttribute("products", this.productService.findProducts());
        return "products"
    }

}