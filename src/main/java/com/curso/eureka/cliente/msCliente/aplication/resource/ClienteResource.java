package com.curso.eureka.cliente.msCliente.aplication.resource;

import com.curso.eureka.cliente.msCliente.domain.dto.ClienteDto;
import com.curso.eureka.cliente.msCliente.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RequiredArgsConstructor
@RestController
@RequestMapping("/clientes")
@Slf4j
public class ClienteResource {

    @Autowired
    public ClienteService clienteService;

    @GetMapping(params = "cpf")
    public ResponseEntity getCliente(@RequestParam("cpf") String cpf){
        ClienteDto dto = new ClienteDto();
        var cliente = clienteService.findByCpf(cpf);
        if (cliente.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(cliente);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ClienteDto clientedto){
        var cliente = clientedto.toModel();
        clienteService.save(cliente);
        URI headerLocation = ServletUriComponentsBuilder.fromCurrentRequest().query("cpf={cpf}").buildAndExpand(cliente.getCpf()).toUri();
        return ResponseEntity.created(headerLocation).build();
    }
}
