package com.iniciandospring.projectspringboot.repositories;

import com.iniciandospring.projectspringboot.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category , Long> {
}
