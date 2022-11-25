package org.soulcodeacademy.helpr.repositories;

import org.soulcodeacademy.helpr.domanin.Cargo;
import org.soulcodeacademy.helpr.domanin.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
    List<Funcionario> findByCargo(Cargo cargo); //Filtrar os funcionários que possuem este cargo
    List<Funcionario> findByFotoIsNull(); // Filtrar os funcionários que não possuem foto
    List<Funcionario> findByFotoIsNotNull(); // Filtrar os funcionários com foto

    @Query(value = "SELECT * FROM usuarios INNER JOIN cargo ON usuarios.id_cargo = cargo.id_cargo  WHERE dtype = 'Funcionario' AND cargo.salario BETWEEN :valor1 AND :valor2", nativeQuery = true)
    List<Funcionario> findBySalarioEntreFaixas(double valor1, double valor2) ;
}
