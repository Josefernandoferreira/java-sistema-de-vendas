/*
 * ClienteControl.java
 *
 * Created on 11 de Fevereiro de 2008, 23:38
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.sisvenda.clientes;

import br.com.sisvenda.acessobd.AcessoFirebird;
import br.com.sisvenda.acessobd.AcessoMySql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Cláudio
 */
public class ClienteControl {
    
    PreparedStatement pstm;
    ResultSet rs;
    String consultaCliente = "SELECT * FROM CLIENTES WHERE NOME LIKE ?";
    String cadastraCliente = "INSERT INTO CLIENTES (NOME, ENDERECO, CIDADE, BAIRRO, UF, CEP, "+
            "TELEFONE) VALUES(?,?,?,?,?,?,?)";
    String alteraCliente = "UPDATE CLIENTES SET NOME = ?, ENDERECO = ?, CIDADE = ?, BAIRRO = ?, "+
            "UF = ?, CEP = ?, TELEFONE = ? WHERE CODIGO = ?";
    //AcessoMySql bd = new AcessoMySql();
    AcessoMySql bd = new AcessoMySql();
    
    /** Creates a new instance of ClienteControl */
    public ClienteControl() {
    }
    
    public void alterarCliente(ClienteBean cliente){
        try{
            pstm = bd.conectar().prepareStatement(alteraCliente);
            pstm.setString(1, cliente.getNome());
            pstm.setString(2, cliente.getEndereco());
            pstm.setString(3, cliente.getCidade());
            pstm.setString(4, cliente.getBairro());
            pstm.setString(5, cliente.getUF());
            pstm.setString(6, cliente.getCep());
            pstm.setString(7, cliente.getTelefone());
            pstm.setInt(8, cliente.getCodigo());
            pstm.executeUpdate();
            bd.desconectar();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void cadastrarCliente(ClienteBean cliente){
        try{
            pstm = bd.conectar().prepareStatement(cadastraCliente);
            pstm.setString(1, cliente.getNome());
            pstm.setString(2, cliente.getEndereco());
            pstm.setString(3, cliente.getCidade());
            pstm.setString(4, cliente.getBairro());
            pstm.setString(5, cliente.getUF());
            pstm.setString(6, cliente.getCep());
            pstm.setString(7, cliente.getTelefone());
            pstm.executeUpdate();
            bd.desconectar();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public List<ClienteBean> listarClientes(String nome){
        List<ClienteBean> clientes = new ArrayList();
        try{
            pstm = bd.conectar().prepareStatement(consultaCliente);
            pstm.setString(1, nome);//SELECT * FROM CLIENTES WHERE NOME LIKE claudio
            rs = pstm.executeQuery();
            ClienteBean cli;
            while (rs.next()){
                cli = new ClienteBean();
                cli.setCodigo(rs.getInt("codigo"));
                cli.setNome(rs.getString("nome"));
                cli.setEndereco(rs.getString("endereco"));
                cli.setBairro(rs.getString("bairro"));
                cli.setCidade(rs.getString("cidade"));
                cli.setUF(rs.getString("uf"));
                cli.setCep(rs.getString("cep"));
                cli.setTelefone(rs.getString("telefone"));
                clientes.add(cli);
            }
            bd.desconectar();
        } catch(Exception e){
            e.printStackTrace();
        }
        return clientes;
    }
    
}
