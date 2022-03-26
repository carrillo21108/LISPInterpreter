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
class PredicateOperationTest {
//predicateoperation
	private Interpreter intp;
	

	public void PredicateOperationTest() {
		intp = new Interpreter();
			
	}
	
	@Test
	//jUnit Interpreter
		void equal() {
		PredicateOperationTest();
		IOperationResult result =  intp.equal("(equal 10 10)");
		assertEquals (result.performOperation(),"El resultado de la operacion  equal  es: T" );
	}
	
	@Test
	//jUnit Interpreter
		void equalnil() {
		PredicateOperationTest();
		IOperationResult result =  intp.equal("(equal 10 1)");
		assertEquals (result.performOperation(),"El resultado de la operacion  equal  es: NIL" );
	}
	
	@Test
	//jUnit Interpreter
		void greaterThan() {
		PredicateOperationTest();
		IOperationResult result =  intp.greaterThan("> 10 2");
		assertEquals (result.performOperation(),"El resultado de la operacion  greater than  es: T" );
	}
	
	@Test
	//jUnit Interpreter
		void greaterThanNIL() {
		PredicateOperationTest();
		IOperationResult result =  intp.greaterThan("> 10 20");
		assertEquals (result.performOperation(),"El resultado de la operacion  greater than  es: NIL" );
	}
	
	@Test
	//jUnit Interpreter
		void smallerThan() {
		PredicateOperationTest();
		IOperationResult result =  intp.smallerThan("(< 10 2)");
		assertEquals (result.performOperation(),"El resultado de la operacion  smaller than  es: NIL" );
	}
	
	
	@Test
	//jUnit Interpreter
		void smallerThannil() {
		PredicateOperationTest();
		IOperationResult result =  intp.smallerThan("(< 10 2)");
		assertEquals (result.performOperation(),"El resultado de la operacion  smaller than  es: NIL" );
	}
	
	@Test
	void listOperation() {
		PredicateOperationTest();
		IOperationResult result =  intp.listOperation("(list 1 2)");
		assertEquals (result.performOperation(),"El resultado de la operacion  list  es: (1 2)" );
	}
	
	@Test
	void listOperationNIL() {
		PredicateOperationTest();
		IOperationResult result =  intp.listOperation("(list)");
		assertEquals (result.performOperation(),"El resultado de la operacion  list  es: NIL" );
	}
	

	@Test
	void atomOperation() {
		PredicateOperationTest();
		IOperationResult result =  intp.atomOperation("(atom '(3 2 1))");
		assertEquals (result.performOperation(),"El resultado de la operacion  atom  es: NIL" );
	}
	
	
	
	@Test
	void atomOperationNIL() {
		PredicateOperationTest();
		IOperationResult result =  intp.atomOperation("(atom (3))");
		assertEquals (result.performOperation(),"El resultado de la operacion  atom  es: T" );
	}

}
