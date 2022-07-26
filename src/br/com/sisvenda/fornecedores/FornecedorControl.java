/*
 * FornecedorControl.java
 *
 * Created on 15 de Fevereiro de 2008, 00:18
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.sisvenda.fornecedores;

import br.com.sisvenda.acessobd.AcessoFirebird;
import br.com.sisvenda.acessobd.AcessoMySql;
import br.com.sisvenda.clientes.ClienteBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cláudio
 */
public class FornecedorControl {
    
    /** Creates a new instance of FornecedorControl */
    public FornecedorControl() {
    }
    PreparedStatement pstm;
    ResultSet rs;
    String consultaFornecedor = "SELECT * FROM FORNECEDORES WHERE NOME LIKE ?";
    String cadastraFornecedor = "INSERT INTO FORNECEDORES (NOME, ENDERECO, CIDADE, BAIRRO, UF, CEP, "+
            "TELEFONE) VALUES(?,?,?,?,?,?,?)";
    String alteraFornecedor = "UPDATE FORNECEDORES SET NOME = ?, ENDERECO = ?, CIDADE = ?, BAIRRO = ?, "+
            "UF = ?, CEP = ?, TELEFONE = ? WHERE CODIGO = ?";
    //AcessoMySql bd = new AcessoMySql();
      AcessoMySql bd = new AcessoMySql();
    
    public void alterarFornecedor(FornecedorBean fornecedor){
        try{
            pstm = bd.conectar().prepareStatement(alteraFornecedor);
            pstm.setString(1, fornecedor.getNome());
            pstm.setString(2, fornecedor.getEndereco());
            pstm.setString(3, fornecedor.getCidade());
            pstm.setString(4, fornecedor.getBairro());
            pstm.setString(5, fornecedor.getUf());
            pstm.setString(6, fornecedor.getCep());
            pstm.setString(7, fornecedor.getTelefone());
            pstm.setInt(8, fornecedor.getCodigo());
            pstm.executeUpdate();
            bd.desconectar();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void cadastrarFornecedor(FornecedorBean fornecedor){
        try{
            pstm = bd.conectar().prepareStatement(cadastraFornecedor);
            pstm.setString(1, fornecedor.getNome());
            pstm.setString(2, fornecedor.getEndereco());
            pstm.setString(3, fornecedor.getCidade());
            pstm.setString(4, fornecedor.getBairro());
            pstm.setString(5, fornecedor.getUf());
            pstm.setString(6, fornecedor.getCep());
            pstm.setString(7, fornecedor.getTelefone());
            pstm.executeUpdate();
            bd.desconectar();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public List<FornecedorBean> listarFornecedores(String nome){
        List<FornecedorBean> fornecedores = new ArrayList();
        try{
            pstm = bd.conectar().prepareStatement(consultaFornecedor);
            pstm.setString(1, nome);//SELECT * FROM CLIENTES WHERE NOME LIKE claudio
            rs = pstm.executeQuery();
            FornecedorBean fornec;
            while (rs.next()){
                fornec = new FornecedorBean();
                fornec.setCodigo(rs.getInt("codigo"));
                fornec.setNome(rs.getString("nome"));
                fornec.setEndereco(rs.getString("endereco"));
                fornec.setBairro(rs.getString("bairro"));
                fornec.setCidade(rs.getString("cidade"));
                fornec.setUf(rs.getString("uf"));
                fornec.setCep(rs.getString("cep"));
                fornec.setTelefone(rs.getString("telefone"));
                fornecedores.add(fornec);
            }
            bd.desconectar();
        } catch(Exception e){
            e.printStackTrace();
        }
        return fornecedores;
    }
}
