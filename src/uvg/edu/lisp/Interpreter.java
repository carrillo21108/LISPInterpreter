/**
 * 
 */
package uvg.edu.lisp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import uvg.edu.common.AritmethicOperationResult;
import uvg.edu.common.AssigmentOperationResult;
import uvg.edu.common.CondOperationResult;
import uvg.edu.common.DefunOperationResult;
import uvg.edu.common.ErrorOperationResult;
import uvg.edu.common.FunctionOperationResult;
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
		myFunctions = new HashMap<String, String>();
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
				
			case 7:
				return defunOperationResult(expresion);
			
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
			
			case 13:
				return condOperation(expresion);
				
			case 14:
				return combOperationResult(expresion);
				
			case 15:
				return functionOperationResult(expresion);
			
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
	
	private String combOperation(String expresion) {
		
		expresion = expresion.substring(1, expresion.length()-1);
		
		Pattern pattern = Pattern.compile("(([a-z,0-9]+)+|(([ ][(]).*[)])+|([+]+|[-]+|[*]+|[/]+)+)", Pattern.CASE_INSENSITIVE);
		Pattern patternNum = Pattern.compile("([0-9]+)", Pattern.CASE_INSENSITIVE);
		Pattern patternVar = Pattern.compile("([a-z]+)", Pattern.CASE_INSENSITIVE); //
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
		    			Matcher matcherVar = patternVar.matcher(matcher.group().trim());
	
		    	    	if(matcherNum.lookingAt()) {	
		    	    		total += Integer.parseInt(matcher.group().trim());
		    	    	}else if(matcherVar.lookingAt()){
		    	    		if(myVars.containsKey(matcher.group())){
		    		    		int valor = myVars.get(matcher.group());
		    		    		total += valor;
		    		    	}else {
		    		    		return "ERROR";
		    		    	}
		    	    	}else if(matcherParentesis.lookingAt()) {
		    	    		try {
		    	    			total += Integer.parseInt(combOperation(matcherParentesis.group()));
		    	    		}catch(Exception e) {
		    	    			return "ERROR";
		    	    		}
		    	    	}
		    			break;
		    			
		    		case "-":
		    			
		    			matcherNum = patternNum.matcher(matcher.group().trim());
		    			matcherParentesis = patternParentesis.matcher(matcher.group().trim());
		    			matcherVar = patternVar.matcher(matcher.group().trim());
		    			
		    			if(countSubs == 0) {
		    				if(matcherNum.lookingAt()) {
		    		    		total = Integer.parseInt(matcher.group().trim());
		    		    	}else if(matcherVar.lookingAt()){
			    	    		if(myVars.containsKey(matcher.group())){
			    		    		int valor = myVars.get(matcher.group());
			    		    		total = valor;
			    		    	}else {
			    					return "ERROR";
			    		    	}
			    	    	}else if(matcherParentesis.lookingAt()) {
			    	    		try {
			    	    			total = Integer.parseInt(combOperation(matcherParentesis.group()));
			    	    		}catch(Exception e) {
			    	    			return "ERROR";
			    	    		}
			    	    	}
		    				countSubs ++;
		    				
		    			}else {
		    				matcherNum = patternNum.matcher(matcher.group().trim());
		    				matcherParentesis = patternParentesis.matcher(matcher.group().trim());
		    				matcherVar = patternVar.matcher(matcher.group().trim());
		    		    	
		    		    	if(matcherNum.lookingAt()) {
		    		    		total -= Integer.parseInt(matcher.group().trim());
		    		    	}else if(matcherVar.lookingAt()){
			    	    		if(myVars.containsKey(matcher.group())){
			    		    		int valor = myVars.get(matcher.group());
			    		    		total -= valor;
			    		    	}else {
			    					return "ERROR";
			    		    	}
			    	    	}else if(matcherParentesis.lookingAt()) {
			    	    		try {
			    	    			total -= Integer.parseInt(combOperation(matcherParentesis.group()));
			    	    		}catch(Exception e) {
			    	    			return "ERROR";
			    	    		}
			    	    	}
		    			}
		    			break;
		    		case "*":
		    			
		    			matcherNum = patternNum.matcher(matcher.group().trim());
		    			matcherParentesis = patternParentesis.matcher(matcher.group().trim());
		    			matcherVar = patternVar.matcher(matcher.group().trim());
	
		    	    	if(matcherNum.lookingAt()) {	
		    	    		total *= Integer.parseInt(matcher.group().trim());
		    	    	}else if(matcherVar.lookingAt()){
		    	    		if(myVars.containsKey(matcher.group())){
		    		    		int valor = myVars.get(matcher.group());
		    		    		total *= valor;
		    		    	}else {
		    					return "ERROR";
		    		    	}
		    	    	}else if(matcherParentesis.lookingAt()) {
		    	    		try {
		    	    			total *= Integer.parseInt(combOperation(matcherParentesis.group()));
		    	    		}catch(Exception e) {
		    	    			return "ERROR";
		    	    		}
		    	    	}
		    			break;
		    			
		    		case "/":
		    			
		    			matcherNum = patternNum.matcher(matcher.group().trim());
		    			matcherParentesis = patternParentesis.matcher(matcher.group().trim());
		    			matcherVar = patternVar.matcher(matcher.group().trim());
		    			
		    			if(countDiv == 0) {
		    				if(matcherNum.lookingAt()) {
		    		    		total = Integer.parseInt(matcher.group().trim());
		    		    	}else if(matcherVar.lookingAt()){
			    	    		if(myVars.containsKey(matcher.group())){
			    		    		int valor = myVars.get(matcher.group());
			    		    		total = valor;
			    		    	}else {
			    					return "ERROR";
			    		    	}
			    	    	}else if(matcherParentesis.lookingAt()) {
			    	    		try {
			    	    			total = Integer.parseInt(combOperation(matcherParentesis.group()));
			    	    		}catch(Exception e) {
			    	    			return "ERROR";
			    	    		}
			    	    	}
		    				countDiv ++;
		    			}else {
		    				matcherNum = patternNum.matcher(matcher.group().trim());
		    				matcherParentesis = patternParentesis.matcher(matcher.group().trim());
		    				matcherVar = patternVar.matcher(matcher.group().trim());
		    		    	
		    		    	if(matcherNum.lookingAt()) {
		    		    		total /= Integer.parseInt(matcher.group().trim());
		    		    	}else if(matcherVar.lookingAt()){
			    	    		if(myVars.containsKey(matcher.group())){
			    		    		int valor = myVars.get(matcher.group());
			    		    		total /= valor;
			    		    	}else {
			    					return "ERROR";
			    		    	}
			    	    	}else if(matcherParentesis.lookingAt()) {
			    	    		try {
			    	    			total /= Integer.parseInt(combOperation(matcherParentesis.group()));
			    	    		}catch(Exception e) {
			    	    			return "ERROR";
			    	    		}
			    	    	}
		    			}
		    			break;
		    		
		    		}
	    	}
		}
	    return String.valueOf(total);
	}
	
	public IOperationResult combOperationResult(String expresion) {
		
		String total = combOperation(expresion);
		
		if(total.equals("ERROR")) {
			ErrorOperationResult errorResult = new ErrorOperationResult();
			errorResult.addResults("VARIABLE ERROR", "Variable invalida.");
			return errorResult;
		}else {			
			AritmethicOperationResult miResult = new AritmethicOperationResult();
			miResult.addResults("", total);
			return miResult;	
		}
		
	}
	
	public IOperationResult defunOperationResult(String expresion) {
		 Pattern pattern = Pattern.compile("(defun[ ]+([a-z]|[a-z,0-9])+)", Pattern.CASE_INSENSITIVE); //
	     Matcher matcher = pattern.matcher(expresion);
	     String funcName = "";
	     String funcValue = "";
	     

	     if (matcher.find()) {
 	    	funcName = matcher.group().replaceFirst("defun", " ").trim();
	     }
	     
	     Pattern patternValue = Pattern.compile("([(]([a-z,0-9][ ]*)+[)][ ]*([(][ ]*([+]+|[-]+|[*]+|[/]+)[ ]+(([a-z]+[ ]([(].*[)])+)|([0-9]+[ ]([(].*[)])+)|([(].*[)])+|(([(].*[)])+[ ][0-9]+)|(([(].*[)])+[ ][a-z]+)|([a-z]+|[0-9]+)[ ]+(([a-z]+|[0-9]+)[ ]*))[ ]*[)]))", Pattern.CASE_INSENSITIVE); //
	     matcher = patternValue.matcher(expresion.substring(0, expresion.length()-1));
	     if (matcher.find()) {
	    	 funcValue = matcher.group();
	     }
	     
	     //Agrego la funcion
	     myFunctions.put(funcName, funcValue);
	     
	     DefunOperationResult miResult = new DefunOperationResult();
	     miResult.addResults(funcName, funcValue);
		 return miResult;
	}
	
	public IOperationResult functionOperationResult(String expresion) {
		Pattern pattern = Pattern.compile("(([a-z]+[ ]*|[0-9]+[ ]*))", Pattern.CASE_INSENSITIVE); //
		Matcher matcher = pattern.matcher(expresion);
	    String funcName = "";
	    String total = "";
	    ArrayList<String>myParameters = new ArrayList<String>();
	    ArrayList<String>myArguments = new ArrayList<String>();
	    
	    int count = 0;
	    while(matcher.find()) {
	    	if(count==0) {
	    		funcName = matcher.group().trim();
	    	}else {
	    		myParameters.add(matcher.group().trim());
	    	}
	    	
	    	count++;
	    }
	    
	    if(myFunctions.containsKey(funcName)){
	    	String funcExpresion = myFunctions.get(funcName);
	    	Pattern patternArguments = Pattern.compile("([(]([a-z][ ]*)+[)])");
	    	Matcher matcherArguments = patternArguments.matcher(funcExpresion);
	    	
	    	if(matcherArguments.find()) {
	    		Pattern patternArgument = Pattern.compile("(([a-z])+)");
	    		Matcher matcherArgument = patternArgument.matcher(matcherArguments.group());
	    		
	    		while(matcherArgument.find()) {
	    			myArguments.add(matcherArgument.group().trim());
	    		}
	    	}
	    	
	    	if(myParameters.size()!=myArguments.size()) {
	    		ErrorOperationResult errorResult = new ErrorOperationResult();
				errorResult.addResults("PAREMETERS ERROR", "Cantidad de Parametros invalida para la funcion.");
				return errorResult;
	    	}else {
	    		for(int i=0; i<myArguments.size(); i++) {
	    			myVars.put(myArguments.get(i), Integer.parseInt(myParameters.get(i)));
	    		}
	    	}
	    	
	    	Pattern patternBody = Pattern.compile("([(][ ]*([+]+|[-]+|[*]+|[/]+)[ ]+([a-z]+|[0-9]+)[ ]+(([a-z]+|[0-9]+)[ ]*)*[)])|([(][ ]*([+]+|[-]+|[*]+|[/]+)[ ]+(([a-z]+[ ]([(].*[)])+)|([0-9]+[ ]([(].*[)])+)|([(].*[)])+|(([(].*[)])+[ ][0-9]+)|(([(].*[)])+[ ][a-z]+))[ ]*[)])");
	    	Matcher matcherBody = patternBody.matcher(funcExpresion);
	    	
	    	if(matcherBody.find()) {
	    		System.out.println(matcherBody.group());
	    		total = functionOperation(matcherBody.group());
	    	}
	    	
    	}else {
    		ErrorOperationResult errorResult = new ErrorOperationResult();
			errorResult.addResults("FUNCTION ERROR", "Funcion invalida.");
			return errorResult;
    	}
	    
		
	    FunctionOperationResult miResult = new FunctionOperationResult();
	    miResult.addResults("", total);
	    return miResult;	
	}
	
	private String functionOperation(String expresion) {
		return combOperation(expresion);
	}
	
	public IOperationResult condOperation(String expresion) {
		
		String total="";
		
		expresion = expresion.substring(6, expresion.length()-1);
			
		Pattern pattern = Pattern.compile("[(][(]([=]+|[<]+|[>]+)[ ]([a-z]+|[0-9]+)+[ ]([a-z]+|[0-9]+)+[)][ ][(]([a-z]+|[0-9]+|[ ]+|[(]+|[)]+|[+]+|[-]+|[*]+|[*]+)+[)][)]", Pattern.CASE_INSENSITIVE);
		Pattern patternNum = Pattern.compile("([0-9]+)", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(expresion);
		
		boolean resultCond = false;
		
		
		while (matcher.find()) {
			
			Pattern patternCond = Pattern.compile("[(]([=]+|[<]+|[>]+)[ ]([a-z]+|[0-9]+)+[ ]([a-z]+|[0-9]+)+[)]", Pattern.CASE_INSENSITIVE);
			Pattern patternCont = Pattern.compile("([(][ ]*([+]+|[-]+|[*]+|[/]+)[ ]+([a-z]+|[0-9]+)[ ]+(([a-z]+|[0-9]+)[ ]*)*[)])|([(][ ]*([+]+|[-]+|[*]+|[/]+)[ ]+(([a-z]+[ ]([(].*[)])+)|([0-9]+[ ]([(].*[)])+)|([(].*[)])+|(([(].*[)])+[ ][0-9]+)|(([(].*[)])+[ ][a-z]+))[ ]*[)])", Pattern.CASE_INSENSITIVE);
			Matcher matcherCond = patternCond.matcher(matcher.group().trim());
			Matcher matcherCont = patternCont.matcher(matcher.group().trim());
			
			while(matcherCond.find()) {				
				
				if(matcherCont.find()) {
					
					Matcher matcherNum = patternNum.matcher(matcherCont.group().trim());
					
					char operator = matcherCond.group().trim().charAt(1);
					
					int count = 1;
					int operand1 = 0, operand2 = 0;
					
				    while (matcherNum.find()) {
				    	if(count == 1) {	    		
				    		operand1 = Integer.parseInt(matcherNum.group().trim());
				    	}else {
				    		operand2 = Integer.parseInt(matcherNum.group().trim());
				    	}
				    	count ++;
				    }
					
					switch(operator) {
						case '=':
							resultCond = (operand1 == operand2);
							break;
						
						case '<':
							resultCond = (operand1 < operand2);
							break;
							
						case '>':
							resultCond = (operand1 > operand2);
							break;
							
					}
					
					if(resultCond) {
						total = combOperation(matcherCont.group());
					}
				}
				
			}
			
		}
			
			
		CondOperationResult miResult = new CondOperationResult();
		miResult.addResults("",total);
		return miResult;
	
	}
	
}
