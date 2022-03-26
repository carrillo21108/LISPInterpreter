/**
 * Clase Principal
 * @author Brian Carrillo, Jennifer Toxcon y Carlos Lopez
 * @version 25.03.2022
 *
 * En esta clase se maneja el metodo main que permite la ejecucion del 
 * programa. Desde el metodo main se ejecutan los metodos de la calculadora.
 */

package uvg.edu.principal;

/**
 * Importacion de la clase scanner e importar el interpreter
 */
import java.util.Scanner;

import uvg.edu.lisp.Interpreter;

/**
 * Clase principal del programa
 * @author Brian Carrillo
 *
 */
public class Principal {

	/**
	 * @param args:(String[])
	 * @see System.out.println()
	 * @see java.util.Scanner()
	 * 
	 */
	public static void main(String[] args) {
		Interpreter miLispInterpreter = new Interpreter();
		/**
		 * instancia del scanner
		 * 
 		*/
		Scanner in = new Scanner(System.in);
		/**
		 * Inicio de la principal
		 */
		System.out.println("Bienvenido a LISP Interpreter. Ingrese una expresion LISP o escriba exit para salir.");
		String opt = "";
		do {
			opt = in.nextLine();
			
			if (!opt.equals("exit")) {
				System.out.println(miLispInterpreter.Operate(opt).performOperation());
			}
			
		}while (!opt.equals("exit"));

	}

}
