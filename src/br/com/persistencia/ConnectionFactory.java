
package br.com.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionFactory {
    private static final String STR_CONEXAO = "jdbc:mysql://localhost:3306/";
    private static final String DATABASE = "";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    public static Connection getConnection(){
        try{
            
        return DriverManager.getConnection(STR_CONEXAO+DATABASE,USER,PASSWORD);
         
        }catch(Exception e){
            System.out.println("erro "+e.getMessage());
        }
        return null;
    }
    
    
}
