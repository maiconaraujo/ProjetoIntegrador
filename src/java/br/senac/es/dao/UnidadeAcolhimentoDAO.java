/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.es.dao;

import br.senac.es.model.UnidadeAcolhimento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UnidadeAcolhimentoDAO {
    
    Connection connection = ConexaoFactory.getConnection();

    public UnidadeAcolhimentoDAO() throws SQLException, ClassNotFoundException {
        connection = ConexaoFactory.getConnection();
    }

    public UnidadeAcolhimento buscar(int codigoUnidadeAcolhimento) throws SQLException, ClassNotFoundException {

        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        String SQL = "";
        UnidadeAcolhimento unidadeAcolhimento = new UnidadeAcolhimento();

        // Obtem conexao com BD
        conn = ConexaoFactory.getConnection();

        // Comando SQL 
        SQL = "SELECT * FROM unidade_acolhimento WHERE codigo = ? ";

        preparedStatement = conn.prepareStatement(SQL);
        preparedStatement.setInt(1, codigoUnidadeAcolhimento);

        // Para buscar informações
        rs = preparedStatement.executeQuery();

        // Verifica se possui dados
        if (rs.next()) {
            unidadeAcolhimento.setCodigo(rs.getInt("codigo"));
            unidadeAcolhimento.setNome(rs.getString("nome"));
        }

        // Fechar conexao
        conn.close();

        return unidadeAcolhimento;
    }
}
