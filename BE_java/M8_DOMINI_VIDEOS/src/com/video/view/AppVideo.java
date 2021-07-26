package com.video.view;


import java.util.Date;


import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.video.application.CampsBuits;
import com.video.application.Uploading;
import com.video.application.Utilitats;
import com.video.application.VideoController;
import com.video.domain.Video;

public class AppVideo {
	
	protected static VideoController vController = new VideoController();
	
	/**
	 * main
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		
		String[] dadesUsuari = new String[3];
		int numero;
		int index = -1;
		int result;
		crearUsuarisProva();
						
		do {
		String missatge = "VIDEOS \n"+
						  "  1 .- Crear nou usuari \n"+
						  "  2 .- Seleccionar usuari \n"+
						  "  3 .- Seleccionar video \n"+
						  "  4 .- Afegir videos a l'usuari seleccionat\n"+
						  "  5 .- Mostrar tots els usuaris \n"+
						  "  6 .- Mostrar els videos de l'usuari seleccionat\n"+
						  "  0 .- Sortir \n"+
						  " ";
			
			// Mostrem si hi ha un usuari seleccionat 
			if (index >=0) {
				missatge+="\nUsuari seleccionat : "+vController.getUsuarisRepositori().getLlistaUsuaris().get(index).nomToString()+"\n";
			}else {
				missatge+="\n[ No hi ha cap usuari seleccionat ]";				
			}
		
		
			do {
				numero=Integer.parseInt(JOptionPane.showInputDialog(null ,missatge, "VIDEOS",JOptionPane.INFORMATION_MESSAGE));
			}while(numero<0 || numero>6);
		
		
			switch(numero) {
			
				case 1:	//Crear un nou usuari.
					dadesUsuari = requestUsuari();
					Date dataActual = new Date();
					vController.addUsuari(dadesUsuari[0], dadesUsuari[1], dadesUsuari[2], dataActual);
					break;
					
				case 2://Seleccionar un usuari dels ja existents al repositori.
					index = seleccionarUsuari();					
					break;
					
				case 3://Seleccionar un video.
					int numVideo = seleccionarVideo(index);	//Seleccionem un video del usuari actual
					Video video = vController.getUsuarisRepositori().getLlistaUsuaris().get(index).getVideos().get(numVideo);
					
					Object[] options1 = { "Reproduir","Sortir" };
					
					JPanel panel = new JPanel();
					JTextField titol = new JTextField(10);
					JTextField durada = new JTextField(6);
					JTextField marcaText = new JTextField(6);
					
					titol.setText(video.getTitol());
					durada.setText(video.getDuradaVideo());
					marcaText.setText(video.getTempsActual());
					
					panel.add(titol);
					panel.add(durada);
					panel.add(marcaText);
					
					
						result = JOptionPane.showOptionDialog(null, panel, "Reproductor",
					        JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null,
					        options1, null);
						
						//Button reproduir video
						if(result == 0) {
							Reproductor repro = new Reproductor(video);							
						}
					
					break;
				case 4://Afegir videos a l'usuari seleccionat
					
					if (index>=0) {						
						String [] dadesRebudes = dadesVideo(index); 									              // demanem les dades del video
						
						if(dadesRebudes !=null) {
							Video nouVideo = vController.newVideo(dadesRebudes[0], dadesRebudes[1], dadesRebudes[2]);  //Creem el video
							vController.addVideo(index, nouVideo);							        				  // Afegim el video a l'usuari
						}	
						
					}else{
						JOptionPane.showMessageDialog(null, "ATENCIÓ : No hi ha cap usuari seleccionat ","", JOptionPane.WARNING_MESSAGE);
					}
					
					break;
					
				case 5:	// Llistat de tots els usuaris.				
					JOptionPane.showMessageDialog(null, vController.getUsuarisRepositori().showUsuaris(),"LLISTAT D'USUARIS ", JOptionPane.INFORMATION_MESSAGE);
					break;
					
				case 6:	// Llistat de tots els videos de l'usuari seleccionat
					if (index>=0) {	
						Object[] videos = vController.getUsuarisRepositori().llistaUsuaris.get(index).getVideos().toArray();
						JOptionPane.showMessageDialog(null, videos,"Llistat de videos de "+vController.getUsuarisRepositori().getLlistaUsuaris().get(index).nomToString()+"\n",JOptionPane.INFORMATION_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(null, "ATENCIÓ : No hi ha cap usuari seleccionat ","", JOptionPane.WARNING_MESSAGE);
					}
					break;	
			}
		}while(numero!=0);	
	}
	
	
	public static String reproduir(String tempsActual, String tempsTotal) {
		String tempsReproduccio;
		
		System.out.println("Inici de la reproducció\n   temps de reproducció : "+tempsActual+"    temps total : "+tempsTotal);
		
		Boolean iterar = true;
		int hores,minuts,segons;
		int result;
		String missatge;
		int[] resultat = horaInteger(tempsActual);
		int[] llargaria = horaInteger(tempsTotal);			      
		Object[] options1 = { "Pausar", "Aturar", "Sortir" };
		
	    hores  = resultat[0];
		minuts = resultat[1];
		segons = resultat[2];		
				
		while(iterar) {		
			missatge="Reproduitn : \n"+" - total : "+tempsTotal+"\n - Parcial : "+hores+":"+minuts+":"+segons;
			
			result = JOptionPane.showOptionDialog(null, missatge, "Reproductor:   >>>  Reproduint",
			        JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null,
			        options1, null);
			
			if(result==2) {iterar =false;}
			
			if(result==1) { llargaria = horaInteger("00:00:00");}
			
			if(result==0) { iterar=false;}
				
			
			
			if(segons==59) {
				minuts++;
				segons = 0;
			}
			
			if (minuts ==59) {
				hores++;
				minuts = 0;
			}
			
			if (hores==24) {
				hores=0;
			}
			
			if(hores==llargaria[0] & minuts==llargaria[1] & segons==llargaria[2]) {
				iterar=false;			    	
			}else {
				segons++;
				System.out.println(hores+":"+minuts+":"+segons);
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				
					e.printStackTrace();
				}
			}	
		}
		
		if(hores==llargaria[0] & minuts==llargaria[1] & segons==llargaria[2]) {
			tempsReproduccio="00:00:00";
		}else {
			tempsReproduccio=hores+":"+minuts+":"+segons;
		}
		
		return tempsReproduccio;
	}
	
	
	public static int[] horaInteger (String tempsActual) {
		int hores,minuts,segons;
		int[] resultat = new int[3];
		
		hores = Integer.parseInt(tempsActual.substring(0,2));
		minuts = Integer.parseInt(tempsActual.substring(3,5));
		segons = Integer.parseInt(tempsActual.substring(6,8));
		
		resultat[0] = hores;
		resultat[1] = minuts;
		resultat[2] = segons;
		
		return resultat;
	}
	
	
	
	/**
	 * requestUsuari
	 * 
	 * Recull nom, cognoms i password del nou usuari a crear.
	 * 
	 * @return	valors	String[3]
	 */
	public static String[] requestUsuari() {
		String[] valors = new String[3];
		
		valors[0] = Utilitats.llegirStringDialog("Nom de l'usuari");
		valors[1] = Utilitats.llegirStringDialog("Cognoms de l'usuari");
		valors[2] = Utilitats.llegirStringDialog("Password");
		
		return valors;
	}
	
