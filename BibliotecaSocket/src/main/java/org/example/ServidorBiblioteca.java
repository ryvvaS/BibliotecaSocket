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

                new Thread(new ManipuladorCliente(clientSocket)).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ServidorBiblioteca servidor = new ServidorBiblioteca();
        servidor.iniciar();
    }

    private class ManipuladorCliente implements Runnable {
        private Socket clientSocket;

        public ManipuladorCliente(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                String request;
                while ((request = in.readLine()) != null) {
                    System.out.println("Solicitação recebida: " + request);
                    String response = processarSolicitacao(request);
                    out.println(response);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private String processarSolicitacao(String request) throws IOException {
            String[] parts = request.split(",");
            String command = parts[0].trim().toLowerCase();

            switch (command) {
                case "listar":
                    return colecaoLivros.livrosString();

                case "cadastrar":
                    if (parts.length != 5) return "Formato de solicitação inválido. Use: cadastrar,autor,título,genero,cópias";
                    try {
                        String autor = parts[1].trim();
                        String titulo = parts[2].trim();
                        String genero = parts[3].trim();
                        int copias = Integer.parseInt(parts[4].trim());
                        Livro novoLivro = new Livro(autor, titulo, copias, genero);
                        colecaoLivros.adicionarLivro(CAMINHO_ARQUIVO, novoLivro);
                        return "Livro cadastrado com sucesso.";
                    } catch (NumberFormatException | IOException e) {
                        return "Erro ao cadastrar o livro: " + e.getMessage();
                    }

                case "alugar":
                    if (parts.length != 2) return "Formato de solicitação inválido. Use: alugar,título";
                    String tituloAlugar = parts[1].trim();
                    for (Livro livro : colecaoLivros.getLivros()) {
                        if (livro.getTitulo().equalsIgnoreCase(tituloAlugar)) {
                            if (livro.getExemplares() > 0) {
                                try {
                                    colecaoLivros.atualizarCopiasLivro(CAMINHO_ARQUIVO, tituloAlugar, livro.getExemplares() - 1);
                                    return "Livro alugado com sucesso.";
                                } catch (IOException e) {
                                    return "Erro ao atualizar o livro: " + e.getMessage();
                                }
                            } else {
                                return "Nenhuma cópia disponível para aluguel.";
                            }
                        }
                    }
                    return "Livro não encontrado.";

                case "devolver":
                    if (parts.length != 2) return "Formato de solicitação inválido. Use: devolver,título";
                    String tituloDevolver = parts[1].trim();
                    for (Livro livro : colecaoLivros.getLivros()) {
                        if (livro.getTitulo().equalsIgnoreCase(tituloDevolver)) {
                            try {
                                colecaoLivros.atualizarCopiasLivro(CAMINHO_ARQUIVO, tituloDevolver, livro.getExemplares() + 1);
                                return "Livro devolvido com sucesso.";
                            } catch (IOException e) {
                                return "Erro ao atualizar o livro: " + e.getMessage();
                            }
                        }
                    }
                    return "Livro não encontrado.";

                default:
                    return "Comando desconhecido.";
            }
        }
    }
}
