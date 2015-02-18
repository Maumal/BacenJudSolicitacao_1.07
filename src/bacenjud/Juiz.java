/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bacenjud;

/**
 *
 * @author f7057419
 */
public class Juiz {

    private String nome;
    private String vara;
    private String tribunal;
    private String comarca;
    private String rua;
    private String cep;
    private String bairro;
    private String cidade;
    private String uf;
    private String id;
    private String protocolo;
    private String numeroBacen;

    public Juiz() {
    }

    public Juiz(String nome, String vara, String tribunal,String comarca, String rua, String cep, String bairro, String cidade, String uf,String protocolo,String numeroBacen, String id) {
        this.nome = nome;
        this.vara = vara;
        this.tribunal = tribunal;
        this.rua = rua;
        this.cep = cep;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;  
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getVara() {
        return vara;
    }

    public void setVara(String vara) {
        this.vara = vara;
    }

    public String getTribunal() {
        return tribunal;
    }

    public void setTribunal(String tribunal) {
        this.tribunal = tribunal;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getNumeroBacen() {
        return numeroBacen;
    }

    public void setNumeroBacen(String numeroBacen) {
        this.numeroBacen = numeroBacen;
    }

    public String getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
    }
       
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getComarca() {
        return comarca;
    }

    public void setComarca(String comarca) {
        this.comarca = comarca;
    }

    
}
