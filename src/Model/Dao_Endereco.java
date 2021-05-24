package Model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Controller.Endereco;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Dao_Endereco extends Conexao{
    
    private final Connection connection;
    public int IDInsercao;
    
    public Dao_Endereco(){
        this.connection = new Conexao().getConnection();
    }
    
    //Método de Inserção na tabela de endereço
    public boolean Salvar(Endereco endereco) {
        //Escrevemos a Regra SQL
        String sql = "INSERT INTO endereco (rua, numero, complemento, bairro, cidade, estado) VALUES(?,?,?,?,?,?)";
        //Chamamos a classe para preparar a chamada no Banco
        PreparedStatement pst;
        // Configuramos a chamada
        try{
            //Passamos parar a chamada o SQL que criamos e no segundo argumento que queremos retorno do ID criado na insercao
            pst = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            //Configurando "?" nos VALUES do SQL
            pst.setString(1, endereco.getRua());
            pst.setInt(2, endereco.getNumero());
            pst.setString(3, endereco.getComplemento());
            pst.setString(4, endereco.getBairro());
            pst.setString(5, endereco.getCidade());
            pst.setString(6, endereco.getEstado());
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
    
    //Método de Atualização na Tabela de Endereço
    public boolean Atualizar(Endereco endereco) {
        //Escrevemos a Regra SQL
        String sql = "UPDATE endereco SET rua = ?, numero = ?, complemento = ?, bairro = ?, cidade = ?, estado = ? WHERE id = ?";
        //Chamamos a classe para preparar a chamada no Banco
        PreparedStatement pst;
        // Configuramos a chamada
        try{
            //Passamos parar a chamada o SQL que criamos e no segundo argumento que queremos retorno do ID criado na insercao
            pst = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            //Configurando "?" nos VALUES do SQL
            pst.setString(1, endereco.getRua());
            pst.setInt(2, endereco.getNumero());
            pst.setString(3, endereco.getComplemento());
            pst.setString(4, endereco.getBairro());
            pst.setString(5, endereco.getCidade());
            pst.setString(6, endereco.getEstado());
            pst.setInt(7, endereco.getId());
            //Pegando o numero de linhas afetadas enquanto execultamos a chamada
            int affectedRows = pst.executeUpdate();
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
    
    //Método de Deleção de Endereço não ira existir devido o endereço estar ligado obrigatoriamente em diversas tabelas de usuarios e Clientes
    
    //Método de Busca Unica por ID
    public List<Endereco> buscarUnicaID(int id) {
        
        //Espaço para armazenar os dados
        List<Endereco> listar = new ArrayList<>();
        
        // Executa a SQL e captura o resultado da consulta
        String SQL = "SELECT * FROM Endereco WHERE id = ?";
        
        try {
            PreparedStatement pst = connection.prepareStatement(SQL);
            
            //Definição de valores da Query
            pst.setInt(1, id);
            
            //Executa a Query e armazena o resultado
            ResultSet rs = pst.executeQuery();
            
            // Cria um objeto para armazenar uma linha da consulta
            while (rs.next()) {
                Endereco endereco = new Endereco();
                endereco.setId(rs.getInt("id"));
                endereco.setRua(rs.getString("rua"));
                endereco.setNumero(rs.getInt("numero"));
                endereco.setComplemento(rs.getString("complemento"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setEstado(rs.getString("estado"));
                             
                // Armazena a linha lida em uma lista
                listar.add(endereco);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
        return listar;
    }
    
    /*Metodos de buscas mais Especificos podem ser adicionados mais tarde*/
}
