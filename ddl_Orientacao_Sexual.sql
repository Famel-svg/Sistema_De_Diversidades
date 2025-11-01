CREATE SEQUENCE seq_padrao START WITH 1 INCREMENT BY 1;

CREATE TABLE orientacao_sexual
(
    cd_osx INTEGER NOT NULL,
    nm_osx VARCHAR2(255),
    CONSTRAINT pk_orientacao_sexual PRIMARY KEY (cd_osx)
);