package com.testes.hibernate;

import java.util.ArrayList;


public class Medicamentos extends Produtos {


    ArrayList<Produtos> produtos = new ArrayList<>();



    public Medicamentos(String tipo, String nome,  int quantiaParaVenda, Double preco) {
        super(tipo, nome, quantiaParaVenda, preco);
    }

}
