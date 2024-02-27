package com.testes.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;



public class Controller {
        
    public static void main(String[] args){
        ListaProdutos p = new ListaProdutos();
        Connection c = null;
        try{
                Class.forName("com.mysql.cj.jdbc.Driver");

            // Conectar com o BD

            String url = "jdbc:mysql://localhost:3306/agropequaria";

            c = DriverManager.getConnection(url, "root", null);
            System.out.println(c);

        }catch(Exception e){
                e.printStackTrace();
        }

        
        
        p.Menu(c); 
        
        
           

        }
        }

        

       
    

