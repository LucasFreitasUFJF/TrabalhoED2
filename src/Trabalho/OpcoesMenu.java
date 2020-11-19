package Trabalho;

import Arvore.ArvoreVP;
import Hash.HashAutor;
import Hash.HashLivro;
import Hash.NoAutor;
import Registros.Livro;
import LeituraEscrita.Leitura;
import LeituraEscrita.Escrita;
import java.io.IOException;
import java.util.ArrayList;
import Ordenacao.HeapSort;
import Ordenacao.InsertionSort;
import Ordenacao.MergeSort;
import Ordenacao.QuickSort;
import Ordenacao.ShellSort;
import Registros.Autor;
import java.util.Scanner;

public class OpcoesMenu {
    private final Dados dados;
    private final Leitura leitura; 
    private final Escrita escrita;
    
    public OpcoesMenu() throws IOException {
        dados = new Dados();
        leitura = new Leitura();
        escrita = new Escrita();
        
        dados.preCarregarArquivos();
    }
    
    //INÍCIO - PARTE 1
    public void executarParte1() throws IOException {
        Livro[] vetorOriginal; //Vetor original com valores aleatórios
        Livro[] vetorAuxiliar; //Vetor usado para clone do vetor original
        int execucoes = 5;
        ArrayList<Integer> parametrosN = leitura.lerParametros("Parte 1.txt");
        if(parametrosN != null) {
            long[][] mediaInsertion = new long[parametrosN.size()][3]; //Armazena a média do Insertionsort
            long[][] mediaShell = new long[parametrosN.size()][3]; //Armazena a média do ShellSort
            long[][] mediaMerge = new long[parametrosN.size()][3]; //Armazena a média do MergeSort
            long[][] mediaQuickRec = new long[parametrosN.size()][3]; //Armazena a média do QuickSort Recursivo
            long[][] mediaHeap = new long[parametrosN.size()][3]; //Armazena a média do HeapSort
            
            for(int i=0; i<execucoes; i++) {//Executa 5 vezes os testes
                for(int j=0; j<parametrosN.size(); j++) {
                    vetorOriginal = dados.getNLivros(parametrosN.get(j));
                    
                    if(vetorOriginal != null) {
                        //Ordena com InsertionSort
                        Metrica.clear();
                        vetorAuxiliar = (Livro[])vetorOriginal.clone();
                        System.out.println("Parte 1: Ordenando estrutura com InsertionSort...");
                        InsertionSort.ordena(vetorAuxiliar);
                        System.out.println("Ordenação feita em = " + Metrica.getTempo() + " ms\n");
                        mediaInsertion[j][0] += Metrica.getTempo();
                        mediaInsertion[j][1] += Metrica.getCopias();
                        mediaInsertion[j][2] += Metrica.getComparacoes();
                        
                        //Ordena com ShellSort
                        Metrica.clear();
                        vetorAuxiliar = (Livro[])vetorOriginal.clone();
                        System.out.println("Parte 1: Ordenando estrutura com ShellSort...");
                        ShellSort.ordena(vetorAuxiliar);
                        System.out.println("Ordenação feita em = " + Metrica.getTempo() + " ms\n");
                        mediaShell[j][0] += Metrica.getTempo();
                        mediaShell[j][1] += Metrica.getCopias();
                        mediaShell[j][2] += Metrica.getComparacoes();
                        
                        //Ordena com MergeSort
                        Metrica.clear();
                        vetorAuxiliar = (Livro[])vetorOriginal.clone();
                        System.out.println("Parte 1: Ordenando estrutura com MergeSort...");
                        MergeSort.ordena(vetorAuxiliar);
                        System.out.println("Ordenação feita em = " + Metrica.getTempo() + " ms\n");
                        mediaMerge[j][0] += Metrica.getTempo();
                        mediaMerge[j][1] += Metrica.getCopias();
                        mediaMerge[j][2] += Metrica.getComparacoes();
                        
                        //Ordena com QuickSort Recursivo
                        Metrica.clear();
                        vetorAuxiliar = (Livro[])vetorOriginal.clone();
                        System.out.println("Parte 1: Ordenando estrutura com QuickSort Recursivo...");
                        QuickSort.ordena_Recursivo(vetorAuxiliar);
                        System.out.println("Ordenação feita em = " + Metrica.getTempo() + " ms\n");
                        mediaQuickRec[j][0] += Metrica.getTempo();
                        mediaQuickRec[j][1] += Metrica.getCopias();
                        mediaQuickRec[j][2] += Metrica.getComparacoes();
                        
                        //Ordena com HeapSort
                        Metrica.clear();
                        vetorAuxiliar = (Livro[])vetorOriginal.clone();
                        System.out.println("Parte 1: Ordenando estrutura com HeapSort...");
                        HeapSort.ordena(vetorAuxiliar);
                        System.out.println("Ordenação feita em = " + Metrica.getTempo() + " ms\n");
                        mediaHeap[j][0] += Metrica.getTempo();
                        mediaHeap[j][1] += Metrica.getCopias();
                        mediaHeap[j][2] += Metrica.getComparacoes();
                    }
                }
            }
            int k;
            
            //Imprie a média InsertionSort
            escrita.imprimeCabecalio("Média InsertionSort");
            for(k=0; k<parametrosN.size(); k++) {
                escrita.imprimeDados(parametrosN.get(k), (mediaInsertion[k][0]/execucoes), mediaInsertion[k][1]/execucoes, mediaInsertion[k][2]/execucoes);
            }
            
            //Imprie a média ShellSort
            escrita.imprimeCabecalio("Média ShellSort");
            for(k=0; k<parametrosN.size(); k++) {
                escrita.imprimeDados(parametrosN.get(k), (mediaShell[k][0]/execucoes), mediaShell[k][1]/execucoes, mediaShell[k][2]/execucoes);
            }
            
            //Imprie a média MergeSort
            escrita.imprimeCabecalio("Média MergeSort");
            for(k=0; k<parametrosN.size(); k++) {
                escrita.imprimeDados(parametrosN.get(k), (mediaMerge[k][0]/execucoes), mediaMerge[k][1]/execucoes, mediaMerge[k][2]/execucoes);
            }
            
            //Imprie a média QuickSort Recursivo
            escrita.imprimeCabecalio("Média QuickSort Recursivo");
            for(k=0; k<parametrosN.size(); k++) {
                escrita.imprimeDados(parametrosN.get(k), (mediaQuickRec[k][0]/execucoes), mediaQuickRec[k][1]/execucoes, mediaQuickRec[k][2]/execucoes);
            }
            
            //Imprie a média HeapSort
            escrita.imprimeCabecalio("Média HeapSort");
            for(k=0; k<parametrosN.size(); k++) {
                escrita.imprimeDados(parametrosN.get(k), (mediaHeap[k][0]/execucoes), mediaHeap[k][1]/execucoes, mediaHeap[k][2]/execucoes);
            }
        }
    }
    //FINAL - PARTE 1
    
