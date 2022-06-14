package br.com.projeto.GestaoUniversitario.modelo;

import javax.persistence.*;

@Entity
@Table(name = "forum")
public class Forum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String pergunta;
    private String tema;


    
    public Forum(String pergunta, String tema) {
        this.pergunta = pergunta;
        this.tema = tema;
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public Forum() {

    }

    public String getPergunta() {
        return pergunta;
    }
    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }
    public String getTema() {
        return tema;
    }
    @Override
    public String toString() {
        return "Pergunta: (" + pergunta + ") Sobre (" + tema + ")\n";
    }
}
