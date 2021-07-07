/*
 * IT ACADEMY  .
 * Fonaments de la programació -POO-
 * Juan José Campos Caballero.
 */
package m7exercici4;

/**
 * M7 exercici 4
 * @author juanjo campos
 **/
public class Hotel extends Edifici {
    private int habitacions;
    
    // --------- Constructor ---------------------------------------------------

    public Hotel(String nom, int plantes, int superficie, int rooms) {
        super(nom, plantes, superficie);
        this.habitacions=rooms;
    }

    // ----------- Getters and Setters  .toString ------------------------------

    public int getHabitacions() {
        return habitacions;
    }

    public void setHabitacions(int habitacions) {
        this.habitacions = habitacions;
    }

    @Override
    public String toString() {
        String missatge;
        
        missatge="--> " +super.getNom();
        missatge+="\n -Plantes : "+super.getPlantes()+" -Superfície : "+super.getSuperficie();
        missatge+="\n nombre d'habitacions : "+this.getHabitacions();
        
        return missatge;
    }
    
    // ---------------------- Mètodes ------------------------------------------
    
    /**
     * costServeiHabitacions
     * 
     * Calcula el nombre de persones i el cost econòmic del servei d'habitacions.
     * 
     */
    public void costServeiHabitacions(){
        // Declaració de variables
        final double souMensual=1000;   // Constant sou de un treballador del servei d'habitacions
        String missatge="";            // Missatge a mostrar amb les dades calculades
        int persones;                 // Nombre de treballadors per prestar el servei. 
        
//Calculem el nombre de persones necessaries pel servei
        persones=habitacions/20;

        //Calculem el cost mensual del servei d'habitacions
        double costMensual=persones*souMensual;
        
        missatge+="El servei d'habitacions necessita "+persones+" persones \n";
        missatge+="El cost menuals del servei és de "+costMensual+" euros";
        
        //mostrem les dades
        System.out.println(missatge);
        
    }


    @Override
    public void calcularCostVigilancia() {
        int nombreDeVigilants=super.getSuperficie()/1000;
        int costVigilancia=nombreDeVigilants*1800;
        
        System.out.println("El nombre de vigilants és de : "+nombreDeVigilants+" i tenen un cost de :"+costVigilancia+" euros.");
        
    }
   
 

  
    
    
    
}
