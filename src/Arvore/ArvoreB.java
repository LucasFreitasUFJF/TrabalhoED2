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
        this.grau = m / 2;
    }

    public NoB buscar(Livro livro) {
        return auxBuscar(raiz, livro, 0);
    }

    private NoB auxBuscar(NoB no, Livro livro, int i) {
        if (no != null && i <= no.getContVal()) {
            if (livro.getId() < no.getChaves()[i]) {
                //vai para o filho na posicao 0.
                return auxBuscar(no.getFilhos()[i], livro, 0);
            } else if (livro.getId() > no.getChaves()[i]) {
                if (i < no.getM()) {
                    //anda para o proximo indice do vetor.
                    return auxBuscar(no, livro, i++);
                } else {
                    //vai para o ultimo vetor de filhos
                    return auxBuscar(no.getFilhos()[i + 1], livro, 0);
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
                if (raiz.getContVal() < raiz.getM()) {
                    auxInsere(raiz, livro, 0);
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
                    no.setValor(livro, i);
                }
            } else {
                no.setValor(livro, i);
            }
        }
    }

    private void cisao(NoB no, Livro livro) {
        NoB cisao = new NoB(m + 1);

        //faz um vetor com uma posicao a mais, para poder pegar o meio
        for (int i = 0; i <= no.getM(); i++) {
            cisao.setValor(no.getValores()[i], i);
        }

        //criacao dos vetores auxiliares
        int k = 0;
        while (livro.getId() < cisao.getChaves()[k]) {
            k++;
        }
        cisao.setValor(livro, k);
        NoB cisaoParte1 = new NoB(m / 2);
        NoB cisaoParte2 = new NoB(m / 2);
        for (int i = 0, j = no.getM(); i < no.getM() / 2; i++, j--) {
            cisaoParte1.setValor(cisao.getValores()[i], i);
            cisaoParte2.setValor(cisao.getValores()[j], i);
        }

        //seta os valores nos lugares corretos da arvore
        no = new NoB(m);
        no.setValor(cisao.getValores()[m / 2], 0);
        no.setFilho(cisaoParte1, 0);
        no.setFilho(cisaoParte2, 1);
    }

    public void remove(Livro livro) {
        if (buscar(livro) != null) {
            auxRemover(raiz, livro, 0);
        }
    }

    public void auxRemover(NoB no, Livro livro, int i) {
        if (no != null) {
            if (i <= no.getContVal()) {
                if (livro.getId() < no.getChaves()[i]) {
                    auxRemover(no.getFilhos()[i], livro, 0);
                } else if (livro.getId() > no.getChaves()[i]) {
                    if (i < no.getM()) {
                        auxRemover(no, livro, i++);
                    } else {
                        auxRemover(no.getFilhos()[i + 1], livro, 0);
                    }
                } else {
                    if (!no.removeValor(i)) {
                        if (i == 0 && !no.ehFolha()) {
                            //removeu do filho
                            if (no.getFilhos()[1].getContVal() > grau) {
                                redistribuicao(no);
                            }
                        } else {
                            //removeu dele mesmo
                            juncao();
                        }
                    }
                }
            }
        }
    }

    private void redistribuicao(NoB no) {
        //no.getFilhos()[0].setValor(no.getValores()[0], grau-1);
        Livro valorPai = no.getValores()[0];
        Livro valor1 = no.getFilhos()[1].getValores()[0];

        no.trocaValores(valor1, 0);
        no.getFilhos()[0].trocaValores(valorPai, grau - 1);
        no.getFilhos()[1].removeValor(0);
    }

    public void juncao() {

    }

}
