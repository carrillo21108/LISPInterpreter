/**
 * Clase FunctionOperationTest
 * @author Brian Carrillo, Jennifer Toxcon y Carlos Lopez
 * @version 25.03.2022
 *
 * Pruebas operaciones funciones
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
class FunctionOperationTest {

	private Interpreter intp;
	
//functionoperation
	
	
	@Test
	public void FunctionOperationTest() {
		intp = new Interpreter();
			
	}
	
	@Test
	void functionOperationResult() {
		FunctionOperationTest();
		IOperationResult creacion =  intp.defunOperationResult("(defun prueba (x)(+ x 10))");
		IOperationResult result =  intp.functionOperationResult("(prueba 10)");
		assertEquals (result.performOperation(),"El resultado de la funcion  es: 20" );
	}
	
	@Test
	void factorial() {
		FunctionOperationTest();
		IOperationResult creacion =  intp.defunOperationResult("(defun factorial (num)(cond ((= num 0) (+ 0 1)) (t (* num (factorial (- num 1))))))");
		IOperationResult result =  intp.functionOperationResult("(factorial 5)");
		assertEquals (result.performOperation(),"El resultado de la funcion  es: 120" );
	}
	
	@Test
	void conversionFaC() {
		FunctionOperationTest();
		IOperationResult creacion =  intp.defunOperationResult("(defun conversionfac (n)(/ (- n 32) 2))");
		IOperationResult result =  intp.functionOperationResult("(conversionfac 32)");
		assertEquals (result.performOperation(),"El resultado de la funcion  es: 0" );
	}
}
