package org.soulcodeacademy.helpr.controllers;

import org.soulcodeacademy.helpr.domanin.Cargo;
import org.soulcodeacademy.helpr.domanin.dto.CargoDTO;
import org.soulcodeacademy.helpr.services.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController // retorno de dados
public class CargoController {

    // Endpoint é o endereço que será acessado no backend
    @GetMapping("/oi") // com base em localhost:8080/oi retorna a String
    public String dizOla(){
        return "Olá, tudo bem?";
    }

    @GetMapping("/valor")
    public Integer valor(){
        return 1000;
    }

    @Autowired
    private CargoService cargoService;

    @PreAuthorize("hasRole('ROLE_ADMIN', 'ROLE_FUNCIONARIO')")
    @GetMapping("/cargos")
    public List<Cargo> listar(){
        // Requisição -> Controller -> Service -> Repository -> SELECT*FROM cargo;
        return this.cargoService.listar(); // JSON = JAVASCRIPT OBJECT NOTATION
    }

    @PreAuthorize("hasRole('ROLE_ADMIN', 'ROLE_FUNCIONARIO')")
    @GetMapping("/cargos/{idCargo}") // indica que o valor após a barra é dinâmico
    public Cargo getCargo(@PathVariable Integer idCargo){
        System.out.println(idCargo);
        return this.cargoService.getCargo(idCargo);
    }

    //Podemos usar o mesmo endpoint para verbos diferentes
    @PreAuthorize("hasRole('ROLE_ADMIN')") //Apenas os admins podem acessar esse endpoint
    @PostMapping("/cargos")
    public Cargo salvar(@Valid @RequestBody CargoDTO cargo){ // REQUISIÇÃO TIPO POST para /cargos
        //@RequestBody - extrair o JSON do corpo e converte para cargo(deserialização)
        Cargo salvo = this.cargoService.salvar(cargo);
        return salvo;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/cargos/{idCargo}")
    public Cargo atualizar(@PathVariable Integer idCargo, @Valid @RequestBody CargoDTO cargo){
        Cargo atualizado = this.cargoService.atualizar(idCargo, cargo);
        return atualizado;// Resposta para o cliente(cargo atualizado)
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/cargos/{idCargo}") // verbo DELETE
    public void deletar(@PathVariable Integer idCargo){
        this.cargoService.deletar(idCargo);
    }
}
