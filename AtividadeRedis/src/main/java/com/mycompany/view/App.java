/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.view;

import com.mycompany.controle.Controle;
import java.util.Scanner;

/**
 *
 * @author kaique
 */
public class App {
    
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        int escolha = 0;
       
        Controle p = new Controle();
        
        while(escolha != 3){
            
            System.out.println("Digite 1 para salvar um produto: ");
            System.out.println("-----------------------------------");
            System.out.println("Digite 2 para buscar um produto: ");
            System.out.println("-----------------------------------");
            System.out.println("Digite 3 para sair: ");
            escolha = scan.nextInt();
             
            switch(escolha){
                case 1:
                    System.out.println("Digite o nome do produto: ");
                    String produto = scan.next();
                    System.out.println("Digite o preço do produto: ");
                    float preco = scan.nextFloat();
                    p.novoProduto(produto, preco);

                    break;
                case 2:
                    System.out.println("Digite o ID do produto: ");
                    int id = scan.nextInt();
                    String descricao = p.getProduto(id);
                    if(descricao != null) {
                        System.out.println("descricao");
                    }else System.out.println("Produto não encontrado");
                    break;
            }
        }
    }
    
}
