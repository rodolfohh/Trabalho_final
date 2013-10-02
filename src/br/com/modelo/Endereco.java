package br.com.modelo;

public class Endereco {
    
    private String rua;
    private String complemento;
    private String bairro;
    private String cidade;
    private int numero;
    private String cep;
   

    public Endereco() {
    }

    

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public String toString() {
        return  "Rua:" + rua + ", complemento=" + complemento + ", bairro=" + bairro + ", cidade=" + cidade + ", numero=" + numero + ", cep=" + cep + '}';
    }

    
    
    
    
    
    
}
