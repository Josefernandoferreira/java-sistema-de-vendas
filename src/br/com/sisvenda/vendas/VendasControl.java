/*
 * VendasControl.java
 *
 * Created on 23 de Fevereiro de 2008, 02:20
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.sisvenda.vendas;

import br.com.sisvenda.acessobd.AcessoFirebird;
import br.com.sisvenda.acessobd.AcessoMySql;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cláudio
 */
public class VendasControl {
    
    PreparedStatement pstm;
    ResultSet rs;
   String cadastraVenda = "INSERT INTO VENDAS (CODIGO, PRODUTOS_CODIGO, NOME_PRODUTO, CLIENTES_CODIGO, NOME_CLIENTE, DATA_VENDA, QUANTIDADE)" +
            " VALUES(?,?,?,?,?,?,?)";
    String buscaUltimoCodigo = "SELECT MAX(CODIGO) AS CODIGO FROM VENDAS";
    String consultaVendas = "SELECT * FROM VENDAS WHERE DATA_VENDA BETWEEN ? AND ?";
    
    //AcessoMySql bd = new AcessoMySql();
    AcessoMySql bd = new AcessoMySql();
    
    /** Creates a new instance of VendasControl */
    public VendasControl() {
    }
    
     public List<VendasBean> listarVendas(Date dataInicial, Date dataFinal){
        try {
            pstm = bd.conectar().prepareStatement(consultaVendas);
            pstm.setDate(1, dataInicial);
            pstm.setDate(2, dataFinal);
            rs = pstm.executeQuery();
            List<VendasBean> venda = new ArrayList<VendasBean>();
            while (rs.next()){
                VendasBean vb = new VendasBean();
                vb.setCodigo(rs.getInt("codigo")); 
                vb.setCodigoProduto(rs.getInt("produtos_codigo"));
                vb.setNomeProduto(rs.getString("nome_produto"));
                vb.setCodigoCliente(rs.getInt("clientes_codigo"));
                vb.setNomeCliente(rs.getString("nome_cliente"));
                vb.setDataVenda(rs.getDate("data_venda"));
                vb.setQuantidade(rs.getInt("quantidade"));
                
                venda.add(vb);
            }
            bd.desconectar();
            return venda;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public int buscarCodigoUltimaVenda(){
        try {
            pstm = bd.conectar().prepareStatement(buscaUltimoCodigo);
            rs = pstm.executeQuery();
            if (rs.last()){
                return rs.getInt("codigo");
            }
            bd.desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
    
        
    public void cadastrarVenda(VendasBean venda){
        try {
            pstm = bd.conectar().prepareStatement(cadastraVenda);
            pstm.setInt(1, venda.getCodigo());
            pstm.setInt(2, venda.getCodigoProduto());
            pstm.setString(3, venda.getNomeProduto());
            pstm.setInt(4, venda.getCodigoCliente());
            pstm.setString(5, venda.getNomeCliente());
            pstm.setDate(6, venda.getDataVenda());
            pstm.setInt(7, venda.getQuantidade());
            pstm.executeUpdate();
            bd.desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}
