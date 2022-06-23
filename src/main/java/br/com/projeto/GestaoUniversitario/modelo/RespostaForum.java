//package br.com.projeto.GestaoUniversitario.modelo;
//
//import br.com.projeto.GestaoUniversitario.modelo.Forum;
//
//import javax.persistence.*;
//
//@Embeddable
//public class RespostaForum extends Forum {
//    private String resposta;
//
//
//    @JoinColumn(name = "forum_id")
//    private Forum forum;
//
//    public Forum getForum() {
//        return forum;
//    }
//
//    public void setForum(Forum forum) {
//        this.forum = forum;
//    }
//
//    public RespostaForum() {
//    }
//
//    public RespostaForum(Forum forum, String resposta) {
//        super();
//        this.forum = forum;
//        this.resposta = resposta;
//    }
//
//    public String getResposta() {
//        return resposta;
//    }
//
//    public void setResposta(String resposta) {
//        this.resposta = resposta;
//    }
//
//    @Override
//    public String toString() {
//        return "Sua resposta foi (" + resposta + ") sobre (" + getPergunta() +")\n";
//    }
//
//}
