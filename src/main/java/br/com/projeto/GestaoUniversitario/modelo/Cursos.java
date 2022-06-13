package br.com.projeto.GestaoUniversitario.modelo;

public class Cursos {
    private String nome;
    private String titulo;
    
    public Cursos(String nome, String titulo) {
        this.nome = nome;
        this.titulo = titulo;
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
