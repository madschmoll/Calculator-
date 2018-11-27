package Evaluator;

public class Operand {

  private int value;
  
  public Operand( String token ) {
      value = Integer.parseInt(token);  
  }

  public Operand( int val ) {
      value = val;
  }

  public int getValue() {
      return value;
  }

  public static boolean check( String token ) {
     boolean isOperand = true;
       
      try {
          Integer.parseInt(token);
          
      } catch(NumberFormatException e){
          
          isOperand = false;
      
      }
     
      return isOperand;
 
   
  }
}
