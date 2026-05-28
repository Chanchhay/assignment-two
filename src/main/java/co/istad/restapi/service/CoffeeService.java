package co.istad.restapi.service;

import co.istad.restapi.domain.Coffee;
import co.istad.restapi.dto.CoffeeResponse;

import java.util.List;

public interface CoffeeService {
    List<Coffee> getAllCoffee();
    CoffeeResponse getCoffeeById(Integer id);
    CoffeeResponse getCoffeeByName(String name);
}
