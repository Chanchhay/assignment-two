package co.istad.restapi.controller;


import co.istad.restapi.domain.Coffee;
import co.istad.restapi.service.CoffeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CoffeeController {
    private final CoffeeService coffeeService;

    public CoffeeController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }


    @GetMapping("/coffees")
    public List<Coffee> getAllCoffee() {
        return coffeeService.getAllCoffee();
    }
}
