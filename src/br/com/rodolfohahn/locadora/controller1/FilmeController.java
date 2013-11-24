package br.com.rodolfohahn.locadora.controller1;

import br.com.rodolfohahn.locadora.modelo.Filme;
import br.com.rodolfohahn.locadora.persistencia.FilmeDAOImplements;
import br.com.rodolfohahn.locadora.persistencia.dao.FilmeDAO;
import java.util.List;

public class FilmeController {
     public int salvar(Filme f){
        FilmeDAO dao = new FilmeDAOImplements();
        return dao.salvar(f);
    }
    
    public List<Filme> ListarTodos(){
        FilmeDAO dao = new FilmeDAOImplements();
        return dao.listAll();
    }
    
    public boolean remove(int id){
        FilmeDAO dao = new FilmeDAOImplements();
        return dao.remove(id);
        
    }
    
    public Filme listById(int codigo){
        FilmeDAO dao = new FilmeDAOImplements();
        return dao.listById(codigo);
    }
    
    public List<Filme> listByNome(String nome){
        FilmeDAO dao = new FilmeDAOImplements();
        return dao.listByNome(nome);
    }
    
}
