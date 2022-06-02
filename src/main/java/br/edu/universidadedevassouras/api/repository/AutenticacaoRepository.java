package br.edu.universidadedevassouras.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.universidadedevassouras.api.model.Autenticacao;

@Repository
public interface AutenticacaoRepository extends JpaRepository<Autenticacao, Long> {

}