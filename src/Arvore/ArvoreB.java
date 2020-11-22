package Arvore;

import Registros.Livro;

public class ArvoreB {

    private NoB raiz;
    private int m;
    private int grau;

    /**
     *
     * @param m ordem da arvore
     */
    public ArvoreB(int m) {
        raiz = null;
        this.m = m;
    }

    public NoB buscar(Livro livro) {
        return auxBuscar(raiz, livro, 0);
    }

    private NoB auxBuscar(NoB no, Livro livro, int i) {
        if (no != null && i <= no.getContVal()) {
            if (livro.getId() < no.getChaves()[i]) {
                return auxBuscar(no.getFilhos()[i], livro, 0); //vai para o filho na posicao 0.
            } else if (livro.getId() > no.getChaves()[i]) {
                if (i < no.getM()) {
                    return auxBuscar(no, livro, i++); //anda para o proximo indice do vetor.
                } else {
                    return auxBuscar(no.getFilhos()[i + 1], livro, 0); //vai para o ultimo vetor de filhos
                }
            } else {
                return no;
            }
        } else {
            return null;
        }
    }

    public void insere(Livro livro) {
        if (raiz == null) {
            NoB no = new NoB(m);
            raiz = no;
            System.out.println(livro.getId() / 10000000);
        } else {
            if (buscar(livro) == null) {
                if (!raiz.setValor(livro)) {
                    if (!raiz.ehFolha()) {
                        auxInsere(raiz, livro, 0);
                    }
                } else {
                    cisao(raiz, livro);
                }
            }
        }
    }

    public void auxInsere(NoB no, Livro livro, int i) {
        if (no != null) {
            if (i <= no.getContVal()) {
                if (livro.getId() < no.getChaves()[i]) {
                    auxInsere(no.getFilhos()[i], livro, 0);
                } else if (livro.getId() > no.getChaves()[i]) {
                    if (i < no.getM()) {
                        auxInsere(no, livro, i++);
                    } else {
                        auxInsere(no.getFilhos()[i + 1], livro, 0);
                    }
                } else {
                    no.setValor(livro);
                }
            }
        }
    }

    private void cisao(NoB no, Livro livro) {
        NoB cisao = new NoB(m + 1);
        
        //faz um vetor com uma posicao a mais, para poder pegar o meio
        for (int i = 0; i <= no.getM(); i++) {
            cisao.setValor(no.getValores()[i]);
        }
        
        //criacao dos vetores auxiliares
        cisao.setValor(livro);
        NoB cisaoParte1 = new NoB(m / 2);
        NoB cisaoParte2 = new NoB(m / 2);
        for (int i = 0, j = no.getM(); i < no.getM() / 2; i++, j--) {
            cisaoParte1.setValor(cisao.getValores()[i]);
            cisaoParte2.setValor(cisao.getValores()[j]);
        }

        //seta os valores nos lugares corretos da arvore
        no = new NoB(m);
        no.setValor(cisao.getValores()[m / 2]);
        no.setFilho(cisaoParte1, 0);
        no.setFilho(cisaoParte2, 1);
    }

}
