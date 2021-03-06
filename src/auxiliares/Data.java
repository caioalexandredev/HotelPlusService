
package auxiliares;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import org.joda.time.DateTime;

public class Data {
    public static DateTime agora(){
        DateTime entrada = new DateTime();
        Calendar cal = entrada.toCalendar(Locale.getDefault());
        cal.set(Calendar.HOUR_OF_DAY, 00);
        cal.set(Calendar.MINUTE, 00);
        cal.set(Calendar.SECOND, 00);
        cal.set(Calendar.MILLISECOND, 00);
        return new DateTime(cal);
    }
    
    public static DateTime converterString(String datatexto) throws ParseException{
        SimpleDateFormat sdf;
        sdf = new SimpleDateFormat("dd/MM/yyyy");
        DateTime saida = new DateTime(sdf.parse(datatexto).getTime());
        Calendar cal = saida.toCalendar(Locale.getDefault());
        cal.set(Calendar.HOUR_OF_DAY, 00);
        cal.set(Calendar.MINUTE, 00);
        cal.set(Calendar.SECOND, 00);
        cal.set(Calendar.MILLISECOND, 00);
        return new DateTime(cal);
    }
    
    public static DateTime avancardia(DateTime data){
        Calendar cal;
        cal = data.toCalendar(Locale.getDefault());
        cal.add(Calendar.DATE, 1);
        return new DateTime(cal);
    }
    
    public static boolean verificarSeUtrapassa(String data1, String data2) throws ParseException{
        DateTime dataV1 = converterString(data1);
        DateTime dataV2 = converterString(data2);
        return dataV1.isAfter(dataV2);
    }
    
    public static boolean verificarMesmoDia(String data1, String data2) throws ParseException{
        DateTime dataV1 = converterString(data1);
        DateTime dataV2 = converterString(data2);
        return dataV1.isEqual(dataV2);
    }
    
    public static boolean verificarSeUtrapassaHoje(String data1) throws ParseException{
        DateTime dataV1 = converterString(data1);
        DateTime dataV2 = agora();
        return dataV1.isAfter(dataV2);
    }
}
