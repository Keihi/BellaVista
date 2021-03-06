/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import dao.ProdutoDAO;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ObjProduto;

/**
 *
 * @author Pichau
 */
public class ListProdutos extends javax.swing.JInternalFrame {

    /**
     * Creates new form ListProdutos
     */
    
    private JDesktopPane painelTelaInicial;
    
    public ListProdutos(JDesktopPane painelTelaInicial) {
        initComponents();
        carregarTabela();
        this.painelTelaInicial = painelTelaInicial;
        
    }
    
    public void carregarTabela(){
        DefaultTableModel modelo = new DefaultTableModel();
        String[] colunas = {"Código", "Nome","Categoria", "Fornecedor",
            "Quantidade","Estoque Minimo", "Custo", "Preço de Venda", "Refrigerado",
            "Comentario"};
        modelo.setColumnIdentifiers(colunas);
        List<ObjProduto> lista = ProdutoDAO.getProdutos();
        
        for( ObjProduto pro : lista ){
            
            String refrigerado = "";
            if(  pro.isRefrigerado() )
                refrigerado = "SIM";
            
            Object[] obj = { pro.getCodigo(), pro.getNome(), pro.getCategoria(),
            pro.getFornecedor(), pro.getQuantidade(), pro.getEstoqueMinimo() , pro.getCusto(), pro.getPrecoDeVenda(),
            refrigerado, pro.getComentario()};
            modelo.addRow(obj);
            
            if (pro.getQuantidade()< pro.getEstoqueMinimo()){
                JOptionPane.showMessageDialog(null, "A quantidade de "+pro.getNome()+" em estoque está abaixo do estoque mínimo");
            }
            
        }
        
        tableProdutos.setModel(modelo);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProdutos = new javax.swing.JTable();
        btnExcluir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnCdeSaida = new javax.swing.JButton();
        btnCdeEntrada = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Lista de Produtos");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Produtos Cadastrados: ");

        tableProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tableProdutos);

        btnExcluir.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnCdeSaida.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCdeSaida.setText("Saida de Produtos");
        btnCdeSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCdeSaidaActionPerformed(evt);
            }
        });

        btnCdeEntrada.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCdeEntrada.setText("Entrada de Produtos");
        btnCdeEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCdeEntradaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 761, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnExcluir)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCdeSaida)
                        .addGap(18, 18, 18)
                        .addComponent(btnCdeEntrada)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluir)
                    .addComponent(btnEditar)
                    .addComponent(btnCdeSaida)
                    .addComponent(btnCdeEntrada))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int linha = tableProdutos.getSelectedRow();
        if (linha == -1){
            JOptionPane.showMessageDialog(this,
                    "Você deve selecionar um produto!");
            
        }else{
            String nome = (String) tableProdutos.getValueAt(linha,  1 );
            int resposta = JOptionPane.showConfirmDialog(this, 
                    "Confirma a exclusão do produto "+nome+" ? ",
                    "Excluir Produto",
                    JOptionPane.YES_NO_OPTION);
            if( resposta == JOptionPane.YES_OPTION){
                ObjProduto pro = new ObjProduto();
                int codigo = (int) tableProdutos.getModel().getValueAt(linha, 0);
                pro.setCodigo(codigo);
                ProdutoDAO.excluir(pro);
                carregarTabela();                        
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int linha = tableProdutos.getSelectedRow();
        if(linha == -1){
            JOptionPane.showMessageDialog(this, 
                    "Você deve selecionar um produto!");
        }else{
            int codigo = (int) tableProdutos.getValueAt(linha, 0);
            FrmProduto formulario = new FrmProduto(codigo, this);
            this.painelTelaInicial.add(formulario);
            formulario.setVisible(true);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnCdeSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCdeSaidaActionPerformed
        int linha = tableProdutos.getSelectedRow();
        if (linha == -1){
            JOptionPane.showMessageDialog(this,
                    "Voce deve escolher uma linha!");
            }else{
            int codigo = (int) tableProdutos.getValueAt(linha, 0);
            CdeSaida formulario = new CdeSaida (codigo, this);
            this.painelTelaInicial.add(formulario);
            formulario.setVisible(true);
            
            
        }
    }//GEN-LAST:event_btnCdeSaidaActionPerformed

    private void btnCdeEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCdeEntradaActionPerformed
        int linha = tableProdutos.getSelectedRow();
        if (linha == -1){
            JOptionPane.showMessageDialog(this,
                    "Voce deve escolher uma linha!");
            }else{
            int codigo = (int) tableProdutos.getValueAt(linha, 0);
            CdeEntrada formulario = new CdeEntrada(codigo, this);
            this.painelTelaInicial.add(formulario);
            formulario.setVisible(true);
        }
    }//GEN-LAST:event_btnCdeEntradaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCdeEntrada;
    private javax.swing.JButton btnCdeSaida;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableProdutos;
    // End of variables declaration//GEN-END:variables
}
