package br.com.estoque.estoque_system;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;



public class Conexao {

    private static Properties props = new Properties();

    static {
        try {
            FileInputStream file = new FileInputStream("src/main/resources/config.properties");
            props.load(file);
        } catch (IOException e) {
            System.out.println("Erro ao carregar config.properties: " + e.getMessage());
        }
    }

    private static final String URL = props.getProperty("db.url");
    private static final String USUARIO = props.getProperty("db.user");
    private static final String SENHA = props.getProperty("db.pass");

    public static Connection conectar() {
        try {
            Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            System.out.println("✔ Conexão bem-sucedida com o banco de dados!");
            return conexao;
        } catch (SQLException e) {
            System.out.println("✘ Erro ao conectar ao banco de dados: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        conectar();
    }
}