package br.com.rodolfohahn.locadora.persistencia.dao;

import br.com.rodolfohahn.locadora.modelo.Funcionario;
import java.util.List;

public interface FuncionarioDAO {
    int salvar(Funcionario f);
    boolean remove(int codigo);
    List<Funcionario>listAll();
    Funcionario listById(int codigo);
    List<Funcionario> listByNome(String nome);
    
}
