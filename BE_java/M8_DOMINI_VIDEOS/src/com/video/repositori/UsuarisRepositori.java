package com.video.repositori;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.video.domain.Usuari;

public class UsuarisRepositori {
	public List<Usuari> llistaUsuaris = new ArrayList<Usuari>();
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	public void afegirUsuari(Usuari usuari) {
		llistaUsuaris.add(usuari);
	}
	
	
	
	public String showUsuaris() {
		String llistat="";
		int i=0;
		
		for(Usuari user : llistaUsuaris) {
			llistat+="id :"+i+"  -"+user.toString()+"\n";
			i++;
		}
		
		return llistat;
	}
	
	public String showShortUsuaris() {
		String llistat="";
		int i=0;
		
		for(Usuari user : llistaUsuaris) {
			llistat+="id :"+i+"  -"+user.getCognoms()+", "+user.getNom()+" "+sdf.format(user.getDataRegistre())+"\n";
			i++;
		}
		
		return llistat;
	}



	public List<Usuari> getLlistaUsuaris() {
		return llistaUsuaris;
	}
	

}
