package com.classes.exercicios;

public class Gerente extends Funcionario {

    //Construtor Gerente
    public Gerente() {
    }

    //Equals e Hash Code
    @Override
    public int hashCode() {
        return super.hashCode(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
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
        final Gerente other = (Gerente) obj;
        return true;
    }

    //toString Gerente
    @Override
    public String toString() {
        return "Nome do Funcionário: " + super.getNome() + "\n"
                + "Tipo: Gerente" + "\n"
                + "Id do Funcionário: " + super.getId() + "\n"
                + "Idade do Funcionário: " + super.getIdade() + "\n"
                + "Salário: " + super.getSalario();
    }

}
