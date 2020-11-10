package Hash;

import Registros.Autor;
import java.util.ArrayList;

public class HashAutor {

    private ArrayList<NoAutor> data[];
    private int n;
    private int colisoes;

    public HashAutor(int n) {
        this.data = new ArrayList[n];
        this.n = n;
        this.colisoes = 0;
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
                this.colisoes++;
            }
            data[hashKey].add(no);
        } else {
            noBusca.incrementaCont();
            this.colisoes++;
        }
    }

    public int getColisoes() {
        return colisoes;
    }

    public void zerarColisoes() {
        this.colisoes = 0;
    }

    public void imprime() {
        for (int i = 0; i < n; i++) {
            System.out.print("Altura " + i + ":");
            for (NoAutor autor : data[i]) {
                System.out.print(autor.getChave() + ", ");
            }
            System.out.println("");
        }
    }
}
