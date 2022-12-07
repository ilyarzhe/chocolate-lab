package com.bnta.chocolate.components;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import com.bnta.chocolate.repositories.EstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    ChocolateRepository chocolateRepository;

    @Autowired
    EstateRepository estateRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Estate estate1 = new Estate("estate1", "Spain");
        Estate estate2 = new Estate("estate2", "Belgium");

        Chocolate chocolate1 = new Chocolate("chocolate1", 70, estate1);
        Chocolate chocolate2 = new Chocolate("chocolate2", 60, estate1);
        Chocolate chocolate3 = new Chocolate("chocolate3", 90, estate2);
        Chocolate chocolate4 = new Chocolate("chocolate4", 100, estate2);

        estateRepository.saveAll(Arrays.asList(estate1, estate2));
        chocolateRepository.saveAll(Arrays.asList(chocolate1, chocolate2, chocolate3, chocolate4));
    }

}
