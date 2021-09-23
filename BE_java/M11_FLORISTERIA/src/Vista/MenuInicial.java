package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.FabricaProductes;
import Model.Floristeria;
import Model.Producte;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class MenuInicial extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	
	public static List<Floristeria> floristeries = new ArrayList<Floristeria>();
	public Floristeria floristeriaActual;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					carregarFloristeries();
					MenuInicial frame = new MenuInicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuInicial() {
		setTitle("GESTIO DE FLORISTERIES");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		
		JLabel lblNewLabel = new JLabel("Floristeria Activa : Cap seleccionada !!!");
		FabricaProductes nouProducte = new FabricaProductes();
				
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Floristeries");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Crear Floristeria");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				afegirFloristeria();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Seleccionar Floristeria");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] opcions = floristeries.toArray();
				Object opcio = JOptionPane.showInputDialog(null,"Selecciona una Floristeria", "",JOptionPane.QUESTION_MESSAGE,null,opcions, opcions[0]);
				int index = floristeries.indexOf(opcio); 
				floristeriaActual = floristeries.get(index);
				lblNewLabel.setText("Floristeria activa : "+floristeriaActual.getNom());
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Mostrar floristeries");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarFloristeries();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Mostrar stock valorat dels articles");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(floristeriaActual!=null) {
					valorarFloristeriaActiva();
				}else {
					JOptionPane.showMessageDialog(null, "No hi ha cap floristeria seleccionada !!\n");
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_1 = new JMenu("Productes");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Crear Arbre");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(floristeriaActual!=null) {
					floristeriaActual.getArticles().add(nouProducte.getProducte("arbre"));
				}else {
					JOptionPane.showMessageDialog(null, "No hi ha cap floristeria seleccionada !!\n");
				}	
			}
		});
		
		mnNewMenu_1.add(mntmNewMenuItem_2);		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Crear Flor");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(floristeriaActual!=null) {
					floristeriaActual.getArticles().add(nouProducte.getProducte("flor"));
				}else {
					JOptionPane.showMessageDialog(null, "No hi ha cap floristeria seleccionada !!\n");
				}
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Crear Decoracio");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(floristeriaActual!=null) {
					floristeriaActual.getArticles().add(nouProducte.getProducte("decoracio"));
				}else {
					JOptionPane.showMessageDialog(null, "No hi ha cap floristeria seleccionada !!\n");
				}
			}
		});
		
		mnNewMenu_1.add(mntmNewMenuItem_4);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		contentPane.add(lblNewLabel, BorderLayout.SOUTH);
		
	}
	
	public void valorarFloristeriaActiva() {
		String articles = "";
		double valor = 0.0;
				
		for(Producte product : floristeriaActual.getArticles()) {
			articles +="- "+product.getNom()+" "+product.getPreu()+"\n";
			valor += product.getPreu();
		}
		
		articles+="Import total de l'estock : "+valor+"\n";
		JOptionPane.showMessageDialog(null, "STOCK VALORAT DE LA FLORISTERIA : "+ floristeriaActual.getNom() + "\n" + articles);
	}
	
	
	public void mostrarFloristeries() {
		String totesFloristeries="";
		
		for(Floristeria flor : floristeries ) {
			totesFloristeries+="- "+flor.getNom()+"\n";
		}
		
		 JOptionPane.showMessageDialog(null, " Floristeries Existents : \n" + totesFloristeries);
	}
	
	
	/**
	 * afegirFloristeria
	 * 
	 */
	public void afegirFloristeria() {
		//demano el nom de la floristeria.
		//Creo la floristeria
		Floristeria novaFloristeria = new Floristeria(demanarNom());		
		//Afegeixo la floristeria a la llista .
		floristeries.add(novaFloristeria);		
	}
	
	/**
	 * demanarNom 
	 * 	
	 * @return		nom 	String
	 */
	public String demanarNom() {
		String nom="";
		do {
			nom = JOptionPane.showInputDialog("Nom de la floristeria : ");
		}while (nom.equals(""));
		
		return nom;
	}
	
	/**
	 * carregarFloristeries
	 * 
	 * Carrega floristeries per fer les proves
	 */
	public static void carregarFloristeries() {
		Floristeria fl_01 = new Floristeria ("La crisàlida");
		Floristeria fl_02 = new Floristeria ("Sant Jordi");
		Floristeria fl_03 = new Floristeria ("La ben florida");
		Floristeria fl_04 = new Floristeria ("Roser de l'alba");
		
		floristeries.add(fl_01);
		floristeries.add(fl_02);
		floristeries.add(fl_03);
		floristeries.add(fl_04);
	}


}
