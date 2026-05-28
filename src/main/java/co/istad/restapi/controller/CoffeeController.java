package co.istad.restapi.controller;

import co.istad.restapi.domain.Coffee;
import co.istad.restapi.dto.CoffeeResponse;
import co.istad.restapi.service.CoffeeService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/coffees/search")
    public CoffeeResponse getCoffeeByName(@RequestParam(required = false) String name){
        return coffeeService.getCoffeeByName(name);
    }

    @GetMapping("/coffees/{id}")
    public CoffeeResponse getCoffeeById(@PathVariable(required = false) Integer id){
        return coffeeService.getCoffeeById(id);
    }

}
