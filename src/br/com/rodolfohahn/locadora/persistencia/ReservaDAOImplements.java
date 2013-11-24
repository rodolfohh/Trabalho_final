package br.com.rodolfohahn.locadora.persistencia;

import br.com.rodolfohahn.locadora.modelo.CategoriaFilme;
import br.com.rodolfohahn.locadora.modelo.Cliente;
import br.com.rodolfohahn.locadora.modelo.Filme;
import br.com.rodolfohahn.locadora.modelo.Reserva;
import br.com.rodolfohahn.locadora.persistencia.dao.ReservaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;









public class ReservaDAOImplements implements ReservaDAO {

    private static final String INSERT = "insert into reserva (filme,clientes,datareserva) values (?,?,?);";
    private static final String LIST = "select *from reserva;";
    private static final String REMOVE = "delete from reserva where id_reserva=?;";
    private static final String UPDATE = "update reserva set filme=?, clientes = ?, datareserva = ? where id =?;";
    private static final String LISTBYID = "select * from reserva where id_reserva = ?;";
    private static final String LISTBYNOME = "select * from reserva,filme where filme.nomefilme like ?;";

    @Override
    public int salvar(Reserva r) {
        if(r.getId_reserva()> 0){
            return update(r);
        }else{
            return insert(r);
        }
    }

    @Override
    public boolean remove(int codigo) {
        Connection con = null;
        PreparedStatement pstm = null;
        boolean retorno =false;
        
        try{
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(REMOVE);
            pstm.setInt(1, codigo);
            pstm.execute();
            retorno = true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro ao remover: " + e.getMessage());
        }finally{
            try{
                ConnectionFactory.closeConnection(con, pstm);
            }catch(Exception e){
               JOptionPane.showMessageDialog(null,"Erro ao fechar conexão: " + e.getMessage());
            }
        }
        return retorno;
    }

    @Override
    public List<Reserva> listAll() {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Reserva> reservas = new ArrayList<>();
        
        try{
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LIST);
            rs = pstm.executeQuery();
            while(rs.next()){
                Reserva r = new Reserva();
                r.setId_reserva(rs.getInt("id_reserva"));
                Cliente c = new Cliente();
                c.setId(rs.getInt("cliente.id"));
                c.setNome(rs.getString("cliente.nome"));
                r.setClientes(c);
                r.setFilme(null);
                Filme f = new Filme();
                f.setId(rs.getInt("filme.id"));
                f.setNomeFilme(rs.getString("filme.nomefilme"));
                r.setFilme(f);
                r.setDataReserva(rs.getDate("datareserva"));
                
                reservas.add(r);
                
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro ao listar: " + e.getMessage());
        }finally{
            try{
                ConnectionFactory.closeConnection(con, pstm, rs);
            }catch(Exception e){
               JOptionPane.showMessageDialog(null,"Erro ao fechar conexão: " + e.getMessage());
            }
        }
        return reservas;
    
    }

    @Override
    public Reserva listById(int codigo) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Reserva r = new Reserva();
        
        try{
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LISTBYID);
            pstm.setInt(1, codigo);
            rs = pstm.executeQuery();
            while(rs.next()){
                r.setId_reserva(rs.getInt("id_reserva"));
                Cliente c = new Cliente();
                c.setId(rs.getInt("cliente.id"));
                c.setNome(rs.getString("cliente.nome"));
                r.setClientes(c);
                r.setFilme(null);
                Filme f = new Filme();
                f.setId(rs.getInt("filme.id"));
                f.setNomeFilme(rs.getString("filme.nomefilme"));
                r.setFilme(f);
                r.setDataReserva(rs.getDate("datareserva"));
                
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro ao listar por id: " + e.getMessage());
        }finally{
            try{
                ConnectionFactory.closeConnection(con, pstm, rs);
            }catch(Exception e){
               JOptionPane.showMessageDialog(null,"Erro ao fechar conexão: " + e.getMessage());
            }
        }
        return r;
    }

    @Override
    public List<Reserva> listByNome(String nome) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Reserva> reservas = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LISTBYNOME);
            pstm.setString(1, "%" + nome + "%");
            rs = pstm.executeQuery();
            while (rs.next()) {
                Reserva r = new Reserva();
                r.setId_reserva(rs.getInt("id_reserva"));
                Cliente c = new Cliente();
                c.setId(rs.getInt("cliente.id"));
                c.setNome(rs.getString("cliente.nome"));
                r.setClientes(c);
                r.setFilme(null);
                Filme f = new Filme();
                f.setId(rs.getInt("filme.id"));
                f.setNomeFilme(rs.getString("filme.nomefilme"));
                r.setFilme(f);
                r.setDataReserva(rs.getDate("datareserva"));
                reservas.add(r);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro ao pesquisar reservas" + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "erro ao fechar a conexão" + e.getMessage());
            }

        }
        return reservas;
    }

    private int update(Reserva r) {
        Connection con = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try{
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(UPDATE );
            pstm.setInt(1, r.getFilme().getId());
            pstm.setInt(2, r.getClientes().getId());
            pstm.setDate(3, new java.sql.Date(r.getDataReserva().getTime()));
            pstm.setInt(4, r.getId_reserva());
            
            pstm.execute();
            retorno = r.getId_reserva();
            
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro ao inserir: " + e.getMessage());
        }finally{
            try{
                ConnectionFactory.closeConnection(con, pstm);
            }catch(Exception e){
               JOptionPane.showMessageDialog(null,"Erro ao fechar conexão: " + e.getMessage());
            }
        }
        return retorno;
    }

    private int insert(Reserva r) {
        Connection con = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try{
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS );
            pstm.setInt(1, r.getFilme().getId());
            pstm.setInt(2, r.getClientes().getId());
            pstm.setDate(3, new java.sql.Date(r.getDataReserva().getTime()));
            
            pstm.execute();
            //Retorna a chave gerada pelo MYSQL
            try(ResultSet rs = pstm.getGeneratedKeys()){
                if(rs.next()){
                    retorno = rs.getInt(1);
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro ao inserir: " + e.getMessage());
        }finally{
            try{
                ConnectionFactory.closeConnection(con, pstm);
            }catch(Exception e){
               JOptionPane.showMessageDialog(null,"Erro ao fechar conexão: " + e.getMessage());
            }
        }
        return retorno;
    }

   

    

   




}


