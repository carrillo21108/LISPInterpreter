/**
 * 
 */
package uvg.edu.lisp;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import uvg.edu.common.AritmethicOperationResult;
import uvg.edu.common.AssigmentOperationResult;
import uvg.edu.common.ErrorOperationResult;
import uvg.edu.common.IOperationResult;
import uvg.edu.common.PredicateOperationResult;

/**
 * @author Brian Carrillo
 *
 */
public class Interpreter {

	private HashMap<String, Integer> myVars;
	private HashMap<String, String> myFunctions;

	public Interpreter() {
		myVars = new HashMap<String, Integer>();
	}
	
	public IOperationResult Operate(String expresion) {
		int state = SintaxScanner.getState(expresion);
		
		switch(state) {
			case 1:
				return variableAssigment(expresion);
				
			case 2:
				return addOperation(expresion);
			
			case 3:
				return subtractionOperation(expresion);
				
			case 4:
				return multiplicationOperation(expresion);
			
			case 5:
				return divisionOperation(expresion);
			
			case 6:
				return quote(expresion);
			
			case 8:
				return atomOperation(expresion);
			
			case 9:
				return listOperation(expresion);
			
			case 10:
				return equal(expresion);
			
			case 11:
				return smallerThan(expresion);
			
			case 12:
				return greaterThan(expresion);
				
			case 14:
				return combOperationResult(expresion);
			
			default:
				
				ErrorOperationResult errorResult = new ErrorOperationResult();
				errorResult.addResults("EXPRESSION ERROR", "Expresion invalida.");
				return errorResult;
		
		}
	}
	
	public IOperationResult variableAssigment(String expresion) {
		 Pattern pattern = Pattern.compile("[ ]+[a-z]+[ ]+", Pattern.CASE_INSENSITIVE); //
	     Matcher matcher = pattern.matcher(expresion);
	     String varName = "";
	     Integer varValue = 0;
	     if (matcher.find()) {
	         varName = matcher.group().trim();
	     }
	     
	     pattern = Pattern.compile("[ ]+[0-9]+[ ]*", Pattern.CASE_INSENSITIVE); //
	     matcher = pattern.matcher(expresion);
	     if (matcher.find()) {
	    	 varValue = Integer.parseInt(matcher.group().trim());
	     }
	     
	     //Agrego la variable
	     myVars.put(varName, varValue);
	     
	     AssigmentOperationResult miResult = new AssigmentOperationResult();
	     miResult.addResults(varName, varValue.toString());
		 return miResult;
	}
	
	
	/**
	 * Suma
	 * @param expresion
	 * @return
	 */
	public IOperationResult addOperation(String expresion) {
		Pattern pattern = Pattern.compile("([a-z]+|[0-9]+)", Pattern.CASE_INSENSITIVE); //
		Pattern patternNum = Pattern.compile("([0-9]+)", Pattern.CASE_INSENSITIVE); //
		Pattern patternVar = Pattern.compile("([a-z]+)", Pattern.CASE_INSENSITIVE); //
		Matcher matcher = pattern.matcher(expresion);
		
		
	    Integer total = 0;
	    
	    while (matcher.find()) {
	    	Matcher matcherNum = patternNum.matcher(matcher.group().trim());
	    	Matcher matcherVar = patternVar.matcher(matcher.group().trim());
	    	
	    	if(matcherNum.lookingAt()) {
	    		
	    		total += Integer.parseInt(matcher.group().trim());
	    		
	    	}else if(matcherVar.lookingAt()) {
	    		if(myVars.containsKey(matcher.group())){
		    		int valor = myVars.get(matcher.group());
		    		total += valor;
		    	}else {
		    		ErrorOperationResult errorResult = new ErrorOperationResult();
					errorResult.addResults("VARIABLE ERROR", "Variable invalida.");
					return errorResult;
		    	}
	    	}
	    }
	    
	    AritmethicOperationResult miResult = new AritmethicOperationResult();
	    miResult.addResults(" suma ", "" + total);
	    return miResult;
	}
	
	/**
	 * Resta
	 * @param expresion
	 * @return
	 */
	
