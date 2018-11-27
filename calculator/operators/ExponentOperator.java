package operators;

import Evaluator.Operand;

public class ExponentOperator extends Operator{
    /**
  *
  * @param op1
  * @param op2
  * @return difference between op1 and op2
  */
  @Override
  public Operand execute( Operand op1, Operand op2 ){
      
      
      int result = op1.getValue(); 
      int base = op1.getValue();
      
      for(int i = 1; i < op2.getValue(); i++){
          result *= base;
      }
      
      
    
      return (new Operand(result));
  }
  
   
  @Override
  public int priority(){
      return 3; // ^ has priority 3
  }
}
