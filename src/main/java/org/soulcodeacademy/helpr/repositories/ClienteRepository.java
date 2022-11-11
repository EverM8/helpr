package org.soulcodeacademy.helpr.repositories;

import org.soulcodeacademy.helpr.domanin.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
