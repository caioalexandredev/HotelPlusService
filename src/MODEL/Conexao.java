
package MODEL;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;


public class Conexao {
    
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/BD_HotelPlusService";
    private final String USER = "root";
    private final String PASS = "";
    
    
    public Connection getConnection(){
        
        try {
            Class.forName(DRIVER);
            
            return DriverManager.getConnection(URL, USER, PASS);
            
        } catch (ClassNotFoundException | SQLException ex) {
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
    
    public static void closeConnection(Connection con, PreparedStatement stmt){
            
        closeConnection(con);
        
        try {
                if(stmt != null){
                stmt.close();
                } 
            } catch (SQLException ex) {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
            
        closeConnection(con, stmt);
        
        try {
                if(rs != null){
                rs.close();
                } 
            } catch (SQLException ex) {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }

 