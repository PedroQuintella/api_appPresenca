package br.edu.universidadedevassouras.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.edu.universidadedevassouras.api.model.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {
    //Turma findByUsername(String turma);

}