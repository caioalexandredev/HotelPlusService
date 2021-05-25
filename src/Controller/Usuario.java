package Controller;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class Usuario {
    private int id;
    private String nome;
    private java.sql.Date nascimento;
    private String CPF;
    private String telefone;
    private String email;
    private String cargo;
    private double remuneracao;
    private Endereco endereco;
    private String senha;
    private int nivel;
    
    public void inserirDados(String nome, String email, String telefone, String cargo, String nascimento, String CPF, Endereco endereco) throws ParseException{
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cargo = cargo;
        this.CPF = CPF;
        this.endereco = endereco;
        
        //Convertendo Data para Formato Aceito
        SimpleDateFormat sdf;
        sdf = new SimpleDateFormat("dd/MM/yyyy");
        java.sql.Date data;
        data = new java.sql.Date(sdf.parse(nascimento).getTime());
        this.nascimento = data;
        
        //Dados padrão a serem definidos pelo Adminsitrador no aceite do Cadastro
        this.remuneracao = 0;
        this.senha = "";
        this.nivel = 0;
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

    public java.sql.Date getNascimento() {
        return nascimento;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getRemuneracao() {
        return remuneracao;
    }

    public void setRemuneracao(double remuneracao) {
        this.remuneracao = remuneracao;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
    
}
