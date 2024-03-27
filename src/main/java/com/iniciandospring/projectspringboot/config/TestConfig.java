package com.iniciandospring.projectspringboot.config;

import com.iniciandospring.projectspringboot.entities.Order;
import com.iniciandospring.projectspringboot.entities.User;
import com.iniciandospring.projectspringboot.repositories.OrderRepository;
import com.iniciandospring.projectspringboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
//O nome que vai no Profile, é o msm que esta no application.propreties
@Profile("test")
//ESSA CLASSE VAI SERVIR PARA POPULAR MANUALMENTE O BANCO DE DADOS
//IMPLEMENTANDO O COMANDlINERUNNER PARA ESSA CLASSE SER EXECUTADA QUANDO RODAR O PROGRAMA
public class TestConfig implements CommandLineRunner {
    //INJEÇÃO DE DEPENDENCIA FRACA OU SEM ACOPLAMENTO
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(null,"Maria Snow" , "maria@gmail.com" ,"999999999" , "123455");
        User user2 = new User(null,"Pedro Kalesee" , "pedro@gmail.com" ,"999999889" , "123456");

        Order o1 = new Order(null , Instant.parse("2019-06-20T19:53:07Z"),user1);
        Order o2 = new Order(null , Instant.parse("2019-06-20T19:53:08Z"),user2);
        Order o3 = new Order(null , Instant.parse("2019-06-20T19:53:09Z"),user1);

        //POPULANDO AS DUAS INFORMAÇÕES NO BANCO DE DADOS
        userRepository.saveAll(Arrays.asList(user1 , user2));
        orderRepository.saveAll(Arrays.asList(o1 , o2,o3));

    }
}
