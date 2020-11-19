package Arvore;

import Registros.Livro;

public class ArvoreB {

    private NoB raiz;
    private int m;
    private int grau;
    

    public ArvoreB(int m) {
        raiz = null;
        this.m = m;
    }

    public void insere(Livro livro) {
        if (raiz == null) {
            NoB no = new NoB(m);
            raiz = no;
            System.out.println(livro.getId() / 10000000);
        } else {
            /*if (buscar(livro) == null) {
                auxInsere(null, raiz, livro);
            }*/
        }
    }

    public void auxInsere(NoB pai, NoB no, Livro livro) {
    
    }
}
