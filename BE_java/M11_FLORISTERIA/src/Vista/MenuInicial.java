package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import Controlador.FabricaProductes;
import Model.Floristeria;
import Model.Producte;
import Model.Ticket;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.awt.event.ActionEvent;

public class MenuInicial extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	
	public List<Floristeria> floristeries = new ArrayList<Floristeria>();
	public Floristeria floristeriaActual;
	public FabricaProductes fabricador = new FabricaProductes();
	public JTextArea tabla = new JTextArea();

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
		setBounds(200, 200, 700, 400);
		
		JLabel lblNewLabel = new JLabel("Floristeria Activa : Cap seleccionada !!!");
		
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
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Mostrar stock dels articles");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mostrarStock();
			}
			
		});
		mnNewMenu.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_1 = new JMenu("Productes");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Crear Arbre");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fabricador.getProducte("arbre", floristeriaActual);
			}
			
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Crear Flor");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fabricador.getProducte("flor", floristeriaActual);
			}
			
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Crear Decoracio");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fabricador.getProducte("decoracio", floristeriaActual);
			}
			
		});
		mnNewMenu_1.add(mntmNewMenuItem_4);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JTextArea tabla = new JTextArea();
		this.tabla= tabla;
		
		tabla.setBounds(300, 300, 300, 300);
		contentPane.add(tabla);
		
		//lblNewLabel = new JLabel("Floristeria Activa : ");
		contentPane.add(lblNewLabel, BorderLayout.SOUTH);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Mostrar precio total del Stock");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				precioTotalStock();
			}
			
		});
		mnNewMenu.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Comprar artículos");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				realizarCompra();
				//comprarSelecciona();
			}
			
		});
		mnNewMenu.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Mostrar última compra");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mostrarUltimaCompra();
			}
			
		});
		mnNewMenu.add(mntmNewMenuItem_9);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Mostrar beneficio total");
		mntmNewMenuItem_10.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tabla.setText("");
				tabla.append("\nEl negocio ha obtenido hasta ahora: "+String.valueOf(floristeriaActual.getDineroTotalGanado()+"€"));
			}
			
		});
		mnNewMenu.add(mntmNewMenuItem_10);
		
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
	
	
	public void mostrarStock() {
		tabla.setText("");
		List<Producte> stock = floristeriaActual.getArticles();
		tabla.append("\nExisten un total de " +Floristeria.contadorArticulos+" artículos, que son los siguientes:\n");
		stock.stream().forEach(v -> tabla.append(v.getNom()+ " "+ v.getPreu()+"\n"));
	}
	
	public double precioTotalStock() {
		tabla.setText("");
		List<Producte> stock = floristeriaActual.getArticles();
		double precioTotal= 0;
		for (Producte e: stock) {
			precioTotal = precioTotal + e.getPreu();
		}
		tabla.append(("\nEl precio total es de: "+precioTotal+ "€"));
		return precioTotal;
	}
	
	public void realizarCompra() {
		
		tabla.setText("");
		tabla.append("\nElige qué productos quieres añadir a tu compra:");
		mostrarStock();
		Ticket compra = new Ticket();
		String productNom= JOptionPane.showInputDialog("Nombre del producto (Introduce \"N\" para terminar)" );
		
		while (!productNom.equalsIgnoreCase("n")) {
			int index=0;
			for (Producte e: floristeriaActual.getArticles()) {
				if(e.getNom().matches(productNom)) {
					index= floristeriaActual.getArticles().indexOf(e);
				}else {
					continue;
				}
			}	
			Producte producto = floristeriaActual.getArticles().get(index);
			compra.compra.add(producto);
			floristeriaActual.getArticles().remove(index);
			floristeriaActual.setDineroTotalGanado(producto.getPreu());
			Floristeria.contadorArticulos--;
			mostrarStock();
			productNom = JOptionPane.showInputDialog("Nombre del producto (Introduce \"N\" para terminar)" );
			
		} 
		;
			if(floristeriaActual.ticketVentaActual.isEmpty()) {
				floristeriaActual.ticketVentaActual.add(compra);
				
		} 	else {
				floristeriaActual.ticketsVentaAntiguos.add(floristeriaActual.ticketVentaActual.get(0));
				floristeriaActual.ticketVentaActual.remove(0);
				floristeriaActual.ticketVentaActual.add(compra);
			}
		}
	public void comprarSelecciona() {
		//por solventar la selección de las opciones (no aparece el nombre, sino los atributos del objeto)
		Ticket compra = new Ticket();
		int yesNo= -1;
		while(yesNo!= JOptionPane.NO_OPTION){
		Object[] opcions = floristeriaActual.getArticles().toArray();
		Object opcio = JOptionPane.showInputDialog(null,"Selecciona los artículos a comprar", "",
				JOptionPane.QUESTION_MESSAGE,null,opcions,opcions[0]);
		
		compra.compra.add((Producte) opcio);
		floristeriaActual.getArticles().remove(opcio);
		Floristeria.contadorArticulos--;
		}
		
		floristeriaActual.ticketVentaActual.add(compra);
		
	}
	public Ticket mostrarUltimaCompra() {
		tabla.setText("");
		if(floristeriaActual.ticketVentaActual.isEmpty()) {
			tabla.append("\nAún no se ha realizado ninguna compra");
			return null;
		}else {
			Ticket mostrarCompra =floristeriaActual.ticketVentaActual.get(0);
			tabla.append("\nLa última compra realizada ha sido:\n");
			mostrarCompra.compra.stream().forEach(v-> tabla.append(v.getNom()+" "+v.getPreu()+"\n"));
			mostrarCompra.getValorTotal();
			return mostrarCompra;
		}
		
	}

		
}
