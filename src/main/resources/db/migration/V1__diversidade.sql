-- ============================================
-- CREATE SEQUENCE
-- ============================================
CREATE SEQUENCE seq_padrao START WITH 1 INCREMENT BY 1;

-- ============================================
-- CREATE TABLES
-- ============================================
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

CREATE TABLE FUNCIONARIO (
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

-- ============================================
-- INSERT DATA
-- ============================================
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

INSERT INTO FUNCIONARIO VALUES (1, 'Joao Requejo', TO_DATE('2024-03-10','YYYY-MM-DD'), 2, 1, 1, 'Ativo');
INSERT INTO FUNCIONARIO VALUES (2, 'Hanelore Seydel', TO_DATE('2024-04-15','YYYY-MM-DD'), 1, 1, 2, 'Ativo');
INSERT INTO FUNCIONARIO VALUES (3, 'Lucas Manica', TO_DATE('2024-05-20','YYYY-MM-DD'), 2, 1, 1, 'Ativo');
INSERT INTO FUNCIONARIO VALUES (4, 'Pedro Arthur Saldanha', TO_DATE('2024-06-01','YYYY-MM-DD'), 2, 1, 1, 'Ativo');

INSERT INTO T_BS_FUNCIONARIOS VALUES (1, 'Joao Requejo', TO_DATE('2024-03-10','YYYY-MM-DD'), 2, 1, 1);
INSERT INTO T_BS_FUNCIONARIOS VALUES (2, 'Hanelore Seydel', TO_DATE('2024-04-15','YYYY-MM-DD'), 1, 1, 2);
INSERT INTO T_BS_FUNCIONARIOS VALUES (3, 'Lucas Manica', TO_DATE('2024-05-20','YYYY-MM-DD'), 2, 1, 1);
INSERT INTO T_BS_FUNCIONARIOS VALUES (4, 'Pedro Arthur Saldanha', TO_DATE('2024-06-01','YYYY-MM-DD'), 2, 1, 1);