package br.edu.universidadedevassouras.api.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.Pattern;
import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Professor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    //@Pattern(regexp = "^[A-Z]+(.)*")
    @Column(name = "pr_nome", nullable = false)
    private String nome;

    @NotBlank
    @Column(name = "pr_matricula", nullable = false)
    private String matricula;

    @NotBlank
    @Column(name = "pr_senha", nullable = false)
    private String senha;
}
