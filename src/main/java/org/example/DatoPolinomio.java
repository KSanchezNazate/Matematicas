package org.example;

public class DatoPolinomio {
    private double valor;
    private int termino;

    // Constructor
    public DatoPolinomio(double valor, int termino) {
        this.valor = valor;
        this.termino = termino;
    }

    // Getters
    public double getValor() {
        return valor;
    }

    public int getTermino() {
        return termino;
    }

    public void setValo(double valor) {
        this.valor = valor;
    }
}
