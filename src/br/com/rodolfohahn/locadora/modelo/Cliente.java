package br.com.rodolfohahn.locadora.modelo;

public class Cliente extends Pessoa{
    private Endereco endereco;
    private double salarioClie;
    private String profissao;
    
    
    public Cliente() {
    }

    public double getSalarioClie() {
        return salarioClie;
    }

    public void setSalarioClie(double salarioClie) {
        this.salarioClie = salarioClie;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    @Override
    public String toString() {
        return "Cliente{" + "endereco=" + endereco + ", salarioClie=" + salarioClie + ", profissao=" + profissao + '}';
    }
    
    
    
    
    
}
