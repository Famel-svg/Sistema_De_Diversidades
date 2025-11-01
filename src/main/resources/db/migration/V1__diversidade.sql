DROP TABLE T_BS_GENERO CASCADE CONSTRAINTS;
DROP TABLE T_BS_RACA_ETNIA CASCADE CONSTRAINTS;
DROP TABLE T_BS_INICIATIVAS CASCADE CONSTRAINTS;
DROP TABLE T_BS_FUNCIONARIOS CASCADE CONSTRAINTS;
DROP TABLE T_BS_ORIENTACAO_SEXUAL CASCADE CONSTRAINTS;
DROP TABLE GENERO CASCADE CONSTRAINTS;
DROP TABLE RACA_ETNIA CASCADE CONSTRAINTS;
DROP TABLE INICIATIVAS CASCADE CONSTRAINTS;
DROP TABLE FUNCIONARIOS CASCADE CONSTRAINTS;
DROP TABLE ORIENTACAO_SEXUAL CASCADE CONSTRAINTS;

CREATE SEQUENCE seq_padrao START WITH 1 INCREMENT BY 1;

CREATE TABLE GENERO (
    cd_genero INTEGER NOT NULL,
    nm_genero VARCHAR2(50),
    PRIMARY KEY (cd_genero)
);

CREATE TABLE T_BS_GENERO (
    cd_genero INTEGER NOT NULL,
    nm_genero VARCHAR2(50),
    PRIMARY KEY (cd_genero)
);

CREATE TABLE RACA_ETNIA (
    cd_raca_etnia INTEGER NOT NULL,
    nm_raca_etnia VARCHAR2(50),
    PRIMARY KEY (cd_raca_etnia)
);

CREATE TABLE T_BS_RACA_ETNIA (
    cd_raca_etnia INTEGER NOT NULL,
    nm_raca_etnia VARCHAR2(50),
    PRIMARY KEY (cd_raca_etnia)
);

CREATE TABLE INICIATIVAS (
    cd_iniciativa INTEGER NOT NULL,
    nm_iniciativa VARCHAR2(100),
    dt_iniciativa DATE,
    tp_iniciativa VARCHAR2(50),
    PRIMARY KEY (cd_iniciativa)
);

CREATE TABLE T_BS_INICIATIVAS (
    cd_iniciativa INTEGER NOT NULL,
    nm_iniciativa VARCHAR2(100),
    dt_iniciativa DATE,
    tp_iniciativa VARCHAR2(50),
    PRIMARY KEY (cd_iniciativa)
);

CREATE TABLE ORIENTACAO_SEXUAL (
    cd_orientacao_sexual INTEGER NOT NULL,
    nm_orientacao VARCHAR2(50),
    PRIMARY KEY (cd_orientacao_sexual)
);

CREATE TABLE T_BS_ORIENTACAO_SEXUAL (
    cd_orientacao_sexual INTEGER NOT NULL,
    nm_orientacao VARCHAR2(50),
    PRIMARY KEY (cd_orientacao_sexual)
);

CREATE TABLE FUNCIONARIOS (
    cd_funcionario INTEGER NOT NULL,
    nm_funcionario VARCHAR2(100),
    dt_contratacao DATE,
    cd_genero INTEGER,
    cd_raca_etnia INTEGER,
    cd_orientacao_sexual INTEGER,
    status_funcionario VARCHAR2(10),
    PRIMARY KEY (cd_funcionario),
    FOREIGN KEY (cd_genero) REFERENCES GENERO(cd_genero),
    FOREIGN KEY (cd_raca_etnia) REFERENCES RACA_ETNIA(cd_raca_etnia),
    FOREIGN KEY (cd_orientacao_sexual) REFERENCES ORIENTACAO_SEXUAL(cd_orientacao_sexual)
);

CREATE TABLE T_BS_FUNCIONARIOS (
    cd_funcionario INTEGER NOT NULL,
    nm_funcionario VARCHAR2(100),
    dt_contratacao DATE,
    cd_genero INTEGER,
    cd_raca_etnia INTEGER,
    cd_orientacao_sexual INTEGER,
    PRIMARY KEY (cd_funcionario),
    FOREIGN KEY (cd_genero) REFERENCES T_BS_GENERO(cd_genero),
    FOREIGN KEY (cd_raca_etnia) REFERENCES T_BS_RACA_ETNIA(cd_raca_etnia),
    FOREIGN KEY (cd_orientacao_sexual) REFERENCES T_BS_ORIENTACAO_SEXUAL(cd_orientacao_sexual)
);

