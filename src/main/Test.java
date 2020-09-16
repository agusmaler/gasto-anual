package main;

import clases.GastoAnual;
import clases.Mes;

public class Test {

	public static void main(String[] args) {
		GastoAnual ga = new GastoAnual();
		ga.agregarGasto(Mes.ENERO, "viaticos", 200);
		ga.agregarGasto(Mes.ENERO, "alimentos", 18000);
		ga.agregarGasto(Mes.FEBRERO, "viaticos", 530);
		ga.agregarGasto(Mes.FEBRERO, "alimentos", 21500);
		ga.agregarGasto(Mes.MARZO, "viaticos", 2500);
		ga.agregarGasto(Mes.MARZO, "alimentos", 24000);
		System.out.println("Acumulado Enero: " + ga.gastoAcumulado(Mes.ENERO));
		System.out.println("Acumulado viaticos: " + ga.gastoAcumulado("viaticos"));
		ga.informarConsumosPorMes();
		ga.informarMesMayorConsumo();
		ga.informarPromedioMensualPorRubro();
	}
}