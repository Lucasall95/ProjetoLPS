/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


import classes.Cliente;
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
public class FrCliente extends javax.swing.JFrame {
    private ArrayList<Cliente> arrayCliente = new ArrayList();
    protected Cliente cliente;
    protected char tipoEdicao;
   
    public FrCliente(){
        initComponents();
        this.habDesabForm(false);
        formatarCampos();
        this.carregarTblCliente();
    }
    //136.573.426-99
    
     public void excluirCliente(){
        String cpf = JOptionPane.showInputDialog("Informe o CPF da pessoa para excluir o cadastro: ","");
        cliente = this.buscarCliente(cpf);
        if(cliente == null){
            JOptionPane.showMessageDialog(this, "Não existe cadastro com este CPF!");
        }else{
            preencherForm();
            this.habDesabForm(false);
            if(JOptionPane.showConfirmDialog(rootPane, "Deseja realmente excluir o(a) Cliente; " + cliente.getNome(), "Sistema Cliente", JOptionPane.YES_NO_OPTION) == 0){
                arrayCliente.remove(cliente);
                this.carregarTblCliente();
            }
        }
    }
    
    public void alterarCliente(){
        String cpf = JOptionPane.showInputDialog("Informe o CPF da pessoa para alterar o cadastro: ","");
        cliente = this.buscarCliente(cpf);
        if(cliente == null){
            JOptionPane.showMessageDialog(this, "Não existe cadastro com este CPF!");
        }else{
            preencherForm();
        }
    }
    
    public Cliente buscarCliente(String cpf){
        for(int i=0; i < arrayCliente.size(); i++){
            if(arrayCliente.get(i).getCPF().equals(cpf))
                return arrayCliente.get(i);   
        }
        return null;
    }
    
    public void preencherForm(){
        this.txtId.setText(String.valueOf(cliente.getId()));
        this.txtNome.setText(cliente.getNome());
        this.txtIdade.setText(String.valueOf(cliente.getIdade()));
        this.txtEmail.setText(cliente.getEmail());
        this.pswSenha.setText(cliente.getSenha());
        this.ftxtCpf.setText(cliente.getCPF());
        if(cliente.getSexo() == 'M')
            this.cbxSexo.setSelectedIndex(0);
        else
            this.cbxSexo.setSelectedIndex(1);
    }
    
