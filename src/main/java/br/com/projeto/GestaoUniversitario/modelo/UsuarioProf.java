package br.com.projeto.GestaoUniversitario.modelo;

public class UsuarioProf {
    private String nome;
    private String senha;
    private String email;


    
    
    public UsuarioProf(String nome,String email,String senha){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
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


    @Override
    public String toString() {
        return "Nome: (" + nome + ") Email: ("+email+ ")\n";
    }

}
