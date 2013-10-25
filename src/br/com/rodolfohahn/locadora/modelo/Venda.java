package br.com.rodolfohahn.locadora.modelo;

import java.util.Date;

public class Venda extends Produto{
    private int id;
    private double valorTotal;
    private Date dataVenda;

    public Venda() {
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    @Override
    public String toString() {
        return "Venda{" + "id=" + id + ", valorTotal=" + valorTotal + ", dataVenda=" + dataVenda + '}';
    }
    
    
    
    
    
    
}
