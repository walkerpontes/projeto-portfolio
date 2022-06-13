package br.com.projeto.GestaoUniversitario.modelo;

public class Salas {
     private String curso;
     private String titulo;
    public Salas(String curso, String titulo) {
        this.curso = curso;
        this.titulo = titulo;
    }
    public String getCurso() {
        return curso;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    @Override
    public String toString() {
        return String.format(" Sala do curso: %s  sobre  %s\n", this.curso,this.titulo);
    }
}
