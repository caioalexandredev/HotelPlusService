/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Endereco;
import Controller.Produtos;
import Controller.Usuario;
import Model.Dao_Endereco;
import Model.Dao_Produtos;
import Model.Dao_Usuario;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DESENVOLVIMENTO
 */
public class PainelProdutos extends javax.swing.JFrame {

    Font roboto = null;
    Font robotoB = null;
    Font rodape = null;
    Font nome = null;
    Font cargo = null;
    Font desc = null;
    Usuario user;
    String produtosExibidos = "";
    double precoFinalProdutos = 0;
    int ocupacao;
    String textoNotaProdutos = "";
    
    public PainelProdutos(Usuario user) {
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
    
    private void definirDadosEmTela(){
        jLabel_Nome.setText(this.user.getNome());
        jLabel_Cargo.setText("Cargo: " + this.user.getCargo());
    }
    
    private void atualizarlista(){
        try {
            DefaultTableModel model =(DefaultTableModel) jTable1.getModel();
            model.getDataVector().clear();// limpa a tabela
            Dao_Produtos produtosgerais = new Dao_Produtos();
            List<Produtos> lista = produtosgerais.buscaGeral();// aki é a pesquisa que popula meu list

            if (!lista.isEmpty()) {// aki verifica se a list nao esta vazia
                for (Produtos c : lista) {// aki ele percorre minha lista
                    model.addRow(new Object[]{c.getId(), c.getNome(), c.getPreco()});// adiciona na jtbale
                }
            }else{
                model.setNumRows(1);
            }
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar tabela\n" + e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
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

        jLabel_Rodape2 = new javax.swing.JLabel();
        jLabel_Rodape1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txt_excluir = new javax.swing.JLabel();
        jLabel_Titulo2 = new javax.swing.JLabel();
        jLabel_Titulo1 = new javax.swing.JLabel();
        jLabel_Cargo = new javax.swing.JLabel();
        jLabel_Nome = new javax.swing.JLabel();
        jLabel_Desc = new javax.swing.JLabel();
        btn_main = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txt_registrar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hotel Plus Service - Check-Out Finalização");
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

        txt_excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/btn_produto_exc_A.png"))); // NOI18N
        txt_excluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txt_excluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_excluirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_excluirMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_excluirMousePressed(evt);
            }
        });
        jPanel1.add(txt_excluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 390, -1, -1));

        jLabel_Titulo2.setForeground(new java.awt.Color(140, 140, 140));
        jLabel_Titulo2.setText("do Frigobar (Padrão a Todos)");
        jPanel1.add(jLabel_Titulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, -1, -1));

        jLabel_Titulo1.setForeground(new java.awt.Color(140, 140, 140));
        jLabel_Titulo1.setText("Tabela de Registro de Itens");
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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_mainMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_mainMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_mainMouseExited(evt);
            }
        });
        jPanel1.add(btn_main, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 50, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nome", "Preço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(5);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(5);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 190, 420, 170));

        txt_registrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/btn_produto_reg_A.png"))); // NOI18N
        txt_registrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txt_registrar.setEnabled(false);
        txt_registrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_registrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_registrarMouseExited(evt);
            }
        });
        jPanel1.add(txt_registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 390, -1, -1));

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

    private void btn_mainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_mainMouseClicked
        new Recepcao(user).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_mainMouseClicked

    private void txt_excluirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_excluirMouseEntered
        ImageIcon ii = new ImageIcon(getClass().getResource("/assets/btn_produto_exc_B.png"));
        txt_excluir.setIcon( ii );
    }//GEN-LAST:event_txt_excluirMouseEntered

    private void txt_excluirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_excluirMouseExited
        ImageIcon ii = new ImageIcon(getClass().getResource("/assets/btn_produto_exc_A.png"));
        txt_excluir.setIcon( ii );
    }//GEN-LAST:event_txt_excluirMouseExited

    private void txt_registrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_registrarMouseEntered
        ImageIcon ii = new ImageIcon(getClass().getResource("/assets/btn_produto_reg_B.png"));
        txt_registrar.setIcon( ii );
    }//GEN-LAST:event_txt_registrarMouseEntered

    private void txt_registrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_registrarMouseExited
        ImageIcon ii = new ImageIcon(getClass().getResource("/assets/btn_produto_reg_A.png"));
        txt_registrar.setIcon( ii );
    }//GEN-LAST:event_txt_registrarMouseExited

    private void txt_excluirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_excluirMousePressed
        String input = JOptionPane.showInputDialog(null,"Identificação do Produto");
        if(input != null && !input.equals("") && input.matches("[0-9]+")){
            int valor = Integer.parseInt(input);
            Dao_Produtos busca = new Dao_Produtos();
            if(!busca.buscarViaID(valor).isEmpty()){
                Object[] options = { "Confirmar", "Cancelar" };
                int opcao = JOptionPane.showOptionDialog(null, "Deseja mesmo excluir este produto?","Confirmação", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                if(opcao == 0){
                    busca.Excluir(valor);
                    JOptionPane.showMessageDialog(null, "Excluido com Sucesso!");
                    this.atualizarlista();
                }
            }else{
                JOptionPane.showMessageDialog(null, "Produto Inexistente!");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Digite um valor válido!");
        }
    }//GEN-LAST:event_txt_excluirMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_main;
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
    private javax.swing.JLabel txt_excluir;
    private javax.swing.JLabel txt_registrar;
    // End of variables declaration//GEN-END:variables
}
