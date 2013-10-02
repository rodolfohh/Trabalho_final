package br.com.modelo;

import java.util.Date;

public class Funcionario extends Pessoa{
    private double salario;
    private String ctps;
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

    @Override
    public String toString() {
        return "Funcionario{" + "salario=" + salario + ", ctps=" + ctps + ", dataAdmissao=" + dataAdmissao + '}';
    }
    
    
    
    
}
