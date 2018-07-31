/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author kaique
 */
public class Conexao {
    
    public Connection getConnection() throws SQLException{
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/AtividadeRedis";
            String user = "postgres";
            String pass = "k123456";
            
            try{
               con = DriverManager.getConnection(url,user,pass);
            } catch(SQLException ex){
                System.out.println("ERRO AO CONECTAR "+ ex.getMessage());
                return null;
            }
        } catch (ClassNotFoundException ex) {
                System.out.println("ERRO AO CARREGAR O DRIVER "+ ex.getMessage());
                return null;
        }
        return con;
    }
}
