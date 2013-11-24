package br.com.rodolfohahn.locadora.persistencia;

import br.com.rodolfohahn.locadora.modelo.Cliente;
import br.com.rodolfohahn.locadora.persistencia.dao.ClienteDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;





public class ClienteDAOImplements implements ClienteDAO {

    private static final String INSERT = "insert into cliente (nome,telfixo,telcel,sexo,salarioclie,profissao,rg,cpf,datanascimento) values (?,?,?,?,?,?,?,?,?);";
    private static final String LIST = "select *from cliente;";
    private static final String REMOVE = "delete from cliente where id=?;";
    private static final String UPDATE = "update cliente set nome = ?, telfixo = ?, telcel = ?, sexo =?, salarioclie = ?, profissao = ?, rg = ?, cpf = ?, datanascimento = ? where id =?;";
    private static final String LISTBYID = "select * from cliente where id = ?;";
    private static final String LISTBYNOME = "select * from cliente where nome like ?;";
    

    @Override
    public int salvar(Cliente c) {
        if (c.getId() == 0) {
            return inserir(c);
        } else {
            return update(c);
        }
    }

    @Override
    public boolean remove(int codigo) {
         boolean status = false;
        Connection con = null;
        PreparedStatement pstm = null;
        try {

            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(REMOVE);
            pstm.setInt(1, codigo);
            pstm.execute();
            status = true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir um cliente " + e.getMessage());

        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão " + e.getMessage());
            }
        }
        return status;
    }

    @Override
    public List<Cliente> listAll() {
        Connection con = null;
        List<Cliente> clientes = new ArrayList<>();
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LIST);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setTelFixo(rs.getString("telfixo"));
                c.setTelCel(rs.getString("telcel"));
                c.setSexo(rs.getString("sexo"));
                c.setSalarioClie(rs.getDouble("salarioclie"));
                c.setProfissao(rs.getString("profissao"));
                c.setRg(rs.getString("rg"));
                c.setCpf(rs.getString("cpf"));
                c.setDataNascimento(rs.getDate("datanascimento"));
                clientes.add(c);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Listar os clientes" + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão" + e.getMessage());
            }
        }
        return clientes;
    }

    @Override
    public Cliente listById(int codigo) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Cliente c = new Cliente();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LISTBYID);
            pstm.setInt(1, codigo);
            rs = pstm.executeQuery();
            while (rs.next()) {
                
               c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setTelFixo(rs.getString("telfixo"));
                c.setTelCel(rs.getString("telcel"));
                c.setSexo(rs.getString("sexo"));
                c.setSalarioClie(rs.getDouble("salarioclie"));
                c.setProfissao(rs.getString("profissao"));
                c.setRg(rs.getString("rg"));
                c.setCpf(rs.getString("cpf"));
                c.setDataNascimento(rs.getDate("datanascimento"));
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro ao listar o clientes " + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "erro ao fechar a conexão" + e.getMessage());
            }
        }
        return c;
    }

    @Override
    public List<Cliente> listByNome(String nome) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Cliente> clientes = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LISTBYNOME);
            pstm.setString(1, "%" + nome + "%");
            rs = pstm.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setTelFixo(rs.getString("telfixo"));
                c.setTelCel(rs.getString("telcel"));
                c.setSexo(rs.getString("sexo"));
                c.setSalarioClie(rs.getDouble("salarioclie"));
                c.setProfissao(rs.getString("profissao"));
                c.setRg(rs.getString("rg"));
                c.setCpf(rs.getString("cpf"));
                c.setDataNascimento(rs.getDate("datanascimento"));
                clientes.add(c);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro ao pesquisar cliente" + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "erro ao fechar a conexão" + e.getMessage());
            }

        }
        return clientes;
    
    }

    private int inserir(Cliente c) {
        Connection con = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, c.getNome());
            pstm.setString(2, c.getTelFixo());
            pstm.setString(3, c.getTelCel());
            pstm.setString(4, c.getSexo());
            pstm.setDouble(5, c.getSalarioClie());
            pstm.setString(6, c.getProfissao());
            pstm.setString(7, c.getRg());
          
            pstm.setString(8, c.getCpf());
            pstm.setDate(9, new java.sql.Date(c.getDataNascimento().getTime()));

            pstm.execute();

            try (ResultSet rs = pstm.getGeneratedKeys()) {
                if (rs.next()) {
                    retorno = rs.getInt(1);
                }
            }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir: " + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm);
            } catch (SQLException ex) {
            }
            return retorno;
        }
    }

    private int update(Cliente c) {
         Connection con = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(UPDATE);
            pstm.setString(1, c.getNome());
            pstm.setString(2, c.getTelFixo());
            pstm.setString(3, c.getTelCel());
            pstm.setDouble(4, c.getSalarioClie());
            pstm.setString(5, c.getProfissao());
            pstm.setString(6, c.getRg());
            
            pstm.setString(7, c.getCpf());
            pstm.setDate(8, new java.sql.Date(c.getDataNascimento().getTime()));
            pstm.setInt(13, c.getId());
            pstm.execute();
            retorno = c.getId();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao editar o cliente" + e);
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão" + e.getMessage());
            }
        }
        return retorno;

    }

   




}


