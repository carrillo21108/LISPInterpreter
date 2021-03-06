/**
 * Clase ErrorOperationResult
 * @author Brian Carrillo, Jennifer Toxcon y Carlos Lopez
 * @version 25.03.2022
 *
 * Errores de operaciones
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
public class ErrorOperationResult implements IOperationResult {
	/**
	 * Here the ErrorOperationResult class is subclass which implementing IOperationResult interface 
	 */
	//atributos
	private String key;
	private String result;
	/**
	 * Interface methods are implemented
	 */
	@Override
	public String performOperation() {
		return key+": "+result;
		
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