	/**
	 * seleccionarUsuari
	 * 
	 * @return	index	int		Valor index usuari seleccionat
	 */
	public static int seleccionarUsuari() {
		int index=-1;
		
		if(vController.getUsuarisRepositori().getLlistaUsuaris().size()>0) {
			Object[] opcions = vController.getUsuarisRepositori().getLlistaUsuaris().toArray();
			
			Object value = JOptionPane.showInputDialog(null, "Selecciona un usuari","Usuaris", 
					JOptionPane.QUESTION_MESSAGE,null, opcions, opcions[0]);
			
			//index del usuari seleccionat
			index = vController.getUsuarisRepositori().getLlistaUsuaris().indexOf(value);   
		}else {
			JOptionPane.showMessageDialog(null, "Actualment no hi han usuaris a seleccionar.");
		}	
		
		return index;
	}
	
	public static int seleccionarVideo(int index) {
		
		if(vController.getUsuarisRepositori().getLlistaUsuaris().get(index).getVideos().size()>0) {
			Object[] opcions = vController.getUsuarisRepositori().getLlistaUsuaris().get(index).getVideos().toArray();
			
			Object value = JOptionPane.showInputDialog(null, "Selecciona un video","Videos", 
					JOptionPane.QUESTION_MESSAGE,null, opcions, opcions[0]);
			
			index = vController.getUsuarisRepositori().getLlistaUsuaris().get(index).getVideos().indexOf(value);
				
		}else {
			JOptionPane.showMessageDialog(null, "Actualment no hi han videos a seleccionar.");
		}
		
		return index;
	}
	
