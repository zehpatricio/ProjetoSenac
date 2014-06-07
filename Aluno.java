package ProjetoSenac;

import java.util.Date;

/**
 *
 * @author Patricio JP
 */
public class Aluno {
    private String nome;
    private String endereco;
    private Date nascimento;
    private int matricula;

    public Aluno(){
        this.nome = "Sem Nome";
        this.endereco = "Sem Endereço";
        this.matricula = 0;
    }
    public Aluno(String nome, String endereco, Date data){
        this.nome = nome;
        this.endereco = endereco;
        this.nascimento = data;
    }
    public String getNome() {
        return nome;
    }
    public int getMatricula(){
        return matricula;
    }    
    public void setMatricula(int matricula){
        this.matricula = matricula;
    }
    public String getEndereco() {
        return endereco;
    }
    public Date getNascimento() {
        return nascimento;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    void setId(long aLong) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
