package br.com.rodolfohahn.locadora.modelo;

import java.util.Date;

public class Locacao{
    private int id;
    private Date dataInicialLoca;
    private Date dataEntregaLoca;
    private Filme filmes;
    private Cliente cliente;

    public Locacao() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataInicialLoca() {
        return dataInicialLoca;
    }

    public void setDataInicialLoca(Date dataInicialLoca) {
        this.dataInicialLoca = dataInicialLoca;
    }

    public Date getDataEntregaLoca() {
        return dataEntregaLoca;
    }

    public void setDataEntregaLoca(Date dataEntregaLoca) {
        this.dataEntregaLoca = dataEntregaLoca;
    }

    public Filme getFilmes() {
        return filmes;
    }

    public void setFilmes(Filme filmes) {
        this.filmes = filmes;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Locacao{" + "id=" + id + ", dataInicialLoca=" + dataInicialLoca + ", dataEntregaLoca=" + dataEntregaLoca + ", filmes=" + filmes + ", cliente=" + cliente + '}';
    }
    
    
    
    
    
}
