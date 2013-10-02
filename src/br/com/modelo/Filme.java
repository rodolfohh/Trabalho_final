package br.com.modelo;

import java.util.Date;

public class Filme {
    private int id;
    private String nomeFilme;
    private String duracaoFilme;
    private String descricaoFilme;
    private String categoriaFilme;
    private Date dataLancamento;
    private String status;

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

    public String getDuracaoFilme() {
        return duracaoFilme;
    }

    public void setDuracaoFilme(String duracaoFilme) {
        this.duracaoFilme = duracaoFilme;
    }

    public String getDescricaoFilme() {
        return descricaoFilme;
    }

    public void setDescricaoFilme(String descricaoFilme) {
        this.descricaoFilme = descricaoFilme;
    }

    public String getCategoriaFilme() {
        return categoriaFilme;
    }

    public void setCategoriaFilme(String categoriaFilme) {
        this.categoriaFilme = categoriaFilme;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Filme{" + "id=" + id + ", nomeFilme=" + nomeFilme + ", duracaoFilme=" + duracaoFilme + ", descricaoFilme=" + descricaoFilme + ", categoriaFilme=" + categoriaFilme + ", dataLancamento=" + dataLancamento + ", status=" + status + '}';
    }
    
    

    
    
    
}
