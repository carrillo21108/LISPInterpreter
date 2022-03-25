/**
 * 
 */
package uvg.edu.principal;

import java.util.Scanner;

import uvg.edu.lisp.Interpreter;

/**
 * clase principal del programa
 * @author Brian Carrillo
 *
 */
public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Interpreter miLispInterpreter = new Interpreter();

		Scanner in = new Scanner(System.in);
		
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
