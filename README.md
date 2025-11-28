# 📘 *Projeto Curso (API de Gerenciamento de Disciplinas)*

## 📌 Sobre o Projeto

Este é um projeto *Spring Boot 3.5.8* desenvolvido em Java 21 que implementa uma API REST para gerenciamento de *Disciplinas*.
A API permite criar, listar, atualizar, alterar categoria e remover disciplinas.

Foi construído usando:

* Spring Boot Web
* Spring Data JPA
* MySQL
* Lombok
* Validation


## 📂 *Estrutura do Projeto*
```
src/main/java/com/henrique/curso/
│
├── controller/
│   └── DisciplinaController.java
│
├── dto/
│   └── DisciplinaRecordDto.java
│
├── enums/
│   └── CategoriaDisciplina.java
│
├── model/
│   └── DisciplinaModel.java
│
├── repository/
│   └── DisciplinaRepository.java
│
├── service/
│   ├── DisciplinaService.java
│   └── impl/
│       └── DisciplinaServiceImpl.java
```

## 🛠 *Tecnologias Utilizadas*

| Tecnologia  | Versão |
| ----------- | ------ |
| Java        | 21     |
| Spring Boot | 3.5.8  |
| Maven       | 3.x    |
| MySQL       | 8+     |


# ⚙️ *Configuração do Projeto*

## *1. Configure o Banco de Dados MySQL*

Crie o banco:

sql
CREATE DATABASE curso;


## *2. Configure o application.yml*

Exemplo recomendado:

yaml
server:
  port: 8080
  servlet:
    context-path: /curso/

spring:
  datasource:
    url: jdbc:mysql://localhost:3306/curso_db?useSSL=false&serverTimezone=UTC
    username: root
    password: SUA_SENHA
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    database-platform: org.hibernate.dialect.MySQLDialect


# 🚀 *Executando o Projeto*

### Via Maven

bash
mvn spring-boot:run


### Compilando JAR

bash
mvn clean package
java -jar target/curso-0.0.1-SNAPSHOT.jar


A API estará disponível em:

http://localhost:8080/curso/


# 📡 *Endpoints da API*

Base URL:

http://localhost:8080/curso/disciplina


## 📌 *1. Criar nova disciplina*

### *POST* /curso/disciplina

#### Body JSON:

json
{
  "titulo": "Lógica de programação",
  "descricao": "Nessa disciplina trabalharemos o pensamento computacional.",
  "categoriaDisciplina": "PRESENCIAL"
}


## 📌 *2. Listar todas as disciplinas*

### *GET* /curso/disciplina


## 📌 *3. Buscar disciplina por ID*

### *GET* /curso/disciplina/disciplinaId/{disciplinaId}


## 📌 *4. Atualizar disciplina (PUT)*

### *PUT* /curso/disciplina/{disciplinaId}

#### Body:

json
{
  "titulo": "Frameworks",
  "descricao": "Desenvolvimento de softwares com Frameworks",
  "categoriaDisciplina": "SEMIPRESENCIAL"
}


## 📌 *5. Atualizar somente titulo, descricao e/ou categoriaDisciplina (PATCH)*

### *PATCH* /curso/disciplina/{disciplinaId}

#### Body:

json
{
  "categoriaDisciplina": "SEMIPRESENCIAL"
}


## 📌 *6. Deletar disciplina*

### *DELETE* /curso/disciplina/{disciplinaId}

Retorno esperado:

204 NO CONTENT


# ⌨️ Testando no Postman

Use os endpoints conforme acima.

Para testar o POST, configure:

* *Method:* POST
* *URL:* http://localhost:8080/curso/disciplina
* *Body → Raw → JSON*
* Insira o JSON do DTO


# 📦 *Dependências (pom.xml)*

Esse projeto utiliza:

xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>

<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <scope>runtime</scope>
</dependency>

<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <optional>true</optional>
</dependency>


# 💻 Autor

*Pedro Henrique*
Projeto de estudo seguindo roadmap Java + Spring Boot.


## 📄 Licença
Este projeto está licenciado sob a Apache License 2.0 — veja o arquivo LICENSE para mais detalhes.
