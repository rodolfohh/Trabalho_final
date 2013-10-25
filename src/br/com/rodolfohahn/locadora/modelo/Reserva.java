package br.com.rodolfohahn.locadora.modelo;

import java.util.Date;

public class Reserva {
    private String nomeFilme;
    private Filme filme;
    private Cliente clientes;
    private Date dataReserva;

    public Reserva() {
    }
    
    
    
    

    public String getNomeFilme() {
        return nomeFilme;
    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Cliente getClientes() {
        return clientes;
    }

    public void setClientes(Cliente clientes) {
        this.clientes = clientes;
    }

    public Date getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(Date dataReserva) {
        this.dataReserva = dataReserva;
    }

    @Override
    public String toString() {
        return "Reserva{" + "nomeFilme=" + nomeFilme + ", filme=" + filme + ", clientes=" + clientes + ", dataReserva=" + dataReserva + '}';
    }
    
    
    
}
