package com.iniciandospring.projectspringboot.config;

import com.iniciandospring.projectspringboot.entities.*;
import com.iniciandospring.projectspringboot.entities.Order;
import com.iniciandospring.projectspringboot.entities.enums.OrderStatus;
import com.iniciandospring.projectspringboot.repositories.*;
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

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(null,"Maria Snow" , "maria@gmail.com" ,"999999999" , "123455");
        User user2 = new User(null,"Pedro Kalesee" , "pedro@gmail.com" ,"999999889" , "123456");

        Order o1 = new Order(null , Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID,user1);
        Order o2 = new Order(null , Instant.parse("2019-06-20T19:53:08Z"),OrderStatus.DELIVERED,user2);
        Order o3 = new Order(null , Instant.parse("2019-06-20T19:53:09Z"),OrderStatus.WAITING_PAYMENT,user1);

        Category category1 = new Category(null , "Eletronics");
        Category category2 = new Category(null , "Books");
        Category category3 = new Category(null , "Computers");

        Product product1 = new Product(null , "The Lord of Rings" , "LOREM IPSUN" , 90.3, "");
        Product product2 = new Product(null , "Smart TV" , "LOREM IPSUN" , 2190.0, "");
        Product product3 = new Product(null , "PC gamer" , "LOREM IPSUN" , 1250.0, "");

        //Populando category e product
        categoryRepository.saveAll(Arrays.asList(category1,category2,category3));
        productRepository.saveAll(Arrays.asList(product1 , product2 , product3));

        //ASSOSCIAÇÃO DOS PRODUTOS COM AS CATEGORIAS
        product1.getCategories().add(category2);
        product2.getCategories().add(category3);
        product2.getCategories().add(category1);
        product3.getCategories().add(category1);
        product3.getCategories().add(category2);

        productRepository.saveAll(Arrays.asList(product1 , product2 , product3));


        //POPULANDO AS DUAS INFORMAÇÕES NO BANCO DE DADOS
        userRepository.saveAll(Arrays.asList(user1 , user2));
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));

        //CRIANDO OS PEDIDOS
        OrderItem item1 = new OrderItem(o1 , product1 , 2 , product1.getPrice());
        OrderItem item2 = new OrderItem(o1 , product3 , 5 , product3.getPrice());
        OrderItem item3 = new OrderItem(o2 , product2 , 3 , product2.getPrice());
        OrderItem item4 = new OrderItem(o3 , product1 , 2 , product1.getPrice());

        orderItemRepository.saveAll(Arrays.asList(item1 , item2 , item3 , item4));

        Payment pay1 = new Payment(null , Instant.parse("2019-06-20T21:53:07Z") , o1);
        o1.setPayment(pay1);

        orderRepository.save(o1);


    }
}
