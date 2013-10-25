/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rodolfohahn.locadora.controller.view;

import br.com.rodolfohahn.locadora.controller1.FuncionarioController;
import br.com.rodolfohahn.locadora.modelo.Endereco;
import br.com.rodolfohahn.locadora.modelo.Funcionario;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author guest01
 */
public class FuncionarioCadastro extends javax.swing.JFrame {
    private DefaultTableModel modelo;
    private int linhaSelecionada;

    /**
     * Creates new form Funcionario
     */
    public FuncionarioCadastro(DefaultTableModel modelo, int linhaSelecionada, int idFuncionario) {
        this.linhaSelecionada = linhaSelecionada;
        this.modelo = modelo;
        initComponents();
        FuncionarioController fc = new FuncionarioController();
        Funcionario f = fc.listById(idFuncionario);
        
        txId.setText(Integer.toString(f.getId()));
        txNome.setText(f.getNome());
        txTelFixo.setText(f.getTelFixo());
        txTelCel.setText(f.getTelCel());
        txCpf.setText(f.getCpf());
        txRua.setText("");
        txComplemento.setText("");
        txBairro.setText("");
        txCidade.setText("");
        txNumero.setText("");
        txCep.setText("");
        txSalario.setText(Double.toString(f.getSalario()));
        txCtps.setText(f.getCtps());
        txLogin.setText(f.getLogin());
        txSenha.setText(f.getSenha());
        txIdade.setText(Integer.toString(f.getIdade()));
        txDataAdmissao.setText("");
        if (f.getSexo().equals("Feminino")) {
            rbFeminino.setSelected(true);
        } else if (f.getSexo().equals("Masculino")) {
            rbMasculino.setSelected(true);
        }
        
    }
    public FuncionarioCadastro() {
 
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoSexo = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txNome = new javax.swing.JTextField();
        txTelFixo = new javax.swing.JTextField();
        txTelCel = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txRua = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txComplemento = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txBairro = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txCidade = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txNumero = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txCep = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txSalario = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txCtps = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txLogin = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txSenha = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txDataAdmissao = new javax.swing.JTextField();
        btLimpar = new javax.swing.JButton();
        btAdicionar = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        txId = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txIdade = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txCpf = new javax.swing.JTextField();
        rbMasculino = new javax.swing.JRadioButton();
        rbFeminino = new javax.swing.JRadioButton();
        jLabel18 = new javax.swing.JLabel();
        txIdEndereco = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel2.setText("Telefone Fixo:");

        jLabel1.setText("Nome:");

        jLabel3.setText("Telefone Celular:");

        txTelCel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txTelCelActionPerformed(evt);
            }
        });

        jLabel4.setText("Rua:");

        jLabel5.setText("Complemento:");

        jLabel6.setText("Bairro:");

        txBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txBairroActionPerformed(evt);
            }
        });

        jLabel7.setText("Cidade:");

        jLabel8.setText("Número:");

        jLabel9.setText("CEP:");

        jLabel10.setText("Salario:");

        jLabel11.setText("CTPS:");

        jLabel12.setText("Login:");

        jLabel13.setText("Senha:");

        txSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txSenhaActionPerformed(evt);
            }
        });

        jLabel14.setText("Data Admissão:");

        txDataAdmissao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txDataAdmissaoActionPerformed(evt);
            }
        });

        btLimpar.setText("Limpar");
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });

        btAdicionar.setText("Adicionar");
        btAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionarActionPerformed(evt);
            }
        });

        jLabel15.setText("Código:");

        txId.setEditable(false);

        jLabel16.setText("Idade:");

        jLabel17.setText("CPF:");

        grupoSexo.add(rbMasculino);
        rbMasculino.setText("Masculino");
        rbMasculino.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        grupoSexo.add(rbFeminino);
        rbFeminino.setText("Feminino");
        rbFeminino.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel18.setText("Sexo:");

        txIdEndereco.setEditable(false);

        jLabel19.setText("Código endereço:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(467, 467, 467)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txCep, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txSalario))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addGap(10, 10, 10)
                                .addComponent(txCidade))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txRua, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txComplemento))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txTelFixo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txTelCel, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txNome)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txId, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel18))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(rbFeminino)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rbMasculino)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btAdicionar)
                                        .addGap(18, 18, 18)
                                        .addComponent(btLimpar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addComponent(txSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel11)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txCtps, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel17)
                                                .addGap(18, 18, 18)
                                                .addComponent(txCpf)))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel14)
                                            .addComponent(jLabel16)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(18, 18, 18)
                                        .addComponent(txLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel19)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txDataAdmissao)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txIdEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(txId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txTelFixo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txTelCel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txCtps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(txDataAdmissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(txCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txIdEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btLimpar)
                    .addComponent(btAdicionar)
                    .addComponent(rbFeminino)
                    .addComponent(rbMasculino)
                    .addComponent(jLabel18))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txTelCelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txTelCelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txTelCelActionPerformed

    private void txBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txBairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txBairroActionPerformed

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        txId.setText("");
        txNome.setText("");
        txTelFixo.setText("");
        txTelCel.setText("");
        txCpf.setText("");
        txRua.setText("");
        txComplemento.setText("");
        txBairro.setText("");
        txCidade.setText("");
        txNumero.setText("");
        txCep.setText("");
        txSalario.setText("");
        txCtps.setText("");
        txLogin.setText("");
        txSenha.setText("");
        txIdade.setText("");
        txDataAdmissao.setText("");
    }//GEN-LAST:event_btLimparActionPerformed

    private void txDataAdmissaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txDataAdmissaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txDataAdmissaoActionPerformed

    private void btAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarActionPerformed
       Funcionario f = new Funcionario();
        if (!(txId.getText().equals("") || (txId.getText().equals(null)))) {
            f.setId(Integer.parseInt(txId.getText()));
        }
        f.setNome(txNome.getText());
        f.setTelFixo(txTelFixo.getText());
        f.setTelCel(txTelCel.getText());
        Endereco e = new Endereco();
        if (!(txIdEndereco.getText().equals("") || (txIdEndereco.getText().equals(null)))) {
            e.setId_end(Integer.parseInt(txIdEndereco.getText()));
        }
        e.setRua(txRua.getText());
        e.setComplemento(txComplemento.getText());
        e.setBairro(txBairro.getText());
        e.setCidade(txCidade.getText());
        if (!(txNumero.getText().equals("") || (txNumero.getText().equals(null)))) {
            e.setNumero(Integer.parseInt(txNumero.getText()));
        }
        e.setCep(txCep.getText());
        if (!(txSalario.getText().equals("") || (txSalario.getText().equals(null)))) {
            f.setSalario(Double.parseDouble(txSalario.getText()));
        }
        f.setEndereco(e);
        f.setCtps(txCtps.getText());
        f.setLogin(txLogin.getText());
        f.setSenha(txSenha.getText());
        f.setCpf(txCpf.getText());
        if (rbFeminino.isSelected()){
           f.setSexo("Feminino");
        } else if (rbMasculino.isSelected()) {
            f.setSexo("Masculino");
        }
       

        try {
            String data = txDataAdmissao.getText();
            f.setDataAdmissao(new SimpleDateFormat("dd/MM/yyyy").parse(data));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "erro ao converter a data");
        }

        FuncionarioController fc = new FuncionarioController();



        if (f.getId() == 0) {
            int id = fc.salvar(f);
            modelo.addRow(new Object[]{id, f.getNome(), f.getCpf(), f.getLogin()});

//            if (id > 0) {
//                modelo.addRow(new Object[]{id, f.getNome(), f.getCpf(), f.getLogin()});
//                JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
//            }
        } else {
                int idFuncionario = fc.salvar(f);
                if (idFuncionario > 0) {
                    modelo.removeRow(linhaSelecionada);
                    

                }
            }
            //limpar campos

            dispose();
    }//GEN-LAST:event_btAdicionarActionPerformed

    private void txSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txSenhaActionPerformed

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Funcionario().setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdicionar;
    private javax.swing.JButton btLimpar;
    private javax.swing.ButtonGroup grupoSexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton rbFeminino;
    private javax.swing.JRadioButton rbMasculino;
    private javax.swing.JTextField txBairro;
    private javax.swing.JTextField txCep;
    private javax.swing.JTextField txCidade;
    private javax.swing.JTextField txComplemento;
    private javax.swing.JTextField txCpf;
    private javax.swing.JTextField txCtps;
    private javax.swing.JTextField txDataAdmissao;
    private javax.swing.JTextField txId;
    private javax.swing.JTextField txIdEndereco;
    private javax.swing.JTextField txIdade;
    private javax.swing.JTextField txLogin;
    private javax.swing.JTextField txNome;
    private javax.swing.JTextField txNumero;
    private javax.swing.JTextField txRua;
    private javax.swing.JTextField txSalario;
    private javax.swing.JTextField txSenha;
    private javax.swing.JTextField txTelCel;
    private javax.swing.JTextField txTelFixo;
    // End of variables declaration//GEN-END:variables
}
