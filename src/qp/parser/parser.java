
//----------------------------------------------------
// The following code was generated by CUP v0.10k
// Sat Mar 30 17:31:28 SGT 2019
//----------------------------------------------------

package qp.parser;

import java.util.Vector;

import java_cup.runtime.Symbol;
import qp.utils.Attribute;
import qp.utils.Condition;
import qp.utils.SQLQuery;

/** CUP v0.10k generated parser.
  * @version Sat Mar 30 17:31:28 SGT 2019
  */
public class parser extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public parser() {super();}

  /** Constructor which sets the default scanner. */
  public parser(java_cup.runtime.Scanner s) {super(s);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\034\000\002\003\005\000\002\002\004\000\002\003" +
    "\010\000\002\003\010\000\002\003\006\000\002\003\006" +
    "\000\002\003\011\000\002\003\011\000\002\003\007\000" +
    "\002\003\007\000\002\004\005\000\002\004\003\000\002" +
    "\006\005\000\002\006\003\000\002\007\005\000\002\007" +
    "\003\000\002\010\005\000\002\010\005\000\002\010\004" +
    "\000\002\010\004\000\002\005\005\000\002\005\004\000" +
    "\002\011\003\000\002\011\003\000\002\011\003\000\002" +
    "\011\003\000\002\011\003\000\002\011\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\065\000\004\021\005\001\002\000\006\002\066\024" +
    "\065\001\002\000\010\004\007\010\010\025\006\001\002" +
    "\000\006\004\007\010\053\001\002\000\006\003\050\007" +
    "\051\001\002\000\004\022\044\001\002\000\006\005\013" +
    "\022\014\001\002\000\012\002\ufff6\005\ufff6\022\ufff6\024" +
    "\ufff6\001\002\000\004\004\007\001\002\000\004\004\015" +
    "\001\002\000\012\002\ufff4\005\ufff4\023\ufff4\024\ufff4\001" +
    "\002\000\012\002\ufffd\005\017\023\020\024\ufffd\001\002" +
    "\000\004\004\042\001\002\000\006\003\022\004\007\001" +
    "\002\000\010\002\uffff\005\040\024\uffff\001\002\000\004" +
    "\026\037\001\002\000\020\003\026\011\030\012\032\013" +
    "\033\014\025\015\027\016\031\001\002\000\010\002\ufff2" +
    "\005\ufff2\024\ufff2\001\002\000\006\004\uffe8\026\uffe8\001" +
    "\002\000\010\002\uffef\005\uffef\024\uffef\001\002\000\006" +
    "\004\uffe6\026\uffe6\001\002\000\006\004\uffeb\026\uffeb\001" +
    "\002\000\006\004\uffe7\026\uffe7\001\002\000\006\004\uffea" +
    "\026\uffea\001\002\000\006\004\uffe9\026\uffe9\001\002\000" +
    "\006\004\007\026\036\001\002\000\010\002\ufff0\005\ufff0" +
    "\024\ufff0\001\002\000\010\002\ufff1\005\ufff1\024\ufff1\001" +
    "\002\000\010\002\uffee\005\uffee\024\uffee\001\002\000\006" +
    "\003\022\004\007\001\002\000\010\002\ufff3\005\ufff3\024" +
    "\ufff3\001\002\000\012\002\ufff5\005\ufff5\023\ufff5\024\ufff5" +
    "\001\002\000\012\002\ufff7\005\ufff7\022\ufff7\024\ufff7\001" +
    "\002\000\004\004\015\001\002\000\012\002\ufffc\005\017" +
    "\023\046\024\ufffc\001\002\000\006\003\022\004\007\001" +
    "\002\000\010\002\ufffe\005\040\024\ufffe\001\002\000\030" +
    "\002\uffec\003\uffec\005\uffec\011\uffec\012\uffec\013\uffec\014" +
    "\uffec\015\uffec\016\uffec\022\uffec\024\uffec\001\002\000\004" +
    "\004\052\001\002\000\030\002\uffed\003\uffed\005\uffed\011" +
    "\uffed\012\uffed\013\uffed\014\uffed\015\uffed\016\uffed\022\uffed" +
    "\024\uffed\001\002\000\004\022\061\001\002\000\006\005" +
    "\013\022\055\001\002\000\004\004\015\001\002\000\012" +
    "\002\ufff9\005\017\023\057\024\ufff9\001\002\000\006\003" +
    "\022\004\007\001\002\000\010\002\ufffb\005\040\024\ufffb" +
    "\001\002\000\004\004\015\001\002\000\012\002\ufff8\005" +
    "\017\023\063\024\ufff8\001\002\000\006\003\022\004\007" +
    "\001\002\000\010\002\ufffa\005\040\024\ufffa\001\002\000" +
    "\004\004\007\001\002\000\004\002\000\001\002\000\010" +
    "\002\001\005\013\024\001\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\065\000\004\003\003\001\001\000\002\001\001\000" +
    "\006\004\010\005\011\001\001\000\006\004\053\005\011" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\004\005\042\001\001\000\004" +
    "\006\015\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\010\005\022\007\020\010\023\001\001" +
    "\000\002\001\001\000\002\001\001\000\004\011\033\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\004\005\034\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\006\005\022\010\040\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\004\006\044\001\001\000" +
    "\002\001\001\000\010\005\022\007\046\010\023\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\004" +
    "\006\055\001\001\000\002\001\001\000\010\005\022\007" +
    "\057\010\023\001\001\000\002\001\001\000\004\006\061" +
    "\001\001\000\002\001\001\000\010\005\022\007\063\010" +
    "\023\001\001\000\002\001\001\000\006\004\066\005\011" +
    "\001\001\000\002\001\001\000\002\001\001" });

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



    public SQLQuery query;

    public SQLQuery getSQLQuery() {
        return query;
    }

    public void report_fatal_error(String message, Object info) throws java.lang.Exception {
        // Stops parsing (not really necessary since we throw an exception, but).
        done_parsing();

        // Uses the normal error message reporting to put out the message.
        report_error("Fatal error occurred, stop parsing.", info);
    }

    public void syntax_error(Symbol cur_token) {
    }

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
          case 27: // op ::= EQUAL 
            {
              Condition RESULT = null;
		
        RESULT = new Condition(Condition.EQUAL);
    
              CUP$parser$result = new java_cup.runtime.Symbol(7/*op*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // op ::= NOTEQUAL 
            {
              Condition RESULT = null;
		
        RESULT = new Condition(Condition.NOTEQUAL);
    
              CUP$parser$result = new java_cup.runtime.Symbol(7/*op*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // op ::= GTOE 
            {
              Condition RESULT = null;
		
        RESULT = new Condition(Condition.GTOE);
    
              CUP$parser$result = new java_cup.runtime.Symbol(7/*op*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // op ::= LTOE 
            {
              Condition RESULT = null;
		
        RESULT = new Condition(Condition.LTOE);
    
              CUP$parser$result = new java_cup.runtime.Symbol(7/*op*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // op ::= GREATERTHAN 
            {
              Condition RESULT = null;
		
        RESULT = new Condition(Condition.GREATER_THAN);
    
              CUP$parser$result = new java_cup.runtime.Symbol(7/*op*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // op ::= LESSTHAN 
            {
              Condition RESULT = null;
		
        RESULT = new Condition(Condition.LESS_THAN);
    
              CUP$parser$result = new java_cup.runtime.Symbol(7/*op*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // attribute ::= ID error 
            {
              Attribute RESULT = null;
		int ileft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int iright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		TokenValue i = (TokenValue)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int pleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int pright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Object p = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		
        System.out.println("syntax error: incorrect attribute:"+ i.text());
        System.exit(0);
    
              CUP$parser$result = new java_cup.runtime.Symbol(3/*attribute*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // attribute ::= ID DOT ID 
            {
              Attribute RESULT = null;
		int i1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int i1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		TokenValue i1 = (TokenValue)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int i2left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int i2right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		TokenValue i2 = (TokenValue)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		
        RESULT= new Attribute(i1.text(),i2.text());
    
              CUP$parser$result = new java_cup.runtime.Symbol(3/*attribute*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // condition ::= error STRINGLIT 
            {
              Condition RESULT = null;
		int pleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int pright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object p = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int sleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int sright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		TokenValue s = (TokenValue)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		
        System.out.println("syntax error: incorrect condition:"+s.text());
        System.exit(0);
    
              CUP$parser$result = new java_cup.runtime.Symbol(6/*condition*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // condition ::= attribute error 
            {
              Condition RESULT = null;
		int atleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int atright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Attribute at = (Attribute)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int pleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int pright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Object p = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		
        System.out.println("syntax error: incorrect condition");
        System.exit(0);
    
              CUP$parser$result = new java_cup.runtime.Symbol(6/*condition*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // condition ::= attribute op attribute 
            {
              Condition RESULT = null;
		int a1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int a1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Attribute a1 = (Attribute)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int oleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int oright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Condition o = (Condition)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int a2left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int a2right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Attribute a2 = (Attribute)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		
        Condition c = new Condition(a1, o.getOperator(), a2);
        c.setCondType(Condition.JOIN);
        RESULT = c;
    
              CUP$parser$result = new java_cup.runtime.Symbol(6/*condition*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // condition ::= attribute op STRINGLIT 
            {
              Condition RESULT = null;
		int atleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int atright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Attribute at = (Attribute)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int oleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int oright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Condition o = (Condition)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int sleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int sright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		TokenValue s = (TokenValue)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		
        Condition c = new Condition(at, o.getOperator(), s.text());
        c.setCondType(Condition.SELECT);
        RESULT = c;
    
              CUP$parser$result = new java_cup.runtime.Symbol(6/*condition*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // conditionlist ::= condition 
            {
              Vector RESULT = null;
		int cleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int cright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Condition c = (Condition)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		
        Vector clist = new Vector();
        clist.add(c);
        RESULT = clist;
    
              CUP$parser$result = new java_cup.runtime.Symbol(5/*conditionlist*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // conditionlist ::= conditionlist COMMA condition 
            {
              Vector RESULT = null;
		int clistleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int clistright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Vector clist = (Vector)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int cleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int cright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Condition c = (Condition)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		
        clist.add(c);
        RESULT = clist;
    
              CUP$parser$result = new java_cup.runtime.Symbol(5/*conditionlist*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // tablelist ::= ID 
            {
              Vector RESULT = null;
		int ileft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int iright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		TokenValue i = (TokenValue)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		
        Vector tlist = new Vector();
        tlist.add(i.text());
        RESULT = tlist;
    
              CUP$parser$result = new java_cup.runtime.Symbol(4/*tablelist*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // tablelist ::= tablelist COMMA ID 
            {
              Vector RESULT = null;
		int tlistleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int tlistright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Vector tlist = (Vector)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int ileft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int iright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		TokenValue i = (TokenValue)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		
        tlist.add(i.text());
        RESULT = tlist;
    
              CUP$parser$result = new java_cup.runtime.Symbol(4/*tablelist*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // attlist ::= attribute 
            {
              Vector RESULT = null;
		int atleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int atright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Attribute at = (Attribute)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		
        Vector v = new Vector();
        v.add(at);
        RESULT = v;
    
              CUP$parser$result = new java_cup.runtime.Symbol(2/*attlist*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // attlist ::= attlist COMMA attribute 
            {
              Vector RESULT = null;
		int asleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int asright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Vector as = (Vector)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Attribute a = (Attribute)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		
        as.add(a);
        RESULT = as;
    
              CUP$parser$result = new java_cup.runtime.Symbol(2/*attlist*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // sqlquery ::= SELECT DISTINCT STAR FROM tablelist 
            {
              SQLQuery RESULT = null;
		int tleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int tright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Vector t = (Vector)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		
        Vector a = new Vector();
        SQLQuery sq = new SQLQuery(a, t);
        sq.setIsDistinct(true);
        parser.query = sq;
        RESULT = sq;
    
              CUP$parser$result = new java_cup.runtime.Symbol(1/*sqlquery*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // sqlquery ::= SELECT DISTINCT attlist FROM tablelist 
            {
              SQLQuery RESULT = null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Vector a = (Vector)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int tleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int tright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Vector t = (Vector)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		
        SQLQuery sq = new SQLQuery(a, t);
        sq.setIsDistinct(true);
        parser.query = sq;
        RESULT = sq;
    
              CUP$parser$result = new java_cup.runtime.Symbol(1/*sqlquery*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // sqlquery ::= SELECT DISTINCT STAR FROM tablelist WHERE conditionlist 
            {
              SQLQuery RESULT = null;
		int tleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int tright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Vector t = (Vector)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int cleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int cright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Vector c = (Vector)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		
        Vector a = new Vector();
        SQLQuery sq = new SQLQuery(a, t, c);
        sq.setIsDistinct(true);
        parser.query = sq;
        RESULT = sq;
    
              CUP$parser$result = new java_cup.runtime.Symbol(1/*sqlquery*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-6)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // sqlquery ::= SELECT DISTINCT attlist FROM tablelist WHERE conditionlist 
            {
              SQLQuery RESULT = null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).right;
		Vector a = (Vector)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-4)).value;
		int tleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int tright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Vector t = (Vector)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int cleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int cright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Vector c = (Vector)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		
        SQLQuery sq = new SQLQuery(a, t, c);
        sq.setIsDistinct(true);
        parser.query = sq;
        RESULT = sq;
    
              CUP$parser$result = new java_cup.runtime.Symbol(1/*sqlquery*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-6)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // sqlquery ::= SELECT STAR FROM tablelist 
            {
              SQLQuery RESULT = null;
		int tleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int tright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Vector t = (Vector)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		
        Vector a = new Vector();
        SQLQuery sq = new SQLQuery(a, t);
        parser.query = sq;
        RESULT = sq;
    
              CUP$parser$result = new java_cup.runtime.Symbol(1/*sqlquery*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // sqlquery ::= SELECT attlist FROM tablelist 
            {
              SQLQuery RESULT = null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Vector a = (Vector)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int tleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int tright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Vector t = (Vector)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		
        SQLQuery sq = new SQLQuery(a, t);
        parser.query = sq;
        RESULT = sq;
    
              CUP$parser$result = new java_cup.runtime.Symbol(1/*sqlquery*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // sqlquery ::= SELECT STAR FROM tablelist WHERE conditionlist 
            {
              SQLQuery RESULT = null;
		int tleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int tright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Vector t = (Vector)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int cleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int cright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Vector c = (Vector)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		
        Vector a = new Vector();
        SQLQuery sq = new SQLQuery(a, t, c);
        parser.query = sq;
        RESULT = sq;
    
              CUP$parser$result = new java_cup.runtime.Symbol(1/*sqlquery*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-5)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // sqlquery ::= SELECT attlist FROM tablelist WHERE conditionlist 
            {
              SQLQuery RESULT = null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).right;
		Vector a = (Vector)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-4)).value;
		int tleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int tright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Vector t = (Vector)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int cleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int cright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Vector c = (Vector)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		
        SQLQuery sq = new SQLQuery(a, t, c);
        parser.query = sq;
        RESULT = sq;
    
              CUP$parser$result = new java_cup.runtime.Symbol(1/*sqlquery*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-5)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= sqlquery EOF 
            {
              Object RESULT = null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		SQLQuery start_val = (SQLQuery)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT = start_val;
              CUP$parser$result = new java_cup.runtime.Symbol(0/*$START*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          /* ACCEPT */
          CUP$parser$parser.done_parsing();
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // sqlquery ::= sqlquery GROUPBY attlist 
            {
              SQLQuery RESULT = null;
		int sleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int sright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		SQLQuery s = (SQLQuery)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Vector a = (Vector)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		
        s.setGroupByList(a);
        parser.query = s;
    
              CUP$parser$result = new java_cup.runtime.Symbol(1/*sqlquery*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number found in internal parse table");

        }
    }
}

