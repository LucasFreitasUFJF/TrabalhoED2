package Hash;

import Registros.Livro;
import Trabalho.Metrica;
import java.util.ArrayList;

public class HashLivro {

    private ArrayList<NoLivro> data[];
    private int n;

    public HashLivro(int n) {
        this.data = new ArrayList[n];
        this.n = n;
    }

    private long construirHash(long valor) {
        return valor % n;
    }

    public NoLivro busca(long chave) {
        int hashKey = (int) construirHash(chave);
        if (data[hashKey] == null) {
            return null;
        } else {
            for (NoLivro indice : data[hashKey]) {
                if (indice.getChave() == chave) {
                    return indice;
                }
            }
            return null;
        }
    }

    public void insere(Livro livro) {
        if (busca(livro.getId()) == null) {
            int hashKey = (int) construirHash(livro.getId());
            NoLivro no = new NoLivro(livro.getId(), livro);
            if (data[hashKey] == null) {
                data[hashKey] = new ArrayList<>();
            } else {
                Metrica.incrementaColisoes();
            }
            data[hashKey].add(no);
        } else {
            Metrica.incrementaColisoes();
        }
    }

    public void imprime() {
        for (int i = 0; i < n; i++) {
            if(data[i]!=null){
            System.out.print("Altura " + i + ":");
            for (NoLivro livro : data[i]) {
                System.out.print(livro.getValor().getTitle()+ ", ");
            }
            System.out.println("");
          }
        }  
    }
}
