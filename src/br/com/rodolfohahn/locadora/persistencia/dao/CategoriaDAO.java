
package br.com.rodolfohahn.locadora.persistencia.dao;

import br.com.rodolfohahn.locadora.modelo.CategoriaFilme;
import java.util.List;


public interface CategoriaDAO {
    int salvar(CategoriaFilme cf);
    boolean remove(int codigo);
    List<CategoriaFilme>listAll();
    CategoriaFilme listById(int codigo);
    List<CategoriaFilme> listByNome(String nome);
}
