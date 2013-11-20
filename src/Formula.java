public abstract class Formula {

	public Formula getLeftArg() {
		return null;
	}
	
	public Formula getRightArg() {
		return null;
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		
		switch (TYPES.valueOf(this.getClass().getSimpleName())) {
			case Equivalence:
				Equivalence e = (Equivalence)this;
				result.append(e.getLeftArg().toString() + " <-> " + e.getRightArg().toString());
				break;
			case Conjunction:
				Conjunction c = (Conjunction)this;
				result.append("(" + c.getLeftArg().toString() + " & " + c.getRightArg().toString() + ")");
				break;
			case Disjunction:
				Disjunction d = (Disjunction)this;
				result.append("(" + d.getLeftArg().toString() + " | " + d.getRightArg().toString() + ")");
				break;
			case Implication:
				Implication i = (Implication)this;
				result.append(i.getLeftArg().toString() + " -> " + i.getRightArg().toString());
				break;
			case Negation:
				Negation n = (Negation)this;
				result.append("-" + n.getLeftArg().toString());
				break;
			case Variable:
				Variable v = (Variable)this;
				result.append(v.getVar());
				break;
		}
		
		return result.toString();
	}
}

enum TYPES {
	Equivalence,
	Conjunction,
	Disjunction,
	Implication,
	Negation,
	Variable
}