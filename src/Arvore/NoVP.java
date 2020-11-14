package Arvore;

import Registros.Livro;

public class NoVP {
    private Livro livro;
    private boolean cor; //false = preto e true = vermelho
    private NoVP esq;
    private NoVP dir;
    private NoVP pai;
    
    public NoVP(Livro livro) {
        this.livro = livro;
        this.cor = true;
        this.esq = null;
        this.dir = null;
        this.pai = null;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setId(Livro livro) {
        this.livro = livro;
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
