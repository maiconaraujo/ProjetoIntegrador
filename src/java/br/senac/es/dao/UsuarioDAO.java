/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.es.dao;

import br.senac.es.model.Funcionario;
import br.senac.es.model.UnidadeAcolhimento;
import br.senac.es.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author sala308b
 */
public class UsuarioDAO {

    private Connection connection;

    public UsuarioDAO() throws SQLException, ClassNotFoundException {
        connection = ConexaoFactory.getConnection();
    }

    public boolean insert(Usuario usuario) {
        String sql = "insert into usuarios(login, senha) "
                + "values(?,?)";

        boolean resultado = false;

        try {
            this.connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, usuario.getLogin());
            preparedStatement.setString(2, usuario.getSenha());
            preparedStatement.executeUpdate();

            preparedStatement.close();
            this.connection.commit();
            resultado = true;

        } catch (SQLException ex) {
            try {

                ex.printStackTrace();
                this.connection.rollback();
            } catch (SQLException ex1) {

                ex1.printStackTrace();
            }
        } finally {
            try {
                this.connection.close();
            } catch (SQLException ex) {

                ex.printStackTrace();
            }
        }
        return resultado;
    }

    public Usuario buscar(String login, String senha) {
        String sql = "SELECT u.codigo as cod_usuario, u.login, f.codigo as cod_func, f.nome as nome_func, ua.codigo as cod_unidade, ua.nome "
                + "FROM usuario u, funcionario f, unidade_acolhimento ua WHERE u.login = ? AND u.senha = ? "
                + "AND u.funcionario_codigo = f.codigo "
                + "AND f.unidade_acolhimento_codigo = ua.codigo";
        Usuario usuario = null;

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, login);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                usuario = new Usuario();

                usuario.setCodigo(rs.getInt("cod_usuario"));
                usuario.setLogin(rs.getString("login"));
                
                Funcionario funcionario = new Funcionario();
                funcionario.setCodigo(rs.getInt("cod_func"));
                funcionario.setNome(rs.getString("nome_func"));
                
                UnidadeAcolhimento unidade = new UnidadeAcolhimento();
                unidade.setCodigo(rs.getInt("cod_unidade"));
                unidade.setNome(rs.getString("nome"));
                
                funcionario.setUnidadeAcolhimento(unidade);
                usuario.setFuncionario(funcionario);
                
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            try {
                this.connection.close();
            } catch (SQLException ex) {

                ex.printStackTrace();
            }
        }
        return usuario;
    }

    public Usuario loginParaMobile(String login, String senha) throws ClassNotFoundException, SQLException {

        connection = ConexaoFactory.getConnection();

        String sql = "SELECT u.codigo, u.login, u.funcionario_codigo FROM usuario u, funcionario f, unidade_acolhimento ua WHERE u.login = ? AND senha = ? "
                + "AND u.funcionario_codigo = f.codigo "
                + "AND f.unidade_acolhimento_codigo = ua.codigo";
        Usuario usuario = null;

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, login);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                usuario = new Usuario();
                usuario.setCodigo(rs.getInt("codigo"));
                usuario.setLogin(rs.getString("login"));
                //usuario.setSenha(rs.getString("senha"));
                Funcionario funcionario = new Funcionario();
                funcionario.setCodigo(rs.getInt("funcionario_codigo"));
                usuario.setFuncionario(funcionario);
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } finally {
            try {
                this.connection.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        }
        return usuario;
    }
}
