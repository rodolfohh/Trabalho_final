
package br.com.rodolfohahn.locadora.persistencia.dao;


import br.com.rodolfohahn.locadora.modelo.Reserva;
import java.util.List;


public interface ReservaDAO {
    int salvar(Reserva r);
    boolean remove(int codigo);
    List<Reserva>listAll();
    Reserva listById(int codigo);
    List<Reserva> listByNome(String nome);
}
