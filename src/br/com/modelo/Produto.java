package br.com.modelo;

import java.util.Date;

public class Produto {
    private int id;
    private String nomePro;
    private double valorPro;
    private Date dataValidadePro;

    public Produto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomePro() {
        return nomePro;
    }

    public void setNomePro(String nomePro) {
        this.nomePro = nomePro;
    }

    public double getValorPro() {
        return valorPro;
    }

    public void setValorPro(double valorPro) {
        this.valorPro = valorPro;
    }

    public Date getDataValidadePro() {
        return dataValidadePro;
    }

    public void setDataValidadePro(Date dataValidadePro) {
        this.dataValidadePro = dataValidadePro;
    }

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", nomePro=" + nomePro + ", valorPro=" + valorPro + ", dataValidadePro=" + dataValidadePro + '}';
    }
    
    
    
    
}
