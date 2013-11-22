/*
import parser;
import scanner;
import formula;
*/

import java.io.StringReader;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
		try {
			parser p = new parser(new Scanner(new StringReader(
			// "A" // KNF korrekt: A
			// "-A" // KNF korrekt: -A
			// "-(-A)" // KNF korrekt: A
			// "A & B" // KNF korrekt: (A & B)
			// "A | B" // KNF korrekt: (A | B)
			                // "-(A & B)" // KNF korrekt: (-A | -B)
			// "-(A | B)" // KNF korrekt: (-A & -B)
			                        // "A -> B" // KNF korrekt: (-A | B)
			                        // "-A & (B | -(C <-> D) | (-B -> A -> -C))"
			                        // "A <-> B" // KNF korrekt: ((A |
									// -B) & (-A | B))
			                        // "(-A & B) & -(C <-> D) | (-B -> A -> -C)"
			                        "((((((((((X0<->X1)<->X2)<->X3)<->X4)<->X5)<->X6)<->X7)<->X8)<->X9)<->X10)&(X10<->X8)&(X9<->X7)&(X8<->X6)&(X7<->X5)&(X6<->X4)&(X5<->X3)&(X4<->X2)&(X3<->X1)&(X2<->X0)&-(X1<->X0)")));

			// parse die Formel
			Formula f = (Formula) p.parse().value;
			System.out.println( "Parsed:\t" + f );
			System.out.println();
			
			// Konvertiere nach KNF
			// ToDo: noch nicht komplett
			// Formula g = Convert.toCnf( f );
			// System.out.println( "-> KNF:\t" + g );
			
			long startTime = System.nanoTime();

			if (Satisfiability.check(f)) {
				System.out.println("Die gegebene Formel ist erfüllbar!");
			} else {
				System.out.println("Die gegebene Formel ist NICHT erfüllbar!");
			}

			long estimatedTime = System.nanoTime() - startTime;

			System.out.println("\n\nCalculation time: "
			        + TimeUnit.MILLISECONDS.convert(estimatedTime,
			                TimeUnit.NANOSECONDS) + "ms");
		
		}
		catch (Exception e) {
			System.out.println( "Fehler:\t" + e.toString() );
		}
    }
}
