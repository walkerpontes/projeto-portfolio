package br.com.projeto.GestaoUniversitario.modelo;

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

    @OneToMany(mappedBy = "curso")
    private List<Usuario> usuario;

    public Cursos() {
    }

    public Cursos(String nome, String titulo) {
        this.nome = nome;
        this.titulo = titulo;
    }

    public List<Usuario> getUsuario() {
        return usuario;
    }

    public void setUsuario(List<Usuario> usuario) {
        this.usuario = usuario;
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
