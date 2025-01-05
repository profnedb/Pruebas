/**
 * 
 */
package practica_3_daw;

/**
 * 
 */
public class CCuenta {
	
    public static void main(String[] args) {
    	// Depuracion. Se detiene siempre
    	CCuenta miCuenta = new CCuenta();
    	
    	System.out.println("Saldo Incial: " + miCuenta.dSaldo + " euros");
    	// Depuracion. Provoca parada por ingreso con cantidad menor de 0
    	System.out.println("Ingreso -100:");
    	miCuenta.ingresar(-100);
    	
    	System.out.println("Saldo Incial: " + miCuenta.dSaldo + " euros");
    	System.out.println("Ingreso 100:");
    	miCuenta.ingresar(100);
    	
    	System.out.println("Saldo tras ingreso: " + miCuenta.dSaldo + " euros");
    	System.out.println("Ingreso 200:");
    	miCuenta.ingresar(200);
    	
    	System.out.println("Saldo tras ingreso: " + miCuenta.dSaldo + " euros");
    	// Depuracion. Provoca parada con codicion de tercer ingreso
    	System.out.println("Ingreso 300:");
    	miCuenta.ingresar(300);
    	
    	System.out.println("Saldo tras ingreso: " + miCuenta.dSaldo + " euros");
    	System.out.println("Retiro 50:");
    	miCuenta.retirar(50);
    	
    	System.out.println("Saldo tras retirada: " + miCuenta.dSaldo + " euros");
    }
    
    // Propiedades de la Clase Cuenta
    public double dSaldo = 0;
 
    /* Metodo para ingresar cantidades en la cuenta. Modifica el saldo.
     * Este metodo va a ser probado con Junit
     */
    public int ingresar(double cantidad) 
    {
    	int iCodErr;
    	
    	/*version inicial de la clase, con cantidad <0 primero, pero así no puede entrar en el -3 */
    	/*
        if (cantidad < 0)
        {
        	System.out.println("No se puede ingresar una cantidad negativa");
        	iCodErr = 1;
        }
        else if (cantidad == -3)
        {
            System.out.println("Error detectable en pruebas de caja blanca");
        	iCodErr = 2;
        }*/
    	if (cantidad == -3)
        {
        	System.out.println("Error detectable en pruebas de caja blanca");
         	iCodErr = 2;
        }
        else if (cantidad < 0)
        {
        	System.out.println("No se puede ingresar una cantidad negativa");
        	iCodErr = 1;
        }
        else
        {
        	// Depuracion. Punto de parada. Solo en el 3 ingreso        
        	dSaldo = dSaldo + cantidad;
        	iCodErr = 0;
        }
        
    	// Depuracion. Punto de parada cuando la cantidad  es menor de 0        
        return iCodErr;
    }
    
    /*1. Análisis de Caja Blanca del Método ingresar
    El análisis de caja blanca implica analizar todos los posibles caminos ejecutables en el código del método ingresar. A continuación, detallo los caminos identificados:

    Caminos posibles en el método ingresar

    Camino 1: La cantidad es menor que 0:
    Condición if (cantidad < 0) se cumple.
    Se ejecuta:
    System.out.println("No se puede ingresar una cantidad negativa");
    iCodErr = 1;
    Camino 2: La cantidad es igual a -3:
    Condición else if (cantidad == -3) se cumple.
    Se ejecuta:
    System.out.println("Error detectable en pruebas de caja blanca");
    iCodErr = 2;
    Camino 3: La cantidad es mayor o igual a 0 y distinta de -3:
    Condición else se cumple.
    Se ejecuta:
    dSaldo = dSaldo + cantidad;
    iCodErr = 0;


    Pruebas necesarias para cubrir todos los caminos

    Prueba con cantidad = -100 (para cubrir el camino 1).
    Prueba con cantidad = -3 (para cubrir el camino 2).
    Prueba con cantidad = 100 (para cubrir el camino 3).

    */

    /* Metodo para retirar cantidades en la cuenta. Modifica el saldo.
     * Este metodo va a ser probado con Junit
     */
    public void retirar (double cantidad) 
    {
        if (cantidad <= 0)
        {
            System.out.println("No se puede retirar una cantidad negativa");
        }
        else if (dSaldo < cantidad)
        {
            System.out.println("No se hay suficiente saldo");
        }
        else
        {
        	dSaldo = dSaldo - cantidad;
        }
    }
}



/*




2. Análisis de Caja Negra del Método retirar
En el análisis de caja negra, consideramos los posibles valores de entrada, límites y casos extremos, sin examinar el código interno.

Condiciones del método retirar:

La cantidad a retirar no debe ser menor o igual a 0.
La cantidad a retirar no debe ser mayor que el saldo actual (dSaldo).
Clases de equivalencia y valores límite

Cantidad negativa o cero (inválido):
Casos: cantidad = -1, cantidad = 0.
Cantidad mayor al saldo actual (inválido):
Si dSaldo = 100, probar cantidad = 150.
Cantidad válida (válido):
Si dSaldo = 100, probar cantidad = 50.
Casos de prueba específicos:

cantidad = -1 → Resultado esperado: "No se puede retirar una cantidad negativa".
cantidad = 0 → Resultado esperado: "No se puede retirar una cantidad negativa".
cantidad = 150 (con dSaldo = 100) → Resultado esperado: "No hay suficiente saldo".
cantidad = 50 (con dSaldo = 100) → Saldo restante: 50.
*/

