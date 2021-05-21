
package MODEL;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;

public class TestarConexao extends Conexao{

    public static void main(String[] args){
        
        try{
            new Conexao().getConnection();
            JOptionPane.showMessageDialog(null, "Conectado com sucesso!");
        } catch (HeadlessException erro){
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
          }
          
        
    }
}
