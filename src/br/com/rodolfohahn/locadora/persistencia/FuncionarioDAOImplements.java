package br.com.rodolfohahn.locadora.persistencia;

import br.com.rodolfohahn.locadora.controller.view.JanelaLogin;
import br.com.rodolfohahn.locadora.modelo.Endereco;
import br.com.rodolfohahn.locadora.modelo.Funcionario;
import br.com.rodolfohahn.locadora.persistencia.dao.FuncionarioDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class FuncionarioDAOImplements implements FuncionarioDAO {

    private static final String INSERT = "insert into funcionario (nome,telfixo,telcel,sexo,rg,cpf,idade,salario,ctps,login,senha,dataadmissao) values (?,?,?,?,?,?,?,?,?,?,?,?);";
    private static final String LIST = "select *from funcionario;";
    private static final String REMOVE = "delete from funcionario where id=?;";
    private static final String UPDATE = "update funcionario set nome = ?, telfixo = ?, telcel = ?, sexo =?, rg = ?, cpf = ?, idade = ?, salario = ?, ctps = ?, login = ?, senha = ?, dataadmissao = ? where id =?;";
    private static final String LISTBYID = "select * from funcionario where id = ?;";
    private static final String LISTBYNOME = "select * from funcionario where nome like ?;";
    private static final String LOGIN = "select login,senha from funcionario;";

    @Override
    public int salvar(Funcionario f) {
        if (f.getId() == 0) {
            return inserir(f);
        } else {
            return update(f);
        }

    }

    private int inserir(Funcionario f) {
        Connection con = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, f.getNome());
            pstm.setString(2, f.getTelFixo());
            pstm.setString(3, f.getTelCel());
            pstm.setString(4, f.getSexo());
            pstm.setString(5, f.getRg());
            pstm.setString(6, f.getCpf());
            
            pstm.setInt(7, f.getIdade());
            pstm.setDouble(8, f.getSalario());
            pstm.setString(9, f.getCtps());
            pstm.setString(10, f.getLogin());
            pstm.setString(11, f.getSenha());
            pstm.setDate(12, new java.sql.Date(f.getDataAdmissao().getTime()));

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
            JOptionPane.showMessageDialog(null, "Erro ao excluir um funcionario " + e.getMessage());

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
    public List<Funcionario> listAll() {
        Connection con = null;
        List<Funcionario> funcionarios = new ArrayList<>();
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LIST);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Funcionario f = new Funcionario();
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setLogin(rs.getString("login"));
                f.setSenha(rs.getString("senha"));
                f.setCpf(rs.getString("cpf"));
                f.setTelFixo(rs.getString("telfixo"));
                f.setTelCel(rs.getString("telcel"));
                f.setSexo(rs.getString("sexo"));
                f.setDataAdmissao(rs.getDate("dataAdmissao"));
//                Endereco e = new Endereco();
//                e.setCidade(rs.getString("cidade"));
//                e.setCep(rs.getString("cep"));
//                e.setBairro(rs.getString("bairro"));
//                e.setRua(rs.getString("rua"));
//                e.setNumero(rs.getInt("numero"));
//                e.setComplemento(rs.getString("complemento"));
//                f.setEndereco(e);
                funcionarios.add(f);




            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Listar os funcionarios1" + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão" + e.getMessage());
            }
        }
        return funcionarios;
    }

    @Override
    public Funcionario listById(int id) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Funcionario f = new Funcionario();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LISTBYID);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setLogin(rs.getString("login"));
                f.setSenha(rs.getString("senha"));
                f.setCpf(rs.getString("cpf"));
                f.setTelFixo(rs.getString("telfixo"));
                f.setTelCel(rs.getString("telcel"));
                f.setSexo(rs.getString("sexo"));
                f.setDataAdmissao(rs.getDate("dataAdmissao"));
//                Endereco e = new Endereco();
//                e.setCidade(rs.getString("cidade"));
//                e.setCep(rs.getString("cep"));
//                e.setBairro(rs.getString("bairro"));
//                e.setRua(rs.getString("rua"));
//                e.setNumero(rs.getInt("numero"));
//                e.setComplemento(rs.getString("complemento"));
//                f.setEndereco(e);
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro ao listar o funcionario2 " + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "erro ao fechar a conexão" + e.getMessage());
            }
        }
        return f;
    }

    private int update(Funcionario f) {
        Connection con = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(UPDATE);
            pstm.setString(1, f.getNome());
//            pstm.setInt(2, f.getEndereco().getId_end());
            pstm.setString(2, f.getTelFixo());
            pstm.setString(3, f.getTelCel());
            pstm.setString(4, f.getSexo());
            pstm.setString(5, f.getRg());
            pstm.setString(6, f.getCpf());
            pstm.setInt(7, f.getIdade());
            pstm.setDouble(8, f.getSalario());
            pstm.setString(9, f.getCtps());
            pstm.setString(10, f.getLogin());
            pstm.setString(11, f.getSenha());
            pstm.setDate(12, new java.sql.Date(f.getDataAdmissao().getTime()));
            pstm.setInt(13, f.getId());
            pstm.execute();
            retorno = f.getId();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao editar o funcionario3" + e);
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão" + e.getMessage());
            }
        }
        return retorno;
    }

    @Override
    public List<Funcionario> listByNome(String nome) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Funcionario> funcionarios = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LISTBYNOME);
            pstm.setString(1, "%" + nome + "%");
            rs = pstm.executeQuery();
            while (rs.next()) {
                Funcionario f = new Funcionario();
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setLogin(rs.getString("login"));
                f.setSenha(rs.getString("senha"));
                f.setCpf(rs.getString("cpf"));
                f.setTelFixo(rs.getString("telfixo"));
                f.setTelCel(rs.getString("telcel"));
                f.setSexo(rs.getString("sexo"));
                f.setDataAdmissao(rs.getDate("dataAdmissao"));
                funcionarios.add(f);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro ao pesquisar Funcionario4" + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "erro ao fechar a conexão" + e.getMessage());
            }

        }
        return funcionarios;
    
    
    }
    
    
    
    public boolean TesteSenha(String txLogin, String txSenha){
        boolean TesteSenha = false;
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try{
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LOGIN);
            rs = pstm.executeQuery();
            while(rs.next()){
                if(rs.getString("login").equals(txLogin) && rs.getString("senha").equals(txSenha)){
                  TesteSenha = true;
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro ao autenticar: " + e.getMessage());
        }finally{
            try{
                ConnectionFactory.closeConnection(con, pstm, rs);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Erro ao fechar conexão: " + e.getMessage());
            }
        }
        return TesteSenha;
    




}
}

