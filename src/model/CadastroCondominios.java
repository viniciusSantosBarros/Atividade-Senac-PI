package model;

import java.time.LocalDate;

public class CadastroCondominios {
    
    private int id;
    private String nome;
    private String endereco;
    private String numero;
    private String sindico;
    private String numeroAp;
    private LocalDate ultimaAssembleia;
    private LocalDate proximaAssembleia;
    private double contaPagar;
    private double contaReceber;
    private double multa;

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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getSindico() {
        return sindico;
    }

    public void setSindico(String sindico) {
        this.sindico = sindico;
    }

    public String getNumeroAp() {
        return numeroAp;
    }

    public void setNumeroAp(String numeroAp) {
        this.numeroAp = numeroAp;
    }

    public LocalDate getUltimaAssembleia() {
        return ultimaAssembleia;
    }

    public void setUltimaAssembleia(LocalDate ultimaAssembleia) {
        this.ultimaAssembleia = ultimaAssembleia;
    }

    public LocalDate getProximaAssembleia() {
        return proximaAssembleia;
    }

    public void setProximaAssembleia(LocalDate proximaAssembleia) {
        this.proximaAssembleia = proximaAssembleia;
    }

    public double getContaPagar() {
        return contaPagar;
    }

    public void setContaPagar(double contaPagar) {
        this.contaPagar = contaPagar;
    }

    public double getContaReceber() {
        return contaReceber;
    }

    public void setContaReceber(double contaReceber) {
        this.contaReceber = contaReceber;
    }

    public double getMulta() {
        return multa;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }
    
    
            
    
}
