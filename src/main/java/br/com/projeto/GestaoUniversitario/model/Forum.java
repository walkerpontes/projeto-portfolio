package br.com.projeto.GestaoUniversitario.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "forum")
public class Forum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String pergunta;
    private String tema;

    @OneToMany(mappedBy = "forum")
    private List<RespostaForum> respostas;


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

    public List<RespostaForum> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<RespostaForum> respostas) {
        this.respostas = respostas;
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
