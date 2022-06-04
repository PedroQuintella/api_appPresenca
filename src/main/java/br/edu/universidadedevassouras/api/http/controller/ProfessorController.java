package br.edu.universidadedevassouras.api.http.controller;

import br.edu.universidadedevassouras.api.model.Professor;
import br.edu.universidadedevassouras.api.service.ProfessorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController("/professor")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Professor salvar(@RequestBody Professor professor){
        return professorService.salvar(professor);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Professor> listaProfessor(){
        return professorService.listaProfessor();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Professor buscarProfessorPorId(Long id){
        return professorService.buscarProfessorPorId(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Professor não encontrado."));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerProfessor(Long id){
        professorService.buscarProfessorPorId(id)
                .map(professor -> {
                    professorService.removerPorId(professor.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Professor não encontrado."));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarProfessor(@PathVariable("id") Long id, @RequestBody Professor professor){
        professorService.buscarProfessorPorId(id)
                .map(professorBase -> {
                    modelMapper.map(professor, professorBase);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Professor não encontrado."));
    }


}
