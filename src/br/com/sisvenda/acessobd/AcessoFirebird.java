/*
 * AcessoFirebird.java
 *
 * Created on 3 de Fevereiro de 2008, 16:20
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
 * @author Cl�udio
 */
public class AcessoFirebird {
    
    Connection con;

    /** Creates a new instance of AcessoFirebird */
    public AcessoFirebird() {
    }
    
    public Connection conectar(){
        try {
            Class.forName("org.firebirdsql.jdbc.FBDriver");
            con = DriverManager.getConnection("jdbc:firebirdsql:localhost/3050:c:\\firebird\\sisvenda.fdb", "sysdba", "masterkey");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("N�o foi poss�vel encontrar o Driver!");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("N�o foi poss�vel conectar ao banco!");
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
