
package com.classes.exercicios;

public class Diretor extends Funcionario {

    //Construtor
    public Diretor() {
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
        final Diretor other = (Diretor) obj;
        return true;
    }

    //toString Diretor
    @Override
    public String toString() {

        return "Nome do Funcionário: " + super.getNome() + "\n"
                + "Tipo: Diretor" + "\n"
                + "Id do Funcionário: " + super.getId() + "\n"
                + "Idade do Funcionário: " + super.getIdade() + "\n"
                + "Salário: " + super.getSalario();
    }
}
