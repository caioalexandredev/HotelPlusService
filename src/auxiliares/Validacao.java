package auxiliares;

import Controller.Ocupacao;
import Model.Dao_Ocupacao;
import Model.Dao_Usuario;
import View.CheckIn;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.joda.time.DateTime;
import org.joda.time.Days;

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
    
    public static boolean verficiarDisponibilidaEntreDatas(String SaidaU, int Quarto){
        //Variavel de retorno
        boolean retorno = false;
        //Capturamos a data de Entrada
        DateTime entrada = auxiliares.Data.agora();
        try {
            //Capturamos a Data de Saida
            DateTime saida = auxiliares.Data.converterString(SaidaU);
            //Calculamos quantos dias de Reservas serão feitos
            int DiasReservas = Days.daysBetween(entrada, saida).getDays() + 1;
            //Variavel de Data Pecorrida
            DateTime pecorrido = entrada;
            //Fazemos Laço Pecorrendo Cada Data
            for(int i = 0; i < DiasReservas; i++){
                //Verificamos se existe reserva naquele dia e quarto
                Dao_Ocupacao ocupa = new Dao_Ocupacao();
                if(!ocupa.verificarReserva(Quarto, new java.sql.Date(pecorrido.toDate().getTime()))){
                    retorno = true;
                }
                //Pecorre o dia para o proximo laço
                pecorrido = auxiliares.Data.avancardia(pecorrido);
            }
        } catch (ParseException ex) {
            Logger.getLogger(CheckIn.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return retorno;
    }  
}
