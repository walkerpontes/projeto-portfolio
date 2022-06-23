package br.com.projeto.GestaoUniversitario.modelo;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String email;
    private String nome;
    private String senha;
    @OneToOne
    @JoinColumn(name = "curso_id", referencedColumnName = "id")
    private Cursos curso;
    @ManyToOne
    @JoinColumn(name = "forum_id")
    private Forum forum;

    @ManyToOne
    @JoinColumn(name = "salas_id")
    private Salas salas;

    public Salas getSalas() {
        return salas;
    }

    public void setSalas(Salas salas) {
        this.salas = salas;
    }

    public Usuario() {
    }

    public Usuario(String nome, String email, String senha,Cursos curso) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.curso = curso;
    }

    public Cursos getCurso() {
        return curso;
    }

    public void setCurso(Cursos curso) {
        this.curso = curso;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }


//    public List<Forum> getForum() {
//        return forum;
//    }
//
//    public void setForum(List<Forum> forum) {
//        this.forum = forum;
//    }

    @Override
    public String toString() {
        return "Seu nome é: " + nome + " está no curso "+curso+"\n";
    }


    



    
}
