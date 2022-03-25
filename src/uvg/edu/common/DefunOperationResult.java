/**
 * 
 */
package uvg.edu.common;

/**
 * @author Brian Carrillo
 *
 */
public class DefunOperationResult implements IOperationResult {
	
	private String key;
	private String result;
	
	@Override
	public String performOperation() {
		return "Funcion: " + key + " asignada con valor " + result;
	}

	@Override
	public void addResults(String key, String result) {
		this.key = key;
		this.result = result;
	}

}
