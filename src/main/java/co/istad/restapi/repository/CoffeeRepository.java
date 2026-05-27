package co.istad.restapi.repository;

import co.istad.restapi.domain.Coffee;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import java.util.Arrays;
import java.util.List;

@Repository
public class CoffeeRepository {


    @Bean
    public List<Coffee> getAllCoffee() {
        Coffee coffee = new Coffee(1, "ice latte", "50%");
        Coffee coffee1 = new Coffee(2, "ice choco", "100%");
        Coffee coffee2 = new Coffee(3, "ice caramel", "1000%");

        return Arrays.asList(coffee, coffee1, coffee2);
    }

}
