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
class PredicateOperationTest {

private Interpreter intp;
	

	public void Inicio() {
		intp = new Interpreter();
			
	}
	
	@Test
	//jUnit Interpreter
		void equal() {
		Inicio();
		IOperationResult result =  intp.equal("(equal 10 10)");
		assertEquals (result.performOperation(),"El resultado de la operacion  equal  es: T" );
	}
	
	
	@Test
	//jUnit Interpreter
		void equalnil() {
		Inicio();
		IOperationResult result =  intp.equal("(equal 10 1)");
		assertEquals (result.performOperation(),"El resultado de la operacion  equal  es: NIL" );
	}
	
	@Test
	//jUnit Interpreter
		void greaterThan() {
		Inicio();
		IOperationResult result =  intp.greaterThan("> 10 2");
		assertEquals (result.performOperation(),"El resultado de la operacion  greater than  es: T" );
	}
	
	@Test
	//jUnit Interpreter
		void greaterThanNIL() {
		Inicio();
		IOperationResult result =  intp.greaterThan("> 10 20");
		assertEquals (result.performOperation(),"El resultado de la operacion  greater than  es: NIL" );
	}
	
	@Test
	//jUnit Interpreter
		void smallerThan() {
		Inicio();
		IOperationResult result =  intp.smallerThan("(< 10 2)");
		assertEquals (result.performOperation(),"El resultado de la operacion  smaller than  es: NIL" );
	}
	
	
	@Test
	//jUnit Interpreter
		void smallerThannil() {
		Inicio();
		IOperationResult result =  intp.smallerThan("(< 10 2)");
		assertEquals (result.performOperation(),"El resultado de la operacion  smaller than  es: NIL" );
	}
	
	@Test
	//jUnit Interpreter
		void quote() {
		Inicio();
		IOperationResult result =  intp.quote("('(1 2))");
		assertEquals (result.performOperation(),"El resultado de la operacion  es: (1 2)" );
	}
	
	@Test
	//jUnit Interpreter
			
	
	void variableAssigment() {
		Inicio();
		IOperationResult result =  intp.variableAssigment("(setq a 10)");
		assertEquals (result.performOperation(),"Variable: a asignada con valor 10" );
	}
	
	@Test
	void listOperation() {
		Inicio();
		IOperationResult result =  intp.listOperation("(list 1 2)");
		assertEquals (result.performOperation(),"El resultado de la operacion  list  es: (1 2)" );
	}
	
	@Test
	void listOperationNIL() {
		Inicio();
		IOperationResult result =  intp.listOperation("(list)");
		assertEquals (result.performOperation(),"El resultado de la operacion  list  es: NIL" );
	}
	
	@Test
	void atomOperation() {
		Inicio();
		IOperationResult result =  intp.atomOperation("(atom '(3 2 1))");
		assertEquals (result.performOperation(),"El resultado de la operacion  atom  es: NIL" );
	}
	
	
	
	@Test
	void atomOperationNIL() {
		Inicio();
		IOperationResult result =  intp.atomOperation("(atom (3))");
		assertEquals (result.performOperation(),"El resultado de la operacion  atom  es: T" );
	}
	
	@Test
	void defunOperationResult() {
		Inicio();
		IOperationResult result =  intp.defunOperationResult("(defun hola (x)(+ x 10))");
		assertEquals (result.performOperation(),"Funcion: hola asignada con valor (x)(+ x 10)" );
	}
	
	@Test
	void condOperation() {
		Inicio();
		IOperationResult result =  intp.condOperation("(cond((= 10 0) (+ 10 10))((> 10 9) (+ 5 10)))");
		assertEquals (result.performOperation(),"El resultado de la condicion  es: 15" );
	}
	

}

