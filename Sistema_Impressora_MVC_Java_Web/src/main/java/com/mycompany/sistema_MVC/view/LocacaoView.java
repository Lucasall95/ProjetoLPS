/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistema_MVC.view;

import com.mycompany.sistema_MVC.controller.LocacaoController;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.mycompany.sistema_MVC.model.DAO.LocacaoDAO;

/**
 *
 * @author corns
 */
public class LocacaoView extends javax.swing.JFrame {

    protected ArrayList<Object []> arrayLocacao = new ArrayList();
    protected Object [] locacao;
    protected char tipoEdicao;
    private LocacaoController locacaoController;
            
    public LocacaoView(LocacaoController locacaoController) {
        initComponents();
        this.habDesabForm(false);
        this.locacaoController = locacaoController;
        this.carregarTblLocacao();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lblTitulo = new javax.swing.JLabel();
        btnAdicionar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        pnlLocacao = new javax.swing.JPanel();
        lblId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        lblTamanho = new javax.swing.JLabel();
        lblTipoMaquina = new javax.swing.JLabel();
        lblFinalidade = new javax.swing.JLabel();
        lblTempoLocacao = new javax.swing.JLabel();
        lblQtdImpressora = new javax.swing.JLabel();
        txtTipoMaquina = new javax.swing.JTextField();
        txtTamanho = new javax.swing.JTextField();
        txtFinalidade = new javax.swing.JTextField();
        txtTempoLocacao = new javax.swing.JTextField();
        txtQtdImpressora = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblLocacao = new javax.swing.JTable();
        btnConsulta = new javax.swing.JButton();
        txtConsulta = new javax.swing.JTextField();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Locação");
        lblTitulo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnAdicionar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnAdicionar.setText("Adicionar");
        btnAdicionar.setBorder(null);
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnAlterar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnExcluir.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnSalvar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        pnlLocacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblId.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lblId.setText("ID:");

        lblTamanho.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lblTamanho.setText("Tamanho:");

        lblTipoMaquina.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lblTipoMaquina.setText("Tipo de Máquina:");

        lblFinalidade.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lblFinalidade.setText("Finalidade:");

        lblTempoLocacao.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lblTempoLocacao.setText("Tempo de Locação:");

        lblQtdImpressora.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lblQtdImpressora.setText("Quantidade de Impressoras:");

        txtTempoLocacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTempoLocacaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlLocacaoLayout = new javax.swing.GroupLayout(pnlLocacao);
        pnlLocacao.setLayout(pnlLocacaoLayout);
        pnlLocacaoLayout.setHorizontalGroup(
            pnlLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLocacaoLayout.createSequentialGroup()
                .addComponent(lblTamanho)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFinalidade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFinalidade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblQtdImpressora)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtQtdImpressora, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
            .addGroup(pnlLocacaoLayout.createSequentialGroup()
                .addComponent(lblId)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(lblTipoMaquina)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTipoMaquina)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTempoLocacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTempoLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        pnlLocacaoLayout.setVerticalGroup(
            pnlLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLocacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTipoMaquina)
                    .addComponent(lblTempoLocacao)
                    .addComponent(txtTipoMaquina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTempoLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTamanho)
                    .addComponent(lblFinalidade)
                    .addComponent(lblQtdImpressora)
                    .addComponent(txtTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFinalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQtdImpressora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        tblLocacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblLocacao);

        btnConsulta.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnConsulta.setText("Consultar");
        btnConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
            .addComponent(pnlLocacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnConsulta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAdicionar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(pnlLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConsulta)
                    .addComponent(txtConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
     
    public void habDesabForm(boolean habDesab){
        for(int i=0; i < pnlLocacao.getComponents().length; i++)
            this.pnlLocacao.getComponent(i).setEnabled(habDesab);
        this.txtId.setEnabled(false);
    }
 
    public void limparDados(){
        this.txtId.setText("");
        this.txtTamanho.setText("");
        this.txtTipoMaquina.setText("");
        this.txtFinalidade.setText("");
        this.txtQtdImpressora.setText("");
        this.txtTempoLocacao.setText("");
    }
     
    public boolean validarCampos(){
        
        if(!this.txtTamanho.getText().replace(" ", "").matches("[A-Za-z]{3,}")){
            JOptionPane.showMessageDialog(rootPane, "Preencha o Tamanho corretamente(somente letras sem acentos");
            this.txtTamanho.requestFocus();
            return false;
        }
        if(!this.txtTipoMaquina.getText().replace(" ", "").matches("[A-Za-z]+")){
            JOptionPane.showMessageDialog(rootPane, "Preencha Tipo da Maquina corretamente");
            this.txtTipoMaquina.requestFocus();
            return false;
        }
        if(!this.txtFinalidade.getText().replace(" ", "").matches("[A-Za-z]+")){
            JOptionPane.showMessageDialog(rootPane, "Preencha a Finalidade Corretamente");
            this.txtFinalidade.requestFocus();
            return false;
        }
        if(!this.txtTempoLocacao.getText().replace(" ", "").matches("[0-9]+[A-Za-z]{3,}")){
            JOptionPane.showMessageDialog(rootPane, "Preencha o Tempo de Locacao existente");
            this.txtTempoLocacao.requestFocus();
            return false;
        }
        if(!this.txtQtdImpressora.getText().replace(" ", "").matches("[0-9]")){
            JOptionPane.showMessageDialog(rootPane, "Preencha a Quantidade apenas com numeros");
            this.txtQtdImpressora.requestFocus();
            return false;
        }
        
        return true;
    }
    
    public void salvarLocacao(){
        
        Object [] locacao = new Object[6];
        
        locacao[0] = txtId.getText();
        locacao[1] = txtTamanho.getText();
        locacao[2] = txtTipoMaquina.getText();
        locacao[3] = txtFinalidade.getText();
        locacao[4] = txtQtdImpressora.getText();
        locacao[5] = txtTempoLocacao.getText();
         
         if(tipoEdicao == 'I')
            if(locacaoController.incluirLocacao(locacao) > 0)
                JOptionPane.showMessageDialog(rootPane, "Locacao cadastrada com Sucesso!");
            else
                JOptionPane.showMessageDialog(rootPane, "Erro ao Cadastrar o Locacao.");
        else
            if(locacaoController.modificarLocacao(locacao) > 0)
                JOptionPane.showMessageDialog(rootPane, "Locacao alterada com Sucesso!");
            else
                JOptionPane.showMessageDialog(rootPane, "Erro ao alterar Locacao.");
           
    }
    
    public void carregarTblLocacao(){
        String [] colunas = {"ID", "Tamanho", "Tipo", "Finalidade", "QtdImpressoras", "Tempo-Locacao"};
        DefaultTableModel model = new DefaultTableModel(colunas, 0);
        
        
        arrayLocacao = locacaoController.buscarLocacao();
        
        for(int i=0; i<arrayLocacao.size(); i++){
            Object [] linha = {arrayLocacao.get(i)[0], arrayLocacao.get(i)[1], arrayLocacao.get(i)[2], 
            arrayLocacao.get(i)[3], arrayLocacao.get(i)[4], arrayLocacao.get(i)[5]}; 
            
            model.addRow(linha);
        }
        this.tblLocacao.setModel(model);
    }
  
    public Object [] buscarLocacao(int id){
         for(int i=0; i < arrayLocacao.size(); i++){
             if((int)arrayLocacao.get(i)[0] == id)
                 return arrayLocacao.get(i);
         }
         return null;
     } 
    
    public void preencherForm(){
        int id;
         if(tblLocacao.getSelectedRow() != -1){
             id = (int) tblLocacao.getValueAt(tblLocacao.getSelectedRow(), 0);
             locacao = buscarLocacao(id);
             this.txtId.setText(locacao[0].toString());
             this.txtTamanho.setText(locacao[1].toString());
             this.txtTipoMaquina.setText(locacao[2].toString());
             this.txtFinalidade.setText(locacao[3].toString());
             this.txtQtdImpressora.setText(locacao[4].toString());
             this.txtTempoLocacao.setText(locacao[5].toString());
        }
    }
    
    public void ExcluirLocacao(){
         int id;
         if(tblLocacao.getSelectedRow() != -1){
             id = (int) tblLocacao.getValueAt(tblLocacao.getSelectedRow(), 0);
             locacao = buscarLocacao(id);
             this.preencherForm();
             this.habDesabForm(false);
             if(JOptionPane.showConfirmDialog(rootPane, "Deseja Realmente Excluir a Locacao com ID: " + locacao[0], "Sistema Locacao", JOptionPane.YES_NO_OPTION) == 0){
                if(locacaoController.removerLocacao(locacao)> 0){
                    JOptionPane.showMessageDialog(rootPane, "Locacao (" + locacao[1] + ") excluída com Sucesso!");
                    limparDados();
                    this.carregarTblLocacao();
                }else
                    JOptionPane.showMessageDialog(rootPane, "Erro ao excluir a Impressora"+ locacao[1] + "!");
             }
                 
         }else
             JOptionPane.showMessageDialog(rootPane, "Selecione uma Impressora!");
     }
    
    public void consultarImpressora(int id){
        for(int i=0; 1<arrayLocacao.size(); i++){
            locacao = arrayLocacao.get(i);
            if((int)locacao[0] == id)
                for(int j=0; j < tblLocacao.getRowCount(); j++){
                    if((int)tblLocacao.getValueAt(j, 0) == (int)locacao[0]){
                        tblLocacao.setRowSelectionInterval(j, j);
                        this.preencherForm();
                        this.habDesabForm(false);
                    }
                }
        }
        
    }  
    
    private void txtTempoLocacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTempoLocacaoActionPerformed
      
    }//GEN-LAST:event_txtTempoLocacaoActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        this.tipoEdicao = 'I';
        this.habDesabForm(true);
        this.limparDados();
        this.txtTipoMaquina.requestFocus();
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        this.salvarLocacao();
        this.carregarTblLocacao();
        this.limparDados();
        this.habDesabForm(false);
        JOptionPane.showMessageDialog(rootPane, "Dados Salvos com sucesso");
        
        
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        this.tipoEdicao = 'E';
        preencherForm();
        this.habDesabForm(true);
       
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        this.ExcluirLocacao();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaActionPerformed
        this.consultarImpressora(Integer.parseInt(this.txtConsulta.getText()));
    }//GEN-LAST:event_btnConsultaActionPerformed
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnConsulta;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblFinalidade;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblQtdImpressora;
    private javax.swing.JLabel lblTamanho;
    private javax.swing.JLabel lblTempoLocacao;
    private javax.swing.JLabel lblTipoMaquina;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlLocacao;
    private javax.swing.JTable tblLocacao;
    private javax.swing.JTextField txtConsulta;
    private javax.swing.JTextField txtFinalidade;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtQtdImpressora;
    private javax.swing.JTextField txtTamanho;
    private javax.swing.JTextField txtTempoLocacao;
    private javax.swing.JTextField txtTipoMaquina;
    // End of variables declaration//GEN-END:variables
}
