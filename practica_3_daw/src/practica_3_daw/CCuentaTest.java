/**
 * 
 */
package practica_3_daw;

import static org.junit.jupiter.api.Assertions.*; // Importamos métodos de JUnit para realizar aserciones
import org.junit.jupiter.api.DisplayName;         // Permite asignar un nombre descriptivo a los tests
import org.junit.jupiter.params.ParameterizedTest; // Permite ejecutar pruebas con diferentes parámetros
import org.junit.jupiter.params.provider.CsvSource; // Define los parámetros de las pruebas en formato CSV

class CCuentaTest {

    // Creamos una instancia de la clase CCuenta para realizar las pruebas
    CCuenta miCuenta = new CCuenta();

    // Definimos un test parametrizado para el método ingresar
    @ParameterizedTest
    @CsvSource({
        "-10,1",  // Caso 1: Ingresar una cantidad negativa (-10), se espera error 1
        "-3,2",   // Caso 2: Ingresar la cantidad -3, se espera error 2
        "10,0"    // Caso 3: Ingresar una cantidad válida (10), se espera éxito 0
    })
    @DisplayName("Caja Blanca - Prueba del método ingresar") // Nombre descriptivo del test
    void testIngresar(double cantidad, int resultadoEsperado) {
        // Comparamos el resultado esperado con el resultado devuelto por el método ingresar
    	assertEquals(resultadoEsperado, miCuenta.ingresar(cantidad), 
                "Fallo al probar con cantidad: " + cantidad);
    }
    
}

	
	/*
	
	@Test
    public void testIngresarCantidadNegativa() {
        CCuenta cuenta = new CCuenta();
        int resultado = cuenta.ingresar(-100);
        assertEquals(1, resultado);
    }

    @Test
    public void testIngresarErrorDetectable() {
        CCuenta cuenta = new CCuenta();
        int resultado = cuenta.ingresar(-3);
        assertEquals(2, resultado);
    }

    @Test
    public void testIngresarCantidadValida() {
        CCuenta cuenta = new CCuenta();
        cuenta.ingresar(100);
        assertEquals(100, cuenta.dSaldo, 0.01);
    }
}
*/