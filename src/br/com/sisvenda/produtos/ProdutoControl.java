/*
 * ProdutoControl.java
 *
 * Created on 17 de Fevereiro de 2008, 05:24
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.sisvenda.produtos;

import br.com.sisvenda.acessobd.AcessoFirebird;
import br.com.sisvenda.acessobd.AcessoMySql;
import br.com.sisvenda.produtos.ProdutoBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cláudio
 */
public class ProdutoControl {
    
    PreparedStatement pstm;
    ResultSet rs;
    String cadastraProduto = "INSERT INTO PRODUTOS (FORNECEDORES_CODIGO, NOME, VALOR, ESTOQUE) " +
            " VALUES (?,?,?,?)";
    String consultaProduto = "SELECT * FROM PRODUTOS WHERE NOME LIKE ?";
    String alteraProduto = "UPDATE PRODUTOS SET NOME = ?, VALOR = ?, ESTOQUE = ?, FORNECEDORES_CODIGO = ? WHERE CODIGO = ?";
    String excluiProduto = "DELETE FROM PRODUTOS WHERE CODIGO = ?";
    
    //AcessoMySql bd = new AcessoMySql();
    AcessoMySql bd = new AcessoMySql();
    
    /** Creates a new instance of ProdutoControl */
    public ProdutoControl() {
    }
    
    public void cadastrarProduto(ProdutoBean produto){
        try{
            pstm = bd.conectar().prepareStatement(cadastraProduto);
            pstm.setInt(1, produto.getFornecedores_codigo());
            pstm.setString(2, produto.getNome());
            pstm.setDouble(3, produto.getValor());
            pstm.setInt(4, produto.getEstoque());
            pstm.executeUpdate();
            bd.desconectar();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public List<ProdutoBean> listarProdutos(String nome){
        List<ProdutoBean> produtos = new ArrayList();
        try{
            pstm = bd.conectar().prepareStatement(consultaProduto);
            pstm.setString(1, nome);
            rs = pstm.executeQuery();
            ProdutoBean prod;
            while (rs.next()){
                prod = new ProdutoBean();
                prod.setCodigo(rs.getInt("codigo"));
                prod.setFornecedores_codigo(rs.getInt("fornecedores_codigo"));
                prod.setNome(rs.getString("nome"));
                prod.setValor(rs.getDouble("valor"));
                prod.setEstoque(rs.getInt("estoque"));
                produtos.add(prod);
            }
            bd.desconectar();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return produtos;
    }
    
    public void alterarProduto(ProdutoBean produto){
        try{
            pstm = bd.conectar().prepareStatement(alteraProduto);
            pstm.setString(1, produto.getNome());
            pstm.setDouble(2, produto.getValor());
            pstm.setInt(3, produto.getEstoque());
            pstm.setInt(4, produto.getFornecedores_codigo());
            pstm.setInt(5, produto.getCodigo());
            pstm.executeUpdate();
            bd.desconectar();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void excluirProduto(int codigoProduto){
        try{
            pstm = bd.conectar().prepareStatement(excluiProduto);
            pstm.setInt(1, codigoProduto);
            pstm.executeUpdate();
            bd.desconectar();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
