
public class Convert {
	public static Formula toCnf(Formula f)
	{
		// A
		if (f instanceof Variable)
		{
			return f;
		}
		
		
		
		if (f instanceof Negation)
		{
			Negation n = (Negation)f;
			
			// -A
			if (getArg(n, true) instanceof Variable)
			{
				return f;
			}
			// -(-A)
			else if (getArg(n, true) instanceof Negation)
			{
				return toCnf( getArg(getArg(n, true), true) );
			}
			// -( & )
			else if (getArg(n, true) instanceof Conjunction)
			{
				return new Disjunction(new Negation(getArg(getArg(n, true), true)), new Negation(getArg(getArg(n, true), false)));
			}
			// -( | )
			else if (getArg(n, true) instanceof Disjunction)
			{
				return new Conjunction(new Negation(getArg(getArg(n, true), true)), new Negation(getArg(getArg(n, true), false)));
			}
			// -(...)
			else
			{
				return toCnf(getArg(n, true));
			}
		}
		
		
		
		Formula cnfLeft = toCnf(getArg(f, true)), cnfRight = toCnf(getArg(f, false));
		
		
		
		//   &
		// ?   ?
		if (f instanceof Conjunction)
			return new Conjunction(cnfLeft, cnfRight);
		
		
		
		if (f instanceof Disjunction)
		{
			//   |
			// |   |
			if (
					(cnfLeft instanceof Negation || cnfLeft instanceof Variable || cnfLeft instanceof Disjunction) &&
					(cnfRight instanceof Negation || cnfRight instanceof Variable || cnfRight instanceof Disjunction)
				)
			{
				return new Disjunction(cnfLeft, cnfRight);
			}
			
			//   |
			// &   |
			else if (
					(cnfLeft instanceof Conjunction) &&
					(cnfRight instanceof Negation || cnfRight instanceof Variable || cnfRight instanceof Disjunction)
				)
			{
				Formula newL = new Disjunction(getArg(cnfLeft, true), cnfRight);
				Formula newR = new Disjunction(getArg(cnfLeft, false), cnfRight);
				
				return new Conjunction(toCnf(newL), toCnf(newR));
			}
			
			//   |
			// |   &
			else if (
					(cnfLeft instanceof Negation || cnfLeft instanceof Variable || cnfLeft instanceof Disjunction) &&
					(cnfRight instanceof Conjunction)
				)
			{
				Formula newL = new Disjunction(cnfLeft, getArg(cnfRight, false));
				Formula newR = new Disjunction(cnfLeft, getArg(cnfRight, true));
				
				return new Conjunction(toCnf(newL), toCnf(newR));
			}
			
			//   |
			// &   &
			else if (
					(cnfLeft instanceof Conjunction) &&
					(cnfRight instanceof Conjunction)
				)
			{
				Formula newL = new Conjunction (
						new Disjunction (getArg(cnfLeft, true), getArg(cnfRight, true)),
						new Disjunction (getArg(cnfLeft, false), getArg(cnfRight, true))
					);
				Formula newR = new Conjunction (
						new Disjunction (getArg(cnfLeft, true), getArg(cnfRight, true)),
						new Disjunction (getArg(cnfLeft, false), getArg(cnfRight, true))
					);
				
				return new Conjunction(toCnf(newL), toCnf(newR));
			}
		}
		
		
		
		if (f instanceof Equivalence)
		{
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
		}
		
		
		
		if (f instanceof Implication)
		{
			Implication i = (Implication)f;
			return toCnf(
						new Disjunction(
								new Negation(i.getLeftArg()),
								i.getRightArg()
							)
					);
		}
		
		
		
		System.out.println("Convert.toCnf(): ERROR");
		return null;
	}
	
	private static Formula getArg(Formula f, boolean wantLeft)
	{
		switch (TYPES.valueOf(f.getClass().getSimpleName()))
		{
			case Equivalence:
				Equivalence e = (Equivalence)f;
				return (wantLeft) ? e.getLeftArg(): e.getRightArg();
			case Conjunction:
				Conjunction c = (Conjunction)f;
				return (wantLeft) ? c.getLeftArg(): c.getRightArg();
			case Disjunction:
				Disjunction d = (Disjunction)f;
				return (wantLeft) ? d.getLeftArg(): d.getRightArg();
			case Implication:
				Implication i = (Implication)f;
				return (wantLeft) ? i.getLeftArg(): i.getRightArg();
			case Negation:
				Negation n = (Negation)f;
				return (wantLeft) ? n.getLeftArg(): n.getLeftArg();
		}
		
		return null;
	}
}
