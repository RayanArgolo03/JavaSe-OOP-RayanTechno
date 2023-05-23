package com.classes.exercicios;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;

public class Empresa {

    //Lista de Funcionários 
    private List<Funcionario> funcionarios = new ArrayList<>();

    //Construtor
    public Empresa() {
    }

    //Getters e Setters
    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    //Opcional 
    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
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

    //toString Empresa
    @Override
    public String toString() {
        String s = "";

        s += "Nome da empresa: Rayan Techno" + "\n"
                + "Quantidade de funcionários: " + this.funcionarios.size();

        return s;
    }

    //Imprimir Menu de Opções de Funcionários para Add
    private String imprimirTipoFunc() {
        return JOptionPane.showInputDialog("Escolha o tipo de funcionário que deseja adicionar a RayanTechno: \n"
                + "1 - Funcionário Regular \n "
                + "2 - Gerente \n "
                + "3 - Diretor ");
    }

    //Verifica se a opc de funcionário é válida
    private boolean verificar(int opcFuncionario) {

        boolean opcValida = (opcFuncionario > 0 && opcFuncionario <= 3);

        return opcValida;
    }

    //Factory Method Criando Obj Funcionário 
    public Funcionario factoryFunc(int opcFunc) {
        Funcionario funcionario;

        //Casting caso Escalabilidade 
        switch (opcFunc) {
            case 1 -> {
                funcionario = (FuncionarioRegular) new FuncionarioRegular();
            }
            case 2 -> {
                funcionario = (Gerente) new Gerente();
            }
            default -> {
                funcionario = (Diretor) new Diretor();
            }
        }

        return funcionario;
    }

    //Adicionando Funcionário a lista
    public void adicionarFunc() {
        //Recebo a opção do Menu
        int opcFunc = Integer.valueOf(Integer.parseInt(imprimirTipoFunc()));

        //Verifico se funcionário é válido
        boolean opcValida = verificar(opcFunc);
        String nomeFuncao = "";

        if (opcValida) {

            //Switch Case para Add novo Func
            switch (opcFunc) {
                case Constantes.OPC_UM -> {
                    nomeFuncao = "Funcionário Regular";
                }
                case Constantes.OPC_DOIS -> {
                    nomeFuncao = "Gerente";
                }
                case Constantes.OPC_TRES -> {
                    nomeFuncao = "Diretor";
                }
            }

            //Coleta informações do Funcionário
            String nome = JOptionPane.showInputDialog("Digite o nome do " + nomeFuncao);

            String idade = JOptionPane.showInputDialog("Digite a idade do " + nomeFuncao);

            String salario = JOptionPane.showInputDialog("Digite o valor do salário do " + nomeFuncao);

            //Criando Funcionário e Add na Lista
            Funcionario funcionario = factoryFunc(opcFunc);
            
            funcionario.setNome(nome);
            funcionario.setIdade(Integer.valueOf(idade));
            funcionario.setSalario(Double.valueOf(salario));

            //Incrementador de Id            
            funcionario.setId();
            
            funcionarios.add(funcionario);
            
            JOptionPane.showMessageDialog(null, "O funcionário "+funcionario.getNome()+ " foi adicionado");
        } else {
            JOptionPane.showMessageDialog(null, "Opção de funcionário inválida!!");
        }
    }

    //Calcula média e soma dos salários 
    private List calcularFolha() {
        double soma = 0;
        double media = 0;

        List<Double> valores = new ArrayList<>();

        //Percorre todos os salários da empresa
        for (Funcionario funcionario : funcionarios) {
            soma += funcionario.getSalario();
        }

        media = soma / this.funcionarios.size();
        valores.add(soma);
        valores.add(media);

        return valores;
    }

    //Imprimir folha salarial da empresa
    public void imprimirFolhaSalarial() {

        List<Double> valores = calcularFolha();

        //Criando Moeda Brasileira
        Locale br = new Locale("pt", "BR");

        int opc = JOptionPane.showConfirmDialog(null, "Deseja vizualizar a folha salarial da empresa?");

        //Caso a pessoa deseje vizualizar
        if (opc == 0) {
            String totalValor = NumberFormat.getCurrencyInstance(br).format(valores.get(0));
            JOptionPane.showMessageDialog(null, "Folha da Rayan Techno: " + totalValor);
        }
        //Exibir Média - Opcional
        opc = JOptionPane.showConfirmDialog(null, "Deseja exibir a média de salários?");

        if (opc == 0) {
            String media = NumberFormat.getCurrencyInstance(br).format(valores.get(1));
            JOptionPane.showMessageDialog(null, "Média dos salários da Rayan Techno: " + media);
        }

    }
    
    //Imprimir Lista de Funcionários + Retorna Info do Funcionário
    public void imprimirListaFunc() {
        String opc = JOptionPane.showInputDialog("Digite o nome do funcionário: ");

        boolean nomeValido = false;

        for (Funcionario funcionario : funcionarios) {
            nomeValido = (opc.equalsIgnoreCase(funcionario.getNome()));

            if (nomeValido) {
                JOptionPane.showMessageDialog(null, funcionario.toString());
                break;
            }
        }

        if (!nomeValido) {
            JOptionPane.showMessageDialog(null, "Funcionário não encontrado!!");
        }
    }
}
