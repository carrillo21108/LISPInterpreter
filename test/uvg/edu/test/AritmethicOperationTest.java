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
	//suma sencilla
		void addOperation() {
		Inicio();
		IOperationResult result =  intp.addOperation("(+ 10 20)");
		assertEquals (result.performOperation(),"El resultado de la operacion  suma  es: 30" );
	}
	//suma compuesta
	@Test
	//jUnit Interpreter
	//suma sencilla
		void addOperationcompuesta() {
		Inicio();
		IOperationResult result =  intp.addOperation("(+ 10 20 10)");
		assertEquals (result.performOperation(),"El resultado de la operacion  suma  es: 40" );
	}
	
	//resta sencilla
	@Test
		void subtractionOperation() {
		Inicio();
		IOperationResult result =  intp.subtractionOperation("(- 20 10)");
		assertEquals (result.performOperation(),"El resultado de la operacion  resta  es: 10" );
	}
	@Test
	
	void subtractionOperationcompuesta() {
		Inicio();
		IOperationResult result =  intp.subtractionOperation("(- 20 10 5)");
		assertEquals (result.performOperation(),"El resultado de la operacion  resta  es: 5" );
}

	
	@Test
	//jUnit Interpreter
		void multiplicationOperation() {
		Inicio();
		IOperationResult result =  intp.multiplicationOperation("(* 5 2)");
		assertEquals (result.performOperation(),"El resultado de la operacion  multiplicacion  es: 10" );
	}
	
	@Test
	//jUnit Interpreter
		void multiplicationOperationcompuesta() {
		Inicio();
		IOperationResult result =  intp.multiplicationOperation("(* 5 2 3)");
		assertEquals (result.performOperation(),"El resultado de la operacion  multiplicacion  es: 30" );
	}
	
	@Test
	//jUnit Interpreter
		void divisionOperation() {
		Inicio();
		IOperationResult result =  intp.divisionOperation("(/ 10 5)");
		assertEquals (result.performOperation(),"El resultado de la operacion  division  es: 2" );
	}
	
	@Test
	//jUnit Interpreter
		void divisionOperationcompuesta() {
		Inicio();
		IOperationResult result =  intp.divisionOperation("(/ 10 5 2)");
		assertEquals (result.performOperation(),"El resultado de la operacion  division  es: 1" );
	}
	
	
	@Test
	//jUnit Interpreter
		void combOperation() {
		Inicio();
		IOperationResult result =  intp.combOperationResult("(- 10 (+ 5 7))");
		assertEquals (result.performOperation(),"El resultado de la operacion  es: -2" );
	}
	
	

}





			
	