INSERT INTO GENERO VALUES (1, 'Feminino');
INSERT INTO GENERO VALUES (2, 'Masculino');
INSERT INTO GENERO VALUES (3, 'Nao Binario');
INSERT INTO GENERO VALUES (4, 'Nao declarado');

INSERT INTO T_BS_GENERO VALUES (1, 'Feminino');
INSERT INTO T_BS_GENERO VALUES (2, 'Masculino');
INSERT INTO T_BS_GENERO VALUES (3, 'Nao Binario');
INSERT INTO T_BS_GENERO VALUES (4, 'Nao declarado');

INSERT INTO RACA_ETNIA VALUES (1, 'Branca');
INSERT INTO RACA_ETNIA VALUES (2, 'Preta');
INSERT INTO RACA_ETNIA VALUES (3, 'Parda');
INSERT INTO RACA_ETNIA VALUES (4, 'Amarela');
INSERT INTO RACA_ETNIA VALUES (5, 'Indigena');
INSERT INTO RACA_ETNIA VALUES (6, 'Nao declarado');

INSERT INTO T_BS_RACA_ETNIA VALUES (1, 'Branca');
INSERT INTO T_BS_RACA_ETNIA VALUES (2, 'Preta');
INSERT INTO T_BS_RACA_ETNIA VALUES (3, 'Parda');
INSERT INTO T_BS_RACA_ETNIA VALUES (4, 'Amarela');
INSERT INTO T_BS_RACA_ETNIA VALUES (5, 'Indigena');
INSERT INTO T_BS_RACA_ETNIA VALUES (6, 'Nao declarado');

INSERT INTO ORIENTACAO_SEXUAL VALUES (1, 'Heterossexual');
INSERT INTO ORIENTACAO_SEXUAL VALUES (2, 'Homossexual');
INSERT INTO ORIENTACAO_SEXUAL VALUES (3, 'Bissexual');
INSERT INTO ORIENTACAO_SEXUAL VALUES (4, 'Assexual');
INSERT INTO ORIENTACAO_SEXUAL VALUES (5, 'Pansexual');
INSERT INTO ORIENTACAO_SEXUAL VALUES (6, 'Outra');
INSERT INTO ORIENTACAO_SEXUAL VALUES (7, 'Nao declarado');

INSERT INTO T_BS_ORIENTACAO_SEXUAL VALUES (1, 'Heterossexual');
INSERT INTO T_BS_ORIENTACAO_SEXUAL VALUES (2, 'Homossexual');
INSERT INTO T_BS_ORIENTACAO_SEXUAL VALUES (3, 'Bissexual');
INSERT INTO T_BS_ORIENTACAO_SEXUAL VALUES (4, 'Assexual');
INSERT INTO T_BS_ORIENTACAO_SEXUAL VALUES (5, 'Pansexual');
INSERT INTO T_BS_ORIENTACAO_SEXUAL VALUES (6, 'Outra');
INSERT INTO T_BS_ORIENTACAO_SEXUAL VALUES (7, 'Nao declarado');

INSERT INTO INICIATIVAS VALUES (1, 'Workshop de Inclusao', TO_DATE('2025-05-15','YYYY-MM-DD'), 'Treinamento');
INSERT INTO INICIATIVAS VALUES (2, 'Grupo de Afinidade LGBTQIA+', TO_DATE('2025-06-20','YYYY-MM-DD'), 'Comunidade');
INSERT INTO INICIATIVAS VALUES (3, 'Semana da Consciencia Negra', TO_DATE('2025-11-20','YYYY-MM-DD'), 'Evento');
INSERT INTO INICIATIVAS VALUES (4, 'Mentoria para Mulheres', TO_DATE('2025-08-01','YYYY-MM-DD'), 'Desenvolvimento');
INSERT INTO INICIATIVAS VALUES (5, 'Programa de Talentos Diversos', TO_DATE('2025-09-10','YYYY-MM-DD'), 'Recrutamento');

INSERT INTO T_BS_INICIATIVAS VALUES (1, 'Workshop de Inclusao', TO_DATE('2025-05-15','YYYY-MM-DD'), 'Treinamento');
INSERT INTO T_BS_INICIATIVAS VALUES (2, 'Grupo de Afinidade LGBTQIA+', TO_DATE('2025-06-20','YYYY-MM-DD'), 'Comunidade');
INSERT INTO T_BS_INICIATIVAS VALUES (3, 'Semana da Consciencia Negra', TO_DATE('2025-11-20','YYYY-MM-DD'), 'Evento');
INSERT INTO T_BS_INICIATIVAS VALUES (4, 'Mentoria para Mulheres', TO_DATE('2025-08-01','YYYY-MM-DD'), 'Desenvolvimento');
INSERT INTO T_BS_INICIATIVAS VALUES (5, 'Programa de Talentos Diversos', TO_DATE('2025-09-10','YYYY-MM-DD'), 'Recrutamento');

