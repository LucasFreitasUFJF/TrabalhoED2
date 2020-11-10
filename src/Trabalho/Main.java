package Trabalho;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        OpcoesMenu opcoesMenu = new OpcoesMenu();
        Scanner input = new Scanner(System.in);
        int opcao = -1;
        
        while(opcao != 0) {
            System.out.println("Book  Depository Dataset");
            System.out.println("Escolha sua opção:");
            System.out.println("1 - Parte 1");
            System.out.println("2 - Parte 2");
            System.out.println("3 - Parte 3");
            System.out.println("0 - Salvar e Sair");
            opcao = input.nextInt();
            
            switch(opcao) {
                case 1: opcoesMenu.executarParte1();
                        break;
                case 2: opcoesMenu.executarParte2();
                        break;
                case 3: System.out.println("Parte 3 ainda não implementada");
                        break;
                case 0: opcoesMenu.closeEscrita();
                        break;
                        
                default: System.out.println("Opção inválida!");
            }
        }
    }  
}
