package org.soulcodeacademy.helpr.services;

import org.soulcodeacademy.helpr.domanin.Cargo;
import org.soulcodeacademy.helpr.repositories.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // Indica para o Spring que esta classe será gerenciada por ele
public class PopulateService {
    @Autowired //Injetar o objeto direto na classe
    private CargoRepository cargoRepository;

    public void populate(){
        //                (Integer idCargo, String nome, String descricao, double salario)
        Cargo c1=new Cargo(null, "Diretor Geral", "Gerencia a empresa", 30000.0);
        Cargo c2= new Cargo(null, "Diretor de Setor", "Gerencia o setor da empresa", 18000.0);
        Cargo c3= new Cargo(null, "Técnico Geral", "Resolve os chamados urgentes ", 12000.0);
        //vamos persistir as entidades = salvar no banco
        this.cargoRepository.save(c1); //INSERT INTO
        this.cargoRepository.save(c2);
        this.cargoRepository.save(c3);
    }
}

// O objetivo desta classe é inserir no banco dados ficticios (de teste)
// IOC = Inversion of Control
// Container = é o locar onde o Spring guarda os objetos anotados
//@Service = indica que a classe é um serviço
// Injeção de Dependências = quando o Spring injeta os objetos na classe
