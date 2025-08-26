package application.model;

import application.record.AlunoInsertDTO;
import application.record.alunoDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Aluno {
    @Id
    private long Id;
    private String nome;
    private Number idade;

    public Aluno(alunoDTO dados){
        this.setId(dados.id());
        this.setNome(dados.nome());
        this.setIdade(dados.idade());
    }

    public Aluno(AlunoInsertDTO dados){
        this.setNome(dados.nome());
        this.setIdade(dados.idade());
    }
}
