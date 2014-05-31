/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetoSenac;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author Aluno
 */
public class ManipulaBanco {
    private  Connection connection;
    
    protected ManipulaBanco(){
        this.connection = FabricaDeConexao.getConnection();
    }
    protected Connection getConnection(){
        return connection;
    }
    
    protected void salvar(String inserirSql, Object... parametros) throws SQLException{
        PreparedStatement pstm = getConnection().prepareStatement(inserirSql);
        for(int i=0 ; i<parametros.length ; i++){
            pstm.setObject(i+1, parametros[i]);
        }
        pstm.execute();
        pstm.close();
    }
    
    protected void atualizar(String atualizarSql, Object id, Object... parametros)throws SQLException{
        PreparedStatement pstmt = getConnection().prepareStatement(atualizarSql);
             
        for (int i = 0; i < parametros.length; i++) {
            pstmt.setObject(i+1, parametros[i]);
        }
        pstmt.setObject(parametros.length + 1, id);
        pstmt.execute();
        pstmt.close();
    }
 
    protected void delete(String deletarSql, Object... parametros) throws SQLException {
        PreparedStatement pstmt = getConnection().prepareStatement(deletarSql);
             
        for (int i = 0; i < parametros.length; i++) {
            pstmt.setObject(i+1, parametros[i]);
        }
 
        pstmt.execute();
        pstmt.close();
    }
}
