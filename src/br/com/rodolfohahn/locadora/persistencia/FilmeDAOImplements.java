package br.com.rodolfohahn.locadora.persistencia;

import br.com.rodolfohahn.locadora.modelo.CategoriaFilme;
import br.com.rodolfohahn.locadora.modelo.Filme;
import br.com.rodolfohahn.locadora.persistencia.dao.FilmeDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;





public class FilmeDAOImplements implements FilmeDAO {

    private static final String INSERT = "insert into filme (nomefilme,duracaofilme,descricaofilme,categoria,datalancamento) values (?,?,?,?,?);";
    private static final String LIST = "select *from filme;";
    private static final String REMOVE = "delete from filme where id=?;";
    private static final String UPDATE = "update filme set nomefilme = ?, duracaofilme = ?, descricaofilme = ?, categoria =?, datalancamento = ? where id =?;";
    private static final String LISTBYID = "select * from filme where id = ?;";
    private static final String LISTBYNOME = "select * from filme where nomefilme like ?;";
    

    @Override
    public int salvar(Filme c) {
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
    public List<Filme> listAll() {
        Connection con = null;
        List<Filme> filmes = new ArrayList<>();
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LIST);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Filme f = new Filme();
                f.setId(rs.getInt("id"));
                f.setNomeFilme(rs.getString("nomefilme"));
                f.setDuracaoFilme(rs.getInt("duracaofilme"));
                f.setDescricaoFilme(rs.getString("descricaofilme"));
                f.setCategoria(null);
                CategoriaFilme cf = new CategoriaFilme();
                cf.setId(rs.getInt("categoria.id"));
                cf.setNome_categoria(rs.getString("categoria.nome_categoria"));
                f.setCategoria(cf);
                f.setDataLancamento(rs.getDate("datalancamento"));
                filmes.add(f);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Listar os filmes" + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão" + e.getMessage());
            }
        }
        return filmes;
    }

    @Override
    public Filme listById(int codigo) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Filme f = new Filme();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LISTBYID);
            pstm.setInt(1, codigo);
            rs = pstm.executeQuery();
            while (rs.next()) {
                
               f.setId(rs.getInt("id"));
                f.setNomeFilme(rs.getString("nomefilme"));
                f.setDuracaoFilme(rs.getInt("duracaofilme"));
                f.setDescricaoFilme(rs.getString("descricaofilme"));
                f.setCategoria(null);
                CategoriaFilme cf = new CategoriaFilme();
                cf.setId(rs.getInt("categoria.id"));
                cf.setNome_categoria(rs.getString("categoria.nome_categoria"));
                f.setCategoria(cf);
                f.setDataLancamento(rs.getDate("datalancamento"));
                
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro ao listar o filmes " + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "erro ao fechar a conexão" + e.getMessage());
            }
        }
        return f;
    }

    @Override
    public List<Filme> listByNome(String nome) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Filme> filmes = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LISTBYNOME);
            pstm.setString(1, "%" + nome + "%");
            rs = pstm.executeQuery();
            while (rs.next()) {
                Filme f = new Filme();
                f.setId(rs.getInt("id"));
                f.setNomeFilme(rs.getString("nomefilme"));
                f.setDuracaoFilme(rs.getInt("duracaofilme"));
                f.setDescricaoFilme(rs.getString("descricaofilme"));
                f.setCategoria(null);
                CategoriaFilme cf = new CategoriaFilme();
                cf.setId(rs.getInt("categoria.if"));
                cf.setNome_categoria(rs.getString("categoria.nome_categoria"));
                f.setCategoria(cf);
                f.setDataLancamento(rs.getDate("datalancamento"));
                filmes.add(f);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro ao pesquisar filmes" + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "erro ao fechar a conexão" + e.getMessage());
            }

        }
        return filmes;
    
    }

    private int inserir(Filme f) {
        Connection con = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, f.getNomeFilme());
            pstm.setInt(2, f.getDuracaoFilme());
            pstm.setString(3, f.getDescricaoFilme());
            pstm.setDouble(4, f.getCategoria().getId());
            pstm.setDate(6, new java.sql.Date(f.getDataLancamento().getTime()));

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

    private int update(Filme f) {
         Connection con = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(UPDATE);
           pstm.setString(1, f.getNomeFilme());
            pstm.setInt(2, f.getDuracaoFilme());
            pstm.setString(3, f.getDescricaoFilme());
            pstm.setDouble(4, f.getCategoria().getId());
            pstm.setDate(6, new java.sql.Date(f.getDataLancamento().getTime()));
            pstm.setInt(7, f.getId());
            pstm.execute();
            retorno = f.getId();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao editar o filme" + e);
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


