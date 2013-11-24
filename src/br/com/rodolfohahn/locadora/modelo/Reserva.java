package br.com.rodolfohahn.locadora.modelo;

import java.util.Date;

public class Reserva {
    private int id_reserva;
    private Filme filme;
    private Cliente clientes;
    private Date dataReserva;

    public Reserva() {
    }

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
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
        return "Reserva{" + "id_reserva=" + id_reserva + ", filme=" + filme + ", clientes=" + clientes + ", dataReserva=" + dataReserva + '}';
    }
    
    
    
    

   

   
    
    
    
}
