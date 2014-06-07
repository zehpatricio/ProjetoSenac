/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProjetoSenac;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
/**
 *
 * @author Patricio JP
 */
public class ConsultaSQL {
    Statement meuState;
    
    public static void main(String[] args) {
        ConsultaSQL obj = new ConsultaSQL();
        obj.buscarDados();
    }
    public void buscarDados(){
        ResultSet rs;
        String sql = "SELECT * FROM alunos";
        String nomes="Matric  |   Nome\n\n";
        try{
            rs = meuState.executeQuery(sql);
            while(rs.next()){
                nomes+="    "+rs.getString("matricula")+"      |  "+rs.getString("nome")+"\n";
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, nomes.toUpperCase(), "Lista de Alunos", JOptionPane.PLAIN_MESSAGE);
    }
    public void buscarNome(String nome){
        ResultSet rs;
        String sql = "SELECT * FROM alunos";
        String nomes="Matric  |   Nome                   | Endereco\n\n";
        try{
            rs = meuState.executeQuery(sql);
            while(rs.next()){
                if(rs.getString("nome").toUpperCase().equals(nome.toUpperCase())){
                    nomes+="    "+rs.getString("matricula")+"      |  "+rs.getString("nome")+
                    "                 |  "+rs.getString("endereco")+"   | "+rs.getString("data")+"\n";
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(nomes.equals("Matric  |   Nome                   | Endereco\n\n")){
            JOptionPane.showMessageDialog(null, "Nenhum nome encontrado!", "Erro", JOptionPane.PLAIN_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, nomes.toUpperCase(), "Resultado da Pesquisa", JOptionPane.PLAIN_MESSAGE);
        }
    }
    public int verificaMatricula(int matricula){
        ResultSet rs;
        String sql = "SELECT * FROM alunos";
        int resp = 0;
        try{
            rs = meuState.executeQuery(sql);
            while(rs.next()){
                if(rs.getInt("matricula") == matricula){
                    resp = 1;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }
    public int buscaMatricula(int matricula){
        ResultSet rs;
        String sql = "SELECT * FROM alunos";
        String nomes="Matric  |   Nome                   | Endereco          | Data Nasc.\n\n";
        int resp=0;
        try{
            rs = meuState.executeQuery(sql);
            while(rs.next()){
                if(rs.getInt("matricula") == matricula){
                    nomes+="    "+rs.getString("matricula")+"      |  "+rs.getString("nome")+
                    "                 |  "+rs.getString("endereco")+"   | "+rs.getString("data")+"\n";
                    resp = 1;
                    break;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(resp==0){
            JOptionPane.showMessageDialog(null, "Matricula não encontrada!", "Erro", JOptionPane.PLAIN_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, nomes.toUpperCase(), "Resultado da Pesquisa", JOptionPane.PLAIN_MESSAGE);
        }
        return resp;
    }
    public ConsultaSQL(){
        String url;
        url = "jdbc:odbc:Banco_LP";
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection minhaConexao = DriverManager.getConnection(url, "root", "root");
            this.meuState = minhaConexao.createStatement();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConsultaSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
