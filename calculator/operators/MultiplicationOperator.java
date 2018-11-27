package operators;

import Evaluator.Operand;

public class MultiplicationOperator extends Operator{
    /**
  *
  * @param op1
  * @param op2
  * @return difference between op1 and op2
  */
  @Override
  public Operand execute( Operand op1, Operand op2 ){
      
      Operand mul = new Operand(op1.getValue() * op2.getValue());
    
      return mul;
  }
  
   
  @Override
  public int priority(){
      return 2; // * has priority 2
  }
}
