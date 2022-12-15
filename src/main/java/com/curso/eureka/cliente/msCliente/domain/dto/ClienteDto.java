package com.curso.eureka.cliente.msCliente.domain.dto;

import com.curso.eureka.cliente.msCliente.domain.Cliente;
import lombok.Data;

@Data
public class ClienteDto {

    private String nome;
    private String cpf;
    private Integer idade;

    public Cliente toModel(){
        return new Cliente(nome,cpf,idade);
    }

}
