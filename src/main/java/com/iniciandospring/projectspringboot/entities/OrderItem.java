package com.iniciandospring.projectspringboot.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iniciandospring.projectspringboot.entities.pk.OrderItemPk;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {
    //O annotation EmbeeddedId é o responsavel por criar o id composto
    @EmbeddedId
    private OrderItemPk id = new OrderItemPk();
    private Integer quantity;
    private Double price;

    public OrderItem(){}

    public OrderItem(Order order , Product product , Integer quantity, Double price) {
        /*
        Mesmo não tendo o ORDER E O PRODUCT no metodo da classe, por conta da classe auxiliar
        podemos usar aqui, e vincular a essa classe qe sera responsavel pela ORDEM DO PEDIDO
        e assosciar ela ao id do produto e do pedido real
         */
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    /*
    O get e set PRODUCT E ORDER sera o responsavel por cuidar do que vem para essa classe
    sem ser necessario instacialos aqui, e vincular com a classe auxiliar
     */

    /*
    O JsonIgnore vem pra ca, pq aqui onde ocorre o loop, chamando os pedidos e as ordens
    infinitamente
     */
    @JsonIgnore
    public Order getOrder(){
        return  id.getOrder();
    }

    public void setOrder(Order order){
        id.setOrder(order);
    }

    public Product getProduct(){
        return  id.getProduct();
    }

    public void setOrder(Product product){
        id.setProduct(product);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(id, orderItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
