package co.istad.restapi.service.impl;

import co.istad.restapi.domain.Coffee;
import co.istad.restapi.dto.CoffeeResponse;
import co.istad.restapi.dto.CreateCoffeeReq;
import co.istad.restapi.dto.UpdateCoffeeReq;
import co.istad.restapi.repository.CoffeeRepository;
import co.istad.restapi.service.CoffeeService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Random;

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
        coffee.setId(new Random().nextInt(999999));
        coffee.setName(coffeeReq.name());
        coffee.setPrice(coffeeReq.price());
        coffee.setDescription(coffeeReq.description());

        boolean isExisting = coffeeRepository.getAllCoffee().stream().anyMatch(coffee1 -> coffee1.getId().equals(coffee.getId()));
        if (isExisting) throw new RuntimeException("Coffee with the id already exist bro!!");
        coffeeRepository.getAllCoffee().add(coffee);

        return CoffeeResponse.builder().name(coffee.getName()).price(coffee.getPrice()).description(coffee.getDescription()).build();
    }

    @Override
    public CoffeeResponse updateCoffeeById(Integer id, UpdateCoffeeReq coffeeReq) {

        return coffeeRepository.getAllCoffee().stream().filter(coffee1 -> coffee1.getId().equals(id)).findFirst().map(oldCoffee -> {
            oldCoffee.setName(coffeeReq.name());
            oldCoffee.setPrice(coffeeReq.price());
            oldCoffee.setDescription(coffeeReq.description());

            return oldCoffee;
        }).map(newCoffee -> CoffeeResponse.builder().name(newCoffee.getName()).price(newCoffee.getPrice()).description(newCoffee.getDescription()).build()
        ).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Coffee with the id: %d does not exit", id)));
    }

    @Override
    public void deleteCoffeeById(Integer id) {
        Coffee coffee = coffeeRepository.getAllCoffee().stream().filter(coffee1 -> coffee1.getId().equals(id)).findFirst().orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Coffee with the id: %d does not exit", id)));

        coffeeRepository.deleteCoffee(coffee);
    }
}