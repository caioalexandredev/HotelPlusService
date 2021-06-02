
package Controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Cliente {
    
    private int id;
    private String nome;
    private java.sql.Date dataNasc;
    private String cpf;
    private String telefone;
    private String email;
    private Endereco endereco;
    
    public void inserirDadosCliente(String nome, String email, String telefone, String dataNasc, String cpf, Endereco end) throws ParseException{
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.endereco = end;
        
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
    
}
