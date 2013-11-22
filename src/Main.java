/*
import parser;
import scanner;
import formula;
*/

import java.io.*;
import java.util.concurrent.TimeUnit;

/**
 * SAT Solver TI Projektaufgabe 1
 * 
 * @author Daniel Becker - 28202534
 * @author Peter Müller - 30201497
 */
public class Main {

    public static void main(String[] args) {
		try {
			parser p;
			if (args.length <= 0 || args[0] == null) {
				System.out.print("Formel: ");
				InputStreamReader converter = new InputStreamReader(System.in);
				BufferedReader in = new BufferedReader(converter);
				p = new parser(new Scanner(new StringReader(in.readLine())));
			} else {
				p = new parser(new Scanner(new StringReader(args[0])));
			}

			// Parse the formula
			Formula f = (Formula) p.parse().value;
			System.out.println( "Parsed:\t" + f );
			System.out.println();
			
			//Formula g = Convert.toCnf(f);
			//System.out.println( "=> KNF:\t" + g );
			
			long startTime = System.nanoTime();

			if (Satisfiability.check(f)) {
				System.out.println("The given formula is satisfiable!");
			} else {
				System.out.println("The given formula is NOT satisfiable!");
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
