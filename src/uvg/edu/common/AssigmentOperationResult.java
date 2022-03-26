/**
 * Clase AssigmentOperationResult
 * @author Brian Carrillo, Jennifer Toxcon y Carlos Lopez
 * @version 25.03.2022
 *
 * Operaciones de asignacion
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
public class AssigmentOperationResult implements IOperationResult {
/**
 * Here the AssigmentOperationResult class is subclass which implementing IOperationResult interface 
 */
	//atributos
	private String key;
	private String result;
	
	/**
	 * Interface methods are implemented
	 */
	@Override
	public String performOperation() {
		return "Variable: " + key + " asignada con valor " + result;

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
