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
		void addOperation() {
		Inicio();
		IOperationResult result =  intp.addOperation("(+ 1 1 1)");
		assertEquals (result.performOperation(),"El resultado de la operacion  suma  es: 3" );
	}
	
	
	@Test
		void subtractionOperation() {
		Inicio();
		IOperationResult result =  intp.subtractionOperation("(- 5 2)");
		assertEquals (result.performOperation(),"El resultado de la operacion  resta  es: 3" );
	}
	
	@Test
	//jUnit Interpreter
		void multiplicationOperation() {
		Inicio();
		IOperationResult result =  intp.multiplicationOperation("(* 2 2 2)");
		assertEquals (result.performOperation(),"El resultado de la operacion  multiplicacion  es: 8" );
	}
	
	@Test
	//jUnit Interpreter
		void divisionOperation() {
		Inicio();
		IOperationResult result =  intp.divisionOperation("(/ 12 4)");
		assertEquals (result.performOperation(),"El resultado de la operacion  division  es: 3" );
	}
	
	@Test
	//jUnit Interpreter
		void equal() {
		Inicio();
		IOperationResult result =  intp.equal("(= 100 200)");
		assertEquals (result.performOperation(),"El resultado de la operacion  equal  es: NIL" );
	}
	
	@Test
	//jUnit Interpreter
		void greaterThan() {
		Inicio();
		IOperationResult result =  intp.greaterThan("> 100 200");
		assertEquals (result.performOperation(),"El resultado de la operacion  greater than  es: NIL" );
	}
	
	@Test
	//jUnit Interpreter
		void smallerThan() {
		Inicio();
		IOperationResult result =  intp.smallerThan("(< 100 200)");
		assertEquals (result.performOperation(),"El resultado de la operacion  smaller than  es: T" );
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
			IOperationResult result =  intp.variableAssigment("( +a )");
			assertEquals (result.performOperation(),"Variable:  asignada con valor 0" );
		}
	
	@Test
	void listOperation() {
	Inicio();
	IOperationResult result =  intp.listOperation("(list 1 2 NIL)");
	assertEquals (result.performOperation(),"El resultado de la operacion  list  es: (1 2 NIL)" );
}
	
	@Test
	void atomOperation() {
	Inicio();
	IOperationResult result =  intp.atomOperation("(atom '(1 T NIL))");
	assertEquals (result.performOperation(),"El resultado de la operacion  atom  es: NIL" );
}
	

}





			
	
