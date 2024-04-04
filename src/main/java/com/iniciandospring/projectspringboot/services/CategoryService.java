package com.iniciandospring.projectspringboot.services;

import com.iniciandospring.projectspringboot.entities.Category;
import com.iniciandospring.projectspringboot.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private CategoryRepository repository;

    public CategoryService(CategoryRepository repository){
        this.repository = repository;
    }

    public List<Category> findAll(){
        return repository.findAll();
    }

    public Category insertCategory(Category obj){return repository.save(obj);}

    public Category fIndById(Long id){
        Optional<Category> obj = repository.findById(id);
        return obj.get();
    }
}
