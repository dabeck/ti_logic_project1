/*
import parser;
import scanner;
import formula;
*/

import java.io.StringReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
		try {
			parser p = new parser(new Scanner(new StringReader(
			        "-A & (B | -(C <-> D) | (-B -> A -> -C))")));

			// parse die Formel
			Formula f = (Formula) p.parse().value;
			System.out.println( "Parsed:\t" + f );
			
			// Konvertiere nach KNF
			// ToDo: noch nicht komplett
			/*f = Convert.toCnf( f );
			System.out.println( "-> KNF:\t" + f );*/
			
			ArrayList<Formula> forms = new ArrayList<Formula>();

			parseTree(f);
		
		}
		catch (Exception e) {
			System.out.println( "Fehler:\t" + e.toString() );
		}
    }
	
	public static void parseTree(Formula x) {
		System.out.print("(");
		if (x instanceof Negation) {
			System.out.print("NOT ");
		}

		if(x instanceof Variable){
			Variable s = (Variable)x;
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
