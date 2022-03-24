/**
 * 
 */
package uvg.edu.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import uvg.edu.common.IOperationResult;
import uvg.edu.lisp.Interpreter;


/**
 * @author jenny
 *
 */
class AritmethicOperationTest {

	
	private Interpreter intp;
	

	public void Inicio() {
		intp = new Interpreter();
			
	}
	
	@Test
	//jUnit Interpreter
		void addOperation() {
		Inicio();
		IOperationResult result =  intp.addOperation("(+ 1 1 1)");
		assertEquals (result.performOperation(),"El resultado de la operacion  suma  es: 3" );
	}
	
	
	@Test
		void subtractionOperation() {
		Inicio();
		IOperationResult result =  intp.subtractionOperation("(- 5 2)");
		assertEquals (result.performOperation(),"El resultado de la operacion  resta  es: 3" );
	}
	
	@Test
	//jUnit Interpreter
		void multiplicationOperation() {
		Inicio();
		IOperationResult result =  intp.multiplicationOperation("(* 2 2 2)");
		assertEquals (result.performOperation(),"El resultado de la operacion  multiplicacion  es: 8" );
	}
	
	@Test
	//jUnit Interpreter
		void divisionOperation() {
		Inicio();
		IOperationResult result =  intp.divisionOperation("(/ 12 4)");
		assertEquals (result.performOperation(),"El resultado de la operacion  division  es: 3" );
	}
	
	

}





			
	
