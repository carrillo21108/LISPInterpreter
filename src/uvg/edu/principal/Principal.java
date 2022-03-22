/**
 * 
 */
package uvg.edu.principal;

import java.util.Scanner;

import uvg.edu.lisp.Interpreter;

/**
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
		
		System.out.println("Bienvenido al interpreter Lisp ingrese una expresion o escriba exit para salir");
		String opt = "";
		do {
			opt = in.nextLine();
			
			if (!opt.equals("exit")) {
				miLispInterpreter.Operate(opt).performOperation();
			}
			
		}while (!opt.equals("exit"));

	}

}
