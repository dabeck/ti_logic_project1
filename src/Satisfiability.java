import java.util.ArrayList;



public class Satisfiability {
	
	public static boolean check(Formula f) {
		int val = parseTree(f).size();

		String out = "";
		
		for (int i = 0; i < val; ++i) {
			out += "0"; // Build prefix buffer
		}

		for (int i = 0; i < Math.pow(2, val); i++) {
			if (val - Integer.toBinaryString(i).length() > 0) {
				System.out.println(out.substring(1, val
				        - Integer.toBinaryString(i).length() + 1)
				        + Integer.toBinaryString(i));
			} else {
				System.out.println(Integer.toBinaryString(i));
			}
		}
		
		// TODO: evaluate every binary combination

		return false;
	}
	
	public static ArrayList<Variable> parseTree(Formula x) {
		ArrayList<Variable> list = new ArrayList<Variable>();

		if (x instanceof Variable) {
			Variable v = (Variable) x;
			v.setValue(true);
			if (!list.contains(v)) {
				list.add(v);
			}
			return list;
		}
		
		if (x.getLeftArg() != null) {
			for (Variable variable : parseTree(x.getLeftArg())) {
				if (!list.contains(variable)) {
					list.add(variable);
				}
			}
		}
		
		if (x.getRightArg() != null) {
			for (Variable variable : parseTree(x.getRightArg())) {
				if (!list.contains(variable)) {
					list.add(variable);
				}
			}
		}
		
		return list;
	}
	
	public static boolean not(boolean a) {
		return !a;
	}

	public static boolean or(boolean a, boolean b) {
		if (a || b) {
			return true;
		}
		
		return false;
	}

	public static boolean and(boolean a, boolean b) {
		if(a && b) {
			return true;
		}
		
		return false;
	}
	
	public static boolean implies(boolean a, boolean b) {
		if (a && !b) {
			return false;
		}
		
		return true;
	}
	
	public static boolean equals(boolean a, boolean b){
		if (a == b) {
			return true;
		}

		return false;
	}
}
