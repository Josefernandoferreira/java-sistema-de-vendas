/*
 * VendasBean.java
 *
 * Created on 23 de Fevereiro de 2008, 02:18
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.sisvenda.vendas;

import java.sql.Date;

/**
 *
 * @author Cláudio
 */
public class VendasBean {
    
    /** Creates a new instance of VendasBean */
    public VendasBean() {
    }
    
    private Integer codigo;
    private Integer codigoProduto;
    private Integer codigoCliente;

  
    private String NomeProduto;
    private String NomeCliente;
    private Date dataVenda;
    private Integer quantidade;
    
    
    
      public String getNomeProduto() {
        return NomeProduto;
    }

    public void setNomeProduto(String NomeProduto) {
        this.NomeProduto = NomeProduto;
    }

    
       public String getNomeCliente() {
        return NomeCliente;
    }

    public void setNomeCliente(String NomeCliente) {
        this.NomeCliente = NomeCliente;
    }
    
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(Integer codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public Integer getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(Integer codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
