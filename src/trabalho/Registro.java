package trabalho;
//26 variaves

public class Registro {
    private String URL_BASE = "https://bookdepository.com";
    //Variáveis do arquivo csv dataset.csv
    private String authors; //Nomes dos autores no authors.csv
    private String bestsellers_rank; //Ranking de livros mais vendidos
    private String categories; //Nomes da categoria no categories.csv
    private String description; //Descrição
    private String dimension_x; //Altura
    private String dimension_y; //Largura
    private String dimension_z; //Espessura
    private String edition; //Edição
    private String edition_statement; //Informação da edição
    private String for_ages; //Classificação indicativa;
    private String format; //Nomes do formato no formats.csv
    private String id; //Id do livro
    private String ilustrations_notes; //Notas de ilustração
    private String imprint; //Selo
    private String index_date; //Data
    private String isbn10; //ISBN-10
    private String isbn13; //ISBN-13
    private String lang; //Lista de idiomas
    private String publication_date; //Data de publicação
    private String publication_place; //Id fo local de publicação. Nome localizado no places.csv
    private String rating_avg; //Avaliação média
    private String rating_count; //Número de avaliações
    private String title; //Título
    private String url; //URL relativa https://bookdepositoty.com + url
    private String weight; //Peso

    //Construtor vázio
    public Registro() {
    }
    //Contrutor com todas as variáveis

    public Registro(String authors, String bestsellers_rank, String categories, String description, String dimension_x, String dimension_y, String dimension_z, String edition, String edition_statement, String for_ages, String format, String id, String ilustrations_notes, String imprint, String index_date, String isbn10, String isbn13, String lang, String publication_date, String publication_place, String rating_avg, String rating_count, String title, String url, String weight) {
        this.authors = authors;
        this.bestsellers_rank = bestsellers_rank;
        this.categories = categories;
        this.description = description;
        this.dimension_x = dimension_x;
        this.dimension_y = dimension_y;
        this.dimension_z = dimension_z;
        this.edition = edition;
        this.edition_statement = edition_statement;
        this.for_ages = for_ages;
        this.format = format;
        this.id = id;
        this.ilustrations_notes = ilustrations_notes;
        this.imprint = imprint;
        this.index_date = index_date;
        this.isbn10 = isbn10;
        this.isbn13 = isbn13;
        this.lang = lang;
        this.publication_date = publication_date;
        this.publication_place = publication_place;
        this.rating_avg = rating_avg;
        this.rating_count = rating_count;
        this.title = title;
        this.url = this.URL_BASE + url;
        this.weight = weight;
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

    public String getIndex_date() {
        return index_date;
    }

    public String getDescription() {
        return description;
    }

    public String getDimension_x() {
        return dimension_x;
    }

    public String getDimension_y() {
        return dimension_y;
    }

    public String getDimension_z() {
        return dimension_z;
    }

    public String getEdition() {
        return edition;
    }

    public String getEdition_statement() {
        return edition_statement;
    }

    public String getFor_ages() {
        return for_ages;
    }

    public String getFormat() {
        return format;
    }

    public String getId() {
        return id;
    }

    public String getIlustrations_notes() {
        return ilustrations_notes;
    }

    public String getImprint() {
        return imprint;
    }

    public String getIsbn10() {
        return isbn10;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public String getLang() {
        return lang;
    }

    public String getPublication_date() {
        return publication_date;
    }

    public String getPublication_place() {
        return publication_place;
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

    public String getUrl() {
        return url;
    }

    public String getWeight() {
        return weight;
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
                + this.description
                + "|"
                + this.dimension_x
                + "|"
                + this.dimension_y
                + "|"
                + this.dimension_z
                + "|"
                + this.edition
                + "|"
                + this.edition_statement
                + "|"
                + this.for_ages
                + "|"
                + this.format
                + "|"
                + this.id
                + "|"
                + this.ilustrations_notes
                + "|"
                + this.imprint
                + "|"
                + this.index_date
                + "|"
                + this.isbn10
                + "|"
                + this.isbn13
                + "|"
                + this.lang
                + "|"
                + this.publication_date
                + "|"
                + this.publication_place
                + "|"
                + this.rating_avg
                + "|"
                + this.rating_count
                + "|"
                + this.title
                + "|"
                + this.url
                + "|"
                + this.weight);
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }
    
    
}
