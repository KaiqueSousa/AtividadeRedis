/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.modelo;

import com.mycompany.controle.ProdutoDao;

/**
 *
 * @author kaique
 */
public class Produto {
    
    private int codigo;
    private String descricao;
    private float preco;
    
    public Produto () {}

    public Produto(int codigo, String descricao, float preco) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
    }
    
     public Produto(String descricao, float preço) {
        this.descricao = descricao;
        this.preco = preco;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
    
    
    public void salvar (Produto p) {
        ProdutoDao dao = new ProdutoDao();
        dao.salvarProduto(p);
    }    

    @Override
    public String toString() {
        return "Produto{" + "codigo=" + codigo + ", descricao=" + descricao + ", preco=" + preco + '}';
    }
}
