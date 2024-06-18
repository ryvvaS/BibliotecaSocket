package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ColecaoLivros {
    private List<Livro> livros = new ArrayList<>();

    public List<Livro> getLivros() {
        return livros;
    }

    public void adicionarLivro(String caminhoArquivo, Livro livro) throws IOException {
        this.livros.add(livro);
        DAOLivro.escreverArquivoJson(caminhoArquivo, this);
    }

    public void atualizarCopiasLivro(String caminhoArquivo, String titulo, Integer novasCopias) throws IOException {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                livro.setExemplares(novasCopias);
                DAOLivro.escreverArquivoJson(caminhoArquivo, this);
                return;
            }
        }
        throw new IOException("Livro com o título " + titulo + " não encontrado.");
    }

    public String livrosString() {
        StringBuilder livrosString = new StringBuilder();
        for (Livro livro : livros) {
            livrosString.append(livro.toString());
        }
        return livrosString.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Coleção de Livros:\n");
        for (Livro livro : livros) {
            sb.append(livro.toString()).append("\n");
        }
        return sb.toString();
    }

}