INSERT INTO FUNCIONARIOS VALUES (1, 'Joao Requejo', TO_DATE('2024-03-10','YYYY-MM-DD'), 2, 1, 1, 'Ativo');
INSERT INTO FUNCIONARIOS VALUES (2, 'Hanelore Seydel', TO_DATE('2024-04-15','YYYY-MM-DD'), 1, 1, 2, 'Ativo');
INSERT INTO FUNCIONARIOS VALUES (3, 'Lucas Manica', TO_DATE('2024-05-20','YYYY-MM-DD'), 2, 1, 1, 'Ativo');
INSERT INTO FUNCIONARIOS VALUES (4, 'Pedro Arthur Saldanha', TO_DATE('2024-06-01','YYYY-MM-DD'), 2, 1, 1, 'Ativo');

INSERT INTO T_BS_FUNCIONARIOS VALUES (1, 'Joao Requejo', TO_DATE('2024-03-10','YYYY-MM-DD'), 2, 1, 1);
INSERT INTO T_BS_FUNCIONARIOS VALUES (2, 'Hanelore Seydel', TO_DATE('2024-04-15','YYYY-MM-DD'), 1, 1, 2);
INSERT INTO T_BS_FUNCIONARIOS VALUES (3, 'Lucas Manica', TO_DATE('2024-05-20','YYYY-MM-DD'), 2, 1, 1);
INSERT INTO T_BS_FUNCIONARIOS VALUES (4, 'Pedro Arthur Saldanha', TO_DATE('2024-06-01','YYYY-MM-DD'), 2, 1, 1);

COMMIT;

CREATE OR REPLACE TRIGGER trg_backup_funcionarios
AFTER INSERT ON FUNCIONARIOS
FOR EACH ROW
BEGIN
    INSERT INTO T_BS_FUNCIONARIOS (
        cd_funcionario, nm_funcionario, dt_contratacao, cd_genero, cd_raca_etnia, cd_orientacao_sexual
    ) VALUES (
        :NEW.cd_funcionario, :NEW.nm_funcionario, :NEW.dt_contratacao, :NEW.cd_genero, :NEW.cd_raca_etnia, :NEW.cd_orientacao_sexual
    );
END;
/

CREATE OR REPLACE TRIGGER trg_alerta_iniciativas
AFTER INSERT OR UPDATE ON INICIATIVAS
FOR EACH ROW
DECLARE
    v_diff NUMBER;
BEGIN
    v_diff := :NEW.dt_iniciativa - SYSDATE;
    IF v_diff <= 7 THEN
        INSERT INTO T_BS_INICIATIVAS (
            cd_iniciativa, nm_iniciativa, dt_iniciativa, tp_iniciativa
        ) VALUES (
            :NEW.cd_iniciativa, :NEW.nm_iniciativa, :NEW.dt_iniciativa, :NEW.tp_iniciativa
        );
    END IF;
END;
/

CREATE OR REPLACE TRIGGER trg_status_funcionario
BEFORE INSERT OR UPDATE ON FUNCIONARIOS
FOR EACH ROW
BEGIN
    IF :NEW.dt_contratacao <= SYSDATE THEN
        :NEW.status_funcionario := 'Ativo';
    ELSE
        :NEW.status_funcionario := 'Inativo';
    END IF;
END;
/

CREATE OR REPLACE TRIGGER trg_sync_iniciativas
AFTER UPDATE ON INICIATIVAS
FOR EACH ROW
BEGIN
    UPDATE T_BS_INICIATIVAS
        SET nm_iniciativa = :NEW.nm_iniciativa,
            dt_iniciativa = :NEW.dt_iniciativa,
            tp_iniciativa = :NEW.tp_iniciativa
      WHERE cd_iniciativa = :NEW.cd_iniciativa;
END;
/

SET SERVEROUTPUT ON;

BEGIN
  FOR func IN (SELECT nm_funcionario FROM FUNCIONARIOS) LOOP
    DBMS_OUTPUT.PUT_LINE('Nome: ' || func.nm_funcionario);
  END LOOP;
END;
/