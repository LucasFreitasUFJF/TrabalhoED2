package Arvore;

import Registros.Livro;

public class NoB {

    /**
     * @param getN the getN to set
     */
    public void setN(int n) {
        this.n = n;
    }

    /**
     * @return the getN
     */
    public int getN() {
        return n;
    }

    /**
     * @return the chave
     */
    public Livro[] getChave() {
        return chave;
    }

    /**
     * @return the getFilhos
     */
    public NoB[] getFilhos() {
        return filhos;
    }

    /**
     * @return the ehFolha
     */
    public boolean isEhFolha() {
        return ehFolha;
    }
    private int n;
    private Livro[] chave;
    private NoB[] filhos;
    private boolean ehFolha;

    public NoB(int t) {
        int m = 2*t;
        this.ehFolha = true;
        this.filhos = new NoB[2 * t+1];
        this.chave = new Livro[m];
    }

    public int encontrar(int k) {
        for (int i = 0; i < this.n; i++) {
            if (this.getChave()[i].getId() == k) {
                return i;
            }
        }
        return -1;
    }

    ;

    /**
     * @param ehFolha the ehFolha to set
     */
    public void setEhFolha(boolean ehFolha) {
        this.ehFolha = ehFolha;
    }
}
