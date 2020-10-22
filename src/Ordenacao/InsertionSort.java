package ordenacao;

import trabalho.Metrica;
import trabalho.Registro;

public class InsertionSort {

    //Contrutor
    public InsertionSort() {
        
    }
    
    public void ordena(Registro[] vetor){
        long tempoInicial = System.currentTimeMillis();
        insertionSort(vetor, vetor.length);
        long tempoFinal = System.currentTimeMillis();
        Metrica.setTempo(tempoFinal-tempoInicial);
    }
    
    private void insertionSort(Registro[] vetor, int n) {
        for(int i=1; i<n; i++){
            Registro pivo = vetor[i];
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
