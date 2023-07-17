package modelo;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.Vector;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Control {
	
	
	private double tT = 0.0, tI = 0.0, tV = 0.0, tH = 0.0, tL = 0.0,tP = 0.0;
	private int c = 0;
	private int año;
	private int inicio;
	private int fin;
	private String resultado;
	
	public Control(int año, int inicio, int fin){
		
		this.año = año;
		this.inicio = inicio;
		this.fin = fin;
			
		Vector<Dia> dias = new Vector<Dia>(deserializarJsonArray());
				
		for(int d = 0; d < dias.size(); d++) {
			
			if (d+1 >= this.inicio && d < this.fin) {
				c++;
				tT += Integer.valueOf(dias.get(d).getTemperatura());
				tI += Integer.valueOf(dias.get(d).getICA());
				tV += Integer.valueOf(dias.get(d).getViento());
				tH += Integer.valueOf(dias.get(d).getHumedad());
				tL += Integer.valueOf(dias.get(d).getLuminosidad());
				tP += Integer.valueOf(dias.get(d).getPrecipitaciones());
			}
		}
		if (dias.size() != 0 ){
			resultado = "\n\n\n\tTemperatura: "+String.format("%.2f",media(tT,c))+" C\n"
					+ "\n\tICA: "+String.format("%.2f",media(tI,c))+"\n"
					+ "\n\tViento: "+String.format("%.2f",media(tV, c))+" Kmh\n"
					+ "\n\tHumedad: "+String.format("%.2f",media(tH, c))+" %\n"
					+ "\n\tLuminosidad: "+String.format("%.2f",media(tL,c))+" %\n"
					+ "\n\tPrecipitaciones: "+String.format("%.2f",media(tP,c))+" l*m2";

			System.out.println(resultado);
		}else {
			resultado = "\n\n\n\n\n\n                  El año " +this.año+ ", no ha sido simulado";
			System.out.println(resultado);
		}
		
		
	}
	
	public double media(double a, double b) {
		double med = (double) (a/b);
		return med;
	}

	public Vector<Dia> deserializarJsonArray(){

		Vector<Dia> dias = new Vector<Dia>();

		try(Reader reader = new FileReader(this.año+".json")){
			Gson gson = new Gson();
			Type tipoListaDias = new TypeToken<Vector<Dia>>(){}.getType();
			dias = gson.fromJson(reader, tipoListaDias);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return dias;
	}

	@Override
	public String toString() {
		
		return resultado;
	}
}
