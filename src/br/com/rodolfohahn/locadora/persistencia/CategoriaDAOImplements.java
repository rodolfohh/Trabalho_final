package br.com.rodolfohahn.locadora.persistencia;

import br.com.rodolfohahn.locadora.modelo.CategoriaFilme;
import br.com.rodolfohahn.locadora.persistencia.dao.CategoriaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CategoriaDAOImplements implements CategoriaDAO{
    private static final String INSERT = "insert into categoria (nome_categoria) values (?);";
    private static final String LIST = "select *from categoria;";
    private static final String REMOVE = "delete from categoria where id=?;";
    private static final String UPDATE = "update categoria set nome_categoria = ? where id =?;";
    private static final String LISTBYID = "select * from categoria where id = ?;";
    private static final String LISTBYNOME = "select * from categoria where nome_categoria like ?;";

    @Override
    public int salvar(CategoriaFilme cf) {
         if (cf.getId() == 0) {
            return inserir(cf);
        } else {
            return update(cf);
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
            JOptionPane.showMessageDialog(null, "Erro ao excluir um categoria " + e.getMessage());

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
    public List<CategoriaFilme> listAll() {
        Connection con = null;
        List<CategoriaFilme> categorias = new ArrayList<>();
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LIST);
            rs = pstm.executeQuery();
            while (rs.next()) {
                CategoriaFilme cf = new CategoriaFilme();
                cf.setId(rs.getInt("id"));
                cf.setNome_categoria(rs.getString("nome_categoria"));
             
                categorias.add(cf);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Listar os categorias" + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão" + e.getMessage());
            }
        }
        return categorias;
    }

    @Override
    public CategoriaFilme listById(int codigo) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        CategoriaFilme cf = new CategoriaFilme();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LISTBYID);
            pstm.setInt(1, codigo);
            rs = pstm.executeQuery();
            while (rs.next()) {
                
               cf.setId(rs.getInt("id"));
                cf.setNome_categoria(rs.getString("nome_categoria"));
                
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro ao listar o categoria " + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "erro ao fechar a conexão" + e.getMessage());
            }
        }
        return cf;
    }

    @Override
    public List<CategoriaFilme> listByNome(String nome) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<CategoriaFilme> categorias = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LISTBYNOME);
            pstm.setString(1, "%" + nome + "%");
            rs = pstm.executeQuery();
            while (rs.next()) {
                CategoriaFilme cf = new CategoriaFilme();
                cf.setId(rs.getInt("id"));
                cf.setNome_categoria(rs.getString("nome_categoria"));
                
                categorias.add(cf);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro ao pesquisar categorias" + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "erro ao fechar a conexão" + e.getMessage());
            }

        }
        return categorias;
    }

    private int inserir(CategoriaFilme cf) {
        Connection con = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, cf.getNome_categoria());
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

    private int update(CategoriaFilme cf) {
        Connection con = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(UPDATE);
            pstm.setString(1, cf.getNome_categoria());
            pstm.setInt(2, cf.getId());
            pstm.execute();
            retorno = cf.getId();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao editar o categoria" + e);
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
