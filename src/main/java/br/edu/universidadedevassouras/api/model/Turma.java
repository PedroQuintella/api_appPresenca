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
public class Turma implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(name = "tr_disciplina", nullable = false)
    private String disciplina;

    @NotBlank
    @Column(name = "tr_semestre", nullable = false)
    private String semestre;

    @NotBlank
    @Column(name = "tr_periodo", nullable = false)
    private String periodo;

    @ManyToMany
    @JoinTable(
            name = "aluno_turma",
            joinColumns = @JoinColumn(name = "turma_id"),
            inverseJoinColumns = @JoinColumn(name = "aluno_id")
    )
    private Set<Aluno> alunosMatriculados = new HashSet<>();

    public Set<Aluno> getAluno() {
        return alunosMatriculados;
    }

    public void matricularAluno(Aluno alunoid) {
        alunosMatriculados.add(alunoid);
    }
}
