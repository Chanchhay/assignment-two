package co.istad.restapi.service.impl;

import co.istad.restapi.domain.Coffee;
import co.istad.restapi.dto.CoffeeResponse;
import co.istad.restapi.dto.CreateCoffeeReq;
import co.istad.restapi.repository.CoffeeRepository;
import co.istad.restapi.service.CoffeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.random.RandomGenerator;

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

    public List<CoffeeResponse> getCoffeeByNameOrPrice(String name, Double price) {
        return coffeeRepository.getAllCoffee().stream().filter(c -> c.getName().equalsIgnoreCase(name) || c.getPrice().equals(price))
                .map(c -> new CoffeeResponse(c.getName(), c.getPrice(), c.getDescription()))
                .toList();
    }

    @Override
    public CoffeeResponse addCoffee(CreateCoffeeReq coffeeReq) {
        Coffee coffee = new Coffee();
        coffee.setId(new Random().nextInt(6));
        coffee.setName(coffeeReq.name());
        coffee.setPrice(coffeeReq.price());
        coffee.setDescription(coffeeReq.description());
        coffeeRepository.getAllCoffee().add(coffee);

        return CoffeeResponse.builder().name(coffee.getName()).price(coffee.getPrice()).description(coffee.getDescription()).build();
    }
}