package org.example.services;

public class Comparador {

    public static String mejorPromedio(int[][] notas, String[] nombres){
        int filas = notas.length;
        double mejorProm = -1;
        int idMejor = 0;

        for (int i = 0; i < filas; i++){
            int suma = 0;
            for (int j = 0; j < notas[i].length; j++){
                suma += notas[i][j];
            }
            double prom = suma / 5d;

            if(prom > mejorProm){
                mejorProm = prom;
                idMejor = i;
            }
        }
        return nombres[idMejor];
    }

    public static String masRegular(int[][] notas, String[] nombres) {
        int filas = notas.length;
        int idx = 0;
        int menorDiferencia = Integer.MAX_VALUE;

        for (int i = 0; i < filas; i++) {
            int notaMax = notas[i][0];
            int notaMin = notas[i][0];

            for (int j = 1; j < notas[i].length; j++) {
                if (notas[i][j] > notaMax) {
                    notaMax = notas[i][j];
                }
                if (notas[i][j] < notaMin) {
                    notaMin = notas[i][j];
                }
            }

            int diferencia = notaMax - notaMin;

            if (diferencia < menorDiferencia) {
                menorDiferencia = diferencia;
                idx = i;
            }
        }

        return nombres[idx];
    }

    public static String peorEnTercera(int[][] notas, String[] nombres){
        int filas = notas.length;
        int peor = 0;
        int peorNota = notas[0][2];

        for (int i = 1; i < filas; i++) {
            if (notas[i][2] < peorNota) {
                peorNota = notas[i][2];
                peor = i;
            }
        }
        return nombres[peor];
    }

}
