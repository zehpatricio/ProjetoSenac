/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProjetoSenac;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Patricio JP
 */
public class FabricaDeConexao {
    private String nomeBanco;
    private String usuario;
    private String senha;
    
    private void setarValores(String nomeBanco, String usuario, String senha){
        this.nomeBanco = nomeBanco;
        this.usuario = usuario;
        this.senha = senha;
    }
    
    public FabricaDeConexao(String nomeBanco, String usuario, String senha){
        setarValores(nomeBanco, usuario, senha);
    }
    public Connection obterConexao(){
        Connection conexao = null;
        String url = "jdbc:odbc:Banco_LP";
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conexao = DriverManager.getConnection(url, this.usuario, this.senha);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FabricaDeConexao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            return conexao;
        }
    }
}
