package co.istad.restapi.dto;

public record CreateCoffeeReq(
        String name,
        Double price,
        String description
) {
}
