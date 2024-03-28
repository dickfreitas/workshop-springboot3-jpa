package com.iniciandospring.projectspringboot.services;


import com.iniciandospring.projectspringboot.entities.User;
import com.iniciandospring.projectspringboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/*O @SERVICE REGISTRA A CLASSE COMO UM COMPONENTE SPRING
PODENDO ASSIM SER INJETADO AUTOMATICAMENTE EM OUTRA CLASSE COM O
AUTOWIRED
EXISTE OUTROS 2 @COMPONENT E @REPOSITORY, QUE TEM O MSM CONTEXTO
SO SAO MAIS SEMANTICOS
*/
@Service
public class UserService {
    //INJEÇÃO DE DEPENDENCIAS
    @Autowired
    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> findAll(){
        return  repository.findAll();
    }

    public User findById(Long id){
        Optional<User> obj = repository.findById(id);
        return  obj.get();

    }

    public User insertUser(User obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

}
