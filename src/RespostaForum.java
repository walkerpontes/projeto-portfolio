public class RespostaForum extends Forum{
    private String resposta;

    public RespostaForum(String tema,String pergunta, String resposta) {
        super(pergunta, tema);
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
