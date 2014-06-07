/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProjetoSenac;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Patricio JP
 */
public class Controle {
    Connection conexao;
    private int ultimo;
    public Controle(){
        FabricaDeConexao fabrica = new FabricaDeConexao("bd", "root", "root");
        conexao = fabrica.obterConexao();
    }
    public void inserirDados(String nome, String endereco, int matricula){
        //Falta fazer a DATA DE NASCIMENTO
        String sql = "INSERT INTO bd.Alunos (nome, endereco, matricula) VALUES (?, ?, ?)";
        PreparedStatement pstmt;
        try {
            pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, nome);
            pstmt.setString(2, endereco);
            pstmt.setInt(3, matricula);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Dados salvos com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(Controle.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void buscarDados(){
        ConsultaSQL consult = new ConsultaSQL();
        consult.buscarDados();
    }
    public void buscarPorNome(String nome){
        ConsultaSQL consult = new ConsultaSQL();
        consult.buscarNome(nome);
    }
    public void pesquisarNome(){
        
    }

    /**
     *
     * @param matricula
     */
    public void excluirDados(int matricula){
        String sql = "DELET FROM bd.Alunos WHERE matricula = ?";
        PreparedStatement pstmt;
        try {
            pstmt = conexao.prepareStatement(sql);
            pstmt.setInt(1, matricula);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Controle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
/*    public void buscarPorNome(String nome){
        String sql = "DELET FROM bd.Alunos WHERE matricula = ?";
        PreparedStatement pstmt;
        try {
            pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, String.valueOf(nome));
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Controle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    public int getUltimo(){
        ResultSet rs;
        PreparedStatement pstmt;
        String sql = "SELECT * FROM bd.Alunos";
        ultimo = 0;
        try {
            pstmt = conexao.prepareStatement(sql);
            rs = pstmt.getResultSet();
            while(rs.next()){
                ultimo = rs.getInt("matricula");}
        } catch (SQLException ex) {
            Logger.getLogger(Controle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ultimo;
    }
}
