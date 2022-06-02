package br.edu.universidadedevassouras.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.edu.universidadedevassouras.api.model.Presenca;

@Repository
public interface PresencaRepository extends JpaRepository<Presenca, Long> {

}