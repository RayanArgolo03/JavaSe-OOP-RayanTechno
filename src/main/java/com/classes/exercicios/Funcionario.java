package com.classes.exercicios;

import java.util.Objects;

public abstract class Funcionario {

    private String nome;
    private int idade;
    private double salario;
    private static int ultimoId = 0;
    private int id = 0;

    //Construtor 
    public Funcionario() {
    }

    //Getters and Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getId() {
        return id;
    }

    public void setId() {
        this.id = atualizaUltimoId();
    }

    public static int getUltimoId() {
        return ultimoId;
    }

    public static int atualizaUltimoId() {
        ultimoId++;
        return ultimoId;
    }

    //Equals e HashCode
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.nome);
        hash = 43 * hash + this.idade;
        hash = 43 * hash + (int) (Double.doubleToLongBits(this.salario) ^ (Double.doubleToLongBits(this.salario) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Funcionario other = (Funcionario) obj;
        if (this.idade != other.idade) {
            return false;
        }
        if (Double.doubleToLongBits(this.salario) != Double.doubleToLongBits(other.salario)) {
            return false;
        }
        return Objects.equals(this.nome, other.nome);
    }

    //toString
    @Override
    public abstract String toString();

}
