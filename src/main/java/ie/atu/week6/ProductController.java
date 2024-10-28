package ie.atu.week6;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService myService;

    public ProductController(ProductService myService) {
        this.myService = myService;
    }

    private List<Product> list = new ArrayList<>();
    //Creating a class which is interested in requests and responses. Seperation of Concern

    @GetMapping
    public List<Product> getAllProducts(){
        return list;
    }

    @PostMapping
    public List<Product> newProduct(@RequestBody @Valid Product product){

        //Send it to do business logic
        list = myService.addProduct(product);
        return list;
    }

    @Autowired
    private ProductService productService;

    @PutMapping("/{id}")
    public ResponseEntity<List<Product>> updateProduct(@PathVariable @Valid int id, @RequestBody @Valid Product updatedProduct) {
        List<Product> updatedList = productService.updateProduct(id, updatedProduct);
        return ResponseEntity.ok(updatedList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Product>> deleteProduct(@PathVariable int id) {
        List<Product> updatedList = productService.deleteProduct(id);
        return ResponseEntity.ok(updatedList);
    }

}
