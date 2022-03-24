/**
 * 
 */
package uvg.edu.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import uvg.edu.common.IOperationResult;
import uvg.edu.lisp.Interpreter;


/**
 * @author jenni
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
	
	
	
		void subtractionOperation() {
		Inicio();
		IOperationResult result =  intp.subtractionOperation("(- 5 2)");
		assertEquals (result.performOperation(),"El resultado de la operacion  suma  es: 3" );
	}
	
	
	
	

}





			
	
