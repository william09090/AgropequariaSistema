package com.testes.hibernate;

import java.util.ArrayList;


public class Injecao extends Medicamentos {
    

    ArrayList<Medicamentos> injecao = new ArrayList<>();
   

    public Injecao(String tipo, String nome, int quantiaParaVenda, Double preco) {
        super(tipo, nome, quantiaParaVenda, preco);
    }

}
