CREATE DATABASE javachallenge;
\c javachallenge;
CREATE TABLE persons (
    id              SERIAL          NOT NULL PRIMARY KEY,
    name            VARCHAR(80)     NOT NULL,
    gender          CHAR(1)         NULL,
    email           VARCHAR(80)     NULL,
    birth_date      DATE            NOT NULL,
    naturalness     VARCHAR(50)     NULL,
    nationality     VARCHAR(50)     NULL,
    cpf             VARCHAR(11)     NULL,
    created_at      TIMESTAMP       NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at      TIMESTAMP       NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT cpf_unique UNIQUE (cpf),
    constraint gender_check check (gender in ('M','F', 'O'))
);

COMMENT ON COLUMN persons.id IS 'Person unique ID.';
COMMENT ON COLUMN persons.name IS 'Name of a person.';
COMMENT ON COLUMN persons.gender IS 'Gender of a person. (M=Male, F=Female, O=Other)';
COMMENT ON COLUMN persons.email IS 'E-mail of a person.';
COMMENT ON COLUMN persons.birth_date IS 'Birthdate of a person.';
COMMENT ON COLUMN persons.naturalness IS 'Naturalness of a person.';
COMMENT ON COLUMN persons.nationality IS 'Nationality of a person.';
COMMENT ON COLUMN persons.cpf IS 'CPF of a person.';
COMMENT ON COLUMN persons.created_at IS 'Creation date of the person.';
COMMENT ON COLUMN persons.updated_at IS 'Date the person was last updated.';

CREATE OR REPLACE FUNCTION trigger_set_timestamp()
RETURNS TRIGGER AS $$
BEGIN
  NEW.updated_at = NOW();
  RETURN NEW;
  END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER set_timestamp
BEFORE UPDATE ON persons
FOR EACH ROW
EXECUTE PROCEDURE trigger_set_timestamp();

INSERT INTO persons (name, gender, email, birth_date, naturalness, nationality, cpf) VALUES ('Vitor Lima', 'M', 'vitor@gmail.com', '1980-01-01', 'FLORIANOPOLIS', 'BRAZILIAN','58801550057');
INSERT INTO persons (name, gender, email, birth_date, naturalness, nationality, cpf) VALUES ('Lohana Cristina', 'F', 'lohana@gmail.com', '1980-01-01', 'FLORIANOPOLIS', 'BRAZILIAN','17179424072');
