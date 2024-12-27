package com.rggt.edutectno.bootcamp.certificacion.parte2;

import java.util.Scanner;

public abstract  class MenuTemplate {
    Scanner leer = new Scanner(System.in);
    Integer op;

    public abstract void newCarrera();
    public abstract void totalAlumno();

    public final void algorit() {
        do {
            System.out.println("=== Algoritmo ===");
            System.out.println("1. Ingresar nueva carrera y director");
            System.out.println("2. Calcular total de alumnos por carrera");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            op = leer.nextInt();
            leer.nextLine();

            switch (op) {

                case 1: newCarrera();
                    break;
                case 2: totalAlumno();
                    break;
                case 0: System.out.println("Saliendo del programa...");
                    break;
                default:
                System.out.println("Opción no válida.");
            }
        } while (op != 0);
        leer.close();
    }
    }

