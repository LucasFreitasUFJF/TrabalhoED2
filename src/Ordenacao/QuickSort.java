package Ordenacao;

import java.util.ArrayList;
import java.util.Random;
import Trabalho.Metrica;
import Registros.Livro;

public class QuickSort {
    
    //INÍCIO - QUICKSORT RECURSIVO
    public static void ordena_Recursivo(Livro[] vetor){
        long tempoInicial = System.currentTimeMillis();
        quickSort_Recursivo(0, vetor.length-1, vetor);
        long tempoFinal = System.currentTimeMillis();
        Metrica.setTempo(tempoFinal-tempoInicial);
    }
    private static void  quickSort_Recursivo(int esq, int dir, Livro[] vetor){
        if(esq < dir){
            int pivo = particiona(esq, dir, vetor, vetor[esq]);
            quickSort_Recursivo(esq, pivo-1, vetor);
            quickSort_Recursivo(pivo+1, dir, vetor);
        }
    }
    //FINAL - QUICKSORT RECURSIVO
    
    //INÍCIO - QUICKSORT MEDIANA
    public static void ordena_Mediana(Livro[] vetor, int k) {
        long tempoInicial = System.currentTimeMillis();
        quickSort_Mediana(0, vetor.length-1, vetor, k);
        long tempoFinal = System.currentTimeMillis();
        Metrica.setTempo(tempoFinal-tempoInicial);
    }
    private static void quickSort_Mediana(int esq, int dir, Livro[] vetor, int k) {
        if(esq < dir) {
            int pivo = escolhePivo_Mediana(esq, dir, vetor, k);
            quickSort_Mediana(esq, pivo-1, vetor, k);
            quickSort_Mediana(pivo+1, dir, vetor, k);
        }
    }
    private static int escolhePivo_Mediana(int esq, int dir, Livro[] vetor, int k) {
        //Escolha do pivo através da mediana de k elementos aleatórios
        Livro pivo;
        if((dir-esq) > k) {
            Random random = new Random(System.currentTimeMillis());
            Livro[] auxPivo = new Livro[k];
            ArrayList<Integer> numAleatorios = new ArrayList();
            boolean existe;
            int aleatorio;
            for(int n=0; n<k; ){ //Escolhe k elementos eleatórios
                aleatorio = random.nextInt(dir-esq)+esq;
                existe = false;
                for(int l=0; l<numAleatorios.size(); l++) {
                    if(aleatorio == numAleatorios.get(l)) {
                        existe = true;
                    }
                }
                
                if(!existe) {
                    numAleatorios.add(aleatorio);
                    n++;
                }
            }
            Livro[] possiveisPivos = new Livro[k];
            for(int m=0; m<k; m++) {
                possiveisPivos[m] = vetor[numAleatorios.get(m)];
            }
            ordena_Recursivo(possiveisPivos); //Ordenação do vetor de possiveis pivos com o QuickSort Recursivo
            pivo = possiveisPivos[(k-1)/2]; //Escolhe o registro mediano
        } else { //Caso a partição seja menor que k, ele escolhe o primeiro elemento como pivo
            pivo = vetor[esq];
        }
        
        return particiona(esq, dir, vetor, pivo);
    }
    //FINAL - QUICKSORT MEDIANA
    
    //INÍCIO - QUICKSORT INSERÇÃO
    public static void ordena_Insercao(Livro[] vetor, int m) {
        long tempoInicial = System.currentTimeMillis();
        quickSort_Insercao(0, vetor.length-1, vetor, m);
        long tempoFinal = System.currentTimeMillis();
        Metrica.setTempo(tempoFinal-tempoInicial);
    }
    private static void quickSort_Insercao(int esq, int dir, Livro[] vetor, int m) {
        if (esq < dir){
            if ((dir - esq) <= m) {
                insertionSort(esq, dir+1, vetor);
            }
            else {
                int pivo = particiona(esq, dir, vetor, vetor[esq]);
                quickSort_Insercao(esq, pivo-1, vetor, m);
                quickSort_Insercao(pivo+1, dir, vetor, m);
            }
        }
    }
    private static void insertionSort(int esq, int dir, Livro[] vetor) {
        for (int i = esq + 1; i < dir; i++) {
            Livro pivo = vetor[i];
            Metrica.incrementaCopias();
            int j = i-1;
            while (j>=0 && ((vetor[j].getTitle().compareToIgnoreCase(pivo.getTitle()) > 0) && Metrica.incrementaComparacoes())) {
                vetor[j+1] = vetor[j];
                j--;
            }
            vetor[j+1] = pivo;
        }
    }
    //FINAL - QUICKSORT INSERÇÃO
    
    //Início - Funções de uso comum
    private static int particiona(int esq, int dir, Livro[] vetor, Livro pivo){
        int i = (esq);
        int j = dir;
        while (i <= j){
            if (vetor[i].getTitle().compareToIgnoreCase(pivo.getTitle()) <= 0 && Metrica.incrementaComparacoes()){
                i++;
            }
            else if (vetor[j].getTitle().compareToIgnoreCase(pivo.getTitle()) > 0 && Metrica.incrementaComparacoes()){
                j--;
            }
            else {
                troca(i, j, vetor);
                i++;
                j--;
            }
        }
        vetor[esq] = vetor[j];
        vetor[j] = pivo;
        return j;
    }

    private static void troca(int i, int j, Livro[] vetor) {
        Livro temp = vetor[i];
        Metrica.incrementaCopias();//Copia feita na linha anterior
        vetor[i] = vetor[j];
        vetor[j] = temp;
    }
    //Final - Funções de uso comum
}
