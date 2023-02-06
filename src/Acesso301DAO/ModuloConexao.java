package Acesso301DAO;

import java.sql.*;

public class ModuloConexao {
    // Passo1: Cria a rotina de conexa.
    public static Connection connector() {
        java.sql.Connection conexao = null;
        //Passo 2: Definir o Driver e as variaveis da String de Conexao.
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/dbone301";
        String user = "root";
        String password = "";
        //Passo 3: Estabelecer a Conexao.
        try {
            // Faz a carga/load do driver.
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        }catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    
    
}
