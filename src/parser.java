
//----------------------------------------------------
// The following code was generated by CUP v0.11a beta 20060608
// Sat Nov 16 18:36:27 CET 2013
//----------------------------------------------------

import java.util.HashMap;
import java.util.Map;

import java_cup.runtime.*;

/** CUP v0.11a beta 20060608 generated parser.
  * @version Sat Nov 16 18:36:27 CET 2013
  */
public class parser extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public parser() {super();}

  /** Constructor which sets the default scanner. */
  public parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\010\000\002\002\003\000\002\002\004\000\002\002" +
    "\005\000\002\002\004\000\002\002\005\000\002\002\005" +
    "\000\002\002\005\000\002\002\005" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\021\000\010\006\004\011\005\013\006\001\002\000" +
    "\010\006\004\011\005\013\006\001\002\000\010\006\004" +
    "\011\005\013\006\001\002\000\016\002\001\004\001\005" +
    "\001\007\001\010\001\012\001\001\002\000\014\002\013" +
    "\004\012\005\014\007\010\010\011\001\002\000\010\006" +
    "\004\011\005\013\006\001\002\000\010\006\004\011\005" +
    "\013\006\001\002\000\010\006\004\011\005\013\006\001" +
    "\002\000\004\002\000\001\002\000\010\006\004\011\005" +
    "\013\006\001\002\000\016\002\ufffc\004\ufffc\005\ufffc\007" +
    "\ufffc\010\ufffc\012\ufffc\001\002\000\016\002\ufffd\004\ufffd" +
    "\005\014\007\ufffd\010\ufffd\012\ufffd\001\002\000\014\002" +
    "\ufffa\004\012\005\014\007\010\012\ufffa\001\002\000\016" +
    "\002\ufffb\004\012\005\014\007\010\010\ufffb\012\ufffb\001" +
    "\002\000\014\004\012\005\014\007\010\010\011\012\022" +
    "\001\002\000\016\002\uffff\004\uffff\005\uffff\007\uffff\010" +
    "\uffff\012\uffff\001\002\000\016\002\ufffe\004\ufffe\005\ufffe" +
    "\007\ufffe\010\ufffe\012\ufffe\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\021\000\004\002\006\001\001\000\004\002\022\001" +
    "\001\000\004\002\020\001\001\000\002\001\001\000\002" +
    "\001\001\000\004\002\017\001\001\000\004\002\016\001" +
    "\001\000\004\002\015\001\001\000\002\001\001\000\004" +
    "\002\014\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 1;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}

}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$parser$actions {
  private final parser parser;

  /** Constructor */
  CUP$parser$actions(parser parser) {
    this.parser = parser;
  }

  /** Method with the actual generated action code. */
  public final java_cup.runtime.Symbol CUP$parser$do_action(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$parser$result;

      /* select the action based on the action number */
      switch (CUP$parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // formula ::= formula BIIMP formula 
            {
              Formula RESULT =null;
		int fleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int fright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Formula f = (Formula)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int gleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int gright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Formula g = (Formula)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Equivalence(f,g); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("formula",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // formula ::= formula IMP formula 
            {
              Formula RESULT =null;
		int fleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int fright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Formula f = (Formula)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int gleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int gright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Formula g = (Formula)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Implication(f,g);   
              CUP$parser$result = parser.getSymbolFactory().newSymbol("formula",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // formula ::= formula OR formula 
            {
              Formula RESULT =null;
		int fleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int fright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Formula f = (Formula)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int gleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int gright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Formula g = (Formula)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Disjunction(f,g);   
              CUP$parser$result = parser.getSymbolFactory().newSymbol("formula",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // formula ::= formula AND formula 
            {
              Formula RESULT =null;
		int fleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int fright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Formula f = (Formula)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int gleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int gright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Formula g = (Formula)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Conjunction(f,g);   
              CUP$parser$result = parser.getSymbolFactory().newSymbol("formula",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // formula ::= NEG formula 
            {
              Formula RESULT =null;
		int fleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int fright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Formula f = (Formula)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Negation(f);        
              CUP$parser$result = parser.getSymbolFactory().newSymbol("formula",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // formula ::= LPAREN formula RPAREN 
            {
              Formula RESULT =null;
		int fleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int fright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Formula f = (Formula)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		 RESULT = f;                      
              CUP$parser$result = parser.getSymbolFactory().newSymbol("formula",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= formula EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Formula start_val = (Formula)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT = start_val;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$parser$parser.done_parsing();
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // formula ::= VARIABLE 
            {
              Formula RESULT =null;
		int xleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int xright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String x = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		if(!varMap.containsKey(x))
			 varMap.put(x, new Variable(x));
		RESULT = varMap.get(x);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("formula",0, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number found in internal parse table");

        }
    }
  
  private final Map<String, Variable> varMap = new HashMap<String,Variable>();
}

