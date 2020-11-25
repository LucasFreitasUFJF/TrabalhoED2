package Arvore;

import Registros.Livro;
import java.util.Vector;

public class NoB {

    private int n;
    private Vector<Long> chaves;
    private Vector<Livro> valores;
    private Vector<NoB> filhos;
    private boolean folha;

    public NoB(int m) {
        chaves = new Vector<>(m-1);
        for (int i=0; i<m-1; i++)
            chaves.add(null);
        
        valores = new Vector<>(m-1);
        for(int i=0; i<m-1; i++)
            valores.add(null);
        
        filhos = new Vector<>(m);
        for (int i=0; i<m; i++)
            filhos.add(null);
        
        folha = true;
        this.n = 0;
    }

    public Vector<Long> getChaves() {
        return chaves;
    }

    public void setChaves(Vector<Long> chaves) {
        this.chaves = chaves;
    }
    
    public Vector<Livro> getValores() {
        return valores;
    }
    
    public void setValores(Vector<Livro> valores) {
        this.valores = valores;
    }

    public Vector<NoB> getFilhos() {
        return filhos;
    }

    public void setFilhos(Vector<NoB> filhos) {
        this.filhos = filhos;
    }

    public boolean ehFolha() {
        return folha;
    }

    public void setFolha(boolean folha) {
        this.folha = folha;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
}
