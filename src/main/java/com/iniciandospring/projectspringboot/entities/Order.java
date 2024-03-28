package com.iniciandospring.projectspringboot.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.iniciandospring.projectspringboot.entities.enums.OrderStatus;
import jakarta.persistence.*;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;


@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //Classe Instant surgiu a partir do java 8, MELHOR QUE A DATE
    //FORMATA O PADRAO QUE IRA PARA O BANCO DE DADOS O MOMENTO DO PEDIDO
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'",timezone = "GMT")
    private Instant moment;
    private Integer orderStatus;

    public Order(Long id, Instant moment, OrderStatus orderStatus, User client) {
        this.id = id;
        this.moment = moment;
        setOrderStatus(orderStatus);
        this.client = client;
    }

    //Informando o JPA que essa vai ser mts para um
    //E colocando a qual coluna pertence o usuario, que no caso é o client_id
    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    public Order() {}

    public Order(Long id, Instant moment, User client) {
        this.id = id;
        this.moment = moment;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }
    public OrderStatus getOrderStatus() {
    /*
    Pega o valor Inteiro e manda para o enum para que seja implementado
    tudo aquilo que fizemos no enum e retornar o OrderStatus referente ao numero
     */
        return OrderStatus.valueOf(orderStatus);
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        if (orderStatus !=null){
            this.orderStatus = orderStatus.getCode();
        }

    }
    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
