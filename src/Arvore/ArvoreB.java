package Arvore;

import Registros.Livro;
import Trabalho.Metrica;

public class ArvoreB {

    private NoB raiz;
    private int ordemM;
    private int cont;

    public ArvoreB(int m) {
        this.raiz = new NoB(m);
        this.ordemM = m;
        cont = 0;
    }

    //Função para inserção
    public void insere(Livro livro) {
        if (buscar(livro) == null) {
            if (raiz.getN() == 0) {
                raiz.getChaves().set(0, livro.getId());
                raiz.getValores().set(0, livro);
                raiz.setN(raiz.getN() + 1);
            } else {
                NoB aux = raiz;
                if (aux.getN() == ordemM - 1) { 
                    NoB novoNo = new NoB(ordemM);
                    raiz = novoNo;
                    novoNo.setFolha(false);
                    novoNo.setN(0);
                    novoNo.getFilhos().set(0, aux);
                    cisao(novoNo, 0, aux);
                    inserirNovoValor(novoNo, livro);

                } else {
                    inserirNovoValor(aux, livro);
                }
            }
            cont++;
        }
    }

    private void cisao(NoB no1, int posicao, NoB no2) {
        Metrica.incrementaOverflow();
        int med = (int) Math.floor((ordemM-1)/2);
        
        NoB aux = new NoB(ordemM);
        aux.setFolha(no2.ehFolha());
        aux.setN(med);

        for (int i = 0; i < med; i++) {
            if ((ordemM-1)%2 == 1) {
                aux.getChaves().set(i, no2.getChaves().get(i+med+1));
                aux.getValores().set(i, no2.getValores().get(i+med+1));
            } else {
                aux.getChaves().set(i, no2.getChaves().get(i+med));
                aux.getValores().set(i, no2.getValores().get(i+med));
            }
            no2.setN(no2.getN()-1);
        }
        if (!no2.ehFolha()) {
            for (int i = 0; i < med + 1; i++) {
                if ((ordemM - 1) % 2 == 0) {
                    aux.getFilhos().set(i, no2.getFilhos().get(i+med));
                } else {
                    aux.getFilhos().set(i, no2.getFilhos().get(i+med+1));
                }
            }
        }

        no2.setN(med);

        for (int i = no1.getN(); i>posicao; i--) 
            no1.getFilhos().set(i + 1, no1.getFilhos().get(i));
        
        no1.getFilhos().set(posicao + 1, aux);
        for (int i = no1.getN(); i > posicao; i--) {
            no1.getChaves().set(i, no1.getChaves().get(i-1));
            no1.getValores().set(i, no1.getValores().get(i-1));
        }
        if ((ordemM - 1) % 2 == 0) {
            no1.getChaves().set(posicao, no2.getChaves().get(med-1));
            no1.getValores().set(posicao, no2.getValores().get(med-1));
            no2.setN(no2.getN() - 1);
        } else {
            no1.getChaves().set(posicao, no2.getChaves().get(med));
            no1.getValores().set(posicao, no2.getValores().get(med));
        }
        no1.setN(no1.getN()+1);
    }

    private void inserirNovoValor(NoB no, Livro livro) {
        int aux = no.getN() - 1;
        if (no.ehFolha()) {
            while (aux >= 0 && livro.getId() < no.getChaves().get(aux) && Metrica.incrementaComparacoes()) {
                no.getChaves().set(aux+1, no.getChaves().get(aux));
                no.getValores().set(aux+1, no.getValores().get(aux));
                aux--;
            }
            aux++;
            no.getChaves().set(aux, livro.getId());
            no.getValores().set(aux, livro);
            no.setN(no.getN() + 1);

        } else {
            while ((aux >= 0 && livro.getId() < no.getChaves().get(aux)) && Metrica.incrementaComparacoes()) {
                aux--;
            }
            aux++;
            if ((no.getFilhos().get(aux)).getN() == ordemM-1) {
                cisao(no, aux, no.getFilhos().get(aux));
                if (livro.getId() > no.getChaves().get(aux)) {
                    aux++;
                }
            }
            inserirNovoValor(no.getFilhos().get(aux), livro);
        }
    }
    
    public NoB buscar(Livro livro) {
        return auxBuscar(raiz, livro);
    }

    public NoB auxBuscar(NoB X, Livro livro) {
        int i = 1;
        while ((i <= X.getN()) && (livro.getId() > X.getChaves().get(i - 1)) && Metrica.incrementaComparacoes()) {
            i++;
        }
        
        if ((i <= X.getN()) && (livro.getId() == X.getChaves().get(i - 1)) && Metrica.incrementaComparacoes()) {
            return X;
        }
        
        if (X.ehFolha()) {
            return null;
        } else {
            return (auxBuscar(X.getFilhos().get(i - 1), livro));
        }
    }
    
    public void print() {
        auxPrint(raiz, 0);
    }

    private void auxPrint(NoB p, int nivel) {
        if (p != null) {
            System.out.print("(" + nivel + ")");
            for (int i = 0; i < nivel; i++) {
                System.out.print("--");
            }

            for (int i = 0; i < p.getN(); i++) {
                System.out.print(p.getChaves().get(i) + ", ");
            }
            System.out.println("");

            
            for (int j = 0; j < p.getFilhos().size(); j++) {
                auxPrint(p.getFilhos().get(j), nivel + 1);
            }
        }
    }
    
    //Getters e Setters
    public int getnCont() {
        return cont;
    }

    public void setOrdemM(int ordem) {
        this.ordemM = ordem;
    }

    public int getOrdem() {
        return ordemM;
    }

    public NoB getRaiz() {
        return raiz;
    }
}
