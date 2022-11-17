package org.soulcodeacademy.helpr.repositories;

import org.soulcodeacademy.helpr.domanin.Chamado;
import org.soulcodeacademy.helpr.domanin.Cliente;
import org.soulcodeacademy.helpr.domanin.Funcionario;
import org.soulcodeacademy.helpr.domanin.enums.StatusChamado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {

    List<Chamado> findByStatus(StatusChamado status); //Filtrar os chamados de acordo com o status
    List<Chamado> findByCliente(Cliente cliente); //Filtrar os chamados de um cliente específico
    List<Chamado> findByFuncionario(Funcionario funcionario); //Filtrar os chamados de um funcionário específico

    // nativeQuery ativa a sintaxe do SQL
    @Query(value = "SELECT * FROM chamado WHERE data_abertura BETWEEN :data1 AND :data2", nativeQuery = true)
    List<Chamado> findByData(LocalDate data1, LocalDate data2);


}
