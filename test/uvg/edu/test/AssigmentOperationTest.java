/**
 * Clase AssigmentOperationTest
 * @author Brian Carrillo, Jennifer Toxcon y Carlos Lopez
 * @version 25.03.2022
 *
 * Pruebas operaciones de asignacion
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
class AssigmentOperationTest {
	
	private Interpreter intp;
	

	public void AssigmentOperationResult() {
		intp = new Interpreter();
			
	}

	@Test
	//jUnit Interpreter
			
	//variable asignada
	void variableAssigment() {
		AssigmentOperationResult();
		IOperationResult result =  intp.variableAssigment("(setq a 10)");
		assertEquals (result.performOperation(),"Variable: a asignada con valor 10" );
	}

}
