package com.iniciandospring.projectspringboot.services;


import com.iniciandospring.projectspringboot.entities.User;
import com.iniciandospring.projectspringboot.repositories.UserRepository;
import com.iniciandospring.projectspringboot.services.exceptions.DatabaseExceptions;
import com.iniciandospring.projectspringboot.services.exceptions.EntityNotFoundExceptions;
import com.iniciandospring.projectspringboot.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
//       //O orElseThrow ele faz o get no objeto se caso n tenha ele ja lança a excessao
        return  obj.orElseThrow(()->new ResourceNotFoundException(id));

    }

    public User insertUser(User obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        try{
            repository.deleteById(id);

        }catch (EmptyResultDataAccessException e ){
            throw new ResourceNotFoundException(id);
        }catch (DataIntegrityViolationException e ){
        // Aqui é para fazer uma excessao caso desejem apagar um usuario que tenha um pedido vinculado
            throw new DatabaseExceptions(e.getMessage());
        }
    }
    public User updateUser(Long id , User obj){
        /*
        o getRefetenceById é diferente do findById
        ele prepara o id monitorado, para que dps va para o banco de dados
        diferente do find
         */
        try{
            User entity = repository.getReferenceById(id);

            updateData(entity , obj);
            return  repository.save(entity);
        }catch (EntityNotFoundException e){
            throw new EntityNotFoundExceptions(e.getMessage());

        }

    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }


}
