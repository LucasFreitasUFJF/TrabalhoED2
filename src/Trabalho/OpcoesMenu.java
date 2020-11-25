package Trabalho;

import Arvore.ArvoreB;
import Arvore.ArvoreVP;
import Hash.HashAutor;
import Hash.HashLivro;
import Hash.NoAutor;
import Hash.NoLivro;
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

    public OpcoesMenu() throws IOException {
        dados = new Dados();
        leitura = new Leitura();

        dados.preCarregarArquivos();
    }

    //INÍCIO - PARTE 1
    public void executarParte1() throws IOException {
        Escrita escrita = new Escrita("ResultadoParte1.txt");
        Livro[] vetorOriginal; //Vetor original com valores aleatórios
        Livro[] vetorAuxiliar; //Vetor usado para clone do vetor original
        int execucoes = 5;
        ArrayList<Integer> parametrosN = leitura.lerParametros("Parte 1.txt");
        if (parametrosN != null) {
            long[][] mediaInsertion = new long[parametrosN.size()][3]; //Armazena a média do Insertionsort
            long[][] mediaShell = new long[parametrosN.size()][3]; //Armazena a média do ShellSort
            long[][] mediaMerge = new long[parametrosN.size()][3]; //Armazena a média do MergeSort
            long[][] mediaQuickRec = new long[parametrosN.size()][3]; //Armazena a média do QuickSort Recursivo
            long[][] mediaHeap = new long[parametrosN.size()][3]; //Armazena a média do HeapSort

            for (int i = 0; i < execucoes; i++) {//Executa 5 vezes os testes
                for (int j = 0; j < parametrosN.size(); j++) {
                    vetorOriginal = dados.getNLivros(parametrosN.get(j));

                    if (vetorOriginal != null) {
                        //Ordena com InsertionSort
                        Metrica.clear();
                        vetorAuxiliar = (Livro[]) vetorOriginal.clone();
                        System.out.println("Parte 1: Ordenando estrutura com InsertionSort...");
                        InsertionSort.ordena(vetorAuxiliar);
                        System.out.println("Ordenação feita em = " + Metrica.getTempo() + " ms\n");
                        mediaInsertion[j][0] += Metrica.getTempo();
                        mediaInsertion[j][1] += Metrica.getCopias();
                        mediaInsertion[j][2] += Metrica.getComparacoes();

                        //Ordena com ShellSort
                        Metrica.clear();
                        vetorAuxiliar = (Livro[]) vetorOriginal.clone();
                        System.out.println("Parte 1: Ordenando estrutura com ShellSort...");
                        ShellSort.ordena(vetorAuxiliar);
                        System.out.println("Ordenação feita em = " + Metrica.getTempo() + " ms\n");
                        mediaShell[j][0] += Metrica.getTempo();
                        mediaShell[j][1] += Metrica.getCopias();
                        mediaShell[j][2] += Metrica.getComparacoes();

                        //Ordena com MergeSort
                        Metrica.clear();
                        vetorAuxiliar = (Livro[]) vetorOriginal.clone();
                        System.out.println("Parte 1: Ordenando estrutura com MergeSort...");
                        MergeSort.ordena(vetorAuxiliar);
                        System.out.println("Ordenação feita em = " + Metrica.getTempo() + " ms\n");
                        mediaMerge[j][0] += Metrica.getTempo();
                        mediaMerge[j][1] += Metrica.getCopias();
                        mediaMerge[j][2] += Metrica.getComparacoes();

                        //Ordena com QuickSort Recursivo
                        Metrica.clear();
                        vetorAuxiliar = (Livro[]) vetorOriginal.clone();
                        System.out.println("Parte 1: Ordenando estrutura com QuickSort Recursivo...");
                        QuickSort.ordena_Recursivo(vetorAuxiliar);
                        System.out.println("Ordenação feita em = " + Metrica.getTempo() + " ms\n");
                        mediaQuickRec[j][0] += Metrica.getTempo();
                        mediaQuickRec[j][1] += Metrica.getCopias();
                        mediaQuickRec[j][2] += Metrica.getComparacoes();

                        //Ordena com HeapSort
                        Metrica.clear();
                        vetorAuxiliar = (Livro[]) vetorOriginal.clone();
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
            escrita.imprimeCabecalioP1("Média InsertionSort");
            for (k = 0; k < parametrosN.size(); k++) {
                escrita.imprimeDadosP1(parametrosN.get(k), (mediaInsertion[k][0] / execucoes), mediaInsertion[k][1] / execucoes, mediaInsertion[k][2] / execucoes);
            }

            //Imprie a média ShellSort
            escrita.imprimeCabecalioP1("Média ShellSort");
            for (k = 0; k < parametrosN.size(); k++) {
                escrita.imprimeDadosP1(parametrosN.get(k), (mediaShell[k][0] / execucoes), mediaShell[k][1] / execucoes, mediaShell[k][2] / execucoes);
            }

            //Imprie a média MergeSort
            escrita.imprimeCabecalioP1("Média MergeSort");
            for (k = 0; k < parametrosN.size(); k++) {
                escrita.imprimeDadosP1(parametrosN.get(k), (mediaMerge[k][0] / execucoes), mediaMerge[k][1] / execucoes, mediaMerge[k][2] / execucoes);
            }

            //Imprie a média QuickSort Recursivo
            escrita.imprimeCabecalioP1("Média QuickSort Recursivo");
            for (k = 0; k < parametrosN.size(); k++) {
                escrita.imprimeDadosP1(parametrosN.get(k), (mediaQuickRec[k][0] / execucoes), mediaQuickRec[k][1] / execucoes, mediaQuickRec[k][2] / execucoes);
            }

            //Imprie a média HeapSort
            escrita.imprimeCabecalioP1("Média HeapSort");
            for (k = 0; k < parametrosN.size(); k++) {
                escrita.imprimeDadosP1(parametrosN.get(k), (mediaHeap[k][0] / execucoes), mediaHeap[k][1] / execucoes, mediaHeap[k][2] / execucoes);
            }
        }
        escrita.close();
    }
    //FINAL - PARTE 1

    //INÍCIO - PARTE 2
    public void executarParte2() throws IOException {
        Escrita escrita = new Escrita("ResultadoParte2.txt");
        ArrayList<Integer> parametrosN = leitura.lerParametros("Parte 2.txt");
        Scanner teclado = new Scanner(System.in);
        int M;

        if (parametrosN != null && parametrosN.size() > 0) {
            Livro[] livros = dados.getNLivros(parametrosN.get(0));
            Autor[] autores = dados.getAutores();

            long[][] resultado = new long[2][2]; // Posição 0 = Inserção livro, Posição 1 = Busca na tabela livro e inserção na tabela autor || tempo e colisões
            long tempoInicial;
            long tempoFinal;
            
            System.out.println("Digite o valor de M(qtde de frequêntes): ");
            M = teclado.nextInt();

            HashLivro hashLivro = new HashLivro(100000);
            HashAutor hashAutor = new HashAutor(60000, M);
            
            // Inserção tabela livros
            Metrica.clear();
            tempoInicial = System.currentTimeMillis();
            for (Livro livro : livros) {
                hashLivro.insere(livro);
            }
            tempoFinal = System.currentTimeMillis();
            resultado[0][0] = tempoFinal-tempoInicial;
            resultado[0][1] = Metrica.getColisoes();
            
            //Busca na tabela livro e inserção na tabela autor
            Metrica.clear();
            NoLivro aux;
            tempoInicial = System.currentTimeMillis();
            for(Livro livro : livros) {
                aux = hashLivro.busca(livro.getId());
                if(aux != null) {
                    for (long id : aux.getValor().getAuthors()) {
                        for (Autor autor : autores) {
                            if (id == autor.getId()) {
                                hashAutor.insere(autor);
                                break;
                            }
                        }
                    }
                }
            }
            tempoFinal = System.currentTimeMillis();
            resultado[1][0] = tempoFinal-tempoInicial;
            resultado[1][1] = Metrica.getColisoes();
            
            
            NoAutor[] autoresFrequentes = hashAutor.getMaisFreq();
            escrita.imprimeCabecalioP2(parametrosN.get(0), M, resultado[0][0], resultado[0][1], resultado[1][0], resultado[1][1]);
            for(int j=autoresFrequentes.length-1; j>=0; j--) {
                escrita.imprimeDadosP2(autoresFrequentes[j].getCont(), autoresFrequentes[j].getNomeAutor());
            }
            escrita.close();
        }
    }
    //FINAL - PARTE 2

    //INÍCIO - PARTE 3
    public void executarParte3() throws IOException {
        int execucoes = 5;
        ArrayList<Integer> parametrosN = leitura.lerParametros("Parte 3.txt");
        Livro[] livros;
        
        ArvoreVP avp;
        ArvoreB arb1; //Passar valor d = ?
        ArvoreB arb2; // Passar valor d = ?
        
        if(parametrosN != null) {
            long[][][] mediaArvoreVP = new long[parametrosN.size()][2][3]; //Busca e Inserção || tempo, comparacoes e rotacões
            long[][][] mediaArvoreB1 = new long[parametrosN.size()][2][2]; //Busca e Inserção || tempo e overflows
            long[][][] mediaArvoreB2 = new long[parametrosN.size()][2][2]; //Busca e Inserção || tempo e overflows
            long tempoInicial;
            long tempoFinal;
            for(int i=0; i< execucoes; i++) {
                for(int j=0; j<parametrosN.size(); j++) {
                    avp = new ArvoreVP();
                    arb1 = new ArvoreB(5);
                    arb2 = new ArvoreB(41);
                    livros = dados.getNLivros(parametrosN.get(j));
                    int k;
                    /*
                    //Inserção ArvoreVP
                    Metrica.clear();
                    tempoInicial = System.currentTimeMillis();
                    for(k=0; k<livros.length; k++) {
                        avp.insere(livros[k]);
                    }
                    tempoFinal = System.currentTimeMillis();
                    mediaArvoreVP[j][0][0] += tempoFinal - tempoInicial;
                    mediaArvoreVP[j][0][1] += Metrica.getComparacoes();
                    mediaArvoreVP[j][0][2] += Metrica.getRotacoes();
                    */
                    //Inserção ArvoreB d = ?
                    Metrica.clear();
                    tempoInicial = System.currentTimeMillis();
                    for(k=0; k<livros.length; k++) {
                        arb1.insere(livros[k]);
                    }
                    tempoFinal = System.currentTimeMillis();
                    arb1.print();
                    mediaArvoreB1[j][0][0] += tempoFinal - tempoInicial;
                    mediaArvoreB1[j][0][1] += Metrica.getOverflow();
                    
                    //Inserção ArvoreB d = ?
                    /*
                    Metrica.clear();
                    tempoInicial = System.currentTimeMillis();
                    for(k=0; k<livros.length; k++) {
                        arb2.insere(livros[k]);
                    }
                    tempoFinal = System.currentTimeMillis();
                    mediaArvoreB2[j][0][0] += tempoFinal - tempoInicial;
                    mediaArvoreB2[j][0][1] += Metrica.getOverflow();
                    
                    //Busca ArvoreVP
                    Metrica.clear();
                    tempoInicial = System.currentTimeMillis();
                    for(k=0; k<livros.length; k++) {
                        avp.buscar(livros[k]);
                    }
                    tempoFinal = System.currentTimeMillis();
                    mediaArvoreVP[j][1][0] += tempoFinal - tempoInicial;
                    mediaArvoreVP[j][1][1] += Metrica.getComparacoes();
                    mediaArvoreVP[j][1][2] += Metrica.getRotacoes();
                    
                    //Busca ArvoreB d = ?
                    Metrica.clear();
                    tempoInicial = System.currentTimeMillis();
                    for(k=0; k<livros.length; k++) {
                        arb1.buscar(livros[k]);
                    }
                    tempoFinal = System.currentTimeMillis();
                    mediaArvoreB1[j][1][0] += tempoFinal - tempoInicial;
                    mediaArvoreB1[j][1][1] += Metrica.getOverflow();
                    
                    //Busca ArvoreB d = ?
                    Metrica.clear();
                    tempoInicial = System.currentTimeMillis();
                    for(k=0; k<livros.length; k++) {
                        arb2.buscar(livros[k]);
                    }
                    tempoFinal = System.currentTimeMillis();
                    mediaArvoreB2[j][0][0] += tempoFinal - tempoInicial;
                    mediaArvoreB2[j][0][1] += Metrica.getOverflow();*/
                }
            }
        }
        
        //Fazer impressão do resultado
    }
    //FINAL - PARTE 3

    
    private void print(Livro[] livros) {
        for (Livro livro : livros) {
            livro.print();
        }
    }

    private boolean testeEquals(Livro[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[i].getTitle().equals(vetor[j].getTitle())) {
                    return true;
                }
            }
        }
        return false;
    }

    //Início - Funções de uso geral
    
    //Final - Funções de uso geral
}
