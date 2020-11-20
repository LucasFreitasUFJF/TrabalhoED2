package Arvore;


public class NoVP {
    private long chave;
    private boolean cor; //false = preto e true = vermelho
    private NoVP esq;
    private NoVP dir;
    private NoVP pai;
    
    public NoVP(long chave) {
        this.chave = chave;
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
