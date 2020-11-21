package Ordenacao;

import Hash.NoAutor;
import Trabalho.Metrica;
import Registros.Livro;

public class MergeSort {
    
    public static <T> void ordena(T[] vetor){
        long tempoInicial = System.currentTimeMillis();
        T[] aux;
        if(vetor[0].getClass() == Livro.class) {
            aux = (T[]) new Livro[vetor.length];
        } else
            aux = (T[]) new NoAutor[vetor.length];
        
        mergeSort(vetor, aux, 0, vetor.length - 1);
        long tempoFinal = System.currentTimeMillis();
        Metrica.setTempo(tempoFinal - tempoInicial);
    }
    
    private static <T> void mergeSort(T[] vetor, T[] aux, int first, int last) {
        if(vetor != null && first < last && first >= 0 && last < vetor.length && vetor.length != 0){
            int mid=(first+last)/2;
            mergeSort(vetor, aux, first, mid);
            mergeSort(vetor, aux, mid+1, last);
            merge(vetor, aux, first, mid, last);
        }
    }

    private static <T> void merge(T[] vetor, T[] aux, int first, int mid, int last) {
        for (int i = first; i <= last; i++) {
            aux[i] = vetor[i];
        }
        
        int i1 = first;
        int i2 = mid+1;
        int k = first;
        
        while((i1 <= mid) && (i2 <=last)) {
            if(compare(aux[i1], aux[i2]) && Metrica.incrementaComparacoes()) {
                vetor[k] = aux[i1];
                Metrica.incrementaCopias();
                i1++;
            } else {
                vetor[k] = aux[i2];
                Metrica.incrementaCopias();
                i2++;
            }
            k++;
        }
        while(i1 <= mid) { vetor[k] = aux[i1]; Metrica.incrementaCopias(); i1++; k++; }
        while(i2 <= last) { vetor[k] = aux[i2]; Metrica.incrementaCopias(); i2++; k++; }
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