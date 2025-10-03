package org.example;

import org.example.utils.Utils;
import org.example.services.Comparador;
import org.example.services.Ranking;

public class Main {
    public static void main(String[] args) {
        String[] nombres = {"Juan", "Ana", "Carlos", "Luisa"};
        int[][] notas = {
                {80, 55, 95, 0, 0},
                {70, 85, 65, 0, 0},
                {50, 40, 60, 0, 0},
                {90, 92, 93, 0, 0}
        };

        int filas = notas.length;


        notas = Utils.generadorNotasFinales(notas);

        System.out.println("Notas finales (cada fila = estudiante):");
        Utils.imprimirMatriz(notas, nombres);

        System.out.println("\n--- Evaluaciones por estudiante ---");
        for (int i = 0; i < filas; i++) {
            System.out.println("\nEstudiante: " + nombres[i]);
            int[] misNotas = notas[i];

            System.out.println(Utils.estadoAprobacion(misNotas));

            int[] saltoPos = Utils.mayorSaltoYPos(misNotas);
            System.out.println("Mayor salto fue de " + saltoPos[0] +
                    " puntos entre la prueba " + (saltoPos[1]) +
                    " y la prueba " + (saltoPos[1] + 1) + ".");

            // 3) Bonus por progreso
            if (Utils.esProgresivo(misNotas)) {
                System.out.println("¡Nivel PROGRESIVO! Sos un Stone Chad en crecimiento 📈");
            }

            int[] ordenadas = Utils.ordenarDescConAux(misNotas);
            System.out.print("Notas ordenadas (desc): ");
            Utils.imprimirArray(ordenadas);

            int total = 0;
            for (int notaParcial : misNotas) total += notaParcial;
            System.out.println("Total: " + total + " -> " + Ranking.evaluarNivelPorTotal(total));
        }

        System.out.println("\n--- Ranking de la clase ---");
        System.out.println("Mejor promedio: " + Comparador.mejorPromedio(notas, nombres));
        System.out.println("Más regular: " + Comparador.masRegular(notas, nombres));
        System.out.println("Peor en 3ra prueba: " + Comparador.peorEnTercera(notas, nombres));
    }
}