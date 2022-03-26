/**
 * 
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
