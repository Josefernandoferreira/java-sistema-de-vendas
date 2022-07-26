/*
 * AcessoMySql.java
 *
 * Created on 3 de Fevereiro de 2008, 16:06
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.sisvenda.acessobd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Cláudio
 */
public class AcessoMySql {
    
    Connection con;
    
    /** Creates a new instance of AcessoMySql */
    public AcessoMySql() {
    }
    
    public Connection conectar(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sisvenda1","root","123");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("Não foi possível encontrar o Driver!");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Não foi possível conectar ao banco!");
        }
        return con;
    }
    
    public void desconectar(){
        try {
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
