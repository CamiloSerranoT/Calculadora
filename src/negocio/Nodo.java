/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author CAMILO
 */
public class Nodo {

    double dato;
    Nodo ant;
    Nodo sig;

    public Nodo() {
        ant = null;
        sig = null;
    }

    public Nodo(double dato) {
        this.dato = dato;
        this.ant = null;
        this.sig = null;
    }

    public double getDato() {
        return dato;
    }

    public void setDato(double dato) {
        this.dato = dato;
    }

    public Nodo getAnt() {
        return ant;
    }

    public void setAnt(Nodo ant) {
        this.ant = ant;
    }

    public Nodo getSig() {
        return sig;
    }

    public void setSig(Nodo sig) {
        this.sig = sig;
    }
}
