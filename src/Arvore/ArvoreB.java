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
        this.raiz = null;
        this.m = m;
        this.grau = m / 2;
    }

    public NoB buscar(Livro livro) {
        return auxBuscar(raiz, livro, 0);
    }

    private NoB auxBuscar(NoB no, Livro livro, int i) {
        if (no != null && i < no.getContVal()) {
            if (livro.getId() < no.getChaves()[i]) {
                //vai para o filho na posicao 0.
                return auxBuscar(no.getFilhos()[i], livro, 0);
            } else if (livro.getId() > no.getChaves()[i]) {
                if (i < no.getM()) {
                    //anda para o proximo indice do vetor.
                    return auxBuscar(no, livro, i + 1);
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
            NoB no = new NoB(m, null);
            raiz = no;
        } else {
            if (buscar(livro) == null) {
                auxInsere(raiz, livro, 0);
            }
        }
    }

    private void auxInsere(NoB no, Livro livro, int i) {
        if (no!=null && no.ehFolha()) {
            if (i < no.getContVal()) {
                if (livro.getId() < no.getChaves()[i]) {
                    if (no.setValor(livro, i) == false) {
                        cisao(no, livro);
                    }
                } else if (livro.getId() > no.getChaves()[i]) {
                    //if (i < no.getM() - 1) {
                    auxInsere(no, livro, i + 1);
                    //} else {
                    //  cisao(no, livro);
                    //}
                } else {
                    if (no.setValor(livro, i) == false) {
                        cisao(no, livro);
                    }
                }
            } else {
                if (no.setValor(livro, i) == false) {
                    cisao(no, livro);
                }
            }
        } //todo noh a partir daqui possui pelo menos 2 filhos
        else if (livro.getId() < no.getChaves()[i]) {
            auxInsere(no.getFilhos()[i], livro, 0);
        } else if (livro.getId() > no.getChaves()[i]) {
            if (i < no.getContVal()) {
                auxInsere(no, livro, i + 1);
            } else if (i < no.getM() - 1) {
                auxInsere(no.getFilhos()[i], livro, 0);
            } else {
                auxInsere(no.getFilhos()[i + 1], livro, 0);

            }
        }
    }

    private void cisao(NoB no, Livro livro) {
        //faz um vetor com uma posicao a mais, para poder pegar o meio
        NoB cisao = new NoB(m + 1, no.getPai());
        for (int i = 0; i < no.getM(); i++) {
            cisao.setValor(no.getValores()[i], i);
        }

        //criacao dos vetores auxiliares
        int k = 0;
        while (livro.getId() < cisao.getChaves()[k]) {
            k++;
        }
        cisao.setValor(livro, k);
        NoB cisaoParte1 = new NoB(m, no.getPai());
        NoB cisaoParte2 = new NoB(m, no.getPai());
        for (int i = 0, j = (cisao.getM() / 2) + 1; i < no.getM() / 2; i++, j++) {
            cisaoParte1.setValor(cisao.getValores()[i], i);
            cisaoParte2.setValor(cisao.getValores()[j], i);
        }

        //verifica se eh a raiz e faz a cisao
        if (no.getPai() != null) {
            k = 0;
            while (livro.getId() < no.getPai().getChaves()[k]) {
                k++;
            }

            if (no.getPai().setValor(cisao.getValores()[cisao.getContVal() / 2], k) == false) {
                cisao(no.getPai(), cisao.getValores()[cisao.getContVal() / 2]);
            } else {
                no.getPai().setFilho(cisaoParte1, k, no.getPai());

                NoB aux = cisaoParte2;
                NoB aux2 = no.getPai().getFilhos()[k + 1];

                for (int l = k + 1; l <= no.getPai().getContVal(); l++) {
                    no.getPai().setFilho(aux, l, no.getPai());
                    if (no.getPai().getFilhos().length >= l + 1) {
                        aux = no.getPai().getFilhos()[l + 1];
                        no.getPai().setFilho(aux2, l + 1, no.getPai());
                        if (no.getPai().getFilhos().length >= l + 2) {
                            aux2 = no.getPai().getFilhos()[l + 2];
                        }
                    }
                }
            }
        } else {
            //seta os valores nos lugares corretos da arvore
            NoB novaRaiz = new NoB(m, null);
            novaRaiz.setValor(cisao.getValores()[m / 2], 0);
            novaRaiz.setFilho(cisaoParte1, 0, novaRaiz);
            novaRaiz.setFilho(cisaoParte2, 1, novaRaiz);
            novaRaiz.setFolha(false);
            raiz = novaRaiz;
            no = novaRaiz;
        }
    }

    public void remove(Livro livro) {
        if (buscar(livro) != null) {
            auxRemover(raiz, livro, 0);
        }
    }

    private void auxRemover(NoB no, Livro livro, int i) {
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

    private void juncao() {

    }

    public void print() {
        auxPrint(raiz, 0);
    }

    private void auxPrint(NoB p, int nivel) {
        if (p != null) {
            System.out.print("(" + nivel + ")");
            for (int i = 0; i < nivel; i++) {
                System.out.print("--");
            }

            for (int i = 0; i < p.getContVal(); i++) {
                System.out.print(p.getChaves()[i] + ", ");
            }
            System.out.println("");

            for (int j = 0; j < p.getContFilho(); j++) {
                auxPrint(p.getFilhos()[j], nivel + 1);
            }
        }
    }

}
