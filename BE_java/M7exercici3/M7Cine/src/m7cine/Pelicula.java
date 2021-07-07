/*
 * IT ACADEMY  .
 * Fonaments de la programació -POO-
 * M7 exercici extra Cinema.
 */
package m7cine;


/**
 *
 * @author Juan José Campos Caballero.
 */
public class Pelicula {
    // PROPIETATS ------------------------------------
    private String titulo;
    private int duracio;
    private int edatMitjana;
    private String director;

    
    // CONSTRUCTORS ------------------------------------
    public Pelicula(String titulo, int duracio, int edatMitjana, String director ){
        this.titulo=titulo;
        this.duracio=duracio;
        this.edatMitjana=edatMitjana;
        this.director=director;
    }
    
    // GETTERS, SETTERS I toString() -------------------
    public String getTitulo(){
        return titulo;
    }
    
    public int getDuracio(){
        return duracio;
    }
    
    public int getEdatMitjana(){
        return edatMitjana;
    }
    
    public String getDirector(){
        return director;
    }
    
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    
    public void setDuracio(int duracio){
        this.duracio = duracio;
    }
    public void setEdatMitjana(int edatMitjana){
        this.edatMitjana = edatMitjana;
    }
    public void setDirector(String director){
        this.director = director;        
    }
    
    @Override
    public String toString(){
        return "PEL·LICULA:  Titulo : "+titulo+" duracio : "+duracio+" edat mitjana : "+edatMitjana+" director : "+director;
    }
    
    // MÈTODES ---- ------------------------------------
    
    
    
    
}
