
package operators;

import Evaluator.Operand;

/*

    After everything behind ( is executed, the priority of ( should be 
    lowered. By changing ( to pop( after the execution of the parenthesis,
    during the final processing, ( can be popped off. 

*/

public class PopLeftParenthesisOperator extends Operator {
    
  @Override
  public int priority(){
      return 0;
  }
  
  @Override
  public Operand execute( Operand op1, Operand op2 ){
     return null;
  }
    
}
