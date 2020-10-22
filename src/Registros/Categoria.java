package Registros;

public class Categoria {
    private long id;
    private String name;
    
    //Construtor default
    public Categoria() {
        
    }
    
    /**
     * Construtor
     * @param id da categoria
     * @param name da categoria
     */
    public Categoria(long id, String name) {
        this.id = id;
        this.name = name;
    }
    
    //Set's e Get's
    public void setId(long id) {
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    
    //Imprimir as variáveis
    public void print() {
        System.out.println("\""+id+"\",\""+name+"\"");
    }
}
