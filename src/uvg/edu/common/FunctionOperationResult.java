/**
 * Clase FunctionOperationResult
 * @author Brian Carrillo, Jennifer Toxcon y Carlos Lopez
 * @version 25.03.2022
 *
 * Operciones de ejecucion de funcion
 */
package uvg.edu.common;

/**
 * @author Brian Carrillo
 *
 */
/**
 * 
 * constructor
 *
 */


public class FunctionOperationResult implements IOperationResult {
	/**
	 * Here the FunctionOperationResult class is subclass which implementing IOperationResult interface 
	 */
	//atributos
	private String key;
	private String result;
	/**
	 * Interface methods are implemented
	 */
	@Override
	public String performOperation() {
		return "El resultado de la funcion " + key + " es: " + result;
	}
	
	
	/**
	 * @param key
	 * @param result
	 * @return	
	 */

	@Override
	public void addResults(String key, String result) {
		this.key = key;
		this.result = result;
	}
	//constructor getkey

	@Override
	public String getKey() {
		return this.key;
	}

	//constructor getresult

	@Override
	public String getResult() {
		return this.result;
	}

}
