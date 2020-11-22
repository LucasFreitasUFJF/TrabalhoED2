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
    
    public int getContVal(){
        return contVal;
    }

    public boolean ehFolha() {
        return folha;
    }

    public void setFolha(boolean folha) {
        this.folha = folha;
    }

    public boolean setValor(Livro livro) {
        if (contVal < m) {
            long auxChaves = livro.getId();
            Livro auxValores = livro;

            for (int i = 0; i < contVal; i++) {
                if (livro.getId() < chaves[i]) {
                    long tmpChaves = chaves[i];
                    Livro tmpVal = valores[i];

                    chaves[i] = auxChaves;
                    valores[i] = auxValores;

                    auxChaves = tmpChaves;
                    auxValores = tmpVal;
                }
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
        if (indice < m && indice >=0) {
            filhos[indice] = filho;
            contFilhos++;
        }
    }

    public boolean removeValor(Livro livro) {
        int index = -1;
        for (int i = 0; i < contVal; i++) {
            if (livro == valores[i]) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            valores[index] = null;
            contVal--;
            if (contVal < grau) {
                return false;
            }
            return true;
        }
        return false;
    }

    
    public boolean removeFilho(int indice) {
        for (int i = indice; i < contFilhos; i++) {
            if (i+1 < m) {
                filhos[i] = filhos[i+1];
            } else {
                filhos[i] = null;
            }
        }
        contFilhos--;
        if(contFilhos<grau)
            return false;
        return true;
    }
}
