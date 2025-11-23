# Portability API

Projeto demo para Spring Boot com MongoDB, JWT, OpenAPI e integração com modelos de IA (Spring AI).

## Tecnologias Utilizadas

- Java 21
- Spring Boot 3.5.7
- MongoDB
- Spring Security (JWT)
- Springdoc OpenAPI (Swagger)
- Spring AI (OpenAI)
- Docker
- NQLBooster
- JUnit 5 / Mockito

---

## Como subir a aplicação

### 1. Configuração de Variáveis de Ambiente

Crie um arquivo `.env` na raiz do projeto ou defina as variáveis diretamente no ambiente.

**
Exemplo de
`.env`
:
**
```env
SPRING_DATA_MONGODB_URI=mongodb://mongo:27017/portability
OPENAI_API_KEY=YOUR_OPENAI_KEY
JWT_SECRET=YOUR_SECRET_KEY
```

No `docker-compose.yml`, as variáveis já estão referenciadas para o container `java_app`.

---

### 2. Subindo a Aplicação com Docker

Certifique-se de ter o Docker instalado.

Clone o repositório:
```bash
git clone https://github.com/seu-usuario/Portability.git
cd Portability
```

Suba os containers:
```bash
docker-compose up --build
```

Isso irá subir:
- MongoDB (`mongo`)
- NQLBooster (`nqlbooster`)
- Aplicação Java (`java_app`)

---

### 3. Configuração do MongoDB

Certifique-se de que o MongoDB está rodando localmente (`mongodb://localhost:27017`) ou ajuste a URI no arquivo `src/main/resources/application.properties`:
```properties
spring.data.mongodb.uri=mongodb://localhost:27017/portability
```

---

### 4. Configuração de Variáveis de Ambiente (se necessário)

Exemplo: chave do OpenAI, segredo JWT, etc.  
Você pode criar um arquivo `.env` ou definir diretamente no `application.properties`.

---

## **Pré-requisitos**

1. Ter o StackSpot CLI instalado.
2. Clonar o repositório deste plugin.
3. Ter uma aplicação HTML base criada.

## **Uso**

### **Entradas**

- **table_id**: Nome da tabela que será gerada (ex: product-list)
- **column_list**: Colunas da tabela separadas por ';' (ex: ID;TITLE;DESCRIPTION)
- **attr_list**: Atributos das colunas na mesma ordem do column_list (ex: id;title;description)

### **Como aplicar**

1. No diretório da sua aplicação, execute:
    ```bash
    stk apply plugin /caminho/para/dummy-json-plugin
    ```
2. Preencha os campos solicitados conforme necessário.

### **Métodos**

- O plugin insere automaticamente o HTML da tabela, importa o CSS e o JavaScript necessários para funcionamento dinâmico.

### **Recursos**

- Snippets para importação de CSS, JS e criação da tabela.
- Templates prontos para estilização e lógica da tabela.

## **Dependências**

- Nenhuma dependência externa obrigatória.

## **Release Notes**

### dummy-json-plugin v1.0.0

- Adicionada geração automática de tabela com integração de CSS e JS.
- Inputs configuráveis para nome, colunas e atributos da tabela.

---

> [!TIP]
> Para mais detalhes, consulte a [documentação oficial da StackSpot](https://docs.stackspot.com/) ou o arquivo `plugin.yaml` deste repositório.# Nome do Plugin/Stack/Action/Starter

Descreva de forma clara e breve o objetivo deste conteúdo.  
Exemplo:  
> Este Plugin adiciona uma tabela dinâmica de produtos em páginas HTML, integrando CSS e JavaScript automaticamente.

## Pré-requisitos

- Liste todos os itens e ações necessárias antes de aplicar este conteúdo.  
Exemplo:
1. Ter o StackSpot CLI instalado.
2. Clonar o repositório deste plugin.
3. Ter uma aplicação HTML base criada.

## Uso

Descreva as etapas para utilizar este conteúdo:

### Entradas

- **table_id**: Nome da tabela que será gerada (ex: product-list)
- **column_list**: Colunas da tabela separadas por ';' (ex: ID;TITLE;DESCRIPTION)
- **attr_list**: Atributos das colunas na mesma ordem do column_list (ex: id;title;description)

### Como aplicar

1. No diretório da sua aplicação, execute:
   ```bash
   stk apply plugin /caminho/para/dummy-json-plugin
   ```
2. Preencha os campos solicitados conforme necessário.

3. Configure as variáveis de ambiente no seu arquivo `.env`:
   ```
   openai.api.key=YOUR_OPENAI_KEY
   jwt.secret=YOUR_SECRET_KEY
   ```

4. Build e execute a aplicação:
   ```bash
   ./mvnw spring-boot:run
   ```

5. Acesse a documentação da API:
   [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

---

### Fluxo de Funcionamento da API

- **Autenticação**
  - O usuário faz login via `/auth/login` e recebe um token JWT.
  - O token deve ser enviado no header `Authorization` para acessar endpoints protegidos.

- **Operações CRUD**
  - A API expõe endpoints REST para manipulação de recursos (exemplo: `/api/portabilities`).
  - As operações são protegidas por autenticação JWT.

- **Integração com IA**
  - Alguns endpoints podem utilizar o Spring AI para processar dados usando modelos do OpenAI.

- **Persistência**
  - Os dados são armazenados no MongoDB.

- **Documentação**
  - Todos os endpoints estão documentados via OpenAPI/Swagger.

---

### Exemplo de Requisição

**Autenticação**
```http
POST /auth/login
Content-Type: application/json

{
  "username": "usuario",
  "password": "senha"
}
```

**Resposta:**
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6..."
}
```

**Requisição autenticada**
```http
GET /api/portabilities
Authorization: Bearer <token>
```

---

### Testes

Execute os testes com:
```bash
./mvnw test
```

---

### Contribuição

Pull requests são bem-vindos!

---

### Licença

MIT