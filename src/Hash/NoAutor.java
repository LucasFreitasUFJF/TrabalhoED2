package Hash;

import Registros.Autor;

public class NoAutor {

    private long chave;
    private Autor valor;
    private int cont;

    public NoAutor(long key, Autor value) {
        this.chave = key;
        this.valor = value;
        this.cont = 0;
    }

    public long getChave() {
        return chave;
    }

    public void setChave(long chave) {
        this.chave = chave;
    }

    public Autor getValor() {
        return valor;
    }

    public void setValor(Autor valor) {
        this.valor = valor;
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
