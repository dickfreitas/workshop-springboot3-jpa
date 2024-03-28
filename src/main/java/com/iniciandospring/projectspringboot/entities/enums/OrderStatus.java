package com.iniciandospring.projectspringboot.entities.enums;

import org.hibernate.boot.jaxb.hbm.spi.PluralAttributeInfoIdBagAdapter;

public enum OrderStatus {
    /*
    No banco de dados os enums sao salvos por numeros, começando do zero
    para faciliar uma futura manutenção vamos dizer os valores, e fazer algumas operações

     */
    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private int code;

    //Criamos um construtor para pegar o valor
    private OrderStatus(int code) {
        this.code = code;
    }

    //O get para pegar o valor dentro da classe
    public int getCode(){
        return code;
    }

    /*
        Cria um metodo static, para que nao precise instanciar para chamar o metodo
     */
    public static OrderStatus valueOf(int code){
        /*
        Cria um for para verificar se o valor mandado pelo usuario
        é igual a algum valor possivel dos que tem dentro da classe
         */
        for (OrderStatus value : OrderStatus.values()){
            if (value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus code");
    }

}
