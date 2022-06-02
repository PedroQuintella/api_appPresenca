package br.edu.universidadedevassouras.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
@Entity
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String disciplina;
    @ManyToMany
    @JoinColumn(name = "id_aluno")
    private Aluno aluno;

}
