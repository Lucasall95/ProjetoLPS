/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author corns
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        pnlTelaPrincipal = new javax.swing.JPanel();
        lblCadastros = new javax.swing.JLabel();
        btnCadCliente = new javax.swing.JButton();
        btnCadFuncionario = new javax.swing.JButton();
        btnCadImpressora = new javax.swing.JButton();
        lblRelatorios = new javax.swing.JLabel();
        btnRelatLocacao = new javax.swing.JButton();
        btnRelatManutencao = new javax.swing.JButton();
        lblAlugar = new javax.swing.JLabel();
        btnLocacaoImpressora = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuCadastro = new javax.swing.JMenu();
        jMenuCadClientes = new javax.swing.JMenuItem();
        jMenuCadFuncionarios = new javax.swing.JMenuItem();
        jMenuCadImpressoras = new javax.swing.JMenuItem();
        jMenuRelatorios = new javax.swing.JMenu();
        jMenuManutencao = new javax.swing.JMenuItem();
        jMenuRelatLocacao = new javax.swing.JMenuItem();
        jMenuLocacao = new javax.swing.JMenu();
        jMenuAlugarImpressora = new javax.swing.JMenuItem();
        jMenuSair = new javax.swing.JMenu();
        jMenuSairTelaP = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sistema de Locação de Impressoras");

        lblCadastros.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblCadastros.setText("Cadastros: ");

        btnCadCliente.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnCadCliente.setText("Cliente");
        btnCadCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadClienteActionPerformed(evt);
            }
        });

        btnCadFuncionario.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnCadFuncionario.setText("Funcionários");
        btnCadFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadFuncionarioActionPerformed(evt);
            }
        });

        btnCadImpressora.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnCadImpressora.setText("Impressoras");
        btnCadImpressora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadImpressoraActionPerformed(evt);
            }
        });

        lblRelatorios.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblRelatorios.setText("Relatórios:");

        btnRelatLocacao.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnRelatLocacao.setText("Locação");

        btnRelatManutencao.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnRelatManutencao.setText("Manutenção");

        lblAlugar.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblAlugar.setText("Alugar Impressora:");

        btnLocacaoImpressora.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnLocacaoImpressora.setText("Locação");
        btnLocacaoImpressora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocacaoImpressoraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTelaPrincipalLayout = new javax.swing.GroupLayout(pnlTelaPrincipal);
        pnlTelaPrincipal.setLayout(pnlTelaPrincipalLayout);
        pnlTelaPrincipalLayout.setHorizontalGroup(
            pnlTelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTelaPrincipalLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(pnlTelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTelaPrincipalLayout.createSequentialGroup()
                        .addComponent(lblAlugar)
                        .addGap(45, 45, 45)
                        .addComponent(btnLocacaoImpressora))
                    .addGroup(pnlTelaPrincipalLayout.createSequentialGroup()
                        .addGroup(pnlTelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCadastros)
                            .addComponent(lblRelatorios))
                        .addGap(31, 31, 31)
                        .addGroup(pnlTelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlTelaPrincipalLayout.createSequentialGroup()
                                .addComponent(btnCadCliente)
                                .addGap(53, 53, 53)
                                .addComponent(btnCadFuncionario))
                            .addGroup(pnlTelaPrincipalLayout.createSequentialGroup()
                                .addComponent(btnRelatLocacao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRelatManutencao)))
                        .addGap(71, 71, 71)
                        .addComponent(btnCadImpressora)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        pnlTelaPrincipalLayout.setVerticalGroup(
            pnlTelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTelaPrincipalLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnlTelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCadastros)
                    .addComponent(btnCadCliente)
                    .addComponent(btnCadFuncionario)
                    .addComponent(btnCadImpressora))
                .addGap(59, 59, 59)
                .addGroup(pnlTelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRelatorios)
                    .addComponent(btnRelatLocacao)
                    .addComponent(btnRelatManutencao))
                .addGap(67, 67, 67)
                .addGroup(pnlTelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAlugar)
                    .addComponent(btnLocacaoImpressora))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jMenuCadastro.setText("Cadastros");

        jMenuCadClientes.setText("Clientes");
        jMenuCadClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCadClientesActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuCadClientes);

        jMenuCadFuncionarios.setText("Funcionários");
        jMenuCadFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCadFuncionariosActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuCadFuncionarios);

        jMenuCadImpressoras.setText("Impressoras");
        jMenuCadImpressoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCadImpressorasActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuCadImpressoras);

        jMenuBar1.add(jMenuCadastro);

        jMenuRelatorios.setText("Relatórios");

        jMenuManutencao.setText("Manutenção");
        jMenuRelatorios.add(jMenuManutencao);

        jMenuRelatLocacao.setText("Locação");
        jMenuRelatorios.add(jMenuRelatLocacao);

        jMenuBar1.add(jMenuRelatorios);

        jMenuLocacao.setText("Locação");

        jMenuAlugarImpressora.setText("Alugar Impressora");
        jMenuAlugarImpressora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuAlugarImpressoraActionPerformed(evt);
            }
        });
        jMenuLocacao.add(jMenuAlugarImpressora);

        jMenuBar1.add(jMenuLocacao);

        jMenuSair.setText("Sair");

        jMenuSairTelaP.setText("Sair");
        jMenuSairTelaP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSairTelaPActionPerformed(evt);
            }
        });
        jMenuSair.add(jMenuSairTelaP);

        jMenuBar1.add(jMenuSair);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlTelaPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addComponent(pnlTelaPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadClienteActionPerformed
        FrCliente telaCliente = new FrCliente();
        telaCliente.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCadClienteActionPerformed

    private void btnCadFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadFuncionarioActionPerformed
        FrFuncionario telaFuncionario = new FrFuncionario();
        telaFuncionario.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCadFuncionarioActionPerformed

    private void btnCadImpressoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadImpressoraActionPerformed
        FrImpressora telaImpressora = new FrImpressora();
        telaImpressora.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCadImpressoraActionPerformed

    private void btnLocacaoImpressoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocacaoImpressoraActionPerformed
        FrLocacao telaLocacao = new FrLocacao();
        telaLocacao.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnLocacaoImpressoraActionPerformed

    private void jMenuCadClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCadClientesActionPerformed
        FrCliente telaCliente = new FrCliente();
        telaCliente.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuCadClientesActionPerformed

    private void jMenuCadFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCadFuncionariosActionPerformed
        FrFuncionario telaFuncionario = new FrFuncionario();
        telaFuncionario.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuCadFuncionariosActionPerformed

    private void jMenuCadImpressorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCadImpressorasActionPerformed
        FrLocacao telaLocacao = new FrLocacao();
        telaLocacao.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuCadImpressorasActionPerformed

    private void jMenuAlugarImpressoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuAlugarImpressoraActionPerformed
        FrLocacao telaLocacao = new FrLocacao();
        telaLocacao.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuAlugarImpressoraActionPerformed

    private void jMenuSairTelaPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSairTelaPActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuSairTelaPActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadCliente;
    private javax.swing.JButton btnCadFuncionario;
    private javax.swing.JButton btnCadImpressora;
    private javax.swing.JButton btnLocacaoImpressora;
    private javax.swing.JButton btnRelatLocacao;
    private javax.swing.JButton btnRelatManutencao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMenuAlugarImpressora;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuCadClientes;
    private javax.swing.JMenuItem jMenuCadFuncionarios;
    private javax.swing.JMenuItem jMenuCadImpressoras;
    private javax.swing.JMenu jMenuCadastro;
    private javax.swing.JMenu jMenuLocacao;
    private javax.swing.JMenuItem jMenuManutencao;
    private javax.swing.JMenuItem jMenuRelatLocacao;
    private javax.swing.JMenu jMenuRelatorios;
    private javax.swing.JMenu jMenuSair;
    private javax.swing.JMenuItem jMenuSairTelaP;
    private javax.swing.JLabel lblAlugar;
    private javax.swing.JLabel lblCadastros;
    private javax.swing.JLabel lblRelatorios;
    private javax.swing.JPanel pnlTelaPrincipal;
    // End of variables declaration//GEN-END:variables
}
