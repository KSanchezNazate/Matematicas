package org.example;

public class Polinomio {
    private Nodo terminoMayor;
    private int grado;

    // Constructor
    public Polinomio() {
        this.terminoMayor = null;
        this.grado = -1;
    }

    public void agregarTermino(int termino, double valor) {
        Nodo aux = new Nodo();
        DatoPolinomio dato = new DatoPolinomio(valor, termino);
        aux.setInfo(dato);

        if (termino > grado) {
            aux.setSig(terminoMayor);
            terminoMayor = aux;
            grado = termino;
        } else {
            Nodo actual = terminoMayor;
            while (actual.getSig() != null && termino < actual.getSig().getInfo().getTermino()) {
                actual = actual.getSig();
            }
            aux.setSig(actual.getSig());
            actual.setSig(aux);
        }
    }

    public void modificarTermino(int termino, double valor) {
        Nodo aux = terminoMayor;
        while (aux != null && aux.getInfo().getTermino() != termino) {
            aux = aux.getSig();
        }
        if (aux != null) {
            aux.getInfo().setValo(valor);
        }
    }

    public double obtenerValor(int termino) {
        Nodo aux = terminoMayor;
        while (aux != null && aux.getInfo().getTermino() > termino) {
            aux = aux.getSig();
        }
        if (aux != null && aux.getInfo().getTermino() == termino) {
            return aux.getInfo().getValor();
        } else {
            return 0;
        }
    }

    public static String mostrarPolinomio(Polinomio polinomio) {
        String polinomioString = "";
        Nodo aux = polinomio.terminoMayor;
        while (aux != null) {
            polinomioString += aux.getInfo().getValor() + "x^" + aux.getInfo().getTermino() + " + ";
            aux = aux.getSig();
        }
        return polinomioString;
    }

    public static String sumarPolinomios(Polinomio polinomio1, Polinomio polinomio2) {
        Polinomio polinomioResultado = new Polinomio();
        Nodo aux1 = polinomio1.terminoMayor;
        Nodo aux2 = polinomio2.terminoMayor;
        while (aux1 != null && aux2 != null) {
            if (aux1.getInfo().getTermino() == aux2.getInfo().getTermino()) {
                polinomioResultado.agregarTermino(aux1.getInfo().getTermino(), aux1.getInfo().getValor() + aux2.getInfo().getValor());
                aux1 = aux1.getSig();
                aux2 = aux2.getSig();
            } else if (aux1.getInfo().getTermino() > aux2.getInfo().getTermino()) {
                polinomioResultado.agregarTermino(aux1.getInfo().getTermino(), aux1.getInfo().getValor());
                aux1 = aux1.getSig();
            } else {
                polinomioResultado.agregarTermino(aux2.getInfo().getTermino(), aux2.getInfo().getValor());
                aux2 = aux2.getSig();
            }
        }
        while (aux1 != null) {
            polinomioResultado.agregarTermino(aux1.getInfo().getTermino(), aux1.getInfo().getValor());
            aux1 = aux1.getSig();
        }
        while (aux2 != null) {
            polinomioResultado.agregarTermino(aux2.getInfo().getTermino(), aux2.getInfo().getValor());
            aux2 = aux2.getSig();
        }
        return mostrarPolinomio(polinomioResultado);
    }

    public static Polinomio multiplicarPolinomios(Polinomio polinomio1, Polinomio polinomio2) {
        Polinomio polinomioResultado = new Polinomio();
        Nodo aux1 = polinomio1.terminoMayor;
        Nodo aux2 = polinomio2.terminoMayor;
        while (aux1 != null) {
            while (aux2 != null) {
                polinomioResultado.agregarTermino(aux1.getInfo().getTermino() + aux2.getInfo().getTermino(), aux1.getInfo().getValor() * aux2.getInfo().getValor());
                aux2 = aux2.getSig();
            }
            aux1 = aux1.getSig();
            aux2 = polinomio2.terminoMayor;
        }
        return polinomioResultado;
    }

    public static void agregarPolinomio(Polinomio polinomio, int termino, double valor) {
        polinomio.agregarTermino(termino, valor);
    }


}
