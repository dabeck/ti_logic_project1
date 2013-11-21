public class Variable extends Formula {

	private String name;
	private Boolean value;
 
    public Variable(String x) {
    	name = x;
		value = true;
    }
	
	public void setValue(boolean i) {
		value = i;
	}
	
	public Boolean getValue() {
		return value;
	}

	public String getVar() {
		return name;
	}
	
	@Override
	public boolean equals(Object object) {
		boolean sameSame = false;
		
		if (object != null && object instanceof Variable) {
			sameSame = this.name.equals(((Variable) object).name);
		}
		
		return sameSame;
	}
	
	@Override
	public int hashCode() {
		return Integer.valueOf(this.name);
	}

}