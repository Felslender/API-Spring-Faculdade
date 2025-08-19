package application.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import application.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{
    
}