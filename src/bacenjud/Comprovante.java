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
public class Comprovante {
    private String Comprovante;
    private String id;

    public Comprovante() {
    }

    public Comprovante(String Comprovante, String id) {
        this.Comprovante = Comprovante;
        this.id = id;
    }

    public String getComprovante() {
        return Comprovante;
    }

    public void setComprovante(String Comprovante) {
        this.Comprovante = Comprovante;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
    
    
}
