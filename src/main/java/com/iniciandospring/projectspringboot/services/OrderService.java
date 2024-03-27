package com.iniciandospring.projectspringboot.services;

import com.iniciandospring.projectspringboot.entities.Order;
import com.iniciandospring.projectspringboot.repositories.OrderRepository;
import com.iniciandospring.projectspringboot.repositories.UserRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }
    public List<Order> findAll(){
        return  repository.findAll();
    }

    public Order findById(Long id){
        Optional<Order> obj = repository.findById(id);
        return obj.get();
    }

}
