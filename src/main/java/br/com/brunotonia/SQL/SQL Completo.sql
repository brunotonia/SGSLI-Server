/* DROP TABLE */
DROP TABLE usuario;
DROP TABLE usuario_tipo;
DROP TABLE instalacao;
DROP TABLE remocao;
DROP TABLE pacotes;
DROP TABLE pacotes_categoria;
/*DROP TRIGGER tr_categorias;*/
/*DROP FUNCTION categorias();*/
DROP TABLE repositorio;
DROP TABLE repositorio_security;
DROP TABLE repositorio_tipo;
DROP TABLE versao;
DROP TRIGGER tr_versao_sources_security;
DROP TRIGGER tr_versao_sources;
DROP FUNCTION versao_sources();
DROP TRIGGER tr_versao_instalacao;
DROP FUNCTION versao_instalacao();
DROP TRIGGER tr_versao_remocao;
DROP FUNCTION versao_remocao();
DROP TRIGGER tr_inserir_instalacao;
DROP TRIGGER tr_inserir_remocao;
DROP FUNCTION inserir_instalacao_remocao();

/* Tabelas usaurio e usuario_tipo */
CREATE TABLE usuario_tipo(id serial PRIMARY KEY, tipo VARCHAR(20) NOT NULL UNIQUE);
INSERT INTO usuario_tipo(tipo) VALUES ('Administrador');
INSERT INTO usuario_tipo(tipo) VALUES ('Professor');
INSERT INTO usuario_tipo(tipo) VALUES ('Estagiário');

CREATE TABLE usuario(id serial PRIMARY KEY, tipo INTEGER NOT NULL, nome VARCHAR(100) NOT NULL, login VARCHAR(100) NOT NULL UNIQUE, senha VARCHAR(100) NOT NULL, ativo BOOLEAN NOT NULL, CONSTRAINT fk_usuario_tipo FOREIGN KEY(tipo) REFERENCES usuario_tipo(id));
INSERT INTO usuario (tipo, nome, login, senha, ativo) VALUES (1, 'Bruno Roberto Vasconcelos Tonia', 'bruno', 'bruno', true);
INSERT INTO usuario (tipo, nome, login, senha, ativo) VALUES (1, 'Administrador', 'administrador', 'administrador', true);
INSERT INTO usuario (tipo, nome, login, senha, ativo) VALUES (1, 'Professor', 'professor', 'professor', true);
INSERT INTO usuario (tipo, nome, login, senha, ativo) VALUES (1, 'Estagiário', 'estagiario', 'estagiario', true);

/* Tabelas repositorio, repositorio_security e repositorio_tipo */
CREATE TABLE repositorio_tipo(id serial PRIMARY KEY, tipo VARCHAR(10) NOT NULL UNIQUE);

INSERT INTO repositorio_tipo(tipo) VALUES ('deb');
INSERT INTO repositorio_tipo(tipo) VALUES ('deb-src');

CREATE TABLE repositorio(id serial PRIMARY KEY, tipo INTEGER NOT NULL, url VARCHAR(100) NOT NULL, versao VARCHAR(20) NOT NULL, repositorios VARCHAR(100) NOT NULL, descricao TEXT NOT NULL, ativo BOOLEAN NOT NULL, CONSTRAINT fk_repositorio_tipo FOREIGN KEY(tipo) REFERENCES repositorio_tipo(id));

CREATE TABLE repositorio_security(id serial PRIMARY KEY, tipo INTEGER NOT NULL, url VARCHAR(100) NOT NULL, versao VARCHAR(20) NOT NULL, repositorios VARCHAR(100) NOT NULL, descricao TEXT NOT NULL, ativo BOOLEAN NOT NULL, CONSTRAINT fk_repositorio_tipo2 FOREIGN KEY(tipo) REFERENCES repositorio_tipo(id));

/* Tabela versao */
CREATE TABLE versao(id serial PRIMARY KEY, sources INTEGER NOT NULL, instalacao INTEGER NOT NULL, remocao INTEGER NOT NULL, updt INTEGER NOT NULL, upgrade INTEGER NOT NULL, dist_update INTEGER NOT NULL);

