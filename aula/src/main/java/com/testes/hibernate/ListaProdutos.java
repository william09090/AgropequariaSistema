package com.testes.hibernate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;



public class ListaProdutos {
     Connection conexao;

    Integer id;
    ArrayList<Produtos> listaProdutos = new ArrayList<>();
         Scanner scanner = new Scanner(System.in);

        int opcao = 0;
        public void Menu(Connection c){
                do {
            System.out.println("=== Menu ===");
            System.out.println("1. Cadastrar produto");
            System.out.println("2. Excluir produto");
            System.out.println("3. Listar produtos");
            System.out.println("4. Salvar alteraçoes");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.print("Digite o tipo do produto (Comprimido/Injeção/Ração): ");
                    String tipo = scanner.nextLine();
                    System.out.print("Digite o nome do produto: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite a quantidade para venda: ");
                    int quantiaParaVenda = scanner.nextInt();
                    System.out.print("Digite o preço do produto: ");
                    double preco = scanner.nextDouble();
                    Produtos produto;

                    if (tipo.equalsIgnoreCase("Comprimido")) {
                        produto = new Comprimido(tipo, nome, quantiaParaVenda, preco);
                    } else if (tipo.equalsIgnoreCase("Injecao")) {
                        produto = new Injecao(tipo, nome, quantiaParaVenda, preco);
                    } else if (tipo.equalsIgnoreCase("Racao")) {
                        produto = new Racao(tipo, nome, quantiaParaVenda, preco);
                    } else {
                        System.out.println("Tipo de produto inválido.");
                        break;
                    }

                    listaProdutos.add(produto);
                    System.out.println("Produto cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.print("Digite o nome do produto a ser excluído: ");
                    String nomeExcluir = scanner.nextLine();
                    boolean produtoRemovido = false;
                    try{
                    for (Produtos p : listaProdutos) {
                        if (p.getNome().equals(nomeExcluir)) {
                            listaProdutos.remove(p);
                            produtoRemovido = true;
                            
                            PreparedStatement ps = c
                            .prepareStatement("delete from produtos where nome = " +  p.getNome());
                            ps.execute();
                        }
                        
                    }
                }
                    catch(Exception e){
                        e.printStackTrace();
                    }


                    if (produtoRemovido) {
                        System.out.println("Produto removido com sucesso!");
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;

                case 3:
                    System.out.println("=== Lista de Produtos ===");
                    try{
                    for (Produtos p : listaProdutos) {
                        System.out.println(p.toString());
                        PreparedStatement ps = c
                        .prepareStatement("select * from produtos");
                        
                        ps.execute();

                        ResultSet a = ps.getResultSet();


                        while(a.next()){
                            System.out.println(a.getString("tipo"));  
                            System.out.println(a.getString("nome"));  
                            System.out.println(a.getInt("QuantiaParaVenda"));  
                            System.out.println(a.getDouble("preco"));  

                            
                        }
                    }
                    }catch(Exception e){
                        e.printStackTrace();
                    }

                    break;
                

                case 4: System.out.println("Salvando produtos...");     
                    try{
                    for(Produtos produtos : listaProdutos){
                        
                    PreparedStatement ps = c
                    .prepareStatement("insert into  produtos (tipo, nome, quantiaParaVenda, preco) values (?, ?, ?, ?)");       
                    ps.setString(1, produtos.getTipo());
                    ps.setString(2, produtos.getNome());
                    ps.setInt(3, produtos.getQuantiaParaVenda());
                    ps.setDouble(4, produtos.getPreco());

                    ps.execute();
                    System.out.println("Salvo com sucesso");
                    }
                    }catch(Exception e){
                        e.printStackTrace();
                    }

                break;


                case 5:
                    System.out.println("Saindo do programa...");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }

            System.out.println();
        } while (opcao != 5);
    }
}





        