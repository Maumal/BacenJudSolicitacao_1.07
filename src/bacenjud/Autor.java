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
public class Autor {

    private String nBanco;
    private String banco;
    private String agencia;
    private String nome;
    private String id;

    public Autor() {
    }

    public Autor(String nBanco, String banco, String agencia, String nome,String id) {
        this.nBanco = nBanco;
        this.banco = banco;
        this.agencia = agencia;
        this.nome = nome;
    }

    public String getnBanco() {
        return nBanco;
    }

    public void setnBanco(String nBanco) {
        this.nBanco = nBanco;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
    
    
    
    

}
