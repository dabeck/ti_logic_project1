import java.util.ArrayList;



public class Satisfiability {
	
	/**
	 * Evaluates every logical combination for the given formula
	 * 
	 * @param f
	 *            formula to check
	 * @return true if the given formula is satisfiable
	 */
	public static boolean check(Formula f) {
		int val = parseTree(f).size();

		for (int i = 0; i < Math.pow(2, val); i++) {
			for (int j = 0; j < val; j++) {
				if ((i & (int) Math.pow(2, j)) > 0) {
					parseTree(f).get(j).setValue(true);
				} else {
					parseTree(f).get(j).setValue(false);
				}
			}
			if (evaluate(f)) {
				for (Variable v : parseTree(f)) {
					System.out.print((v.getValue()) ? 1 : 0);
					System.out.print(" ");
				}
				System.out.println();

				return true;
			}
		}

		return false;
	}

	/**
	 * checks whether a given formula is satisfiable or not (be sure to
	 * set the variable values through the v.setValue() method and loop
	 * over evaluate
	 * 
	 * @param f
	 *            formula to evaluate
	 * @return true if the given formula is satisfiable
	 */
	private static boolean evaluate(Formula f) {
		
		if (f instanceof Negation) {
			return not(evaluate(f.getLeftArg()));
		}

		if (f instanceof Variable) {
			Variable v = (Variable) f;
			return v.getValue();
		}
		
		if (f instanceof Conjunction) {
			return and(evaluate(f.getLeftArg()), evaluate(f.getRightArg()));
		}
		
		if (f instanceof Disjunction) {
			return or(evaluate(f.getLeftArg()), evaluate(f.getRightArg()));
		}

		if (f instanceof Implication) {
			return implies(evaluate(f.getLeftArg()), evaluate(f.getRightArg()));
		}

		if (f instanceof Equivalence) {
			return equals(evaluate(f.getLeftArg()), evaluate(f.getRightArg()));
		}

		if (f.getLeftArg() != null) {
			evaluate(f.getLeftArg());
		}

		if (f.getRightArg() != null) {
			evaluate(f.getRightArg());
		}
		
		return false;
	}

	private static ArrayList<Variable> parseTree(Formula x) {
		ArrayList<Variable> list = new ArrayList<Variable>();

		if (x instanceof Variable) {
			Variable v = (Variable) x;
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
	
	private static boolean not(boolean a) {
		return !a;
	}

	private static boolean or(boolean a, boolean b) {
		if (a || b) {
			return true;
		}
		
		return false;
	}

	private static boolean and(boolean a, boolean b) {
		if(a && b) {
			return true;
		}
		
		return false;
	}
	
	private static boolean implies(boolean a, boolean b) {
		if (a && !b) {
			return false;
		}
		
		return true;
	}
	
	private static boolean equals(boolean a, boolean b) {
		if (a == b) {
			return true;
		}

		return false;
	}
}
