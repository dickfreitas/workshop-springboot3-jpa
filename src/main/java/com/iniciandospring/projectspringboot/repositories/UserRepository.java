package com.iniciandospring.projectspringboot.repositories;

import com.iniciandospring.projectspringboot.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

//JPA REPOSITORY É UM TIPO GENERICS ONDE PEDE 2 CHAVES A CLASSE QUE IRA USAR E O TIPO DO ID, NESSE CASO O LONG
public interface UserRepository extends JpaRepository<User , Long> {

}
