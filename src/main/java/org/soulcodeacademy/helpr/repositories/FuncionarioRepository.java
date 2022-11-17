package org.soulcodeacademy.helpr.repositories;

import org.soulcodeacademy.helpr.domanin.Cargo;
import org.soulcodeacademy.helpr.domanin.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
    List<Funcionario> findByCargo(Cargo cargo); //Filtrar os funcionários que possuem este cargo
    List<Funcionario> findByFotoIsNull(); // Filtrar os funcionários que não possuem foto
    List<Funcionario> findByFotoIsNotNull(); // Filtrar os funcionários com foto
}
