package br.com.rodolfohahn.locadora.controller1;

import br.com.rodolfohahn.locadora.modelo.Cliente;
import br.com.rodolfohahn.locadora.persistencia.ClienteDAOImplements;
import br.com.rodolfohahn.locadora.persistencia.dao.ClienteDAO;
import java.util.List;

public class ClienteController {
     public int salvar(Cliente c){
        ClienteDAO dao = new ClienteDAOImplements();
        return dao.salvar(c);
    }
    
    public List<Cliente> ListarTodos(){
        ClienteDAO dao = new ClienteDAOImplements();
        return dao.listAll();
    }
    
    public boolean remove(int id){
        ClienteDAO dao = new ClienteDAOImplements();
        return dao.remove(id);
        
    }
    
    public Cliente listById(int codigo){
        ClienteDAO dao = new ClienteDAOImplements();
        return dao.listById(codigo);
    }
    
    public List<Cliente> listByNome(String nome){
        ClienteDAO dao = new ClienteDAOImplements();
        return dao.listByNome(nome);
    }
    
}
