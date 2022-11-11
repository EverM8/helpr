package org.soulcodeacademy.helpr.controllers;

import org.soulcodeacademy.helpr.domanin.Cliente;
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
    @GetMapping("/clientes")
    public List<Cliente> listar(){
        // Requisição -> Controller -> Service -> Repository -> SELECT*FROM cargo;
        return this.clienteService.listar();
    }

    //LISTAR BY ID
    @GetMapping("/clientes/{idCliente}")
    public Cliente getCliente(@PathVariable Integer idCliente){

        return this.clienteService.getCliente(idCliente);
    }

    //SALVAR
    @PostMapping("/clientes/{idCliente}")
    public Cliente salvar(@Valid @RequestBody ClienteDTO dto){
        Cliente salvo=this.clienteService.salvar(dto);
        return salvo;
    }

    //ATUALIZAR
    @PutMapping("/clientes/{idCliente}")
    public Cliente atualizar(@PathVariable Integer idCliente, @Valid @RequestBody ClienteDTO dto){
        Cliente atualizado=this.clienteService.atualizar(idCliente, dto);
        return atualizado; // CORPO DA RESPOSTA em JSON
    }

    //DELETAR
    @DeleteMapping("/clientes/{idCliente}")
    public void deletar(@PathVariable Integer idCliente){
        this.clienteService.deletar(idCliente);
    }


}
