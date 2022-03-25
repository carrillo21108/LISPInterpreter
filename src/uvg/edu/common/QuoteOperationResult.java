/**
 * 
 */
package uvg.edu.common;

/**
 * @author Brian Carrillo
 *
 */
public class QuoteOperationResult implements IOperationResult {
	
	private String key;
	private String result;

	@Override
	public String performOperation() {
		return "El resultado de la operacion " + key + " es: " + result;
	}

	@Override
	public void addResults(String key, String result) {
		this.key = key;
		this.result = result;
	}
	
	@Override
	public String getKey() {
		return this.key;
	}


	@Override
	public String getResult() {
		return this.result;
	}

}
