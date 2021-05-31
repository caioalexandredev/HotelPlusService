
package Controller;

public class Quarto {
    private int id;
    private int numeroQuarto;
    private String tipo;
    private Double precoDiaria;
    
    public void cadastrarQuarto(int id, int numero, String tipo, Double diaria){
        this.id = id;
        this.numeroQuarto = numero;
        this.tipo = tipo;
        this.precoDiaria = diaria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(int numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getPrecoDiaria() {
        return precoDiaria;
    }

    public void setPrecoDiaria(Double precoDiaria) {
        this.precoDiaria = precoDiaria;
    }
    
    
}
