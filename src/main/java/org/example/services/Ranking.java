package org.example.services;

public class Ranking {

    public static String evaluarNivelPorTotal(int total) {
        if (total < 250) return "Normie total 😢";
        else if (total < 350) return "Soft Chad";
        else if (total < 450) return "Chad";
        else return "Stone Chad definitivo 💪";
    }
}
