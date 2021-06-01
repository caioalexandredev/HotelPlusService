/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Usuario;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import javax.swing.ImageIcon;

/**
 *
 * @author DESENVOLVIMENTO
 */
public class TelaInicial extends javax.swing.JFrame {

    Font roboto = null;
    Font robotoB = null;
    Font rodape = null;
    Font nome = null;
    Font cargo = null;
    Font desc = null;
    Usuario user;
    
    public TelaInicial(Usuario user) {
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
        
        definirDadosEmTela(user);
        this.user = user;
        configurarUsuario();
    }
    
    private void configurarUsuario(){
        if(user.getNivel() == 1){
            btn_recepcao.disable();
        }else if(user.getNivel() == 2){
            btn_recepcao.disable();
            btn_controle.disable();
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
        jLabel_Cargo = new javax.swing.JLabel();
        jLabel_Nome = new javax.swing.JLabel();
        jLabel_Desc = new javax.swing.JLabel();
        btn_sair = new javax.swing.JLabel();
        btn_ponto = new javax.swing.JLabel();
        btn_recepcao = new javax.swing.JLabel();
        btn_controle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hotel Plus Service - Tela Inicial");
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

        jLabel_Cargo.setBackground(new java.awt.Color(92, 92, 92));
        jLabel_Cargo.setForeground(new java.awt.Color(150, 150, 150));
        jLabel_Cargo.setText("Cargo: Cargo do Usuário");
        jPanel1.add(jLabel_Cargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, -1, -1));

        jLabel_Nome.setBackground(new java.awt.Color(92, 92, 92));
        jLabel_Nome.setForeground(new java.awt.Color(92, 92, 92));
        jLabel_Nome.setText("Nome do Usuário do Sistema");
        jPanel1.add(jLabel_Nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 115, -1, -1));

        jLabel_Desc.setForeground(new java.awt.Color(142, 45, 226));
        jLabel_Desc.setText("Você entrou como:");
        jPanel1.add(jLabel_Desc, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, -1, -1));

        btn_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/btn_Sair_A.png"))); // NOI18N
        btn_sair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_sair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_sairMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_sairMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_sairMouseExited(evt);
            }
        });
        jPanel1.add(btn_sair, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 360, -1, -1));

        btn_ponto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/btn_Ponto_A.png"))); // NOI18N
        btn_ponto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ponto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_pontoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_pontoMouseExited(evt);
            }
        });
        jPanel1.add(btn_ponto, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, -1, -1));

        btn_recepcao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/btn_Recepcao_A.png"))); // NOI18N
        btn_recepcao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_recepcao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_recepcaoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_recepcaoMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_recepcaoMousePressed(evt);
            }
        });
        jPanel1.add(btn_recepcao, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, -1, -1));

        btn_controle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/btn_Controle_A.png"))); // NOI18N
        btn_controle.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_controle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_controleMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_controleMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_controleMousePressed(evt);
            }
        });
        jPanel1.add(btn_controle, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 300, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 520));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void definirDadosEmTela(Usuario usuario){
        jLabel_Nome.setText(usuario.getNome());
        jLabel_Cargo.setText("Cargo: " + usuario.getCargo());
    }
    
    private void btn_pontoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_pontoMouseEntered
        ImageIcon ii = new ImageIcon(getClass().getResource("/assets/btn_Ponto_B.png"));
        btn_ponto.setIcon( ii );
    }//GEN-LAST:event_btn_pontoMouseEntered

    private void btn_pontoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_pontoMouseExited
        ImageIcon ii = new ImageIcon(getClass().getResource("/assets/btn_Ponto_A.png"));
        btn_ponto.setIcon( ii );
    }//GEN-LAST:event_btn_pontoMouseExited

    private void btn_recepcaoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_recepcaoMouseEntered
        ImageIcon ii = new ImageIcon(getClass().getResource("/assets/btn_Recepcao_B.png"));
        btn_recepcao.setIcon( ii );
    }//GEN-LAST:event_btn_recepcaoMouseEntered

    private void btn_recepcaoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_recepcaoMouseExited
        ImageIcon ii = new ImageIcon(getClass().getResource("/assets/btn_Recepcao_A.png"));
        btn_recepcao.setIcon( ii );
    }//GEN-LAST:event_btn_recepcaoMouseExited

    private void btn_controleMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_controleMouseEntered
        ImageIcon ii = new ImageIcon(getClass().getResource("/assets/btn_Controle_B.png"));
        btn_controle.setIcon( ii );
    }//GEN-LAST:event_btn_controleMouseEntered

    private void btn_controleMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_controleMouseExited
        ImageIcon ii = new ImageIcon(getClass().getResource("/assets/btn_Controle_A.png"));
        btn_controle.setIcon( ii );
    }//GEN-LAST:event_btn_controleMouseExited

    private void btn_sairMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_sairMouseEntered
        ImageIcon ii = new ImageIcon(getClass().getResource("/assets/btn_Sair_B.png"));
        btn_sair.setIcon( ii );
    }//GEN-LAST:event_btn_sairMouseEntered

    private void btn_sairMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_sairMouseExited
        ImageIcon ii = new ImageIcon(getClass().getResource("/assets/btn_Sair_A.png"));
        btn_sair.setIcon( ii );
    }//GEN-LAST:event_btn_sairMouseExited

    private void btn_sairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_sairMouseClicked
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_sairMouseClicked

    private void btn_controleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_controleMousePressed
        if(user.getNivel() == 3){
            new Controle(this.user).setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btn_controleMousePressed

    private void btn_recepcaoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_recepcaoMousePressed
        new Recepcao(user).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_recepcaoMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_controle;
    private javax.swing.JLabel btn_ponto;
    private javax.swing.JLabel btn_recepcao;
    private javax.swing.JLabel btn_sair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_Cargo;
    private javax.swing.JLabel jLabel_Desc;
    private javax.swing.JLabel jLabel_Nome;
    private javax.swing.JLabel jLabel_Rodape1;
    private javax.swing.JLabel jLabel_Rodape2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
