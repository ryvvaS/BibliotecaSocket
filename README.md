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
  
# Classe Livro

Uma classe Java simples para representar um livro com atributos como autor, título, número de exemplares e gênero.

## Visão Geral

A classe `Livro` foi projetada para representar um livro com quatro atributos principais:
- `autor`: O autor do livro.
- `titulo`: O título do livro.
- `exemplares`: O número de exemplares disponíveis.
- `genero`: O gênero do livro.

Esta classe fornece um construtor para inicializar esses atributos, juntamente com métodos getter e setter para cada atributo. Além disso, sobrescreve o método `toString` para fornecer uma representação formatada dos detalhes do livro.

## Uso

Para usar esta classe, você pode criar uma instância de `Livro` e definir seus atributos, seja através do construtor ou utilizando os métodos setter fornecidos.

### Exemplo de Uso

- Criar um objeto `Livro`.
- Definir os atributos `autor`, `titulo`, `exemplares` e `genero`.
- Imprimir os detalhes do livro no console.

# Classe ColecaoLivros

A classe ColecaoLivros gerencia uma coleção de livros. Ela oferece funcionalidades para adicionar livros, atualizar o número de cópias disponíveis e exibir a coleção de livros como uma string. 

## Funcionalidades

- getLivros: Retorna a lista de livros.
- adicionarLivro: Adiciona um livro à coleção e atualiza o arquivo JSON.
- atualizarCopiasLivro: Atualiza o número de cópias de um livro específico e o arquivo JSON.
- livrosString: Retorna uma representação em string dos livros.
- toString: sobreescreve o metódo toString e retorna uma representação detalhada da coleção de livros.

# Integrantes 
- Guilherme dos Santos Mota (UC22101328)
- Matheus Da Cruz Santos (UC21200334)
- Ryann Vitório Vasconcelos (UC21200006)
- Gabriel Felipe Rezende de Jesus (UC22101458)
- Eduardo Henrique Moraes Gama (UC22100642)

## Manipulador Cliente

Este código implementa a classe `ManipuladorCliente`, responsável por lidar com as solicitações de clientes conectados a um servidor de biblioteca.

## Funcionalidades
- **Listar livros:** Retorna a lista de todos os livros disponíveis.
- **Cadastrar livro:** Adiciona um novo livro à coleção.
- **Alugar livro:** Permite alugar um livro disponível.
- **Devolver livro:** Permite devolver um livro alugado.

## Detalhes de Implementação
- A classe é executada em uma thread separada para cada cliente.
- Processa solicitações recebidas via socket, lendo os comandos e enviando as respostas apropriadas.
- Utiliza a classe `ColecaoLivros` para manipular a coleção de livros armazenada em um arquivo JSON.

## Instruções
- Construa um objeto `ManipuladorCliente` passando um `Socket`, um objeto `ColecaoLivros` e o caminho do arquivo JSON contendo a coleção de livros.
- Chame o método `run` para começar a processar as solicitações do cliente.
