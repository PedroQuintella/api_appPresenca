package br.edu.universidadedevassouras.api.http.controller;

import br.edu.universidadedevassouras.api.model.Aula;
import br.edu.universidadedevassouras.api.service.AulaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/aula")
public class AulaController {

    @Autowired
    private AulaService aulaService;

    @Autowired
    private ModelMapper modelMapper;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Aula salvar(@RequestBody Aula aula){
        return aulaService.salvar(aula);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Aula> listaAula(){
        return aulaService.listaAula();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Aula buscarAulaPorId(Long id){
        return aulaService.buscarAulaPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aula não encontrada."));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerAula(Long id){
        aulaService.buscarAulaPorId(id)
                .map(aula -> {
                    aulaService.removerPorId(aula.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aula não encontrada."));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarAula(@PathVariable("id") Long id, @RequestBody Aula aula){
        aulaService.buscarAulaPorId(id)
                .map(aulaBase -> {
                    modelMapper.map(aula, aulaBase);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aula não encontrada."));
    }
}
