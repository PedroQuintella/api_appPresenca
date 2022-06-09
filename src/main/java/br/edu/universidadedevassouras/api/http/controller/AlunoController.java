package br.edu.universidadedevassouras.api.http.controller;

import br.edu.universidadedevassouras.api.model.Aluno;
import br.edu.universidadedevassouras.api.service.AlunoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/aluno")
public class AlunoController {

    private AlunoService alunoService;

    @Autowired
    public void setAlunoService(AlunoService alunoService){
        this.alunoService = alunoService;
    }

    @Autowired
    private ModelMapper modelMapper;



    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Aluno salvar(@RequestBody Aluno aluno){
        return alunoService.salvar(aluno);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Aluno> listaAluno(){
        return alunoService.listaAluno();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Aluno buscarAlunoPorId(Long id){
        return alunoService.buscarAlunoPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado."));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerAluno(Long id){
        alunoService.buscarAlunoPorId(id)
                .map(aluno -> {
                    alunoService.removerPorId(aluno.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado."));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarAluno(@PathVariable("id") Long id, @RequestBody Aluno aluno){
        alunoService.buscarAlunoPorId(id)
                .map(alunoBase -> {
                    modelMapper.map(aluno, alunoBase);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado."));
    }

}
