
package Controller;
import java.sql.Date;

public class Ocupacao {
    private int id;
    private Date checkIn;
    private Date checkOut;
    private Date reserva;
    private boolean check;
    private int FK_Cliente;
    private int FK_Quarto;

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public Date getReserva() {
        return reserva;
    }

    public void setReserva(Date reserva) {
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
