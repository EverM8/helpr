package org.soulcodeacademy.helpr.controllers;

import org.soulcodeacademy.helpr.domanin.Funcionario;
import org.soulcodeacademy.helpr.domanin.dto.FuncionarioDTO;
import org.soulcodeacademy.helpr.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


//@Autowired
//private FuncionarioService funcionarioService;

@RestController
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    // Endpoint é o endereço que será acessado no backend
    @GetMapping("/funcionarios")
    public List<Funcionario>listar(){
        // Requisição -> Controller -> Service -> Repository -> SELECT*FROM cargo;
        return this.funcionarioService.listar();
    }

    @GetMapping("funcionarios/{idFuncionario}")
    public Funcionario getFuncionario(@PathVariable Integer idFuncionario){
        System.out.println(idFuncionario);
        return this.funcionarioService.getFuncionario(idFuncionario);
    }

    //POST = REPRESENTA A INSERSÃO DE DADOS
    @PostMapping("/funcionarios/{idFuncionario}")
    public Funcionario salvar(@Valid @RequestBody FuncionarioDTO dto){// REQUISIÇÃO TIPO POST para /cargos
        //@RequestBody - extrair o JSON do corpo e converte para cargo(deserialização)
        Funcionario salvo= this.funcionarioService.salvar(dto);
        return salvo;
    }

    //PUT = REPRESENTA A INSERSÃO DE DADOS
    @PutMapping("/funcionarios/{idFuncionario}")
    public Funcionario atualizar(@PathVariable Integer idFuncionario, @Valid @RequestBody FuncionarioDTO dto){
        Funcionario atualizado=this.funcionarioService.atualizar(idFuncionario, dto);
        return atualizado;
    }

    @DeleteMapping("/funcionarios/{idFuncionario}")
    public void  deletar(@PathVariable Integer idFuncionario){
        this.funcionarioService.deletar(idFuncionario);
    }



}
