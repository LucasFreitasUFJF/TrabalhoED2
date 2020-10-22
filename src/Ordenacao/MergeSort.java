package Ordenacao;

import Trabalho.Metrica;
import Registros.Livro;

public class MergeSort {
    
    public static void ordena(Livro[] vetor){
        long tempoInicial = System.currentTimeMillis();
        Livro[] aux = new Livro[vetor.length];
        mergeSort(vetor, aux, 0, vetor.length - 1);
        long tempoFinal = System.currentTimeMillis();
        Metrica.setTempo(tempoFinal - tempoInicial);
    }
    
    private static void mergeSort(Livro[] vetor, Livro[] aux, int first, int last) {
        if(first < last){
            int mid=(first+last)/2;
            mergeSort(vetor, aux, first, mid);
            mergeSort(vetor, aux, mid+1, last);
            merge(vetor, aux, first, mid, last);
        }
    }

    private static void merge(Livro[] vetor, Livro[] aux, int first, int mid, int last) {
        int i1 = first;
        int i2 = mid+1;
        int k = 0;
        
        while((i1 <= mid) && (i2 <=last)) {
            if(vetor[i1].getTitle().compareToIgnoreCase(vetor[i2].getTitle()) <= 0 && Metrica.incrementaComparacoes()) {
                aux[k] = vetor[i1];
                Metrica.incrementaCopias();
                i1++;
            } else {
                aux[k] = vetor[i2];
                Metrica.incrementaCopias();
                i2++;
            }
            k++;
        }
        while(i1 <= mid) { aux[k] = vetor[i1]; Metrica.incrementaCopias(); i1++; k++; }
        while(i2 <= last) { aux[k] = vetor[i2]; Metrica.incrementaCopias(); i2++; k++; }
        for(int i = first; i<last+1; i++) {
            vetor[i] = aux[i-first];
        }
    }
}
