![Banner AutoBots](img/bannerAutobots.png)

O AutoBots é um sistema de gestão especializado para lojas de manutenção veicular e venda de autopeças. O projeto surge em um cenário de alta demanda e valorização do mercado de veículos usados no Brasil, onde a agilidade na gestão e a excelência no atendimento ao cliente tornaram-se diferenciais competitivos essenciais.

Nesta versão, o foco está no módulo de cadastro e gestão de clientes, com persistência de dados como endereço, documentos e telefones.

## Tecnologias utilizadas

- Java 17
- Spring Boot 2.6.3
- Maven (via Maven Wrapper)
- MySQL
- Postman (para testes de API)

## Requisitos para rodar

- JDK 17 instalado e configurado no PATH
- MySQL Server (recomendado 8.x)
- Git
- Postman (Desktop ou Web)

## Como rodar o projeto

### 1) Clonar o repositório

```bash
git clone https://github.com/SarahBatagioti/AV1-DWIII.git
```

### 2) Entrar na pasta do projeto

```bash
cd AV1-DWIII/automanager
```

### 3) Configurar o banco MySQL

As configurações ficam em `src/main/resources/application.properties`.

Propriedades atuais:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/AV1?createDatabaseIfNotExist=true&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=fatec
spring.jpa.hibernate.ddl-auto=update
```

Ajuste `username` e `password` conforme o seu ambiente.

### 4) Rodar a aplicação

No Windows (PowerShell/CMD):

```bash
mvnw.cmd spring-boot:run
```

No Linux/macOS/Git Bash:

```bash
./mvnw spring-boot:run
```

Saída esperada:

- Aplicacao iniciada em `http://localhost:8080`
- Banco `AV1` criado automaticamente (se não existir)
- Um cliente de exemplo pode ser inserido automaticamente na primeira execução

## Como testar os endpoints da API

Para testar todos os endpoints da API de forma completa, consulte o guia detalhado com exemplos prontos para copiar e colar:

👉 [Clique aqui para ver exemplos completos de todas as requisições](EXEMPLOS_API.md)
