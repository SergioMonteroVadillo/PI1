package vista;

import java.awt.Canvas;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controlador.ControladorVentana;

public class Ventana extends JFrame{

	public JButton boton1;
	public JButton boton2;
	public JButton boton3;
	private JTextField AnoSim;
	private JTextField inicio;
	private JTextField fin;
	private JTextField ano;
	JTextArea listado1;
	JTextArea listado2;
	
	
	ControladorVentana controlador;
	
	public Ventana(ControladorVentana c){
		
		this.controlador = c;
		
		this.setSize(710, 610);
		this.setLocation(300, 100);
		this.setResizable(false);
		this.setTitle("Simulador de datos meteorologicos");		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Se base donde ir poniendo los elementos
		JPanel tapiz = new JPanel();
		tapiz.setLayout(null);
		tapiz.setBackground((Color.CYAN).darker());
					
		//Se crean etiquetas de texto y cuadros de diálogo
		JLabel etiqueta1 = new JLabel("Año: ");
		etiqueta1.setBounds(100, 483, 75, 30);
		
		AnoSim = new JTextField(5);
		AnoSim.setBounds(130, 490, 50, 18);
		
		JLabel etiqueta2 = new JLabel("SELECCIONE PERIODO ");
		etiqueta2.setBounds(380, 410, 175, 30);
				
		JLabel etiqueta3 = new JLabel("Inicio: ");  
		etiqueta3.setBounds(430, 440, 75, 30);
		
		inicio = new JTextField(5);
		inicio.setBounds(467, 448, 30, 18);
		
		JLabel etiqueta4 = new JLabel("Fin: ");  
		etiqueta4.setBounds(505, 440, 75, 30);
		
		fin = new JTextField(5);
		fin.setBounds(531, 448, 30, 18);
		
		JLabel etiqueta5 = new JLabel("Año: ");  
		etiqueta5.setBounds(340, 440, 75, 30);
		
		ano = new JTextField(5);
		ano.setBounds(368, 448, 50, 18);

		
		JLabel etiqueta6 = new JLabel("AÑOS SIMULADOS");  
		etiqueta6.setBounds(90, 10, 175, 100);
		
		JLabel etiqueta7 = new JLabel("RESULTADOS DE SIMULACION");  
		etiqueta7.setBounds(360, 10, 200, 100);
						
		//Crea boton simular
		boton1 = new JButton("SIMULAR");
		boton1.setBounds(100, 450, 88, 30);
		boton1.setActionCommand("simular");
		boton1.addActionListener(controlador);

		//Se crea boton mostrar
		boton2 = new JButton("MOSTRAR");
		boton2.setBounds(390, 485, 120, 30);
		boton2.setActionCommand("Borrar");
		boton2.setActionCommand("mostrar");
		boton2.addActionListener(controlador);	
		
		//Se crea boton ver
		boton3 = new JButton("VER");
		boton3.setBounds(100, 420, 88, 30);		
		boton3.setActionCommand("ver");
		boton3.addActionListener(controlador);	

		//Se crea área de texto
		listado1 = new JTextArea();		//Muestra de datos
		listado1.setBounds(300, 100, 300, 300);
		getContentPane().add(listado1);

		//Se crea área de texto
		listado2 = new JTextArea();		//Años simulados
		listado2.setBounds(100, 100, 88, 300);
		getContentPane().add(listado2);
		
		//Se añade todos los elementos creados al tapiz
		tapiz.add(listado1);
		tapiz.add(listado2);
		tapiz.add(boton1);
		tapiz.add(boton2);	
		tapiz.add(boton3);			
		tapiz.add(AnoSim);
		tapiz.add(etiqueta1);
		tapiz.add(inicio);
		tapiz.add(etiqueta2);
		tapiz.add(fin);
		tapiz.add(etiqueta3);
		tapiz.add(etiqueta4);
		tapiz.add(etiqueta5);
		tapiz.add(ano);
		tapiz.add(etiqueta6);
		tapiz.add(etiqueta7);
		tapiz.add(boton1);	
		tapiz.add(boton3);	
		add(tapiz);		
	}
	
	public JTextArea getTextListado1() {
		return listado1;		
	}
	
	public JTextArea getTextListado2() {
		return listado2;		
	}
	
	public JTextField getAnoSim() {
		return AnoSim;		
	}
	
	public JTextField getInicio() {
		return inicio;		
	}
	
	public JTextField getFin() {
		return fin;		
	}
	
	public JTextField getAno() {
		return ano;		
	}


}
