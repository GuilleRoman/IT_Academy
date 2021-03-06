package Lambda_1;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import Lambda_1.Persona.Sex;


/**
 * L'expressi? Lambda s'utilitza per proporcionar la implementaci? 
 * d'una interf?cie que tingui una interf?cie funcional.
 * 
 * @author juanj
 *
 */

@FunctionalInterface
interface Sayable {
	public String say(String name);
}

@FunctionalInterface
interface Addable{
	public int add(int a, int b);
}

@FunctionalInterface
interface Percentatge{
	public double calculaPercentatge (double quantitat, int percentatge);
}


public class LambdaRun {

	public static void main(String[] args) {
		
		Product producte;
		
		
		// ---- Lambda expression with single parameter.
		Sayable s1 = (name)->{
			return "Hello "+name;
		};
		
		Sayable s2 = (name)->{
			return "Hello 2 "+name;
		};
		
		System.out.println("--- Expressions Lambda amb un ?nic par?metre");
		System.out.println(s1.say("Joanet"));
		System.out.println(s1.say("Laura"));
		
		System.out.println(s2.say("juanjo"));
				
		// ---- Lambda expression with single parameter.
		System.out.println("--- Expressions Lambda amb multiples par?metres suma, i resta");
		Addable ad1 = (a,b)->(a+b);
		System.out.println(ad1.add(10, 20));
		
		ad1=(a,b)->(a-b);
		System.out.println(ad1.add(30, 10));
		
		System.out.println("--- Expressions Lambda amb multiples par?metres percentatge");
		Percentatge pc=(a,b)->(a*b/100);
		System.out.println(pc.calculaPercentatge(1000, 10));
		
		// Java Lambda Expression Foreach Loop
		System.out.println("Lambda expression, forEach loop");
		List<String> llista = new ArrayList<String>();
		
		llista.add("joan");
		llista.add("joan1");
		llista.add("joan2");
		llista.add("joan3");
		llista.add("joan4");
		
		llista.forEach((n)->System.out.println(n));
			
		//Java Lambda Expression: Comparator
		List<Product> llistaProductes = new ArrayList<Product>();
		
	    producte = new Product (1,"hp pavilion",3200);
	    llistaProductes.add(producte);
	    producte = new Product (2,"Asus Acer II",2200);
	    llistaProductes.add(producte);
	    producte = new Product (3,"Lenovo S3 ",3280);
	    llistaProductes.add(producte);
	    producte = new Product (4,"Acer S300",2900);
	    llistaProductes.add(producte);
	    producte = new Product (5,"Acer think",2800);	
	    
	    llistaProductes.add(producte);		
	    
	    Collections.sort(llistaProductes, (p1,p2)->{
	    	return p1.getNom().compareTo(p2.getNom());
	    });
	    
	    for(Product p:llistaProductes) {
	    	System.out.println(p);
	    }
	    
	    
	    // --------------- ARRAYLIST LAMBDA, STREAM ---------------------------------
	    List<Persona> persones = new ArrayList<Persona>();
	    
	    Persona persona = new Persona("joan", "emilio 1", LocalDate.of(1960, Month.JANUARY, 1),"0000");
	    persona.setGender(Sex.MALE);
	    persones.add(persona);	    
	    
	    Persona persona1 = new Persona("Montserrat", "emilio 2", LocalDate.of(1968, Month.JANUARY, 1),"1111");
	    persona1.setGender(Sex.FEMALE);
	    persones.add(persona1);
	    
	    Persona persona2 = new Persona("jofre", "emilio 3", LocalDate.of(1965, Month.JANUARY, 1),"2222");
	    persona2.setGender(Sex.MALE);
	    persones.add(persona2);
	    
	    Persona persona3 = new Persona("Sussana", "emilio 4", LocalDate.of(1965, Month.JANUARY, 1),"3333");
	    persona3.setGender(Sex.FEMALE);
	    persones.add(persona3);
	    
	    Persona persona4 = new Persona("Sussana", "emilio 4", LocalDate.of(1965, Month.JANUARY, 1),"3333");
	    persona4.setGender(Sex.FEMALE);
	    persones.add(persona4);
	    
	    double mitjaEdatHomes = persones
	    	.stream()
	    	.filter(e-> e.getGender()==Persona.Sex.MALE)
	    	.mapToInt(Persona::getAge)
	    	.average()
	    	.getAsDouble();
	    
	    persones
	    	.stream()
	    	.filter(e-> e.getGender()==Persona.Sex.FEMALE)
	    	.forEach (e-> System.out.println(e.toString()));
	    	
	    System.out.println("mitja d'edat dels homes : "+mitjaEdatHomes+"\n");
	    
	    // --------------------- HASHSET, EQUALS HASHCODE --------------------------
	    System.out.print("Col.lecci? Set class HashSet  ordenat per nom  ");
	    System.out.println("-----------------------------------------------");
	    Set<Persona> setPersones = new HashSet<Persona>();
	    
	    setPersones.add(persona);
	    setPersones.add(persona1);
	    setPersones.add(persona2);
	    setPersones.add(persona3);
	    setPersones.add(persona4);
	    
	    System.out.println("Recorro la col?lecci? amb un Stream");
	    System.out.println("-----------------------------------------------");
	    setPersones.stream()
	    			.filter(p-> p.getGender()==Persona.Sex.FEMALE)
	    			.forEach(p-> System.out.println(p.toString()));
	    
	   System.out.println("HashCode : " + setPersones.hashCode()); 
	   
	   System.out.println("Recorro la col?lecci? amb un objecte Iterator");
	   System.out.println("-----------------------------------------------");
	   Iterator<Persona> it = setPersones.iterator();
	   Persona personaIt;
	   
	   while(it.hasNext()) {
		   personaIt=it.next();
		   System.out.println("- "+personaIt.toString());
	   }
	   
	// --------------------- LINKEDLIST -------- --------------------------
	System.out.print("Col.lecci? LinkedList class  ");
	System.out.println("-----------------------------------------------"); 
	    
	LinkedList<Persona> personesLl = new LinkedList<Persona>();
	    
	personesLl.add(persona);
	personesLl.add(persona1);
	personesLl.add(persona2);
	personesLl.add(persona3);
	personesLl.add(persona4);
	    
	System.out.println("Elements de la LinkedList : "+personesLl.size());
	
	System.out.println("Llistat amb Stream");   
	personesLl.stream()
		.forEach(p-> System.out.println("- "+p.toString()));
	
	System.out.println("Llistat amb bucle for");    
	for(Persona person : personesLl) {
		System.out.println(person.toString());
	}
	    
	    
	}
}
