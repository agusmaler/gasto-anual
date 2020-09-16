package ejercicios.ejercicio6.clases;

import java.util.ArrayList;

public class GastoAnual {

	private ArrayList<Rubro> rubros;

	public GastoAnual() {
		rubros = new ArrayList<>();
	}

	public void agregarGasto(Mes mes, String nombreRubro, double importe) {
		Rubro rubro = obtenerRubro(nombreRubro);
		rubro.agregarGasto(mes, importe);
	}

	private Rubro obtenerRubro(String nombreRubro) {
		Rubro rubro = buscarRubro(nombreRubro);
		if (rubro == null) {
			rubro = new Rubro(nombreRubro);
			rubros.add(rubro);
		}
		return rubro;
	}

	private Rubro buscarRubro(String nombreRubro) {
		Rubro rubro = null;
		int pos = 0;
		while (pos < rubros.size() && !rubros.get(pos).getNombre().equals(nombreRubro)) {
			pos++;
		}
		if (pos < rubros.size()) {
			rubro = rubros.get(pos);
		}
		return rubro;
	}

	private double[][] consolidadoDeGastos() {
		double[][] consolidado = new double[rubros.size()][Mes.values().length];
		Rubro rubro;
		for (int r = 0; r < consolidado.length; r++) {
			rubro = rubros.get(r);
			for (int m = 0; m < consolidado[r].length; m++) {
				consolidado[r][m] = rubro.getTotalGastos(Mes.values()[m]);
			}
		}
		return consolidado;
	}

	public double gastoAcumulado(Mes mes) {
		double importe = 0;
		double[][] gastos = consolidadoDeGastos();
		for (int r = 0; r < gastos.length; r++) {
			importe += gastos[r][mes.ordinal()];
		}
		return importe;
	}

	public double gastoAcumulado(String nombreRubro) {
		double importe = 0;
		Rubro rubro = buscarRubro(nombreRubro);
		if (rubro != null) {
			for (int m = 0; m < Mes.values().length; m++) {
				importe += rubro.getTotalGastos(Mes.values()[m]);
			}
		}
		return importe;
	}

	public void informarConsumosPorMes() {
		double acumMes;
		double importe;
		for (Mes mes : Mes.values()) {
			System.out.println(mes);
			acumMes = 0;
			for (Rubro rubro : rubros) {
				importe = rubro.getTotalGastos(mes);
				if (importe > 0) {
					System.out.printf("%s = %10.2f\n", rubro.getNombre(), importe);
					acumMes += importe;
				}
			}
			if (acumMes > 0) {
				System.out.printf("%s = %10.2f\n", "Total " + mes, acumMes);
			}
		}
	}

	// Para simplificar asumir todo el año completo
	public void informarPromedioMensualPorRubro() {
		double[][] gastos = consolidadoDeGastos();
		double total;
		for (int r = 0; r < gastos.length; r++) {
			total = 0;
			for (int m = 0; m < gastos[r].length; m++) {
				total += gastos[r][m];
			}
			System.out.printf("Promedio anual %s = %10.2f\n", rubros.get(r).getNombre(), total / Mes.values().length);
		}
	}

	public void informarMesMayorConsumo() {
		MaximoMultiple<Mes> mayorConsumo = new MaximoMultiple<>();
		double[][] gastos = consolidadoDeGastos();
		double total;
		for (int m = 0; m < gastos[0].length; m++) {
			total = 0;
			for (int r = 0; r < gastos.length; r++) {
				total += gastos[r][m];
			}
			mayorConsumo.procesar(total, Mes.values()[m]);
		}
		System.out.printf("El mayor consumo fue de %10.2f en %s\n", mayorConsumo.getValor(),
				mayorConsumo.getElementos().toString());
	}

}
