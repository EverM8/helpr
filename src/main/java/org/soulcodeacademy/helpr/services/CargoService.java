package org.soulcodeacademy.helpr.services;

import org.soulcodeacademy.helpr.domanin.Cargo;
import org.soulcodeacademy.helpr.repositories.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class CargoService {
    @Autowired
    private CargoRepository cargoRepository;

    // Listar todos
    public List<Cargo> listar(){
        // Retorna os dados da tabela de forma de lista
        return this.cargoRepository.findAll();
    }
    //Listar um pelo ID
    public Cargo getCargo(Integer idCargo){
        // SELECT * FROM cargo WHERE idCargo = ?
        Optional<Cargo> cargo = this.cargoRepository.findById(idCargo);

        if (cargo.isEmpty()){ // Encontrou o cargo?
            //Não encontrou o cargo com id solicitado
            throw new RuntimeException("O cargo não foi encontrado!"); // Causa um erro com a mensagem
        }else{
            return cargo.get(); // Extrair o cargo de dentro do optional
        }
    }
    //Salvar
    public Cargo salvar(Cargo novoCargo){
        novoCargo.setIdCargo(null); //Limpar o campo id para não substituir
        //INSERT INTO cargo
        Cargo cargoSalvo = this.cargoRepository.save(novoCargo);
        return cargoSalvo;
    }
    //Atualizar
    // Preciso do ID do cargo e dos dados atualizados
    public Cargo atualizar(Integer idCargo, Cargo novoCargo){
        // Verificar se o cargo existe mesmo
        Cargo cargoAtual=this.getCargo(idCargo);

        cargoAtual.setNome(novoCargo.getNome());
        cargoAtual.setDescricao(novoCargo.getDescricao());
        cargoAtual.setSalario(novoCargo.getSalario());

        //Atualiza a entidade, pois ela possui um ID diferente de null
        Cargo atualizado = this.cargoRepository.save(cargoAtual);
        return atualizado;
    }
    //Deletar
    public void deletar(Integer idCargo){
        Cargo cargo = this.getCargo(idCargo);
        //DELETE FROM cargo WHERE idCargo = ?
        this.cargoRepository.delete(cargo);
    }


}
