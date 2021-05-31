
package Model;

import Controller.Endereco;
import Controller.Quarto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class Dao_Quarto extends Conexao{
    
    private final Connection connection;
    
    public Dao_Quarto(){
        this.connection = new Conexao().getConnection();
    }
    

    public List<Quarto> buscarID(int id) {
        
        List<Quarto> listar = new ArrayList<>();
        
        String SQL = "SELECT * FROM quarto WHERE id = ?";
        
        try {
            PreparedStatement pst = connection.prepareStatement(SQL);
            
            pst.setInt(1, id);
            
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                Quarto quarto = new Quarto();
                
                quarto.setId(rs.getInt("id"));
                quarto.setNumeroQuarto(rs.getInt("numeroQuarto"));
                quarto.setTipo(rs.getString("tipo"));
                quarto.setPrecoDiaria(rs.getDouble("precoDiaria"));

                listar.add(quarto);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
        return listar;
    }
}

