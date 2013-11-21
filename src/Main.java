/*
import parser;
import scanner;
import formula;
*/

import java.io.StringReader;

public class Main {

    public static void main(String[] args) {
		try {
			parser p = new parser(new Scanner(new StringReader(
			// "A" // KNF korrekt: A
			// "-A" // KNF korrekt: -A
			// "-(-A)" // KNF korrekt: A
			// "A & B" // KNF korrekt: (A & B)
			// "A | B" // KNF korrekt: (A | B)
					//"-(A & B)"	// KNF korrekt: (-A | -B)
					//"-(A | B)"	// KNF korrekt: (-A & -B)
					//"A -> B"		// KNF korrekt: (-A | B)
			        // "-A & (B | -(C <-> D) | (-B -> A -> -C))"
					//"A <-> B"		// KNF korrekt:  ((A | -B) & (-A | B))
			        "-A & (B | -(C <-> D) | (-B -> A -> -C))"
				)));

			// parse die Formel
			Formula f = (Formula) p.parse().value;
			System.out.println( "Parsed:\t" + f );
			
			// Konvertiere nach KNF
			// ToDo: noch nicht komplett
			Formula g = Convert.toCnf( f );
			// System.out.println( "-> KNF:\t" + g );
			
			if (Satisfiability.check(g)) {
				System.out.println("Die gegebene Formel ist erfüllbar!");
			} else {
				System.out.println("Die gegebene Formel ist NICHT erfüllbar!");
			}
		
		}
		catch (Exception e) {
			System.out.println( "Fehler:\t" + e.toString() );
		}
    }
}
