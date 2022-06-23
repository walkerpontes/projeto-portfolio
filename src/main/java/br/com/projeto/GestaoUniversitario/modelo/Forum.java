package br.com.projeto.GestaoUniversitario.modelo;

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


    @ManyToMany
    private List<Usuario> usuario;
//    @Embedded
//    @JoinColumn(name = "resposta")
//    private RespostaForum respostaForum;



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

//    public RespostaForum getRespostaForum() {
//        return respostaForum;
//    }
//
//    public void setRespostaForum(RespostaForum respostaForum) {
//        this.respostaForum = respostaForum;
//    }

    public String getPergunta() {
        return pergunta;
    }
    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }
    public String getTema() {
        return tema;
    }

    public List<Usuario> getUsuarios() {
        return usuario;
    }

    public void setUsuarios(List<Usuario> usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Pergunta: (" + pergunta + ") Sobre (" + tema + ")\n";
    }
}
