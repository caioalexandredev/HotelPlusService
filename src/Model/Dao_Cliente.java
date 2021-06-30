
package Model;
import Controller.Cliente;
import Controller.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Dao_Cliente extends Conexao {
    
    private final Connection connection;
    
    //Instanciando a conexão.
    public Dao_Cliente(){
        this.connection = new Conexao().getConnection();
    }
    
    //Método para inserir na tabela Cliente
    public boolean Salvar(Cliente cliente, int idEndereco){
        //string sql
        String sql = "INSERT INTO cliente (nome, dataNasc, cpf, telefone, email, FK_Endereco) values (?,?,?,?,?,?)";
        
        PreparedStatement pst;
        
        try{
            pst = connection.prepareStatement(sql);
            
            pst.setString(1, cliente.getNome());
            pst.setDate(2, cliente.getDataNasc());
            pst.setString(3, cliente.getCpf());
            pst.setString(4, cliente.getTelefone());
            pst.setString(5, cliente.getEmail());
            pst.setInt(6, idEndereco);
            
            pst.executeUpdate();
            
            return true;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro interno: " + ex);
            //Se deu erro, retornando falso
            return false;
        }        
    }
    
    public List<Cliente> buscarClientePorID(int id){
    
        String sql = "SELECT * FROM cliente WHERE id = ?";
        
        PreparedStatement pst;
        
        List<Cliente> lista = new ArrayList<>();
        
        try{
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                lista.add(cliente);
            }
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Erro interno: " + ex);
          }
        return lista;
    }
    
    public List<Cliente> buscarClienteGeral(){
    
        String sql = "SELECT * FROM cliente";
        
        PreparedStatement pst;
        
        List<Cliente> lista = new ArrayList<>();
        
        try{
            pst = connection.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));                
                cliente.setEmail(rs.getString("email"));                
                cliente.setCpf(rs.getString("cpf"));                
                cliente.setDataNasc(rs.getDate("dataNasc"));                
                cliente.setTelefone(rs.getString("telefone"));                
                lista.add(cliente);
            }
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Erro interno: " + ex);
          }
        return lista;
    }
}
