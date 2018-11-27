
package operators;

import Evaluator.Operand;

/*

    Left Parenthesis "(" has the highest priority of 4 so that when executing
    the while loop in eval, everything behind the ( will be executed

*/
public class LeftParenthesisOperator extends Operator {

  @Override
  public int priority(){
      return 4;
  }
  
  @Override
  public Operand execute( Operand op1, Operand op2 ){
     return null;
  }
    
}