	public IOperationResult subtractionOperation(String expresion) {
		Pattern pattern = Pattern.compile("([a-z]+|[0-9]+)", Pattern.CASE_INSENSITIVE); //
		Pattern patternNum = Pattern.compile("([0-9]+)", Pattern.CASE_INSENSITIVE); //
		Pattern patternVar = Pattern.compile("([a-z]+)", Pattern.CASE_INSENSITIVE); //
		Matcher matcher = pattern.matcher(expresion);
		
	    Integer total = 0;
	    
	    int count = 0;
	    while (matcher.find()) {
	    	if(count == 0) {
	    		Matcher matcherNum = patternNum.matcher(matcher.group().trim());
		    	Matcher matcherVar = patternVar.matcher(matcher.group().trim());
		    	
		    	if(matcherNum.lookingAt()) {
		    		
		    		total = Integer.parseInt(matcher.group().trim());
		    		
		    	}else if(matcherVar.lookingAt()) {
		    		if(myVars.containsKey(matcher.group())){
			    		int valor = myVars.get(matcher.group());
			    		total = valor;
			    	}else {
			    		ErrorOperationResult errorResult = new ErrorOperationResult();
						errorResult.addResults("VARIABLE ERROR", "Variable invalida.");
						return errorResult;
			    	}
		    	}
	    	}else {	    		
	    		Matcher matcherNum = patternNum.matcher(matcher.group().trim());
		    	Matcher matcherVar = patternVar.matcher(matcher.group().trim());
		    	
		    	if(matcherNum.lookingAt()) {
		    		
		    		total -= Integer.parseInt(matcher.group().trim());
		    		
		    	}else if(matcherVar.lookingAt()) {
		    		if(myVars.containsKey(matcher.group())){
			    		int valor = myVars.get(matcher.group());
			    		total -= valor;
			    	}else {
			    		ErrorOperationResult errorResult = new ErrorOperationResult();
						errorResult.addResults("VARIABLE ERROR", "Variable invalida.");
						return errorResult;
			    	}
		    	}
	    	}
	    	count ++;
	    }
	    
	    AritmethicOperationResult miResult = new AritmethicOperationResult();
	    miResult.addResults(" resta ", "" + total);
	    return miResult;
	}
	/**
	 * Multiplicacion
	 * @param expresion
	 * @return
	 */
	public IOperationResult multiplicationOperation(String expresion) {
		Pattern pattern = Pattern.compile("([a-z]+|[0-9]+)", Pattern.CASE_INSENSITIVE); //
		Pattern patternNum = Pattern.compile("([0-9]+)", Pattern.CASE_INSENSITIVE); //
		Pattern patternVar = Pattern.compile("([a-z]+)", Pattern.CASE_INSENSITIVE); //
		Matcher matcher = pattern.matcher(expresion);
	    Integer total = 1;
	    
	    while (matcher.find()) {
	    	Matcher matcherNum = patternNum.matcher(matcher.group().trim());
	    	Matcher matcherVar = patternVar.matcher(matcher.group().trim());
	    	
	    	if(matcherNum.lookingAt()) {
	    		
	    		total *= Integer.parseInt(matcher.group().trim());
	    		
	    	}else if(matcherVar.lookingAt()) {
	    		if(myVars.containsKey(matcher.group())){
		    		int valor = myVars.get(matcher.group());
		    		total *= valor;
		    	}else {
		    		ErrorOperationResult errorResult = new ErrorOperationResult();
					errorResult.addResults("VARIABLE ERROR", "Variable invalida.");
					return errorResult;
		    	}
	    	}
	    }
	    
	    AritmethicOperationResult miResult = new AritmethicOperationResult();
	    miResult.addResults(" multiplicacion ", "" + total);
	    return miResult;
	}
	

