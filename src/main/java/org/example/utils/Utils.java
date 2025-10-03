package org.example.utils;

public class Utils {
    public static int[][] generadorNotasFinales(int[][] listaNotas){
        int filas = listaNotas.length;
        int[][] notas = new int[filas][5];

        for (int i = 0; i < filas; i++){
            for (int j = 0; j < 3; j++){
                notas[i][j] = listaNotas[i][j];
            }

            int nota2 = notas[i][1];
            int nota1 = notas[i][0];
            int nota3 = notas[i][2];

            notas[i][3] = (nota2 < 60) ? 100 : nota2;
            notas[i][4] = ((nota1 + nota3 > 150) ? 95 : 70);

        }

        return notas;
    }

    public static void imprimirArray(int[] arr) {
        for (int v : arr) System.out.print(v + " ");
        System.out.println();
    }

    // Imprime matriz filas x columnas
    public static void imprimirMatriz(int[][] mat, String[] nombres) {
        for (int i = 0; i < mat.length; i++) {
            System.out.print(nombres[i] + ": ");
            imprimirArray(mat[i]);
        }
    }

    public static int[] ordenarDescConAux(int[] original) {
        int[] aux = new int[original.length];
        for (int i = 0; i < original.length; i++) aux[i] = original[i];

        for (int i = 0; i < aux.length - 1; i++) {
            int idxMax = i;
            for (int j = i + 1; j < aux.length; j++) {
                if (aux[j] > aux[idxMax]) idxMax = j;
            }
            // swap
            int temp = aux[i];
            aux[i] = aux[idxMax];
            aux[idxMax] = temp;
        }
        return aux;
    }

    public static int[] mayorSaltoYPos(int[] notas) {
        int maxSalto = 0;
        int posSegunda = 1;
        for (int i = 1; i < notas.length; i++) {
            int salto = Math.abs(notas[i] - notas[i - 1]);
            if (salto > maxSalto) {
                maxSalto = salto;
                posSegunda = i;
            }
        }
        return new int[]{maxSalto, posSegunda};
    }

    public static String estadoAprobacion(int[] notas) {
        int aprobadas = 0;
        for (int n : notas) if (n >= 60) aprobadas++;

        if (aprobadas == notas.length) return "Resultado: Aprobaste todas. ¡Backend Sensei!";
        else if (aprobadas == 0) return "Resultado: No aprobaste ninguna. ¡Sos un clon de frontend!";
        else return "Resultado: Algunas aprobadas. Sos un refactor en progreso.";
    }

    public static boolean esProgresivo(int[] notas) {
        for (int i = 1; i < notas.length; i++) {
            if (notas[i] <= notas[i - 1]) return false;
        }
        return true;
    }

}
