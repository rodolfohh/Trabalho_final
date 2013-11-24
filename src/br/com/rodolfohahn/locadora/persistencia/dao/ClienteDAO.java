
package br.com.rodolfohahn.locadora.persistencia.dao;

import br.com.rodolfohahn.locadora.modelo.Cliente;
import java.util.List;



public interface ClienteDAO {
    int salvar(Cliente c);
    boolean remove(int codigo);
    List<Cliente>listAll();
    Cliente listById(int codigo);
    List<Cliente> listByNome(String nome);
    
}
