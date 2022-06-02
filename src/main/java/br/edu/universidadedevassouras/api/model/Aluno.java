package br.edu.universidadedevassouras.api.model;

import javax.persistence.*;
import br.edu.universidadedevassouras.api.model.Turma;

import com.sun.istack.NotNull;
import lombok.Data;

import java.util.ArrayList;

@Data
@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer matricula;
    @NotNull
    private String nome;
    @NotNull
    @Lob
    private String foto;
    private ArrayList<Turma> turmas;

}
