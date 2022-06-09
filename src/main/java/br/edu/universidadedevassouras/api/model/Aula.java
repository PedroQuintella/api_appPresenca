package br.edu.universidadedevassouras.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Aula implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "aula_dia", nullable = false)
    private String dia;

    @Column(name = "aula_conteudo")
    private String conteudoMinistrado;

    @ManyToMany
    @JoinTable(
            name = "presenca_aluno_aula",
            joinColumns = @JoinColumn(name = "aula_id"),
            inverseJoinColumns = @JoinColumn(name = "aluno_id")
    )
    private Set<Aluno> alunosPresentes = new HashSet<>();

    public Set<Aluno> getAluno() {
        return alunosPresentes;
    }

}
