/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rodolfohahn.locadora.controller.view;

import br.com.rodolfohahn.locadora.controller1.FuncionarioController;
import br.com.rodolfohahn.locadora.modelo.Funcionario;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author guest01
 */
public class FuncionarioListar extends javax.swing.JFrame {
    private JTable tabela;
    private DefaultTableModel modelo = new DefaultTableModel();

    /**
     * Creates new form FuncionarioListar
     */
    public FuncionarioListar() {
        initComponents();
        criaJTable();
        PainelRolagem.setViewportView(tabela);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txPesquisar = new javax.swing.JTextField();
        btRemover = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        PainelRolagem = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(500, 500));

        jLabel1.setText("Pesquisar");

        txPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txPesquisarActionPerformed(evt);
            }
        });

        btRemover.setText("Remover");
        btRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoverActionPerformed(evt);
            }
        });

        btEditar.setText("Editar");
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(PainelRolagem, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btRemover))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btRemover)
                    .addComponent(btEditar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PainelRolagem, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        int linhaSelecionada = -1;
        linhaSelecionada = tabela.getSelectedRow();
        if(linhaSelecionada >=0){
            int idFuncionario = (int)tabela.getValueAt(linhaSelecionada, 0);
            FuncionarioCadastro fuc = new FuncionarioCadastro(modelo,linhaSelecionada,idFuncionario);
            fuc.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "ERRO Y:= nenhuma linha selecionada");
        }
    }//GEN-LAST:event_btEditarActionPerformed

    private void btRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverActionPerformed
                                                  
        int linhaSelecionada = -1;
        linhaSelecionada = tabela.getSelectedRow();
        if (linhaSelecionada >= 0) {
            int idFuncionario = (int) tabela.getValueAt(linhaSelecionada, 0);
            FuncionarioController fc = new FuncionarioController();
            if (fc.remove(idFuncionario)) {
                modelo.removeRow(linhaSelecionada);
            }else{
                JOptionPane.showMessageDialog(null, "ERRO Y:= nenhuma linha foi selecionada");
            }
        }
               
    }//GEN-LAST:event_btRemoverActionPerformed

    private void txPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txPesquisarActionPerformed
        String nome = txPesquisar.getText();
        FuncionarioController fc = new FuncionarioController();
        modelo.setNumRows(0);
        for (Funcionario f:fc.listByNome(nome)){
            modelo.addRow(new Object[]{f.getId(),f.getNome(),f.getCpf(),f.getLogin()});
        }
    }//GEN-LAST:event_txPesquisarActionPerformed

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
//            java.util.logging.Logger.getLogger(FuncionarioListar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FuncionarioListar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FuncionarioListar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FuncionarioListar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FuncionarioListar().setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane PainelRolagem;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btRemover;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txPesquisar;
    // End of variables declaration//GEN-END:variables

private void criaJTable() {
        tabela = new JTable(modelo);
        modelo.addColumn("Id");
        modelo.addColumn("Nome");
        modelo.addColumn("CPF");
        modelo.addColumn("Login");
        preencherJTable();
    }

private void preencherJTable() {
        FuncionarioController fc = new FuncionarioController();
        for (Funcionario f : fc.ListarTodos()) {
            modelo.addRow(new Object[]{f.getId(), f.getNome(), f.getCpf(), f.getLogin()});
        }
    }


}
