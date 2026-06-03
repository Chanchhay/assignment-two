package co.istad.restapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record UpdateCoffeeReq(@NotBlank(message = "name cannot be blank")
                              @Size(min = 3, max = 255, message = "size cannot be less than 3 or more than 255")
                              String name,
                              @NotNull
                              @Positive(message = "price must be positive")
                              Double price,
                              @NotBlank(message = "name cannot be blank")
                              String description) {
}
