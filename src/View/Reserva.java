/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Ocupacao;
import Controller.Quarto;
import Controller.Usuario;
import Model.Dao_Ocupacao;
import Model.Dao_Quarto;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.joda.time.DateTime;
import org.joda.time.Days;

/**
 *
 * @author DESENVOLVIMENTO
 */
public class Reserva extends javax.swing.JFrame {

    Font roboto = null;
    Font robotoB = null;
    Font rodape = null;
    Font nome = null;
    Font cargo = null;
    Font desc = null;
    Usuario user;
    String IDQuarto = "0";
    String IDCliente = "";
    boolean msg = true;
    boolean msg2 = true;
    
    public Reserva(Usuario user) {
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
        ((DefaultTableModel) jTable1.getModel()).setRowCount(1);
        
    }
    
    private void atualizarlista(){
        try {
            DefaultTableModel model =(DefaultTableModel) jTable1.getModel();
            model.getDataVector().clear();// limpa a tabela
            Dao_Quarto listarc = new Dao_Quarto();
            List<Quarto> lista = listarc.buscarDisponivelDia();// aki é a pesquisa que popula meu list

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
    
    private void atualizarListaV2() throws ParseException{
        String entTxt = txt_data_entrada.getText().replaceAll("\\s+","");
        String saiTxt = txt_data_saida.getText().replaceAll("\\s+","");
        
        if(auxiliares.Validacao.verificarDataInvalida(entTxt) || auxiliares.Validacao.verificarDataInvalida(saiTxt) || entTxt.length() != 10 || saiTxt.length() != 10){
        }else if(!auxiliares.Data.verificarSeUtrapassaHoje(saiTxt) || !auxiliares.Data.verificarSeUtrapassaHoje(entTxt)){
            if(msg2 == true){
                JOptionPane.showMessageDialog(null, "A datas de reserva devem vir após o dia de hoje!");
            }
            msg2 = !msg2;
            ((DefaultTableModel) jTable1.getModel()).setRowCount(0);
            this.IDQuarto = "0";
            txt_quartos.setText("");
            ImageIcon ii = new ImageIcon(getClass().getResource("/assets/form_quartos_A.png"));
            form_quarto.setIcon( ii );
        }else if(auxiliares.Data.verificarMesmoDia(saiTxt, entTxt)){
            execultarAtualizacao(entTxt, saiTxt);
        }else if(!auxiliares.Data.verificarSeUtrapassa(saiTxt, entTxt)){
            if(msg == true){
                JOptionPane.showMessageDialog(null, "Dia de Sáida deve ser após o de entrada!");
            }
            msg = !msg;
            ((DefaultTableModel) jTable1.getModel()).setRowCount(0);
            this.IDQuarto = "0";
            txt_quartos.setText("");
            ImageIcon ii = new ImageIcon(getClass().getResource("/assets/form_quartos_A.png"));
            form_quarto.setIcon( ii );
        }else{
            execultarAtualizacao(entTxt, saiTxt);
        }
    }
    
    private void execultarAtualizacao(String entradaV, String saidaV){
        try {
            //Capturamos a data de Entrada
            DateTime entrada = auxiliares.Data.converterString(entradaV);
            //Capturamos a Data de Saida
            DateTime saida = auxiliares.Data.converterString(saidaV);
            //Variavel de Data Pecorrida
            DateTime pecorrido = entrada;
            //Configuramos a Reserva
            Ocupacao opcoes = new Ocupacao();
            opcoes.setCheckIn(new java.sql.Date(entrada.toDate().getTime()));
            opcoes.setCheckOut(new java.sql.Date(saida.toDate().getTime()));
            try {
                DefaultTableModel model =(DefaultTableModel) jTable1.getModel();
                model.getDataVector().clear();// limpa a tabela
                Dao_Quarto listarc = new Dao_Quarto();
                // aki é a pesquisa que popula meu list
                List<Quarto> lista = listarc.buscarDisponivelEntreDadas(opcoes); 

                if (!lista.isEmpty()) {// aki verifica se a list nao esta vazia
                    for (Quarto c : lista) {// aki ele percorre minha lista

                        model.addRow(new Object[]{c.getId(), c.getNumeroQuarto(), c.getTipo(), c.getPrecoDiaria()});// adiciona na jtbale
                    }
                }else{
                    model.setNumRows(1);
                }
            }catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar tabela\n" + e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (ParseException ex) {
            Logger.getLogger(CheckIn.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel_Rodape2 = new javax.swing.JLabel();
        jLabel_Rodape1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txt_data_saida = new javax.swing.JFormattedTextField();
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
        txt_data_entrada = new javax.swing.JFormattedTextField();
        form_data2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        form_data1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hotel Plus Service - Check-In");
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

        txt_data_saida.setBackground(new java.awt.Color(255, 255, 255, 0));
        txt_data_saida.setBorder(null);
        txt_data_saida.setForeground(new java.awt.Color(83, 83, 83));
        try {
            txt_data_saida.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_data_saida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_data_saidaKeyReleased(evt);
            }
        });
        jPanel1.add(txt_data_saida, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 279, 180, 30));

        btn_registro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/btn_registro_A.png"))); // NOI18N
        btn_registro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_registro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_registroMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_registroMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_registroMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_registroMousePressed(evt);
            }
        });
        jPanel1.add(btn_registro, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 436, -1, -1));

        jLabel_Titulo2.setForeground(new java.awt.Color(140, 140, 140));
        jLabel_Titulo2.setText("Reserva de Quarto");
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
        jPanel1.add(form_data, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, -1));

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
        jPanel1.add(txt_quartos, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 439, 180, 30));

        form_quarto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/form_quartos_A.png"))); // NOI18N
        jPanel1.add(form_quarto, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 420, -1, -1));

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
        jPanel1.add(txt_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 439, 180, 30));

        form_cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/form_cliente_A.png"))); // NOI18N
        jPanel1.add(form_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 420, -1, -1));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 200, -1, 150));

        txt_data_entrada.setBackground(new java.awt.Color(255, 255, 255, 0));
        txt_data_entrada.setBorder(null);
        txt_data_entrada.setForeground(new java.awt.Color(83, 83, 83));
        try {
            txt_data_entrada.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_data_entrada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_data_entradaKeyReleased(evt);
            }
        });
        jPanel1.add(txt_data_entrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 219, 180, 30));

        form_data2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/form_data_B.png"))); // NOI18N
        jPanel1.add(form_data2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, -1));

        jLabel4.setBackground(new java.awt.Color(74, 0, 224));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(74, 0, 224));
        jLabel4.setText("de Entrada do Hóspede");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 199, -1, -1));

        jLabel2.setBackground(new java.awt.Color(74, 0, 224));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(74, 0, 224));
        jLabel2.setText("de Saída do Hóspede");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 259, -1, -1));

        jLabel5.setBackground(new java.awt.Color(74, 0, 224));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(74, 0, 224));
        jLabel5.setText("os quartos diponíveis");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, -1, 20));

        jLabel6.setBackground(new java.awt.Color(74, 0, 224));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(74, 0, 224));
        jLabel6.setText("Ao inserir duas datas válidas, a tabela exibirá os ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 520));

        jLabel3.setBackground(new java.awt.Color(74, 0, 224));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(74, 0, 224));
        jLabel3.setText("de Saída do Hóspede");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(508, 399, -1, -1));

        form_data1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/form_data_B.png"))); // NOI18N
        getContentPane().add(form_data1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 400, -1, -1));

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
        }
    }//GEN-LAST:event_txt_clienteMouseClicked

    private void txt_quartosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_quartosMouseClicked
        JOptionPane.showMessageDialog(null, "Para selecionar um quarto, de um duplo clique no quato disponivel na tabela acima!");
    }//GEN-LAST:event_txt_quartosMouseClicked

    private void btn_registroMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_registroMousePressed
        
    }//GEN-LAST:event_btn_registroMousePressed

    private void txt_data_entradaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_data_entradaKeyReleased
        try {
            this.atualizarListaV2();
        } catch (ParseException ex) {
            Logger.getLogger(Reserva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txt_data_entradaKeyReleased

    private void txt_data_saidaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_data_saidaKeyReleased
        try {
            this.atualizarListaV2();
        } catch (ParseException ex) {
            Logger.getLogger(Reserva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txt_data_saidaKeyReleased

    private void btn_registroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_registroMouseClicked
        if(this.IDCliente.equals("") || this.IDQuarto.equals("0")){
            JOptionPane.showMessageDialog(null, "Selecione o Cliente e o Quarto Corretamente");
        }else{
            Object[] options = { "Confirmar", "Cancelar" };
            int opcao = JOptionPane.showOptionDialog(null, "Reserva a ser marcada, deseja confirmar?","Confirmação", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
            if(opcao == 0){
                try {
                    //Capturamos a data de Entrada
                    DateTime entrada = auxiliares.Data.converterString(txt_data_entrada.getText());
                    //Capturamos a Data de Saida
                    DateTime saida = auxiliares.Data.converterString(txt_data_saida.getText());
                    //Calculamos quantos dias de Reservas serão feitos
                    int DiasReservas = Days.daysBetween(entrada, saida).getDays() + 1;
                    //Variavel de Data Pecorrida
                    DateTime pecorrido = entrada;
                    //Configuramos a Reserva
                    Ocupacao reservamax = new Ocupacao();
                    reservamax.setCheckIn(new java.sql.Date(entrada.toDate().getTime()));
                    reservamax.setCheckOut(new java.sql.Date(saida.toDate().getTime()));
                    reservamax.setFK_Cliente(Integer.parseInt(this.IDCliente));
                    reservamax.setFK_Quarto(Integer.parseInt(this.IDQuarto));
                    reservamax.setCheck(false);
                    //Fazemos Laço Pecorrendo Cada Data
                    for(int i = 0; i < DiasReservas; i++){
                        //Registramos a Reserva do dia em uma Ocupação Propria
                        reservamax.setReserva(new java.sql.Date(pecorrido.toDate().getTime()));
                        Dao_Ocupacao ocupa = new Dao_Ocupacao();
                        ocupa.salvarReserva(reservamax);
                        //Pecorre o dia para o proximo laço
                        pecorrido = auxiliares.Data.avancardia(pecorrido);
                    }
                    //Informamos o Registro e Finalizamos a Sessão
                    JOptionPane.showMessageDialog(null, "Reserva do hóspede " + txt_cliente.getText() + " Feito");
                    new Recepcao(user).setVisible(true);
                    this.dispose();
                }catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro ao atualizar tabela\n" + e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btn_registroMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_main;
    private javax.swing.JLabel btn_registro;
    private javax.swing.JLabel form_cliente;
    private javax.swing.JLabel form_data;
    private javax.swing.JLabel form_data1;
    private javax.swing.JLabel form_data2;
    private javax.swing.JLabel form_quarto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
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
    private javax.swing.JFormattedTextField txt_data_entrada;
    private javax.swing.JFormattedTextField txt_data_saida;
    private javax.swing.JTextField txt_quartos;
    // End of variables declaration//GEN-END:variables
}
