package Arvore;

import Registros.Livro;

public class ArvoreB {

    private int t;
    private NoB raiz;

    public ArvoreB(int t) {
        t = t;
        raiz = new NoB(t);
        raiz.setN(0);
        raiz.setEhFolha(true);
    }

    // Search chave
    private NoB busca(NoB x, Livro chave) {
        int i = 0;
        if (x == null) {
            return x;
        }
        for (i = 0; i < x.getN(); i++) {
            if (chave.getId() < x.getChave()[i].getId()) {
                break;
            }
            if (chave.getId() == x.getChave()[i].getId()) {
                return x;
            }
        }
        if (x.isEhFolha()) {
            return null;
        } else {
            return busca(x.getFilhos()[i], chave);
        }
    }

    private void separa(NoB x, int pos, NoB y) {
        NoB z = new NoB(t);
        z.setEhFolha(y.isEhFolha());
        z.setN(t - 1);
        for (int j = 0; j < t - 1; j++) {
            z.getChave()[j] = y.getChave()[j + t];
        }
        if (!y.isEhFolha()) {
            for (int j = 0; j < t; j++) {
                z.getFilhos()[j] = y.getFilhos()[j + t];
            }
        }
        y.setN(t - 1);
        for (int j = x.getN(); j >= pos + 1; j--) {
            x.getFilhos()[j + 1] = x.getFilhos()[j];
        }
        x.getFilhos()[pos + 1] = z;

        for (int j = x.getN() - 1; j >= pos; j--) {
            x.getChave()[j + 1] = x.getChave()[j];
        }
        x.getChave()[pos] = y.getChave()[t - 1];
        x.setN(x.getN() + 1);
    }

    public void insere(final Livro key) {
        NoB r = raiz;
        if (r.getN() == 2 * t - 1) {
            NoB s = new NoB(t);
            raiz = s;
            s.setEhFolha(false);
            s.setN(0);
            s.getFilhos()[0] = r;
            separa(s, 0, r);
            insereValor(s, key);
        } else {
            insereValor(r, key);
        }
    }

    final private void insereValor(NoB x, Livro k) {

        if (x.isEhFolha()) {
            int i = 0;
            for (i = x.getN() - 1; i >= 0 && k.getId() < x.getChave()[i].getId(); i--) {
                if (i + 1 < x.getChave().length) {
                    x.getChave()[i + 1] = x.getChave()[i];
                }
            }
            x.getChave()[i + 1] = k;
            x.setN(x.getN() + 1);
        } else {
            int i = 0;
            for (i = x.getN() - 1; i >= 0 && k.getId() < x.getChave()[i].getId(); i--) {
            }
            ;
            i++;
            NoB tmp = x.getFilhos()[i];
            if (tmp.getN() == 2 * t - 1) {
                separa(x, i, tmp);
                if (k.getId() > x.getChave()[i].getId()) {
                    i++;
                }
            }
            insereValor(x.getFilhos()[i], k);
        }

    }

    public void print() {
        auxPrint(raiz, 0);
    }

    private void auxPrint(NoB x, int nivel) {
        if (x != null) {
            System.out.print("(" + nivel + ")");
            for (int i = 0; i < nivel; i++) {
                System.out.print("--");
            }
        }

        for (int i = 0; i < x.getChave().length; i++) {
            System.out.print(x.getChave()[i].getId() + ", ");
        }
        System.out.println("");
        if (!x.isEhFolha()) {
            for (int i = 0; i < x.getN() + 1; i++) {
                auxPrint(x.getFilhos()[i], nivel + 1);
            }
        }
    }

    public boolean contem(Livro k) {
        if (this.busca(raiz, k) != null) {
            return true;
        } else {
            return false;
        }
    }
}
