package org.soulcodeacademy.helpr.services;

import org.soulcodeacademy.helpr.domanin.Cargo;
import org.soulcodeacademy.helpr.domanin.Funcionario;
import org.soulcodeacademy.helpr.domanin.dto.CargoDTO;
import org.soulcodeacademy.helpr.domanin.dto.FuncionarioDTO;
import org.soulcodeacademy.helpr.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Instaciar automaticamente a classe
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private CargoService cargoService;

    //Listar Todos
    public List<Funcionario>listar(){
        // Retorna os dados da tabela de forma de lista
        return this.funcionarioRepository.findAll();
    }

    //Listar um pelo ID
    public Funcionario getFuncionario(Integer idFuncionario){
        Optional<Funcionario> funcionario = this.funcionarioRepository.findById(idFuncionario);

        if (funcionario.isEmpty()){
            throw new RuntimeException("O funcionário não foi encontrado");
        } else {
            return  funcionario.get(); //pega o valor da entidade encontrada
        }
    }

    //SAVE
    public Funcionario salvar(FuncionarioDTO dto){
        //INSERT INTO cargo
        //Criando uma entidade nova a partir do DTO
        Cargo cargo=this.cargoService.getCargo(dto.getIdCargo()); // verifica se o cargo existe
        //id, nome, email, cpf, senha, foto, cargo
        Funcionario funcionario=new Funcionario(null, dto.getNome(), dto.getEmail(), dto.getCpf(), dto.getSenha(), dto.getFoto(), cargo);
        Funcionario funcionarioSalvo = this.funcionarioRepository.save(funcionario);

        return funcionarioSalvo;
    }

    //ATUALIZAR
    public Funcionario atualizar(Integer idFuncionario, FuncionarioDTO dto){
        Cargo cargoAtual=this.cargoService.getCargo(dto.getIdCargo());

        Funcionario funcionarioAtual=this.getFuncionario(idFuncionario);
        funcionarioAtual.setNome(dto.getNome());
        funcionarioAtual.setEmail(dto.getEmail());
        funcionarioAtual.setCpf(dto.getCpf());
        funcionarioAtual.setSenha(dto.getSenha());
        funcionarioAtual.setFoto(dto.getFoto());
        funcionarioAtual.setCargo(cargoAtual);

        //Atualiza a entidade, pois ela possui um ID diferente de null
        Funcionario atualizado = this.funcionarioRepository.save(funcionarioAtual);
        return atualizado;
    }

    //DELETE
    public void deletar(Integer idFuncionario){
        Funcionario funcionario=this.getFuncionario(idFuncionario);
        this.funcionarioRepository.delete(funcionario);
    }


}
