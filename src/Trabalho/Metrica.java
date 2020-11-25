package Trabalho;

//Classe com métodos estáticos para armazenar as métricas das execuções
public class Metrica {
    private static long comparacoes;
    private static long copias;
    private static long tempo;
    
    private static long colisoes;
    
    private static long rotacoes; // <- ArvoreVP
    public static long overflow;
    
    public static void clear() {
        comparacoes = 0;
        copias = 0;
        tempo = 0;
        colisoes = 0;
        rotacoes = 0;
        overflow = 0;
    }
    
    //Set's e increment's
    public static boolean incrementaComparacoes() {
        Metrica.comparacoes++;
        return true;
    }
    public static void incrementaCopias() {
        Metrica.copias++;
    }
    public static void setTempo(long tempo) {
        Metrica.tempo = tempo;
    }
    public static void incrementaColisoes() {
        Metrica.colisoes++;
    }
    public static void incrementaRotacoes() {
        Metrica.rotacoes++;
    }
    public static void incrementaOverflow() {
        Metrica.overflow++;
    } 
    
    //Get's
    public static long getComparacoes() {
        return comparacoes;
    }
    public static long getCopias() {
        return copias;
    }
    public static long getTempo() {
        return tempo;
    }
    public static long getColisoes() {
        return colisoes;
    }
    public static long getRotacoes() {
        return rotacoes;
    }
    public static long getOverflow() {
        return overflow;
    }
}
