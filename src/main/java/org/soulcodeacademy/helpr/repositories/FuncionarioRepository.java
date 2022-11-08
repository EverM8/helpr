package org.soulcodeacademy.helpr.repositories;

import org.soulcodeacademy.helpr.domanin.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
}
