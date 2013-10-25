package br.com.rodolfohahn.locadora.modelo;

import java.util.Date;

public abstract class Pessoa {
    private int id;
    private String nome;
    private Endereco endereco;
    private String TelFixo;
    private String TelCel;
    private String sexo;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTelFixo() {
        return TelFixo;
    }

    public void setTelFixo(String TelFixo) {
        this.TelFixo = TelFixo;
    }

    public String getTelCel() {
        return TelCel;
    }

    public void setTelCel(String TelCel) {
        this.TelCel = TelCel;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", TelFixo=" + TelFixo + ", TelCel=" + TelCel + ", sexo=" + sexo + '}';
    }
    
  
    
    
    
}
