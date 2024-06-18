# BibliotecaSocket
Atividade avaliativa em grupo da disciplina Programação Concorrente e Distribuída. Como não foi especificado nos requisitos do trabalho a IDE a ser utilizada, o projeto foi desenvolvido na IDEA IntelliJ, recomendamos a execução na mesma para melhor experiêcia, além da biblioteca Gson.

# Classe ServidorBiblioteca
Este projeto implementa um servidor de biblioteca que permite gerenciar uma coleção de livros através de comandos de texto. O servidor é executado na porta 1010 e suporta várias operações como listar, cadastrar, alugar e devolver livros.

## Funcionalidades
- Listar livros: Retorna a lista de todos os livros disponíveis.
- Cadastrar livro: Adiciona um novo livro à coleção.
- Alugar livro: Permite alugar um livro disponível.
- Devolver livro: Permite devolver um livro alugado.
  
## Instruções
Para iniciar o servidor, execute a classe ServidorBiblioteca. As solicitações dos clientes são processadas por threads, permitindo múltiplas conexões simu

# Classe ClienteBiblioteca
`ClienteBiblioteca` é uma aplicação Java que permite aos usuários interagirem com um servidor de biblioteca para realizar operações como listar livros disponíveis, registrar novos livros, alugar e devolver livros, além da opção de sair, que termina a execução do programa, mediante confirmação.

## Instruções
Para executar o `ClienteBiblioteca`, você precisará executar primeiro a Classe `SevidorBiblioteca`, para que conecte ao servidor.

# Classe DAOLivro

A classe `DAOLivro` é uma implementação do projeto com o objetivo de ler e escrever arquivos em JSON. Nela foram utilizadas bibliotecas Gson e GsonBuilder, diferente do comum mas muito utilizado na manasipulação desses arquivos. 

## Funcionalidades

- **lerArquivoJson**: Lê um arquivo JSON de um caminho especificado e desserializa seu conteúdo em um objeto do tipo fornecido.
- **escreverArquivoJson**: Serializa um objeto em JSON e escreve o conteúdo em um arquivo no caminho especificado.
  
# Integrantes 
- Guilherme dos Santos Mota (UC22101328)
- Matheus Da Cruz Santos (UC21200334)
- Ryann Vitório Vasconcelos (UC21200006)
- Gabriel Felipe Rezende de Jesus (UC22101458)
