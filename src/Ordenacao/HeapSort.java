package Ordenacao;

import Trabalho.Metrica;
import Registros.Livro;

public class HeapSort {
    
    public static void ordena(Livro[] vetor) {
        long tempoInicial = System.currentTimeMillis();
        heapSort(vetor, vetor.length);
        long tempoFinal = System.currentTimeMillis();
        Metrica.setTempo(tempoFinal-tempoInicial);
    }
    
    private static void heapSort(Livro[] vetor, int n) {
        buildMaxHeap(vetor, n);
        for(int i=n-1; i>0; i--) {
            trocar(0, i, vetor);
            maxHeapify(vetor, 0, i);
        }
    }
    
    private static void buildMaxHeap(Livro[] vetor, int n) {
        for(int i=n/2 - 1; i>=0; i--) {
            maxHeapify(vetor, i, n);
        }
    }
    
    private static void maxHeapify(Livro[] vetor, int i, int n) {
        int m = i; 
        int l = 2*i + 1; // left 
        int r = 2*i + 2; // right

        if (l < n && (vetor[l].getTitle().compareToIgnoreCase(vetor[i].getTitle()) > 0 && Metrica.incrementaComparacoes())) {
            m = l; 
        }

        if (r < n && vetor[r].getTitle().compareToIgnoreCase(vetor[m].getTitle()) > 0 && Metrica.incrementaComparacoes()) {
            m = r; 
        }

        if (m != i) { 
            trocar(i, m, vetor);
            maxHeapify(vetor, m, n);
        } 
    }
    
    private static void trocar(int i, int j, Livro[] vetor) {
        Livro tmp = vetor[i];
        Metrica.incrementaCopias();
        vetor[i] = vetor[j];
        vetor[j] = tmp;
    }
}
