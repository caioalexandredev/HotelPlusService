
package Model;

import Controller.Ponto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;


public class Dao_Ponto extends Conexao {
    
    private final Connection connection;
    
    public Dao_Ponto(){
        this.connection = new Conexao().getConnection();
    }
    
    public boolean Salvar(Ponto ponto){

        String sql = "INSERT INTO ponto (FK_Usuario, datahora) VALUES(?,now())";

        PreparedStatement pst;
        try {

            pst = connection.prepareStatement(sql);
   
            pst.setInt(1, ponto.getFK_Usuario());

            pst.executeUpdate();

            pst.close();

            return true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro interno: " + ex);

            return false;
        }
    }
    
    
    
    
}
