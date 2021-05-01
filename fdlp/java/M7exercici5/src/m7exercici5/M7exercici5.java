/*
 * IT ACADEMY  .
 * Fonaments de la programació -POO-
 * Juan José Campos Caballero.
 */
package m7exercici5;

/**
 *
 * @author juanj
 */
public class M7exercici5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // declaració variables locals
        int x,y,rad;         // var que emma. el punt(x,y) i el radi
        int numCercles=0;    // contador de cercles aleatoris
        Punt punt1=null;
        Cercle cercle1=null;
        
                
        //Creo el primer cercle
        Punt punt = new Punt(4,8);
        Cercle cercle=new Cercle(punt,10);
        System.out.println("Primer Cercle : "+cercle.toString()+"\n");
        
        
        // Genero 6 cercles amb valors aleatoris 
       // executo els mètodes de la classe Cercle
        do{
            
            // Genero aleatòriament x,y,rad de valors entre [1..20]
            x = generarIntAleatori(1, 20);
            y = generarIntAleatori(1, 20);
            rad = generarIntAleatori(1, 20);
            
            // Genero un objecte de la classe Cercle amb els valors aleatoris generats.  
            punt1 = new Punt(x,y);
            cercle1=new Cercle(punt1,rad);
            System.out.println("-----------------------------------------------------");
            cercle.mostrarCoordenades(cercle1);
            mostrarMetodes(cercle,cercle1);
            numCercles++;
            
        }while (numCercles<=6);
        
        
        //Genero un cercle identic en radi i posició
         System.out.println("-------------cercle igual en pos i radi -----------------");
        punt1 = new Punt(4,8);
        cercle1=new Cercle(punt1,10);
        cercle.mostrarCoordenades(cercle1);
        mostrarMetodes(cercle,cercle1);
        
        //Genero un cercle identic en l'eix x 
        System.out.println("-------------cercle eix x iguals, radi diferent-----------");
        punt1 = new Punt(4,6);
        cercle1=new Cercle(punt1,10);
        cercle.mostrarCoordenades(cercle1);
        mostrarMetodes(cercle,cercle1);
        
        //Genero un cercle identic en l'eix x 
        System.out.println("-------------cercle eix y iguals, radi diferent-----------");
        punt1 = new Punt(7,8);
        cercle1=new Cercle(punt1,10);
        cercle.mostrarCoordenades(cercle1);
        mostrarMetodes(cercle,cercle1);
        
        //Genero un cercle concèntric  
        System.out.println("-------------cercle concentric -----------");
        punt1 = new Punt(4,8);
        cercle1=new Cercle(punt1,12);
        cercle.mostrarCoordenades(cercle1);
        mostrarMetodes(cercle,cercle1);
        
        
        //Genero un cercle tangent exterior
        System.out.println("-------------cercle tangent exterior -----------");
        punt1 = new Punt(4,13);
        cercle1=new Cercle(punt1,5);
        cercle.mostrarCoordenades(cercle1);
        mostrarMetodes(cercle,cercle1);
        
        //Genero un cercle tangent interior
        System.out.println("-------------cercle tangent interior -----------");
        punt1 = new Punt(4,14);
        cercle1=new Cercle(punt1,4);
        cercle.mostrarCoordenades(cercle1);
        mostrarMetodes(cercle,cercle1);
        
        //Genero un cercle que no es toca
        System.out.println("-------------cercles secants  -----------");
        punt1 = new Punt(16,11);
        cercle1=new Cercle(punt1,18);
        cercle.mostrarCoordenades(cercle1);
        mostrarMetodes(cercle,cercle1);
                        
                
        //Genero un cercle que no es toca
        System.out.println("-------------cercles no es toquen  -----------");
        punt1 = new Punt(19,8);
        cercle1=new Cercle(punt1,2);
        cercle.mostrarCoordenades(cercle1);
        mostrarMetodes(cercle,cercle1);
               
        
        System.out.println("L'execució del programa ha finalitzat. ");
    }
    
    
    /**
     * mostrarMetodes(c1,c1)
     * 
     * Mostra tots els mètodes de cercle respecte a c1 i c2
     * 
     * @param cercle1   Cercle
     * @param cercle2   Cercle 
     */
    public static void mostrarMetodes(Cercle cercle1, Cercle cercle2){
        
        System.out.println("- Distancia entre centres : "+cercle1.distanciaCentres(cercle2));  
        System.out.println("- Equals       : "+cercle1.iguals(cercle2) );        
        System.out.println("- Concèntrics  : "+cercle1.sonConcentrics(cercle2) ); 
        System.out.println("- Radis iguals : "+cercle1.mateixRadi(cercle2));
        System.out.println("- Tangents     : "+cercle1.sonTangents(cercle2));
        System.out.println("- Secants      : "+cercle1.sonSecants(cercle2));
        System.out.println("- No es toquen : "+cercle1.noEsToquen(cercle2));            
    }
    
    
    
    
    
    
    /**
     * generarIntAleatori
     * 
     * Genera un nombre aleatori entre min i max.
     * 
     * @param       min      int aleatori mínim
     * @param       max      int aleatori màxim
     * @return      nombre   int random [min..max] 
     */
    public static int generarIntAleatori(int min, int max){
        int nombre=(int) Math.floor(Math.random()*max+min);
        return nombre;
    }    
    
}
