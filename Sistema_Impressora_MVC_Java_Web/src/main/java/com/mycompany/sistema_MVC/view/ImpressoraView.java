/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistema_MVC.view;

import com.mycompany.sistema_MVC.controller.ImpressoraController;
import com.mycompany.sistema_MVC.model.Impressora;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.mycompany.sistema_MVC.model.DAO.ImpressoraDAO;

/**
 *
 * @author corns
 */
public class ImpressoraView extends javax.swing.JFrame {

    protected ArrayList<Object []> arrayImpressora = new ArrayList();
    protected Object [] impressora;
    protected char tipoEdicao;
    private ImpressoraController impressoraController;
    
    public ImpressoraView(ImpressoraController impressoraController) {
        initComponents();
        this.habDesabForm(false);
        this.limparDados();
        this.impressoraController = impressoraController;
        this.carregarTblImpressora();
    }
    
     public void habDesabForm(boolean habDesab){
        for(int i=0; i < pnlImpressora.getComponents().length; i++)
            this.pnlImpressora.getComponent(i).setEnabled(habDesab);
        this.txtID.setEnabled(false);
    }
     public void limparDados(){
        this.txtID.setText("");
        this.txtNome.setText("");
        this.txtTipo.setText("");
        this.txtModelo.setText("");
        this.cbxColorida.setSelected(false);
        this.txtMarca.setText("");
    }
     public boolean validarCampos(){
        
        if(!this.txtNome.getText().replace(" ", "").matches("[A-Za-z]{3,}")){
            JOptionPane.showMessageDialog(rootPane, "Preencha o nome corretamente(somente letras sem acentos");
            this.txtNome.requestFocus();
            return false;
        }
        if(!this.txtMarca.getText().replace(" ", "").matches("[A-Za-z]+")){
            JOptionPane.showMessageDialog(rootPane, "Preencha a Marca corretamente");
            this.txtMarca.requestFocus();
            return false;
        }
        if(!this.txtModelo.getText().replace(" ", "").matches("[A-Za-z]+[0-9]*")){
            JOptionPane.showMessageDialog(rootPane, "Preencha com um Modelo Valido");
            this.txtModelo.requestFocus();
            return false;
        }
        if(!this.txtTipo.getText().replace(" ", "").matches("[A-Za-z]{3,}")){
            JOptionPane.showMessageDialog(rootPane, "Preencha o Modelo corretamente");
            this.txtTipo.requestFocus();
            return false;
        }
        
        return true;
    }
     
     public void salvarImpressora(){
         
         Object [] impressora = new Object[6];
         
         impressora[0] = txtID.getText();
         impressora[1] = txtNome.getText();
         impressora[2] = txtTipo.getText();
         impressora[3] = txtMarca.getText();
         impressora[4] = txtModelo.getText();
         impressora[5] = cbxColorida.isSelected();
         
         if(tipoEdicao == 'I')
            if(impressoraController.incluirImpressora(impressora) > 0)
                JOptionPane.showMessageDialog(rootPane, "Impressora cadastrada com Sucesso!");
            else
                JOptionPane.showMessageDialog(rootPane, "Erro ao Cadastrar o Impressora.");
        else
            if(impressoraController.modificarImpressora(impressora) > 0)
                JOptionPane.showMessageDialog(rootPane, "Impressora alterada com Sucesso!");
            else
                JOptionPane.showMessageDialog(rootPane, "Erro ao alterar Impressora.");
             
    }
     
