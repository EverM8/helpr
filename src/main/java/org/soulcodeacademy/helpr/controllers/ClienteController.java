package org.soulcodeacademy.helpr.controllers;

import org.soulcodeacademy.helpr.domanin.Cliente;
import org.soulcodeacademy.helpr.domanin.Funcionario;
import org.soulcodeacademy.helpr.domanin.dto.ClienteDTO;
import org.soulcodeacademy.helpr.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Endpoint é o endereço que será acessado no backend
    @GetMapping("/Clientes")
    public List<Cliente> listar(){
        // Requisição -> Controller -> Service -> Repository -> SELECT*FROM cargo;
        return this.clienteService.listar();
    }

    //LISTAR BY ID
    @GetMapping("/Clientes/{idCliente}")
    public Cliente getCliente(@PathVariable Integer idCliente){
        System.out.println(idCliente);
        return this.clienteService.getCliente(idCliente);
    }

    //SALVAR
    @PostMapping("/Clientes/{idCliente}")
    public Cliente salvar(@Valid @RequestBody ClienteDTO dto){
        Cliente salvo=this.clienteService.salvar(dto);
        return salvo;
    }

    //ATUALIZAR
    @PutMapping("/Clientes/{idCliente}")
    public Cliente atualizar(@PathVariable Integer idCliente, @Valid @RequestBody ClienteDTO dto){
        Cliente atualizado=this.clienteService.atualizar(idCliente, dto);
        return atualizado;
    }

    //DELETAR
    @DeleteMapping("/Clientes/{idCliente}")
    public void deletar(@PathVariable Integer idCliente){
        this.clienteService.deletar(idCliente);
    }


}
