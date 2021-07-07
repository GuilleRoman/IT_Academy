/**
 * F&G Dev. 
 * 
 */

package ArrayList;

import java.util.*;

public class UsEmpleat {

	public static void main(String[] args) {
		// ------ DECLARACIÓ DE VARIABLES ----------------
		Jefatura jefeRRHH=null;
		Empleado empleat=null;
		
		Empleado[] empleats = new Empleado[12];
		
		// Afegeixo els empleats a l'array ---------------
		jefeRRHH = new Jefatura("juanjo",54,6000);
		jefeRRHH.establirIncentiu(1500);
		empleats[0]=(Empleado)jefeRRHH;
		
		empleat = new Empleado("jona",42,2500);
		empleats[1] = empleat;
		empleat = new Empleado("Cecilia",35,1500);
		empleats[2] = empleat;
		empleat = new Empleado("Raquel ",42,3800);
		empleats[3] = empleat;
		empleat = new Empleado("Juanjo",53,2100);
		empleats[4] = empleat;
		empleat = new Empleado("jona",42,2500);
		empleats[5] = empleat;
		empleat = new Empleado("jona",42,2500);
		empleats[6] = empleat;
		empleat = new Empleado("Cecilia",35,1500);
		empleats[7] = empleat;
		empleat = new Empleado("Raquel ",42,3800);
		empleats[8] = empleat;
		empleat = new Empleado("Juanjo",53,2100);
		empleats[9] = empleat;
		empleat = new Empleado("jona",42,2500);
		empleats[10] = empleat;
		empleat = new Empleado("pedro",22,2500);
		empleats[11] = empleat;		
		
		Arrays.sort(empleats);
		String cadena = Arrays.toString(empleats);
		System.out.println(cadena);
		
		System.out.println("Longitud de la llista : "+empleats.length);
		for (int i=0; i<empleats.length; i++) {
			System.out.println(empleats[i].toString());
		}
		
		
	}

}
