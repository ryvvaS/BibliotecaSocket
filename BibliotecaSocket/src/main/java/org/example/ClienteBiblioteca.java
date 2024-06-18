package org.example;

import java.io.*;
import java.net.Socket;

public class ClienteBiblioteca {

    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 1010);
             BufferedReader leitorServidor = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter escritorServidor = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader leitorUsuario = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Conectado ao servidor da biblioteca.");

            boolean running = true;
            while (running) {
                System.out.println("Digite um comando (listar, cadastrar, alugar, devolver, sair): ");
                String comando = leitorUsuario.readLine().trim().toLowerCase();

                switch (comando) {
                    case "listar":
                        escritorServidor.println("listar");
                        break;
                    case "cadastrar":
                        System.out.println("Digite os detalhes (autor,título,genero,exemplares): ");
                        String detalhesCadastro = leitorUsuario.readLine().trim();
                        escritorServidor.println("cadastrar," + detalhesCadastro);
                        break;
                    case "alugar":
                        System.out.println("Digite o título: ");
                        String tituloAlugar = leitorUsuario.readLine().trim();
                        escritorServidor.println("alugar," + tituloAlugar);
                        break;
                    case "devolver":
                        System.out.println("Digite o título: ");
                        String tituloDevolver = leitorUsuario.readLine().trim();
                        escritorServidor.println("devolver," + tituloDevolver);
                        break;
                    case "sair":
                        System.out.println("Tem certeza que deseja sair? Digite 'sim' para confirmar ou 'não' para continuar:");
                        String confirmacao = leitorUsuario.readLine().trim().toLowerCase();
                        if (confirmacao.equals("sim")) {
                            System.out.println("Desconectando do servidor da biblioteca.");
                            running = false;
                        }
                        break;
                    default:
                        System.out.println("Comando desconhecido.");
                        break;
                }

                if (running) {
                    String resposta = leitorServidor.readLine();
                    System.out.println(resposta);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
