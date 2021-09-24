package Model;

import java.util.ArrayList;
import java.util.List;

public class Floristeria {
	private String nom;
	private List<Producte> articles = new ArrayList<Producte>();
	public static int contadorArticulos=0;
	
	public Floristeria(String nom) {		
		this.nom = nom;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public List<Producte> getArticles() {
		return articles;
	}


	public void setArticles(List<Producte> articles) {
		this.articles = articles;
	}


	@Override
	public String toString() {
		return "Floristeria nom : " + nom;
	}
	
	public void addProduct(Producte e) {
		this.articles.add(e);
	}
	
	
	
	
}
