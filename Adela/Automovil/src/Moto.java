
public class Moto extends Automovil{

	private int cc;
	public Moto(int matricula, int numeroRuedas, int kilometraje, int cc) {
		super(matricula, numeroRuedas, kilometraje);
		this.cc = cc;
	}

	public int getCc() {
		return cc;
	}

	public void setCc(int cc) {
		this.cc = cc;
	}
	
	@Override
	int cambioDeRuedas() {
		
		return 0;
	}

}
