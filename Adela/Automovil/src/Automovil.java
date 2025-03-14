
public abstract class Automovil {
	private int matricula;
	private int numeroRuedas;
	private int kilometraje;
	
	//Constructor
	public Automovil(int matricula, int numeroRuedas, int kilometraje) {
		this.matricula = matricula;
		this.numeroRuedas = numeroRuedas;
		this.kilometraje = kilometraje;
	}

	//Getters
	public int getMatricula() {
		return matricula;
	}
	
	public int getNumeroRuedas() {
		return numeroRuedas;
	}

	public int getKilometraje() {
		return kilometraje;
	}
	
	
	//Setters
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	
	public void setKilometraje(int kilometraje) {
		this.kilometraje = kilometraje;
	}
	
	public void setNumeroRuedas(int numeroRuedas) {
		this.numeroRuedas = numeroRuedas;
	}
	
	//functions
	abstract int cambioDeRuedas();
	
}
