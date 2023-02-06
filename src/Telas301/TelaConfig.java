package Telas301;

import Acesso301DAO.ModuloConexao;
import java.awt.Color;
import javax.swing.JOptionPane;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Alunos
 */
public class TelaConfig extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    private void setarCampoListaLicenca() {
        String valorListaClickada = lstLicencas.getSelectedValue().toString();
        if (valorListaClickada == "1 - Perpétua") {
            txtTipoLic.setText("1");
        } else if (valorListaClickada == "2 - Anual") {
            txtTipoLic.setText("2");
        } else if (valorListaClickada == "3 - Temporária") {
            txtTipoLic.setText("3");
        }
    }

    private void setarCampoListaSuporte() {
        String valorListaClickada = lstSuporte.getSelectedValue().toString();
        if (valorListaClickada == "1 - 24hrs") {
            txtTipoSup.setText("1");
        } else if (valorListaClickada == "2 - Chamado") {
            txtTipoSup.setText("2");
        } else if (valorListaClickada == "3 - Prioritário") {
            txtTipoSup.setText("3");
        }
    }

    public void incluir() {
        // 1 Criar a String com o comando SQL.
        String sql = "insert into tblicencont (cdliccont,cdtipolic,vlvalorlic,cdtiposup,dtiniciovig,dtfimvig,vltotalcont,dsnomeresp,dscontrato) values (?,?,?,?,?,?,?,?,?);";
        try {
            Date dataclickada = jxDpInicioVigencia.getDate();
            SimpleDateFormat BDformat = new SimpleDateFormat("yyyy-MM-dd");
            String txtDtInicioCon = BDformat.format(dataclickada);
            Date dataclickada2 = jxDpFimVigencia.getDate();
            String txtDtFimCOn = BDformat.format(dataclickada2);
            // Finalizar a preparação do comando na conexao do banco.
            pst = conexao.prepareStatement(sql);
            pst.setString(1, null);
            pst.setString(2, txtTipoLic.getText());
            pst.setString(3, txtValorLic.getText());
            pst.setString(4, txtTipoSup.getText());
            pst.setString(5, txtDtInicioCon);
            pst.setString(6, txtDtFimCOn);
            pst.setString(7, txtValorCon.getText());
            pst.setString(8, txtResponsavel.getText());
            pst.setString(9, txtDescCon.getText());
            // Executar o comando a inserção no Banco.
            int incluiOK = pst.executeUpdate();
            // Verificar/testar o resultado da Consulta
            if (incluiOK > 0) {
                // Se incluiu OK
                JOptionPane.showMessageDialog(null, "Incluído com Sucesso!");
                txtIDLic.setText("");
                txtTipoLic.setText("");
                txtValorLic.setText("");
                txtTipoSup.setText("");
                jxDpInicioVigencia.setDate(null);
                jxDpFimVigencia.setDate(null);
                txtValorCon.setText("");
                txtResponsavel.setText("");
                txtDescCon.setText("");
                // conexao.close();
            } else {
                JOptionPane.showMessageDialog(null, "Erro na inclusão - Verifique.");
                txtIDLic.setText("");
                txtTipoLic.setText("");
                txtValorLic.setText("");
                txtTipoSup.setText("");
                jxDpInicioVigencia.setDate(null);
                jxDpFimVigencia.setDate(null);
                txtValorCon.setText("");
                txtResponsavel.setText("");
                txtDescCon.setText("");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Banco de Dados com ERRO!!!");
            System.out.println(e);

        }

    }

    public void alterar() {
        // 1 Criar a String com o comando SQL.

        String sql = "update tblicencont set cdtipolic =?,vlvalorlic=?,cdtiposup=?,dtiniciovig=?,dtfimvig=?,vltotalcont=?,dsnomeresp=?,dscontrato=? where (cdliccont =?);";
        //);
        try {
            Date dataclickada = jxDpInicioVigencia.getDate();
            SimpleDateFormat BDformat = new SimpleDateFormat("yyyy-MM-dd");
            String txtDtInicioCon = BDformat.format(dataclickada);
            Date dataclickada2 = jxDpFimVigencia.getDate();
            String txtDtFimCOn = BDformat.format(dataclickada2);
            // Finalizar a preparação do comando na conexao do banco.
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtTipoLic.getText());
            pst.setString(2, txtValorLic.getText());
            pst.setString(3, txtTipoSup.getText());
            pst.setString(4, txtDtInicioCon);
            pst.setString(5, txtDtFimCOn);
            pst.setString(6, txtValorCon.getText());
            pst.setString(7, txtResponsavel.getText());
            pst.setString(8, txtDescCon.getText());
            pst.setString(9, txtIDLic.getText());
            if (txtIDLic.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Campo não preenchido - Verifique!");
            } else {
                // Executar o comando a inserção no Banco.
                int alteraOK = pst.executeUpdate();
                // Verificar/testar o resultado da Consulta
                if (alteraOK > 0) {
                    // Se incluiu OK
                    JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");
                    txtIDLic.setText("");
                    txtTipoLic.setText("");
                    txtValorLic.setText("");
                    txtTipoSup.setText("");
                    jxDpInicioVigencia.setDate(null);
                    jxDpFimVigencia.setDate(null);
                    txtValorCon.setText("");
                    txtResponsavel.setText("");
                    txtDescCon.setText("");
                    // conexao.close();
                } else {
                    JOptionPane.showMessageDialog(null, "Erro na inclusão - Verifique.");
                    txtIDLic.setText("");
                    txtTipoLic.setText("");
                    txtValorLic.setText("");
                    txtTipoSup.setText("");
                    jxDpInicioVigencia.setDate(null);
                    jxDpFimVigencia.setDate(null);
                    txtValorCon.setText("");
                    txtResponsavel.setText("");
                    txtDescCon.setText("");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Banco de Dados com ERRO!!!");
            System.out.println(e);
        }

    }

    public void excluir() {
        // 1 Criar a String com o comando SQL.
        //
        String sql = "delete from tblicencont where (cdliccont =?);";
        try {
            // Finalizar a preparação do comando na conexao do banco.
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtIDLic.getText());
            if (txtIDLic.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Campo não preenchido - Verifique!");
            } else {
                // Executar o comando delete no Banco.
                int deleteOK = pst.executeUpdate();
                // Verificar/testar o resultado da exclusão
                if (deleteOK > 0) {
                    // Se incluiu OK
                    JOptionPane.showMessageDialog(null, "Excluído com Sucesso!");
                    txtIDLic.setText("");
                    txtTipoLic.setText("");
                    txtValorLic.setText("");
                    txtTipoSup.setText("");
                    jxDpInicioVigencia.setDate(null);
                    jxDpFimVigencia.setDate(null);
                    txtValorCon.setText("");
                    txtResponsavel.setText("");
                    txtDescCon.setText("");
                    // conexao.close();
                } else {
                    JOptionPane.showMessageDialog(null, "Erro na Exclusão - Verifique.");
                    txtIDLic.setText("");
                    txtTipoLic.setText("");
                    txtValorLic.setText("");
                    txtTipoSup.setText("");
                    jxDpInicioVigencia.setDate(null);
                    jxDpFimVigencia.setDate(null);
                    txtValorCon.setText("");
                    txtResponsavel.setText("");
                    txtDescCon.setText("");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Banco de Dados com ERRO!!!");
            System.out.println(e);
        }

    }

    public void consultar() {
        // 1 Criar a String com o comando SQL.
        //String sql = "select * from tbperfil where idcadperfil = ?";
        String sql = "select * from tblicencont where cdliccont=?;;";
        try {
            // Finalizar a preparação do comando na conexao do banco.
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtIDLic.getText());
            // Executar o comando/Consulta.
            rs = pst.executeQuery();
            // Verificar/testar o resultado da Consulta
            if (rs.next()) {
                // Se existir o Cadastro...
                txtIDLic.setText(rs.getString(1));
                txtTipoLic.setText(rs.getString(2));
                txtValorLic.setText(rs.getString(3));
                txtTipoSup.setText(rs.getString(4));
                jxDpInicioVigencia.setDate(rs.getDate(5));
                jxDpFimVigencia.setDate(rs.getDate(6));
                txtValorCon.setText(rs.getString(7));
                txtResponsavel.setText(rs.getString(8));
                txtDescCon.setText(rs.getString(9));

                // conexao.close();
            } else {
                JOptionPane.showMessageDialog(null, "Cadastro inexistente - Verifique.");
                txtIDLic.setText("");
                txtTipoLic.setText("");
                txtValorLic.setText("");
                txtTipoSup.setText("");
                jxDpInicioVigencia.setDate(null);
                jxDpFimVigencia.setDate(null);
                txtValorCon.setText("");
                txtResponsavel.setText("");
                txtDescCon.setText("");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Banco de Dados com ERRO!!!");
            System.out.println(e);

        }
    }

    /**
     * Creates new form TelaConfig
     */
    public TelaConfig() {
        initComponents();

        conexao = ModuloConexao.connector();
        if (conexao != null) {
            lblDbStatus.setText("Conectado Ok!");

            lblDbStatus.setForeground(Color.BLUE);
        } else {
            lblDbStatus.setText("NÃO Conectado.");
            lblDbStatus.setForeground(Color.red);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        lstLicencas = new javax.swing.JList<>();
        lblTipoLic = new javax.swing.JLabel();
        txtTipoLic = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtValorLic = new javax.swing.JTextField();
        txtTipoSup = new javax.swing.JTextField();
        txtValorCon = new javax.swing.JTextField();
        txtResponsavel = new javax.swing.JTextField();
        txtDescCon = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstSuporte = new javax.swing.JList<>();
        btnAlterar = new javax.swing.JButton();
        btnIncluir = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        txtIDLic = new javax.swing.JTextField();
        lblTipoLic1 = new javax.swing.JLabel();
        lblDbStatus = new javax.swing.JLabel();
        jxDpFimVigencia = new org.jdesktop.swingx.JXDatePicker();
        jxDpInicioVigencia = new org.jdesktop.swingx.JXDatePicker();

        setIconifiable(true);
        setMaximizable(true);
        setTitle("Contratos & Manutenção");

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        lstLicencas.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "1 - Perpétua", "2 - Anual", "3 - Temporária" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lstLicencas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstLicencasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lstLicencas);

        lblTipoLic.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTipoLic.setText("Tipo de Licença:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Valor da Licença:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Tipo de Suporte:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Vigência (Data Início do Contrado):");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Vigência (Data Fim do Contrado):");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Valor do Contrato:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Depto/Pessoa responsável:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Descrição do Contrato:");

        txtResponsavel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtResponsavelActionPerformed(evt);
            }
        });

        lstSuporte.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "1 - 24hrs", "2 - Chamado", "3 - Prioritário" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lstSuporte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstSuporteMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(lstSuporte);

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnIncluir.setText("Incluir");
        btnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        lblTipoLic1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTipoLic1.setText("Código da Licença:");

        lblDbStatus.setText("DbStatus");

        jxDpFimVigencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jxDpFimVigenciaActionPerformed(evt);
            }
        });

        jxDpInicioVigencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jxDpInicioVigenciaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtValorLic, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(lblTipoLic1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIDLic, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(lblDbStatus)
                                .addGap(102, 102, 102)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTipoLic)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(txtTipoLic, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(txtTipoSup, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtValorCon, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtDescCon, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jxDpInicioVigencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jxDpFimVigencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAlterar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnIncluir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnExcluir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnConsultar)))
                        .addGap(0, 103, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipoLic)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(lblDbStatus))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTipoLic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTipoSup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(txtValorLic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(lblTipoLic1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtIDLic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jxDpInicioVigencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jxDpFimVigencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtValorCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtDescCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFechar)
                    .addComponent(btnAlterar)
                    .addComponent(btnIncluir)
                    .addComponent(btnExcluir)
                    .addComponent(btnConsultar))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        setBounds(0, 0, 520, 421);
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void lstLicencasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstLicencasMouseClicked
        setarCampoListaLicenca();
    }//GEN-LAST:event_lstLicencasMouseClicked

    private void lstSuporteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstSuporteMouseClicked
        // TODO add your handling code here:
        setarCampoListaSuporte();
    }//GEN-LAST:event_lstSuporteMouseClicked

    private void txtResponsavelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtResponsavelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtResponsavelActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        alterar();
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirActionPerformed
        incluir();
    }//GEN-LAST:event_btnIncluirActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        excluir();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        consultar();
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void jxDpInicioVigenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jxDpInicioVigenciaActionPerformed
        Date dataclickada = jxDpInicioVigencia.getDate();
        SimpleDateFormat BDformat = new SimpleDateFormat("yyyy-MM-dd");
        String txtDtInicioCon = BDformat.format(dataclickada);
    }//GEN-LAST:event_jxDpInicioVigenciaActionPerformed

    private void jxDpFimVigenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jxDpFimVigenciaActionPerformed
        Date dataclickada = jxDpFimVigencia.getDate();
        SimpleDateFormat BDformat = new SimpleDateFormat("yyyy-MM-dd");
        String txtDtFimCOn = BDformat.format(dataclickada);

    }//GEN-LAST:event_jxDpFimVigenciaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnIncluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private org.jdesktop.swingx.JXDatePicker jxDpFimVigencia;
    private org.jdesktop.swingx.JXDatePicker jxDpInicioVigencia;
    private javax.swing.JLabel lblDbStatus;
    private javax.swing.JLabel lblTipoLic;
    private javax.swing.JLabel lblTipoLic1;
    private javax.swing.JList<String> lstLicencas;
    private javax.swing.JList<String> lstSuporte;
    private javax.swing.JTextField txtDescCon;
    private javax.swing.JTextField txtIDLic;
    private javax.swing.JTextField txtResponsavel;
    private javax.swing.JTextField txtTipoLic;
    private javax.swing.JTextField txtTipoSup;
    private javax.swing.JTextField txtValorCon;
    private javax.swing.JTextField txtValorLic;
    // End of variables declaration//GEN-END:variables
}
