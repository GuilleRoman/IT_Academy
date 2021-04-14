/*
 * IT ACADEMY  .
 * Fonaments de la programació -POO-
 * Juan José Campos Caballero.
 */
package m7exercici4;

/**
 * M7 exercici 4
 * @author juanjo Campos
 */
public class Hospital extends Edifici {
    // ---------- Propietats ----------
    private int llitsOcupats;    // llits Ocupats
    private int llits;          // llits totals de l'hospital
    
    // ---------- Constructor ----------
    public Hospital(String nom, int plantes, int superficie, int llitsOcupats,int llits) {
        super(nom, plantes, superficie);
        this.llitsOcupats=llitsOcupats;
        this.llits=llits;
    }

    // ---------- Getters and Setters  ----------

    public int getLlitsOcupats() {
        return llitsOcupats;
    }

    public void setLlitsOcupats(int llitsOcupats) {
        this.llitsOcupats = llitsOcupats;
    }

    public int getLlits() {
        return llits;
    }

    public void setLlits(int llits) {
        this.llits = llits;
    }   
    
    
    // ---------- Mètodes ----------

    @Override
    public String toString() {
        String missatge;
        int llitsLliures=llits-llitsOcupats;
        missatge="--> " +super.getNom();
        missatge+="\n -Plantes : "+super.getPlantes()+" -Superfície : "+super.getSuperficie();
        missatge+="\n -Total de llits : "+llits +"  -Llits ocupats : "+llitsOcupats+"  -Llits lliures : "+llitsLliures;
        return missatge;
    }
    
    
    /**
     *calcularCostVigilancia
     * 
     * Mostra els vigilants i el seu cost econòmic.
     */
    @Override
    public void calcularCostVigilancia() {
        int nombreDeVigilants=super.getSuperficie()/1000;
        int costVigilancia=nombreDeVigilants*1300;
        
        System.out.println("El nombre de vigilants és de : "+nombreDeVigilants+" i tenen un cost de :"+costVigilancia+" euros.");
        
                
    }
    
    /**
     * repartirDinar
     * 
     * Mostra el nombre de racions en funció dels llits ocupats
     * i comptabilitzant tres apats diàris.
     */
    public void repartirDinar(){
        int totalRacions=llitsOcupats*3;
        System.out.println("Actualment s'estan lliurant "+totalRacions+" racions");
    }
    
    
}
