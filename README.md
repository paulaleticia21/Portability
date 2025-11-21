# Portability API

Projeto demo para Spring Boot com MongoDB, JWT, OpenAPI e integração com modelos de IA (Spring AI).

## Tecnologias Utilizadas

- Java 25
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

## 1. Configuração de Variáveis de Ambiente

Crie um arquivo `.env` na raiz do projeto ou defina as variáveis diretamente no ambiente.

Exemplo de `.env`:

```env
SPRING_DATA_MONGODB_URI=mongodb://mongo:27017/portability
OPENAI_API_KEY=YOUR_OPENAI_KEY
JWT_SECRET=YOUR_SECRET_KEY
```
No `docker-compose.yml`, as variáveis já estão referenciadas para o container `java_app`.

---

## 2. Subindo a Aplicação com Docker

Certifique-se de ter o [
Docker
](https://www.docker.com/) instalado

. **Clone o repositório:**
   ```bash
   git clone https://github.com/seu-usuario/Portability.git
   cd Portability
   ```
Suba os containers:
**
```bash
docker-compose up --build
```
Isso irá subir:
- MongoDB (`mongo`)
- NQLBooster (`nqlbooster`)
- Aplicação Java (`java_app`)


. **Configure o MongoDB:**
- Certifique-se de que o MongoDB está rodando localmente (`mongodb://localhost:27017`) ou ajuste a URI no arquivo `src/main/resources/application.properties`:
  ```
  spring.data.mongodb.uri=mongodb://localhost:27017/portability
  ```

. **Configure variáveis de ambiente (se necessário):**
- Exemplo: chave do OpenAI, segredo JWT, etc.
- Você pode criar um arquivo `.env` ou definir no próprio `application.properties`:
  ```
  openai.api.key=YOUR_OPENAI_KEY
  jwt.secret=YOUR_SECRET_KEY
  ```

. **Build e execute a aplicação:**
   ```bash
   ./mvnw spring-boot:run
   ```

. **Acesse a documentação da API:**
- [http://localhost:8080/swagger-ui/index.html]


---

## Fluxo de Funcionamento da API

. **Autenticação**
- O usuário faz login via `/auth/login` e recebe um token JWT.
- O token deve ser enviado no header `Authorization` para acessar endpoints protegidos.

. **Operações CRUD**
- A API expõe endpoints REST para manipulação de recursos (exemplo: `/api/portabilities`).
- As operações são protegidas por autenticação JWT.

. **Integração com IA**
- Alguns endpoints podem utilizar o Spring AI para processar dados usando modelos do OpenAI.

. **Persistência**
- Os dados são armazenados no MongoDB.

. **Documentação**
- Todos os endpoints estão documentados via OpenAPI/Swagger.

---

## Exemplo de Requisição

### Autenticação

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

### Requisição autenticada

```http
GET /api/portabilities
Authorization: Bearer <token>
```

---

## Testes

Execute os testes com:
```bash
./mvnw test
```

---

## Contribuição

Pull requests são bem-vindos!

---

## Licença

MIT
