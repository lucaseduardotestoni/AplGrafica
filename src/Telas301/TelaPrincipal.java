package Telas301;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.sql.*;
import Acesso301DAO.ModuloConexao;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class TelaPrincipal extends javax.swing.JFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

private void TrocarCorVigencia(){
    String CodLic = "1";
        String sql = "select dtfimvig from tblicencont where cdliccont ="+CodLic;
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date dataAtual = new Date();
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                long miliseconds = dateFormat.parse(rs.getString(1)).getTime() - dataAtual.getTime();
                long dias = TimeUnit.MILLISECONDS.toDays(miliseconds);
                System.out.println(dias);
                if (dias <= 0){
                    btnChamados.setBackground( Color.RED );
                }else if (dias <= 3){
                    btnChamados.setBackground( Color.ORANGE );
                    
                }else if(dias <= 5){
                    btnChamados.setBackground( Color.YELLOW );
                }else if(dias > 5){
                    btnChamados.setBackground( Color.GREEN );
                }
            } 
        } catch (Exception e) {
            System.out.println("Erro no Banco "+e);
        
        }
    }
 

    public TelaPrincipal() {
        initComponents();
        conexao = ModuloConexao.connector();
        TrocarCorVigencia();
//        conexao = ModuloConexao.connector();
//        if (conexao != null) {
//            // lblDbStatus.setText("Conectado Ok!");
//            lblDbStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones301/DatabaseON-icon.png")));
//        }else {
//            // lblDbStatus.setText("NÃO Conectado.");
//            lblDbStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones301/DatabaseOFF-icon.png")));
//        }        

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlDesktop1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        lblDataSis = new javax.swing.JLabel();
        lblUsuarioLogado = new javax.swing.JLabel();
        btnChamados = new javax.swing.JButton();
        lblDbStatus = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnCadastros = new javax.swing.JMenu();
        mnCadastrosUsuarios = new javax.swing.JMenuItem();
        mnCadastrosPesNomeAv = new javax.swing.JMenuItem();
        mnCadastrosPerfil = new javax.swing.JMenuItem();
        mnCadastrosConfigs = new javax.swing.JMenuItem();
        mnUtilitarios = new javax.swing.JMenu();
        mnUtilitariosCalculadora = new javax.swing.JMenuItem();
        mnSistemas = new javax.swing.JMenu();
        mnSistemaMedias = new javax.swing.JMenuItem();
        mnAjuda = new javax.swing.JMenu();
        mnAjudaDocumentacao = new javax.swing.JMenuItem();
        mnAjudaSobre = new javax.swing.JMenuItem();
        mnSair = new javax.swing.JMenu();
        mnSairExit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Principal");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        javax.swing.GroupLayout pnlDesktop1Layout = new javax.swing.GroupLayout(pnlDesktop1);
        pnlDesktop1.setLayout(pnlDesktop1Layout);
        pnlDesktop1Layout.setHorizontalGroup(
            pnlDesktop1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 432, Short.MAX_VALUE)
        );
        pnlDesktop1Layout.setVerticalGroup(
            pnlDesktop1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 449, Short.MAX_VALUE)
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones301/LogoCedup.png"))); // NOI18N

        lblDataSis.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblDataSis.setText("Data do Sistema");

        lblUsuarioLogado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblUsuarioLogado.setForeground(new java.awt.Color(51, 51, 255));
        lblUsuarioLogado.setText("Usuário logado");

        btnChamados.setBackground(new java.awt.Color(255, 255, 255));
        btnChamados.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnChamados.setText("Chamados & Contrato");
        btnChamados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChamadosActionPerformed(evt);
            }
        });

        mnCadastros.setText("Cadastros");

        mnCadastrosUsuarios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_MASK));
        mnCadastrosUsuarios.setText("Usuários");
        mnCadastrosUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCadastrosUsuariosActionPerformed(evt);
            }
        });
        mnCadastros.add(mnCadastrosUsuarios);

        mnCadastrosPesNomeAv.setText("PesNome Avançada");
        mnCadastros.add(mnCadastrosPesNomeAv);

        mnCadastrosPerfil.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK));
        mnCadastrosPerfil.setText("Perfis");
        mnCadastrosPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCadastrosPerfilActionPerformed(evt);
            }
        });
        mnCadastros.add(mnCadastrosPerfil);

        mnCadastrosConfigs.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        mnCadastrosConfigs.setText("Configurações");
        mnCadastrosConfigs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCadastrosConfigsActionPerformed(evt);
            }
        });
        mnCadastros.add(mnCadastrosConfigs);

        jMenuBar1.add(mnCadastros);

        mnUtilitarios.setText("Utilitários");

        mnUtilitariosCalculadora.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        mnUtilitariosCalculadora.setText("Calculadora");
        mnUtilitariosCalculadora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnUtilitariosCalculadoraActionPerformed(evt);
            }
        });
        mnUtilitarios.add(mnUtilitariosCalculadora);

        jMenuBar1.add(mnUtilitarios);

        mnSistemas.setText("Sistema");

        mnSistemaMedias.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.ALT_MASK));
        mnSistemaMedias.setText("Medias");
        mnSistemaMedias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnSistemaMediasActionPerformed(evt);
            }
        });
        mnSistemas.add(mnSistemaMedias);

        jMenuBar1.add(mnSistemas);

        mnAjuda.setText("Ajuda");

        mnAjudaDocumentacao.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        mnAjudaDocumentacao.setText("Manual Documentacao");
        mnAjudaDocumentacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnAjudaDocumentacaoActionPerformed(evt);
            }
        });
        mnAjuda.add(mnAjudaDocumentacao);

        mnAjudaSobre.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        mnAjudaSobre.setText("Sobre");
        mnAjudaSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnAjudaSobreActionPerformed(evt);
            }
        });
        mnAjuda.add(mnAjudaSobre);

        jMenuBar1.add(mnAjuda);

        mnSair.setText("Sair");

        mnSairExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        mnSairExit.setText("Exit");
        mnSairExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnSairExitActionPerformed(evt);
            }
        });
        mnSair.add(mnSairExit);

        jMenuBar1.add(mnSair);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlDesktop1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(lblDataSis, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblUsuarioLogado, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnChamados)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(lblDbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlDesktop1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDataSis, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(lblUsuarioLogado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnChamados)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setSize(new java.awt.Dimension(606, 509));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mnSairExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnSairExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);

    }//GEN-LAST:event_mnSairExitActionPerformed

    private void mnCadastrosUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCadastrosUsuariosActionPerformed
        // TODO add your handling code here:
        TelaUsuarios tlUsuarios = new TelaUsuarios();
        tlUsuarios.setVisible(true);
    }//GEN-LAST:event_mnCadastrosUsuariosActionPerformed

    private void mnUtilitariosCalculadoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnUtilitariosCalculadoraActionPerformed
        // TODO add your handling code here:
        TelaCalculadora tlCalculadora = new TelaCalculadora();
        tlCalculadora.setVisible(true);
    }//GEN-LAST:event_mnUtilitariosCalculadoraActionPerformed

    private void mnSistemaMediasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnSistemaMediasActionPerformed
        // TODO add your handling code here:
        TelaMedias tlMedias = new TelaMedias();
        tlMedias.setVisible(true);
    }//GEN-LAST:event_mnSistemaMediasActionPerformed

    private void mnAjudaDocumentacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnAjudaDocumentacaoActionPerformed
        // TODO add your handling code here:
        TelaDocumentacao tlDocumentacao = new TelaDocumentacao();
        tlDocumentacao.setVisible(true);
    }//GEN-LAST:event_mnAjudaDocumentacaoActionPerformed

    private void mnAjudaSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnAjudaSobreActionPerformed
        // TODO add your handling code here:
        TelaSobre tlSobre = new TelaSobre();
        tlSobre.setVisible(true);
    }//GEN-LAST:event_mnAjudaSobreActionPerformed

    private void mnCadastrosPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCadastrosPerfilActionPerformed
        // TODO add your handling code here:
        TelaPerfil tlPerfil = new TelaPerfil();
        tlPerfil.setVisible(true);
        pnlDesktop1.add(tlPerfil);
    }//GEN-LAST:event_mnCadastrosPerfilActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        Date data = new Date();
        DateFormat formatador = DateFormat.getDateInstance(DateFormat.MEDIUM);
        lblDataSis.setText(formatador.format(data));

        // Definir Nova variável para trabalhar com a data para o padrão MySQL e
        // Comparar datas.
        //       Date dtAtual = new Date();
        // Formatando a data atual em uma variavel padrao data MySQL.
