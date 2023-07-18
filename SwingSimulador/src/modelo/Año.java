package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Random;
import java.util.Vector;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Año {
	
	private int año;
	Vector<Dia>  dias = new Vector<Dia>();
	Vector<String> AñosSimulados = new Vector<String>();
	private String AñosEscritos = "";
	
	File Años = new File("Años.txt");
	
	public Año() {	LeerAño(Años,this.año);}

	public Año (int año) {

		this.año = año;

		if (LeerAño(Años,this.año) == true) {

			AnotarAño(Años, this.año);

			int dAño = 0 ;
			int modulo = (this.año - ((this.año/4) * 4));
			if (modulo == 0) {
				dAño = 366;
			}else {
				dAño = 365;
			}

			for (int i = 0; i < dAño; i++) {

				Dia eventos = new Dia();

				eventos.setnDia(i+1);
				eventos.setTemperatura(gTemperatura(i+1));
				eventos.setICA(gICA(i+1));
				eventos.setViento(gViento(i+1));
				eventos.setHumedad(gHumedad(i+1));
				eventos.setLuminosidad(gLuminosidad(i+1));
				eventos.setPrecipitaciones(gPrecipitaciones(i+1));

				dias.add(eventos);

			}

			Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();

			try(FileWriter write = new FileWriter(this.año+".json")){
				prettyGson.toJson(dias, write);			
			} catch (IOException e) {			
				e.printStackTrace();
			}
			AñosEscritos = "\n                           Se ha simulado el año "+this.año;
		}else {
			AñosEscritos = "\n                         El año " +this.año+ " ya fue simulado";
		}
		
	}
	

	public void setAño(int año) {
		this.año = año;
	}

	public int getAño() {
		return año;
	}

	public int gTemperatura(int dia) {
		
		Random rdm = new Random();
		int temperatura = 0;
		int probabilidad = (rdm.nextInt(100 - 0 + 1) + 0);
				
		if (dia < 90){	
			
			if ( probabilidad <= 70) {

				temperatura = rdm.nextInt(10 + 5 + 1) - 5;

			}else {temperatura = rdm.nextInt(25 - 5 + 1) + 5;}
			

		}else if (dia < 180){

			if ( probabilidad <= 60) {

				temperatura = rdm.nextInt(20 - 5 + 1) + 5;

			}else {temperatura = rdm.nextInt(30 - 15 + 1) + 15;}
			

		}else if (dia < 270){

			if ( probabilidad <= 60) {

				temperatura = rdm.nextInt(45 - 25 + 1) + 25;

			}else {temperatura = rdm.nextInt(30 - 15 + 1) + 15;}

		}else {

			if ( probabilidad <= 50) {

				temperatura = rdm.nextInt(30 - 5 + 1) + 5;

			}else {temperatura = rdm.nextInt(15 - 0 + 1) + 0;}			
		}		

		return temperatura;
	}

	public int gICA(int dia) {
		
		Random rdm = new Random();
		int ICA = 0;
		int probabilidad = (rdm.nextInt(100 - 0 + 1) + 0);
		
		if (dia < 60){
			ICA = rdm.nextInt(60 - 20 + 1) + 20;
		}else if (dia < 150){
			ICA = rdm.nextInt(80 - 20 + 1) + 20;
		}else if (dia < 240){
			ICA = rdm.nextInt(40 - 10 + 1) + 20;
		}else {
			ICA = rdm.nextInt(100 - 30 + 1) + 20;
		}
		return ICA; 
	}

	public int gViento(int dia) {
		
		Random rdm = new Random();
		int Viento = 0;
		int probabilidad = (rdm.nextInt(100 - 0 + 1) + 0);
		
		if (dia < 60){
			Viento = rdm.nextInt(30 - 0 + 1) + 0;
		}else if (dia < 150){
			Viento = rdm.nextInt(100 - 20 + 1) + 20;
		}else if (dia < 240){
			Viento = rdm.nextInt(60 - 10 + 1) + 10;
		}else {
			Viento = rdm.nextInt(120 - 5 + 1) + 5;
		}		
		return Viento;
	}

	public int gHumedad(int dia) {

		Random rdm = new Random();
		int humedad = 0;
		int probabilidad = (rdm.nextInt(100 - 0 + 1) + 0);
		
		if (dia < 60){
			humedad = rdm.nextInt(60 - 20 + 1) + 1;
		}else if (dia < 150){
			humedad = rdm.nextInt(80 - 20 + 1) + 1;
		}else if (dia < 240){
			humedad = rdm.nextInt(40 - 10 + 1) + 1;
		}else {
			humedad = rdm.nextInt(100 - 30 + 1) + 1;
		}
		return humedad;
	}

	public int gLuminosidad(int dia) {

		Random rdm = new Random();
		int luminosidad = 0;
		int probabilidad = (rdm.nextInt(100 - 0 + 1) + 0);
		
		if (dia < 60){
			luminosidad = rdm.nextInt(60 - 20 + 1) + 1;
		}else if (dia < 150){
			luminosidad = rdm.nextInt(80 - 20 + 1) + 1;
		}else if (dia < 240){
			luminosidad = rdm.nextInt(40 - 10 + 1) + 1;
		}else {
			luminosidad = rdm.nextInt(100 - 30 + 1) + 1;
		}
		return luminosidad;
	}

	public int gPrecipitaciones(int dia) {

		Random rdm = new Random();
		int precipitaciones = 0;
		int probabilidad = (rdm.nextInt(100 - 0 + 1) + 0);
		
		if (dia < 60){
			precipitaciones = rdm.nextInt(15 - 2 + 1) + 2;
		}else if (dia < 150){
			precipitaciones = rdm.nextInt(20 - 3 + 1) + 3;
		}else if (dia < 240){
			precipitaciones = rdm.nextInt(2 - 0 + 1) + 0;
		}else {
			precipitaciones = rdm.nextInt(20 - 1 + 1) + 1;
		}
		return precipitaciones;
	}
	
	public void AnotarAño(File Años, int año) {
		
		try {
			if (!Años.exists()) {
				Años.createNewFile();
			}
			
			BufferedWriter escribeAño = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(Años, true), "utf-8"));
			escribeAño.write(this.año+"\n");			
			
			escribeAño.close();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}
	
	public boolean LeerAño(File Años, int año) {
		
		boolean existe = true;//false;		
		
		try {
			if (!Años.exists()) {
				Años.createNewFile();
			}
			
			BufferedReader LeeAño = new BufferedReader(new FileReader(Años));
				
			String AñoLeido;
			
			while ((AñoLeido = LeeAño.readLine()) != null) {
				AñosSimulados.add(AñoLeido);				
			}
			
			LeeAño.close();
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		AñosSimulados.sort(null);
		    
		for(String a : AñosSimulados) {
			AñosEscritos += "         "+a+"\n";
			if (a.equals(año+"")) {
				existe = false;				
			}
			
		}		
		return existe;
	}
	
	public String toString() {
		
		System.out.println(AñosEscritos);
		return AñosEscritos;
	}
}