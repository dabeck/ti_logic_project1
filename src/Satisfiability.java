

public class Satisfiability {

	
	public static void parseTree(Formula x) {
		System.out.print("(");
		if (x instanceof Negation) {
			System.out.print("NOT ");
		}
		
		if (x instanceof Variable) {
			Variable s = (Variable) x;
			System.out.print(s.getVar());
		}
		
		if (x.getLeftArg() != null) {
			parseTree(x.getLeftArg());
		}
		
		if (x instanceof Conjunction) {
			System.out.print(" AND ");
		}
		
		if (x instanceof Disjunction) {
			System.out.print(" OR ");
		}
		
		if (x instanceof Implication) {
			System.out.print(" IMPLIES ");
		}
		
		if (x instanceof Equivalence) {
			System.out.print(" EQUIVALENT ");
		}
		
		if (x.getRightArg() != null) {
			parseTree(x.getRightArg());
		}
		System.out.print(")");
		
	}
}
