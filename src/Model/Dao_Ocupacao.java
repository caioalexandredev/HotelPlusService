
package Model;

import Controller.Ocupacao;
import Controller.Produtos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;


public class Dao_Ocupacao extends Conexao {
    
    private final Connection connection;
    public int idOcupacao;
    
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
    
    //Verificar se Reserva Existe no Dia e com o Cliente
    public boolean verificarReserva(int id, java.sql.Date date){
        String sql = "SELECT * FROM ocupacao WHERE FK_Cliente = ? AND `check-in` = ? AND `check` = ?";
        PreparedStatement pst;
        
        //Cria a lista de retorno
        List<Ocupacao> listar = new ArrayList<>();
        
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setDate(2, date);
            pst.setBoolean(3, false);
            
            //Executa a Query e armazena o resultado
            ResultSet rs = pst.executeQuery();
            
            //Vamos chamar um resultado por vez dentro de um WHILE
            while(rs.next()){
                Ocupacao ocuapcao = new Ocupacao();
                ocuapcao.setId(rs.getInt("id"));
                listar.add(ocuapcao);
                this.idOcupacao = rs.getInt("id");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro interno: " + e);
        }
        return !listar.isEmpty();
    }
    
    //Verificar se Reserva Existe no Dia e com o Cliente
    public boolean confirmarReserva(int id){
        String sql = "UPDATE `ocupacao` SET `check` = '1' WHERE `id` = ?;";
        PreparedStatement pst;
        
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro interno: " + e);
        }
        return true;
    }
    
}
