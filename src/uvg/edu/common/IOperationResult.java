/**
 * 
 */
package uvg.edu.common;

/**
 * @author Brian Carrillo
 *
 */
public interface IOperationResult {
	public String performOperation();
	public void addResults(String key, String result);
	public String getKey();
	public String getResult();
}
