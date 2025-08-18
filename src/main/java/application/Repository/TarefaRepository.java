package application.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import application.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long>{
    
}
