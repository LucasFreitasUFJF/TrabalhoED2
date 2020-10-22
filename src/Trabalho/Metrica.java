package trabalho;


public class Metrica {
    private static long comparacoes;
    private static long copias;
    private static long tempo;
    
    public static void clear() {
        comparacoes = 0;
        copias = 0;
        tempo = 0;
    }
    
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
    
    public static long getComparacoes() {
        return comparacoes;
    }
    public static long getCopias() {
        return copias;
    }
    public static long getTempo() {
        return tempo;
    }
}
