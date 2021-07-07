/*
 * IT ACADEMY  .
 * Fonaments de la programació -POO-
 * M7 exercici 4
 */
package m7exercici4;

/**
 * 
 * @author Juanjo Campos
 */
public class Cinema extends Edifici{
    
    private int aforament;
    
    // ----- Constructors ------------------------------------------------------

    public Cinema(String nom, int plantes, int superficie, int aforament) {
        super(nom, plantes, superficie);
        this.aforament = aforament;
    }
    
    //---------Getters, Setters i toString -------------------------------------

    public int getAforament() {
        return aforament;
    }

    public void setAforament(int aforament) {
        this.aforament = aforament;
    }

    @Override
    public String toString() {
        String missatge;
        
        missatge="--> " +super.getNom();
        missatge+="\n -Plantes : "+super.getPlantes()+" -Superfície : "+super.getSuperficie();
        missatge+="\n aforament : "+this.aforament;
        
        return missatge;
        
    }
    
    // -------- Mètodes --------------------------------------------------------

    public String projectarSessio (int assistents, double preuEntrada){
        //Definició de variables
        double recaptacio;
        String missatge="";
        
        if (assistents<=this.aforament){
           recaptacio=assistents*preuEntrada;
           missatge+="Dades de la sessio: \n";
           missatge+="- Assistents : "+assistents;
           missatge+="- Preu de l'entrada : "+preuEntrada;
           missatge+="-- Total de la recaptació : : "+recaptacio;
           
        }else{
            missatge="ATENCIÓ: El nombre d'assistents supera l'aforament de la sala ";
        }
        
        return missatge;
    }
    
    
    
    @Override
    public void calcularCostVigilancia() {
        int nombreDeVigilants=super.getSuperficie()/3000;
        int costVigilancia=nombreDeVigilants*1300;
        
        System.out.println("El nombre de vigilants és de : "+nombreDeVigilants+" i tenen un cost de :"+costVigilancia+" euros.");
        
    }    
    
    
}
