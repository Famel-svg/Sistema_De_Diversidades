# ─────────────────────────────────────────────
# Stage 1 — Build
# ─────────────────────────────────────────────
FROM maven:3.9.12-eclipse-temurin-21 AS builder

WORKDIR /app

# Cache de dependências (camada separada para rebuild rápido)
COPY pom.xml .
COPY .mvn .mvn
COPY mvnw .
RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline -B

# Copia o código-fonte e empacota
COPY src ./src
RUN ./mvnw clean package -DskipTests -B

# ─────────────────────────────────────────────
# Stage 2 — Runtime (imagem mínima ~180MB)
# ─────────────────────────────────────────────
FROM eclipse-temurin:21-jre-alpine AS runtime

LABEL maintainer="ZippyGo"
LABEL description="Sistema de Diversidades — API RESTful com Spring Boot"

# Usuário não-root para segurança em produção
RUN addgroup -S appgroup && adduser -S appuser -G appgroup
USER appuser

WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080

ENV SPRING_PROFILES_ACTIVE=prod \
    JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0"

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
