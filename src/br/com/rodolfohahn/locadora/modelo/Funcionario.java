package br.com.rodolfohahn.locadora.modelo;

import java.util.Date;

public class Funcionario extends PessoaFisica{
    private double salario;
    private String ctps;
    private String login;
    private String senha;
    private Date dataAdmissao;
   

    public Funcionario() {
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getCtps() {
        return ctps;
    }

    public void setCtps(String ctps) {
        this.ctps = ctps;
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
        
        
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    

    @Override
    public String toString() {
        return "Funcionario{" + "salario=" + salario + ", ctps=" + ctps + ", dataAdmissao=" + dataAdmissao + '}';
    }
    
    
    
    
}
