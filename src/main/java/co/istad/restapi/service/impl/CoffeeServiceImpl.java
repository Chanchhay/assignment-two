package co.istad.restapi.service.impl;

import co.istad.restapi.domain.Coffee;
import co.istad.restapi.repository.CoffeeRepository;
import co.istad.restapi.service.CoffeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeeServiceImpl implements CoffeeService {
    private final CoffeeRepository coffeeRepository;

    public CoffeeServiceImpl(CoffeeRepository coffeeRepository){
        this.coffeeRepository = coffeeRepository;
    }

    @Override
    public List<Coffee> getAllCoffee() {
        return coffeeRepository.getAllCoffee();
    }
}
