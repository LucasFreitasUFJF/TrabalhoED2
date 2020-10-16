package ordenacao;

import trabalho.Metrica;
import trabalho.Registro;

public class HeapSort {
    
    //Construtor
    public HeapSort() {
        
    }
    
    public void ordena(Registro[] vetor) {
        long tempoInicial = System.currentTimeMillis();
        heapSort(vetor, vetor.length);
        long tempoFinal = System.currentTimeMillis();
        Metrica.setTempo(tempoFinal-tempoInicial);
    }
    
    private void heapSort(Registro[] vetor, int n) {
        buildMaxHeap(vetor, n);
        for(int i=n-1; i>0; i--) {
            trocar(0, i, vetor);
            maxHeapify(vetor, 0, i);
        }
    }
    
    private void buildMaxHeap(Registro[] vetor, int n) {
        for(int i=n/2 - 1; i>=0; i--) {
            maxHeapify(vetor, i, n);
        }
    }
    
    private void maxHeapify(Registro[] vetor, int i, int n) {
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
    
    private void trocar(int i, int j, Registro[] vetor) {
        Registro tmp = vetor[i];
        Metrica.incrementaCopias();
        vetor[i] = vetor[j];
        vetor[j] = tmp;
    }
}
