package co.istad.restapi.service;

import co.istad.restapi.domain.Coffee;
import co.istad.restapi.dto.CoffeeResponse;
import co.istad.restapi.dto.CreateCoffeeReq;
import co.istad.restapi.dto.UpdateCoffeeReq;

import java.util.List;

public interface CoffeeService {
    List<Coffee> getAllCoffee();
    CoffeeResponse getCoffeeById(Integer id);
    List<CoffeeResponse> getCoffeeByNameOrPrice(String name, Double price);
    CoffeeResponse addCoffee(CreateCoffeeReq coffeeReq);
    CoffeeResponse updateCoffeeById(Integer id, UpdateCoffeeReq coffeeReq);
    void deleteCoffeeById(Integer id);
}
