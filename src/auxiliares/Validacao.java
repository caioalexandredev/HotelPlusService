package auxiliares;

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
}
