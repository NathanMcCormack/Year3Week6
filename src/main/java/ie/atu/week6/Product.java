package ie.atu.week6;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @NotNull
    private int id;

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotNull
    @Min(value = 1, message = "Price must be greater than 0")
    private double price;

}
