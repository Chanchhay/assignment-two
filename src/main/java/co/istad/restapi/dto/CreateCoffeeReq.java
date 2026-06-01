package co.istad.restapi.dto;

import jakarta.validation.constraints.*;

public record CreateCoffeeReq(
        @NotBlank(message = "name cannot be blank")
        @Size(min = 3, max = 255, message = "size cannot be less than 3 or more than 255")
        String name,
        @NotNull
        @Positive(message = "price must be positive")
        Double price,
        @NotBlank(message = "name cannot be blank")
        String description
) {
}
