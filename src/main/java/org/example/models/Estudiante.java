package org.example.models;

public class Estudiante {
    private String name;
    private String legajo;
    private int[] notas = new int[5];

    public Estudiante(String name, String legajo, int[] notas) {
        this.name = name;
        this.legajo = legajo;
        this.notas = notas;
    }

    public int getTotal(){
        int total = 0;
        for (int nota : notas){
            total += nota;
        }
        return total;
    }

    public double getPromedio(){
        return getTotal() / 5d;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    public int[] getNotas() {
        return notas;
    }

    public void setNotas(int[] notas) {
        this.notas = notas;
    }
}
