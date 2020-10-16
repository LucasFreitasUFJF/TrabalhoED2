package trabalho;
//26 variaves

public class Registro {
    private String URL_BASE = "https://bookdepository.com";
    //Variáveis do arquivo csv dataset.csv
    private String authors; //Nomes dos autores no authors.csv
    private String bestsellers_rank; //Ranking de livros mais vendidos
    private String categories; //Nomes da categoria no categories.cs
    private String edition; //Edição
    private long id; //Id do livro
    private String isbn10; //ISBN-10
    private String isbn13; //ISBN-13
    private String rating_avg; //Avaliação média
    private String rating_count; //Número de avaliações
    private String title; //Título

    //Construtor vázio
    public Registro() {
    }
    //Contrutor com todas as variáveis

    public Registro(String authors, String bestsellers_rank, String categories, String edition, String id, String isbn10, String isbn13, String rating_avg, String rating_count, String title) {
        this.authors = authors;
        this.bestsellers_rank = bestsellers_rank;
        this.categories = categories;
        this.edition = edition;
        this.id = Long.parseLong(id);
        this.isbn10 = isbn10;
        this.isbn13 = isbn13;
        this.rating_avg = rating_avg;
        this.rating_count = rating_count;
        this.title = title;
    }
    
    
    //Gets ++++++++++++++++++++++++++++++++++++++++++++++
    public String getAuthors() {
        return authors;
    }
    

    public String getBestsellers_rank() {
        return bestsellers_rank;
    }

    public String getCategories() {
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
    //+++++++++++++++++++++++++++++++++++++++++++++++++++
    
    //Imprimir as variáveis
    public void print(){
        System.out.println(this.authors
                + "|"
                + this.bestsellers_rank
                + "|"
                + this.categories
                + "|"
                + this.edition
                + "|"
                + this.id
                + "|"
                + this.isbn10
                + "|"
                + this.isbn13
                + "|"
                + this.rating_avg
                + "|"
                + this.rating_count
                + "|"
                + this.title);
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }
    
    
}
