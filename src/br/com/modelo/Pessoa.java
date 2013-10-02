package br.com.modelo;

import java.util.Date;

public abstract class Pessoa {
    private int id;
    private String nome;
    private Endereco endereco;
    private String telFixo;
    private String telCel;

    public Pessoa() {
    }

    
    
    
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", telFixo=" + telFixo + ", telCel=" + telCel + '}';
    }

   

   
    
    

    
    
    
    
    
}
