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
            System.out.println("Cercle aleatori "+numCercles+"  "+cercle1.toString());
            
            //Executo els mètodes de la Classe Cercle
            cercle.distanciaCentres(cercle1);    //Calculo la distància entre centres.
            // test equals cercles.
            System.out.println("- Cercle1 equals Cercle2 és "+cercle1.iguals(cercle1) ); 
            System.out.println("-----------------------------------------------------");
            numCercles++;
            
        }while (numCercles<=6);
        
        
        //Genero un cercle identic en radi i posició
         System.out.println("-------------cercle igual en pos i radi -----------------");
        punt1 = new Punt(4,8);
        cercle1=new Cercle(punt1,10);
        System.out.println("Cercle aleatori "+numCercles+"  "+cercle1.toString());
        cercle.distanciaCentres(cercle1);  //Calculo la distància entre centres.
        System.out.println("- Cercle1 equals Cercle2 és "+cercle1.iguals(cercle1) );       
        numCercles++;
        
        //Genero un cercle identic en l'eix x 
        System.out.println("-------------cercle eix x iguals, radi diferent-----------");
        punt1 = new Punt(4,6);
        cercle1=new Cercle(punt1,10);
        System.out.println("Cercle aleatori "+numCercles+"  "+cercle1.toString());
        cercle.distanciaCentres(cercle1);  //Calculo la distància entre centres.
        System.out.println("- Cercle1 equals Cercle2 és "+cercle1.iguals(cercle1) );        
        numCercles++;
        
        //Genero un cercle identic en l'eix x 
        System.out.println("-------------cercle eix y iguals, radi diferent-----------");
        punt1 = new Punt(7,8);
        cercle1=new Cercle(punt1,10);
        System.out.println("Cercle aleatori "+numCercles+"  "+cercle1.toString());
        cercle.distanciaCentres(cercle1);  //Calculo la distància entre centres.
        System.out.println("- Cercle1 equals Cercle2 és "+cercle1.iguals(cercle1) );        
        numCercles++;
        
        System.out.println("L'execució del programa ha finalitzat. ");
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
