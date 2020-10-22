package trabalho;

import java.io.IOException;
import java.util.ArrayList;
import ordenacao.HeapSort;
import ordenacao.InsertionSort;
import ordenacao.MergeSort;
import ordenacao.QuickSort;

public class OpcoesMenu {
    private ArrayList<Integer> parametrosN;
    private Leitura leitura; //Inicializa a classe para executar a leitura do arquivo .csv
    private Escrita escrita; //Inicializa a classe para executar a escrita do arquivo saida.txt
    
    //Ordenadores
    QuickSort quickSort;
    InsertionSort insertionSort;
    MergeSort mergeSort;
    HeapSort heapSort;
    
    public OpcoesMenu() throws IOException {
        leitura = new Leitura();
        escrita = new Escrita();
        quickSort = new QuickSort();
        insertionSort = new InsertionSort();
        mergeSort = new MergeSort();
        heapSort = new HeapSort();
        
        leitura.preCarregarArquivo();
    }
    
    //INÍCIO - PARTE 1
        //INÍCIO - CENÁRIO 1
    public void executarParte1Cenario1() throws IOException {
        Registro[] vetor;
        int execucoes = 5;
        parametrosN = leitura.lerParametros("Parte 1 - cenario 1.txt");
        if(parametrosN != null) {
            long[][] media = new long[parametrosN.size()][3];
            
            for(int j=0; j<execucoes; j++) { //Executa 5 vezes os testes

                for(int k=0; k<parametrosN.size(); k++) {
                    vetor = leitura.lerArquivo(parametrosN.get(k)); //Lê o arquivo .csv e passa para o vetor os dados

                    if(vetor != null) {
                        Metrica.clear();
                        System.out.println("Parte 1 - Cenário 1: Ordenando estrutura com QuickSort Recursivo...");
                        quickSort.ordena_Recursivo(vetor);
                        System.out.println("Ordenação feita em = " + Metrica.getTempo() + " ms\n");

                        media[k][0] += Metrica.getTempo();
                        media[k][1] += Metrica.getCopias();
                        media[k][2] += Metrica.getComparacoes();

                    }
                }
            }
            //Imprie a média
            escrita.imprimeCabecalio(1, "Média");
            for(int l=0; l<parametrosN.size(); l++) {
                escrita.imprimeDados(parametrosN.get(l), (media[l][0]/execucoes), media[l][1]/execucoes, media[l][2]/execucoes);
            }
        } else {
            System.out.println("Nenhum parâmetro encoontrado");
        }
    }
        //FINAL - CENÁRIO 1
        //INICIO - CENÁRIO 2
    public void executarParte1Cenario2(int[] k, int[] m) throws IOException {
        Registro[] vetorR;
        Registro[][] vetorM = new Registro[k.length][];
        Registro[][] vetorI = new Registro[m.length][];
        int execucoes = 5;
        parametrosN = leitura.lerParametros("Parte 1 - cenario 2.txt");
        if(parametrosN != null) {
            long[][] mediaR = new long[parametrosN.size()][3]; //Armazena a média do QuickSort Recursivo
            long[][][] mediaM = new long[k.length][parametrosN.size()][3]; //Armazena a média do QuickSort Mediana
            long[][][] mediaI = new long[m.length][parametrosN.size()][3]; //Armazena a média do QuickSort Inserção
            
            for(int j=0; j<execucoes; j++) { //Executa 5 vezes os testes

                for(int l=0; l<parametrosN.size(); l++) {
                    vetorR = leitura.lerArquivo(parametrosN.get(l));
                    if(vetorR != null) {
                        int aux;
                        for(aux = 0; aux<k.length; aux++) { vetorM[aux] = (Registro[])vetorR.clone(); }
                        for(aux = 0; aux<m.length; aux++) { vetorI[aux] = (Registro[])vetorR.clone(); }
                    
                        //Ordena QuickSort Recursivo
                        Metrica.clear();
                        System.out.println("Parte 1 - Cenário 2: Ordenando estrutura com QuickSort Recursivo...");
                        quickSort.ordena_Recursivo(vetorR);
                        System.out.println("Ordenação feita em = " + Metrica.getTempo() + " ms\n");
                        mediaR[l][0] += Metrica.getTempo();
                        mediaR[l][1] += Metrica.getCopias();
                        mediaR[l][2] += Metrica.getComparacoes();

                        //Ordena QuickSort Mediana
                        for(aux=0; aux<k.length; aux++) {
                            Metrica.clear();
                            System.out.println("Parte 1 - Cenário 2: Ordenando estrutura com QuickSort Mediana...");
                            quickSort.ordena_Mediana(vetorM[aux], k[aux]);
                            System.out.println("Ordenação feita em = " + Metrica.getTempo() + " ms\n");
                            mediaM[aux][l][0] += Metrica.getTempo();
                            mediaM[aux][l][1] += Metrica.getCopias();
                            mediaM[aux][l][2] += Metrica.getComparacoes();
                        }
                        
                        //Ordena QuickSort Inserção
                        for(aux=0; aux<m.length; aux++) {
                            Metrica.clear();
                            System.out.println("Parte 1 - Cenário 2: Ordenando estrutura com QuickSort Inserção...");
                            quickSort.ordena_Insercao(vetorI[aux], m[aux]);
                            System.out.println("Ordenação feita em = " + Metrica.getTempo() + " ms\n");
                            mediaI[aux][l][0] += Metrica.getTempo();
                            mediaI[aux][l][1] += Metrica.getCopias();
                            mediaI[aux][l][2] += Metrica.getComparacoes();
                        }
                    }
                }
            }
            
            //Imprime Resultados
            int n, o;
            //QuickSort Recursivo
            escrita.imprimeCabecalio(2, "Média QuickSort Recursivo");
            for(n=0; n<parametrosN.size(); n++) {
                escrita.imprimeDados(parametrosN.get(n), (mediaR[n][0]/execucoes), (mediaR[n][1]/execucoes), (mediaR[n][2]/execucoes));
            }
            
            //QuickSort Mediana
            for(o=0; o<k.length; o++) {
                escrita.imprimeCabecalio(2, "Média QuickSort Mediana com K = "+k[o]);
                for(n=0; n<parametrosN.size(); n++) {
                    escrita.imprimeDados(parametrosN.get(n), (mediaM[o][n][0]/execucoes), (mediaM[o][n][1]/execucoes), (mediaM[o][n][2]/execucoes));
                }
            }
            
            //QuickSort Inserção
            for(o=0; o<m.length; o++) {
                escrita.imprimeCabecalio(2, "Média QuickSort Inserção com M = "+m[o]);
                for(n=0; n<parametrosN.size(); n++) {
                    escrita.imprimeDados(parametrosN.get(n), (mediaI[o][n][0]/execucoes), (mediaI[o][n][1]/execucoes), (mediaI[o][n][2]/execucoes));
                }
            }
        } else {
            System.out.println("Nenhum parâmetro encontrado");
        }
    }
        //FINAL - CENÁRIO 2
        //INÍCIO - CENÁRIO 3
    public void executarParte1Cenario3() throws IOException {
        Registro[] vetorI;
        Registro[] vetorM;
        Registro[] vetorH;
        //Registro[] vetor?;
        int execucoes = 5;
        parametrosN = leitura.lerParametros("Parte 1 - cenario 3.txt");
        if(parametrosN != null) {
            long[][] mediaI = new long[parametrosN.size()][3];
            long[][] mediaM = new long[parametrosN.size()][3];
            long[][] mediaH = new long[parametrosN.size()][3];
            //int[][] media? = new int[parametrosN.size()][3];
            
            for(int i=0; i<execucoes; i++) { //Executa 5 vezes os testes
                for(int j=0; j<parametrosN.size(); j++) {
                    
                    vetorI = leitura.lerArquivo(parametrosN.get(j));
                    if(vetorI != null) {
                        vetorM = (Registro[])vetorI.clone();
                        vetorH = (Registro[])vetorI.clone();
                        //vetor? = (Registro[])vetorI.clone();
                        
                        //Ordena com InsertionSort
                        Metrica.clear();
                        System.out.println("Parte 1 - Cenário 3: Ordenando estrutura com InsertionSort...");
                        insertionSort.ordena(vetorI);
                        System.out.println("Ordenação feita em = " + Metrica.getTempo() + " ms\n");
                        mediaI[j][0] += Metrica.getTempo();
                        mediaI[j][1] += Metrica.getCopias();
                        mediaI[j][2] += Metrica.getComparacoes();
                        
                    
                        //Ordena com MergeSort
                        Metrica.clear();
                        System.out.println("Parte 1 - Cenário 3: Ordenando estrutura com MergeSort...");
                        mergeSort.ordena(vetorM);
                        System.out.println("Ordenação feita em = " + Metrica.getTempo() + " ms\n");
                        mediaM[j][0] += Metrica.getTempo();
                        mediaM[j][1] += Metrica.getCopias();
                        mediaM[j][2] += Metrica.getComparacoes();
                    
                    
                        //Ordena com HeapSort
                        Metrica.clear();
                        System.out.println("Parte 1 - Cenário 3: Ordenando estrutura com HeapSort...");
                        heapSort.ordena(vetorH);
                        System.out.println("Ordenação feita em = " + Metrica.getTempo() + " ms\n");
                        mediaH[j][0] += Metrica.getTempo();
                        mediaH[j][1] += Metrica.getCopias();
                        mediaH[j][2] += Metrica.getComparacoes();
                    
                    
                        //Ordena com MeuSort
//                        Metrica.clear();
//                        System.out.println("Parte 1 - Cenário 3: Ordenando estrutura com MeuSort...");
//                        meuSort.ordena(vetor?);
//                        System.out.println("Ordenação feita em = " + Metrica.getTempo() + " ms\n");
//                        media?[j][0] += Metrica.getTempo();
//                        media?[j][1] += Metrica.getCopias();
//                        media?[j][2] += Metrica.getComparacoes();
                    }
                }
            }
            //IMPRIME RESULTADOS
            int n;
            
            //InsertionSort
            escrita.imprimeCabecalio(3, "Média InsertionSort");
            for(n=0; n<parametrosN.size(); n++) {
                escrita.imprimeDados(parametrosN.get(n), (mediaI[n][0]/execucoes), (mediaI[n][1]/execucoes), (mediaI[n][2]/execucoes));
            }
            
            //MergeSort
            escrita.imprimeCabecalio(3, "Média MergeSort");
            for(n=0; n<parametrosN.size(); n++) {
                escrita.imprimeDados(parametrosN.get(n), (mediaM[n][0]/execucoes), (mediaM[n][1]/execucoes), (mediaM[n][2]/execucoes));
            }
            
            //HeapSort
            escrita.imprimeCabecalio(3, "Média HeapSort");
            for(n=0; n<parametrosN.size(); n++) {
                escrita.imprimeDados(parametrosN.get(n), (mediaH[n][0]/execucoes), (mediaH[n][1]/execucoes), (mediaH[n][2]/execucoes));
            }
            
            //MeuSort
//            escrita.imprimeCabecalio(3, "Média MeuSort");
//            for(n=0; n<parametrosN.size(); n++) {
//                escrita.imprimeDados(parametrosN.get(n), (long)(media?[n][0]/execucoes), (media?[n][1]/execucoes), (media?[n][2]/execucoes));
//            }
        }
    }
        //FINAL - CENÁRIO 3
        //INÍCIO - CENÁRIO 4
    
        //FINAL - CENÁRIO 4
    //FINAL - PARTE 1
    
    //INÍCIO - PARTE 2
    
    //FINAL - PARTE 2
    
    private boolean testeEquals(Registro[] vetor) {
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
