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
	private String temperatura, ICA, viento, humedad, luminosidad, precipitaciones;
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
			
			this.temperatura = String.format("%.2f",media(tT,c))+"C";
			this.ICA = String.format("%.2f",media(tI,c));
			this.viento = String.format("%.2f",media(tV, c))+"Kmh";
			this.humedad = String.format("%.2f",media(tH, c))+"%";
			this.luminosidad = String.format("%.2f",media(tL,c))+"%";
			this.precipitaciones = String.format("%.2f",media(tP,c))+"lm2";

			resultado = "\n\n                      Solicitud realizada correctamente";


			if (this.inicio > this.fin) {

				resultado = "\n\n  La fecha de inicio tine que ser menor que la fecha final";
			}

		}else {
			resultado = "\n\n                     El año " +this.año+ ", no ha sido simulado";
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




	public String getTemperatura() {
		return temperatura;
	}

	public String getICA() {
		return ICA;
	}

	public String getViento() {
		return viento;
	}

	public String getHumedad() {
		return humedad;
	}

	public String getLuminosidad() {
		return luminosidad;
	}

	public String getPrecipitaciones() {
		return precipitaciones;
	}

	@Override
	public String toString() {

		return resultado;
	}
}
