
public class Convert {
	public static Formula toCnf(Formula f) {
		switch (TYPES.valueOf(f.getClass().getSimpleName())) {
			case Equivalence:
				Equivalence e = (Equivalence)f;
				return toCnf(
							new Disjunction(
										new Conjunction(e.getLeftArg(), e.getRightArg()),
										new Conjunction(
													new Negation(e.getLeftArg()),
													new Negation(e.getRightArg())
												)
									)
						);
			case Conjunction:
				Conjunction c = (Conjunction)f;
				return new Conjunction(
						toCnf(c.getLeftArg()),
						toCnf(c.getRightArg())
						);
			case Disjunction:
				Disjunction d = (Disjunction)f;
				return new Disjunction(
						toCnf(d.getLeftArg()),
						toCnf(d.getRightArg())
					);
			case Implication:
				Implication i = (Implication)f;
				return toCnf(
							new Disjunction(
									new Negation(i.getLeftArg()),
									i.getRightArg()
								)
						);
			case Negation:
				Negation n = (Negation)f;
				if ( n.getLeftArg() instanceof Variable ) {
					return f;
				} else if ( n.getLeftArg() instanceof Negation ) {
					return toCnf( ((Negation)n.getLeftArg()).getLeftArg() );
				} else if ( n.getLeftArg() instanceof Conjunction ) {
					return toCnf(
								new Disjunction(
											new Negation(n.getLeftArg()),
											new Negation(n.getRightArg())
										)
							);
				} else if ( n.getLeftArg() instanceof Disjunction ) {
					return toCnf(
							new Conjunction(
										new Negation(n.getLeftArg()),
										new Negation(n.getRightArg())
									)
						);
				} 
				break;
			case Variable:
				return f;
		}
		
		return null;
	}
}
