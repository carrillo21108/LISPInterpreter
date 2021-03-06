/**
 * Clase Sintaxis Scanner
 * @author Brian Carrillo, Jennifer Toxcon y Carlos Lopez
 * @version 25.03.2022
 *
 * En esta clase se escanean las operaciones.
 */

package uvg.edu.lisp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Brian Carrillo
 *
 */
public class SintaxScanner {

	/***
	 * This method return a integer number that identifies the type of the operation
	 * @param Expresion The expresion given by the user
	 * @return An integer greater than 0 that indicates the type of the operation, -1 if the expression is not valid
	 */
	public static int getState(String expresion){
		if (evaluate("^[(][ ]*setq[ ]+[a-z]+[ ]+[0-9]+[ ]*[)]$",expresion)) //This is a simple assignment using setq
			return 1;
		else if (evaluate("^[(][ ]*[+][ ]+([a-z]+|[0-9]+)[ ]+(([a-z]+|[0-9]+)[ ]*)*[)]$",expresion))
			return 2;
		else if (evaluate("^[(][ ]*[-][ ]+([a-z]+|[0-9]+)[ ]+(([a-z]+|[0-9]+)[ ]*)*[)]$",expresion))
			return 3;
		else if (evaluate("^[(][ ]*[*][ ]+([a-z]+|[0-9]+)[ ]+(([a-z]+|[0-9]+)[ ]*)*[)]$",expresion))
			return 4;
		else if (evaluate("^[(][ ]*[/][ ]+([a-z]+|[0-9]+)[ ]+(([a-z]+|[0-9]+)[ ]*)*[)]$",expresion))
			return 5;
		else if (evaluate("^[(][ ]*(quote |')+([+]|[-]|[*]|[/]|[(]|[)]|[0-9]|[a-z]|[defun]|[ ])*[)]$",expresion))
			return 6;
		else if (evaluate("^[(][ ]*defun[ ]+([a-z]|[a-z,0-9]+)[ ]+([(]([a-z,0-9][ ]*)+[)][ ]*([(][ ]*([+]+|[-]+|[*]+|[/]+)[ ]+(([a-z]+[ ]([(].*[)])+)|([0-9]+[ ]([(].*[)])+)|([(].*[)])+|(([(].*[)])+[ ][0-9]+)|(([(].*[)])+[ ][a-z]+)|([a-z]+|[0-9]+)[ ]+(([a-z]+|[0-9]+)[ ]*))[ ]*[)]))[)]$",expresion))
			return 7;
		else if (evaluate("^[(][ ]*atom[ ]+((((\"[a-z]\")+|[0-9]+|(NIL)+|(T)+|('[0-9]+))[ ]*)|[']([(]+[ ]*(((\"[a-z]\")+|[0-9]+|(NIL)+|(T)+)[ ]*)+[)]))[)]$",expresion)) //This is a simple add operation of 2 operands
			return 8;
		else if (evaluate("^[(][ ]*list[ ]*(((\"[a-z]\")*|[0-9]*|(NIL)*|(T)*)[ ]*)+[)]$",expresion))
			return 9;
		else if (evaluate("^[(][ ]*equal[ ]+[0-9]+[ ]+[0-9]+[ ]*[)]$",expresion))
			return 10;
		else if (evaluate("^[(][ ]*[<][ ]+([a-z]+|[0-9]+)+[ ]+([a-z]+|[0-9]+)+[ ]*[)]$",expresion))
			return 11;
		else if (evaluate("^[(][ ]*[>][ ]+([a-z]+|[0-9]+)+[ ]+([a-z]+|[0-9]+)+[ ]*[)]$",expresion))
			return 12;
		else if (evaluate("^[(]cond [(]([(].*[)])[)]$",expresion))
			return 13;
		else if (evaluate("^[(][ ]*([+]+|[-]+|[*]+|[/]+)[ ]+(([a-z]+[ ]([(].*[)])+)|([0-9]+[ ]([(].*[)])+)|([(].*[)])+|(([(].*[)])+[ ][0-9]+)|(([(].*[)])+[ ][a-z]+))[ ]*[)]$",expresion))
			return 14;
		else if (evaluate("^[(][ ]*([a-z]|[a-z,0-9]+)[ ]+([a-z]+|[0-9]+)[ ]*(([a-z]+|[0-9]+)[ ]*)*[)]$",expresion))
			return 15;
		else if (evaluate("^[(][ ]*defun[ ]+([a-z]|[a-z,0-9]+)[ ]+([(]([a-z,0-9][ ]*)+[)][ ]*([(]cond.*[)]))[)]$",expresion))
			return 16;
		else 
			return -1; //if no match found then the expression is incorrect
	}
	
	/***
	 * Private method which evaluate an expression
	 * @param regex the patter of the expresion
	 * @param expresion The expresion given by the user
	 * @return true if is a match, false otherwise
	 */
	private static boolean evaluate(String regex, String expresion) {
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(expresion);
	    return matcher.find();
	}
	
}