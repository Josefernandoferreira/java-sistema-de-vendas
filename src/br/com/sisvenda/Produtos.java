/*
 * Produtos.java
 *
 * Created on 23 de Janeiro de 2008, 23:57
 */

package br.com.sisvenda;

import br.com.sisvenda.fornecedores.FornecedorBean;
import br.com.sisvenda.fornecedores.FornecedorControl;
import br.com.sisvenda.produtos.ProdutoBean;
import br.com.sisvenda.produtos.ProdutoControl;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author  Cl�udio
 */
public class Produtos extends javax.swing.JFrame {
    
    DefaultTableModel tmProdutos = new DefaultTableModel(null, new String[] {"C�digo", "C�d. Fornec.", "Nome", "Valor", "Qtde Estoque"});
    ListSelectionModel lsmProdutos;
    List<ProdutoBean> produtos;
    List<FornecedorBean> fornecedores;
    
    /** Creates new form Produtos */
    public Produtos() {
        initComponents();
        fornecedores = new FornecedorControl().listarFornecedores("%%");
        System.out.println(fornecedores.size());
        cbFornecedores.removeAllItems();
        for (int i = 0; i < fornecedores.size(); i++){
            cbFornecedores.addItem(fornecedores.get(i).getNome());
        }
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfPesquisaProduto = new javax.swing.JTextField();
        btPesquisaProduto = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbProdutos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        tfValor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfEstoque = new javax.swing.JTextField();
        btNovo = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btFechar = new javax.swing.JButton();
        cbFornecedores = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();

        setTitle("Produtos");

        btPesquisaProduto.setText("Pesquisar");
        btPesquisaProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisaProdutoActionPerformed(evt);
            }
        });

        tbProdutos.setModel(tmProdutos);
        tbProdutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lsmProdutos = tbProdutos.getSelectionModel();
        lsmProdutos.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (! e.getValueIsAdjusting()){
                    tbProdutosLinhaSelecionada();
                }
            }
        });
        jScrollPane1.setViewportView(tbProdutos);

        jLabel1.setText("Nome:");

        jLabel2.setText("Valor:");

        jLabel3.setText("Fornecedor:");

        jLabel4.setText("Estoque:");

        btNovo.setText("Salvar");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        btAlterar.setText("Alterar");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btFechar.setText("Fechar");
        btFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFecharActionPerformed(evt);
            }
        });

        cbFornecedores.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel10.setText("Produtos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btFechar)
                .addGap(131, 131, 131))
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tfPesquisaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btPesquisaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                                .addGap(77, 77, 77))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1)
                                    .addComponent(cbFornecedores, 0, 286, Short.MAX_VALUE)
                                    .addComponent(tfNome))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(tfEstoque, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                            .addComponent(tfValor))
                        .addContainerGap(89, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(205, 205, 205)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btAlterar, btExcluir, btFechar, btNovo});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfPesquisaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btPesquisaProduto))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(4, 4, 4)
                        .addComponent(tfValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btFechar)
                    .addComponent(btAlterar)
                    .addComponent(btExcluir)
                    .addComponent(btNovo))
                .addGap(49, 49, 49))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btAlterar, btExcluir, btFechar, btNovo, btPesquisaProduto});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btFecharActionPerformed
    
    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        excluirProduto();
    }//GEN-LAST:event_btExcluirActionPerformed
    
    private void excluirProduto(){
        if (tbProdutos.getSelectedRow() != -1){
            int resposta = JOptionPane.showConfirmDialog(this, "Excluir produto selecionado?", "Confirma��o",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION){
                ProdutoControl pc = new ProdutoControl();
                pc.excluirProduto(produtos.get(tbProdutos.getSelectedRow()).getCodigo());
            }
        }
    }
    
    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        alterarProduto();
    }//GEN-LAST:event_btAlterarActionPerformed
    
    private void alterarProduto(){
        if (tbProdutos.getSelectedRow() != -1){
            if (! verificaNome()){
                JOptionPane.showMessageDialog(this, "Informe o nome do produto!");
                tfNome.requestFocus();
            } else if (! verificaValor()){
                JOptionPane.showMessageDialog(this, "Valor inv�lido!");
                tfValor.requestFocus();
            } else if (! verificaEstoque()){
                JOptionPane.showMessageDialog(this, "Valor do estoque inv�lido!");
                tfEstoque.requestFocus();
            } else {
                ProdutoControl pc = new ProdutoControl();
                ProdutoBean produto = new ProdutoBean();
                produto.setCodigo(produtos.get(tbProdutos.getSelectedRow()).getCodigo());
                produto.setFornecedores_codigo(fornecedores.get(cbFornecedores.getSelectedIndex()).getCodigo());
                System.out.println(fornecedores.get(cbFornecedores.getSelectedIndex()).getCodigo());
                produto.setNome(tfNome.getText());
                produto.setValor(Double.parseDouble(tfValor.getText().trim()));
                produto.setEstoque(Integer.parseInt(tfEstoque.getText().trim()));
                pc.alterarProduto(produto);
                JOptionPane.showMessageDialog(this, "Produto alterado com sucesso!");
            }
        } else{
            JOptionPane.showMessageDialog(this, "Selecione um produto!");
        }
    }
    
    private void btPesquisaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisaProdutoActionPerformed
        listarProdutos();
    }//GEN-LAST:event_btPesquisaProdutoActionPerformed
    
    protected void listarProdutos(){
        ProdutoControl prd = new ProdutoControl();
        produtos = prd.listarProdutos("%" + tfPesquisaProduto.getText().trim() + "%");
        mostrarProdutos(produtos);
    }
    
    protected void mostrarProdutos(List<ProdutoBean> produtos){
        while (tmProdutos.getRowCount() > 0){
            tmProdutos.removeRow(0);
        }
        
        if (produtos.size() == 0){
            JOptionPane.showMessageDialog(this, "Nenhum produto encontrado!");
        }else{
            String [] campos = new String[] {null, null, null, null};
            for (int i = 0; i < produtos.size(); i++){
                tmProdutos.addRow(campos);
                tmProdutos.setValueAt(produtos.get(i).getCodigo(), i, 0);
                tmProdutos.setValueAt(produtos.get(i).getFornecedores_codigo(), i, 1);
                tmProdutos.setValueAt(produtos.get(i).getNome(), i, 2);
                tmProdutos.setValueAt(produtos.get(i).getValor(), i, 3);
                tmProdutos.setValueAt(produtos.get(i).getEstoque(), i, 4);
            }
        }
    }
    
    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        novoProduto();
    }//GEN-LAST:event_btNovoActionPerformed
    
    private void novoProduto(){
        if (! verificaNome()){
            JOptionPane.showMessageDialog(this, "Informe o nome do produto!");
            tfNome.requestFocus();
        } else if (! verificaValor()){
            JOptionPane.showMessageDialog(this, "Valor inv�lido!");
            tfValor.requestFocus();
        } else if (! verificaEstoque()){
            JOptionPane.showMessageDialog(this, "Valor do estoque inv�lido!");
            tfEstoque.requestFocus();
        } else {
            cadastraProduto();
        }
    }
    
    private void cadastraProduto(){
        ProdutoControl pc = new ProdutoControl();
        ProdutoBean produto = new ProdutoBean();
        produto.setFornecedores_codigo(fornecedores.get(cbFornecedores.getSelectedIndex()).getCodigo());
        produto.setNome(tfNome.getText());
        produto.setValor(Double.parseDouble(tfValor.getText().trim()));
        produto.setEstoque(Integer.parseInt(tfEstoque.getText().trim()));
        pc.cadastrarProduto(produto);
        JOptionPane.showMessageDialog(this, "Produto cadastrado com sucesso!");
    }
    
    private boolean verificaEstoque(){
        if (tfEstoque.getText().trim().equals("")){
            return false;
        } else {
            try {
                int estoque = Integer.parseInt(tfEstoque.getText().trim());
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
                return false;
            }
        }
        int estoque = Integer.parseInt(tfEstoque.getText().trim());
        if (estoque < 0){
            return false;
        }
        return true;
    }
    
    private boolean verificaValor(){
        if (tfValor.getText().trim().equals("")){
            return false;
        } else {
            try {
                double valor = Double.parseDouble(tfValor.getText().trim());
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
                return false;
            }
        }
        return true;
    }
    
    private boolean verificaNome(){
        if (tfNome.getText().trim().equals(""))
            return false;
        return true;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Produtos().setVisible(true);
            }
        });
    }
    
    private void tbProdutosLinhaSelecionada(){
        if (tbProdutos.getSelectedRow() != -1){
            tfNome.setText(produtos.get(tbProdutos.getSelectedRow()).getNome());
            tfValor.setText(String.valueOf(produtos.get(tbProdutos.getSelectedRow()).getValor()));
            tfEstoque.setText(String.valueOf(produtos.get(tbProdutos.getSelectedRow()).getEstoque()));
            selecionaFornecedor(produtos.get(tbProdutos.getSelectedRow()).getFornecedores_codigo());
        } else {
            tfNome.setText("");
            tfValor.setText("");
            //tfFornecedor.setText("");
            tfEstoque.setText("");
        }
    }
    
    private void selecionaFornecedor(int codigoFornecedor){
        for (int i = 0; i < fornecedores.size(); i++){
            if (fornecedores.get(i).getCodigo() == codigoFornecedor){
                cbFornecedores.setSelectedIndex(i);
                return;
            }
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btFechar;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btPesquisaProduto;
    private javax.swing.JComboBox cbFornecedores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbProdutos;
    private javax.swing.JTextField tfEstoque;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfPesquisaProduto;
    private javax.swing.JTextField tfValor;
    // End of variables declaration//GEN-END:variables
    
}