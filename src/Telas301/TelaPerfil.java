package Telas301;

// 1 - Importar Bibliotecas e Modulos.
import java.sql.*;
import Acesso301DAO.ModuloConexao;
import java.awt.Color;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;


public class TelaPerfil extends javax.swing.JInternalFrame {
// 2 - Criar/Definir as variáveis especias/conexao.
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public void consultar() {
        // 1 Criar a String com o comando SQL.
        String sql = "select * from tbperfil where idcadperfil = ?";
        try {
            // Finalizar a preparação do comando na conexao do banco.
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtIdPerfil.getText());
            // Executar o comando/Consulta.
            rs = pst.executeQuery();
            // Verificar/testar o resultado da Consulta
            if (rs.next()) {
                // Se existir o Cadastro...
                txtIdPerfil.setText(rs.getString(1));
                txtDsPerfil.setText(rs.getString(2));
                txtSearchNome.setText("Search Nome...");
                // conexao.close();
            } else {
                JOptionPane.showMessageDialog(null,"Cadastro inexistente - Verifique.");
                txtIdPerfil.setText("");
                txtDsPerfil.setText("");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Banco de Dados com ERRO!!!");
        
        }
    }
    
    public void consultarUltimo() {
        // 1 Criar a String com o comando SQL.
        String sql = "select * from tbperfil where idcadperfil";
        try {
            // Finalizar a preparação do comando na conexao do banco.
            pst = conexao.prepareStatement(sql);
            //pst.setString(1, txtIdPerfil.getText());
            // Executar o comando/Consulta.
            rs = pst.executeQuery();
            // Verificar/testar o resultado da Consulta
            if (rs.last()) {
                // Se existir o Cadastro...
                txtIdPerfil.setText(rs.getString(1));
                txtDsPerfil.setText(rs.getString(2));
                txtSearchNome.setText("Search Nome...");
                // conexao.close();
            } else {
                JOptionPane.showMessageDialog(null,"Cadastro inexistente - Verifique.");
                txtIdPerfil.setText("");
                txtDsPerfil.setText("");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Banco de Dados com ERRO!!!");
        
        }
    }
    
    public void consultarPrimeiro() {
        // 1 Criar a String com o comando SQL.
        String sql = "select * from tbperfil;";
        try {
            // Finalizar a preparação do comando na conexao do banco.
            pst = conexao.prepareStatement(sql);
            //pst.setString(1, txtIdPerfil.getText());
            // Executar o comando/Consulta.
            rs = pst.executeQuery();
            // Verificar/testar o resultado da Consulta
            if (rs.first()) {
                // Se existir o Cadastro...
                txtIdPerfil.setText(rs.getString(1));
                txtDsPerfil.setText(rs.getString(2));
                txtSearchNome.setText("Search Nome...");
                // conexao.close();
            } else {
                JOptionPane.showMessageDialog(null,"Cadastro inexistente - Verifique.");
                txtIdPerfil.setText("");
                txtDsPerfil.setText("");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Banco de Dados com ERRO!!!");
        
        }        
    }
    
    public void consultarAnterior() {
        // 1 Criar a String com o comando SQL.
        String sql = "select * from tbperfil where idcadperfil = ? - 1;";
        try {
            // Finalizar a preparação do comando na conexao do banco.
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtIdPerfil.getText());
            // Executar o comando/Consulta.
            rs = pst.executeQuery();
            // Verificar/testar o resultado da Consulta
            if (rs.next()) {
                // Se existir o Cadastro...
                txtIdPerfil.setText(rs.getString(1));
                txtDsPerfil.setText(rs.getString(2));
                txtSearchNome.setText("Search Nome...");
                // conexao.close();
            } else {
                JOptionPane.showMessageDialog(null,"Cadastro inexistente - Verifique.");
                txtIdPerfil.setText("");
                txtDsPerfil.setText("");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Banco de Dados com ERRO!!!");
        
        }         
    }
    
    public void consultarProximo() {
        // 1 Criar a String com o comando SQL.
        String sql = "select * from tbperfil where idcadperfil = ? + 1;";
        try {
            // Finalizar a preparação do comando na conexao do banco.
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtIdPerfil.getText());
            // Executar o comando/Consulta.
            rs = pst.executeQuery();
            // Verificar/testar o resultado da Consulta
            if (rs.next()) {
                // Se existir o Cadastro...
                txtIdPerfil.setText(rs.getString(1));
                txtDsPerfil.setText(rs.getString(2));
                txtSearchNome.setText("Search Nome...");
                // conexao.close();
            } else {
                JOptionPane.showMessageDialog(null,"Cadastro inexistente - Verifique.");
                txtIdPerfil.setText("");
                txtDsPerfil.setText("");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Banco de Dados com ERRO!!!");
        
        }         
    }
    
    public void consultarNome() {
        // 1 Criar a String com o comando SQL.
        String sql = "select * from vw_nomeperfil where NOME like ?;";
        try {
            // Finalizar a preparação do comando na conexao do banco.
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtSearchNome.getText() + "%");
            // Executar o comando/Consulta.
            rs = pst.executeQuery();
            // Verificar/testar o resultado da Consulta
            if (rs.next()) {
                // Se existir o Cadastro...
                tblPerfis.setModel(DbUtils.resultSetToTableModel(rs));
                //txtIdPerfil.setText(rs.getString(1));
                //txtDsPerfil.setText(rs.getString(2));
                //txtSearchNome.setText("Search Nome...");
                // conexao.close();
            } else {
                JOptionPane.showMessageDialog(null,"Cadastro inexistente - Verifique.");
                txtIdPerfil.setText("");
                txtDsPerfil.setText("");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Banco de Dados com ERRO!!!");
        
        }           
        
    }
    
    public void setarCamposSelecionados() {
        // a instrução abaixo,Pega a linha clickada...
        int linhaK = tblPerfis.getSelectedRow();
        // System.out.println("Linka K = " + linhaK);
        txtDsPerfil.setText(tblPerfis.getModel().getValueAt(linhaK, 0).toString());
        txtIdPerfil.setText(tblPerfis.getModel().getValueAt(linhaK, 1).toString());
    }
    
    public void incluir() {
     // 1 Criar a String com o comando SQL.
        String sql = "insert into tbperfil(idcadperfil,dsperfil) values(?,?)";
        try {
            // Finalizar a preparação do comando na conexao do banco.
            pst = conexao.prepareStatement(sql);
            pst.setString(1, null);
            pst.setString(2, txtDsPerfil.getText());
            // Executar o comando a inserção no Banco.
            int incluiOK = pst.executeUpdate();
            // Verificar/testar o resultado da Consulta
            if (incluiOK > 0) {
                // Se incluiu OK
                JOptionPane.showMessageDialog(null,"Incluído com Sucesso!");
                txtIdPerfil.setText("");
                txtDsPerfil.setText("");
                txtSearchNome.setText("Search Nome...");
            } else {
                JOptionPane.showMessageDialog(null,"Erro na inclusão - Verifique.");
                txtIdPerfil.setText("");
                txtDsPerfil.setText("");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Banco de Dados com ERRO!!!");
        
        }        
        
    }
    
    public void alterar() {
     // 1 Criar a String com o comando SQL.
        String sql = "update tbperfil set dsperfil=? where idcadperfil=?";
        try {
            // Finalizar a preparação do comando na conexao do banco.
            pst = conexao.prepareStatement(sql);
            pst.setString(2, txtIdPerfil.getText());
            pst.setString(1, txtDsPerfil.getText());
            if (txtDsPerfil.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null,"Campo não preenchido - Verifique!");
            }else {
                // Executar o comando a inserção no Banco.
                int alteraOK = pst.executeUpdate();
                // Verificar/testar o resultado da Consulta
                if (alteraOK > 0) {
                    // Se incluiu OK
                    JOptionPane.showMessageDialog(null,"Alterado com Sucesso!");
                    txtIdPerfil.setText("");
                    txtDsPerfil.setText("");
                    txtSearchNome.setText("Search Nome...");
                    // conexao.close();
                    } else {
                        JOptionPane.showMessageDialog(null,"Erro na inclusão - Verifique.");
                        txtIdPerfil.setText("");
                        txtDsPerfil.setText("");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Banco de Dados com ERRO!!!");
        
        }        
        
    }
    
    public void excluir() {
     // 1 Criar a String com o comando SQL.
        String sql = "delete from tbperfil where idcadperfil=?";
        try {
            // Finalizar a preparação do comando na conexao do banco.
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtIdPerfil.getText());
            if (txtDsPerfil.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null,"Campo não preenchido - Verifique!");
            }else {
                // Executar o comando de deleção no Banco.
                int excluiOK = pst.executeUpdate();
                // Verificar/testar o resultado da Exclusão
                if (excluiOK > 0) {
                    // Se incluiu OK
                    JOptionPane.showMessageDialog(null,"Excluido com Sucesso!");
                    txtIdPerfil.setText("");
                    txtDsPerfil.setText("");
                    txtSearchNome.setText("Search Nome...");
                    // conexao.close();
                    } else {
                        JOptionPane.showMessageDialog(null,"Erro na Exclusão - Verifique.");
                        txtIdPerfil.setText("");
                        txtDsPerfil.setText("");
                }
            }          
        } catch (Exception erro) {
            System.out.println(erro);
            JOptionPane.showMessageDialog(null,"Banco de Dados com ERRO!!!");
        
        }        
        
    }
    

    public TelaPerfil() {
        initComponents();
        // 3 - Executar a conexao ao banco.
        conexao = ModuloConexao.connector();
        if (conexao != null) {
            // lblDbStatus.setText("Conectado Ok!");
            lblDbStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones301/DatabaseON-icon.png")));
        }else {
            // lblDbStatus.setText("NÃO Conectado.");
            lblDbStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones301/DatabaseOFF-icon.png")));
        }        
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
        lblIdPerfil = new javax.swing.JLabel();
        lblDsPerfil = new javax.swing.JLabel();
        txtIdPerfil = new javax.swing.JTextField();
        txtDsPerfil = new javax.swing.JTextField();
        btnIncluir = new javax.swing.JButton();
        btnExluir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        lblDbStatus = new javax.swing.JLabel();
        txtSearchNome = new javax.swing.JTextField();
        btnConsultarUltimo = new javax.swing.JButton();
        btnConsultarPrimeiro = new javax.swing.JButton();
        btnConsultarAnterior = new javax.swing.JButton();
        btnConsultarProximo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPerfis = new javax.swing.JTable();

        setIconifiable(true);
        setMaximizable(true);
        setTitle("Cadastro de Perfis");

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        lblIdPerfil.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblIdPerfil.setText("Cadastro do Perfil:");

        lblDsPerfil.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblDsPerfil.setText("Descrição do Perfil:");

        txtIdPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdPerfilActionPerformed(evt);
            }
        });

