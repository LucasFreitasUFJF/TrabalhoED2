package Ordenacao;

import Registros.Livro;
import Trabalho.Metrica;

public class ShellSort {

    public static void ordena(Livro[] vetor) {
        long tempoInicial = System.currentTimeMillis();
        shellSort(vetor, vetor.length);
        long tempoFinal = System.currentTimeMillis();
        Metrica.setTempo(tempoFinal - tempoInicial);
    }

    private static void shellSort(Livro[] vetor, int n) {
        int h = 1;
        while (h < n) {
            h = 3 * h + 1;
        }

        int j;
        Livro valor;
        while (h > 0) {
            for (int i = h; i < n; i++) {
                valor = vetor[i];
                Metrica.incrementaCopias();
                j = i;
                while (Metrica.incrementaComparacoes() && j > h - 1 && valor.getTitle().compareToIgnoreCase(vetor[j - h].getTitle()) <= 0) {
                    vetor[j] = vetor[j - h];
                    Metrica.incrementaCopias();
                    j = j - h;
                }
                vetor[j] = valor;
                Metrica.incrementaCopias();
            }
            h = h / 3;
        }
    }
}
