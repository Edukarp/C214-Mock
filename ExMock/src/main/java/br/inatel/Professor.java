package br.inatel;

import java.util.*;

public class Professor {

    private String nome;
    private String horario;
    private String periodo;
    private int sala;
    private ArrayList<String> predio;

    public Professor(String nome, String horario, String periodo, int sala) {
        this.nome = nome;
        this.horario = horario;
        this.periodo = periodo;
        this.sala = sala;
        this.predio = new ArrayList<>();
        definirPredio();

    }

    private void definirPredio() {
        // Verifica o intervalo da sala e define o prédio
        if (sala >= 1 && sala <= 5) {
            predio.add("1");
        } else if (sala >= 6 && sala <= 10) {
            predio.add("2");
        } else if (sala >= 11 && sala <= 15) {
            predio.add("3");
        } else if (sala >= 16 && sala <= 20) {
            predio.add("4");
        } else {
            predio.add("6"); // Define "6" para outras salas fora dos intervalos especificados
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public ArrayList<String> getPredio() {
        return predio;
    }

    public void setPredio(ArrayList<String> predio) {
        this.predio = predio;
    }
}