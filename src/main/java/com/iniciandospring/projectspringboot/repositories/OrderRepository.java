package com.iniciandospring.projectspringboot.repositories;

import com.iniciandospring.projectspringboot.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
