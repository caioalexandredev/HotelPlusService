
package Model;

import Controller.Endereco;
import Controller.Ocupacao;
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
    
    public List<Quarto> buscarGeral() {
        
        List<Quarto> listar = new ArrayList<>();
        
        String SQL = "SELECT * FROM quarto";
        try {
            PreparedStatement pst = connection.prepareStatement(SQL);
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
    
    //VEREFICAR DISPONIBILIDADE DO QUARTO NO DIA
    public List<Quarto> buscarDisponivelDia() {
        
        List<Quarto> listar = new ArrayList<>();
        
        String SQL = "SELECT * FROM quarto q WHERE q.id NOT IN (SELECT FK_Quarto FROM ocupacao WHERE 'check-in' != now())";
        try {
            PreparedStatement pst = connection.prepareStatement(SQL);
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
    
    public List<Quarto> buscarDisponivelEntreDadas(Ocupacao ocupacao) {
        //Espaço para armazenar os dados
        List<Quarto> listar = new ArrayList<>();
        // Executa a SQL e captura o resultado da consulta
        String SQL = "SELECT * FROM quarto q WHERE q.id NOT IN (SELECT `FK_Quarto` FROM `ocupacao` WHERE `check` = 0 and `reserva` BETWEEN ? AND ?)";
        try {
            PreparedStatement pst = connection.prepareStatement(SQL);
            //Definição de valores da Query
            pst.setDate(1, ocupacao.getCheckIn());
            pst.setDate(2, ocupacao.getCheckOut());
            //Executa a Query e armazena o resultado
            ResultSet rs = pst.executeQuery();
            // Cria um objeto para armazenar uma linha da consulta
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

