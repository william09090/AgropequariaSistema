package com.testes.hibernate;

import java.util.Scanner;




public class Produtos {


    private String tipo;
    private String nome;
    private int quantiaParaVenda;
    private double preco;
    

    public String getNome(){
        return nome;
    }

    public String getTipo(){
        return tipo;
    }

    public int getQuantiaParaVenda(){
        return quantiaParaVenda;
    }

    public Double getPreco(){
        return preco;
    }

    public void setNome(String nome){
        this.nome = nome;
    }


    public void setQuantiaParaVenda(int quantiaParaVenda){
        this.quantiaParaVenda += quantiaParaVenda;
    }

    public void setPreco(Double preco){
        this.preco =  preco;
    }
    public String toString() {
        return "Tipo: " + tipo + "nome: " + nome + ", Quantidade: " + quantiaParaVenda + "Preço: " + preco;
    }


    public Produtos(String tipo, String nome ,int quantiaParaVenda ,Double preco){
        this.tipo = tipo;
        this.nome = nome;
        this.quantiaParaVenda = quantiaParaVenda;
        this.preco = preco;
    }

}
