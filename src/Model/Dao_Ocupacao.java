
package Model;

import Controller.Ocupacao;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;


public class Dao_Ocupacao extends Conexao {
    
    private final Connection connection;
    
    public Dao_Ocupacao(){
        this.connection = new Conexao().getConnection();
    }
    
    public boolean salvarCheckIn(Ocupacao ocupacao){

        String sql = "INSERT INTO ocupacao (check-in, FK_Cliente, FK_Quarto ) VALUES(?,?,?)";

        PreparedStatement pst;
        try {

            pst = connection.prepareStatement(sql);
   
            pst.setString(1, ocupacao.getCheckIn());
            pst.setInt(2, ocupacao.getFK_Cliente());
            pst.setInt(3, ocupacao.getFK_Quarto());

            pst.executeUpdate();

            pst.close();

            return true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro interno: " + ex);

            return false;
        }
    }
    
    public boolean salvarCheckOut(Ocupacao ocupacao){

        String sql = "INSERT INTO ocupacao (check-out, FK_Cliente, FK_Quarto ) VALUES(?,?,?)";

        PreparedStatement pst;
        try {

            pst = connection.prepareStatement(sql);
   
            pst.setString(1, ocupacao.getCheckOut());
            pst.setInt(2, ocupacao.getFK_Cliente());
            pst.setInt(3, ocupacao.getFK_Quarto());

            pst.executeUpdate();

            pst.close();

            return true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro interno: " + ex);

            return false;
        }
    }
    
    
}
