
package Model;

import Controller.Hospedagem;
import Controller.Ocupacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        String sql = "INSERT INTO `ocupacao` (`id`, `check-in`, `check-out`, `reserva`, `check`, `FK_Cliente`, `FK_Quarto`) VALUES (NULL, now(), ?, ?, ?, ?, ?)";
        PreparedStatement pst;
        
        try {
            pst = connection.prepareStatement(sql);
   
            pst.setDate(1, ocupacao.getCheckOut());
            pst.setDate(2, ocupacao.getReserva());
            pst.setBoolean(3, ocupacao.isCheck());
            pst.setInt(4, ocupacao.getFK_Cliente());
            pst.setInt(5, ocupacao.getFK_Quarto());

            pst.executeUpdate();
            pst.close();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro interno: " + ex);
            return false;
        }
    }
    
    public boolean salvarReserva(Ocupacao ocupacao){
        String sql = "INSERT INTO `ocupacao` (`id`, `check-in`, `check-out`, `reserva`, `check`, `FK_Cliente`, `FK_Quarto`) VALUES (NULL, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pst;
        
        try {
            pst = connection.prepareStatement(sql);
   
            pst.setDate(1, ocupacao.getCheckIn());
            pst.setDate(2, ocupacao.getCheckOut());
            pst.setDate(3, ocupacao.getReserva());
            pst.setBoolean(4, ocupacao.isCheck());
            pst.setInt(5, ocupacao.getFK_Cliente());
            pst.setInt(6, ocupacao.getFK_Quarto());

            pst.executeUpdate();
            pst.close();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro interno: " + ex);
            return false;
        }
    }
    
    public boolean salvarCheckOu(Ocupacao ocupacao){
        String sql = "UPDATE `ocupacao` SET `check`= 1 WHERE `check-in` = ? AND `check-out` = ? AND `FK_Cliente` = ? AND `FK_Quarto` = ?;";
        PreparedStatement pst;
        
        try {
            pst = connection.prepareStatement(sql);
   
            pst.setDate(1, ocupacao.getCheckIn());
            pst.setDate(2, ocupacao.getCheckOut());
            pst.setInt(3, ocupacao.getFK_Cliente());
            pst.setInt(4, ocupacao.getFK_Quarto());

            pst.executeUpdate();
            pst.close();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro interno: " + ex);
            return false;
        }
    }
    
    //Verificar se Reserva Existe no Quarto e Dia
    public boolean verificarReserva(int id, java.sql.Date date){
        String sql = "SELECT * FROM ocupacao WHERE FK_Quarto = ? AND `reserva` = ?";
        PreparedStatement pst;
        
        //Cria a lista de retorno
        List<Ocupacao> listar = new ArrayList<>();
        
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setDate(2, date);
            
            //Executa a Query e armazena o resultado
            ResultSet rs = pst.executeQuery();
            
            //Vamos chamar um resultado por vez dentro de um WHILE
            while(rs.next()){
                Ocupacao ocuapcao = new Ocupacao();
                ocuapcao.setId(rs.getInt("id"));
                listar.add(ocuapcao);
                this.idOcupacao = rs.getInt("id");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro interno: " + e);
        }
        return listar.isEmpty();
    }
    
    //Verificar se Reserva Existe no Dia e com o Cliente
    public boolean confirmarReserva(int id){
        String sql = "UPDATE `ocupacao` SET `check` = '1' WHERE `id` = ?;";
        PreparedStatement pst;
        
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro interno: " + e);
        }
        return true;
    }
    
    public List<Ocupacao> buscarReservas(int id) {
        
        //Espaço para armazenar os dados
        List<Ocupacao> listar = new ArrayList<>();
        // Executa a SQL e captura o resultado da consulta
        String SQL = "SELECT * FROM `ocupacao` WHERE`id` = ?";
        
        try {
            PreparedStatement pst = connection.prepareStatement(SQL);
            //Definição de valores da Query
            pst.setInt(1, id);
            //Executa a Query e armazena o resultado
            ResultSet rs = pst.executeQuery();
            // Cria um objeto para armazenar uma linha da consulta
            while (rs.next()) {
                Ocupacao ocupacao = new Ocupacao();
                ocupacao.setId(rs.getInt("id"));
                ocupacao.setCheckIn(rs.getDate("check-in"));
                ocupacao.setCheckOut(rs.getDate("check-out"));
                ocupacao.setReserva(rs.getDate("reserva"));
                ocupacao.setCheck(rs.getBoolean("check"));
                ocupacao.setFK_Cliente(rs.getInt("FK_Cliente"));
                ocupacao.setFK_Quarto(rs.getInt("FK_Quarto"));
                // Armazena a linha lida em uma lista
                listar.add(ocupacao);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
        return listar;
    }
    
    //Retornar Dados Tratados de Hospedagem
    public List<Hospedagem> hospedagem() {
        //Espaço para armazenar os dados
        List<Hospedagem> listar = new ArrayList<>();
        // Executa a SQL e captura o resultado da consulta
        String SQL = "SELECT * FROM `checkoutinfs`";
        
        try {
            PreparedStatement pst = connection.prepareStatement(SQL);
            //Executa a Query e armazena o resultado
            ResultSet rs = pst.executeQuery();
            // Cria um objeto para armazenar uma linha da consulta
            while (rs.next()) {
                Hospedagem hospedagem = new Hospedagem();
                hospedagem.setId(rs.getInt("id"));
                hospedagem.setCheck_IN(rs.getDate("check-in"));
                hospedagem.setCheck_OUT(rs.getDate("check-out"));
                hospedagem.setQuarto(rs.getInt("numeroQuarto"));
                hospedagem.setNome(rs.getString("nome"));
                // Armazena a linha lida em uma lista
                listar.add(hospedagem);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
        return listar;
    }
}
