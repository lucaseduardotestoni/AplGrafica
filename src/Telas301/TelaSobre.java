/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas301;

/**
 *
 * @author Alunos
 */
public class TelaSobre extends javax.swing.JFrame {

    /**
     * Creates new form TelaSobre
     */
    public TelaSobre() {
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

        btnFechar = new javax.swing.JButton();
        lblDsProduto = new javax.swing.JLabel();
        lblVersaoProduto = new javax.swing.JLabel();
        lblLicenciamento = new javax.swing.JLabel();
        lblManuais = new javax.swing.JLabel();
        lblEof = new javax.swing.JLabel();
        lblFornecedor = new javax.swing.JLabel();
        lblManSis = new javax.swing.JLabel();
        lblDataEof = new javax.swing.JLabel();
        lblNomeFornecedor = new javax.swing.JLabel();
        lblLicenProd = new javax.swing.JLabel();
        lblVersaoProd = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tela Sobre");
        setResizable(false);

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        lblDsProduto.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblDsProduto.setText("Aplicação Gráfica 301");

        lblVersaoProduto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblVersaoProduto.setText("Versão Produto:");

        lblLicenciamento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblLicenciamento.setText("Licenciamento:");

        lblManuais.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblManuais.setText("Manuais:");

        lblEof.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblEof.setText("End Of Life (EOF):");

        lblFornecedor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblFornecedor.setText("Fornecedor:");

        lblManSis.setText("http://www.infem301.com");

        lblDataEof.setText("31/12/2022");

        lblNomeFornecedor.setText("INFEM301");

        lblLicenProd.setText("GPL versão");

        lblVersaoProd.setText("2.1 Release 1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(lblDsProduto))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblLicenciamento)
                            .addComponent(lblVersaoProduto)
                            .addComponent(lblManuais)
                            .addComponent(lblEof)
                            .addComponent(lblFornecedor))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblManSis)
                                    .addComponent(lblDataEof)
                                    .addComponent(lblLicenProd)
                                    .addComponent(lblVersaoProd)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(lblNomeFornecedor))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(btnFechar)))
                .addContainerGap(156, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lblDsProduto)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVersaoProduto)
                    .addComponent(lblVersaoProd))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLicenciamento)
                    .addComponent(lblLicenProd))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblManuais)
                    .addComponent(lblManSis))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEof)
                    .addComponent(lblDataEof))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFornecedor)
                    .addComponent(lblNomeFornecedor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(btnFechar)
                .addGap(45, 45, 45))
        );

        setSize(new java.awt.Dimension(495, 405));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaSobre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaSobre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaSobre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaSobre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaSobre().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFechar;
    private javax.swing.JLabel lblDataEof;
    private javax.swing.JLabel lblDsProduto;
    private javax.swing.JLabel lblEof;
    private javax.swing.JLabel lblFornecedor;
    private javax.swing.JLabel lblLicenProd;
    private javax.swing.JLabel lblLicenciamento;
    private javax.swing.JLabel lblManSis;
    private javax.swing.JLabel lblManuais;
    private javax.swing.JLabel lblNomeFornecedor;
    private javax.swing.JLabel lblVersaoProd;
    private javax.swing.JLabel lblVersaoProduto;
    // End of variables declaration//GEN-END:variables
}