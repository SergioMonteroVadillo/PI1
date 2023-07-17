package modelo;

public class Dia {
	
	private int nDia ;
	private int temperatura ;
	private int ICA;
	private int viento;
	private int humedad;
	private int luminosidad;
	private int precipitaciones;
	
	public Dia() {	}
	
    public Dia(int nDia, int temperatura, int ICA, int viento, int humedad, int luminosidad, int precipitaciones) {
		
		this.nDia = nDia;		
		this.temperatura = temperatura;
		this.ICA = ICA;
		this.viento = viento;
		this.humedad = humedad;
		this.luminosidad = luminosidad;
		this.precipitaciones = precipitaciones;
	}
			
	public int getnDia() {
		return nDia;
	}

	public void setnDia(int nDia) {
		this.nDia = nDia;
	}

	public int getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(int temperatura) {
		this.temperatura = temperatura;
	}

	public int getICA() {
		return ICA;
	}

	public void setICA(int iCA) {
		ICA = iCA;
	}

	public int getViento() {
		return viento;
	}

	public void setViento(int viento) {
		this.viento = viento;
	}

	public int getHumedad() {
		return humedad;
	}

	public void setHumedad(int humedad) {
		this.humedad = humedad;
	}

	public int getLuminosidad() {
		return luminosidad;
	}

	public void setLuminosidad(int luminosidad) {
		this.luminosidad = luminosidad;
	}

	public int getPrecipitaciones() {
		return precipitaciones;
	}

	public void setPrecipitaciones(int precipitaciones) {
		this.precipitaciones = precipitaciones;
	}

	

	@Override
	public String toString() {
		return "Dia [nDia = " + nDia + ", temperatura = " + temperatura + ", ICA = " + ICA + ", viento = " + viento
				+ ", humedad = " + humedad + ", luminosidad = " + luminosidad + ", precipitaciones = " + precipitaciones
				+ "]";
	}

	
}