     public void carregarTblImpressora(){
        String [] colunas = {"ID", "Nome", "Tipo", "Marca", "Modelo", "Colorida"};
        DefaultTableModel model = new DefaultTableModel(colunas, 0);
        
        arrayImpressora = impressoraController.buscarImpressora();
        
        for(int i=0; i<arrayImpressora.size(); i++){
            Object [] linha = {arrayImpressora.get(i)[0], arrayImpressora.get(i)[1], arrayImpressora.get(i)[2], 
            arrayImpressora.get(i)[3], arrayImpressora.get(i)[4], arrayImpressora.get(i)[5]}; 
            
            model.addRow(linha);
        }
        this.tblImpressora.setModel(model);
    }
      public void ExcluirImpressora(){
         int id;
         if(tblImpressora.getSelectedRow() != -1){
             id = (int) tblImpressora.getValueAt(tblImpressora.getSelectedRow(), 0);
             impressora = buscarImpressora(id);
             this.preencherForm();
             this.habDesabForm(false);
             if(JOptionPane.showConfirmDialog(rootPane, "Deseja Realmente Excluir a Impressora: " + impressora[1], "Sistema Impressora", JOptionPane.YES_NO_OPTION) == 0){
                 if(impressoraController.removerImpressora(impressora)> 0){
                    JOptionPane.showMessageDialog(rootPane, "Impressora (" + impressora[1] + ") excluído com Sucesso!");
                    limparDados();
                    this.carregarTblImpressora();
                }else
                    JOptionPane.showMessageDialog(rootPane, "Erro ao excluir a Impressora"+ impressora[1] + "!");
             }
                 
         }else
             JOptionPane.showMessageDialog(rootPane, "Selecione uma Impressora!");
     }   
  
     
     public Object[] buscarImpressora(int id){
         for(int i=0; i < arrayImpressora.size(); i++){
             if((int)arrayImpressora.get(i)[0] == id)
                 return arrayImpressora.get(i);
         }
         return null;
   }  
     public void preencherForm(){
        int id;
        if(tblImpressora.getSelectedRow() != -1){
            id = (int) tblImpressora.getValueAt(tblImpressora.getSelectedRow(), 0);
            impressora = buscarImpressora(id);
            this.txtID.setText(impressora[0].toString());
            this.txtNome.setText(impressora[1].toString());
            this.txtTipo.setText(impressora[2].toString());
            this.txtMarca.setText(impressora[3].toString());
            this.txtModelo.setText(impressora[4].toString());
            this.cbxColorida.setSelected(Boolean.valueOf(impressora[5].toString()));
         }
    }
    
     
     public void consultarImpressora(String nome){
        for(int i=0; 1<arrayImpressora.size(); i++){
            impressora = arrayImpressora.get(i);
            if(impressora[1].toString().toUpperCase().contains(nome))
                for(int j=0; j < tblImpressora.getRowCount(); j++){
                    if((int)tblImpressora.getValueAt(j, 0) == (int) impressora[0]){
                        tblImpressora.setRowSelectionInterval(j, j);
                        this.preencherForm();
                        this.habDesabForm(false);
                    }
                }
        }
        
    }    
         
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        btnAdicionar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        pnlImpressora = new javax.swing.JPanel();
        lblID = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblTipo = new javax.swing.JLabel();
        txtTipo = new javax.swing.JTextField();
        cbxColorida = new javax.swing.JCheckBox();
        lblMarca = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        lblModelo = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblImpressora = new javax.swing.JTable();
        txtConsulta = new javax.swing.JTextField();
        btnConsulta = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Cadastro Impressora");

        btnAdicionar.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnAlterar.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnExcluir.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnSalvar.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        lblID.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lblID.setText("ID:");

        lblNome.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lblNome.setText("NOME:");

        lblTipo.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lblTipo.setText("TIPO:");

        cbxColorida.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        cbxColorida.setText("COLORIDA");
        cbxColorida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxColoridaActionPerformed(evt);
            }
        });

        lblMarca.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lblMarca.setText("MARCA:");

        lblModelo.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lblModelo.setText("MODELO:");

        javax.swing.GroupLayout pnlImpressoraLayout = new javax.swing.GroupLayout(pnlImpressora);
        pnlImpressora.setLayout(pnlImpressoraLayout);
        pnlImpressoraLayout.setHorizontalGroup(
            pnlImpressoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlImpressoraLayout.createSequentialGroup()
                .addComponent(lblID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104)
                .addComponent(lblNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlImpressoraLayout.createSequentialGroup()
                .addGroup(pnlImpressoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlImpressoraLayout.createSequentialGroup()
                        .addComponent(lblModelo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 273, Short.MAX_VALUE))
                    .addGroup(pnlImpressoraLayout.createSequentialGroup()
                        .addComponent(lblTipo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbxColorida)
                        .addGap(68, 68, 68)
                        .addComponent(lblMarca)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        pnlImpressoraLayout.setVerticalGroup(
            pnlImpressoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlImpressoraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlImpressoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlImpressoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblID)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlImpressoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblNome)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pnlImpressoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipo)
                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxColorida)
                    .addComponent(lblMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(pnlImpressoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblModelo)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblImpressora.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        tblImpressora.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblImpressora);

        txtConsulta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtConsultaKeyReleased(evt);
            }
        });

        btnConsulta.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlImpressora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnConsulta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 169, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(4, 4, 4)))
                .addComponent(pnlImpressora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsulta))
                .addGap(0, 7, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbxColoridaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxColoridaActionPerformed
        
    }//GEN-LAST:event_cbxColoridaActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        this.tipoEdicao = 'I';
        this.habDesabForm(true);
        this.limparDados();
        this.txtNome.requestFocus();
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if(this.validarCampos()){
            this.salvarImpressora();
            this.carregarTblImpressora();
            this.limparDados();
            this.habDesabForm(false);
            JOptionPane.showMessageDialog(rootPane, "Dados Salvos com sucesso");
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        this.tipoEdicao = 'E';
        preencherForm();
        this.habDesabForm(true);
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        this.ExcluirImpressora();
        this.limparDados();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void txtConsultaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConsultaKeyReleased
        //this.consultarImpressora(this.txtConsulta.getText().toUpperCase());
    }//GEN-LAST:event_txtConsultaKeyReleased

    private void btnConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaActionPerformed
        this.consultarImpressora(this.txtConsulta.getText().toUpperCase());
    }//GEN-LAST:event_btnConsultaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnConsulta;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JCheckBox cbxColorida;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlImpressora;
    private javax.swing.JTable tblImpressora;
    private javax.swing.JTextField txtConsulta;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables
}
