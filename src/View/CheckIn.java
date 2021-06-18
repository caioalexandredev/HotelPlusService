/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Quarto;
import Controller.Usuario;
import Model.Dao_Ocupacao;
import Model.Dao_Quarto;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DESENVOLVIMENTO
 */
public class CheckIn extends javax.swing.JFrame {

    Font roboto = null;
    Font robotoB = null;
    Font rodape = null;
    Font nome = null;
    Font cargo = null;
    Font desc = null;
    Usuario user;
    String IDQuarto;
    String IDCliente;
    
    public CheckIn(Usuario user) {
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
        
        definirDadosEmTela();
        atualizarlista();
        
    }
    
    private void atualizarlista(){
        try {
            DefaultTableModel model =(DefaultTableModel) jTable1.getModel();
            model.getDataVector().clear();// limpa a tabela
            Dao_Quarto listarc = new Dao_Quarto();
            List<Quarto> lista = listarc.buscarGeral();// aki é a pesquisa que popula meu list

            if (!lista.isEmpty()) {// aki verifica se a list nao esta vazia
                for (Quarto c : lista) {// aki ele percorre minha lista
                    
                    model.addRow(new Object[]{c.getId(), c.getNumeroQuarto(), c.getTipo(), c.getPrecoDiaria()});// adiciona na jtbale
                }
            }else{
                model.setNumRows(1);
            }
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar tabela\n" + e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void definirDadosEmTela(){
        jLabel_Nome.setText(this.user.getNome());
        jLabel_Cargo.setText("Cargo: " + this.user.getCargo());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel_Rodape2 = new javax.swing.JLabel();
        jLabel_Rodape1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txt_data = new javax.swing.JFormattedTextField();
        btn_registro = new javax.swing.JLabel();
        jLabel_Titulo2 = new javax.swing.JLabel();
        jLabel_Titulo1 = new javax.swing.JLabel();
        jLabel_Cargo = new javax.swing.JLabel();
        jLabel_Nome = new javax.swing.JLabel();
        jLabel_Desc = new javax.swing.JLabel();
        btn_main = new javax.swing.JLabel();
        form_data = new javax.swing.JLabel();
        txt_quartos = new javax.swing.JTextField();
        form_quarto = new javax.swing.JLabel();
        txt_cliente = new javax.swing.JTextField();
        form_cliente = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hotel Plus Service - Check-In");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(74, 0, 224));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(74, 0, 224));
        jLabel2.setText("de Saída do Hóspede");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(508, 399, -1, -1));

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

        txt_data.setBackground(new java.awt.Color(255, 255, 255, 0));
        txt_data.setBorder(null);
        txt_data.setForeground(new java.awt.Color(83, 83, 83));
        try {
            txt_data.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_data.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_dataKeyTyped(evt);
            }
        });
        jPanel1.add(txt_data, new org.netbeans.lib.awtextra.AbsoluteConstraints(495, 420, 180, 30));

        btn_registro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/btn_registro_A.png"))); // NOI18N
        btn_registro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_registro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_registroMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_registroMouseExited(evt);
            }
        });
        jPanel1.add(btn_registro, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 417, -1, -1));

        jLabel_Titulo2.setForeground(new java.awt.Color(140, 140, 140));
        jLabel_Titulo2.setText("Entrada no Quarto");
        jPanel1.add(jLabel_Titulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, -1, -1));

        jLabel_Titulo1.setForeground(new java.awt.Color(140, 140, 140));
        jLabel_Titulo1.setText("Tabela de Registro de");
        jPanel1.add(jLabel_Titulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, -1, -1));

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

        form_data.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/form_data_B.png"))); // NOI18N
        jPanel1.add(form_data, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 400, -1, -1));

        txt_quartos.setEditable(false);
        txt_quartos.setBackground(new java.awt.Color(255, 255, 255, 0));
        txt_quartos.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txt_quartos.setForeground(new java.awt.Color(83, 83, 83));
        txt_quartos.setBorder(null);
        txt_quartos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_quartosMouseClicked(evt);
            }
        });
        txt_quartos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_quartosActionPerformed(evt);
            }
        });
        txt_quartos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_quartosKeyPressed(evt);
            }
        });
        jPanel1.add(txt_quartos, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 420, 180, 30));

        form_quarto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/form_quartos_A.png"))); // NOI18N
        jPanel1.add(form_quarto, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 400, -1, -1));

        txt_cliente.setEditable(false);
        txt_cliente.setBackground(new java.awt.Color(255, 255, 255, 0));
        txt_cliente.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txt_cliente.setForeground(new java.awt.Color(83, 83, 83));
        txt_cliente.setBorder(null);
        txt_cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_clienteMouseClicked(evt);
            }
        });
        txt_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_clienteActionPerformed(evt);
            }
        });
        txt_cliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_clienteKeyPressed(evt);
            }
        });
        jPanel1.add(txt_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 420, 180, 30));

        form_cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/form_cliente_A.png"))); // NOI18N
        jPanel1.add(form_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Quarto Disponível", "Tipo", "Preço"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(10);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, -1, 140));

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

    private void txt_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_clienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_clienteActionPerformed

    private void txt_clienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_clienteKeyPressed
        ImageIcon ii = new ImageIcon(getClass().getResource("/assets/form_cliente_B.png"));
        form_cliente.setIcon( ii );
    }//GEN-LAST:event_txt_clienteKeyPressed

    private void txt_quartosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_quartosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_quartosActionPerformed

    private void txt_quartosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_quartosKeyPressed
        ImageIcon ii = new ImageIcon(getClass().getResource("/assets/form_quartos_B.png"));
        form_quarto.setIcon( ii );
    }//GEN-LAST:event_txt_quartosKeyPressed

    private void btn_registroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_registroMouseEntered
        ImageIcon ii = new ImageIcon(getClass().getResource("/assets/btn_registro_B.png"));
        btn_registro.setIcon( ii );
    }//GEN-LAST:event_btn_registroMouseEntered

    private void btn_registroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_registroMouseExited
        ImageIcon ii = new ImageIcon(getClass().getResource("/assets/btn_registro_A.png"));
        btn_registro.setIcon( ii );
    }//GEN-LAST:event_btn_registroMouseExited

    private void btn_mainMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_mainMousePressed
        new Recepcao(user).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_mainMousePressed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int row = jTable1.rowAtPoint(evt.getPoint());
        int col = jTable1.columnAtPoint(evt.getPoint());
        if (row >= 0 && col >= 0 && evt.getClickCount() == 2) {
            ImageIcon ii = new ImageIcon(getClass().getResource("/assets/form_quartos_B.png"));
            form_quarto.setIcon( ii );
            this.IDQuarto = jTable1.getValueAt(row, 0).toString();
            txt_quartos.setText(jTable1.getValueAt(row, 1).toString());
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void txt_clienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_clienteMouseClicked
        SelecaoCliente modal = new SelecaoCliente();
        modal.setModal(true);
        modal.setVisible(true);
        modal.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        ImageIcon ii = new ImageIcon(getClass().getResource("/assets/form_cliente_B.png"));
        form_cliente.setIcon( ii );
        this.IDCliente = modal.IDCliente;
        txt_cliente.setText(modal.NomeCliente);
        modal.dispose();
        
        if(txt_cliente.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Nenhum Cliente Selecionado, Por Favor Selecione");
            ImageIcon iii = new ImageIcon(getClass().getResource("/assets/form_cliente_A.png"));
            form_cliente.setIcon( iii );
        }else{
            //Convertendo Data para Formato Aceito
            java.sql.Date data = new java.sql.Date(Calendar.getInstance().getTime().getTime());
            Dao_Ocupacao ocupacaov = new Dao_Ocupacao();
            if(ocupacaov.verificarReserva(Integer.parseInt(this.IDCliente), data)){
                Object[] options = { "Confirmar", "Cancelar" };
                int opcao = JOptionPane.showOptionDialog(null, "O Cliente " + txt_cliente.getText() + " tem uma reserva marcada iniciando hoje, deseja apenas comfirmar?","Confirmação", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
                if(opcao == 0){
                    ocupacaov.confirmarReserva(ocupacaov.idOcupacao);
                    JOptionPane.showMessageDialog(null, "Check-in Efetuado! Retornando a Recepção!");
                    new Recepcao(this.user).setVisible(true);
                    this.dispose();
                }
            }
        }
    }//GEN-LAST:event_txt_clienteMouseClicked

    private void txt_dataKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dataKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dataKeyTyped

    private void txt_quartosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_quartosMouseClicked
        JOptionPane.showMessageDialog(null, "Para selecionar um quarto, de um duplo clique no quato disponivel na tabela acima!");
    }//GEN-LAST:event_txt_quartosMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_main;
    private javax.swing.JLabel btn_registro;
    private javax.swing.JLabel form_cliente;
    private javax.swing.JLabel form_data;
    private javax.swing.JLabel form_quarto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JTextField txt_cliente;
    private javax.swing.JFormattedTextField txt_data;
    private javax.swing.JTextField txt_quartos;
    // End of variables declaration//GEN-END:variables
}
