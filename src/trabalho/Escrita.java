package trabalho;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Escrita {
    private static final String arquivoSaida = "Saidas/saida.txt";
    private FileWriter saida;
    private PrintWriter gravarSaida;
    
    public Escrita() throws IOException {
        saida = new FileWriter(arquivoSaida);
        gravarSaida = new PrintWriter(saida);
    }
    
    //INÍCIO - PARTE 1 DO TRABALHO
        //INÍCIO - CENÁRIO 1, 2 E 3
    public void imprimeCabecalio(int cenario, String execucao) {
        gravarSaida.write("-----------------------------------------------------------\n");
        gravarSaida.write("Parte 1 - Cenário "+cenario+" - "+execucao+"\n");
        gravarSaida.write("Tamanho\t\tTempo(ms)\tCópias\t\tComparações\n");
    }
    public void imprimeDados(int parametro, long tempo, long copias, long comparacoes) {
        gravarSaida.write(parametro+"\t\t"+tempo+"\t\t"+copias+"\t\t"+comparacoes+"\n");
    }
        //FINAL - CENÁRIO 1, 2 E 3
        //INÍCIO - CENÁRIO 4
    
        //FINAL - CENÁRIO 4
    //FINAL - PARTE 1 DO TRABALHO
    
    //INÍCIO - PARTE 2 DO TRABALHO
    
    //FINAL - PARTE 2 DO TRABALHO
    
    //Início - Funções de uso geral
    public void impressao(String texto) {
        gravarSaida.write(texto);
    }
    
    public void close() throws IOException {
        saida.close();
    }
    //Final - Funções de uso geral
}
