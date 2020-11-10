package Hash;

import Registros.Autor;

public class NoAutor {

    private long chave;
    private String nomeAutor;
    private int cont;

    public NoAutor(long key, Autor autor) {
        this.chave = key;
        this.nomeAutor = autor.getName();
        this.cont = 0;
    }

    public long getChave() {
        return chave;
    }

    public void setChave(long chave) {
        this.chave = chave;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public int getCont() {
        return this.cont;
    }

    public void incrementaCont() {
        this.cont++;
    }

    public void decrementaCont() {
        this.cont--;
    }
}
