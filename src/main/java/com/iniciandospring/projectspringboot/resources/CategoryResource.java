package com.iniciandospring.projectspringboot.resources;


import com.iniciandospring.projectspringboot.entities.Category;
import com.iniciandospring.projectspringboot.services.CategoryService;
import com.iniciandospring.projectspringboot.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
    private CategoryService service;

    public CategoryResource(CategoryService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        List<Category> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){
        Category obj = service.fIndById(id);

        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Category> insertCategory(@RequestBody Category obj){
        obj = service.insertCategory(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).body(obj);

    }

}
