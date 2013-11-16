/*
import parser;
import scanner;
import formula;
*/

import java.io.StringReader;

public class Main {

    public static void main(String[] args) {
		try {
			parser p = new parser(new Scanner(new StringReader("-A & B")));
		    //parser p = new parser(new Scanner(new StringReader("-A & (B | -(C <-> HalloWelt) | (-B -> A -> -C))")));
		    Formula f = (Formula) p.parse().value;
		    System.out.println("TEST: " + p.parse().value.toString());
		}
		catch (Exception e) {
		}
    }
}