	/**
	 * division
	 * @param expresion
	 * @return
	 */
	public IOperationResult divisionOperation(String expresion) {
		Pattern pattern = Pattern.compile("([a-z]+|[0-9]+)", Pattern.CASE_INSENSITIVE); //
		Pattern patternNum = Pattern.compile("([0-9]+)", Pattern.CASE_INSENSITIVE); //
		Pattern patternVar = Pattern.compile("([a-z]+)", Pattern.CASE_INSENSITIVE); //
		Matcher matcher = pattern.matcher(expresion);
	    Integer total = 1;
	    
	    int count = 0;
	    while (matcher.find()) {
	    	if (count == 0) {
	    		Matcher matcherNum = patternNum.matcher(matcher.group().trim());
		    	Matcher matcherVar = patternVar.matcher(matcher.group().trim());
		    	
		    	if(matcherNum.lookingAt()) {
		    		
		    		total = Integer.parseInt(matcher.group().trim());
		    		
		    	}else if(matcherVar.lookingAt()) {
		    		if(myVars.containsKey(matcher.group())){
			    		int valor = myVars.get(matcher.group());
			    		total = valor;
			    	}else {
			    		ErrorOperationResult errorResult = new ErrorOperationResult();
						errorResult.addResults("VARIABLE ERROR", "Variable invalida.");
						return errorResult;
			    	}
		    	}
	    	}else {	    		
	    		Matcher matcherNum = patternNum.matcher(matcher.group().trim());
		    	Matcher matcherVar = patternVar.matcher(matcher.group().trim());
		    	
		    	if(matcherNum.lookingAt()) {
		    		
		    		total /= Integer.parseInt(matcher.group().trim());
		    		
		    	}else if(matcherVar.lookingAt()) {
		    		if(myVars.containsKey(matcher.group())){
			    		int valor = myVars.get(matcher.group());
			    		total /= valor;
			    	}else {
			    		ErrorOperationResult errorResult = new ErrorOperationResult();
						errorResult.addResults("VARIABLE ERROR", "Variable invalida.");
						return errorResult;
			    	}
		    	}
	    	}
	    	count ++;
	    }
	    
	    AritmethicOperationResult miResult = new AritmethicOperationResult();
	    miResult.addResults(" division ", "" + total);
	    return miResult;
	}
	
