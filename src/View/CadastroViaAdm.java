package View;

import Controller.Endereco;
import Controller.Usuario;
import Model.Dao_Endereco;
import Model.Dao_Usuario;
import auxiliares.Validacao;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class CadastroViaAdm extends javax.swing.JDialog {

    Font roboto = null;
    Font rodape = null;
    
    public CadastroViaAdm() {
        initComponents();
        
        try{
        roboto = Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResourceAsStream("fonts/Roboto-Regular.ttf"));
        }
        catch(IOException|FontFormatException e){
             System.out.println("Erro: " + e);
        }
        
        rodape = roboto.deriveFont(Font.PLAIN, 13);
        
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        
        ge.registerFont(rodape);  
        jLabel_Rodape1.setFont(rodape); 
        jLabel_Rodape2.setFont(rodape); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_CPF = new javax.swing.JFormattedTextField();
        txt_nascimento = new javax.swing.JFormattedTextField();
        btn_cadastro1 = new javax.swing.JLabel();
        btn_cadastro = new javax.swing.JLabel();
        txt_comp = new javax.swing.JTextField();
        form_Comp = new javax.swing.JLabel();
        txt_numero = new javax.swing.JTextField();
        form_Numero = new javax.swing.JLabel();
        txt_estado = new javax.swing.JTextField();
        form_Estado = new javax.swing.JLabel();
        txt_cidade = new javax.swing.JTextField();
        form_Cidade = new javax.swing.JLabel();
        txt_bairro = new javax.swing.JTextField();
        form_Bairro = new javax.swing.JLabel();
        txt_rua = new javax.swing.JTextField();
        form_Rua = new javax.swing.JLabel();
        form_CPF = new javax.swing.JLabel();
        form_Nascimento = new javax.swing.JLabel();
        txt_cargo = new javax.swing.JTextField();
        form_Cargo = new javax.swing.JLabel();
        txt_celular = new javax.swing.JFormattedTextField();
        form_Celular = new javax.swing.JLabel();
        txt_nome = new javax.swing.JTextField();
        form_Nome = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        form_Email = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel_Rodape2 = new javax.swing.JLabel();
        jLabel_Rodape1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Hotel Plus Service - Cadastro");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/assets/icon.png")).getImage());
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_CPF.setBackground(new java.awt.Color(255, 255, 255, 0));
        txt_CPF.setBorder(null);
        txt_CPF.setForeground(new java.awt.Color(83, 83, 83));
        try {
            txt_CPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_CPF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_CPFKeyTyped(evt);
            }
        });
        getContentPane().add(txt_CPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(555, 220, 180, 30));

        txt_nascimento.setBackground(new java.awt.Color(255, 255, 255, 0));
        txt_nascimento.setBorder(null);
        txt_nascimento.setForeground(new java.awt.Color(83, 83, 83));
        try {
            txt_nascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_nascimento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nascimentoKeyTyped(evt);
            }
        });
        getContentPane().add(txt_nascimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 220, 180, 30));

        btn_cadastro1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/return.png"))); // NOI18N
        btn_cadastro1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cadastro1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cadastro1MouseClicked(evt);
            }
        });
        getContentPane().add(btn_cadastro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 13, -1, -1));

        btn_cadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/btn_CadastroF_A.png"))); // NOI18N
        btn_cadastro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cadastro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cadastroMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_cadastroMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_cadastroMouseExited(evt);
            }
        });
        getContentPane().add(btn_cadastro, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 435, -1, -1));

        txt_comp.setBackground(new java.awt.Color(255, 255, 255, 0));
        txt_comp.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txt_comp.setForeground(new java.awt.Color(83, 83, 83));
        txt_comp.setBorder(null);
        txt_comp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_compActionPerformed(evt);
            }
        });
        txt_comp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_compKeyPressed(evt);
            }
        });
        getContentPane().add(txt_comp, new org.netbeans.lib.awtextra.AbsoluteConstraints(555, 380, 190, 30));

        form_Comp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/form_Comp_A.png"))); // NOI18N
        getContentPane().add(form_Comp, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 360, -1, -1));

        txt_numero.setBackground(new java.awt.Color(255, 255, 255, 0));
        txt_numero.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txt_numero.setForeground(new java.awt.Color(83, 83, 83));
        txt_numero.setBorder(null);
        txt_numero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_numeroActionPerformed(evt);
            }
        });
        txt_numero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_numeroKeyPressed(evt);
            }
        });
        getContentPane().add(txt_numero, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 380, 190, 30));

        form_Numero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/form_Numero_A.png"))); // NOI18N
        getContentPane().add(form_Numero, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 360, -1, -1));

        txt_estado.setBackground(new java.awt.Color(255, 255, 255, 0));
        txt_estado.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txt_estado.setForeground(new java.awt.Color(83, 83, 83));
        txt_estado.setBorder(null);
        txt_estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_estadoActionPerformed(evt);
            }
        });
        txt_estado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_estadoKeyPressed(evt);
            }
        });
        getContentPane().add(txt_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 380, 180, 30));

        form_Estado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/form_Estado_A.png"))); // NOI18N
        getContentPane().add(form_Estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, -1, -1));

        txt_cidade.setBackground(new java.awt.Color(255, 255, 255, 0));
        txt_cidade.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txt_cidade.setForeground(new java.awt.Color(83, 83, 83));
        txt_cidade.setBorder(null);
        txt_cidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cidadeActionPerformed(evt);
            }
        });
        txt_cidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_cidadeKeyPressed(evt);
            }
        });
        getContentPane().add(txt_cidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(555, 320, 190, 30));

        form_Cidade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/form_Cidade_A.png"))); // NOI18N
        getContentPane().add(form_Cidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 300, -1, -1));

        txt_bairro.setBackground(new java.awt.Color(255, 255, 255, 0));
        txt_bairro.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txt_bairro.setForeground(new java.awt.Color(83, 83, 83));
        txt_bairro.setBorder(null);
        txt_bairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bairroActionPerformed(evt);
            }
        });
        txt_bairro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_bairroKeyPressed(evt);
            }
        });
        getContentPane().add(txt_bairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 320, 190, 30));

        form_Bairro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/form_Bairro_A.png"))); // NOI18N
        getContentPane().add(form_Bairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 300, -1, -1));

        txt_rua.setBackground(new java.awt.Color(255, 255, 255, 0));
        txt_rua.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txt_rua.setForeground(new java.awt.Color(83, 83, 83));
        txt_rua.setBorder(null);
        txt_rua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ruaActionPerformed(evt);
            }
        });
        txt_rua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_ruaKeyPressed(evt);
            }
        });
        getContentPane().add(txt_rua, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 320, 190, 30));

        form_Rua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/form_Rua_A.png"))); // NOI18N
        getContentPane().add(form_Rua, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, -1, -1));

        form_CPF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/form_CPF_B.png"))); // NOI18N
        getContentPane().add(form_CPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 200, -1, -1));

        form_Nascimento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/form_Nasc_B.png"))); // NOI18N
        getContentPane().add(form_Nascimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 200, -1, -1));

        txt_cargo.setBackground(new java.awt.Color(255, 255, 255, 0));
        txt_cargo.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txt_cargo.setForeground(new java.awt.Color(83, 83, 83));
        txt_cargo.setBorder(null);
        txt_cargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cargoActionPerformed(evt);
            }
        });
        txt_cargo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_cargoKeyPressed(evt);
            }
        });
        getContentPane().add(txt_cargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 220, 190, 30));

        form_Cargo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/form_Cargo_A.png"))); // NOI18N
        getContentPane().add(form_Cargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, -1, -1));

        txt_celular.setBackground(new java.awt.Color(255, 255, 255, 0));
        txt_celular.setBorder(null);
        txt_celular.setForeground(new java.awt.Color(83, 83, 83));
        try {
            txt_celular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) # ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(txt_celular, new org.netbeans.lib.awtextra.AbsoluteConstraints(555, 160, 180, 30));

        form_Celular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/form_Cel_B.png"))); // NOI18N
        getContentPane().add(form_Celular, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 140, -1, -1));

        txt_nome.setBackground(new java.awt.Color(255, 255, 255, 0));
        txt_nome.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txt_nome.setForeground(new java.awt.Color(83, 83, 83));
        txt_nome.setBorder(null);
        txt_nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nomeActionPerformed(evt);
            }
        });
        txt_nome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_nomeKeyPressed(evt);
            }
        });
        getContentPane().add(txt_nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 160, 180, 30));

        form_Nome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/form_Nome_A.png"))); // NOI18N
        getContentPane().add(form_Nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, -1, -1));

        txt_email.setBackground(new java.awt.Color(255, 255, 255, 0));
        txt_email.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txt_email.setForeground(new java.awt.Color(83, 83, 83));
        txt_email.setBorder(null);
        txt_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_emailActionPerformed(evt);
            }
        });
        txt_email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_emailKeyPressed(evt);
            }
        });
        getContentPane().add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 160, 180, 30));

        form_Email.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/form_Email_A.png"))); // NOI18N
        getContentPane().add(form_Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/BG_Cadastro.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jLabel_Rodape2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Rodape2.setText("de Análise e Desenvolvimento de Sistemas peos Discentes Caio Alexandre de Sousa Ramos e Lucas Eduardo Sampaio Andrade.");
        getContentPane().add(jLabel_Rodape2, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 560, -1, -1));

        jLabel_Rodape1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Rodape1.setText("Este software é um protótipo desenvolvido durante uma avaliação da disciplina de Linguagem de Programação II no curso Tecnológico");
        getContentPane().add(jLabel_Rodape1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 545, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/BG_login.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_emailActionPerformed

    private void txt_emailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_emailKeyPressed
        ImageIcon ii = new ImageIcon(getClass().getResource("/assets/form_Email_B.png"));
        form_Email.setIcon( ii );
    }//GEN-LAST:event_txt_emailKeyPressed

    private void txt_nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nomeActionPerformed

    private void txt_nomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nomeKeyPressed
        ImageIcon ii = new ImageIcon(getClass().getResource("/assets/form_Nome_B.png"));
        form_Nome.setIcon( ii );
    }//GEN-LAST:event_txt_nomeKeyPressed

    private void txt_cargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cargoActionPerformed

    private void txt_cargoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cargoKeyPressed
        ImageIcon ii = new ImageIcon(getClass().getResource("/assets/form_Cargo_B.png"));
        form_Cargo.setIcon( ii );
    }//GEN-LAST:event_txt_cargoKeyPressed

    private void txt_compActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_compActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_compActionPerformed

    private void txt_compKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_compKeyPressed
        ImageIcon ii = new ImageIcon(getClass().getResource("/assets/form_Comp_B.png"));
        form_Comp.setIcon( ii );
    }//GEN-LAST:event_txt_compKeyPressed

    private void txt_numeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_numeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_numeroActionPerformed

    private void txt_numeroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_numeroKeyPressed
        ImageIcon ii = new ImageIcon(getClass().getResource("/assets/form_Numero_B.png"));
        form_Numero.setIcon( ii );
    }//GEN-LAST:event_txt_numeroKeyPressed

    private void txt_estadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_estadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_estadoActionPerformed

    private void txt_estadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_estadoKeyPressed
        ImageIcon ii = new ImageIcon(getClass().getResource("/assets/form_Estado_B.png"));
        form_Estado.setIcon( ii );
    }//GEN-LAST:event_txt_estadoKeyPressed

    private void txt_cidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cidadeActionPerformed

    private void txt_cidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cidadeKeyPressed
        ImageIcon ii = new ImageIcon(getClass().getResource("/assets/form_Cidade_B.png"));
        form_Cidade.setIcon( ii );
    }//GEN-LAST:event_txt_cidadeKeyPressed

    private void txt_bairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bairroActionPerformed

    private void txt_bairroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_bairroKeyPressed
       ImageIcon ii = new ImageIcon(getClass().getResource("/assets/form_Bairro_B.png"));
       form_Bairro.setIcon( ii );
    }//GEN-LAST:event_txt_bairroKeyPressed

    private void txt_ruaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ruaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ruaActionPerformed

    private void txt_ruaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ruaKeyPressed
        ImageIcon ii = new ImageIcon(getClass().getResource("/assets/form_Rua_B.png"));
        form_Rua.setIcon( ii );
    }//GEN-LAST:event_txt_ruaKeyPressed

    private void btn_cadastroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cadastroMouseEntered
        ImageIcon ii = new ImageIcon(getClass().getResource("/assets/btn_CadastroF_B.png"));
        btn_cadastro.setIcon( ii );
    }//GEN-LAST:event_btn_cadastroMouseEntered

    private void btn_cadastroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cadastroMouseExited
        ImageIcon ii = new ImageIcon(getClass().getResource("/assets/btn_CadastroF_A.png"));
        btn_cadastro.setIcon( ii );
    }//GEN-LAST:event_btn_cadastroMouseExited

    private void btn_cadastro1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cadastro1MouseClicked
        this.dispose();
    }//GEN-LAST:event_btn_cadastro1MouseClicked

    private void btn_cadastroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cadastroMouseClicked
        Object[] options = { "Confirmar", "Cancelar" };
        int opcao = JOptionPane.showOptionDialog(null, "Deseja prosseguir com o cadastro?","Confirmação", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
        
        if(opcao == 0){
            String campos[] = {txt_rua.getText(), txt_bairro.getText(), txt_numero.getText(), txt_comp.getText(), txt_cidade.getText(), txt_estado.getText(), txt_nome.getText(), txt_email.getText(), txt_celular.getText(), txt_cargo.getText(), txt_nascimento.getText(), txt_CPF.getText()};
            
            if(Validacao.verificarCamposVazios(campos) && Validacao.verificarExistenciaEmail(txt_email.getText())){
                Usuario cadUser = new Usuario();
                Endereco cadEnd = new Endereco();
                cadEnd.inserirDados(txt_rua.getText(), txt_bairro.getText(), txt_numero.getText(), txt_comp.getText(), txt_cidade.getText(), txt_estado.getText());
                try {
                    cadUser.inserirDados(txt_nome.getText(), txt_email.getText(), txt_celular.getText(), txt_cargo.getText(), txt_nascimento.getText(), txt_CPF.getText(), cadEnd);
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "Houve um erro, contate o adminstrador do sistema");
                    Logger.getLogger(CadastroViaAdm.class.getName()).log(Level.SEVERE, null, ex);
                }
                Dao_Endereco end = new Dao_Endereco();
                if(end.Salvar(cadEnd)){
                    Dao_Usuario user = new Dao_Usuario();
                    if(user.Salvar(cadUser, end.IDInsercao)){
                        JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso, O administrador fará a análise.\n Aguarde mais informações via canais de contato informados!");
                        new Login().setVisible(true);
                        this.dispose();
                    }else{
                        JOptionPane.showMessageDialog(null, "Ocorreu um erro, Contate o Administrador");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro, Contate o Administrador");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Campos Vazios ou Email já Existente!");
            }
        }
    }//GEN-LAST:event_btn_cadastroMouseClicked

    private void txt_nascimentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nascimentoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nascimentoKeyTyped

    private void txt_CPFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_CPFKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CPFKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_cadastro;
    private javax.swing.JLabel btn_cadastro1;
    private javax.swing.JLabel form_Bairro;
    private javax.swing.JLabel form_CPF;
    private javax.swing.JLabel form_Cargo;
    private javax.swing.JLabel form_Celular;
    private javax.swing.JLabel form_Cidade;
    private javax.swing.JLabel form_Comp;
    private javax.swing.JLabel form_Email;
    private javax.swing.JLabel form_Estado;
    private javax.swing.JLabel form_Nascimento;
    private javax.swing.JLabel form_Nome;
    private javax.swing.JLabel form_Numero;
    private javax.swing.JLabel form_Rua;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel_Rodape1;
    private javax.swing.JLabel jLabel_Rodape2;
    private javax.swing.JFormattedTextField txt_CPF;
    private javax.swing.JTextField txt_bairro;
    private javax.swing.JTextField txt_cargo;
    private javax.swing.JFormattedTextField txt_celular;
    private javax.swing.JTextField txt_cidade;
    private javax.swing.JTextField txt_comp;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_estado;
    private javax.swing.JFormattedTextField txt_nascimento;
    private javax.swing.JTextField txt_nome;
    private javax.swing.JTextField txt_numero;
    private javax.swing.JTextField txt_rua;
    // End of variables declaration//GEN-END:variables
}
