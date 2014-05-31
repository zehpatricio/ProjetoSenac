/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetoSenac;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
/**
 *
 * @author Aluno
 */
public class FabricaDeConexao {
    private static String url = "jdbc:mysql://localhost:3306/alunos";
    private static String nome = "root";
    private static String senha = "root";
    private static final String driver = "com.mysql.jdbc.Driver";
    public static Connection getConnection() {
        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, nome, senha);
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
