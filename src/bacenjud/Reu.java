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
public class Reu {
     private String cpf;
     private String nome;
    //private String mci; 
     private String agencia;
     private String pso;
     private String id;

    public Reu() {
    }

    public Reu(String cpf, String nome,  String agencia, String id) {
        this.cpf = cpf;
        this.nome = nome;    
        this.agencia = agencia;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

//    public String getMci() {
//        return mci;
//    }
//
//    public void setMci(String mci) {
//        this.mci = mci;
//    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }
       
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return getId();      
      
    }

    public String getPso() {
        return pso;
    }

    public void setPso(String pso) {
        this.pso = pso;
    }
    
    
    
    
    
}
