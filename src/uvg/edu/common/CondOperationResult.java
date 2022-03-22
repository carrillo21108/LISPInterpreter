/**
 * 
 */
package uvg.edu.common;

/**
 * @author Brian Carrillo
 *
 */
public class CondOperationResult implements IOperationResult {
	
	private String key;
	private String result;
	
	@Override
	public void performOperation() {
		System.out.println("El resultado de la operacion " + key + " es: " + result);

	}

	@Override
	public void addResults(String key, String result) {
		this.key = key;
		this.result = result;
	}

}