    public void limparDados(){
        this.txtId.setText("");
        this.txtNome.setText("");
        this.txtEmail.setText("");
        this.txtIdade.setText("");
        this.ftxtCpf.setText("");
        this.pswSenha.setText("");
        this.cbxSexo.setSelectedItem(0);
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
        
        if(!this.txtId.getText().replace(" ", "").matches("[0-9]")){
            JOptionPane.showMessageDialog(rootPane, "Preencha o ID apenas com numeros");
            this.txtNome.requestFocus();
            return false;
        }
        if(!this.txtNome.getText().replace(" ", "").matches("[A-Za-z]{3,}")){
            JOptionPane.showMessageDialog(rootPane, "Preencha o nome corretamente(somente letras sem acentos");
            this.txtNome.requestFocus();
            return false;
        }
        if(!this.txtIdade.getText().replace(" ", "").matches("[0-9][0-9]*")){
            JOptionPane.showMessageDialog(rootPane, "Preencha a idade corretamente");
            this.txtIdade.requestFocus();
            return false;
        }
        if(!this.txtEmail.getText().replace(" ", "").contains("@")){
            JOptionPane.showMessageDialog(rootPane, "Preencha com um Email valido");
            this.txtEmail.requestFocus();
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
        
        if(this.pswSenha.getPassword().length < 6){
            JOptionPane.showMessageDialog(rootPane, "A senha deve conter pelo menos 6 digitos");
            this.pswSenha.requestFocus();
            return false;
        }
         
        return true;
    }
    
    public void carregarTblCliente(){
        String [] colunas = {"Id","Nome", "Sexo", "Idade", "Email", "CPF", "Senha"};
        DefaultTableModel model = new DefaultTableModel(colunas, 0);
        
        for(int i=0; i<arrayCliente.size(); i++){
            Object [] linha = {arrayCliente.get(i).getId(),arrayCliente.get(i).getNome(),arrayCliente.get(i).getSexo(), arrayCliente.get(i).getIdade(), 
            arrayCliente.get(i).getEmail(), arrayCliente.get(i).getCPF(), arrayCliente.get(i).getSenha()};
            model.addRow(linha);
        }
        this.tblCliente.setModel(model);
    }
    
    
    public void salvarCliente(){
        if(tipoEdicao == 'I')
            cliente = new Cliente();
            cliente.setId(Integer.parseInt(txtId.getText()));
        
        cliente.setNome(txtNome.getText());
        cliente.setIdade(Integer.parseInt(txtIdade.getText()));
        cliente.setEmail(txtEmail.getText());
        cliente.setSexo(cbxSexo.getItemAt(cbxSexo.getSelectedIndex()).toCharArray()[0]);
        cliente.setCPF(ftxtCpf.getText());
        cliente.setSenha(String.valueOf(pswSenha.getPassword()));
        
        if(tipoEdicao == 'I')
            this.arrayCliente.add(cliente);
        
    }
    
    public void consultarCliente(String nome){
        for(int i=0; 1<arrayCliente.size(); i++){
            cliente = arrayCliente.get(i);
            if(cliente.getNome().toUpperCase().contains(nome))
                for(int j=0; j<tblCliente.getRowCount(); j++){
                    if(tblCliente.getValueAt(j, 0) == cliente.getNome()){
                        tblCliente.setRowSelectionInterval(j, j);
                        this.preencherForm();
                        this.habDesabForm(false);
                    }
                }
        }
        
    }
    
    public void habDesabForm(boolean habDesab){
        for(int i=0; i < pnlForm.getComponents().length; i++)
            this.pnlForm.getComponent(i).setEnabled(habDesab);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lblTitulo = new javax.swing.JLabel();
        pnlForm = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblIdade = new javax.swing.JLabel();
        txtIdade = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblSexo = new javax.swing.JLabel();
        cbxSexo = new javax.swing.JComboBox<>();
        lblCpf = new javax.swing.JLabel();
        ftxtCpf = new javax.swing.JFormattedTextField();
        lblSenha = new javax.swing.JLabel();
        pswSenha = new javax.swing.JPasswordField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblCliente = new javax.swing.JTable();
        lblId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        btnAdicionar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
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
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Cadastro Cliente");
        lblTitulo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        pnlForm.setBorder(new javax.swing.border.MatteBorder(null));

        lblNome.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblNome.setText("Nome:");

        lblIdade.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lblIdade.setText("Idade:");

        lblEmail.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lblEmail.setText("E-mail:");

        lblSexo.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lblSexo.setText("Sexo");

        cbxSexo.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        cbxSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "F" }));
        cbxSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSexoActionPerformed(evt);
            }
        });

        lblCpf.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lblCpf.setText("CPF:");

        lblSenha.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lblSenha.setText("Senha:");

        pswSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pswSenhaActionPerformed(evt);
            }
        });

        tblCliente.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        tblCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tblCliente);

        lblId.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lblId.setText("Id:");

        javax.swing.GroupLayout pnlFormLayout = new javax.swing.GroupLayout(pnlForm);
        pnlForm.setLayout(pnlFormLayout);
        pnlFormLayout.setHorizontalGroup(
            pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormLayout.createSequentialGroup()
                .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIdade)
                    .addGroup(pnlFormLayout.createSequentialGroup()
                        .addComponent(lblId)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFormLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addComponent(lblCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ftxtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFormLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(lblNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24)
                .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(lblSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFormLayout.createSequentialGroup()
                        .addComponent(pswSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 59, Short.MAX_VALUE))
                    .addGroup(pnlFormLayout.createSequentialGroup()
                        .addComponent(txtEmail)
                        .addContainerGap())))
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        pnlFormLayout.setVerticalGroup(
            pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormLayout.createSequentialGroup()
                .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFormLayout.createSequentialGroup()
                        .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblId)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlFormLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pswSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSenha)
                            .addComponent(lblCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ftxtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        btnAdicionar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnAdicionar.setText("Adicionar");
        btnAdicionar.setBorder(new javax.swing.border.MatteBorder(null));
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnAlterar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.setBorder(new javax.swing.border.MatteBorder(null));
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnConsultar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnConsultar.setText("Consultar");
        btnConsultar.setBorder(new javax.swing.border.MatteBorder(null));
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        btnExcluir.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.setAlignmentX(1.0F);
        btnExcluir.setAlignmentY(1.0F);
        btnExcluir.setBorder(new javax.swing.border.MatteBorder(null));
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnSalvar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setAlignmentX(1.0F);
        btnSalvar.setAlignmentY(1.0F);
        btnSalvar.setBorder(new javax.swing.border.MatteBorder(null));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        txtConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConsultaActionPerformed(evt);
            }
        });
        txtConsulta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtConsultaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
            .addComponent(pnlForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(pnlForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed

    }//GEN-LAST:event_btnConsultarActionPerformed

    private void cbxSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSexoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxSexoActionPerformed

    private void pswSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pswSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pswSenhaActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        tipoEdicao = 'I';
        this.habDesabForm(true);
        this.limparDados();
        this.txtId.requestFocus();
        
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if(this.validarCampos()){
            this.salvarCliente();
            this.carregarTblCliente();
            this.limparDados();
            this.habDesabForm(false);
            JOptionPane.showMessageDialog(rootPane, "Dados Salvos com Sucesso!");
            
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
       tipoEdicao = 'E';
       this.habDesabForm(true);
       this.limparDados();
       this.alterarCliente();
     
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
       this.excluirCliente();
       this.limparDados();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void txtConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConsultaActionPerformed
   
    }//GEN-LAST:event_txtConsultaActionPerformed

    private void txtConsultaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConsultaKeyReleased
       this.consultarCliente(this.txtConsulta.getText().toUpperCase());
    }//GEN-LAST:event_txtConsultaKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbxSexo;
    private javax.swing.JFormattedTextField ftxtCpf;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblIdade;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlForm;
    private javax.swing.JPasswordField pswSenha;
    private javax.swing.JTable tblCliente;
    private javax.swing.JTextField txtConsulta;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIdade;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
