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
    public void imprimeCabecalioP2(int n, int m) {
        gravarSaida.write("-----------------------------------------------------------\n");
        gravarSaida.write("Parte 2 - N = "+n+", M = "+m+"\n");
        gravarSaida.write("Frequencia\t\tAutor\n");
    }
    public void imprimeDadosP2(int freq, String autor) {
        gravarSaida.write(freq+"\t"+autor+"\n");
    }
    //FINAL - PARTE 2
    
    //INÍCIO - PARTE 3
    public void imprimeCabecalioP3() {
        
    }
    public void imprimeDadosP3() {
        
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
