package Model;

import Controller.Endereco;
import Controller.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
    
    //Método de Busca Unica por email
    public List<Usuario> buscarUnicaEmail(String email) {
        
        //Espaço para armazenar os dados
        List<Usuario> listar = new ArrayList<>();
        
        // Executa a SQL e captura o resultado da consulta
        String SQL = "SELECT * FROM usuario WHERE email = ?";
        
        try {
            PreparedStatement pst = connection.prepareStatement(SQL);
            
            //Definição de valores da Query
            pst.setString(1, email);
            
            //Executa a Query e armazena o resultado
            ResultSet rs = pst.executeQuery();
            
            // Cria um objeto para armazenar uma linha da consulta
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setNascimento(rs.getDate("dataNasc"));
                usuario.setCPF(rs.getString("cpf"));
                usuario.setTelefone(rs.getString("telefone"));
                usuario.setEmail(rs.getString("email"));
                usuario.setCargo(rs.getString("cargo"));
                usuario.setRemuneracao(rs.getDouble("remuneracao"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setNivel(rs.getInt("nivel"));
                
                //Realizando busca do Endereço e Armazenando o Objeto retornado com o FK_Endereco fornecido pelo Usuário
                usuario.setEndereco(new Dao_Endereco().buscarUnicaID(rs.getInt("FK_Endereco")).get(0));
                             
                // Armazena a linha lida em uma lista
                listar.add(usuario);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
        return listar;
    }
}
