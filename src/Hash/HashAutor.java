package Hash;

import Ordenacao.MergeSort;
import Registros.Autor;
import Trabalho.Metrica;
import java.util.ArrayList;

public class HashAutor {

    private ArrayList<NoAutor> data[];
    private int n;
    private int m;
    private ArrayList<NoAutor> freq;
    private NoAutor maisFreq;
    private NoAutor menosFreq;

    public HashAutor(int n, int m) {
        this.data = new ArrayList[n];
        this.n = n;
        this.m = m;
        this.freq = new ArrayList<>();
        this.maisFreq = null;
        this.menosFreq = null;
    }

    private long construirHash(long valor) {
        return valor % n;
    }

    public NoAutor busca(long chave) {
        int hashKey = (int) construirHash(chave);
        if (data[hashKey] == null) {
            return null;
        } else {
            for (NoAutor indice : data[hashKey]) {
                if (indice.getChave() == chave) {
                    return indice;
                }
            }
            return null;
        }
    }

    public void insere(Autor autor) {
        NoAutor noBusca = busca(autor.getId());
        if (noBusca == null) {
            int hashKey = (int) construirHash(autor.getId());
            NoAutor no = new NoAutor(autor.getId(), autor);
            if (data[hashKey] == null) {
                data[hashKey] = new ArrayList<>();
            } else {
                Metrica.incrementaColisoes();
            }
            data[hashKey].add(no);
            insereListaMaisFreq(no);
        } else {
            noBusca.incrementaCont();
            insereListaMaisFreq(noBusca);
            Metrica.incrementaColisoes();
        }
    }

    private void insereListaMaisFreq(NoAutor no) {
        if (!freq.contains(no)) {
            if (freq.size() < m) {
                if (maisFreq == null) {
                    maisFreq = no;
                    menosFreq = no;
                } else {
                    if (maisFreq.getCont() < no.getCont()) {
                        maisFreq = no;
                    }
                    if (menosFreq.getCont() < no.getCont()) {
                        menosFreq = no;
                    }
                }
                freq.add(no);
            } else {
                if (maisFreq.getCont() < no.getCont()) {
                    freq.remove(menosFreq);
                    freq.add(no);
                    maisFreq = no;
                    NoAutor aux = maisFreq;
                    for (int i = 0; i < freq.size(); i++) {
                        if (freq.get(i).getCont() < aux.getCont()) {
                            aux = freq.get(i);
                        }
                    }
                    menosFreq = aux;
                }

                if (menosFreq.getCont() < no.getCont()) {
                    freq.remove(menosFreq);
                    freq.add(no);
                    menosFreq = no;
                }
            }
        } else{
            freq.remove(no);
            insereListaMaisFreq(no);
        }
    }

    public NoAutor[] getMaisFreq() {
        NoAutor[] autores = freq.toArray(new NoAutor[freq.size()]);
        MergeSort.ordena(autores);
        return autores;
    }

    public void imprime() {
        for (int i = 0; i < n; i++) {
            if (data[i] != null) {
                System.out.print("Altura " + i + ":");
                for (NoAutor autor : data[i]) {
                    System.out.print(autor.getCont() + ", ");
                }
                System.out.println("");
            }
        }
    }
}
