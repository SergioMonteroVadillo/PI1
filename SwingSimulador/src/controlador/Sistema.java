package controlador;

import vista.Ventana;

public class Sistema {
	
	static Sistema s = new Sistema();

	public static void main(String[] args) {
				
		ControladorVentana controlador = new ControladorVentana(s);
		Ventana ventana = new Ventana(controlador);
		controlador.setVentanaAControlar(ventana);
		ventana.setVisible(true);

	}

}
