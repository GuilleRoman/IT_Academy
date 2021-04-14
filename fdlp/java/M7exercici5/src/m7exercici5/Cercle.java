/*
 * IT ACADEMY  .
 * Fonaments de la programació -POO-
 * M7 exercici 5
 */
package m7exercici5;

/**
 *
 * @author Juan José Campos Caballero.
 */
public class Cercle {
    // ---------- Propietats ---------------------------------------------------
    private Punt centre;
    private double radi;
    
    // ---------- Constructors--------------------------------------------------
    public Cercle(Punt centre, int radi){
        this.centre=centre;
        this.radi=radi;
    }
                
            
   // ---------- Getters, Setters i toString------------------------------------

    public Punt getCentre() {
        return centre;
    }

    public void setCentre(Punt centre) {
        this.centre = centre;
    }

    public double getRadi() {
        return radi;
    }

    public void setRadi(int radi) {
        this.radi = radi;
    }

    @Override
    public String toString() {
        return "->"+centre.toString() + ", radi : " + radi;
    }
   
    // ---------- Mètodes-------------------------------------------------------
   
    /**
    * distanciaCentres(altreCercle)
    * : Retorna la distància entre el centre del cercle actual i el rebut com a paràmetre.          
    *
    * @param altreCercle   Cercle
    * 
    **/
    public void distanciaCentres(Cercle altreCercle){
        double a = 0,b = 0;    //Catetos del triangle rectangle
        double c=-1;  // hipotenusa del triangle rectangle
        double x,y,x1,y1,r;
        
        //Determinem les coordenades cercle per paràmetre
        x1=altreCercle.getCentre().getPosicioX();
        y1=altreCercle.getCentre().getPosicioY();
        
        //Coordenades del cercle referència
        x=this.centre.getPosicioX();
        y=this.centre.getPosicioY();
        
        //valor del radi per paràmetre
        r=altreCercle.getRadi();
        
        
        // Calculem el valor d'a
        if (x>x1){
            a=x-x1;
        }else if (x<x1){
            a=x1-x;
        }else if (x==x1){
            if (y>y1){
                c=y-y1;
            }else if (y<y1){
                c=y1-y;
            }
            
        }
        
        // Calculem el valor de b
        if (y>y1){
            b=y-y1;
        }else if (y<y1){
            b=y1-y;
        }else if (y==y1){
            if (x>x1){
                c=x-x1;
            }else if(x<x1){
                c=x1-x;
            }
        }
        
        //Mostrem les coordenades i els valors a,b i c         
        System.out.println("------ Coordenades, a, b, c ------");
        System.out.println("eix x [ "+x+" - "+x1+" ]"+" a = "+a);
        System.out.println("eix y [ "+y+" - "+y1+" ]"+" b = "+b);
        System.out.println("El Valor de l'hipotenusa (c)  = "+c);
        System.out.println("radis [ "+r+" - "+radi+" ]");
        
        
        // Si formen un triangle rectangle, llavors calculem c, i distància entre centres.
        if (c==-1){
            c= Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2));
        }
        
        System.out.println("- La distància entre centres es de : "+c);
    }
    
    /**
     * equals()
     * 
     * Retorna true si dos cercles són iguals (si tenen el mateix centre i el mateix radi).
     * 
     * @param       altreCercle     Cercle
     * @return      equal           Boolean  True-equal; False-not equal 
     */
    public Boolean iguals(Cercle altreCercle){
        // Definició de variables.
        Boolean eq=false;        
        double x,y,x1,y1,r;
        
        x=centre.getPosicioX();
        x1=altreCercle.getCentre().getPosicioX();
        y=centre.getPosicioY();
        y1=altreCercle.getCentre().getPosicioY();
        r=altreCercle.getRadi();
        
        //Mostrem les coordenades.
        System.out.println("-- Coordenades --");
        System.out.println("eix x [ "+x+" - "+x1+" ]");
        System.out.println("eix y [ "+y+" - "+y1+" ]");
        System.out.println("radis [ "+r+" - "+radi+" ]");
        
        if((x==x1) & (y==y1) & (r==radi) ){ 
            eq=true;            
        }
                
        return eq;
    }
    
    
    
}
