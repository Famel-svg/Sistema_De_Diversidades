# ─────────────────────────────────────────────
# Stage 1 — Build
# ─────────────────────────────────────────────
FROM maven:3.9.12-eclipse-temurin-17 AS builder

WORKDIR /app

# Cache de dependências (camada separada)
COPY pom.xml .
COPY .mvn .mvn
COPY mvnw .
RUN chmod +x mvnw

# Baixa dependências offline
RUN ./mvnw dependency:go-offline -B

# Copia código
COPY src ./src

# 🔴 CORREÇÃO CRÍTICA — encoding real para UTF-8
RUN find src/main/resources -type f \( -name "*.properties" -o -name "*.yml" -o -name "*.yaml" \) \
    -exec sh -c 'iconv -f ISO-8859-1 -t UTF-8 "$1" -o "$1.tmp" && mv "$1.tmp" "$1"' _ {} \;

# Build
RUN ./mvnw clean package -DskipTests -B

# ─────────────────────────────────────────────
# Stage 2 — Runtime
# ─────────────────────────────────────────────
FROM eclipse-temurin:17-jre-alpine AS runtime

LABEL maintainer="ZippyGo"
LABEL description="Sistema de Diversidades — API RESTful com Spring Boot"

# Usuário não-root
RUN addgroup -S appgroup && adduser -S appuser -G appgroup
USER appuser

WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080

ENV SPRING_PROFILES_ACTIVE=prod \
    JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0"

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
