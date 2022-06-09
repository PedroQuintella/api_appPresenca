package br.edu.universidadedevassouras.api.http.controller;

import br.edu.universidadedevassouras.api.model.Aluno;
import br.edu.universidadedevassouras.api.model.Turma;
import br.edu.universidadedevassouras.api.repository.AlunoRepository;
import br.edu.universidadedevassouras.api.repository.TurmaRepository;
import br.edu.universidadedevassouras.api.service.TurmaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@RequestMapping("api/turma")
public class TurmaController {

    @Autowired
    private TurmaRepository turmaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private TurmaService turmaService;

    @Autowired
    private ModelMapper modelMapper;


    @GetMapping
    List<Turma> getTurmas(){
        return turmaRepository.findAll();
    }

    @PostMapping
    Turma criarTurma(@RequestBody Turma turma){
        return turmaRepository.save(turma);
    }

    @PutMapping("/{turmaid}/alunos/{alunoid}")
    Turma matricularAlunoEmDisciplina(
            @PathVariable Long turmaId,
            @PathVariable Long alunoId
    ) {
        Turma turma = turmaRepository.getReferenceById(turmaId);
        Aluno aluno = alunoRepository.getReferenceById(alunoId);
        turma.matricularAluno(aluno);
        return turmaRepository.save(turma);
    }

}