	/**
	 * dadesVideo
	 * 
	 * recull url i titol del video
	 * 
	 * 
	 * @param index	int 	index de l'usuari creador
	 * 
	 * @return	resultat	String[] 	url, titol del video
	 */
	public static String[] dadesVideo(int index) {
		Boolean iterar =false;
		Boolean dataCorrecta;		
		String[] resultat = new String[3];
		
		JTextField url = new JTextField(20);
		JTextField titol = new JTextField(10);
		JTextField hores = new JTextField(2);
		JTextField minuts = new JTextField(2);
		JTextField segons = new JTextField(2);
		
		String usuari = "AFEGIR VIDEO"+"\nUsuari : "+vController.getUsuarisRepositori().getLlistaUsuaris().get(index).nomToString()+"\n";
		Object[]  missatge ={"url", url,"titol", titol,"hores",hores,"minuts",minuts,"segons",segons};
		
		do {  
			int option = JOptionPane.showConfirmDialog(null, missatge, usuari, JOptionPane.OK_CANCEL_OPTION);
				
			if (option == JOptionPane.OK_OPTION){
			  
				try {
					// Recollida de dades
					String url1 = url.getText();
				    String titol1 = titol.getText();
				    String hores1 = hores.getText();
				    String minuts1 = minuts.getText();
				    String segons1 = segons.getText();
				    
				    //Detecció d'errors en les dades
				    dataCorrecta = vController.validarDurada(hores1,minuts1,segons1);				    			    
				    if (url1.equals(""))  { throw new CampsBuits("Atenció: la URL no pot estar buida");}
				    if (titol1.equals("")) { throw new CampsBuits("Atenció: el titol no pot estar buit");}
				    if(hores1.equals("") & minuts1.equals("") & segons1.equals("")) { throw new CampsBuits("Atenció: La durada del video no pot ser zero");}
				    if(hores1.length()>2 || minuts1.length()>2 || segons1.length()>2){ throw new CampsBuits("La llargaria dels camps Hores,Minuts i segons és de dos caràcters numèrics");}
				    if (!dataCorrecta) { throw new CampsBuits("La durada del video no és correcta");};
				    				    
				    resultat[0] = url1;
				    resultat[1] = titol1;
				    resultat[2] = hores+":"+minuts+":"+segons;
				    iterar=false;
				}catch(CampsBuits cb) {
					JOptionPane.showMessageDialog(null, cb);
					iterar =true;
			    }
			}else{
				resultat=null;	
				iterar=false;
			}	
		  }while(iterar);
		
		
		return resultat;
	}
	
	
	
	/**
	 * crearUsuariProva
	 * 
	 * Crea 5 usuaris per poder fer proves de funcionament.
	 */
	public static void crearUsuarisProva() {
		
		Date dataActual = new Date();
		
		vController.addUsuari("Laia", "Riuvall i Sanui", "12345", dataActual);
		vController.addUsuari("Joan", "Sanui i Capell", "12345a", dataActual);
		vController.addUsuari("Pere", "Catà i Costa", "12345b", dataActual);
		vController.addUsuari("Anna", "Llop i Serrat", "12345c", dataActual);
		vController.addUsuari("Mariona", "Soler i Padevall", "12345d", dataActual);	
		
		Video video = new Video("https://video1.avi","video1","01:55:57");
		video.setDataPujada(dataActual);
		video.setEstat(new Uploading(video));
		video.setTempsActual("01:54:50");
		vController.getUsuarisRepositori().getLlistaUsuaris().get(0).addVideo(video);
		
		video = new Video("https://video2.avi","video2","23:55:57");
		video.setDataPujada(dataActual);
		video.setEstat(new Uploading(video));
		vController.getUsuarisRepositori().getLlistaUsuaris().get(0).addVideo(video);
		
		video = new Video("https://video3.avi","video3","12:45:57");
		video.setDataPujada(dataActual);
		video.setEstat(new Uploading(video));
		vController.getUsuarisRepositori().getLlistaUsuaris().get(0).addVideo(video);
		
		video = new Video("https://video1.avi","video1","01:55:57");
		video.setDataPujada(dataActual);
		video.setEstat(new Uploading(video));
		vController.getUsuarisRepositori().getLlistaUsuaris().get(1).addVideo(video);
		
		video = new Video("https://video2.avi","video2","23:55:57");
		video.setDataPujada(dataActual);
		video.setEstat(new Uploading(video));
		vController.getUsuarisRepositori().getLlistaUsuaris().get(1).addVideo(video);
		
	}
	
}
