package auxiliares;

import Model.Dao_Usuario;

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
}
