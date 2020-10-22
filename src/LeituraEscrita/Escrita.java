package LeituraEscrita;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Escrita {
    private static final String arquivoSaida = "Saidas/saida.txt";
    private final FileWriter saida;
    private final PrintWriter gravarSaida;
    
    public Escrita() throws IOException {
        saida = new FileWriter(arquivoSaida);
        gravarSaida = new PrintWriter(saida);
    }
    
    //INÍCIO - PARTE 1
    public void imprimeCabecalio(String execucao) {
        gravarSaida.write("-----------------------------------------------------------\n");
        gravarSaida.write("Parte 1 - "+execucao+"\n");
        gravarSaida.write("Tamanho\t\tTempo(ms)\tCópias\t\tComparações\n");
    }
    public void imprimeDados(int parametro, long tempo, long copias, long comparacoes) {
        gravarSaida.write(parametro+"\t\t"+tempo+"\t\t"+copias+"\t\t"+comparacoes+"\n");
    }
    //FINAL - PARTE 1
    
    
    //Início - Funções de uso geral
    public void impressao(String texto) {
        gravarSaida.write(texto);
    }
    
    public void close() throws IOException {
        saida.close();
    }
    //Final - Funções de uso geral
}
