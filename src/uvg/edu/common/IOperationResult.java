/**
 * Clase IOperationResult
 * @author Brian Carrillo, Jennifer Toxcon y Carlos Lopez
 * @version 25.03.2022
 *
 * Interfaz de operaciones
 */
package uvg.edu.common;

/**
 * @author Brian Carrillo
 *
 */


/**
 * 
 * interface IOpertion
 *
 */
public interface IOperationResult {
	public String performOperation();
	public void addResults(String key, String result);
	public String getKey();
	public String getResult();
}
