package LinkedList;

import java.util.LinkedList;
import java.util.ListIterator;

public class Inici {

	public static void main(String[] args) {
		LinkedList <String>  paisos = new LinkedList <String>();
		paisos.add("Catalunya");
		paisos.add("Fran?a");
		paisos.add("Italia");
		paisos.add("Alemanya");
		paisos.add("Portugal");
		paisos.add("Suissa");
			
		
		LinkedList <String> capitals = new LinkedList <String>();
		capitals.add("Barcelona");		
		capitals.add("Par?s");		
		capitals.add("Roma");
		capitals.add("Berlin");
		capitals.add("Lisboa");
		capitals.add("Berna");
		
		System.out.println("Pa?sos   : \n \t"+paisos);
		System.out.println("Capitals : \n \t"+capitals);
		
		ListIterator<String> litP = paisos.listIterator();
		ListIterator<String> litC = capitals.listIterator();
		
		if(paisos.size()>capitals.size()) {
			System.out.println("Hi han m?s pa?sos que capitals, Quedaran paisos sense capital.");
		} else if(paisos.size()<capitals.size()) {
			System.out.println("Hi han m?s capitals que pa?sos.");			
		} else {
			System.out.println("Els nombre de pa?sos i de capitals s?n iguals.");
		}
		
		// fusiono la taula capitals a la taula paisos
		while(litP.hasNext()) {
			litP.next(); //Avan?o l'iterador pa?sos
			
			// si hi ha una capital llavors l'afegeixo al pais
			if(litC.hasNext()) {				
				litP.add(litC.next()); //Avan?o iterador capitals i l'inserto a pa?sos.
			}	
			
		}
		
		//Mostrem linkedList de capitals
		
		System.out.println("Llistat Stream de la linkedList capitals fusionada : ");
		paisos.stream()
			.forEach(p-> System.out.println(p));
		
		System.out.println("Llistat for de la linkedList capitals fusionada : ");
		for(String paisosAux : paisos) {
			System.out.println("- "+paisosAux);
		}
		
		//eliminem les capitals parells
		litC=capitals.listIterator(); //Reinicialitzem el iterador
		
		while(litC.hasNext()) {
			litC.next();
			
			if (litC.hasNext()) {
				litC.next();
				litC.remove();
				
			}
		}
		
		System.out.println("Llista capitals eliminades les parells : \n"+capitals.toString());
		
		System.out.println("Eliminem a la linkedList capitals les capitals que han quedat ");
		System.out.println("M?tode removeAll heretat de class [java.util.AbstractCollection] per LinkedList ");
		paisos.removeAll(capitals);
		System.out.println("Llista de paisos un cop eliminades les capitals de capitals : \n"+paisos.toString());
	}

}
