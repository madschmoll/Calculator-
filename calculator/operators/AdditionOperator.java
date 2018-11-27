
package operators;

import Evaluator.Operand;

public class AdditionOperator extends Operator {
    
  /**
  *
  * @param op1
  * @param op2
  * @return sum of op1 and op2
  */
  @Override
  public Operand execute( Operand op1, Operand op2 ){
      
      int sum = op1.getValue() + op2.getValue();
      return (new Operand(sum));
  }
  
   
  @Override
  public int priority(){
      return 1; // + has priority 1
  }
    
}
