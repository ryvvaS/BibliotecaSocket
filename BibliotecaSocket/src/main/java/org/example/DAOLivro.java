package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

public class DAOLivro {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static <T> T lerArquivoJson(String caminhoArquivo, Class<T> clazz) throws IOException {
        URL recurso = DAOLivro.class.getClassLoader().getResource(caminhoArquivo);
        if (recurso == null) {
            throw new FileNotFoundException("Arquivo não encontrado: " + caminhoArquivo);
        }
        File arquivo = new File(recurso.getFile());
        try (FileReader leitor = new FileReader(arquivo)) {
            return gson.fromJson(leitor, clazz);
        }
    }

    public static <T> void escreverArquivoJson(String caminhoArquivo, T objeto) throws IOException {
        File arquivo = new File("src/main/resources/" + caminhoArquivo);
        try (FileWriter escritor = new FileWriter(arquivo)) {
            gson.toJson(objeto, escritor);
        }
    }
}
