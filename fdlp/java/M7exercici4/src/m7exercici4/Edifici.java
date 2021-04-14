/*
 * IT ACADEMY  .
 * Fonaments de la programació -POO-
 * Juan José Campos Caballero.
 */
package m7exercici4;

/**
 * M7 exercici 4
 * 
 * @author juanjo Campos
 */
public abstract class Edifici {
    
    //propietats --------------------------------------------------------------- 
    private String nom;
    private int plantes;
    private int superficie;
    
    // constructors ------------------------------------------------------------
    public Edifici(String nom, int plantes, int superficie) {
        this.nom = nom;
        this.plantes = plantes;
        this.superficie = superficie;
    }
    
    // Getters and Setters -----------------------------------------------------

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPlantes() {
        return plantes;
    }

    public void setPlantes(int plantes) {
        this.plantes = plantes;
    }

    public int getSuperficie() {
        return superficie;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    @Override
    public String toString() {
        return "Edifici: "+nom+"\n- plantes=" + plantes +"\n- superficie=" + superficie + '\n';
    }
   
   // Mètodes ------------------------------------------------------------------
   /**
    *netejar()
    * 
    * Calcula el temps i el cost de la neteja de l'edifici.
    */ 
   public void netejar(){
       double tempsSuperficie=0;    // Temps en netejar la superficie de l'edifici
       double tempsPlantes=0;      // Temps de desplaçament per les plantes
       double tempsTotal=0;       // Temps total en netejar l'edifici 
       double preuMinutNeteja=1; // Preu del minut de neteja
       double costDiariNeteja;  // Cost diari de la neteja de l'edifici.
       
       
       //Calcul minuts per superficie
       tempsSuperficie=(superficie/5);
       
       //Calcul minuts desplaçament per plantes
       if(plantes>1){
        tempsPlantes=plantes*0.5;
       }
       
       tempsTotal=tempsSuperficie+tempsPlantes;
       costDiariNeteja=tempsTotal*preuMinutNeteja;
       
       System.out.println("Minuts totals de neteja : "+tempsTotal+" = "+(tempsTotal/60)+" hores");
       System.out.println("Preu diari de la neteja : "+costDiariNeteja);
       System.out.println("Cost mensual de la neteja : "+costDiariNeteja*30);       
   }
   
  
   public abstract void calcularCostVigilancia();
   
}