//        SimpleDateFormat formatandoDT = new SimpleDateFormat("YYYYMMdd");
//        String dtFormatadaOk = formatandoDT.format(dtAtual);
//        int dtAtualOK = Integer.parseInt (dtFormatadaOk);
        // Acessamdo a tabela "licencont" para a ultima licença vigente.
//        String sql = "select * from tblicencont";
//        try {
        // Finalizar a preparação do comando na conexao do banco.
//            pst = conexao.prepareStatement(sql);
//            rs = pst.executeQuery();
//            if (rs.last()) {
        // Para a Licença vigente, verificar as datas
//                String dtIniVig = rs.getString(5);
//                String dtIniVigOK = dtIniVig.replace("-","");
//                int dtIniNum = Integer.parseInt(dtIniVigOK);
//                String dtFimVig = rs.getString(6);
//                System.out.println("A data eh: " + dtIniNum);
//            } else {
//                JOptionPane.showMessageDialog(null,"Software sem Licença Vigente - Verifique.");
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null,"Banco de Dados com ERRO!!!");
//        }        

    }//GEN-LAST:event_formWindowActivated

    private void mnCadastrosConfigsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCadastrosConfigsActionPerformed
        // TODO add your handling code here:
        TelaConfig tlConfig = new TelaConfig();
        tlConfig.setVisible(true);
        pnlDesktop1.add(tlConfig);
    }//GEN-LAST:event_mnCadastrosConfigsActionPerformed

    private void btnChamadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChamadosActionPerformed
        // TODO add your handling code here:
        TelaChamados301Luc tlChamados = new TelaChamados301Luc();
        tlChamados.setVisible(true);

    }//GEN-LAST:event_btnChamadosActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChamados;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lblDataSis;
    private javax.swing.JLabel lblDbStatus;
    public static javax.swing.JLabel lblUsuarioLogado;
    private javax.swing.JMenu mnAjuda;
    private javax.swing.JMenuItem mnAjudaDocumentacao;
    private javax.swing.JMenuItem mnAjudaSobre;
    private javax.swing.JMenu mnCadastros;
    private javax.swing.JMenuItem mnCadastrosConfigs;
    private javax.swing.JMenuItem mnCadastrosPerfil;
    private javax.swing.JMenuItem mnCadastrosPesNomeAv;
    private javax.swing.JMenuItem mnCadastrosUsuarios;
    private javax.swing.JMenu mnSair;
    private javax.swing.JMenuItem mnSairExit;
    private javax.swing.JMenuItem mnSistemaMedias;
    private javax.swing.JMenu mnSistemas;
    private javax.swing.JMenu mnUtilitarios;
    private javax.swing.JMenuItem mnUtilitariosCalculadora;
    private javax.swing.JDesktopPane pnlDesktop1;
    // End of variables declaration//GEN-END:variables
}
