
package Controller;


public class Ocupacao {
    private int id;
    private String checkIn;
    private String checkOut;
    private String reserva;
    private int FK_Cliente;
    private int FK_Quarto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public String getReserva() {
        return reserva;
    }

    public void setReserva(String reserva) {
        this.reserva = reserva;
    }

    public int getFK_Cliente() {
        return FK_Cliente;
    }

    public void setFK_Cliente(int FK_Cliente) {
        this.FK_Cliente = FK_Cliente;
    }

    public int getFK_Quarto() {
        return FK_Quarto;
    }

    public void setFK_Quarto(int FK_Quarto) {
        this.FK_Quarto = FK_Quarto;
    }
    
    
}
