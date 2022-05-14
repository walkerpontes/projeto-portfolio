public class Forum {
    private String pergunta;
    private String tema;
    private String resposta;

    
    public Forum(String pergunta, String tema) {
        this.pergunta = pergunta;
        this.tema = tema;
        
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
    public void setTema(String tema) {
        this.tema = tema;
    } public String getResposta() {
        return resposta;
    }
    @Override
    public String toString() {
        return "Pergunta: (" + pergunta + ") Sobre (" + tema + ")\n";
    }
}