INSERT INTO versao VALUES (1, 0, 0, 0, 0, 0, 0);

/* Triggers versao_sources */
CREATE FUNCTION versao_sources() RETURNS TRIGGER as $$
	BEGIN
		UPDATE versao SET sources = (sources + 1);
		RETURN new;
	END;
$$ LANGUAGE 'plpgsql';

CREATE TRIGGER tr_versao_sources AFTER INSERT OR UPDATE OR DELETE ON repositorio FOR EACH ROW EXECUTE PROCEDURE versao_sources();
CREATE TRIGGER tr_versao_sources_security AFTER INSERT OR UPDATE OR DELETE ON repositorio_security FOR EACH ROW EXECUTE PROCEDURE versao_sources();

/* Inserts nas tabelas repositorio e repositorio_security */
INSERT INTO repositorio (tipo, url, versao, repositorios, descricao, ativo) VALUES (1,'http://sft.if.usp.br/debian/', 'jessie', 'main contrib non-free', 'repositorio padrão','true');
INSERT INTO repositorio_security (tipo, url, versao, repositorios, descricao, ativo) VALUES (1,'http://security.debian.org/', 'jessie/updates', 'main contrib non-free', 'repositorio padrão','true');

/* Tabelas pacotes_categoria */
CREATE TABLE pacotes_categoria(id serial PRIMARY KEY, categoria TEXT NOT NULL UNIQUE);
CREATE TABLE pacotes (id serial PRIMARY KEY, pacote TEXT NOT NULL UNIQUE, categoria INTEGER NOT NULL, versao TEXT, dependencias TEXT,  descricao TEXT, ativo BOOLEAN NOT NULL, CONSTRAINT fk_pacotes_categoria FOREIGN KEY(categoria) REFERENCES pacotes_categoria(id));

/* Tabelas instalacao e remocao */
CREATE TABLE instalacao (id serial PRIMARY KEY, pacote INTEGER NOT NULL, ativo BOOLEAN NOT NULL, CONSTRAINT fk_pacotes FOREIGN KEY(pacote) REFERENCES pacotes(id));

CREATE TABLE remocao (id serial PRIMARY KEY, pacote INTEGER NOT NULL, ativo BOOLEAN NOT NULL, CONSTRAINT fk_pacotes2 FOREIGN KEY(pacote) REFERENCES pacotes(id));

CREATE FUNCTION versao_instalacao() RETURNS TRIGGER AS $$
	BEGIN
		UPDATE versao SET instalacao = (instalacao + 1);
		RETURN new;
	END;
$$ LANGUAGE 'plpgsql';

CREATE TRIGGER tr_versao_instalacao AFTER INSERT ON instalacao FOR EACH ROW EXECUTE PROCEDURE versao_instalacao();

CREATE FUNCTION versao_remocao() RETURNS TRIGGER AS $$
	BEGIN
		UPDATE versao SET remocao = (remocao + 1);
		RETURN new;
	END;
$$ LANGUAGE 'plpgsql';

CREATE TRIGGER tr_versao_remocao AFTER INSERT ON remocao FOR EACH ROW EXECUTE PROCEDURE versao_remocao();

CREATE FUNCTION inserir_instalacao_remocao() RETURNS TRIGGER AS $$
	BEGIN
		IF new.ativo IS TRUE THEN
			UPDATE remocao SET ativo = 'false' WHERE new.pacote = pacote;
			UPDATE instalacao SET ativo = 'false' WHERE new.pacote = pacote;
		END IF;
		RETURN new;
	END;
$$ LANGUAGE 'plpgsql';

CREATE TRIGGER tr_inserir_instalacao BEFORE INSERT ON instalacao FOR EACH ROW EXECUTE PROCEDURE inserir_instalacao_remocao();
CREATE TRIGGER tr_inserir_remocao BEFORE INSERT ON instalacao FOR EACH ROW EXECUTE PROCEDURE inserir_instalacao_remocao();
