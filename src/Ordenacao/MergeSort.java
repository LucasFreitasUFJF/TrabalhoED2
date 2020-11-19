package Ordenacao;

import Hash.NoAutor;
import Trabalho.Metrica;
import Registros.Livro;

public class MergeSort {
    
    public static <T> void ordena(T[] vetor){
        long tempoInicial = System.currentTimeMillis();
        T[] aux = (T[]) new Object[vetor.length];
        
        mergeSort(vetor, aux, 0, vetor.length - 1);
        long tempoFinal = System.currentTimeMillis();
        Metrica.setTempo(tempoFinal - tempoInicial);
    }
    
    private static <T> void mergeSort(T[] vetor, T[] aux, int first, int last) {
        if(first < last){
            int mid=(first+last)/2;
            mergeSort(vetor, aux, first, mid);
            mergeSort(vetor, aux, mid+1, last);
            merge(vetor, aux, first, mid, last);
        }
    }

    private static <T> void merge(T[] vetor, T[] aux, int first, int mid, int last) {
        int i1 = first;
        int i2 = mid+1;
        int k = 0;
        
        while((i1 <= mid) && (i2 <=last)) {
            if(compare(vetor[i1], vetor[i2]) && Metrica.incrementaComparacoes()) {
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
    
    private static <T> boolean compare(T i, T j) {
        if(i.getClass() == Livro.class) {
            return ((Livro) i).getTitle().compareToIgnoreCase(((Livro) j).getTitle()) <= 0;
        } else {
            if(((NoAutor) i).getCont() < ((NoAutor) j).getCont()) {
                return true;
            } else {
                return false;
            }
        }
    }
}
