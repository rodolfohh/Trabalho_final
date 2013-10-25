package br.com.rodolfohahn.locadora.controller1;

import br.com.rodolfohahn.locadora.modelo.Funcionario;
import br.com.rodolfohahn.locadora.persistencia.FuncionarioDAOImplements;
import br.com.rodolfohahn.locadora.persistencia.dao.FuncionarioDAO;
import java.util.List;

public class FuncionarioController {
     public int salvar(Funcionario f){
        FuncionarioDAO dao = new FuncionarioDAOImplements();
        return dao.salvar(f);
    }
    
    public List<Funcionario> ListarTodos(){
        FuncionarioDAO dao = new FuncionarioDAOImplements();
        return dao.listAll();
    }
    
    public boolean remove(int id){
        FuncionarioDAO dao = new FuncionarioDAOImplements();
        return dao.remove(id);
        
    }
    
    public Funcionario listById(int codigo){
        FuncionarioDAO dao = new FuncionarioDAOImplements();
        return dao.listById(codigo);
    }
    
    public List<Funcionario> listByNome(String nome){
        FuncionarioDAO dao = new FuncionarioDAOImplements();
        return dao.listByNome(nome);
    }
    
}