    //INÍCIO - PARTE 2
    public void executarParte2() throws IOException {
        ArrayList<Integer> parametrosN = leitura.lerParametros("Parte 2.txt");
        Scanner teclado = new Scanner(System.in);
        int M;
        
        if(parametrosN != null && parametrosN.size() > 0) {
            Livro[] livros = dados.getNLivros(parametrosN.get(0));
            Autor[] autores = dados.getAutores();
            
            System.out.println("Digite o valor de M: ");
            M = teclado.nextInt();
            
            HashLivro hashLivro=new HashLivro(100000);
            HashAutor hashAutor=new HashAutor(60000, M);
            for(int i=0; i<parametrosN.size(); i++) {
            //    livros = dados.getNLivros(parametrosN.get(i));
                for(Livro livro : livros){
                    hashLivro.insere(livro);
                    for(long id : livro.getAuthors()){
                        for(Autor autor : autores){
                            if(id == autor.getId()){
                                hashAutor.insere(autor);
                                break;
                            }
                        }
                    }
                }
            }
            hashAutor.imprimeMaisFreq();
            //hashLivro.imprime();
            //System.out.println(" ");
            //hashAutor.imprime();
        }
    }
    //FINAL - PARTE 2
    
    //INÍCIO - PARTE 3
    public void executarParte3() throws IOException {
        ArrayList<Integer> parametrosN = leitura.lerParametros("Parte 3.txt");
        Livro[] livros = dados.getNLivros(10);
        ArvoreVP avp = new ArvoreVP();
        for(Livro livro : livros) {
            avp.insere(livro);
        }
        avp.print();
    }
    //FINAL - PARTE 3
    
    
    
    
    
    
    
     /*public void test() {
        Livro[] livros = dados.getNLivros(10);
        MergeSort.ordena(livros);
        for(Livro livro : livros) {
            System.out.println(livro.getTitle());
        }
    }*/
    
    private void print(Livro[] livros) {
        for (Livro livro : livros) {
            livro.print();
        }
    }
    
    
    
    private boolean testeEquals(Livro[] vetor) {
        for(int i=0; i<vetor.length; i++) {
            for(int j=i+1; j<vetor.length; j++) {
                if(vetor[i].getTitle().equals(vetor[j].getTitle())) {
                    return true;
                }
            }
        }
        return false;
    }
    
    //Início - Funções de uso geral
    public void closeEscrita() throws IOException {
        escrita.close();
    }
    //Final - Funções de uso geral
}
