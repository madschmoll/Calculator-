
package operators;

import Evaluator.Operand;

/*
    Hash Operator indicates beginning of Stack
*/

public class HashOperator extends Operator{
    
    @Override
    public Operand execute( Operand op1, Operand op2 ){
        return op1;   
      }
  
   
  @Override
  public int priority(){
      return -1; // # has lowest priority of -1
  }
}