        btnIncluir.setBackground(new java.awt.Color(255, 204, 51));
        btnIncluir.setText("Incluir");
        btnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirActionPerformed(evt);
            }
        });

        btnExluir.setText("Excluir");
        btnExluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExluirActionPerformed(evt);
            }
        });

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones301/Search2-icon.png"))); // NOI18N
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        txtSearchNome.setText("Search Nome...");
        txtSearchNome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearchNomeFocusGained(evt);
            }
        });
        txtSearchNome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSearchNomeMouseClicked(evt);
            }
        });
        txtSearchNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchNomeActionPerformed(evt);
            }
        });
        txtSearchNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchNomeKeyReleased(evt);
            }
        });

        btnConsultarUltimo.setText(">>");
        btnConsultarUltimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarUltimoActionPerformed(evt);
            }
        });

        btnConsultarPrimeiro.setText("<<");
        btnConsultarPrimeiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarPrimeiroActionPerformed(evt);
            }
        });

        btnConsultarAnterior.setText("<");
        btnConsultarAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarAnteriorActionPerformed(evt);
            }
        });

        btnConsultarProximo.setText(">");
        btnConsultarProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarProximoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Consulta por Nome:");

        tblPerfis.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblPerfis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        tblPerfis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPerfisMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPerfis);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblDbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnFechar)
                                    .addComponent(btnLimpar))
                                .addGap(60, 60, 60)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnConsultarAnterior)
                                    .addComponent(btnConsultarPrimeiro)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblIdPerfil)
                                        .addComponent(lblDsPerfil))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtIdPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtDsPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(13, 13, 13))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnConsultarProximo)
                                        .addComponent(btnConsultarUltimo))
                                    .addGap(30, 30, 30)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnIncluir)
                                .addGap(18, 18, 18)
                                .addComponent(btnExluir)
                                .addGap(18, 18, 18)
                                .addComponent(btnAlterar)
                                .addGap(18, 18, 18)
                                .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtSearchNome, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtSearchNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdPerfil)
                    .addComponent(txtIdPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDsPerfil)
                    .addComponent(txtDsPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIncluir)
                    .addComponent(btnExluir)
                    .addComponent(btnAlterar)
                    .addComponent(btnConsultar))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(lblDbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(btnLimpar)
                        .addGap(18, 18, 18)
                        .addComponent(btnFechar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnConsultarAnterior)
                            .addComponent(btnConsultarProximo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnConsultarPrimeiro)
                            .addComponent(btnConsultarUltimo))))
                .addGap(52, 52, 52))
        );

        setBounds(0, 0, 435, 460);
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        // TODO add your handling code here:
        consultar();
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        // TODO add your handling code here:
        txtIdPerfil.setText("");
        txtDsPerfil.setText("");
        txtSearchNome.setText("Search Nome...");
    }//GEN-LAST:event_btnLimparActionPerformed

    private void txtIdPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdPerfilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdPerfilActionPerformed

    private void btnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirActionPerformed
        // TODO add your handling code here:
        btnIncluir.setBackground(Color.blue);
        incluir();
    }//GEN-LAST:event_btnIncluirActionPerformed

    private void btnExluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExluirActionPerformed
        // TODO add your handling code here:
        excluir();
    }//GEN-LAST:event_btnExluirActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        // TODO add your handling code here:
        alterar();
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnConsultarUltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarUltimoActionPerformed
        // TODO add your handling code here:
        consultarUltimo();
    }//GEN-LAST:event_btnConsultarUltimoActionPerformed

    private void btnConsultarPrimeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarPrimeiroActionPerformed
        // TODO add your handling code here:
        consultarPrimeiro();
    }//GEN-LAST:event_btnConsultarPrimeiroActionPerformed

    private void btnConsultarAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarAnteriorActionPerformed
        // TODO add your handling code here:
        consultarAnterior();
    }//GEN-LAST:event_btnConsultarAnteriorActionPerformed

    private void btnConsultarProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarProximoActionPerformed
        // TODO add your handling code here:
        consultarProximo();
    }//GEN-LAST:event_btnConsultarProximoActionPerformed

    private void txtSearchNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchNomeActionPerformed

    private void txtSearchNomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchNomeMouseClicked
        // TODO add your handling code here:
        txtSearchNome.setText("");
    }//GEN-LAST:event_txtSearchNomeMouseClicked

    private void txtSearchNomeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchNomeFocusGained
        // TODO add your handling code here:
        txtSearchNome.setText("");
    }//GEN-LAST:event_txtSearchNomeFocusGained

    private void txtSearchNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchNomeKeyReleased
        // TODO add your handling code here:
        consultarNome();
    }//GEN-LAST:event_txtSearchNomeKeyReleased

    private void tblPerfisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPerfisMouseClicked
        // TODO add your handling code here:
        setarCamposSelecionados();
    }//GEN-LAST:event_tblPerfisMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnConsultarAnterior;
    private javax.swing.JButton btnConsultarPrimeiro;
    private javax.swing.JButton btnConsultarProximo;
    private javax.swing.JButton btnConsultarUltimo;
    private javax.swing.JButton btnExluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnIncluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDbStatus;
    private javax.swing.JLabel lblDsPerfil;
    private javax.swing.JLabel lblIdPerfil;
    private javax.swing.JTable tblPerfis;
    private javax.swing.JTextField txtDsPerfil;
    private javax.swing.JTextField txtIdPerfil;
    private javax.swing.JTextField txtSearchNome;
    // End of variables declaration//GEN-END:variables
}
