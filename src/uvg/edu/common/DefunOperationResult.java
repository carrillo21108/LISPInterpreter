/**
 * Clase DefunOperationResult
 * @author Brian Carrillo, Jennifer Toxcon y Carlos Lopez
 * @version 25.03.2022
 *
 * Operaciones de definicion de funciones
 */
package uvg.edu.common;

/**
 * @author Brian Carrillo
 *
 */
public class DefunOperationResult implements IOperationResult {
	/**
	 * Here the DefunOperationResult class is subclass which implementing IOperationResult interface 
	 */
	//atributos
	private String key;
	private String result;
	/**
	 * Interface methods are implemented
	 */
	@Override
	public String performOperation() {
		return "Funcion: " + key + " asignada con valor " + result;
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
