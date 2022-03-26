/**
 * Clase QuoteOperationTest
 * @author Brian Carrillo, Jennifer Toxcon y Carlos Lopez
 * @version 25.03.2022
 *
 * Pruebas con operaciones quote
 */
package uvg.edu.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import uvg.edu.common.IOperationResult;
import uvg.edu.lisp.Interpreter;

/**
 * @author Brian Carrillo
 *
 */
class QuoteOperationTest {

private Interpreter intp;
	
//QuoteOpertaion
	public void QuoteOperationTest() {
		intp = new Interpreter();
			
	}
	//simple
	@Test
	//jUnit Interpreter
		void quote() {
		QuoteOperationTest();
		IOperationResult result =  intp.quote("('(1 2))");
		assertEquals (result.performOperation(),"El resultado de la operacion  es: (1 2)" );
	}
	//compuesta
	@Test
	//jUnit Interpreter
		void quote2() {
		QuoteOperationTest();
		IOperationResult result =  intp.quote("(quote x)");
		assertEquals (result.performOperation(),"El resultado de la operacion  es:  x" );
	}

}
