
package operators;

import Evaluator.Operand;

public class DivisionOperator extends Operator {
    /**
  *
  * @param op1
  * @param op2
  * @return difference between op1 and op2
  */
  @Override
  public Operand execute( Operand op1, Operand op2 ){
      
      Operand quo = new Operand(op1.getValue() / op2.getValue());
    
      return quo;
  }
  
   
  @Override
  public int priority(){
      return 2; // / has priority 2
  }
}
