
package br.com.rodolfohahn.locadora.controller1;

import br.com.rodolfohahn.locadora.modelo.CategoriaFilme;
import br.com.rodolfohahn.locadora.persistencia.CategoriaDAOImplements;
import br.com.rodolfohahn.locadora.persistencia.dao.CategoriaDAO;
import java.util.List;



public class CategoriaController {
    
     public int salvar(CategoriaFilme c){
        CategoriaDAO dao = new CategoriaDAOImplements();
        return dao.salvar(c);
    }
    
    public List<CategoriaFilme> ListarTodos(){
        CategoriaDAO dao = new CategoriaDAOImplements();
        return dao.listAll();
    }
    
    public boolean remove(int id){
        CategoriaDAO dao = new CategoriaDAOImplements();
        return dao.remove(id);
        
    }
    
    public CategoriaFilme listById(int codigo){
        CategoriaDAO dao = new CategoriaDAOImplements();
        return dao.listById(codigo);
    }
    
    public List<CategoriaFilme> listByNome(String nome){
        CategoriaDAO dao = new CategoriaDAOImplements();
        return dao.listByNome(nome);
    }
}
