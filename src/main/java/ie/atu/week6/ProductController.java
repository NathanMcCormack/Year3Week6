package ie.atu.week6;

import org.springframework.http.ResponseEntity;
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
    public List<Product> newProduct(@RequestBody Product product){

        //Send it to do business logic
        list = myService.addProduct(product);
        return list;
    }

    @PutMapping("/{id}")
    public ResponseEntity<List> updateProduct(@PathVariable String id, @RequestBody Product updatedProduct){

        for(Product product : list){
            if(product.getId().equals(id)){
                list.remove(product);
            }
        }
        list.add(updatedProduct);
        return ResponseEntity.ok(list);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List> deleteProduct(@PathVariable String id){

        for (Product product : list){
            if (product.getId().equals(id)){
                list.remove(product);
            }
        }
        return ResponseEntity.ok(list);
    }
}
