package Arvore;

import Registros.Livro;
import Trabalho.Metrica;

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
            if(livro.getId() < no.getChave() && Metrica.incrementaComparacoes()) {
                return auxBuscar(no.getEsq(), livro);
            } else if(livro.getId() > no.getChave() && Metrica.incrementaComparacoes()) {
                return auxBuscar(no.getDir(), livro);
            } else {
                return no;
            }
        } else {
            return null;
        }
    }
    
    public void insere(Livro livro) {
        if(buscar(livro) == null) {
            auxInsere(null, raiz, livro);
        }
        raiz.setCor(false);
    }
    
    private void auxInsere(NoVP pai, NoVP no, Livro livro) {
        if(no == null) {
            no = new NoVP(livro.getId(), livro);
            System.out.println(livro.getId()/10000000);
            no.setPai(pai);
            if(pai != null) {
                if(livro.getId() < pai.getChave() && Metrica.incrementaComparacoes())
                    pai.setEsq(no);
                else 
                    pai.setDir(no);
                
                if(no.getPai().getPai() == null)
                    return;
            } else {
                raiz = no;
                no.setCor(false);
                return;
            }
            atualizarInsercao(no);
        } else if(livro.getId() < no.getChave() && Metrica.incrementaComparacoes()) {
            auxInsere(no, no.getEsq(), livro);
        } else {
            auxInsere(no, no.getDir(), livro);
        }
    }
    
    private void atualizarInsercao(NoVP no) {
        if(no.getPai() != null && no.getPai().getPai()!= null && no.getPai().getCor()) {
            if (no.getPai() == no.getPai().getPai().getDir()) { // Pai está a direita do avô
                if (no.getPai().getPai().getEsq() != null && no.getPai().getPai().getEsq().getCor()) { //Pai e tio vermelho
                    no.getPai().getPai().getEsq().setCor(false); // Tio = preto
                    no.getPai().setCor(false); // Pai = preto
                    no.getPai().getPai().setCor(true); // Avô = vermelho
                    atualizarInsercao(no.getPai().getPai());
                } else { // Pai vermelho e tio preto
                    if (no == no.getPai().getEsq()) { // Filho a esquerda do pai
                        no = no.getPai(); // No = Pai
                        rotacaoSimplesDir(no);
                    }
                    no.getPai().setCor(false); // Pai = preto
                    no.getPai().getPai().setCor(true); // Avô = vermelho
                    rotacaoSimplesEsq(no.getPai().getPai());
                    atualizarInsercao(no);
                }
            } else { // Pai está a esquerda do avô
                if (no.getPai().getPai().getDir() != null && no.getPai().getPai().getDir().getCor()) { // Pai e tio vermelho
                    no.getPai().getPai().getDir().setCor(false); // Tio = Preto
                    no.getPai().setCor(false); // Pai = preto
                    no.getPai().getPai().setCor(true); // Avo = vermelho
                    atualizarInsercao(no.getPai().getPai());
                } else { // Pai vermelho e tio preto
                    if (no == no.getPai().getDir()) { // Filho a direita do pai
                        no = no.getPai(); // No = pai
                        rotacaoSimplesEsq(no);
                    }
                    no.getPai().setCor(false); // Pai = preto
                    no.getPai().getPai().setCor(true); // Avô = vermelho
                    rotacaoSimplesDir(no.getPai().getPai());
                    atualizarInsercao(no);
                }
            }
        }
    }
    
    public void remove(Livro livro) {
        if(buscar(livro) != null) {
            auxRemover(raiz, livro);
            
        }
    }
    
    private void auxRemover(NoVP no, Livro livro) {
        if(no == null)
            return;
        else if(no.getChave() == livro.getId()) {
            if(no.getEsq() != null && no.getDir() != null) { // Dois filhos
                NoVP aux = no.getEsq();
                while(aux.getDir() != null)
                    aux = aux.getDir();
                no.setChave(aux.getChave());
                no.setValor(aux.getValor());
                aux.setChave(livro.getId());
                aux.setValor(livro);
                auxRemover(no.getEsq(), livro);
            } else if(no.getEsq() == null && no.getDir() == null) {
                NoVP aux;
                if(no == no.getPai().getEsq()) {
                    no.getPai().setEsq(null);
                    aux = no.getPai().getDir();
                } else {
                    no.getPai().setDir(null);
                    aux = no.getPai().getEsq();
                }
                no = null;
                if(aux != null && aux.getEsq() != null && aux.getDir() != null)
                    atualizaRemocao(aux);
            } else {
                NoVP aux;
                if(no.getDir() != null)
                    aux = no.getDir();
                else
                    aux = no.getEsq();
                
                if(no == no.getPai().getEsq())
                    no.getPai().setEsq(aux);
                else
                    no.getPai().setDir(aux);
                aux.setPai(no.getPai());
                aux.setCor(true);
                no = null;
                if(aux.getEsq() != null && aux.getDir() != null)
                    atualizaRemocao(aux);
            }
        } else if(livro.getId() < no.getChave())
            auxRemover(no.getEsq(), livro);
        else
            auxRemover(no.getDir(), livro);
    }
    
    private void atualizaRemocao(NoVP x) {
        if(x != raiz && !x.getCor()) {
            NoVP s;
            if (x == x.getPai().getEsq()) {
                s = x.getPai().getDir();
                if(s != null) {
                    if (s.getCor()) {
                        s.setCor(false);
                        x.getPai().setCor(true);
                        rotacaoSimplesEsq(x.getPai());
                        s = x.getPai().getDir();
                    }
                    if (!s.getEsq().getCor() && !s.getDir().getCor()) {
                        s.setCor(true);
                        x = x.getPai();
                    } else {
                        if (!s.getDir().getCor()) {
                            s.getEsq().setCor(false);
                            s.setCor(true);
                            rotacaoSimplesDir(s);
                            s = x.getPai().getDir();
                        } 
                        s.setCor(x.getPai().getCor());
                        x.getPai().setCor(false);
                        s.getDir().setCor(false);
                        rotacaoSimplesEsq(x.getPai());
                        x = raiz;
                    }
                }
            } else {
                s = x.getPai().getEsq();
                if(s != null) {
                    if (s.getCor()) {
                        s.setCor(false);
                        x.getPai().setCor(true);
                        rotacaoSimplesDir(x.getPai());
                        s = x.getPai().getEsq();
                    }
                    if (!s.getEsq().getCor() && !s.getDir().getCor()) {
                        s.setCor(true);
                        x = x.getPai();
                    } else {
                        if (!s.getEsq().getCor()) {
                            s.getDir().setCor(false);
                            s.setCor(true);
                            rotacaoSimplesEsq(s);
                            s = x.getPai().getEsq();
                        } 
                        s.setCor(x.getPai().getCor());
                        x.getPai().setCor(false);
                        s.getEsq().setCor(false);
                        rotacaoSimplesDir(x.getPai());
                        x = raiz;
                    }
                }
            } 
            atualizaRemocao(x);
        }
    }
    
    private void rotacaoSimplesEsq(NoVP p) {
        Metrica.incrementaRotacoes();
        NoVP q = p.getDir();
        p.setDir(q.getEsq());
        if(p.getDir() != null) 
            p.getDir().setPai(p);
        q.setEsq(p);
        if(p.getPai() != null) {
            if(p.getChave() < p.getPai().getChave())
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
        Metrica.incrementaRotacoes();
        NoVP q = p.getEsq();
        p.setEsq(q.getDir());
        if(p.getEsq()!= null) 
            p.getEsq().setPai(p);
        q.setDir(p);
        if(p.getPai() != null) {
            if(p.getChave() < p.getPai().getChave())
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
