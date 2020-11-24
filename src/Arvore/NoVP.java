package Arvore;

import Registros.Livro;


public class NoVP {
    private long chave;
    private Livro valor;
    private boolean cor; //false = preto e true = vermelho
    private NoVP esq;
    private NoVP dir;
    private NoVP pai;
    
    public NoVP(long chave, Livro valor) {
        this.chave = chave;
        this.valor = valor;
        this.cor = true;
        this.esq = null;
        this.dir = null;
        this.pai = null;
    }

    public long getChave() {
        return chave;
    }

    public void setChave(long chave) {
        this.chave = chave;
    }
    
    public Livro getValor() {
        return valor;
    }
    
    public void setValor(Livro valor) {
        this.valor = valor;
    }

    public boolean getCor() {
        return cor;
    }

    public void setCor(boolean cor) {
        this.cor = cor;
    }

    public NoVP getEsq() {
        return esq;
    }

    public void setEsq(NoVP esq) {
        this.esq = esq;
    }

    public NoVP getDir() {
        return dir;
    }

    public void setDir(NoVP dir) {
        this.dir = dir;
    }

    public NoVP getPai() {
        return pai;
    }

    public void setPai(NoVP pai) {
        this.pai = pai;
    }
}
