package Arvore;

import Registros.Livro;

public class ArvoreVP {
    private NoVP raiz;
    
    public ArvoreVP() {
        raiz = null;
    }
    
    public NoVP buscar(Livro livro) {
        return auxBuscar(raiz, livro);
    }
    
    private NoVP auxBuscar(NoVP no, Livro livro) {
        if(no != null) {
            if(livro.getId() < no.getLivro().getId()) {
                return auxBuscar(no.getEsq(), livro);
            } else if(livro.getId() > no.getLivro().getId()) {
                return auxBuscar(no.getDir(), livro);
            } else {
                return no;
            }
        } else {
            return null;
        }
    }
    
    public void insere(Livro livro) {
        if(raiz == null) {
            NoVP no = new NoVP(livro);
            raiz = no;
            raiz.setCor(false);
            System.out.println(livro.getId()/10000000);
        } else {
            if(buscar(livro) == null) {
                auxInsere(null, raiz, livro);
            }
        }
    }
    
    private void auxInsere(NoVP pai, NoVP no, Livro livro) {
        if(no == null) {
            no = new NoVP(livro);
            System.out.println(livro.getId()/10000000);
            no.setPai(pai);
            if(pai != null) {
                if(livro.getId() < pai.getLivro().getId())
                    pai.setEsq(no);
                else 
                    pai.setDir(no);
            }
        } else if(livro.getId() < no.getLivro().getId()) {
            auxInsere(no, no.getEsq(), livro);
        } else {
            auxInsere(no, no.getDir(), livro);
        }
        
        if(pai != null)
            atualizarSubArvore(pai, no);
    }
    
    private void atualizarSubArvore(NoVP pai, NoVP no) {
        if(pai.getPai() != null) { //Avô != null
            if(pai.getLivro().getId() < pai.getPai().getLivro().getId()) { //Pai a esquerda do avô
                if(pai.getCor() && (pai.getPai().getDir() != null && pai.getPai().getDir().getCor())) { //Pai e tio vermelho
                    recolore(pai.getPai(), !pai.getCor());
                    if(raiz == pai.getPai()) //Se o pai é raiz
                        raiz.setCor(false);
                } else if(pai.getCor() && (pai.getPai().getDir() == null || !pai.getPai().getDir().getCor())) { //Pai vermelho e tio preto
                    if(no.getLivro().getId() < pai.getLivro().getId()) { //Nó atual está a esquerda do pai
                        //RotSimplesDir
                        rotacaoSimplesDir(pai.getPai()); //Esq, Esq
                    } else { //Nó atual está a direita do pai
                        //RotDuplaDir
                        NoVP aux = pai.getPai();
                        rotacaoSimplesEsq(pai); //Dir, Esq
                        rotacaoSimplesDir(aux);
                    }
                    recolore(pai, !pai.getCor());
                    if(raiz == pai) //Se o pai é raiz
                        raiz.setCor(false);
                    //Rotação
                    /*
                    Se rot simples = recolore pai e avo
                    se rot dupla = recolore no e avo
                    */
                }
            } else { //Pai a direita do avô
                if(pai.getCor() && (pai.getPai().getEsq() != null && pai.getPai().getEsq().getCor())) { //Pai e tio vermelho
                    recolore(pai.getPai(), true);
                    if(raiz == pai.getPai()) //Se o pai é raiz
                        raiz.setCor(false);
                } else if(pai.getCor() && (pai.getPai().getEsq() == null || !pai.getPai().getEsq().getCor())) { //Pai vermelho e tio preto
                    if(no.getLivro().getId() < pai.getLivro().getId()) { //Nó atual está a esquerda do pai
                        //RotDuplaEsq
                        NoVP aux = pai.getPai();
                        rotacaoSimplesDir(pai);
                        rotacaoSimplesEsq(aux);
                    } else { //Nó atual está a direita do pai
                        //RotSimplesEsq
                        rotacaoSimplesEsq(pai.getPai());
                    }
                    recolore(pai, !pai.getCor());
                    if(raiz == pai) //Se o pai é raiz
                        raiz.setCor(false);
                    //Rotação
                    /*
                    Se rot simples = recolore pai e avo
                    se rot dupla = recolore no e avo
                    */
                }
            }
        }
    }
    
    private void rotacaoSimplesEsq(NoVP p) {
        NoVP q = p.getDir();
        p.setDir(q.getEsq());
        if(p.getDir() != null) 
            p.getDir().setPai(p);
        q.setEsq(p);
        if(p.getPai() != null) {
            if(p.getLivro().getId() < p.getPai().getLivro().getId())
                p.getPai().setEsq(q);
            else
                p.getPai().setDir(q);
            q.setPai(p.getPai());
        } else {
            raiz = q;
            q.setPai(null);
        }
        p.setPai(q);
    }
    
    private void rotacaoSimplesDir(NoVP p) {
        NoVP q = p.getEsq();
        p.setEsq(q.getDir());
        if(p.getEsq()!= null) 
            p.getEsq().setPai(p);
        q.setDir(p);
        if(p.getPai() != null) {
            if(p.getLivro().getId() < p.getPai().getLivro().getId())
                p.getPai().setEsq(q);
            else
                p.getPai().setDir(q);
            q.setPai(p.getPai());
        } else {
            raiz = q;
            q.setPai(null);
        }
        p.setPai(q);
    }
    
    private void recolore(NoVP no, boolean cor) {
        if(no != null) {
            no.setCor(cor);
            recolore(no.getEsq(), !cor);
            recolore(no.getDir(), !cor);
        }
    }
    
    public void print() {
        auxPrint(raiz, 0);
    }
    
    private void auxPrint(NoVP p, int nivel) {
        if(p != null) {
            System.out.print("("+nivel+")");
            for(int i=0; i< nivel; i++) {
                System.out.print("--");
            }
            if(p.getCor())
                System.out.println("V");
            else 
                System.out.println("P");
            auxPrint(p.getEsq(), nivel+1);
            auxPrint(p.getDir(), nivel+1);
        }
    }
}
