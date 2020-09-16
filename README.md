
_EJERCICIO DE MATRICES-POO REALIZADO EN JAVA_

#### ENUNCIADO
> La clase GastosAnuales permite guardar los datos de los gastos comunes del año separados por rubro y mes. Para eso tiene una colección de rubros, donde cada Rubro tiene un nombre y guarda el importe de los gastos de cada uno de los meses del año. El diseño de clases (incompleto) es el que se muestra en el siguiente gráfico: 
___
___

![UML del ejercicio](UML.png "UML")


> Implementá los métodos de Rubro:
* public Rubro(String nombre)  Es el constructor. Recibe el nombre o descripción del rubro. Debe inicializar el arreglode importes.  
* private void inicializarGastos() Inicializa el arreglo de importes. 
* public void agregarGasto(Mes mes, double importe)  Acumula el importe en la posición correspondiente al mes indicado. 
* public getNombre()  Devuelve el nombre del Rubro. 
* public double getTotalGastos(Mes mes)  Devuelve el importe acumulado de gastos para el mes indicado.

> Implementá los métodos de GastoAnual: 
* public GastoAnual()  Es el constructor, e inicializa la colección de Rubros.
* public void agregarGasto(Mes mes, String nombreRubro, double importe) Agrega el importe gastado al rubro que corresponda y en el mes indicado. Si el rubro no se encuentra registrado en la colección se lo agregará, y cuando ya exista se acumulará en este el valor del gasto. Pero debe controlarse que el importe ingresado sea mayor que cero. 
* private Rubro obtenerRubro(String nombreRubro)  Obtiene y devuelve el Rubro a partir de su nombre. Cuando éste no exista deberá crearlo.  
* private Rubro buscarRubro(String nombreRubro)  Busca y devuelve un Rubro a partir de su nombre. Cuando no lo encuentre deberá volver null. 
* private double[][] consolidadoDeGastos()  Genera un arreglo bidimensional consolidando en una sola estructura todos los gastos del año. La matriz debe medir 12 (la cantidad de meses del año) por la cantidad de Rubros existentes, y cada celda debe contener el importe acumulado para el rubro en ese mes.  
* public double gastoAcumulado(Mes mes)  Devuelve el importe del gasto acumulado en el mes indicado. 
* public double gastoAcumulado(String nombreRubro)  Devuelve el importe del gasto acumulado en el rubro indicado. Si el rubro no existe deberá devolver -1. 
* public void informarConsumosPorMes()  Muestra los consumos por mes (discriminado por cada rubro de gasto y acumulado). 
* public void informarPromedioMensualPorRubro() Muestra los consumos promedio por mes en cada rubro. 
* public void informarMesMayorConsumo()  Calcula y muestra nombre e importe acumulado del mes con mayor consumo total (puede ser uno o más de uno). 
