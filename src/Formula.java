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
	
	public Formula getArg(Character direction)
	{
		switch (TYPES.valueOf(this.getClass().getSimpleName()))
		{
			case Equivalence:
				Equivalence e = (Equivalence)this;
				return (direction == 'L') ? e.getLeftArg(): e.getRightArg();
			case Conjunction:
				Conjunction c = (Conjunction)this;
				return (direction == 'L') ? c.getLeftArg(): c.getRightArg();
			case Disjunction:
				Disjunction d = (Disjunction)this;
				return (direction == 'L') ? d.getLeftArg(): d.getRightArg();
			case Implication:
				Implication i = (Implication)this;
				return (direction == 'L') ? i.getLeftArg(): i.getRightArg();
			case Negation:
				Negation n = (Negation)this;
				return (direction == 'L') ? n.getLeftArg(): n.getLeftArg();
		}
		
		return null;
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