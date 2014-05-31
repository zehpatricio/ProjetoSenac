/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetoSenac;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class AlunoDAO extends ManipulaBanco{
    public void Salva(Aluno aluno) throws SQLException{
        String inserir = "INSERT INTO ALUNOS(Nome, Matricula, Nasc, Endereco) VALUES(?,?,?,?)";
        salvar(inserir, aluno.getNome(), aluno.getMatricula(), aluno.getNascimento(), aluno.getEndereco());
    }
    public void alterar(Aluno aluno) throws SQLException{
         String update = "UPDATE CONTATOS " +
                "SET nome = ?, apelido = ?, data_nascimento = ? " +
                "WHERE id = ?";
        atualizar(update, aluno.getNome(), aluno.getMatricula(), aluno.getNascimento(), aluno.getEndereco());
    }
    public Aluno findByName(String nome) throws SQLException {
        String select = "SELECT * FROM CONTATOS WHERE nome = ?";
        Aluno aluno = null;
        try (PreparedStatement stmt = getConnection().prepareStatement(select)) {
            stmt.setString(1, nome);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    aluno = new Aluno();
                    aluno.setNome(rs.getString("Nome"));
                    aluno.setEndereco(rs.getString("Endereco"));
                    aluno.setMatricula(Integer.parseInt(rs.getString("Matricula")));
                    aluno.setNascimento(rs.getDate("Nasc"));
                }
            }
        }
        return aluno;
    }
    public List<Aluno> findAlunos() throws SQLException{
        List<Aluno> alunos = new ArrayList<>();
        String select = "SELECT * FROM CONTATOS";
        try (PreparedStatement stmt = getConnection().prepareStatement(select); ResultSet rs = stmt.executeQuery()) {
     
            while (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setId(rs.getLong("id"));
                aluno.setNome(rs.getString("Nome"));
                aluno.setNascimento(rs.getDate("Nasc"));
                aluno.setEndereco(rs.getString("Endereco"));
                aluno.setMatricula(Integer.parseInt(rs.getString("Matricula")));
                alunos.add(aluno);
            }
        }
        return alunos;
    }
     public void excluir(long id) throws SQLException {
        String delete = "DELETE FROM CONTATOS WHERE id = ?";
        delete(delete, id);
    }
}
