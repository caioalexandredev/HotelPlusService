
package Controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Cliente {
    
    private int id;
    private String nome;
    private java.sql.Date dataNasc;
    private int cpf;
    private int telefone;
    private String email;
    
    public void inserirDadosCliente(int id, String nome, String dataNasc, int cpf, int telefone, String email) throws ParseException{
        
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        
        //Convertendo Data para Formato Aceito
        SimpleDateFormat sdf;
        sdf = new SimpleDateFormat("dd/MM/yyyy");
        java.sql.Date data;
        data = new java.sql.Date(sdf.parse(dataNasc).getTime());
        this.dataNasc = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
    
}
