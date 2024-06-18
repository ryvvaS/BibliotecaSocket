package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorBiblioteca {
    private static final String CAMINHO_ARQUIVO = "livros.json";
    private ColecaoLivros colecaoLivros;

    public ServidorBiblioteca() {
        colecaoLivros = new ColecaoLivros();
        try {
            colecaoLivros = DAOLivro.lerArquivoJson(CAMINHO_ARQUIVO, ColecaoLivros.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void iniciar() {
        try (ServerSocket serverSocket = new ServerSocket(1010)) {
            System.out.println("Servidor de livros está rodando na porta " + 1010);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Novo cliente conectado");

                new Thread(new ManipuladorCliente(clientSocket, colecaoLivros, CAMINHO_ARQUIVO)).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ServidorBiblioteca servidor = new ServidorBiblioteca();
        servidor.iniciar();
    }
}
