package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Floristeria;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;

public class MenuInicial extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	
	public List<Floristeria> floristeries = new ArrayList<Floristeria>();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Mostrar floristeries");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarFloristeries();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Mostrar stock dels articles");
		mnNewMenu.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_1 = new JMenu("Productes");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Crear Arbre");
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Crear Flor");
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Crear Decoracio");
		mnNewMenu_1.add(mntmNewMenuItem_4);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Floristeria Activa : ");
		contentPane.add(lblNewLabel, BorderLayout.SOUTH);
		
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

}
