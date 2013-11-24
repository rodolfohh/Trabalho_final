package br.com.rodolfohahn.locadora.modelo;

public class CategoriaFilme {
    private int id;
    private String nome_categoria;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome_categoria() {
        return nome_categoria;
    }

    public void setNome_categoria(String nome_categoria) {
        this.nome_categoria = nome_categoria;
    }

    

    @Override
    public String toString() {
        return  nome_categoria ;
    }
    
    
    
}
