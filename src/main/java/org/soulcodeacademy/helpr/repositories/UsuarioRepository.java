package org.soulcodeacademy.helpr.repositories;

import org.soulcodeacademy.helpr.domanin.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    // UM RESULTADO = OPTIONAL
    // VÁRIOS = LIST
    Optional<Usuario> findByEmail(String email); //WHERRE email = email
    Optional<Usuario> findByCpf(String cpf); //WHERE cpf = cpf

    List<Usuario> findByNome(String nome); //WHERE nome = nome
    List<Usuario> findByNomeContaining(String busca); //Filtrar pelo nome
}

// Métodos presentes
// - findAll => SELECT*FROM usuario;
// - findById => SELECT*FROM usuario WHERE id = ?;
// - save => INSERT INTO(caso id nulo) ou UPDATE(caso id não nulo);
// - delete => DELETE FROM usuario WHERE id=?;

// CRUD de Funcionários
// Entidade -> Repository -> DTO -> Service + Controller
