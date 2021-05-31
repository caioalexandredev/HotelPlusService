package Model;

import Controller.Produtos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Dao_Produtos extends Conexao{
    
    private final Connection connection;
    
    public Dao_Produtos(){
        //Instanciamos a conexao paa uso posterior
        this.connection = new Conexao().getConnection();
    }
    
    //Método de Inserção na tabela de Produto
    public boolean Salvar(Produtos produto){
        //Primeiramente criamos um SQL
        String sql = "INSERT INTO (nome, preco) VALUES(?,?)";
        //Instaciamos o objeto que trabalha com o banco
        PreparedStatement pst;
        try {
            //Criamos o execultavel do banco
            pst = connection.prepareStatement(sql);
            //Configurando "?" postos no sql
            pst.setString(1, produto.getNome());
            pst.setDouble(2, produto.getPreco());
            //Agora vamos execultar o SQL
            pst.executeUpdate();
            //Fecha a conexão
            pst.close();
            //Return True = TUDO DEU CERTO IRRA
            return true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro interno: " + ex);
            //Se deu erro, retornando falso
            return false;
        }
    }
    
    //MÉTODO BUSCAR
    //UM FATOR DE BUSCA
    //SE VAI MULTIPLUS DADOS
    
    public List<Produtos> buscarViaID (int id){
        String sql = "SELECT * FROM produtos WHERE id = ?";
        PreparedStatement pst;
        
        //Cria a lista de retorno
        List<Produtos> listar = new ArrayList<>();
        
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            
            //Executa a Query e armazena o resultado
            ResultSet rs = pst.executeQuery();
            
            //Vamos chamar um resultado por vez dentro de um WHILE
            while(rs.next()){
                Produtos produto = new Produtos();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setPreco(rs.getDouble("preco"));
                listar.add(produto);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro interno: " + e);
        }
        return listar;
    }
}
