package br.edu.universidadedevassouras.api.service;

import br.edu.universidadedevassouras.api.model.Professor;
import br.edu.universidadedevassouras.api.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public Professor salvar(Professor professor){
        return professorRepository.save(professor);
    }

    public List<Professor> listaProfessor(){
        return professorRepository.findAll();
    }

    public Optional<Professor> buscarProfessorPorId(Long id){
        return professorRepository.findById(id);
    }

    public void removerPorId(Long id) {
        professorRepository.deleteById(id);
    }
}
