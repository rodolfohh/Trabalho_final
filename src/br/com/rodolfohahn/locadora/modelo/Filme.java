package br.com.rodolfohahn.locadora.modelo;

import java.util.Date;

public class Filme {
    private int id;
    private String nomeFilme;
    private int duracaoFilme;
    private String descricaoFilme;
    private Date dataLancamento;
    
    private CategoriaFilme categoria;

    public Filme() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    
    public String getNomeFilme() {
        return nomeFilme;
    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    public int getDuracaoFilme() {
        return duracaoFilme;
    }

    public void setDuracaoFilme(int duracaoFilme) {
        this.duracaoFilme = duracaoFilme;
    }

    

    public String getDescricaoFilme() {
        return descricaoFilme;
    }

    public void setDescricaoFilme(String descricaoFilme) {
        this.descricaoFilme = descricaoFilme;
    }

    

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

   

    public CategoriaFilme getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaFilme categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Filme{" + "id=" + id + ", nomeFilme=" + nomeFilme + ", duracaoFilme=" + duracaoFilme + ", descricaoFilme=" + descricaoFilme + ", dataLancamento=" + dataLancamento + ", categoria=" + categoria + '}';
    }

   

    
    

    
    
    

    
    
    
}
