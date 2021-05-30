# API para registrar as movimentações financeiras do usuário






<!-- ABOUT THE PROJECT -->
## Sobre a API

Simples API para registrar a movimentação financeira do usuário<br/>
A API utiliza JWT para atenticação do usuário após realizar o cadastro<br/>
<br/>
Tecnologias que devem ser usadas<br/>
* Java 8
* Spring Boot 2.4.3
* PostgreSql 9

## Endpoint Login:<br/>
POST:<br/>
Solicita acesso a API: /api/v1/login

## Endpoints Usuário:<br/>
GET:<br/>
Lista todos os usuário: /api/v1/usuario<br/>
Lista usuário por ID: /api/v1/usuario/{id}
<br/>
<br/>
POST:<br/>
Insere um novo usuário /api/v1/usuario [Não necessita de autenticação]<br/><br/>
PUT:<br/>
Atualiza um novo usuário /api/v1/usuario<br/><br/>
DELETE:<br/>
Remove um usuário /api/v1/usuario


## Endpoints Categoria:<br/>
GET:<br/>
Lista todas as categorias: /api/v1/categoria<br/>
Lista categoria por ID: /api/v1/categoria/{id}<br/>
Lista categoria por nome: /api/v1/categoria/getByNome/{nome}
<br/>
<br/>
POST:<br/>
Insere uma nova categoria /api/v1/categoria<br/><br/>
PUT:<br/>
Atualiza uma nova categoria /api/v1/categoria<br/><br/>
DELETE:<br/>
Remove uma categoria /api/v1/categoria

## Endpoints Movimentação:<br/>
GET:<br/>
Lista todas as movimentações: /api/v1/entrada<br/>
Lista movimentação por ID: /api/v1/entrada/{id}<br/>
Lista movimentação por nome: /api/v1/entrada/getByNome/{nome}
<br/>
<br/>
POST:<br/>
Insere uma nova movimentação /api/v1/entrada<br/><br/>
PUT:<br/>
Atualiza uma nova movimentação /api/v1/entrada<br/><br/>
DELETE:<br/>
Remove uma movimentação /api/v1/entrada


<!-- GETTING STARTED -->
## Começando

* Faça checkout deste projeto
* Abra em uma IDE de sua preferência
* Execute o maven para baixar as depedências.

### Pre-requisitos

* PostgreSql 9<br/>
* Java 8 ou Superior


## Como Usar

* Acesse o arquivo application.properties altere as properties para sua conexao:
```JS 
spring.datasource.url=jdbc:postgresql://localhost:5432/SUA_BASE
spring.datasource.username=?????
spring.datasource.password=?????
 ```
* Para criar as tabelas, deixe a propertie abaixo como update
```JS 
spring.jpa.hibernate.ddl-auto=update
 ```
* Compile o projeto na IDE de sua preferência e siga para a pasta target
* Execute o comando:
```JS
  java -jar financeiro-0.0.1-SNAPSHOT.jar;
   ```
* Abra o navegador e acesse:
```JS
  http://localhost:8080/swagger-ui.html
   ```

* Acesse o endpoint de Login em uma ferramenta de teste de API de sua preferência:
```JS
  http://localhost:8080/api/v1/login 
   ```
* Altere para o method POST e inclua o seguinte JSON na requisição:
```JS
  {
  "username": "usuario criado",
  "password": "senha criada"
  }
   ```

* Copie o Token de retorno, acesse o swagger e informe o token obtido da seguinte forma:
```JS
  Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkZnNkZiIsImV4cCI6MTYyMjM4Nzc2MH0.byoCrUX_g7BTk2tenfmtkv31MNJbMCOBpx9P1eYSBfcFKOZNUJMv-3I87VayY01ticsSIVEPh0EDbQxuoR-bhA
   ```
* Agora você poderá realizar as requisições normalmente para os endpoints que necessitam de autenticação.
<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/othneildrew/Best-README-Template.svg?style=for-the-badge
[contributors-url]: https://github.com/othneildrew/Best-README-Template/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/othneildrew/Best-README-Template.svg?style=for-the-badge
[forks-url]: https://github.com/othneildrew/Best-README-Template/network/members
[stars-shield]: https://img.shields.io/github/stars/othneildrew/Best-README-Template.svg?style=for-the-badge
[stars-url]: https://github.com/othneildrew/Best-README-Template/stargazers
[issues-shield]: https://img.shields.io/github/issues/othneildrew/Best-README-Template.svg?style=for-the-badge
[issues-url]: https://github.com/othneildrew/Best-README-Template/issues
[license-shield]: https://img.shields.io/github/license/othneildrew/Best-README-Template.svg?style=for-the-badge
[license-url]: https://github.com/othneildrew/Best-README-Template/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/othneildrew
[product-screenshot]: images/screenshot.png