package br.com.projeto.GestaoUniversitario.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "salas")
public class Salas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer id;
     private String curso;
     private String titulo;
     @OneToMany(mappedBy = "salas")
     private List<Mensagem> mensagem;

    public Salas() {
    }

    public Salas(String curso, String titulo) {
        this.curso = curso;
        this.titulo = titulo;
    }

    public List<Mensagem> getMensagem() {
        return mensagem;
    }

    public void setMensagem(List<Mensagem> mensagem) {
        this.mensagem = mensagem;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getCurso() {
        return curso;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    @Override
    public String toString() {
        return String.format(" Sala do curso: %s  sobre  %s\n", this.curso,this.titulo);
    }
}
