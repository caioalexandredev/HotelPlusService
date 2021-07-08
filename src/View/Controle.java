/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Usuario;
import Model.Dao_Usuario;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DESENVOLVIMENTO
 */
public class Controle extends javax.swing.JFrame {

    Font roboto = null;
    Font robotoB = null;
    Font rodape = null;
    Font nome = null;
    Font cargo = null;
    Font desc = null;
    Usuario user;
    boolean emSelecao = false;
    
    public Controle(Usuario user) {
        initComponents();
        
        try{
        roboto = Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResourceAsStream("fonts/Roboto-Regular.ttf"));
        }
        catch(IOException|FontFormatException e){
             System.out.println("Erro: " + e);
        }
        try{
        robotoB = Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResourceAsStream("fonts/Roboto-Black.ttf"));
        }
        catch(IOException|FontFormatException e){
             System.out.println("Erro: " + e);
        }
        
        rodape = roboto.deriveFont(Font.PLAIN, 13);
        nome = roboto.deriveFont(Font.PLAIN, 18);
        cargo = roboto.deriveFont(Font.PLAIN, 14);
        desc = robotoB.deriveFont(Font.PLAIN, 18);
        
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        
        ge.registerFont(rodape);
        jLabel_Rodape1.setFont(rodape); 
        jLabel_Rodape2.setFont(rodape);
        jLabel_Nome.setFont(nome);
        jLabel_Cargo.setFont(cargo);
        jLabel_Desc.setFont(desc);
        jLabel_Titulo1.setFont(desc);
        jLabel_Titulo2.setFont(desc);
        
        this.user = user;
        
        atualizarlista();
        definirDadosEmTela();
    }
    
    private void definirDadosEmTela(){
        jLabel_Nome.setText(this.user.getNome());
        jLabel_Cargo.setText("Cargo: " + this.user.getCargo());
    }
    
    private void atualizarlista(){
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "CPF", "Celular", "Email/Usuário", "Senha", "Cargo", "Nivel"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(5);
        jTable1.getColumnModel().getColumn(7).setPreferredWidth(5);
        
        try {
            DefaultTableModel model =(DefaultTableModel) jTable1.getModel();
            model.getDataVector().clear();// limpa a tabela
            Dao_Usuario listarc = new Dao_Usuario();
            List<Usuario> lista_pessoa = listarc.buscarGeral();// aki é a pesquisa que popula meu list

            if (!lista_pessoa.isEmpty()) {// aki verifica se a list nao esta vazia
                for (Usuario c : lista_pessoa) {// aki ele percorre minha lista
                    model.addRow(new Object[]{c.getId(), c.getNome(), c.getCPF(), c.getTelefone(), c.getEmail(), c.getSenha(), c.getCargo(), c.getNivel()});// adiciona na jtbale
                }
            }else{
                model.setNumRows(1);
            }
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar tabela\n" + e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void atualizarlistaeditar(){
        this.emSelecao = true;
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "CPF", "Celular", "Email/Usuário", "Senha", "Cargo", "Nivel"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(5);
        jTable1.getColumnModel().getColumn(7).setPreferredWidth(5);
        
        try {
            DefaultTableModel model =(DefaultTableModel) jTable1.getModel();
            model.getDataVector().clear();// limpa a tabela
            Dao_Usuario listarc = new Dao_Usuario();
            List<Usuario> lista_pessoa = listarc.buscarUnicaID(Integer.parseInt(txt_ocupacao.getText()));// aki é a pesquisa que popula meu list

            if (!lista_pessoa.isEmpty()) {// aki verifica se a list nao esta vazia
                for (Usuario c : lista_pessoa) {// aki ele percorre minha lista
                    model.addRow(new Object[]{c.getId(), c.getNome(), c.getCPF(), c.getTelefone(), c.getEmail(), c.getSenha(), c.getCargo(), c.getNivel()});// adiciona na jtbale
                }
            }else{
                model.setNumRows(1);
            }
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar tabela\n" + e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
        }
        
        btn_editar.setEnabled(false);
        btn_excluir.setEnabled(false);
        btn_salvar.setEnabled(true);
        JOptionPane.showMessageDialog(null, "Registro Selecionado, altere na tabela os dados que deseja alterar!");
        
    }
    
    private void realizarAlteracoes(){
        System.out.println(txt_ocupacao.getText());
        Usuario funcionario = new Dao_Usuario().buscarUnicaID(Integer.parseInt(txt_ocupacao.getText())).get(0);
        funcionario.setNome(jTable1.getValueAt(0, 1).toString());
        funcionario.setCPF(jTable1.getValueAt(0, 2).toString());
        funcionario.setTelefone(jTable1.getValueAt(0, 3).toString());
        funcionario.setEmail(jTable1.getValueAt(0, 4).toString());
        funcionario.setSenha(jTable1.getValueAt(0, 5).toString());
        funcionario.setCargo(jTable1.getValueAt(0, 6).toString());
        funcionario.setNivel(Integer.parseInt(jTable1.getValueAt(0, 7).toString()));
        new Dao_Usuario().Atualizar(funcionario);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_Rodape2 = new javax.swing.JLabel();
        jLabel_Rodape1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btn_regproduto = new javax.swing.JLabel();
        jLabel_Titulo2 = new javax.swing.JLabel();
        jLabel_Titulo1 = new javax.swing.JLabel();
        jLabel_Cargo = new javax.swing.JLabel();
        jLabel_Nome = new javax.swing.JLabel();
        jLabel_Desc = new javax.swing.JLabel();
        btn_main = new javax.swing.JLabel();
        txt_ocupacao = new javax.swing.JTextField();
        form_funcionario = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btn_novo = new javax.swing.JLabel();
        btn_salvar = new javax.swing.JLabel();
        btn_excluir = new javax.swing.JLabel();
        btn_editar = new javax.swing.JLabel();
        btn_cancelar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hotel Plus Service - Controle Administrativo");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/assets/icon.png")).getImage());
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_Rodape2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Rodape2.setText("de Análise e Desenvolvimento de Sistemas peos Discentes Caio Alexandre de Sousa Ramos e Lucas Eduardo Sampaio Andrade.");
        getContentPane().add(jLabel_Rodape2, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 560, -1, -1));

        jLabel_Rodape1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Rodape1.setText("Este software é um protótipo desenvolvido durante uma avaliação da disciplina de Linguagem de Programação II no curso Tecnológico");
        getContentPane().add(jLabel_Rodape1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 545, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/BG_Geral.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 520, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_regproduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/btn_regprot_A.png"))); // NOI18N
        btn_regproduto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_regproduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_regprodutoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_regprodutoMouseExited(evt);
            }
        });
        jPanel1.add(btn_regproduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 420, -1, -1));

        jLabel_Titulo2.setForeground(new java.awt.Color(140, 140, 140));
        jLabel_Titulo2.setText("Funcionários e Gerencia");
        jPanel1.add(jLabel_Titulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, -1, -1));

        jLabel_Titulo1.setForeground(new java.awt.Color(140, 140, 140));
        jLabel_Titulo1.setText("Tabela Controle de");
        jPanel1.add(jLabel_Titulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, -1, -1));

        jLabel_Cargo.setBackground(new java.awt.Color(92, 92, 92));
        jLabel_Cargo.setForeground(new java.awt.Color(150, 150, 150));
        jLabel_Cargo.setText("Cargo: Cargo do Usuário");
        jPanel1.add(jLabel_Cargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        jLabel_Nome.setBackground(new java.awt.Color(92, 92, 92));
        jLabel_Nome.setForeground(new java.awt.Color(92, 92, 92));
        jLabel_Nome.setText("Nome do Usuário do Sistema");
        jPanel1.add(jLabel_Nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 75, -1, -1));

        jLabel_Desc.setForeground(new java.awt.Color(142, 45, 226));
        jLabel_Desc.setText("Você entrou como:");
        jPanel1.add(jLabel_Desc, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        btn_main.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/btn_A.png"))); // NOI18N
        btn_main.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_main.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_mainMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_mainMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_mainMousePressed(evt);
            }
        });
        jPanel1.add(btn_main, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 50, -1, -1));

        txt_ocupacao.setBackground(new java.awt.Color(255, 255, 255, 0));
        txt_ocupacao.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txt_ocupacao.setForeground(new java.awt.Color(83, 83, 83));
        txt_ocupacao.setBorder(null);
        txt_ocupacao.setEnabled(false);
        txt_ocupacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ocupacaoActionPerformed(evt);
            }
        });
        txt_ocupacao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_ocupacaoKeyPressed(evt);
            }
        });
        jPanel1.add(txt_ocupacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 362, 340, 30));

        form_funcionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/form_funcionario_A.png"))); // NOI18N
        jPanel1.add(form_funcionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "CPF", "Celular", "Email/Usuário", "Senha", "Cargo", "Nivel"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(5);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
            jTable1.getColumnModel().getColumn(6).setResizable(false);
            jTable1.getColumnModel().getColumn(7).setResizable(false);
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(5);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 750, 140));

        btn_novo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Novo.png"))); // NOI18N
        btn_novo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_novo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_novoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_novoMouseExited(evt);
            }
        });
        jPanel1.add(btn_novo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, -1, -1));

        btn_salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Salvar.png"))); // NOI18N
        btn_salvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_salvar.setEnabled(false);
        btn_salvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_salvarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_salvarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_salvarMousePressed(evt);
            }
        });
        jPanel1.add(btn_salvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 420, -1, -1));

        btn_excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Excluir.png"))); // NOI18N
        btn_excluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_excluir.setEnabled(false);
        btn_excluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_excluirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_excluirMouseExited(evt);
            }
        });
        jPanel1.add(btn_excluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 420, -1, -1));

        btn_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Editar.png"))); // NOI18N
        btn_editar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_editar.setEnabled(false);
        btn_editar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_editarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_editarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_editarMousePressed(evt);
            }
        });
        jPanel1.add(btn_editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 420, -1, -1));

        btn_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Cancelar.png"))); // NOI18N
        btn_cancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cancelar.setEnabled(false);
        btn_cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_cancelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_cancelarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_cancelarMousePressed(evt);
            }
        });
        jPanel1.add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 420, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 520));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_mainMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_mainMouseEntered
        ImageIcon ii = new ImageIcon(getClass().getResource("/assets/btn_B.png"));
        btn_main.setIcon( ii );
    }//GEN-LAST:event_btn_mainMouseEntered

    private void btn_mainMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_mainMouseExited
        ImageIcon ii = new ImageIcon(getClass().getResource("/assets/btn_A.png"));
        btn_main.setIcon( ii );
    }//GEN-LAST:event_btn_mainMouseExited

    private void txt_ocupacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ocupacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ocupacaoActionPerformed

    private void txt_ocupacaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ocupacaoKeyPressed
        ImageIcon ii = new ImageIcon(getClass().getResource("/assets/form_funcionario_B.png"));
        form_funcionario.setIcon( ii );
    }//GEN-LAST:event_txt_ocupacaoKeyPressed

    private void btn_regprodutoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_regprodutoMouseEntered
        ImageIcon ii = new ImageIcon(getClass().getResource("/assets/btn_regprot_B.png"));
        btn_regproduto.setIcon( ii );
    }//GEN-LAST:event_btn_regprodutoMouseEntered

    private void btn_regprodutoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_regprodutoMouseExited
        ImageIcon ii = new ImageIcon(getClass().getResource("/assets/btn_regprot_A.png"));
        btn_regproduto.setIcon( ii );
    }//GEN-LAST:event_btn_regprodutoMouseExited

    private void btn_novoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_novoMouseEntered
       ImageIcon ii = new ImageIcon(getClass().getResource("/assets/Novo_.png"));
        btn_novo.setIcon( ii );
    }//GEN-LAST:event_btn_novoMouseEntered

    private void btn_novoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_novoMouseExited
         ImageIcon ii = new ImageIcon(getClass().getResource("/assets/Novo.png"));
        btn_novo.setIcon( ii );
    }//GEN-LAST:event_btn_novoMouseExited

    private void btn_salvarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_salvarMouseEntered
        ImageIcon ii = new ImageIcon(getClass().getResource("/assets/Salvar_.png"));
        btn_salvar.setIcon( ii );
    }//GEN-LAST:event_btn_salvarMouseEntered

    private void btn_salvarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_salvarMouseExited
        ImageIcon ii = new ImageIcon(getClass().getResource("/assets/Salvar.png"));
        btn_salvar.setIcon( ii );
    }//GEN-LAST:event_btn_salvarMouseExited

    private void btn_excluirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_excluirMouseEntered
        ImageIcon ii = new ImageIcon(getClass().getResource("/assets/Excluir_.png"));
        btn_excluir.setIcon( ii );
    }//GEN-LAST:event_btn_excluirMouseEntered

    private void btn_excluirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_excluirMouseExited
        ImageIcon ii = new ImageIcon(getClass().getResource("/assets/Excluir.png"));
        btn_excluir.setIcon( ii );
    }//GEN-LAST:event_btn_excluirMouseExited

    private void btn_editarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editarMouseEntered
        ImageIcon ii = new ImageIcon(getClass().getResource("/assets/Editar_.png"));
        btn_editar.setIcon( ii );
    }//GEN-LAST:event_btn_editarMouseEntered

    private void btn_editarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editarMouseExited
        ImageIcon ii = new ImageIcon(getClass().getResource("/assets/Editar.png"));
        btn_editar.setIcon( ii );
    }//GEN-LAST:event_btn_editarMouseExited

    private void btn_cancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancelarMouseEntered
        ImageIcon ii = new ImageIcon(getClass().getResource("/assets/Cancelar_.png"));
        btn_cancelar.setIcon( ii );
    }//GEN-LAST:event_btn_cancelarMouseEntered

    private void btn_cancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancelarMouseExited
        ImageIcon ii = new ImageIcon(getClass().getResource("/assets/Cancelar.png"));
        btn_cancelar.setIcon( ii );
    }//GEN-LAST:event_btn_cancelarMouseExited

    private void btn_mainMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_mainMousePressed
        new TelaInicial(this.user).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_mainMousePressed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int row = jTable1.rowAtPoint(evt.getPoint());
        int col = jTable1.columnAtPoint(evt.getPoint());
        if (row >= 0 && col >= 0) {
            ImageIcon ii = new ImageIcon(getClass().getResource("/assets/form_funcionario_B.png"));
            form_funcionario.setIcon( ii );
            txt_ocupacao.setText(jTable1.getValueAt(row, 0).toString());
            btn_novo.setEnabled(false);
            btn_cancelar.setEnabled(true);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
        int row = jTable1.rowAtPoint(evt.getPoint());
        int col = jTable1.columnAtPoint(evt.getPoint());
        if (row >= 0 && col >= 0 && !this.emSelecao) {
            ImageIcon ii = new ImageIcon(getClass().getResource("/assets/form_funcionario_B.png"));
            form_funcionario.setIcon( ii );
            txt_ocupacao.setText(jTable1.getValueAt(row, 0).toString());
            btn_novo.setEnabled(false);
            btn_cancelar.setEnabled(true);
            btn_editar.setEnabled(true);
            btn_excluir.setEnabled(true);
        }
    }//GEN-LAST:event_jTable1MousePressed

    private void btn_cancelarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancelarMousePressed
        jTable1.getSelectionModel().clearSelection();
        ImageIcon ii = new ImageIcon(getClass().getResource("/assets/form_funcionario_A.png"));
        form_funcionario.setIcon( ii );
        btn_novo.setEnabled(true);
        btn_cancelar.setEnabled(false);
        txt_ocupacao.setText("");
        btn_editar.setEnabled(false);
        btn_excluir.setEnabled(false);
        this.emSelecao = false;
        btn_salvar.setEnabled(false);
        atualizarlista();
    }//GEN-LAST:event_btn_cancelarMousePressed

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        System.out.println(jTable1.getSelectionModel().getSelectedItemsCount());
        if(jTable1.getSelectionModel().getSelectedItemsCount() > 1){
            JOptionPane.showMessageDialog(null, "Selecione apenas um registro");
            jTable1.getSelectionModel().clearSelection();
            ImageIcon ii = new ImageIcon(getClass().getResource("/assets/form_funcionario_A.png"));
            form_funcionario.setIcon( ii );
            btn_novo.setEnabled(true);
            btn_cancelar.setEnabled(false);
            txt_ocupacao.setText("");
        }
    }//GEN-LAST:event_jTable1MouseReleased

    private void btn_editarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editarMousePressed
        if(jTable1.getSelectionModel().getSelectedItemsCount() == 1){
            jTable1.getSelectionModel().clearSelection();
            atualizarlistaeditar();
        }
    }//GEN-LAST:event_btn_editarMousePressed

    private void btn_salvarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_salvarMousePressed
        if(this.emSelecao){
            Object[] options = { "Confirmar", "Cancelar" };
            int opcao = JOptionPane.showOptionDialog(null, "Deseja prosseguir com o cadastro?\nLembre-se de apertar enter no campo alterado para confirmar a ação!","Confirmação", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
            
            if(opcao == 0){
                realizarAlteracoes();
                jTable1.getSelectionModel().clearSelection();
                ImageIcon ii = new ImageIcon(getClass().getResource("/assets/form_funcionario_A.png"));
                form_funcionario.setIcon( ii );
                btn_novo.setEnabled(true);
                btn_cancelar.setEnabled(false);
                txt_ocupacao.setText("");
                btn_editar.setEnabled(false);
                btn_excluir.setEnabled(false);
                this.emSelecao = false;
                btn_salvar.setEnabled(false);
                atualizarlista();
                JOptionPane.showMessageDialog(null, "Dados Atualizados com Sucesso!");
            }
        }
    }//GEN-LAST:event_btn_salvarMousePressed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_cancelar;
    private javax.swing.JLabel btn_editar;
    private javax.swing.JLabel btn_excluir;
    private javax.swing.JLabel btn_main;
    private javax.swing.JLabel btn_novo;
    private javax.swing.JLabel btn_regproduto;
    private javax.swing.JLabel btn_salvar;
    private javax.swing.JLabel form_funcionario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_Cargo;
    private javax.swing.JLabel jLabel_Desc;
    private javax.swing.JLabel jLabel_Nome;
    private javax.swing.JLabel jLabel_Rodape1;
    private javax.swing.JLabel jLabel_Rodape2;
    private javax.swing.JLabel jLabel_Titulo1;
    private javax.swing.JLabel jLabel_Titulo2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txt_ocupacao;
    // End of variables declaration//GEN-END:variables
}
