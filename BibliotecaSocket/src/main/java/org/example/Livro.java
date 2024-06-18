package org.example;

public class Livro {
    private String autor;
    private String titulo;
    private Integer exemplares;
    private String genero;  // Novo campo

    public Livro() {}

    public Livro(String autor, String titulo, Integer exemplares, String genero) {
        this.autor = autor;
        this.titulo = titulo;
        this.exemplares = exemplares;
        this.genero = genero;  // Inicialização do novo campo
    }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public Integer getExemplares() { return exemplares; }
    public void setExemplares(Integer exemplares) { this.exemplares = exemplares; }

    public String getGenero() { return genero; }  // Getter para genero
    public void setGenero(String genero) { this.genero = genero; }  // Setter para genero

    @Override
    public String toString() {
        return "Livro: " +
                "Autor = '" + autor + '\'' +
                ", Título = '" + titulo + '\'' +
                ", Exemplares = " + exemplares +
                ", Gênero = '" + genero + '\'';  // Inclusão do novo campo
    }
}
