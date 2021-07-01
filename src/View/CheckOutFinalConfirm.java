/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Cliente;
import Controller.Log;
import Controller.Ocupacao;
import Controller.Quarto;
import Model.Dao_Cliente;
import Model.Dao_Log;
import Model.Dao_Ocupacao;
import Model.Dao_Quarto;
import javax.swing.ImageIcon;
import org.joda.time.DateTime;
import org.joda.time.Days;

/**
 *
 * @author DESENVOLVIMENTO
 */
public class CheckOutFinalConfirm extends javax.swing.JDialog {

    boolean check = false;
    String NotaRegistro;
    int idCliente;
    int idQuarto;
    Ocupacao registroPrimordial;
    /**
     * Creates new form CheckOutFinalConfirm
     */
    public CheckOutFinalConfirm(String produtos, double valorProdutos, int id) {
        initComponents();
        
        Dao_Ocupacao busca = new Dao_Ocupacao();
        Ocupacao hospedagem = busca.buscarReservas(id).get(0);
        Dao_Cliente buscaC = new Dao_Cliente();
        System.out.println(hospedagem.getFK_Cliente());
        Cliente cliente = buscaC.buscarClientePorID(hospedagem.getFK_Cliente()).get(0);
        Dao_Quarto buscarQ = new Dao_Quarto();
        Quarto quarto = buscarQ.buscarID(hospedagem.getFK_Quarto()).get(0);
        
        DateTime entrada = new DateTime(hospedagem.getCheckIn());
        DateTime saida = new DateTime(hospedagem.getCheckOut());
        int dias =  Days.daysBetween(entrada, saida).getDays() + 1;
        
        String Nota = "Nota de Check-Out\n";
        Nota += "===============\n";
        Nota += "Cliente: " + cliente.getNome() + "\n";
        Nota += "===============\n";
        Nota += "Hospedagem de " + dias + " dias no Quarto: " + quarto.getNumeroQuarto() + "\n";
        Nota += "Valor da Diária: " + quarto.getPrecoDiaria() + "\n";
        Nota += "Valor da Diária x Dias Hospedados: " + (quarto.getPrecoDiaria() * dias) + "\n";
        Nota += "\n===============\n";
        Nota += produtos;
        Nota += "\n===============\n";
        Nota +="VALOR TOTAL = " + (quarto.getPrecoDiaria() * dias + valorProdutos);
        
        txt_nota.setText(Nota);
        this.NotaRegistro = Nota;
        this.idCliente = cliente.getId();
        this.registroPrimordial = hospedagem;
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txt_nota = new javax.swing.JTextPane();
        jPanel1 = new javax.swing.JPanel();
        btn_final = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_nota.setEditable(false);
        txt_nota.setBackground(new java.awt.Color(255, 255, 102));
        txt_nota.setAutoscrolls(false);
        jScrollPane1.setViewportView(txt_nota);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 17, 370, 450));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_final.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/btn-finaliza-checkout-A.png"))); // NOI18N
        btn_final.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_final.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_finalMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_finalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_finalMouseExited(evt);
            }
        });
        jPanel1.add(btn_final, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 560));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_finalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_finalMouseEntered
        ImageIcon ii = new ImageIcon(getClass().getResource("/assets/btn-finaliza-checkout-B.png"));
        btn_final.setIcon( ii );
    }//GEN-LAST:event_btn_finalMouseEntered

    private void btn_finalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_finalMouseExited
        ImageIcon ii = new ImageIcon(getClass().getResource("/assets/btn-finaliza-checkout-A.png"));
        btn_final.setIcon( ii );
    }//GEN-LAST:event_btn_finalMouseExited

    private void btn_finalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_finalMouseClicked
        //Registramos LOG de Cupom
        Dao_Log registroLog = new Dao_Log();
        Log log = new Log();
        log.setLog(this.NotaRegistro);
        log.setFK_Cliente(this.idCliente);
        registroLog.Salvar(log);
        //Registramos a Saída em todas as Reservas
        Dao_Ocupacao registroOcupa = new Dao_Ocupacao();
        Ocupacao ocupacao = new Ocupacao();
        ocupacao.setCheckIn(registroPrimordial.getCheckIn());
        ocupacao.setCheckOut(registroPrimordial.getCheckOut());
        ocupacao.setFK_Cliente(registroPrimordial.getFK_Cliente());
        ocupacao.setFK_Quarto(registroPrimordial.getFK_Quarto());
        registroOcupa.salvarCheckOu(ocupacao);
        //Voltamos a Tela Inicial
        this.check = true;
        this.dispose();
    }//GEN-LAST:event_btn_finalMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_final;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane txt_nota;
    // End of variables declaration//GEN-END:variables
}
