/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import classes.Funcionario;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author corns
 */
public class FrFuncionario extends javax.swing.JFrame {
    protected ArrayList<Funcionario> arrayFuncionario = new ArrayList();
    protected Funcionario funcionario;
    protected char tipoEdicao;
    /**
     * Creates new form FrFuncionario
     */
    public FrFuncionario() {
        initComponents();
        this.habDesabForm(false);
        this.limparDados();
        formatarCampos();
        this.carregarTblFuncionario();
    }

    public void formatarCampos(){
        try {
            MaskFormatter maskCPF = new MaskFormatter("###.###.###-##");
            maskCPF.install(ftxtCpf);
            
        } catch (ParseException ex) {
            Logger.getLogger(FrCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean verficarCPF(String cpf){
        int digito1=0, digito2=0, calculoDigito1=0, calculoDigito2=0, j=10, z=11;
        int [] arrayCPF;
        boolean repetido = true;
        arrayCPF = new int[9];
        
        digito1 = Integer.parseInt(cpf.substring(12, 13));
        digito2 = Integer.parseInt(cpf.substring(13, 14));
        cpf = cpf.substring(0, 3) + cpf.substring(4, 7) + cpf.substring(8, 11);
        
        for(int i=0; i < arrayCPF.length; i++){
            arrayCPF[i] = Integer.parseInt(cpf.substring(i, i+1));
            
            calculoDigito1 += j * arrayCPF[i];
            j--;
            calculoDigito2 += z * arrayCPF[i];
            z--;
            
            if(arrayCPF[0] != arrayCPF[i] && repetido)
                repetido = false;
        }
        calculoDigito2 += digito1 * z;
        
        calculoDigito1 = calculoDigito1 * 10 % 11;
        calculoDigito2 = calculoDigito2 * 10 % 11;
        
        if(calculoDigito1 == 10)
            calculoDigito1 = 0;
        if(calculoDigito2 == 10)
            calculoDigito2 = 0;
        
        
        if(calculoDigito1 != digito1 || calculoDigito2 != digito2 || repetido)
            return false;
        else 
            return true;
        
     
    }
    
    public boolean validarCampos(){
        
        if(!this.txtID.getText().replace(" ", "").matches("[0-9]")){
            JOptionPane.showMessageDialog(rootPane, "Preencha o ID apenas com numeros");
            this.txtNome.requestFocus();
            return false;
        }
        if(!this.txtNome.getText().replace(" ", "").matches("[A-Za-z]{3,}")){
            JOptionPane.showMessageDialog(rootPane, "Preencha o nome corretamente(somente letras sem acentos");
            this.txtNome.requestFocus();
            return false;
        }
        if(!this.txtIdade.getText().replace(" ", "").matches("[0-9][0-9]")){
            JOptionPane.showMessageDialog(rootPane, "Preencha a idade corretamente");
            this.txtIdade.requestFocus();
            return false;
        }
        if(!this.txtCargo.getText().replace(" ", "").matches("[A-Za-z]{5,}")){
            JOptionPane.showMessageDialog(rootPane, "Preencha com um Cargo Valido");
            this.txtCargo.requestFocus();
            return false;
        }
        if(this.ftxtCpf.getText().replace(" ", "").length() < 13){
            JOptionPane.showMessageDialog(rootPane, "Preencha o CPF corretamente(deve conter 11 numeros)");
            this.ftxtCpf.requestFocus();
            return false;
        }else
            if(!verficarCPF(ftxtCpf.getText())){
                JOptionPane.showMessageDialog(rootPane, "CPF invalido");
                this.ftxtCpf.requestFocus();
                return false;
            }
        
        if(!this.txtSalario.getText().replace(" ", "").matches("[0-9][0-9]+")){
            JOptionPane.showMessageDialog(rootPane, "O salario deve conter apenas numeros");
            this.txtSalario.requestFocus();
            return false;
        }
        return true;
    }
    
    public void preencherForm(){
        
        this.txtID.setText(String.valueOf(funcionario.getId()));
        this.txtNome.setText(funcionario.getNome());
        this.txtIdade.setText(String.valueOf(funcionario.getIdade()));
        this.txtCargo.setText(funcionario.getCargo());
        this.txtSalario.setText(String.valueOf(funcionario.getSalario()));
        this.ftxtCpf.setText(funcionario.getCPF());
        if(funcionario.getSexo() == 'M')
            this.cbxSexo.setSelectedIndex(0);
        else
            this.cbxSexo.setSelectedIndex(1);
    }
    
    public void habDesabForm(boolean habDesab){
        for(int i=0; i < pnlForm.getComponents().length; i++)
            this.pnlForm.getComponent(i).setEnabled(habDesab);
    }
    
    public void limparDados(){
        this.txtNome.setText("");
        this.txtID.setText("");
        this.txtIdade.setText("");
        this.ftxtCpf.setText("");
        this.txtCargo.setText("");
        this.txtSalario.setText("");
        this.cbxSexo.setSelectedItem(0);
    }
    
    public void salvarFuncionario(){
        
        if(tipoEdicao == 'I'){
            funcionario = new Funcionario(); 
            funcionario.setId(Integer.parseInt(txtID.getText()));
        }
       
        funcionario.setNome(txtNome.getText());
        funcionario.setIdade(Integer.parseInt(txtIdade.getText()));
        funcionario.setCargo(txtCargo.getText());
        funcionario.setSalario(Double.parseDouble(txtSalario.getText()));
        funcionario.setSexo(cbxSexo.getItemAt(cbxSexo.getSelectedIndex()).toCharArray()[0]);
        funcionario.setCPF(ftxtCpf.getText());
        
        if(tipoEdicao == 'I')
            this.arrayFuncionario.add(funcionario);
        
    }
    
    public void carregarTblFuncionario(){
        String [] colunas = {"ID", "Nome", "Sexo", "Idade", "Cargo", "CPF", "Salario"};
        DefaultTableModel model = new DefaultTableModel(colunas, 0);
        
        for(int i=0; i<arrayFuncionario.size(); i++){
            Object [] linha = {arrayFuncionario.get(i).getId(), arrayFuncionario.get(i).getNome(), arrayFuncionario.get(i).getSexo(), 
            arrayFuncionario.get(i).getIdade(), arrayFuncionario.get(i).getCargo(), arrayFuncionario.get(i).getCPF(), 
            arrayFuncionario.get(i).getSalario()};
            model.addRow(linha);
        }
        this.tblFuncionario.setModel(model);
    }
    public void alterarFuncionario(){
        String cpf = JOptionPane.showInputDialog("Informe o CPF da pessoa para alterar o cadastro: ","");
        funcionario= this.buscarFuncionario(cpf);
        if(funcionario == null){
            JOptionPane.showMessageDialog(this, "Não existe cadastro com este CPF!");
        }else{
            preencherForm();
        }
    }
    
    public Funcionario buscarFuncionario(String cpf){
        for(int i=0; i < arrayFuncionario.size(); i++){
            if(arrayFuncionario.get(i).getCPF().equals(cpf))
                return arrayFuncionario.get(i);   
        }
        return null;
    }
     public void excluirFuncionario(){
        String cpf = JOptionPane.showInputDialog("Informe o CPF do(a) Funcionario(a) para excluir o cadastro: ","");
        funcionario = this.buscarFuncionario(cpf);
        if(funcionario == null){
            JOptionPane.showMessageDialog(this, "Não existe cadastro com este CPF!");
        }else{
            preencherForm();
            this.habDesabForm(false);
            if(JOptionPane.showConfirmDialog(rootPane, "Deseja realmente excluir o(a) Funcionario(a): " + funcionario.getNome(), "Sistema Funcionario", JOptionPane.YES_NO_OPTION) == 0){
                arrayFuncionario.remove(funcionario);
                this.carregarTblFuncionario();
            }
        }
    }
     
     public void consultarFuncionario(String nome){
        for(int i=0; 1<arrayFuncionario.size(); i++){
            funcionario = arrayFuncionario.get(i);
            if(funcionario.getNome().toUpperCase().contains(nome))
                for(int j=0; j < tblFuncionario.getRowCount(); j++){
                    if((int)tblFuncionario.getValueAt(j, 0) == funcionario.getId()){
                        tblFuncionario.setRowSelectionInterval(j, j);
                        this.preencherForm();
                        this.habDesabForm(false);
                    }
                }
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        btnAdicionar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        pnlForm = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblIdade = new javax.swing.JLabel();
        lblSexo = new javax.swing.JLabel();
        txtIdade = new javax.swing.JTextField();
        cbxSexo = new javax.swing.JComboBox<>();
        lblCpf = new javax.swing.JLabel();
        ftxtCpf = new javax.swing.JFormattedTextField();
        lblId = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        lblCargo = new javax.swing.JLabel();
        txtCargo = new javax.swing.JTextField();
        lblSalario = new javax.swing.JLabel();
        txtSalario = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFuncionario = new javax.swing.JTable();
        lblConsulta = new javax.swing.JLabel();
        txtConsulta = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Cadastro Funcionário");

        btnAdicionar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnAlterar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnExcluir.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnSalvar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        lblNome.setText("Nome:");

        lblIdade.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lblIdade.setText("Idade:");

        lblSexo.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lblSexo.setText("Sexo");

        cbxSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "F" }));

        lblCpf.setText("CPF: ");

        ftxtCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ftxtCpfActionPerformed(evt);
            }
        });

        lblId.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lblId.setText("ID:");

        lblCargo.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lblCargo.setText("Cargo:");

        txtCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCargoActionPerformed(evt);
            }
        });

        lblSalario.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lblSalario.setText("Salário:");

        txtSalario.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        javax.swing.GroupLayout pnlFormLayout = new javax.swing.GroupLayout(pnlForm);
        pnlForm.setLayout(pnlFormLayout);
        pnlFormLayout.setHorizontalGroup(
            pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormLayout.createSequentialGroup()
                .addComponent(lblIdade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSexo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(lblCpf)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ftxtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlFormLayout.createSequentialGroup()
                .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFormLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblSalario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlFormLayout.createSequentialGroup()
                        .addComponent(lblId)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCargo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 151, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlFormLayout.setVerticalGroup(
            pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCargo)
                    .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSalario)
                    .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSexo)
                    .addComponent(cbxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIdade)
                    .addComponent(txtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ftxtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );

        tblFuncionario.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        tblFuncionario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblFuncionario);

        lblConsulta.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblConsulta.setText("Consultar Funcionário");
        lblConsulta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtConsulta.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConsultaActionPerformed(evt);
            }
        });
        txtConsulta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtConsultaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtConsultaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnAdicionar)
                .addGap(54, 54, 54)
                .addComponent(btnAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(btnExcluir)
                .addGap(65, 65, 65)
                .addComponent(btnSalvar)
                .addGap(28, 28, 28))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlForm, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblConsulta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionar)
                    .addComponent(btnAlterar)
                    .addComponent(btnExcluir)
                    .addComponent(btnSalvar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblConsulta)
                    .addComponent(txtConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ftxtCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ftxtCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ftxtCpfActionPerformed

    private void txtCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCargoActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        tipoEdicao = 'I';
        this.habDesabForm(true);
        this.limparDados();
        this.txtID.requestFocus();
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if(this.validarCampos()){
            this.salvarFuncionario();
            this.carregarTblFuncionario();
            this.limparDados();
            this.habDesabForm(false);
            JOptionPane.showMessageDialog(rootPane, "Dados Salvos com Sucesso!");
            
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        this.excluirFuncionario();
        this.limparDados();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        tipoEdicao = 'E';
        this.habDesabForm(true);
        this.limparDados();
        this.alterarFuncionario();
        
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void txtConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConsultaActionPerformed
       
    }//GEN-LAST:event_txtConsultaActionPerformed

    private void txtConsultaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConsultaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtConsultaKeyPressed

    private void txtConsultaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConsultaKeyReleased
       this.consultarFuncionario(this.txtConsulta.getText().toUpperCase());
    }//GEN-LAST:event_txtConsultaKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbxSexo;
    private javax.swing.JFormattedTextField ftxtCpf;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblConsulta;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblIdade;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSalario;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlForm;
    private javax.swing.JTable tblFuncionario;
    private javax.swing.JTextField txtCargo;
    private javax.swing.JTextField txtConsulta;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtIdade;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtSalario;
    // End of variables declaration//GEN-END:variables
}
