package com.curso.eureka.cliente.msCliente.service;

import com.curso.eureka.cliente.msCliente.domain.Cliente;
import com.curso.eureka.cliente.msCliente.infra.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {
     private final ClienteRepository clienteRepository;

     @Transactional
     public Cliente save(Cliente cliente){
         return clienteRepository.save(cliente);
     }

     public Optional<Cliente> findByCpf(String cpf){
         return clienteRepository.findByCpf(cpf);
     }
}
