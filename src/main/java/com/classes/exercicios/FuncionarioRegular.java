
package com.classes.exercicios;


public class FuncionarioRegular extends Funcionario {
    
    //Construtor FuncionarioRegular 
    public FuncionarioRegular() {    
    }

    
    //Equals e HashCode
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
        final FuncionarioRegular other = (FuncionarioRegular) obj;
        return true;
    }
    
    
    
    //toString FuncionarioRegular
    @Override
    public String toString() {
        return "Nome do Funcionário: " + super.getNome() + "\n"
                + "Tipo: Funcionário Regular" + "\n"
                + "Id do Funcionário: " + super.getId() + "\n"
                + "Idade do Funcionário: " + super.getIdade() + "\n"
                + "Salário: " + super.getSalario();
    }
}
