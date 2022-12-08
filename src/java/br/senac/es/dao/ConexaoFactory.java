/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.es.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexaoFactory {
public static Connection getConnection() throws SQLException, ClassNotFoundException{
        
        Connection conn = null;
        
        String driver = "org.postgresql.Driver";
        String banco = "jdbc:postgresql://179.127.193.11:5432/bd_sistemagac";
        String usuarioBD = "user_gac";
        String senha = "gac@es157";
        
        try { 
            Class.forName(driver);
            conn = DriverManager.getConnection(banco, usuarioBD, senha);
        } catch (SQLException | ClassNotFoundException e) { 
    		throw e; 
        } 
        return conn;
    }   
}
