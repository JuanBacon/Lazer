/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Juand
 */
public class Tarjeta {
    String Texto;
    int Granja, Iglesia, Milicia, Burguesia; 
    int tipo;
    
    

    public Tarjeta(String Texto, int Granja, int Iglesia, int Milicia, int Burguesia, int tipo) {
        this.Texto = Texto;
        this.Granja = Granja;
        this.Iglesia = Iglesia;
        this.Milicia = Milicia;
        this.Burguesia = Burguesia;
        this.tipo = tipo;
        
    }

    public String getTexto() {
        return Texto;
    }

    public void setTexto(String Texto) {
        this.Texto = Texto;
    }

    public int getGranja() {
        return Granja;
    }

    public void setGranja(int Granja) {
        this.Granja = Granja;
    }

    public int getIglesia() {
        return Iglesia;
    }

    public void setIglesia(int Iglesia) {
        this.Iglesia = Iglesia;
    }

    public int getMilicia() {
        return Milicia;
    }

    public void setMilicia(int Milicia) {
        this.Milicia = Milicia;
    }

    public int getBurguesia() {
        return Burguesia;
    }

    public void setBurguesia(int Burguesia) {
        this.Burguesia = Burguesia;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

}