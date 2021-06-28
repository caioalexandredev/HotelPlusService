package auxiliares;

import Controller.Ocupacao;
import Model.Dao_Ocupacao;
import Model.Dao_Usuario;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Validacao {
    public static boolean verificarCamposVazios(String campos[]){
        boolean retorno = true;
        for (String campo : campos) {
            if(campo.equals("")){
                retorno = false;
            }
        }
        return retorno;
    }
    
    public static boolean verificarExistenciaEmail(String email){
        return new Dao_Usuario().buscarUnicaEmail(email).isEmpty();
    }
    
    public static boolean verificarDataInvalida(String userData){
        boolean retorno = false;
        
        Date data = null;
        String dataTexto = new String(userData);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
                format.setLenient(false);
                data = format.parse(dataTexto);
        } catch (ParseException e) {
            retorno = true;
        }
        
        return retorno;
    }
    
    public static boolean verificarDataInvalidaLogica(String userData){
        boolean retorno = true;
        
        Date data1 = null;
        String dataTexto = new String(userData);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        
        Date hoje = new Date();
        try {
                format.setLenient(false);
                data1 = format.parse(dataTexto);
                retorno = data1.before(hoje);
                
                Calendar cal = Calendar.getInstance();
                // remove next line if you're always using the current time.
                cal.setTime(hoje);
                cal.set(Calendar.HOUR_OF_DAY, 0);
                cal.set(Calendar.MINUTE, 0);
                cal.set(Calendar.SECOND, 0);
                cal.set(Calendar.MILLISECOND, 0);
                Date today = cal.getTime();
                
                if(data1.equals(today)){
                    retorno = false;
                    System.out.println("SOCORRO");
                }
                
        } catch (ParseException e) {
            
        }
        
        return retorno;
    }
    
    public static boolean verficiarDisponibilidaEntreDatas(java.sql.Date Entrada, java.sql.Date Saida, int Quarto){
        boolean retorno = false;
        
        //Primeiro capaturamos as Ocupações Registradas que não obtiveram checkout ainda
        Dao_Ocupacao reserva = new Dao_Ocupacao();
        List<Ocupacao> reservas = reserva.buscarReservas(0);
        
        //Agora iremos verificar reservas por reservas
        for (int i = 0; i < reservas.size(); i++) {
            Ocupacao ocupa = reservas.get(i);
            if(ocupa.getCheckIn().getTime() > Entrada.getTime() && ocupa.getCheckIn().getTime() < Saida.getTime()){
                System.out.println("Data Ocupada");
            }
        }
        
        return retorno;
    }
}
