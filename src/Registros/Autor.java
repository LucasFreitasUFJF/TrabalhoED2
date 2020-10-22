package Registros;

public class Autor {
    private long id;
    private String name;
    
    //Contrutor defaulf
    public Autor() {
        
    }
    
    /**
     * Construtor
     * @param id do autor
     * @param name do autor
     */
    public Autor(long id, String name) {
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
