/**
 * 
 */
package uvg.edu.lisp;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import uvg.edu.common.AritmethicOperationResult;
import uvg.edu.common.IOperationResult;
import uvg.edu.common.PredicateOperationResult;

/**
 * @author Brian Carrillo
 *
 */
public class Interpreter {

	private HashMap<String, Integer> myVars;

	public Interpreter() {
		myVars = new HashMap<String, Integer>();
	}
	
	public IOperationResult Operate(String expresion) {
		int state = SintaxScanner.getState(expresion);
		
		switch(state) {
		case 1:{
			return variableAssigment(expresion);
		}
		
		case 2:{
			return addOperation(expresion);
		}
		
		case 10:{
			return equal(expresion);
		}
		
		case 11:{
			return smallerThan(expresion);
		}
		
		case 12:{
			return greaterThan(expresion);
		}
		
		default:{
			
			//Using anonymous Inner class
			IOperationResult errorResult = new IOperationResult() {

				
				@Override
				public void performOperation() {
					System.out.println("ERROR: Invalid expression");
					
				}

				@Override
				public void addResults(String key, String result) {
					// TODO Auto-generated method stub
				}
				
			};
			return errorResult;
		}
		
		}
		
	}
	
	private IOperationResult variableAssigment(String expresion) {
		 Pattern pattern = Pattern.compile("[ ]+[a-z]+[ ]+", Pattern.CASE_INSENSITIVE); //
	     Matcher matcher = pattern.matcher(expresion);
	     String varName = "";
	     Integer varValue = 0;
	     if (matcher.find()) {
	         varName = matcher.group();
	     }
	     
	     pattern = Pattern.compile("[ ]+[0-9]+[ ]*", Pattern.CASE_INSENSITIVE); //
	     matcher = pattern.matcher(expresion);
	     if (matcher.find()) {
	    	 varValue = Integer.parseInt(matcher.group().trim());
	     }
	     
	     //Agrego la variable
	     myVars.put(varName, varValue);
	     
	     //Using anonymous Inner class
	     IOperationResult assigmentResult = new IOperationResult() {
			
			String key = "";
			String value = "";
			
			@Override
			public void performOperation() {
				System.out.println("Variable: " + key + " asignada con valor " + value);				
			}

			@Override
			public void addResults(String key, String result) {
				this.key = key;
				this.value = result;
			}
				
		};

		assigmentResult.addResults(varName, varValue.toString());
		
	    return assigmentResult;  
	    
	}
	
	private IOperationResult addOperation(String expresion) {
		Pattern pattern = Pattern.compile("([a-z]+|[0-9]+)", Pattern.CASE_INSENSITIVE); //
	    Matcher matcher = pattern.matcher(expresion);
	    Integer total = 0;
	    
	    while (matcher.find()) {
	    	total += Integer.parseInt(matcher.group().trim());
	    }
	    
	    AritmethicOperationResult miResult = new AritmethicOperationResult();
	    miResult.addResults(" suma ", "" + total);
	    return miResult;
	}
	
	private IOperationResult equal(String expresion) {
		Pattern pattern = Pattern.compile("([0-9]+)", Pattern.CASE_INSENSITIVE); //
	    Matcher matcher = pattern.matcher(expresion);
	    Integer firstVar = 0;
	    Integer secondVar = 0;
	    String result = "";
	    
	    int count = 1;
	    while (matcher.find()) {
	    	if(count == 1) {	    		
	    		firstVar = Integer.parseInt(matcher.group().trim());
	    	}else {
	    		secondVar = Integer.parseInt(matcher.group().trim());
	    	}
	    	count ++;
	    }
	    
	    if(firstVar == secondVar) {
	    	result = "T";
	    }else {
	    	result = "NIL";
	    }
	    
	    PredicateOperationResult miResult = new PredicateOperationResult();
	    miResult.addResults(" equal ", "" + result);
	    return miResult;
	}
	
	private IOperationResult greaterThan(String expresion) {
		Pattern pattern = Pattern.compile("([0-9]+)", Pattern.CASE_INSENSITIVE); //
	    Matcher matcher = pattern.matcher(expresion);
	    Integer firstVar = 0;
	    Integer secondVar = 0;
	    String result = "";
	    
	    int count = 1;
	    while (matcher.find()) {
	    	if(count == 1) {	    		
	    		firstVar = Integer.parseInt(matcher.group().trim());
	    	}else {
	    		secondVar = Integer.parseInt(matcher.group().trim());
	    	}
	    	count ++;
	    }
	    
	    if(firstVar > secondVar) {
	    	result = "T";
	    }else {
	    	result = "NIL";
	    }
	    
	    PredicateOperationResult miResult = new PredicateOperationResult();
	    miResult.addResults(" greater than ", "" + result);
	    return miResult;
	}
	
	private IOperationResult smallerThan(String expresion) {
		Pattern pattern = Pattern.compile("([0-9]+)", Pattern.CASE_INSENSITIVE); //
	    Matcher matcher = pattern.matcher(expresion);
	    Integer firstVar = 0;
	    Integer secondVar = 0;
	    String result = "";
	    
	    int count = 1;
	    while (matcher.find()) {
	    	if(count == 1) {	    		
	    		firstVar = Integer.parseInt(matcher.group().trim());
	    	}else {
	    		secondVar = Integer.parseInt(matcher.group().trim());
	    	}
	    	count ++;
	    }
	    
	    if(firstVar < secondVar) {
	    	result = "T";
	    }else {
	    	result = "NIL";
	    }
	    
	    PredicateOperationResult miResult = new PredicateOperationResult();
	    miResult.addResults(" smaller than ", "" + result);
	    return miResult;
	}
	
}
