package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import modelo.Año;
import modelo.Control;
import vista.Ventana;

public class ControladorVentana implements ActionListener{
	
	Ventana ventana = new Ventana(null);
	
	Sistema sistema;

	public ControladorVentana(Sistema s) {
		
		this.sistema = s;
				
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
			
		
		if (e.getActionCommand() == "simular") {
			
			if (ventana.getAnoSim().getText().equals("")) {
				
				this.ventana.getTextListado2().setText("\n\n     Introduzca\n        un año");				
			}else {
				
				int Nano = Integer.parseInt(ventana.getAnoSim().getText());
				Año año = new Año(Nano);
				this.ventana.getTextListado2().setText("\n"+año.toString());
			}
		}
		
		else if(e.getActionCommand() == "mostrar") {

			if (ventana.getInicio().getText().equals("") | ventana.getFin().getText().equals("") | ventana.getAno().getText().equals("")) {
				
				this.ventana.getTextListado1().setText("\n\n\n\n\n\n                  Por favor, rellene todos los campos");
			}else {
				
				int inicio = Integer.parseInt(ventana.getInicio().getText());
				int fin = Integer.parseInt(ventana.getFin().getText());
				int ano = Integer.parseInt(ventana.getAno().getText());

				Control control = new Control(ano, inicio, fin);

				this.ventana.getTextListado1().setText(control.toString());
			}
			
		}
		else if(e.getActionCommand() == "ver") {
			
			Año años = new Año();
			this.ventana.getTextListado2().setText("\n"+años.toString());						
		}
		
	}
	
	public void setVentanaAControlar (Ventana v) {
		this.ventana = v;
	}

}
