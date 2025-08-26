package application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import application.Repository.AlunoRepository;
import application.record.AlunoInsertDTO;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepo;

    @Autowired
    private AlunoService alunoService;

    public Iterable<AlunoDTO> getAll(){
        return alunoRepo.findAll().stream().map(AlunoDTO::new).toList();
    }

    public AlunoDTO insert(AlunoInsertDTO dados){
        return new AlunoDTO(alunoRepo.save(new Aluno(dados)));
    }
}
