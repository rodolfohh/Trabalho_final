package br.com.rodolfohahn.locadora.modelo;

public class Cliente extends PessoaFisica{
    
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
        return "Cliente{" + "salarioClie=" + salarioClie + ", profissao=" + profissao + '}';
    }

  
    
    
    
    
    
}
