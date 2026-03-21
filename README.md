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


## Testando a API com Postman

Base URL:

```text
http://localhost:8080
```

### Endpoints de cliente

- `GET /clientes` -> Lista todos os clientes
- `GET /clientes/{id}` -> Busca cliente por ID
- `POST /clientes` -> Cadastra cliente
- `PUT /clientes` -> Atualiza cliente
- `DELETE /clientes/{id}` -> Remove cliente

### Exemplo de body para cadastrar cliente (`POST /clientes`)

```json
{
  "nome": "Maria Oliveira",
  "nomeSocial": "Maria O.",
  "dataNascimento": "1995-08-20T00:00:00.000+00:00",
  "endereco": {
    "estado": "SP",
    "cidade": "São Paulo",
    "bairro": "Centro",
    "rua": "Rua das Oficinas",
    "numero": "120",
    "codigoPostal": "01001000",
    "informacoesAdicionais": "Próximo ao pátio de serviços"
  },
  "documentos": [
    {
      "tipo": "RG",
      "numero": "123456789"
    },
    {
      "tipo": "CPF",
      "numero": "12345678901"
    }
  ],
  "telefones": [
    {
      "ddd": "11",
      "numero": "987654321"
    }
  ]
}
```

### Exemplo de body para atualizar cliente (`PUT /clientes`)

```json
{
  "id": 1,
  "nome": "Maria Oliveira",
  "nomeSocial": "Maria Oliveira",
  "dataNascimento": "1995-08-20T00:00:00.000+00:00",
  "endereco": {
    "estado": "SP",
    "cidade": "São Paulo",
    "bairro": "Vila Mariana",
    "rua": "Rua Nova",
    "numero": "200",
    "codigoPostal": "04001000",
    "informacoesAdicionais": "Casa"
  },
  "documentos": [
    {
      "id": 1,
      "tipo": "RG",
      "numero": "123456789"
    }
  ],
  "telefones": [
    {
      "id": 1,
      "ddd": "11",
      "numero": "999999999"
    }
  ]
}
```

