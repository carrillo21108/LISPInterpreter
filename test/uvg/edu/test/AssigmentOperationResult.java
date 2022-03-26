/**
 * 
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
class AssigmentOperationResult {
	
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
