package co.istad.restapi.service;

import co.istad.restapi.domain.Coffee;
import co.istad.restapi.dto.CoffeeResponse;
import co.istad.restapi.dto.CreateCoffeeReq;

import java.util.List;

public interface CoffeeService {
    List<Coffee> getAllCoffee();
    CoffeeResponse getCoffeeById(Integer id);
    List<CoffeeResponse> getCoffeeByNameOrPrice(String name, Double price);
    CoffeeResponse addCoffee(CreateCoffeeReq coffeeReq);
}
