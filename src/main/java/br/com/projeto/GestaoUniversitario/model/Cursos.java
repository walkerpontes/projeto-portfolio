package br.com.projeto.GestaoUniversitario.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cursos")
public class Cursos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String titulo;



    public Cursos() {
    }

    public Cursos(String nome, String titulo) {
        this.nome = nome;
        this.titulo = titulo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    @Override
    public String toString() {
        return "Curso: (" + nome + ") fala sobre (" + titulo + ")\n";
    }
    
}
