package LeituraEscrita;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Escrita {
    private static final String caminhoSaida = "Saidas/";
    private final FileWriter saida;
    private final PrintWriter gravarSaida;
    
    
    public Escrita(String arquivoSaida) throws IOException {
        saida = new FileWriter(caminhoSaida+arquivoSaida);
        gravarSaida = new PrintWriter(saida);
    }
    
    //INÍCIO - PARTE 1
    public void imprimeCabecalioP1(String execucao) {
        gravarSaida.write("-----------------------------------------------------------\n");
        gravarSaida.write("Parte 1 - "+execucao+"\n");
        gravarSaida.write("Tamanho\t\tTempo(ms)\tCópias\t\tComparações\n");
    }
    public void imprimeDadosP1(int parametro, long tempo, long copias, long comparacoes) {
        gravarSaida.write(parametro+"\t\t"+tempo+"\t\t"+copias+"\t\t"+comparacoes+"\n");
    }
    //FINAL - PARTE 1
    
    //INÍCIO - PARTE 2
    public void imprimeCabecalioP2(int n, int m, long tempohashLivro, long colisoesHashLivros, long tempoHashAutores, long colisoesHashAutores) {
        gravarSaida.write("-----------------------------------------------------------\n");
        gravarSaida.write("Parte 2 - N = "+n+", M = "+m+"\n\n");
        gravarSaida.write("HashLivro\n\tTempo = "+tempohashLivro+"ms\n\tColisões = "+colisoesHashLivros+"\n");
        gravarSaida.write("Busca HashLivro e insersão hashAutores\n\tTempo = "+tempoHashAutores+"ms\n\tColisões = "+colisoesHashAutores+"\n\n");
        gravarSaida.write("Frequencia\t\tAutor\n");
    }
    public void imprimeDadosP2(int freq, String autor) {
        gravarSaida.write(freq+"\t\t\t"+autor+"\n");
    }
    //FINAL - PARTE 2
    
    //INÍCIO - PARTE 3
    public void imprimeCabecalioP3(String execucao, boolean tipoArvore) {
        gravarSaida.write("-----------------------------------------------------------\n");
        gravarSaida.write("Parte 3 - "+execucao+"\n");
        if(tipoArvore) {
            gravarSaida.write("Tamanho\t\tTempo(ms)\tCompações\tRotações\n");
        } else {
            gravarSaida.write("Tamanho\t\tTempo(ms)\tCompações\tOverFlows\n");
        }
    }
    public void imprimeDadosP3(long parametro, long tempo, long comparacoes, long rotOver) {
        gravarSaida.write(parametro+"\t\t"+tempo+"\t\t"+comparacoes+"\t\t"+rotOver+"\n");
    }
    //FINAL - PARTE 3
    
    
    //Início - Funções de uso geral
    public void impressao(String texto) {
        gravarSaida.write(texto);
    }
    
    public void close() throws IOException {
        saida.close();
    }
    //Final - Funções de uso geral
}
