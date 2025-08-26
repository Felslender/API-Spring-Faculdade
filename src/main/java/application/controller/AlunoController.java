package application.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import application.Repository.AlunoRepository;
import application.model.Aluno;
import application.record.alunoDTO;
import application.service.AlunoService;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    @Autowired
    private AlunoRepository alunoRepo;

    @Autowired
    private AlunoService alunoService;

    @PostMapping
    public AlunoDTO insert(@RequestBody AlunoDTO novoAluno){

        return alunoService.insert(novoAluno);
    }

    @GetMapping
    public Iterable<AlunoDTO> getAll(){
        return alunoService.getAll();
    }

    @GetMapping("/{id}")
    public AlunoDTO getOne(@PathVariable long id){
        Optional<Aluno> resultado = alunoRepo.findById(id);

        if(resultado.isEmpty()){
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Aluno não encontrado(a)"
            );
        }

        return new AlunoDTO(resultado.get());
    }

    @PutMapping("/{id}")
    public AlunoDTO update(@PathVariable long id, @RequestBody AlunoDTO dadosAluno){
        Optional<Aluno> resultado = alunoRepo.findById(id);

        if(resultado.isPresent()){
            resultado.get().setNome(dadosAluno.getNome());
            resultado.get().setIdade(dadosAluno.getIdade());
            return alunoRepo.save(resultado.get());
        }

        return new alunoDTO(alunoRepo.save(resultado.get()));
    }


    @DeleteMapping("/{id}")
    public void remove(@PathVariable long id){
        if(!alunoRepo.existsById(id)){
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Aluno não encontrado(a)"
            );
        }

        alunoRepo.deleteById(id);
    }

}
