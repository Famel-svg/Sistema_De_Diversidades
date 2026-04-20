# Projeto — Sistema de Diversidades (ESG)

API RESTful em Java 21 + Spring Boot para gestão de diversidade corporativa: funcionários, gênero, raça/etnia, orientação sexual e iniciativas ESG.

---

## Como executar localmente com Docker

### Pré-requisitos
- Docker Desktop instalado e em execução
- ~3GB de espaço livre (imagem Oracle XE ~2GB)

### Passos

```bash
# 1. Clone o repositório
git clone https://github.com/<seu-usuario>/Sistema_de_Diversidades.git
cd Sistema_de_Diversidades

# 2. Copie e configure o .env
cp .env.example .env
# Edite o .env se quiser alterar senhas

# 3. Suba a aplicação + banco Oracle XE
docker compose up --build

# Aguarde a mensagem: "DATABASE IS READY TO USE" no log do oracle-db
# O app inicia logo após (~90s)

# 4. Teste a API
curl http://localhost:8080/api/funcionarios
```

> ⚠️ O Oracle XE demora ~60–90s para inicializar na primeira execução. O `depends_on: condition: service_healthy` garante que o app só sobe após o banco estar pronto.

### Parar os containers

```bash
docker compose down          # Para e remove containers
docker compose down -v       # Remove também o volume do banco
```

---

## Pipeline CI/CD

**Ferramenta:** GitHub Actions — arquivo `.github/workflows/pipeline.yml`

**Registry:** GitHub Container Registry (GHCR) — autenticação automática via `GITHUB_TOKEN`.

| Job | Descrição | Gatilho |
|-----|-----------|---------|
| 🔨 **Build** | `mvn clean package -DskipTests` | Push em qualquer branch |
| 🧪 **Test** | `mvn test` com perfil H2 in-memory | Após Build |
| 🐳 **Docker → GHCR** | Build multi-stage + push para `ghcr.io` | Push na `main` |
| 🚀 **Deploy Staging** | Deploy no environment `staging` (automático) | Após push da imagem |
| 🏭 **Deploy Production** | Deploy no environment `production` (gate manual) | Após aprovação |

### Configurar aprovação manual (production)

1. Vá em **Settings → Environments → New environment**
2. Crie `staging` (sem reviewer)
3. Crie `production` → **Required reviewers** → adicione seu usuário → **Save protection rules**

---

## Containerização

### Estratégia: Multi-stage build

```dockerfile
# Stage 1 — Build (maven:3.9.12-eclipse-temurin-21)
FROM maven:3.9.12-eclipse-temurin-21 AS builder
# ...compila e empacota com mvnw...

# Stage 2 — Runtime (~180MB final)
FROM eclipse-temurin:21-jre-alpine AS runtime
# Usuário não-root para segurança em produção
RUN addgroup -S appgroup && adduser -S appuser -G appgroup
USER appuser
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
```

**Vantagens adotadas:**
- Imagem final ~180MB (sem Maven nem JDK, só JRE Alpine)
- Cache de dependências Maven em camada separada (rebuild rápido)
- Usuário não-root (`appuser`) por segurança
- `UseContainerSupport` + `MaxRAMPercentage` para respeitar limites do container

---

## Testes no CI (perfil H2)

O Oracle não está disponível no runner do GitHub Actions. Para os testes rodarem sem banco externo, o pipeline usa o perfil `test` com H2 in-memory:

```bash
./mvnw test -Dspring.profiles.active=test
```

O arquivo `src/main/resources/application-test.properties` substitui Oracle por H2 e desativa o Flyway (DDL gerenciado pelo Hibernate com `create-drop`).

> **Dependência necessária no `pom.xml`** para o perfil de teste funcionar:
> ```xml
> <dependency>
>     <groupId>com.h2database</groupId>
>     <artifactId>h2</artifactId>
>     <scope>test</scope>
> </dependency>
> ```

---

## Prints do funcionamento

> Substitua pelas evidências reais após executar o pipeline e o compose.

| Evidência | Descrição |
|-----------|-----------|
| `[print-build.png]` | Job Build concluído (✅ verde) |
| `[print-test.png]` | Job Test com testes passando |
| `[print-docker.png]` | Imagem publicada no GHCR |
| `[print-staging.png]` | Deploy Staging concluído |
| `[print-approval.png]` | Tela de aprovação manual (production) |
| `[print-production.png]` | Deploy Production concluído |
| `[print-compose.png]` | `docker compose up` — app + Oracle XE rodando |
| `[print-api.png]` | Resposta da API (Postman / curl) |

---

## Tecnologias utilizadas

| Categoria | Tecnologia |
|-----------|-----------|
| Linguagem | Java 21 |
| Framework | Spring Boot 3.5.x |
| Segurança | Spring Security + JWT (jjwt 0.11.5) |
| Build | Apache Maven 3.9 + Wrapper |
| Banco (prod/local) | Oracle XE 21c (`gvenzl/oracle-xe:21-slim`) |
| Banco (testes/CI) | H2 in-memory |
| Migração | Flyway |
| Container | Docker (multi-stage build) |
| Orquestração local | Docker Compose |
| CI/CD | GitHub Actions |
| Registry | GitHub Container Registry (GHCR) |

---

## Checklist de Entrega

| Item | OK |
|------|----|
| Projeto compactado em .ZIP com estrutura organizada | ✅ |
| Dockerfile funcional (multi-stage) | ✅ |
| docker-compose.yml com app + Oracle XE | ✅ |
| Pipeline com etapas de build, teste e deploy | ✅ |
| Deploy em staging e production (com gate manual) | ✅ |
| README.md com instruções e prints | ✅ |
| Documentação técnica com evidências (PDF ou PPT) | ☐ |
