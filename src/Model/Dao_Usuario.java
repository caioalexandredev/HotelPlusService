package Model;

import Controller.Endereco;
import Controller.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Dao_Usuario {
    private final Connection connection;
    public int IDInsercao;
    
    public Dao_Usuario(){
        this.connection = new Conexao().getConnection();
    }
    
    //Método de Inserção na tabela de Usuario
    public boolean Salvar(Usuario usuario, int idEndereco) {
        //Escrevemos a Regra SQL
        String sql = "INSERT INTO usuario (nome, dataNasc, cpf, telefone, email, cargo, remuneracao, senha, nivel, FK_Endereco) VALUES(?,?,?,?,?,?,?,?,?,?)";
        //Chamamos a classe para preparar a chamada no Banco
        PreparedStatement pst;
        // Configuramos a chamada
        try{
            //Passamos parar a chamada o SQL que criamos e no segundo argumento que queremos retorno do ID criado na insercao
            pst = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            //Configurando "?" nos VALUES do SQL
            pst.setString(1, usuario.getNome());
            pst.setDate(2, usuario.getNascimento());
            pst.setString(3, usuario.getCPF());
            pst.setString(4, usuario.getTelefone());
            pst.setString(5, usuario.getEmail());
            pst.setString(6, usuario.getCargo());
            pst.setDouble(7, usuario.getRemuneracao());
            pst.setString(8, usuario.getSenha());
            pst.setInt(9, usuario.getNivel());
            pst.setInt(10, idEndereco);
            //Pegando o numero de linhas afetadas enquanto execultamos a chamada
            int affectedRows = pst.executeUpdate();
            //Guardando ultimo ID Criado (Fazemos isso pois precisaremos de ID para utilizar na Inserção de Usuário (Chave Estrangeira do Endereço)
            ResultSet result = pst.getGeneratedKeys();
            if(result.next() && result != null){
                 this.IDInsercao =  result.getInt(1);
            }
            //Fechando a chamada no banco
            pst.close();
            //Caso houver algum erro vai retornar falso (pois se nenhuma linha foi afetada, houve erro)
            return affectedRows != 0;
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro interno: " + ex);
            //Se deu erro, retornando falso
            return false;
        }
    }
}
