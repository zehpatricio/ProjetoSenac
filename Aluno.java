/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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

    public Aluno(){
        this.nome = "Sem Nome";
        this.endereco = "Sem Endereço";
    }
    public Aluno(String nome, String endereco, Date data){
        this.nome = nome;
        this.endereco = endereco;
        this.nascimento = data;
    }
    public String getNome() {
        return nome;
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
    
}
