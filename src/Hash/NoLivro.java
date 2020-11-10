package Hash;

import Registros.Livro;

public class NoLivro {

    private long chave;
    private Livro valor;

    public NoLivro(long key, Livro value) {
        this.chave = key;
        this.valor = value;
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

}
