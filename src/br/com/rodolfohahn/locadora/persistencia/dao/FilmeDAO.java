
package br.com.rodolfohahn.locadora.persistencia.dao;


import br.com.rodolfohahn.locadora.modelo.Filme;
import java.util.List;


public interface FilmeDAO {
    int salvar(Filme f);
    boolean remove(int codigo);
    List<Filme>listAll();
    Filme listById(int codigo);
    List<Filme> listByNome(String nome);
}
