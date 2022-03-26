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
class CondOperationTest {

private Interpreter intp;
	
//cond operation
	public void CondOperationTest() {
		intp = new Interpreter();
			
	}
	
	@Test
	void condOperation() {
		CondOperationTest();
		IOperationResult result =  intp.condOperation("(cond ((= 0 10) (+ 10 10))((> 10 9) (+ 5 10)))");
		assertEquals (result.performOperation(),"El resultado de la condicion  es: 15" );
	}
	
	@Test
	void condOperation2() {
		CondOperationTest();
		IOperationResult result =  intp.condOperation("(cond ((= 10 10) (+ 10 10))((> 0 9) (+ 5 10)))");
		assertEquals (result.performOperation(),"El resultado de la condicion  es: 20" );
	}
	
	@Test
	void condOperationT() {
		CondOperationTest();
		IOperationResult result =  intp.condOperation("(cond ((= 0 10) (+ 10 10))(t (+ 5 10)))");
		assertEquals (result.performOperation(),"El resultado de la condicion  es: 15" );
	}

}
