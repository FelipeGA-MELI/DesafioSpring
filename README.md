# Desafio Spring BootCamp MELI

Projeto de uma API para interação entre usuários e publicação de produtos. O objetivo deste projeto é exercitar todos os conceitos de Java, paradigma orientado a objetos e Spring vistos durante o BootCamp.

## Instalação

Para executar a API não é necessária nenhuma instalação. Basta executar o projeto na sua IDE de preferência.
Como pedido no desafio, não foi utilizado banco de dados, apenas JSON.
O JSON encontra-se no diretório: "/Users/fgusmao/Downloads/desafioSpring/user.json"
Para execução na sua máquina, altere este diretório para o diretório respectivo da sua máquina. Esta configuração deve ser modificada em repository/APIrepository, linha 22, na constante "DIRETORIO_JSON".

## Endpoints da API


- Criar usuário:
  POST 127.0.0.1:8080/users/create

- Seguir usuário:
  POST 127.0.0.1:8080/users/{userId}/follow/{userIdToFollow}

- Contar seguidores:
  GET 127.0.0.1:8080/users/{userId}/followers/count/

- Gerar lista de seguidores:
  GET 127.0.0.1:8080/users/{userId}/followers/list

- Gerar lista de quem o usuário está seguindo:
  GET 127.0.0.1:8080/users/{userId}/followed/list

- Deixar de seguir usuário:
  POST 127.0.0.1:8080users/{userId}/unfollow/{userIdToUnfollow}

- Criar um a publicação:
  POST 127.0.0.1:8080/products/newpost

- Criar nova publicação promocional:
  POST 127.0.0.1:8080/products/newpromopost

- Contar publicações promocionais de um usuário:
  GET 127.0.0.1:8080/products/{userId}/countPromo/

- Listar todas as publicações promocionais de um usuário:
  GET 127.0.0.1:8080/products/{userId}/list

- Listar todos as publicações promocionais cujos vendedores são seguidos pelo usuário, nas últimas duas semanas:
  GET 127.0.0.1:8080/products/followed/{userId}/list