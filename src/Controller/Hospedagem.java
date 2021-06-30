package Controller;

import java.sql.Date;

public class Hospedagem {
    private int id;
    private java.sql.Date check_IN;
    private java.sql.Date check_OUT;
    private int quarto;
    private String nome;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCheck_IN() {
        return check_IN;
    }

    public void setCheck_IN(Date check_IN) {
        this.check_IN = check_IN;
    }

    public Date getCheck_OUT() {
        return check_OUT;
    }

    public void setCheck_OUT(Date check_OUT) {
        this.check_OUT = check_OUT;
    }

    public int getQuarto() {
        return quarto;
    }

    public void setQuarto(int quarto) {
        this.quarto = quarto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
