package Registros;

public class Livro {
    private int[] authors; //Nomes dos autores no authors.csv
    private String bestsellers_rank; //Ranking de livros mais vendidos
    private int[] categories; //Nomes da categoria no categories.cs
    private String edition; //Edição
    private long id; //Id do livro
    private String isbn10; //ISBN-10
    private String isbn13; //ISBN-13
    private String rating_avg; //Avaliação média
    private String rating_count; //Número de avaliações
    private String title; //Título

    //Construtor vázio
    public Livro() {
    }

    /**
     * Contrutor
     * @param authors
     * @param bestsellers_rank
     * @param categories
     * @param edition
     * @param id
     * @param isbn10
     * @param isbn13
     * @param rating_avg
     * @param rating_count
     * @param title 
     */
    public Livro(int[] authors, String bestsellers_rank, int[] categories, String edition, long id, String isbn10, String isbn13, String rating_avg, String rating_count, String title) {
        this.authors = authors;
        this.bestsellers_rank = bestsellers_rank;
        this.categories = categories;
        this.edition = edition;
        this.id = id;
        this.isbn10 = isbn10;
        this.isbn13 = isbn13;
        this.rating_avg = rating_avg;
        this.rating_count = rating_count;
        this.title = title;
    }
    
    //Set's e Get's
    public void setAuthors(int[] authors) {
        this.authors = authors;
    }

    public void setBestsellers_rank(String bestsellers_rank) {
        this.bestsellers_rank = bestsellers_rank;
    }

    public void setCategories(int[] categories) {
        this.categories = categories;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setIsbn10(String isbn10) {
        this.isbn10 = isbn10;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public void setRating_avg(String rating_avg) {
        this.rating_avg = rating_avg;
    }

    public void setRating_count(String rating_count) {
        this.rating_count = rating_count;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public int[] getAuthors() {
        return authors;
    }
    
    public String getBestsellers_rank() {
        return bestsellers_rank;
    }
    
    public int[] getCategories() {
        return categories;
    }
    
    public String getEdition() {
        return edition;
    }

    public long getId() {
        return id;
    }

    public String getIsbn10() {
        return isbn10;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public String getRating_avg() {
        return rating_avg;
    }

    public String getRating_count() {
        return rating_count;
    }

    public String getTitle() {
        return title;
    }
    
    
    //Imprimir as variáveis
    public void print(){
        System.out.print("\"");
        for(int i : this.authors) {
            System.out.print(i + ", ");
        }
        System.out.print("\",\""+this.bestsellers_rank+"\",\"");
        for(int i : this.categories) {
            System.out.print(i + ", ");
        }
        System.out.println(
                "\",\""
                + this.edition
                + "\",\""
                + this.id
                + "\",\""
                + this.isbn10
                + "\",\""
                + this.isbn13
                + "\",\""
                + this.rating_avg
                + "\",\""
                + this.rating_count
                + "\",\""
                + this.title
                + "\"");
    }
}
