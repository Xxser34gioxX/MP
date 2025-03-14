
public class Coche extends Automovil{

	private int numeroPuertas;
	public Coche(int matricula, int numeroRuedas, int kilometraje, int numeroPuertas) {
		super(matricula, numeroRuedas, kilometraje);
		this.numeroPuertas = numeroPuertas;
	}
	
	//Getter
	public int getNumeroPuertas() {
		return numeroPuertas;
	}
	//Setter
	public void setNumeroPuertas(int numeroPuertas) {
		this.numeroPuertas = numeroPuertas;
	}

	@Override
	int cambioDeRuedas() {
		return 0;
	}
}
