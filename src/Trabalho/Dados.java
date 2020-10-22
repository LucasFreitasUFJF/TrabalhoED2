package Trabalho;

import Registros.Autor;
import Registros.Categoria;
import Registros.Livro;
import java.util.ArrayList;
import LeituraEscrita.Leitura;
import java.io.IOException;
import java.util.Random;

public class Dados {
    private Livro[] livros;
    private Autor[] autores;
    private Categoria[] categorias;
    
    private final Leitura leitura;
    
    /**
     * Classe para armazenar livro, autores e categorias, e retorna-los sempre que nescessário
     * @throws IOException 
     */
    public Dados() throws IOException {
        leitura = new Leitura();
    }
    
    /**
     * Pré-carrega arquivos em memória
     * @throws IOException 
     */
    public void preCarregarArquivos() throws IOException {
        System.out.println("Pré-carregando livros em memória!");
        livros = leitura.lerLivros();
        System.out.println("Pré-carregando autores em memória!");
        autores = leitura.lerAutores();
        System.out.println("Pré-carregando categorias em memória!");
        categorias = leitura.lerCategorias();
    }
    
    /**
     * @param n Quantidade de valores a seren retornados
     * @return Vetor de N livros aleatórios
     */
    public Livro[] getNLivros(int n) {
        Livro[] randomLivros = new Livro[n];
        Random r = new Random(System.currentTimeMillis());
        
        if(this.livros.length < n) {
            System.out.println("Erro: não há "+n+" livros pre carregados disponiveis!");
            return null;
        }
        
        System.out.println("Escolhendo "+ n + " números aleatorios...");
        ArrayList<Integer> numAleatorios = new ArrayList<>(); //Lista para armazenar numeros já sorteados
        for(int i=0; i<n;) { //Gera o vetor que será ordenado/ inserido na tabela hash
           int aleatorio = r.nextInt(livros.length); //Gera um valor aleatório entre 0 e a quantidade de registros - 1

           if(!numAleatorios.contains(aleatorio)) {
                numAleatorios.add(aleatorio);
                randomLivros[i] = livros[aleatorio];  //insere no vetor o valor aleatorio corresponde no vetor que contem todos os registros criados
                i++;
           }
        }
        
        return randomLivros;
    }

    /**
     * @return Array de livros lidos 
     */
    public Livro[] getLivros() {
        return livros;
    }

    /**
     * @return Array de autores lidos 
     */
    public Autor[] getAutores() {
        return autores;
    }

    /**
     * @return Array de categorias lidos 
     */
    public Categoria[] getCategorias() {
        return categorias;
    }
}
