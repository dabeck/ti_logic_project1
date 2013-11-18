public class Variable extends Formula {

	private String name;
	private Boolean value;
 
    public Variable(String x) {
    	name = x;
		value = true;
    }
	
	public void setValue(Boolean val) {
		value = val;
	}
	
	public Boolean getValue() {
		return value;
	}

	public String getVar() {
		return name;
	}
}