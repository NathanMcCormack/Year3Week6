package ie.atu.week6;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> myList = new ArrayList<>();

    public List<Product> getAllProducts(){
        return myList;
    }

    public List<Product> addProduct( Product product){

        //Do business stuff like retrieving details from database, or generating files pdfs
        myList.add(product);
        return myList;
    }

    public List<Product> updateProduct(int id, Product uProduct) {
        for (Product product : myList) { //finds product with matching ID
            if (product.getId() == id) {
                myList.remove(product); //removes old product
            }
        }


        myList.add(uProduct); //Adds updated Product
        return myList;
    }

    public List<Product> deleteProduct(int id) {
        for(Product p : myList){
            if(p.getId() == id){
                myList.remove(p);
            }
        }
        return myList;

    }

}
