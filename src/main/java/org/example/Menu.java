package org.example;

import java.util.Scanner;

public class Menu {

    public void mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        Polinomio p1 = new Polinomio();
        Polinomio p2 = new Polinomio();

        int opcion = 0;

        while (opcion != 5) {
            System.out.println("Selecciona una opción:");
            System.out.println("1. Agregar término a polinomio 1");
            System.out.println("2. Agregar término a polinomio 2");
            System.out.println("3. Sumar polinomios");
            System.out.println("4. Multiplicar polinomios");
            System.out.println("5. Salir");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Introduce el término: ");
                    int termino1 = sc.nextInt();
                    System.out.println("Introduce el valor: ");
                    double valor1 = sc.nextDouble();
                    p1.agregarTermino(termino1, valor1);
                    break;
                case 2:
                    System.out.println("Introduce el término: ");
                    int termino2 = sc.nextInt();
                    System.out.println("Introduce el valor: ");
                    double valor2 = sc.nextDouble();
                    p2.agregarTermino(termino2, valor2);
                    break;
                case 3:
                    System.out.println("El resultado de la suma es: ");
                    System.out.println(Polinomio.sumarPolinomios(p1, p2));
                    break;
                case 4:
                    System.out.println("El resultado de la multiplicación es: ");
                    System.out.println(Polinomio.mostrarPolinomio(Polinomio.multiplicarPolinomios(p1, p2)));
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida, por favor seleccione una opción válida.");
                    break;
            }
        }
    }
}
