package br.edu.universidadedevassouras.api.service;

import br.edu.universidadedevassouras.api.model.Aluno;
import br.edu.universidadedevassouras.api.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    private AlunoRepository alunoRepository;

    @Autowired
    public void setAlunoRepository(AlunoRepository alunoRepository){
        this.alunoRepository = alunoRepository;
    }

    public Aluno salvar(Aluno aluno){
        return alunoRepository.save(aluno);
    }

    public List<Aluno> listaAluno(){
        return alunoRepository.findAll();
    }

    public Optional<Aluno> buscarAlunoPorId(Long id){
        return alunoRepository.findById(id);
    }

    public void removerPorId(Long id) {
        alunoRepository.deleteById(id);
    }

}
