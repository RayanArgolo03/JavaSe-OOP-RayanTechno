package com.executavel.exercicios;

import com.classes.exercicios.Constantes;
import com.classes.exercicios.Empresa;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        //Main
        Empresa empresa = new Empresa();
        Main.escolherOpc(empresa);

    }

    //Imprimir Menu - Retorna Opç Selecionada
    public static final int imprimirMenu() {
        String aux = JOptionPane.showInputDialog(null, "------ Bem vindo a RayanTechno!! ------\n 0 - Sair \n 1 - Adicionar Funcionários a lista \n 2 - Calcular Folha de Pagamento da Empresa \n 3- Exibir informações do Funcionário");
        int opcMenu = Integer.valueOf(Integer.parseInt(aux));
        return opcMenu;
    }

    //Receber informações do Menu e chamar Mensagens 
    public static final void escolherOpc(Empresa empresa) {

        int opcMenu = 0;

        do {
            opcMenu = imprimirMenu();

            switch (opcMenu) {
                case Constantes.OPC_UM -> {
                    empresa.adicionarFunc();
                }
                case Constantes.OPC_DOIS -> {
                    //Null Pointer Exception - Se tiverem funcionários
                    if (!empresa.getFuncionarios().isEmpty()) {
                        empresa.imprimirFolhaSalarial();
                    } else {
                        JOptionPane.showMessageDialog(null, "Não existem funcionários! Adicione funcionários a empresa!!");
                    }
                }
                case Constantes.OPC_TRES -> {
                    //Null Pointer Exception - Se tiverem funcionários
                    if (!empresa.getFuncionarios().isEmpty()) {
                        empresa.imprimirListaFunc();
                    } else {
                        JOptionPane.showMessageDialog(null, "Sem funcionários na empresa, adicione funcionários!!");
                    }

                }
            }

        } while (opcMenu != 0);

        //Thank You :)
        if (opcMenu == 0) {
            JOptionPane.showMessageDialog(null, "Obrigado pelo Teste / Thank you :)");
        }
    }

}
