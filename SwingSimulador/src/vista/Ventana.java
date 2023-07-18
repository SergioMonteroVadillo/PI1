package vista;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Line2D;

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
	JTextArea listado3;
	JTextArea listado4;
	JTextArea listado5;
	JTextArea listado6;
	JTextArea listado7;
	JTextArea listado8;
	
	
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
		AnoSim.setBounds(125, 490, 50, 18);
		
		JLabel etiqueta2 = new JLabel("SELECCIONE PERIODO ");
		etiqueta2.setBounds(380, 210, 175, 30);
				
		JLabel etiqueta3 = new JLabel("Inicio: ");  
		etiqueta3.setBounds(425, 240, 75, 30);
		
		inicio = new JTextField(5);
		inicio.setBounds(462, 248, 30, 18);
		
		JLabel etiqueta4 = new JLabel("Fin: ");  
		etiqueta4.setBounds(500, 240, 75, 30);
		
		fin = new JTextField(5);
		fin.setBounds(526, 248, 30, 18);
		
		JLabel etiqueta5 = new JLabel("Año: ");  
		etiqueta5.setBounds(335, 240, 75, 30);
		
		ano = new JTextField(5);
		ano.setBounds(368, 248, 50, 18);
		
		JLabel etiqueta6 = new JLabel("Temperatura: ");  
		etiqueta6.setBounds(320, 100, 85, 30);
		
		JLabel etiqueta7 = new JLabel("Humedad: ");  
		etiqueta7.setBounds(460, 100, 85, 30);
		
		JLabel etiqueta8 = new JLabel("Iluminacion: ");  
		etiqueta8.setBounds(320, 130, 85, 30);
		
		JLabel etiqueta9 = new JLabel("Viento: ");  
		etiqueta9.setBounds(460, 130, 85, 30);
		
		JLabel etiqueta10 = new JLabel("Lluvias: ");  
		etiqueta10.setBounds(320, 160, 85, 30);
		
		JLabel etiqueta11 = new JLabel("ICA: ");  
		etiqueta11.setBounds(460, 160, 85, 30);		
		
		JLabel etiqueta12 = new JLabel("AÑOS SIMULADOS");  
		etiqueta12.setBounds(90, 10, 175, 100);
		
		JLabel etiqueta13 = new JLabel("RESULTADOS DE SIMULACION");  
		etiqueta13.setBounds(360, 10, 200, 100);
		
		JLabel etiqueta14 = new JLabel("MENSAJES DE ALERTA");
		etiqueta14.setBounds(380, 350, 175, 30);
						
		//Crea boton simular
		boton1 = new JButton("SIMULAR");
		boton1.setBounds(100, 450, 88, 30);
		boton1.setActionCommand("simular");
		boton1.addActionListener(controlador);

		//Se crea boton mostrar
		boton2 = new JButton("MOSTRAR");
		boton2.setBounds(390, 285, 120, 30);
		boton2.setActionCommand("Borrar");
		boton2.setActionCommand("mostrar");
		boton2.addActionListener(controlador);	
		
		//Se crea boton ver
		boton3 = new JButton("VER");
		boton3.setBounds(100, 420, 88, 30);		
		boton3.setActionCommand("ver");
		boton3.addActionListener(controlador);	

		//Se crea área de texto
		listado1 = new JTextArea();		//Mensajes
		listado1.setBounds(300, 400, 300, 80);
		getContentPane().add(listado1);

		//Se crea área de texto
		listado2 = new JTextArea();		//Años simulados
		listado2.setBounds(100, 100, 88, 300);
		getContentPane().add(listado2);

		listado3 = new JTextArea();		//Temperatura
		listado3.setBounds(400, 108, 55, 18);
		getContentPane().add(listado3);
		
		listado4 = new JTextArea();		//Humedad
		listado4.setBounds(520, 108, 55, 18);
		getContentPane().add(listado4);
		
		listado5 = new JTextArea();		//Iluminacion
		listado5.setBounds(400, 138, 55, 18);
		getContentPane().add(listado5);

		listado6 = new JTextArea();		//Viento
		listado6.setBounds(520, 138, 55, 18);
		getContentPane().add(listado6);

		listado7 = new JTextArea();		//Precipitaciones
		listado7.setBounds(400, 168, 55, 18);
		getContentPane().add(listado7);

		listado8 = new JTextArea();		//ICA
		listado8.setBounds(520, 168, 55, 18);
		getContentPane().add(listado8);

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
		tapiz.add(etiqueta8);		
		tapiz.add(etiqueta9);
		tapiz.add(etiqueta10);
		tapiz.add(etiqueta11);
		tapiz.add(etiqueta12);
		tapiz.add(etiqueta13);
		tapiz.add(etiqueta14);
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
	public JTextArea getTextListado3() {
		return listado3;		
	}
	public JTextArea getTextListado4() {
		return listado4;		
	}
	public JTextArea getTextListado5() {
		return listado5;		
	}
	public JTextArea getTextListado6() {
		return listado6;		
	}
	public JTextArea getTextListado7() {
		return listado7;		
	}
	public JTextArea getTextListado8() {
		return listado8;		
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
