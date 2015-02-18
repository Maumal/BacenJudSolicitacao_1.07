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
public class Processo {

    private String correio;
    private String protocolo;
    private String processo;
    private String data;
    private String valor;
    private String id;
   // private String gsv;

    public Processo() {
    }

    public Processo(String correio, String protocolo, String processo, String data, String valor,String id) {
        this.correio = correio;
        this.protocolo = protocolo;
        this.processo = processo;
        this.data = data;
        this.valor = valor;
    }

    public String getCorreio() {
        return correio;
    }

    public void setCorreio(String correio) {
        this.correio = correio;
    }

    public String getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
    }

    public String getProcesso() {
        return processo;
    }

    public void setProcesso(String processo) {
        this.processo = processo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    
    
    }
