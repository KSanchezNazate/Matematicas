package org.example;

public class Nodo {
    private DatoPolinomio info;
    private Nodo sig;

    // Constructor
    public Nodo() {
        this.info = null;
        this.sig = null;
    }

    // Getters y Setters
    public DatoPolinomio getInfo() {
        return info;
    }

    public void setInfo(DatoPolinomio info) {
        this.info = info;
    }

    public Nodo getSig() {
        return sig;
    }

    public void setSig(Nodo sig) {
        this.sig = sig;
    }
}
