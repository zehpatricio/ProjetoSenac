/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetoSenac;
import javax.swing.*;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
/**
 *
 * @author Aluno
 */
public class AlunoControler {
    private Date formatarData(String data) throws ParseException{
        DateFormat formatar = new SimpleDateFormat("dd/MM/yyyy");
        return new Date(formatar.parse(data).getTime());
    }
    public void salvarAluno(int matricula, String nome, String dtNasc, String endereco) throws ParseException{
        Aluno aluno = new Aluno();
        aluno.setNome(nome);
        aluno.setEndereco(endereco);
        aluno.setNascimento(formatarData(dtNasc));
    }
    public void alteraAluno(long id, int matricula, String nome, String dtNasc, String endereco) throws ParseException, SQLException{
        Aluno aluno = new Aluno();
        aluno.setNome(nome);
        aluno.setEndereco(endereco);
        aluno.setMatricula(matricula);
        aluno.setNascimento(formatarData(dtNasc));
        
        new AlunoDAO().alterar(aluno);
    }
    public List<Aluno> listarAlunos() {
        AlunoDAO dao = new AlunoDAO();
            return dao.findAlunos();
    }
    public void excluirALuno(long id) throws SQLException{
        new AlunoDAO().excluir(id);
    }
    public Aluno buscaPorNome(String nome) throws SQLException {
        AlunoDAO dao = new AlunoDAO();
        return dao.findByName(nome);
    }
}
