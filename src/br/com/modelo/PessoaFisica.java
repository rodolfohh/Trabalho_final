package br.com.modelo;

import java.util.Date;

public class PessoaFisica extends Pessoa{
    private String rg;
    private String cpf;
    private Date dataNascimento;
    private int idade;

    public PessoaFisica() {
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "PessoaFisica{" + "rg=" + rg + ", cpf=" + cpf + ", dataNascimento=" + dataNascimento + ", idade=" + idade + '}';
    }
    
    
    
    
}
