package co.istad.restapi.controller;

import co.istad.restapi.domain.Coffee;
import co.istad.restapi.dto.CoffeeResponse;
import co.istad.restapi.dto.CreateCoffeeReq;
import co.istad.restapi.dto.UpdateCoffeeReq;
import co.istad.restapi.service.CoffeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
    public List<CoffeeResponse> getCoffeeByNameOrPrice(@RequestParam(required = false, defaultValue = "") String name, @RequestParam(required = false, defaultValue = "") Double price) {
        return coffeeService.getCoffeeByNameOrPrice(name, price);
    }

    @GetMapping("/coffees/{id}")
    public CoffeeResponse getCoffeeById(@PathVariable(required = false) Integer id) {
        return coffeeService.getCoffeeById(id);
    }

    @PostMapping("/coffees")
    @ResponseStatus(HttpStatus.CREATED)
    public CoffeeResponse addCoffee(@Valid @RequestBody CreateCoffeeReq coffeeReq) {
        return coffeeService.addCoffee(coffeeReq);
    }


    @PutMapping("/coffees/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CoffeeResponse updateCoffeeById(@PathVariable Integer id, @Valid @RequestBody UpdateCoffeeReq updateCoffeeReq) {
        return coffeeService.updateCoffeeById(id, updateCoffeeReq);
    }

    @DeleteMapping("/coffees/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCoffeeById(@PathVariable Integer id) {
        coffeeService.deleteCoffeeById(id);
    }
}
