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

public class A�o {
	
	private int a�o;
	Vector<Dia>  dias = new Vector<Dia>();
	Vector<String> A�osSimulados = new Vector<String>();
	private String A�osEscritos = "";
	
	File A�os = new File("A�os.txt");
	
	public A�o() {	LeerA�o(A�os,this.a�o);}

	public A�o (int a�o) {

		this.a�o = a�o;

		if (LeerA�o(A�os,this.a�o) == true) {

			AnotarA�o(A�os, this.a�o);

			int dA�o = 0 ;
			int modulo = (this.a�o - ((this.a�o/4) * 4));
			if (modulo == 0) {
				dA�o = 366;
			}else {
				dA�o = 365;
			}

			for (int i = 0; i < dA�o; i++) {

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

			try(FileWriter write = new FileWriter(this.a�o+".json")){
				prettyGson.toJson(dias, write);			
			} catch (IOException e) {			
				e.printStackTrace();
			}
			A�osEscritos = "\n                           Se ha simulado el a�o "+this.a�o;
		}else {
			A�osEscritos = "\n                         El a�o " +this.a�o+ " ya fue simulado";
		}
		
	}
	

	public void setA�o(int a�o) {
		this.a�o = a�o;
	}

	public int getA�o() {
		return a�o;
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
	
	public void AnotarA�o(File A�os, int a�o) {
		
		try {
			if (!A�os.exists()) {
				A�os.createNewFile();
			}
			
			BufferedWriter escribeA�o = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(A�os, true), "utf-8"));
			escribeA�o.write(this.a�o+"\n");			
			
			escribeA�o.close();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}
	
	public boolean LeerA�o(File A�os, int a�o) {
		
		boolean existe = true;//false;		
		
		try {
			if (!A�os.exists()) {
				A�os.createNewFile();
			}
			
			BufferedReader LeeA�o = new BufferedReader(new FileReader(A�os));
				
			String A�oLeido;
			
			while ((A�oLeido = LeeA�o.readLine()) != null) {
				A�osSimulados.add(A�oLeido);				
			}
			
			LeeA�o.close();
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		A�osSimulados.sort(null);
		    
		for(String a : A�osSimulados) {
			A�osEscritos += "         "+a+"\n";
			if (a.equals(a�o+"")) {
				existe = false;				
			}
			
		}		
		return existe;
	}
	
	public String toString() {
		
		System.out.println(A�osEscritos);
		return A�osEscritos;
	}
}