package Ordenacao;

import Trabalho.Metrica;
import Registros.Livro;

public class InsertionSort {
    
    public static void ordena(Livro[] vetor){
        long tempoInicial = System.currentTimeMillis();
        insertionSort(vetor, vetor.length);
        long tempoFinal = System.currentTimeMillis();
        Metrica.setTempo(tempoFinal-tempoInicial);
    }
    
    private static void insertionSort(Livro[] vetor, int n) {
        for(int i=1; i<n; i++){
            Livro pivo = vetor[i];
            Metrica.incrementaCopias();
            int j= i-1;
            while (j>=0 && ((vetor[j].getTitle().compareToIgnoreCase(pivo.getTitle()) > 0) && Metrica.incrementaComparacoes())) {
                vetor[j+1] = vetor[j];
                j--;
            }
            vetor[j+1] = pivo;
        }
    }
}
