package org.soulcodeacademy.helpr.services;

import org.soulcodeacademy.helpr.domanin.Cliente;
import org.soulcodeacademy.helpr.domanin.dto.ClienteDTO;
import org.soulcodeacademy.helpr.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    //LISTAR TODOS
    public List<Cliente>listar(){
        return this.clienteRepository.findAll();
    }

    //LISTAR BY ID
    public Cliente getCliente(Integer idCliente){
        Optional<Cliente> cliente=this.clienteRepository.findById(idCliente);
        if (cliente.isEmpty()) {
            throw new RuntimeException("O cliente informado não foi encontrado!");
        } else {
            return cliente.get(); //pega o valor da entidade encontrada
            }
    }

    //SALVAR
    public Cliente salvar(ClienteDTO dto){
        //id, nome, email, cpf, senha, foto, cargo
        Cliente cliente= new Cliente(null, dto.getNome(), dto.getEmail(), dto.getCpf(), dto.getSenha(), dto.getTelefone() );
        Cliente clienteSalvo=this.clienteRepository.save(cliente);

        return clienteSalvo;
    }

    // Quando usar entidade e dto?
    // Entidade = retorno dos dados
    // DTO = entrada de dados

    //ATUALIZAR
    public Cliente atualizar(Integer idCliente, ClienteDTO dto){

        Cliente clienteAtual=this.getCliente(idCliente); //garante que não será acrescentado um novo cliente e sim atualizá-lo

        clienteAtual.setNome(dto.getNome());
        clienteAtual.setEmail(dto.getEmail());
        clienteAtual.setCpf(dto.getCpf());
        clienteAtual.setSenha(dto.getSenha());
        clienteAtual.setTelefone(dto.getTelefone());

        Cliente atualizado=this.clienteRepository.save(clienteAtual);
        return atualizado;
    }

    //DELETE
    public void deletar(Integer idCliente){
        Cliente cliente=this.getCliente(idCliente);
        this.clienteRepository.delete(cliente);
    }








    }





