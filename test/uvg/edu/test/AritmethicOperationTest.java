/**
 * Clase ArithmeticOperationTest
 * @author Brian Carrillo, Jennifer Toxcon y Carlos Lopez
 * @version 25.03.2022
 *
 * Pruebas operaciones aritmeticas
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
	

	public void AritmethicOperationTest() {
		intp = new Interpreter();
			
	}
	
	@Test
	//jUnit Interpreter
	//suma sencilla
		void addOperation() {
		AritmethicOperationTest();
		IOperationResult result =  intp.addOperation("(+ 10 20)");
		assertEquals (result.performOperation(),"El resultado de la operacion  suma  es: 30" );
	}
	//suma compuesta
	@Test
	//jUnit Interpreter
	//suma sencilla
		void addOperationcompuesta() {
		AritmethicOperationTest();
		IOperationResult result =  intp.addOperation("(+ 10 20 10)");
		assertEquals (result.performOperation(),"El resultado de la operacion  suma  es: 40" );
	}
	
	//resta sencilla
	@Test
		void subtractionOperation() {
		AritmethicOperationTest();
		IOperationResult result =  intp.subtractionOperation("(- 20 10)");
		assertEquals (result.performOperation(),"El resultado de la operacion  resta  es: 10" );
	}
	@Test
	//resta compuesta
	void subtractionOperationcompuesta() {
		AritmethicOperationTest();
		IOperationResult result =  intp.subtractionOperation("(- 20 10 5)");
		assertEquals (result.performOperation(),"El resultado de la operacion  resta  es: 5" );
}

	//multiplicacion
	@Test
	//jUnit Interpreter
		void multiplicationOperation() {
		AritmethicOperationTest();
		IOperationResult result =  intp.multiplicationOperation("(* 5 2)");
		assertEquals (result.performOperation(),"El resultado de la operacion  multiplicacion  es: 10" );
	}
	//multiplicacioncompuesta
	@Test
	//jUnit Interpreter
		void multiplicationOperationcompuesta() {
		AritmethicOperationTest();
		IOperationResult result =  intp.multiplicationOperation("(* 5 2 3)");
		assertEquals (result.performOperation(),"El resultado de la operacion  multiplicacion  es: 30" );
	}
	//division
	@Test
	//jUnit Interpreter
		void divisionOperation() {
		AritmethicOperationTest();
		IOperationResult result =  intp.divisionOperation("(/ 10 5)");
		assertEquals (result.performOperation(),"El resultado de la operacion  division  es: 2" );
	}
	//divisioncompuesta
	@Test
	//jUnit Interpreter
		void divisionOperationcompuesta() {
		AritmethicOperationTest();
		IOperationResult result =  intp.divisionOperation("(/ 10 5 2)");
		assertEquals (result.performOperation(),"El resultado de la operacion  division  es: 1" );
	}
	//operacioncompuesta
	@Test
	//jUnit Interpreter
		void combOperation() {
		AritmethicOperationTest();
		IOperationResult result =  intp.combOperationResult("(- 10 (+ 5 7))");
		assertEquals (result.performOperation(),"El resultado de la operacion  es: -2" );
	}
	

}





			
	
