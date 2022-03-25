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
class DefunOperationTest {
	
	private Interpreter intp;
	

	public void DefunOperationTest() {
		intp = new Interpreter();
			
	}

	@Test
	void defunOperationResult() {
		DefunOperationTest();
		IOperationResult result =  intp.defunOperationResult("(defun prueba (x)(+ x 10))");
		assertEquals (result.performOperation(),"Funcion: prueba asignada con valor (x)(+ x 10)" );
	}

}
