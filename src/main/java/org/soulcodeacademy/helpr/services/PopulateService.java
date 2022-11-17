package org.soulcodeacademy.helpr.services;

import org.soulcodeacademy.helpr.domanin.Cargo;
import org.soulcodeacademy.helpr.domanin.Chamado;
import org.soulcodeacademy.helpr.domanin.Cliente;
import org.soulcodeacademy.helpr.domanin.Funcionario;
import org.soulcodeacademy.helpr.domanin.enums.StatusChamado;
import org.soulcodeacademy.helpr.repositories.CargoRepository;
import org.soulcodeacademy.helpr.repositories.ChamadoRepository;
import org.soulcodeacademy.helpr.repositories.ClienteRepository;
import org.soulcodeacademy.helpr.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Indica para o Spring que esta classe será gerenciada por ele
public class PopulateService {
    @Autowired //Injetar o objeto direto na classe
    private CargoRepository cargoRepository;
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ChamadoRepository chamadoRepository;

    public void populate(){
        //                (Integer idCargo, String nome, String descricao, double salario)
        Cargo c1=new Cargo(null, "Diretor Geral", "Gerencia a empresa", 30000.0);
        Cargo c2= new Cargo(null, "Diretor de Setor", "Gerencia o setor da empresa", 18000.0);
        Cargo c3= new Cargo(null, "Técnico Geral", "Resolve os chamados urgentes ", 12000.0);
        //Integer id, String nome, String email, String cpf, String senha, String foto, Cargo cargo);
        Funcionario f1=new Funcionario(null, "Renato","renato@email.com", "14243481881", "123456", null, c1);

        Funcionario f2 = new Funcionario(null, "Victor Icoma", "victor@email.com", "51127383671", "12345", null, c2);

        //vamos persistir as entidades = salvar no banco
        this.cargoRepository.saveAll(List.of(c1,c2,c3));//INSERT INTO

        this.funcionarioRepository.saveAll(List.of(f1,f2));

        Cliente cl1= new Cliente(null, "Jõao", "joão@email.com", "55655757899", "12345", "+55 (00) 98888-8888");
        Cliente cl2 = new Cliente(null, "Pedro João", "pedro@gmail.com", "37734168302", "batata", "+55 (99) 99999-9997");
        this.clienteRepository.saveAll(List.of(cl1,cl2));
        //this.clienteRepository.save(cl1);
        //this.clienteRepository.save(cl2);

         Chamado ch1=new Chamado(null, "Primeiro chamado do sistema.", "Revisar entidades criadas");
        ch1.setCliente(cl1);
        Chamado ch2=new Chamado(null, "Ativar VPN do sistema.", "Conectar aos servidores remotos");
        ch2.setCliente(cl2);
        ch2.setFuncionario(f1);
        ch2.setStatus(StatusChamado.ATRIBUIDO);
        this.chamadoRepository.saveAll(List.of(ch1,ch2));


    }



}

// O objetivo desta classe é inserir no banco dados ficticios (de teste)
// IOC = Inversion of Control
// Container = é o locar onde o Spring guarda os objetos anotados
//@Service = indica que a classe é um serviço
// Injeção de Dependências = quando o Spring injeta os objetos na classe
