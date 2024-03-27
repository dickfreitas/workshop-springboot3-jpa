package com.iniciandospring.projectspringboot.repositories;

import com.iniciandospring.projectspringboot.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//JPA REPOSITORY É UM TIPO GENERICS ONDE PEDE 2 CHAVES A CLASSE QUE IRA USAR E O TIPO DO ID, NESSE CASO O LONG
/*NESSA CLASSE FICA A CRITERIO DA PESSOA COLOCAR O @REPOSITORY(QUE TEM A MESMA IDEIA DO @SERVICE, NA CAMADA DE SERVIÇO)
POIS JPAREPOSITORY JA FAZ ESSE TRABALHO AUTOMATICAMENTE POR BAIXO DOS PANOS,
*/
@Repository
public interface UserRepository extends JpaRepository<User , Long> {

}
