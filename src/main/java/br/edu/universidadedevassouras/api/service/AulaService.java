package br.edu.universidadedevassouras.api.service;

import br.edu.universidadedevassouras.api.model.Aula;
import br.edu.universidadedevassouras.api.repository.AulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AulaService {

    @Autowired
    private AulaRepository aulaRepository;

    public Aula salvar(Aula aula){
        return aulaRepository.save(aula);
    }

    public List<Aula> listaAula(){
        return aulaRepository.findAll();
    }

    public Optional<Aula> buscarAulaPorId(Long id){
        return aulaRepository.findById(id);
    }

    public void removerPorId(Long id) {
        aulaRepository.deleteById(id);
    }
}
