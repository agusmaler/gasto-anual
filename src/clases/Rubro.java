package ejercicios.ejercicio6.clases;

public class Rubro {
	// SACO LA CONSTANTE PARA USAR EL ENUM DE MESES
	private String nombre;
	private double[] gastosPorMes;
	
	public Rubro(String nombre) {
		this.setNombre(nombre);
		this.gastosPorMes = new double[Mes.values().length];
		inicializarGastos();
	}

	private void inicializarGastos() {
		for (int i = 0; i < gastosPorMes.length; i++) {
			gastosPorMes[i] = 0;
		}
	}
	
	public void agregarGasto(Mes mes, double importe) {
		if (importe >= 0) {
			gastosPorMes[mes.ordinal()] += importe;
		}
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public double getTotalGastos(Mes mes) {
		return gastosPorMes[mes.ordinal()];
	}
}
