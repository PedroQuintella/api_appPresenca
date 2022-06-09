package br.edu.universidadedevassouras.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Aluno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "matricula", nullable = false)
    private Integer matricula;

    @NotBlank
    private String nome;

    @Lob
    private String foto;

    @ManyToMany(mappedBy = "alunosMatriculados")
    private Set<Turma> turma = new HashSet<>();

    public Set<Turma> getTurma() {
        return turma;
    }

    @ManyToMany(mappedBy = "alunosPresentes")
    private Set<Aula> aula = new HashSet<>();

    public Set<Aula> getAula() {
        return aula;
    }

}
