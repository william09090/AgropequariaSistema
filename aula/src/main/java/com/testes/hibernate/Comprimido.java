package com.testes.hibernate;

import java.util.ArrayList;


public class Comprimido extends Medicamentos{

    ArrayList<Medicamentos> comprimidos = new ArrayList<>();
    

    public Comprimido(String tipo,String nome, int quantiaParaVenda, Double preco) {
        super(tipo, nome, quantiaParaVenda, preco);
    }    
}