	public IOperationResult equal(String expresion) {
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
	
	public IOperationResult greaterThan(String expresion) {
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
	
	public IOperationResult smallerThan(String expresion) {
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
	
	public IOperationResult listOperation(String expresion) {
		Pattern pattern = Pattern.compile("(('[a-z]')+|[0-9]+|(NIL)+|([ ]+T)+)", Pattern.CASE_INSENSITIVE); //
		Matcher matcher = pattern.matcher(expresion);
		String result="(";
		
		int count = 0;
		while(matcher.find()) {
			
			if(count==0) {
				result += String.valueOf(matcher.group().trim());
			}else {
				result += " "+String.valueOf(matcher.group().trim());
			}

			count++;
		}
		
		if(count == 0) {
			result = "NIL";
		}else {
			result += ")";
		}
		
		PredicateOperationResult miResult = new PredicateOperationResult();
		miResult.addResults(" list ", "" + result);
		return miResult;
	}
	
	public IOperationResult atomOperation(String expresion) {
		Pattern patternAtom = Pattern.compile("^[(][ ]*atom[ ]+(((\"[a-z]\")+|[0-9]+|(NIL)+|(T)+|('[0-9]+))[ ]*)[)]$", Pattern.CASE_INSENSITIVE); //
		Pattern patternConsp = Pattern.compile("^[(][ ]*atom[ ]+[']([(]+[ ]*(((\"[a-z]\")+|[0-9]+|(NIL)+|(T)+)[ ]*)+[)])[)]$", Pattern.CASE_INSENSITIVE); //
		Matcher matcherAtom = patternAtom.matcher(expresion);
		Matcher matcherConsp = patternConsp.matcher(expresion);
		String result="";
		
		boolean atom = true;
		
		while(matcherAtom.find()) {
			atom = true;
		}
		
		while(matcherConsp.find()) {
			atom = false;
		}
		
		if(atom)
			result = "T";
		else
			result = "NIL";
		
		PredicateOperationResult miResult = new PredicateOperationResult();
		miResult.addResults(" atom ", "" + result);
		return miResult;
	}

	public IOperationResult quote(String expresion) {
		Pattern pattern = Pattern.compile("(quote |')+", Pattern.CASE_INSENSITIVE); //
	    Matcher matcher = pattern.matcher(expresion);
	    String replace = "";
	    String result = "";
	    
	    if(matcher.find()) {
	    	replace = matcher.group().trim();
	    }
	    
	    result = expresion.replace(replace, "");
	    result = result.substring(1, result.length()-1);
	    
	    PredicateOperationResult miResult = new PredicateOperationResult();
	    miResult.addResults("",result);
	    return miResult;
	}
	
	private int combOperation(String expresion) {
		
		expresion = expresion.substring(1, expresion.length()-1);
		
		Pattern pattern = Pattern.compile("(([0-9]+)+|(([ ][(]).*[)])+|([+]+|[-]+|[*]+|[/]+)+)", Pattern.CASE_INSENSITIVE);
		Pattern patternNum = Pattern.compile("([0-9]+)", Pattern.CASE_INSENSITIVE);
		Pattern patternParentesis = Pattern.compile("(([(]).*[)])", Pattern.CASE_INSENSITIVE);
		Pattern patternOp = Pattern.compile("([+]+|[-]+|[*]+|[/]+)", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(expresion);
		
		int countSubs = 0;
		int countDiv = 0;
		Integer total = 0;
		String operator = null;
		
		while (matcher.find()) {
			
	    	Matcher matcherOp = patternOp.matcher(matcher.group().trim());

	    	if(matcherOp.lookingAt()) {
	    		operator = matcherOp.group();
	    		if(operator.equals("*") || operator.equals("/")) {
	    			total = 1;
	    		}
	    	}else{
	    		
	    		switch (operator) {
	    		
		    		case "+":
		    			Matcher matcherNum = patternNum.matcher(matcher.group().trim());
		    			Matcher matcherParentesis = patternParentesis.matcher(matcher.group().trim());
	
		    	    	if(matcherNum.lookingAt()) {	
		    	    		total += Integer.parseInt(matcher.group().trim());
		    	    	}else if(matcherParentesis.lookingAt()) {
		    	    		total += combOperation(matcherParentesis.group());
		    	    	}
		    			break;
		    			
		    		case "-":
		    			matcherNum = patternNum.matcher(matcher.group().trim());
		    			matcherParentesis = patternParentesis.matcher(matcher.group().trim());
		    			
		    			if(countSubs == 0) {
		    				if(matcherNum.lookingAt()) {
		    		    		total = Integer.parseInt(matcher.group().trim());
		    		    	}else if(matcherParentesis.lookingAt()) {
			    	    		total = combOperation(matcherParentesis.group());
			    	    	}
		    				countSubs ++;
		    			}else {
		    				matcherNum = patternNum.matcher(matcher.group().trim());
		    				matcherParentesis = patternParentesis.matcher(matcher.group().trim());
		    		    	
		    		    	if(matcherNum.lookingAt()) {
		    		    		total -= Integer.parseInt(matcher.group().trim());
		    		    	}else if(matcherParentesis.lookingAt()) {
			    	    		total -= combOperation(matcherParentesis.group());
			    	    	}
		    			}
		    			break;
		    		case "*":
		    			
		    			matcherNum = patternNum.matcher(matcher.group().trim());
		    			matcherParentesis = patternParentesis.matcher(matcher.group().trim());
	
		    	    	if(matcherNum.lookingAt()) {	
		    	    		total *= Integer.parseInt(matcher.group().trim());
		    	    	}else if(matcherParentesis.lookingAt()) {
		    	    		total *= combOperation(matcherParentesis.group());
		    	    	}
		    			break;
		    			
		    		case "/":
		    			
		    			matcherNum = patternNum.matcher(matcher.group().trim());
		    			matcherParentesis = patternParentesis.matcher(matcher.group().trim());
		    			
		    			if(countDiv == 0) {
		    				if(matcherNum.lookingAt()) {
		    		    		total = Integer.parseInt(matcher.group().trim());
		    		    	}else if(matcherParentesis.lookingAt()) {
			    	    		total = combOperation(matcherParentesis.group());
			    	    	}
		    				countDiv ++;
		    			}else {
		    				matcherNum = patternNum.matcher(matcher.group().trim());
		    				matcherParentesis = patternParentesis.matcher(matcher.group().trim());
		    		    	
		    		    	if(matcherNum.lookingAt()) {
		    		    		total /= Integer.parseInt(matcher.group().trim());
		    		    	}else if(matcherParentesis.lookingAt()) {
			    	    		total /= combOperation(matcherParentesis.group());
			    	    	}
		    			}
		    			break;
		    		
		    		}
	    	}
		}
	    return total;
	}
	
	public IOperationResult combOperationResult(String expresion) {
		
		int total = combOperation(expresion);
		
		AritmethicOperationResult miResult = new AritmethicOperationResult();
	    miResult.addResults("",String.valueOf(total));
	    return miResult;	
	}
	
}
