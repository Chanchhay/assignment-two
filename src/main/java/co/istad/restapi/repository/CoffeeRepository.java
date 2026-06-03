package co.istad.restapi.repository;

import co.istad.restapi.domain.Coffee;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CoffeeRepository {
    List<Coffee> coffeeList = new ArrayList<>();

    @PostConstruct
    public void initCoffee(){
        Coffee coffee = new Coffee(1, "ice latte", 10.0, "50%");
        Coffee coffee1 = new Coffee(2, "ice choco", 11.2, "100%");
        Coffee coffee2 = new Coffee(3, "ice caramel", 2.0, "1000%");

        coffeeList.add(coffee);
        coffeeList.add(coffee1);
        coffeeList.add(coffee2);
    }


    @Bean
    public List<Coffee> getAllCoffee() {
        return coffeeList;
    }

    public void deleteCoffee(Coffee coffee){
        coffeeList.remove(coffee);
    }

}