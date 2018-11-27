
package operators;

import Evaluator.Operand;

public class SubtractionOperator extends Operator {
 
/**
  *
  * @param op1
  * @param op2
  * @return difference between op1 and op2
  */
  @Override
  public Operand execute( Operand op1, Operand op2 ){
      
      Operand dif = new Operand(op1.getValue() - op2.getValue());
    
      return dif;
  }
  
   
  @Override
  public int priority(){
      return 1; // - has priority 1
  }
  
  
}
