package br.unoeste.imccalculatorfx.entity;

import java.io.Serializable;

public class Pessoa implements Serializable {
    private String nome;
    private int peso;
    private double altura;
    private double imc;

    public Pessoa(String nome, int peso, double altura, double imc) {
        this.nome = nome;
        this.peso = peso;
        this.altura = altura;
        this.imc = imc;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }
}
