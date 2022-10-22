package br.com.projeto.GestaoUniversitario.model;

import javax.persistence.*;

@Entity
public class Mensagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String mensagem;

    @ManyToOne
    private Salas salas;

    @ManyToOne
    private Usuario usuario;

    public Mensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Mensagem() {

    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
