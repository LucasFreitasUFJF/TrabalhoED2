package LeituraEscrita;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import Registros.Autor;
import Registros.Categoria;
import Registros.Livro;

public class Leitura {
    private final char ASPAS = '"';
    
    private final String livrosCSV = "Entradas/dataset_simp_sem_descricao.csv";
    private final String autoresCSV = "Entradas/authors.csv";
    private final String categoriasCSV = "Entradas/categories.csv";
    
    private long tempoInicial;
    private long tempoFinal;

    public Leitura() throws IOException {
    }
    
    /**
     * Função para ler parâmetros
     * @param arquivoNome Nome do arquivo a ser lido
     * @return ArrayList dos parâmetros
     * @throws IOException 
     */
    public ArrayList<Integer> lerParametros(String arquivoNome) throws IOException {
        ArrayList<Integer> parametros = new ArrayList<>();
        try {
            BufferedReader leitura = new BufferedReader(new FileReader("Entradas/"+arquivoNome));
            String linha = leitura.readLine();
            
            while(linha != null) {
                parametros.add(Integer.parseInt(linha));
                linha = leitura.readLine();
            }
            leitura.close();
            return parametros;
        } catch (FileNotFoundException ex) {
            System.out.println("ERRO: Não foi possível ler o arquivo de parâmetros!");
            return null;
        }
    }
    
    /**
     * Função para ler livros
     * @return Array de livros
     * @throws IOException 
     */
    public Livro[] lerLivros() throws IOException {
        try {
            ArrayList<Livro> livros = new ArrayList<>();
            tempoInicial = System.currentTimeMillis();
            BufferedReader leitura = new BufferedReader(new FileReader(livrosCSV));
            String linha = leitura.readLine();
            String[] campos = new String[10];
            while (linha != null) {
                divideCampos(linha.toCharArray(), campos);
                
                livros.add(new Livro(converteStringParaVecInt(campos[0]), campos[1], converteStringParaVecInt(campos[2]), campos[3], converterStringParaLong(campos[4]), campos[5], campos[6], campos[7], campos[8], campos[9]));
                
                linha = leitura.readLine();// Lê a proxima linha
            }
            tempoFinal = System.currentTimeMillis();
            System.out.println("Foram lidos " + livros.size() + " livros em " + (tempoFinal - tempoInicial) + " ms\n");
            leitura.close();
            
            Livro[] rLivros = livros.toArray(new Livro[livros.size()]); //Converte ArrayList para vetor
            livros.clear(); //Libera memória do arrayList
            return rLivros;
        } catch (FileNotFoundException ex) {
            System.out.println("ERRO: Não foi possível ler o arquivo de livros!"); //mensagem de erro caso não seja possivel realizar a leitura do arquivo
            return null;
        }
    }
    
    /**
     * Função para ler autores
     * @return Array de autores
     * @throws IOException 
     */
    public Autor[] lerAutores() throws IOException {
        try {
            ArrayList<Autor> autores = new ArrayList<>();
            tempoInicial = System.currentTimeMillis();
            BufferedReader leitura = new BufferedReader(new FileReader(autoresCSV));
            String linha = leitura.readLine(); //Pula primeira linha
            linha = leitura.readLine();
            String[] campos = new String[2];
            while (linha != null) {
                divideCampos(linha.toCharArray(), campos);

                autores.add(new Autor(converterStringParaLong(campos[0]), campos[1]));
                
                linha = leitura.readLine();// Lê a proxima linha
            }
            tempoFinal = System.currentTimeMillis();
            System.out.println("Foram lidos " + autores.size() + " autores em " + (tempoFinal - tempoInicial) + " ms\n");
            leitura.close();
            
            Autor[] rAutores = autores.toArray(new Autor[autores.size()]); //Converte ArrayList para vetor
            autores.clear(); //Libera memória do arrayList
            return rAutores;
        } catch (FileNotFoundException ex) {
            System.out.println("ERRO: Não foi possível ler o arquivo de autores!"); //mensagem de erro caso não seja possivel realizar a leitura do arquivo
            return null;
        }
    }
    
