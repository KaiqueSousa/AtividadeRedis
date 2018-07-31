/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controle;

import com.google.gson.Gson;
import com.mycompany.modelo.Produto;
import redis.clients.jedis.Jedis;

/**
 *
 * @author kaique
 */
public class Controle {
    
    Jedis jedis = new Jedis("localhost", 6379);
    Gson gson = new Gson();
    ProdutoDao dao = new ProdutoDao();
    
    public void novoProduto (String descricao, float preco) {
       Produto p = new Produto();       
       p.setDescricao(descricao);
       p.setPreco(preco);
       dao.salvarProduto(p);
       
    }
    
    public String getProduto ( int id ) {   
        
        if(getCache(id) != null ){
            return getCache(id).getDescricao();
        }
        else {
            for(Produto p : dao.getProdutos()) {
                if(p.getCodigo() == id) {
                    salvarCache(p);
                    return p.getDescricao();
                }
            }
            return null;
        }
    }
        
    
    public void salvarCache(Produto p) {
        String key = p.getCodigo()+"";
        String produto = gson.toJson(p);
        System.out.println("Salvo no cache" + produto);   
        jedis.set(key,produto);
        jedis.expire(key, 1800);
        
    }
    
    
    public Produto getCache (int id) {
       String key = id+"";
        System.out.println("chave " + key);
       String produto = jedis.get(key);
       System.out.println("Produto no getCache " + produto);
       Produto p = gson.fromJson(produto, Produto.class);
        
       if(p != null ){
          return p;
       }
       else return null;
    }
}
