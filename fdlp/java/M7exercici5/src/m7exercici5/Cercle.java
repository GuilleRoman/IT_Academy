/*
 * IT ACADEMY  .
 * Fonaments de la programació -POO-
 * M7 exercici 5
 */
package m7exercici5;

/**
 *
 * @author Juan José Campos Caballero.
 * 
 * Informació trigonomètrica
 * https://www.superprof.es/diccionario/?s=circunferencias&post_type=post
 *  
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
    * @param        altreCercle   Cercle
    *  
    * @return       c     double     Valor de la distància entre centres  
    * 
    **/
    public double distanciaCentres(Cercle altreCercle){
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
        
        
        // Si formen un triangle rectangle, llavors calculem c, i distància entre centres.
        if (c==-1){
            c= Math.sqrt(Math.pow(a, 2)+Math.pow(b, 2));
        }
        
                        
        return c;
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
        
        //Determinem les coordenades cercle per paràmetre
        x1=altreCercle.getCentre().getPosicioX();
        y1=altreCercle.getCentre().getPosicioY();
        
        //Coordenades del cercle referència
        x=this.centre.getPosicioX();
        y=this.centre.getPosicioY();
        
        //valor del radi per paràmetre
        r=altreCercle.getRadi();
        
        if((x==x1) & (y==y1) & (r==radi) ){ 
            eq=true;            
        }
                
        return eq;
    }
    
    /**
     * mostrarCoordenades(Cercle altreCercle)
     * 
     * Mostra les coordenades dels dos cercles.
     * 
     * @param altreCercle   Cercle
     */
    public void mostrarCoordenades(Cercle altreCercle){
        double x,y,x1,y1,r;       
         
        //Determinem les coordenades cercle per paràmetre
        x1=altreCercle.getCentre().getPosicioX();
        y1=altreCercle.getCentre().getPosicioY();
        
        //Coordenades del cercle referència
        x=this.centre.getPosicioX();
        y=this.centre.getPosicioY();
        
        //valor dels radis
        r=altreCercle.getRadi();
        
        
       System.out.println("Coordenades : ");
       System.out.print("eix x [ "+x+" - "+x1+" ]  ");
       System.out.print("eix y [ "+y+" - "+y1+" ]  ");        
       System.out.print("radis [ "+radi+" - "+r+" ] \n");
            
        
    }
    
    
    
    
    /**
     *sonConcentrics(altreCercle) 
     * 
     * Retorna true si dos cercles són concèntrics (tenen igual centre).
     * Tenen el mateix centre i no tenen cap punt en comú
     * 
     * @param       altreCercle
     * @return      Boolean         true:Concèntric  
     */
    public Boolean sonConcentrics(Cercle altreCercle){
        Boolean concentrics=false;
        
        if(altreCercle.centre.getPosicioX()==this.centre.getPosicioX() & altreCercle.centre.getPosicioY()==this.centre.getPosicioY() &  this.radi!=altreCercle.getRadi()){
            concentrics=true;
        } 
        
        return concentrics;
    }
    
    
    public Boolean mateixRadi(Cercle altreCercle){
        Boolean mateixRadi=false;
        
        if(altreCercle.getRadi()==this.radi){
            mateixRadi=true;
        }
        
        return mateixRadi;
    }
    
    
    
    /**
     * sonTangents(altreCercle)
     * 
     * Retorna true si dos cercles són tangents.
     *  
     * @param       altreCercle Cercle
     * @return      tangents    true:tangents 
     * 
     * Tangents interiors:  La distancia entre los centros es igual a la diferencia de los radios.
     * 
     * Tangents exteriors:  La distancia entre los centros es igual a la suma de los radios.     * 
     * 
     */
    public Boolean sonTangents(Cercle altreCercle){
        Boolean tangents=false;
        double sumaRadis=this.radi+altreCercle.getRadi();
        double restaRadis=this.radi-altreCercle.getRadi();
        double dec=this.distanciaCentres(altreCercle);
                
        // tangents exteriors
        if(sumaRadis==dec){
            tangents=true;
        }
        
        // tangents interiors.
        if(dec==restaRadis){
            tangents=true;
        }
                
        return tangents;
    }	

        
    /**
     * sonSecants(altreCercle)
     * 
     * La distancia entre los centros es mayor que la diferencia de los radios pero menor que la suma.
     * 
     * @param   altreCercle     Cercle
     * @return  secant          Boolean     True=secant
     */
    public Boolean sonSecants(Cercle altreCercle){
        Boolean secant = false;
        double difRadis =Math.abs(this.radi-altreCercle.getRadi());
        double sumRadis =this.radi+altreCercle.getRadi();
        double dec = this.distanciaCentres(altreCercle);
        
        if(dec > difRadis & dec<sumRadis){
            secant = true;
        } 
        
        return secant;
    }
	
    /**
     * noEsToquen(altreCercle)
     * 
     * Retorna true si dos cercles no es toquen.
     * 
     * Exteriors: true si la dist.entre centres > r1+r2
     * Interiors: true si la dist.entre centres < r1-r2 
     * 
     * @param altreCercle
     * @return 
     */
    public Boolean noEsToquen(Cercle altreCercle){
        Boolean noToquen=false;
        double difRadis =Math.abs(this.radi-altreCercle.getRadi());
        double sumaRadis = this.radi+altreCercle.getRadi();
        double dec = this.distanciaCentres(altreCercle);
        
        if (dec > sumaRadis || dec < difRadis){
            noToquen=true;
        }        
        
        return noToquen;
    }
    
      
    
}
