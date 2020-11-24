package Arvore;

import Registros.Livro;

public class NoB {

    private long chaves[];
    private Livro valores[];
    private NoB filhos[];
    private int m; //tamanho do vetor
    private boolean folha;
    private int grau;
    private int contVal; //numero de chaves presentes no noh
    private int contFilhos;

    public NoB(int m) {
        this.chaves = new long[m - 1];
        this.valores = new Livro[m - 1];
        this.filhos = new NoB[m];
        this.m = m - 1;
        this.folha = true;
        this.grau = m / 2;
        this.contVal = 0;
        this.contFilhos = 0;
    }

    public int getM() {
        return m;
    }

    public long[] getChaves() {
        return chaves;
    }

    public Livro[] getValores() {
        return valores;
    }

    public NoB[] getFilhos() {
        return filhos;
    }

    public int getContVal() {
        return contVal;
    }
    
    public int getContFilho() {
        return contFilhos;
    }

    public boolean ehFolha() {
        return folha;
    }

    public void setFolha(boolean folha) {
        this.folha = folha;
    }

    public boolean setValor(Livro livro, int indice) {
        if (contVal < m) {
            long auxChaves = livro.getId();
            Livro auxValores = livro;

            while (indice <= contVal) {
                long tmpChaves = chaves[indice];
                Livro tmpVal = valores[indice];

                chaves[indice] = auxChaves;
                valores[indice] = auxValores;

                auxChaves = tmpChaves;
                auxValores = tmpVal;
                indice++;
            }

            this.valores[contVal] = livro;
            this.chaves[contVal] = livro.getId();
            contVal++;
            return true;
        } else {
            return false;
        }
    }

    public void setFilho(NoB filho, int indice) {
        if (indice < m && indice >= 0) {
            filhos[indice] = filho;
            contFilhos++;
        }
    }

    public boolean removeValor(int indice) {
        if (indice == 0 && contVal - 1 < grau && !ehFolha()) {
            //chave 0 recebe o valor menor que ele
            chaves[0] = filhos[0].getChaves()[filhos[0].getContVal()];
            filhos[0].removeValor(filhos[0].getContVal());
            filhos[0].contVal--;
            return filhos[0].contVal >= grau;
        }
        
        for (int i = indice; i < m; i++) {
            chaves[i] = chaves[i + 1];
            valores[i] = valores[i + 1];
            contVal--;
        }

        return contVal >= grau;
    }

    public boolean removeFilho(int indice) {
        for (int i = indice; i < contFilhos; i++) {
            if (i + 1 < m) {
                filhos[i] = filhos[i + 1];
            } else {
                filhos[i] = null;
            }
        }
        contFilhos--;
        return contFilhos >= grau;
    }
    
    public void trocaValores(Livro livro, int indice){
        chaves[indice] = livro.getId();
        valores[indice] = livro;
    }
}