    /**
     * Função para ler categorias
     * @return Array de categorias
     * @throws IOException 
     */
    public Categoria[] lerCategorias() throws IOException {
        try {
            ArrayList<Categoria> categorias = new ArrayList<>();
            tempoInicial = System.currentTimeMillis();
            BufferedReader leitura = new BufferedReader(new FileReader(categoriasCSV));
            String linha = leitura.readLine(); //Pula primeira linha
            linha = leitura.readLine();
            String[] campos = new String[2];
            while (linha != null) {
                divideCampos(linha.toCharArray(), campos);

                categorias.add(new Categoria(converterStringParaLong(campos[0]), campos[1]));
                
                linha = leitura.readLine();// Lê a proxima linha
            }
            tempoFinal = System.currentTimeMillis();
            System.out.println("Foram lidos " + categorias.size() + " autores em " + (tempoFinal - tempoInicial) + " ms\n\n");
            leitura.close();
            
            Categoria[] rCategorias = categorias.toArray(new Categoria[categorias.size()]); //Converte ArrayList para vetor
            categorias.clear(); //Libera memória do arrayList
            return rCategorias;
        } catch (FileNotFoundException ex) {
            System.out.println("ERRO: Não foi possível ler o arquivo de categorias!"); //mensagem de erro caso não seja possivel realizar a leitura do arquivo
            return null;
        }
    }
    
    /**
     * Função para ler cada linha dos arquivos .csv e dividi-la em campos
     * @param caracteres Vetor de caracteres
     * @param campos Vetor para dividir os campos
     */
    private void divideCampos(char[] caracteres, String[] campos) {
        boolean entreAspas = false;
        String texto = "";
        int coluna = 0;
        for (int j = 0; j < caracteres.length; j++) {
            if(entreAspas) {
                if(caracteres[j] == this.ASPAS){
                    if(j+1 < caracteres.length) {
                        if(caracteres[j+1] == this.ASPAS) {
                            texto += "\"";
                            j++;
                        } else {
                            entreAspas = false;
                            campos[coluna] = texto;
                            coluna++;
                            texto = "";
                        }
                    } else {
                        entreAspas = false;
                        campos[coluna] = texto;
                        coluna++;
                        texto = "";
                    }
                } else {
                    texto += caracteres[j];
                }
            } else {
                if(caracteres[j] == this.ASPAS) {
                    entreAspas = true;
                    texto = "";
                }
            }
        }
    }
    
    /**
     * Função para converter uma string de numeroes em vetor de int -
     * @param frase Frase a ser convertida
     * @return Vetor de inteiros
     */
    private int[] converteStringParaVecInt(String frase) {
        frase = frase.replace("[", ""); //Remove [ da string
        frase = frase.replace("]", ""); //Remove ] da string
        if(frase != "") {
            String[] campos = frase.split(","); //Divide a frase pela vírgula
            int[] vetor = new int[campos.length];
            for(int i=0; i<campos.length; i++) {
                vetor[i] = converterStringParaInt(campos[i].trim());
            }
            return vetor;
        } else {
            return null;
        }
    }
    
    /**
     * Converte string para inteiro se possível. Caso não seja possível, retorna 0 (zero).
     * @param frase String a ser convertida
     * @return Inteiro convertido
     */
    private int converterStringParaInt(String frase) {
        try {
            if(frase != "") {
                return Integer.parseInt(frase);
            } else {
                return 0;
            }
        } catch (NumberFormatException e) {
            //System.out.println("Falha ao converter "+frase+" para int");
            return 0;
        }
    }
    
    /**
     * Converte string para float se possível. Caso não seja possível, retorna 0 (zero).
     * @param frase String a ser convertida
     * @return Float convertido
     */
    private float converterStringParaFloat(String frase) {
        try {
            if(frase != "") {
                return Float.parseFloat(frase);
            } else {
                return 0;
            }
        } catch (NumberFormatException e) {
            //System.out.println("Falha ao converter string para float");
            return 0;
        }
    }
    
    /**
     * Converte string para long se possível. Caso não seja possível, retorna 0 (zero).
     * @param frase String a ser convertida
     * @return Long convertido
     */
    private long converterStringParaLong(String frase) {
        try {
            if(frase != "") {
                return Long.parseLong(frase);
            } else {
                return 0;
            }
        } catch (NumberFormatException e) {
            //System.out.println("Falha ao converter string para long");
            return 0;
        }
    }
}