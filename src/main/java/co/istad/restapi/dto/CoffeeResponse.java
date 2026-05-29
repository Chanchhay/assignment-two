package co.istad.restapi.dto;

import lombok.Builder;

@Builder
public record CoffeeResponse(
        String name, Double price, String description
) {
}