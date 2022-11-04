package org.soulcodeacademy.helpr.controllers;

import org.soulcodeacademy.helpr.domanin.Cargo;
import org.soulcodeacademy.helpr.services.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/cargos")
    public List<Cargo> listar(){
        // Requisição -> Controller -> Service -> Repository -> SELECT*FROM cargo;
        return this.cargoService.listar(); // JSON = JAVASCRIPT OBJECT NOTATION
    }

    @GetMapping("/cargos/{idCargo}") // indica que o valor após a barra é dinâmico
    public Cargo getCargo(@PathVariable Integer idCargo){
        System.out.println(idCargo);
        return this.cargoService.getCargo(idCargo);
    }

    //Podemos usar o mesmo endpoint para verbos diferentes
    @PostMapping("/cargos")
    public Cargo salvar(@RequestBody Cargo cargo){ // REQUISIÇÃO TIPO POST para /cargos
        //@RequestBody - extrai do JSON do corpo e converte para cargo(deserialização)
        Cargo salvo = this.cargoService.salvar(cargo);
        return salvo;
    }

    @PutMapping("/cargos/{idCargo}")
    public Cargo atualizar(@PathVariable Integer idCargo, @RequestBody Cargo cargo){
        Cargo atualizado = this.cargoService.atualizar(idCargo, cargo);
        return atualizado;// Resposta para o cliente(cargo atualizado)
    }

    @DeleteMapping("/cargos/{idCargo}") // verbo DELETE
    public void deletar(@PathVariable Integer idCargo){
        this.cargoService.deletar(idCargo);
    }
}
