package com.iniciandospring.projectspringboot.repositories;

import com.iniciandospring.projectspringboot.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem , Long> {
}
