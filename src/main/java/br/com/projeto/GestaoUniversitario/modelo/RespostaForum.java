package br.com.projeto.GestaoUniversitario.modelo;

import br.com.projeto.GestaoUniversitario.modelo.Forum;

public class RespostaForum extends Forum {
    private String resposta;
    private Forum forum;

    public RespostaForum(Forum forum, String resposta) {
        super();
        this.forum = forum;
        this.resposta = resposta;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    @Override
    public String toString() {
        return "Sua resposta foi (" + resposta + ") sobre (" + getPergunta() +")\n";
    }
    
}
