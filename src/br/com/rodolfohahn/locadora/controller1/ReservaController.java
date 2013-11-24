package br.com.rodolfohahn.locadora.controller1;

import br.com.rodolfohahn.locadora.modelo.Reserva;
import br.com.rodolfohahn.locadora.persistencia.ReservaDAOImplements;
import br.com.rodolfohahn.locadora.persistencia.dao.ReservaDAO;
import java.util.List;

public class ReservaController {
     public int salvar(Reserva r){
        ReservaDAO dao = new ReservaDAOImplements();
        return dao.salvar(r);
    }
    
    public List<Reserva> ListarTodos(){
        ReservaDAO dao = new ReservaDAOImplements();
        return dao.listAll();
    }
    
    public boolean remove(int id){
        ReservaDAO dao = new ReservaDAOImplements();
        return dao.remove(id);
        
    }
    
    public Reserva listById(int codigo){
        ReservaDAO dao = new ReservaDAOImplements();
        return dao.listById(codigo);
    }
    
    public List<Reserva> listByNome(String nome){
        ReservaDAO dao = new ReservaDAOImplements();
        return dao.listByNome(nome);
    }
    
}
