package apresentacao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import db.DatabaseConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AcessoADado {

    public String cadastrar_conta(String numero, float saldo) {
        String resultado = "Conta cadastrada com sucesso!";
        String sql = "INSERT INTO contas (numero, saldo) VALUES (?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, numero);
            stmt.setFloat(2, saldo);
            stmt.executeUpdate();
        } catch (SQLException e) {
            resultado = "Erro ao cadastrar conta: " + e.getMessage();
        }

        return resultado;
    }

    public String cadastrar_conta_normal(String numero) {
        String resultado = "Conta Normal cadastrada com sucesso!";
        String sql = "INSERT INTO conta_normal (numero) VALUES (?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, numero);
            stmt.executeUpdate();
        } catch (SQLException e) {
            resultado = "Erro ao cadastrar conta normal: " + e.getMessage();
        }

        return resultado;
    }
}

/*
 * -- Table: public.conta

-- DROP TABLE IF EXISTS public.conta;

CREATE TABLE IF NOT EXISTS public.conta
(
    numero character(20) COLLATE pg_catalog."default" NOT NULL,
    saldo double precision,
    CONSTRAINT comnta_pk PRIMARY KEY (numero)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.conta
    OWNER to postgres;

GRANT ALL ON TABLE public.conta TO postgres;


-- Table: public.conta_deb_especial

-- DROP TABLE IF EXISTS public.conta_deb_especial;

CREATE TABLE IF NOT EXISTS public.conta_deb_especial
(
    numero character(20) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT conta_deb_especial_pk PRIMARY KEY (numero),
    CONSTRAINT foreignkey_conta_deb_especial FOREIGN KEY (numero)
        REFERENCES public.conta_especial (numero) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.conta_deb_especial
    OWNER to postgres;

GRANT ALL ON TABLE public.conta_deb_especial TO postgres;

-- Table: public.conta_especial

-- DROP TABLE IF EXISTS public.conta_especial;

CREATE TABLE IF NOT EXISTS public.conta_especial
(
    numero character(20) COLLATE pg_catalog."default" NOT NULL,
    limite double precision,
    CONSTRAINT conta_especial_pk PRIMARY KEY (numero),
    CONSTRAINT foreignkey_conta_especial FOREIGN KEY (numero)
        REFERENCES public.conta (numero) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.conta_especial
    OWNER to postgres;

GRANT ALL ON TABLE public.conta_especial TO postgres;

-- Table: public.conta_normal

-- DROP TABLE IF EXISTS public.conta_normal;

CREATE TABLE IF NOT EXISTS public.conta_normal
(
    numero character(20) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT conta_normal_pk PRIMARY KEY (numero)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.conta_normal
    OWNER to postgres;

GRANT ALL ON TABLE public.conta_normal TO postgres;

 * 
 * 
 */


// package br.com.dragon.util.conexao;
 
 /**
  *
  * @author botel
  */
/* public class AcessoADado {
 

     public AcessoADado() {
     }
 

     public Connection connect() throws SQLException {
         String url = "jdbc:mysql://localhost:3306/banco"; // Ajuste para o MySQL
         Properties props = new Properties();
         props.setProperty("user", "root"); // Substitua por seu usuário
         props.setProperty("password", "senha"); // Substitua pela senha do MySQL
 
         return DriverManager.getConnection(url, props);
     }
 
     public String cadastrar_conta(String numero, float saldo) {
         String SQL = "INSERT INTO conta (numero, saldo) VALUES (?, ?)";
         String mensagem = "";
 
         try {
             // Registrar o driver MySQL
             Class.forName("com.mysql.cj.jdbc.Driver");
         } catch (ClassNotFoundException e) {
             e.printStackTrace();
             return "Driver MySQL não encontrado.";
         }
 
         try (Connection conn = connect();
              PreparedStatement pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {
 
             pstmt.setString(1, numero);
             pstmt.setFloat(2, saldo);
 
             int affectedRows = pstmt.executeUpdate();
 
             if (affectedRows > 0) {
                 mensagem = "Cadastro de conta " + numero + " realizado com sucesso.";
             }
         } catch (SQLException ex) {
             mensagem = "Erro ao cadastrar conta: " + ex.getMessage();
         }
 
         return mensagem;
     }
 
     public String alterar_conta(String numero, float saldo) {
         String SQL = "UPDATE conta SET saldo = ? WHERE numero = ?";
         String mensagem = "";
 
         try {
             // Registrar o driver MySQL
             Class.forName("com.mysql.cj.jdbc.Driver");
         } catch (ClassNotFoundException e) {
             e.printStackTrace();
             return "Driver MySQL não encontrado.";
         }
 
         try (Connection conn = connect();
              PreparedStatement pstmt = conn.prepareStatement(SQL)) {
 
             pstmt.setFloat(1, saldo);
             pstmt.setString(2, numero);
 
             int affectedRows = pstmt.executeUpdate();
 
             if (affectedRows > 0) {
                 mensagem = "Sucesso na alteração de conta.";
             } else {
                 mensagem = "Nenhuma conta encontrada para alterar.";
             }
         } catch (SQLException ex) {
             mensagem = "Erro ao alterar conta: " + ex.getMessage();
         }
 
         return mensagem;
     }
 }*/
 