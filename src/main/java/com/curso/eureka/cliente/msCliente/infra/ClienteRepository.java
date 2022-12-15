package com.curso.eureka.cliente.msCliente.infra;

import com.curso.eureka.cliente.msCliente.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

    Optional<Cliente> findByCpf(String cpf);
}
