/*
 * IT ACADEMY  .
 * Fonaments de la programació -POO-
 * M7 exercici extra   Ruleta Russa.
 */
package m7ruletarussa;

/**
 *
 * @author Juan José Campos Caballero.
 */
public class Jugador {
    
    // propietats ----------------------------------------
    private int id;
    private String nombre="";
    private String nickName="";
    Boolean viu;
    
    // Constructors ----------------------------------------

    public Jugador(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        nickName=nombre+id;
        viu=true;
    }
    
    // Getters, Setters, i toString --------------------------

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Boolean getViu() {
        return viu;
    }

    public void setViu(Boolean viu) {
        this.viu = viu;
    }

    @Override
    public String toString() {
        return "Jugador{ \n" + "id= " + id + ", \nnombre= " + nombre + ", \nnickName= " + nickName + ", \nviu= " + viu + " }";
    }
    
    // Mètodes  ----------------------------------------
    public void jugar(Revolver r){
        if(r.disparar()){
            viu=false;
        }
    }
    
    
    
    
    
    
    
}
