package co.istad.restapi.service.impl;

import co.istad.restapi.domain.Coffee;
import co.istad.restapi.dto.CoffeeResponse;
import co.istad.restapi.repository.CoffeeRepository;
import co.istad.restapi.service.CoffeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeeServiceImpl implements CoffeeService {
    private final CoffeeRepository coffeeRepository;

    public CoffeeServiceImpl(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    @Override
    public List<Coffee> getAllCoffee() {
        return coffeeRepository.getAllCoffee();
    }

    public CoffeeResponse getCoffeeById(Integer id) {
        Coffee coffee = coffeeRepository.getAllCoffee().stream().filter(c -> c.getId().equals(id)).findFirst().orElseThrow(() -> new RuntimeException("Failed to find coffee " + id));
        return CoffeeResponse.builder().name(coffee.getName()).price(coffee.getPrice()).description(coffee.getDescription()).build();
    }

    public CoffeeResponse getCoffeeByName(String name) {
        Coffee coffee = coffeeRepository.getAllCoffee().stream().filter(c -> c.getName().equals(name)).findFirst().orElseThrow(() -> new RuntimeException("Failed to find coffee " + name));
        return CoffeeResponse.builder().name(coffee.getName()).price(coffee.getPrice()).description(coffee.getDescription()).build();
    }

}
