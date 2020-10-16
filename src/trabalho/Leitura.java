package trabalho;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Leitura {
    private static final char VIRGULA = ',';
    private static final char ASPAS = '"';
    private static final String livrosCSV = "dataset.csv";
    private ArrayList<Registro> leituraDados;
    private long tempoInicial;
    private long tempoFinal;

    public Leitura() throws IOException {
        this.leituraDados = new ArrayList<Registro>();
    }
    
    //Função para ler parâmetros
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
            Logger.getLogger(Leitura.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    //Retorn um vetor com N elementos do arquivo pre carregado
    public Registro[] lerArquivo(int quantidade) throws IOException {
        Registro[] dados = new Registro[quantidade]; //Vetor para armazenar e retornar o dados aleatórios do documento .csv
        Random r = new Random(System.currentTimeMillis());// Classe para gerar numeros aleatórios
        int e = 0;
        
        if(this.leituraDados.size() < quantidade) {
            dados = null;
            System.out.println("Erro: não há "+quantidade+" registros pre carregados disponiveis!");
            return dados;
        }
        
        System.out.println("Escolhendo "+ quantidade + " números aleatorios...");
        tempoInicial = System.currentTimeMillis();
        ArrayList<Integer> numAleatorios = new ArrayList<>(); //Lista para armazenar numeros já sorteados
        boolean sorteado = false;
        while (e < quantidade ) { //Gera o vetor que será ordenado/ inserido na tabela hash
           int aleatorio = r.nextInt(leituraDados.size()); //Gera um valor aleatório entre 0 e a quantidade de registros - 1
           for(int l=0; l<numAleatorios.size(); l++) {
                if(aleatorio == numAleatorios.get(l)) {
                    sorteado = true;
                }
           }

           if(!sorteado) {
                numAleatorios.add(aleatorio);
                dados[e] = this.leituraDados.get(aleatorio); //insere no vetor o valor aleatorio corresponde no vetor que contem todos os registros criados
                e++; // incrementa a variavel de controle
           } 
           sorteado = false;
        }
        tempoFinal = System.currentTimeMillis();
        System.out.println("A randomização do arquivo demorou: " + (tempoFinal - tempoInicial) + " ms\n");
        
        return dados;
    }
    
    //Pre recarrega os dados para o uso durante toda execução
    public void preCarregarArquivo() throws IOException {
        try {
            System.out.println("Pre carregando arquivo em memória...");
            tempoInicial = System.currentTimeMillis();
            BufferedReader leitura = new BufferedReader(new FileReader(this.livrosCSV));// Lê o arquivo CSV
            String linha = leitura.readLine();// Lê a primeira linha
            linha = leitura.readLine();// Pula o cabeçalho do arquivo
            int i = 0;
            String texto = "";
            boolean entreAspas = false;
            int coluna = 0;
            String[] campos = new String[25];// Vetor das colunas no arquivo csv
            while (linha != null && i < 540000) {
                char[] caracteres = linha.toCharArray();// Tranforma a linha lida em um vetor de char
                // Loop para andar em todas os campos do vetor de char
                for (int j = 0; j < caracteres.length;) {
                    // Verifica se não está entre aspas
                    if (entreAspas != true) {
                        if (caracteres[j] == this.VIRGULA) {// Ignora a vírgula
                            coluna++;
                            texto = "";
                            j++;
                        }
                    }
                    if (entreAspas == true && (caracteres[j] == '[' || caracteres[j] == ']')){
                        j++;
                    }
                    // Verifica se o caractere é aspas
                    if ( caracteres[j] == this.ASPAS ) {
                        if (entreAspas) { entreAspas = false; }// Se tiver fora das aspas
                        else { entreAspas = true; }// Se tiver entre aspas
                    }
                    // Verifica se é um campo vazio no vetor
                    if (caracteres[j] == this.ASPAS && j+1 < caracteres.length ) {
                        if(caracteres[j+1] == this.ASPAS ){ texto = ""; }
                    }
                    texto += caracteres[j];// Concatena os caracteres
                    campos[coluna] = texto;// Coloca o texto no vetor das colunas
                    campos[coluna] = campos[coluna].replaceAll("\"", "");// Remove as aspas dos textos
                    j++;
                }
                // Insere os valores no vetor de Registros
                this.leituraDados.add( new Registro(campos[0], campos[1], campos[2], campos[3], campos[4], campos[5], campos[6], campos[7], campos[8], campos[9], campos[10], campos[11], campos[12], campos[13], campos[14], campos[15], campos[16], campos[17], campos[18], campos[19], campos[20], campos[21], campos[22], campos[23], campos[24]) );
                i++;
                linha = leitura.readLine();// Lê a proxima linha
                coluna = 0;// Volta para a primeira coluna
                texto = "";// Reseta o texto
                
                //Temporário. Apenas para verificar andamento da leitura
                if(this.leituraDados.size() == 100000) {
                    System.out.println("100.000");
                } else if(this.leituraDados.size() == 150000) {
                    System.out.println("150.000");
                } else if(this.leituraDados.size() == 200000) {
                    System.out.println("200.000");
                } else if(this.leituraDados.size() == 250000) {
                    System.out.println("250.000");
                } else if(this.leituraDados.size() == 300000) {
                    System.out.println("300.000");
                } else if(this.leituraDados.size() == 350000) {
                    System.out.println("350.000");
                } else if(this.leituraDados.size() == 400000) {
                    System.out.println("400.000");
                } else if(this.leituraDados.size() == 450000) {
                    System.out.println("450.000");
                } else if(this.leituraDados.size() == 500000) {
                    System.out.println("500.000");
                }
            }  
            tempoFinal = System.currentTimeMillis();
            System.out.println("O pre carregamento demorou: " + (tempoFinal - tempoInicial) + " ms\n");
            leitura.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Erro na leitura do arquivo."); //mensagem de erro caso não seja possivel realizar a leitura do arquivo
        }
    }
        
}