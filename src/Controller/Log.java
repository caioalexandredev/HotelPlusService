package Controller;

public class Log {
    int id;
    String log;
    int FK_Cliente;
    int FK_Usuario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public int getFK_Cliente() {
        return FK_Cliente;
    }

    public void setFK_Cliente(int FK_Cliente) {
        this.FK_Cliente = FK_Cliente;
    }

    public int getFK_Usuario() {
        return FK_Usuario;
    }

    public void setFK_Usuario(int FK_Usuario) {
        this.FK_Usuario = FK_Usuario;
    }
}
