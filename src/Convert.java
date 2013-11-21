
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
			// -A
			if (f.getArg('L') instanceof Variable)
			{
				return f;
			}
			// -(-A)
			else if (f.getArg('L') instanceof Negation)
			{
				return toCnf( f.getArg('L').getArg('L') );
			}
			// -( & )
			else if (f.getArg('L') instanceof Conjunction)
			{
				return new Disjunction(new Negation(f.getArg('L').getArg('L')), new Negation(f.getArg('L').getArg('R')));
			}
			// -( | )
			else if (f.getArg('L') instanceof Disjunction)
			{
				return new Conjunction(new Negation(f.getArg('L').getArg('L')), new Negation(f.getArg('L').getArg('R')));
			}
			// -(...)
			else
			{
				return toCnf(f.getArg('L'));
			}
		}
		
		
		
		Formula cnfLeft = toCnf(f.getArg('L')), cnfRight = toCnf(f.getArg('R'));
		
		
		
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
				Formula newL = new Disjunction(cnfLeft.getArg('L'), cnfRight);
				Formula newR = new Disjunction(cnfLeft.getArg('R'), cnfRight);
				
				return new Conjunction(toCnf(newL), toCnf(newR));
			}
			
			//   |
			// |   &
			else if (
					(cnfLeft instanceof Negation || cnfLeft instanceof Variable || cnfLeft instanceof Disjunction) &&
					(cnfRight instanceof Conjunction)
				)
			{
				Formula newL = new Disjunction(cnfLeft, cnfRight.getArg('R'));
				Formula newR = new Disjunction(cnfLeft, cnfRight.getArg('L'));
				
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
						new Disjunction (cnfLeft.getArg('L'), cnfRight.getArg('L')),
						new Disjunction (cnfLeft.getArg('R'), cnfRight.getArg('L'))
					);
				Formula newR = new Conjunction (
						new Disjunction (cnfLeft.getArg('L'), cnfRight.getArg('L')),
						new Disjunction (cnfLeft.getArg('R'), cnfRight.getArg('L'))
					);
				
				return new Conjunction(toCnf(newL), toCnf(newR));
			}
		}
		
		
		
		if (f instanceof Equivalence)
		{
			Formula newL = new Disjunction (f.getArg('L'), new Negation(f.getArg('R')));
			Formula newR = new Disjunction (new Negation(f.getArg('L')), f.getArg('R'));
			
			return toCnf(new Conjunction(
					new Disjunction (f.getArg('L'), new Negation(f.getArg('R'))),
					new Disjunction (new Negation(f.getArg('L')), f.getArg('R'))
					));
		}
		
		
		
		if (f instanceof Implication)
		{
			return toCnf(
						new Disjunction(
								new Negation(f.getArg('L')),
								f.getArg('R')
							)
					);
		}
		
		
		System.out.println("Convert.toCnf(): ERROR");
		return null;
	}
}
