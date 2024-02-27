package com.testes.hibernate;



public class Racao extends Produtos{
 
    private Double precoPorQuilo;
    private Double precoPorSaco;
    private String raca;
    

    ListaProdutos p = new ListaProdutos();

        public Double getPrecoPorQuilo(){
        return precoPorQuilo;
    }

            public Double getPrecoPorSaco(){
        return precoPorSaco;
    }

        public String getRaca(){
        return raca;
    }




    public Racao(String tipo, String nome, int quantiaParaVenda, Double preco) {
        super( tipo, nome, quantiaParaVenda, preco);
    }

    
}
