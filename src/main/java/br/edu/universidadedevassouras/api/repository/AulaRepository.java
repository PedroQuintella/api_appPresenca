package br.edu.universidadedevassouras.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.universidadedevassouras.api.model.Aula;

@Repository
public interface AulaRepository extends JpaRepository<Aula, Long> {

}