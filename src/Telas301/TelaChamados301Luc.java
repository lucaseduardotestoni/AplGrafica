package Telas301;
// 1 - Importar Bibliotecas e Modulos.

import java.sql.*;
import Acesso301DAO.ModuloConexao;
import java.awt.Color;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TelaChamados301Luc extends javax.swing.JFrame {

// 2 - Criar/Definir as variáveis especias/conexao.
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

        public void consultarNome() {
            String txtSearch = txtsearch301Luc.getText();
            // 1 Criar a String com o comando SQL.
            String sql = "select iduser,nmuser from tbusuario where nmuser like '%" + txtSearch + "%' order by iduser ;";
            try {
                if (txtsearch301Luc.getText() != "") {
                    // Finalizar a preparação do comando na conexao do banco.
                    pst = conexao.prepareStatement(sql);
                    // Executar o comando/Consulta.
                    rs = pst.executeQuery();
                    // Verificar/testar o resultado da Consulta
                    if (rs.next()) {

                        ResultSet resultado = pst.executeQuery(sql);

                        DefaultTableModel model = (DefaultTableModel) tblUser301Luc.getModel();
                        model.setNumRows(0);

                        while (resultado.next()) {
                            model.addRow(new Object[]{
                                //retorna os dados da tabela do BD, cada campo e um coluna.
                                resultado.getString("iduser"),
                                resultado.getString("nmuser"),});
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Cadastro inexistente - Verifique.");
                        txtsearch301Luc.setText("");
                        DefaultTableModel model = (DefaultTableModel) tblUser301Luc.getModel();
                        model.setNumRows(0);
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Banco de Dados com ERRO!!!");
                System.out.println(e);
            }

        }

        public void limpar() {
            textTipo301Luc.setText("");
            textCodChamado301Luc.setText("");
            textCusto301Luc.setText("");
            dtInicioTipo301Luc.setDate(null);
            dtfimTipo301Luc.setDate(null);
            txtCodLicContratada301Luc.setText("");
            Desc301Luc.setText("");
            textCodChamado301Luc.setText("");
            textprio301Luc1.setText("");
            textNomeUser301Luc.setText("");
            textCodUser301Luc.setText("");
            txtsearch301Luc.setText("");
            lstPrioridade301Luc.clearSelection();
            lstTipoChamado301Luc.clearSelection();
            DefaultTableModel model = (DefaultTableModel) tblUser301Luc.getModel();
            model.setNumRows(0);
        }

        public void setarCamposSelecionadoPri() {

            String valorListaClickada = lstPrioridade301Luc.getSelectedValue().toString();
            if (valorListaClickada == "Alta") {
                textprio301Luc1.setText("1");
            } else if (valorListaClickada == "Média") {
                textprio301Luc1.setText("2");
            } else if (valorListaClickada == "Baixa") {
                textprio301Luc1.setText("3");
            }
        }

        public void setarCamposSelecionadoTipo() {

            String valorListaClickada2 = lstTipoChamado301Luc.getSelectedValue().toString();
            if (valorListaClickada2 == "Dúvida") {
                textTipo301Luc.setText("1");
            } else if (valorListaClickada2 == "Bugs") {
                textTipo301Luc.setText("2");
            }

        }

        public void setarCamposSelecionadosUser() {
            // a instrução abaixo,Pega a linha clickada...
            int linhaK = tblUser301Luc.getSelectedRow();
            // System.out.println("Linka K = " + linhaK);
            String CodUser = (tblUser301Luc.getModel().getValueAt(linhaK, 0).toString());
            // 1 Criar a String com o comando SQL.
            String sql = "select iduser,dslogin from tbusuario where iduser = " + CodUser;
            try {
                // Finalizar a preparação do comando na conexao do banco.
                pst = conexao.prepareStatement(sql);
                // Executar o comando/Consulta.
                rs = pst.executeQuery();
                // Verificar/testar o resultado da Consulta
                if (rs.next()) {
                    // Se existir o Cadastro...
                    textCodUser301Luc.setText(rs.getString(1));
                    textNomeUser301Luc.setText(rs.getString(2));
                    // conexao.close();
                } else {
                    JOptionPane.showMessageDialog(null, "Cadastro inexistente - Verifique.");

                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Banco de Dados com ERRO!!!");
                System.out.println(e);

            }
        }

        public void incluir() {
            // 1 Criar a String com o comando SQL.
            String sql = "insert into tbchamado "
                    + "(cdchamado,cdtipochamado, cdpriorisup, dtabrchamado, "
                    + "dtflzchamado, dschamado, nmuserrespo, vlchamado, tbusuario_iduser,"
                    + " tblicencont_cdliccont) values (?,?,?,?,?,?,?,?,?,?);";
            try {
                SimpleDateFormat BDformat = new SimpleDateFormat("yyyy-MM-dd");

                java.util.Date dataclickada = dtInicioTipo301Luc.getDate();
                String dtInicioChamado = BDformat.format(dataclickada);

                java.util.Date dataclickada2 = dtfimTipo301Luc.getDate();
                String dtFimChamado = BDformat.format(dataclickada2);
                // Verificar/testar o resultado da Consulta
                if (textTipo301Luc.getText().isEmpty() && textprio301Luc1.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Campos Prioridade e Tipo não preenchidos - Verifique!");
                } else {
                    pst = conexao.prepareStatement(sql);
                    pst.setString(1, null);
                    pst.setString(2, textTipo301Luc.getText());
                    pst.setString(3, textprio301Luc1.getText());
                    pst.setString(4, dtInicioChamado);
                    pst.setString(5, dtFimChamado);
                    pst.setString(6, Desc301Luc.getText());
                    pst.setString(7, textNomeUser301Luc.getText());
                    pst.setString(8, textCusto301Luc.getText());
                    pst.setString(9, textCodUser301Luc.getText());
                    pst.setString(10, txtCodLicContratada301Luc.getText());
                    int incluiOK = pst.executeUpdate();
                    if (incluiOK > 0) {
                        // Se incluiu OK
                        JOptionPane.showMessageDialog(null, "Incluído com Sucesso!");
                        limpar();
                        // conexao.close();
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro na inclusão - Verifique.");
                        limpar();
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Banco de Dados com ERRO!!!");
                System.out.println(e);

            }

        }

        public void alterar() {
            // 1 Criar a String com o comando SQL.

            String sql = "update tbchamado set cdtipochamado=?,cdpriorisup=?,"
                    + "dtabrchamado=?,dtflzchamado=?,nmuserrespo=?,dschamado=?,"
                    + "vlchamado=?,tbusuario_iduser=?,tblicencont_cdliccont=? where cdchamado=?";
            try {
                if (textCodChamado301Luc.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Campo não preenchido - Verifique!");
                    limpar();
                } else {
                    SimpleDateFormat BDformat = new SimpleDateFormat("yyyy-MM-dd");

                    java.util.Date dataclickada = dtfimTipo301Luc.getDate();
                    String dtFimChamado = BDformat.format(dataclickada);

                    java.util.Date dataclickada2 = dtInicioTipo301Luc.getDate();
                    String dtInicioChamado = BDformat.format(dataclickada2);

                    pst = conexao.prepareStatement(sql);
                    pst.setString(1, textTipo301Luc.getText());
                    pst.setString(2, textprio301Luc1.getText());
                    pst.setString(3, dtInicioChamado);
                    pst.setString(4, dtFimChamado);
                    pst.setString(5, textNomeUser301Luc.getText());
                    pst.setString(6, Desc301Luc.getText());
                    pst.setString(7, textCusto301Luc.getText());
                    pst.setString(8, textCodUser301Luc.getText());
                    pst.setString(9, txtCodLicContratada301Luc.getText());
                    pst.setString(10, textCodChamado301Luc.getText());
                    // Executar o comando a inserção no Banco.
                    int alteraOK = pst.executeUpdate();
                    // Verificar/testar o resultado da Consulta
                    if (alteraOK > 0) {
                        // Se incluiu OK
                        JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");
                        limpar();
                        // conexao.close();
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro na inclusão - Verifique.");
                        limpar();
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Banco de Dados com ERRO!!!");
                System.out.println(e);
            }

        }

        public void consultar() {
            lstPrioridade301Luc.clearSelection();
            lstTipoChamado301Luc.clearSelection();
            // 1 Criar a String com o comando SQL.
            String sql = "select * from tbchamado where cdchamado=?;";
            try {
                // Finalizar a preparação do comando na conexao do banco.
                pst = conexao.prepareStatement(sql);
                pst.setString(1, textCodChamado301Luc.getText());
                // Executar o comando/Consulta.
                rs = pst.executeQuery();
                // Verificar/testar o resultado da Consulta
                if (rs.next()) {
                    // Se existir o Cadastro...
                    textCodChamado301Luc.setText(rs.getString(1));
                    textTipo301Luc.setText(rs.getString(2));
                    textprio301Luc1.setText(rs.getString(3));
                    dtInicioTipo301Luc.setDate(rs.getDate(4));
                    dtfimTipo301Luc.setDate(rs.getDate(5));
                    textNomeUser301Luc.setText(rs.getString(6));
                    Desc301Luc.setText(rs.getString(7));
                    textCusto301Luc.setText(rs.getString(8));
                    textCodUser301Luc.setText(rs.getString(9));
                    txtCodLicContratada301Luc.setText(rs.getString(10));

                    int tipo = Integer.parseInt(textTipo301Luc.getText());
                    if (tipo == 1) {
                        lstTipoChamado301Luc.addSelectionInterval(0, 0);
                    } else if (tipo == 2) {
                        lstTipoChamado301Luc.addSelectionInterval(1, 1);
                    }
                    //-------------------------------------------
                    int prio = Integer.parseInt(textprio301Luc1.getText());
                    if (prio == 1) {
                        lstPrioridade301Luc.addSelectionInterval(0, 0);
                    } else if (prio == 2) {
                        lstPrioridade301Luc.addSelectionInterval(1, 1);
                    } else if (prio == 3) {
                        lstPrioridade301Luc.addSelectionInterval(2, 2);
                    }

                    // conexao.close();
                } else {
                    JOptionPane.showMessageDialog(null, "Cadastro inexistente - Verifique.");
                    limpar();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Banco de Dados com ERRO!!!");
                System.out.println(e);

            }
        }

        public void excluir() {
            // 1 Criar a String com o comando SQL.
            //
            String sql = "delete from tbchamado where (cdchamado =?);";
            try {
                // Finalizar a preparação do comando na conexao do banco.
                pst = conexao.prepareStatement(sql);
                pst.setString(1, textCodChamado301Luc.getText());

                if (textCodChamado301Luc.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Campo não preenchido - Verifique!");
                } else {
                    // Executar o comando delete no Banco.
                    int deleteOK = pst.executeUpdate();
                    // Verificar/testar o resultado da exclusão
                    if (deleteOK > 0) {
                        // Se incluiu OK
                        JOptionPane.showMessageDialog(null, "Excluído com Sucesso!");
                        limpar();
                        // conexao.close();
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro na Exclusão - Verifique.");
                        limpar();
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Banco de Dados com ERRO!!!");
                System.out.println(e);
            }

        }

        public TelaChamados301Luc() {
            initComponents();
            btnSair301Luc.setBackground(Color.ORANGE);
            // 3 - Executar a conexao ao banco.
            conexao = ModuloConexao.connector();
            if (conexao != null) {
                lblDbStatus.setText("");
                lblDbStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones301/DatabaseON-icon.png")));
            } else {
                lblDbStatus.setText("");
                lblDbStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones301/DatabaseOFF-icon.png")));
            }
        }

        /**
         * This method is called from within the constructor to initialize the
         * form. WARNING: Do NOT modify this code. The content of this method is
         * always regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textTipo301Luc = new javax.swing.JTextField();
        pnlBotoes1 = new javax.swing.JPanel();
        btnSair301Luc = new javax.swing.JButton();
        btnConsultar301Luc = new javax.swing.JButton();
        btnexcluir301Luc = new javax.swing.JButton();
        btnLimpar301Luc = new javax.swing.JButton();
        btnIncluir301Luc = new javax.swing.JButton();
        BtnEditar301Luc = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Desc301Luc = new javax.swing.JTextArea();
        lblDbStatus = new javax.swing.JLabel();
        textCodChamado301Luc = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblUser301Luc = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        txtsearch301Luc = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        textCusto301Luc = new javax.swing.JTextField();
        txtCodLicContratada301Luc = new javax.swing.JTextField();
        dtfimTipo301Luc = new org.jdesktop.swingx.JXDatePicker();
        dtInicioTipo301Luc = new org.jdesktop.swingx.JXDatePicker();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstTipoChamado301Luc = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        lstPrioridade301Luc = new javax.swing.JList<>();
        textprio301Luc1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        textNomeUser301Luc = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        textCodUser301Luc = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Chamados");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlBotoes1.setBackground(new java.awt.Color(153, 153, 153));
        pnlBotoes1.setForeground(new java.awt.Color(153, 153, 153));
        pnlBotoes1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSair301Luc.setText("Sair");
        btnSair301Luc.setBorder(null);
        btnSair301Luc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSair301LucActionPerformed(evt);
            }
        });
        pnlBotoes1.add(btnSair301Luc, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, 60, 29));

        btnConsultar301Luc.setText("Consultar");
        btnConsultar301Luc.setBorder(null);
        btnConsultar301Luc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultar301LucActionPerformed(evt);
            }
        });
        pnlBotoes1.add(btnConsultar301Luc, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 130, 29));

        btnexcluir301Luc.setText("Excluir");
        btnexcluir301Luc.setBorder(null);
        btnexcluir301Luc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexcluir301LucActionPerformed(evt);
            }
        });
        pnlBotoes1.add(btnexcluir301Luc, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 60, 29));

        btnLimpar301Luc.setText("Limpar");
        btnLimpar301Luc.setBorder(null);
        btnLimpar301Luc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpar301LucActionPerformed(evt);
            }
        });
        pnlBotoes1.add(btnLimpar301Luc, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 60, 29));

        btnIncluir301Luc.setText("Incluir");
        btnIncluir301Luc.setBorder(null);
        btnIncluir301Luc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluir301LucActionPerformed(evt);
            }
        });
        pnlBotoes1.add(btnIncluir301Luc, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 60, 29));

        BtnEditar301Luc.setText("Editar");
        BtnEditar301Luc.setBorder(null);
        BtnEditar301Luc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEditar301LucActionPerformed(evt);
            }
        });
        pnlBotoes1.add(BtnEditar301Luc, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 60, 29));

        getContentPane().add(pnlBotoes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código do Chamado:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Tipo do Chamado:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 160, -1, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Data Abertura:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, -1, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Data Fechamento:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, -1, 20));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Nome User Responsável:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, 20));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Cod. Licenca Contratada:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, 20));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Descrição:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 360, -1, -1));

        Desc301Luc.setColumns(20);
        Desc301Luc.setRows(5);
        jScrollPane1.setViewportView(Desc301Luc);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 380, 380, -1));

        lblDbStatus.setText("StatusDb");
        getContentPane().add(lblDbStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));
        getContentPane().add(textCodChamado301Luc, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 40, -1));

        tblUser301Luc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblUser301Luc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUser301LucMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblUser301Luc);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 300, 90));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Usuário:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, 50, 20));

        txtsearch301Luc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsearch301LucActionPerformed(evt);
            }
        });
        txtsearch301Luc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtsearch301LucKeyPressed(evt);
            }
        });
        getContentPane().add(txtsearch301Luc, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, 190, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Custo Chamado:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, -1, 20));
        getContentPane().add(textCusto301Luc, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 70, -1));

        txtCodLicContratada301Luc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCodLicContratada301LucFocusGained(evt);
            }
        });
        txtCodLicContratada301Luc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtCodLicContratada301LucMouseEntered(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtCodLicContratada301LucMouseReleased(evt);
            }
        });
        txtCodLicContratada301Luc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodLicContratada301LucActionPerformed(evt);
            }
        });
        txtCodLicContratada301Luc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodLicContratada301LucKeyReleased(evt);
            }
        });
        getContentPane().add(txtCodLicContratada301Luc, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 50, -1));

        dtfimTipo301Luc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dtfimTipo301LucActionPerformed(evt);
            }
        });
        getContentPane().add(dtfimTipo301Luc, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, -1, -1));

        dtInicioTipo301Luc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dtInicioTipo301LucActionPerformed(evt);
            }
        });
        getContentPane().add(dtInicioTipo301Luc, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, -1, -1));

        lstTipoChamado301Luc.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Dúvida", "Bugs", " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lstTipoChamado301Luc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstTipoChamado301LucMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(lstTipoChamado301Luc);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 190, 130, 70));

        lstPrioridade301Luc.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Alta", "Média", "Baixa" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lstPrioridade301Luc.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lstPrioridade301Luc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstPrioridade301LucMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(lstPrioridade301Luc);
        lstPrioridade301Luc.getAccessibleContext().setAccessibleParent(lstPrioridade301Luc);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 190, 130, 70));
        getContentPane().add(textprio301Luc1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 210, 40, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Prioridade:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 160, -1, 20));

        textNomeUser301Luc.setEditable(false);
        textNomeUser301Luc.setText("Pesquise User");
        getContentPane().add(textNomeUser301Luc, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 100, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Cod. User Responsável:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 140, 20));

        textCodUser301Luc.setEditable(false);
        getContentPane().add(textCodUser301Luc, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 40, -1));

        setSize(new java.awt.Dimension(615, 569));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSair301LucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSair301LucActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnSair301LucActionPerformed

    private void txtCodLicContratada301LucFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodLicContratada301LucFocusGained
        // TODO add your handling code here:
//      TelaSearchLicenca tlSearchLic = new TelaSearchLicenca();
//      tlSearchLic.setVisible(true);        
    }//GEN-LAST:event_txtCodLicContratada301LucFocusGained

    private void txtCodLicContratada301LucMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCodLicContratada301LucMouseEntered
        // TODO add your handling code here:
//      TelaSearchLicenca tlSearchLic = new TelaSearchLicenca();
//      tlSearchLic.setVisible(true);
    }//GEN-LAST:event_txtCodLicContratada301LucMouseEntered

    private void txtCodLicContratada301LucKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodLicContratada301LucKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodLicContratada301LucKeyReleased

    private void txtCodLicContratada301LucMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCodLicContratada301LucMouseReleased
        // TODO add your handling code here:
        TelaSearchLicenca tlSearchLic = new TelaSearchLicenca();
        tlSearchLic.setVisible(true);
    }//GEN-LAST:event_txtCodLicContratada301LucMouseReleased

    private void txtsearch301LucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsearch301LucActionPerformed

    }//GEN-LAST:event_txtsearch301LucActionPerformed

    private void txtsearch301LucKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearch301LucKeyPressed
        consultarNome();
    }//GEN-LAST:event_txtsearch301LucKeyPressed

    private void dtfimTipo301LucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dtfimTipo301LucActionPerformed

    }//GEN-LAST:event_dtfimTipo301LucActionPerformed

    private void dtInicioTipo301LucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dtInicioTipo301LucActionPerformed

    }//GEN-LAST:event_dtInicioTipo301LucActionPerformed

    private void lstTipoChamado301LucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstTipoChamado301LucMouseClicked
        setarCamposSelecionadoTipo();
    }//GEN-LAST:event_lstTipoChamado301LucMouseClicked

    private void lstPrioridade301LucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstPrioridade301LucMouseClicked
        setarCamposSelecionadoPri();
    }//GEN-LAST:event_lstPrioridade301LucMouseClicked

    private void tblUser301LucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUser301LucMouseClicked
        setarCamposSelecionadosUser();
    }//GEN-LAST:event_tblUser301LucMouseClicked

    private void btnLimpar301LucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpar301LucActionPerformed
        limpar();
    }//GEN-LAST:event_btnLimpar301LucActionPerformed

    private void btnIncluir301LucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluir301LucActionPerformed
        incluir();
    }//GEN-LAST:event_btnIncluir301LucActionPerformed

    private void btnConsultar301LucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultar301LucActionPerformed
        consultar();
    }//GEN-LAST:event_btnConsultar301LucActionPerformed

    private void BtnEditar301LucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditar301LucActionPerformed
        alterar();
    }//GEN-LAST:event_BtnEditar301LucActionPerformed

    private void txtCodLicContratada301LucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodLicContratada301LucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodLicContratada301LucActionPerformed

    private void btnexcluir301LucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexcluir301LucActionPerformed
        excluir();
    }//GEN-LAST:event_btnexcluir301LucActionPerformed

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
                java.util.logging.Logger.getLogger(TelaChamados301Luc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(TelaChamados301Luc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(TelaChamados301Luc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(TelaChamados301Luc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            //</editor-fold>
            //</editor-fold>

            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new TelaChamados301Luc().setVisible(true);
                }
            });
        }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEditar301Luc;
    private javax.swing.JTextArea Desc301Luc;
    private javax.swing.JButton btnConsultar301Luc;
    private javax.swing.JButton btnIncluir301Luc;
    private javax.swing.JButton btnLimpar301Luc;
    private javax.swing.JButton btnSair301Luc;
    private javax.swing.JButton btnexcluir301Luc;
    private org.jdesktop.swingx.JXDatePicker dtInicioTipo301Luc;
    private org.jdesktop.swingx.JXDatePicker dtfimTipo301Luc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblDbStatus;
    private javax.swing.JList<String> lstPrioridade301Luc;
    private javax.swing.JList<String> lstTipoChamado301Luc;
    private javax.swing.JPanel pnlBotoes1;
    private javax.swing.JTable tblUser301Luc;
    private javax.swing.JTextField textCodChamado301Luc;
    private javax.swing.JTextField textCodUser301Luc;
    private javax.swing.JTextField textCusto301Luc;
    private javax.swing.JTextField textNomeUser301Luc;
    private javax.swing.JTextField textTipo301Luc;
    private javax.swing.JTextField textprio301Luc1;
    private javax.swing.JTextField txtCodLicContratada301Luc;
    private javax.swing.JTextField txtsearch301Luc;
    // End of variables declaration//GEN-END:variables
}
