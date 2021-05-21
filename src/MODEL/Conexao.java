
package MODEL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexao {
    
    private final String URL = "jdbc:mysql://localhost:3306/BD_HotelPlusService";
    private final String USER = "root";
    private final String PASS = "";
    
    
    public Connection getConnection(){
        
        try {
            return DriverManager.getConnection(URL, USER, PASS);
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro na conexão: ", ex);
        } 
    }
    
    public static void closeConnection(Connection con){
            try {
                if(con != null){
                con.close();
                } 
            } catch (SQLException ex) {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}