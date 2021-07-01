package Model;

import Controller.Log;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Dao_Log extends Conexao{
    
    private final Connection connection;
    
    //Instanciando a conexão.
    public Dao_Log(){
        this.connection = new Conexao().getConnection();
    }
    
    //Método para inserir na tabela Logo
    public boolean Salvar(Log log){
        //string sql
        String sql = "INSERT INTO log (log, FK_Cliente, FK_Usuario) values (?,?,NULL)";
        
        PreparedStatement pst;
        
        try{
            pst = connection.prepareStatement(sql);
            
            pst.setString(1, log.getLog());
            pst.setInt(2, log.getFK_Cliente());
            
            pst.executeUpdate();
            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro interno: " + ex);
            return false;
        }        
    }
}
