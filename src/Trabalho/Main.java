package trabalho;

import java.io.IOException;
import java.util.Scanner;

public class Trabalho {
    public static void main(String[] args) throws IOException {
        OpcoesMenu opcoesMenu = new OpcoesMenu();
        Scanner input = new Scanner(System.in);
        int opcao = -1;
        
        while(opcao != 0) {
            System.out.println("Book  Depository Dataset");
            System.out.println("Escolha sua opção:");
            System.out.println("1 - Parte 1, Cenário 1");
            System.out.println("2 - Parte 1, Cenário 2");
            System.out.println("3 - Parte 1, Cenário 3");
            System.out.println("4 - Parte 1, Cenário 4");
            System.out.println("5 - Parte 2");
            System.out.println("0 - Salvar e Sair");
            opcao = input.nextInt();
            
            switch(opcao) {
                case 1: opcoesMenu.executarParte1Cenario1();
                        break;
                case 2: int[] k = new int[2];
                        k[0] = 3; k[1] = 5;
                        int[] m = new int[2];
                        m[0] = 10; m[1] = 100;
                        opcoesMenu.executarParte1Cenario2(k, m);
                        break;
                case 3: opcoesMenu.executarParte1Cenario3();
                        break;
                case 4: //opcoesMenu.executarParte1Cenario4();
                        break;
                case 5: //opcoesMenu.executarParte2();
                        break;
                case 0: opcoesMenu.closeEscrita();
                        break;
                        
                default: System.out.println("Opção inválida!");
            }
        }
    }  
}
