/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controle;

import com.mycompany.conexao.Conexao;
import com.mycompany.modelo.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kaique
 */
public class ProdutoDao {
    
    public boolean salvarProduto (Produto p) {
        
        Connection con;
        try {
            con = new Conexao().getConnection();
            String sql = "INSERT INTO PRODUTO(descricao, preco) VALUES (?, ?)";
            
            PreparedStatement state = con.prepareStatement(sql);
            state.setString(1, p.getDescricao());
            state.setFloat(2, p.getPreco());
            
            state.executeUpdate();
            state.close();
            
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao salvar o produto : " + ex.getMessage());
        }               
        return false;
        
    }
    
    public List<Produto> getProdutos () {
        try {
            List<Produto> produtos = new ArrayList<>();
            Connection con = new Conexao().getConnection();
            String sql = "SELECT * FROM PRODUTOS";
            Statement state = con.createStatement(
                    ResultSet.CONCUR_UPDATABLE,
                    ResultSet.HOLD_CURSORS_OVER_COMMIT,
                    ResultSet.TYPE_SCROLL_SENSITIVE
            );
            
            ResultSet result = state.executeQuery(sql);
            
            while(result.next()) {
                Produto p = new Produto();
                p.setCodigo(result.getInt("id"));
                p.setDescricao(result.getString("descricao"));
                p.setPreco(result.getFloat("preco"));            
                produtos.add(p);
            }        
            return produtos;
        } catch (SQLException ex) {
            return null;
        }       
        
    }
}
