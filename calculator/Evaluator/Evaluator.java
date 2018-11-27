package Evaluator;

import operators.Operator;
import java.util.*;
import operators.AdditionOperator;
import static operators.Operator.operators;

public class Evaluator {
  private Stack<Operand> operandStack;
  private Stack<Operator> operatorStack;

  private StringTokenizer tokenizer;
  private static final String DELIMITERS = "+-*^/#() ";
  // ^^^ Don't forget to consider () when looking for tokens

  private void Process(Operator oldOpr){
     // note that when we eval the expression 1 - 2 we will
     // push the 1 then the 2 and then do the subtraction operation
     // This means that the first number to be popped is the
     // second operand, not the first operand - see the following code
     // ex : expression = 5 - 3 ; operandStack = 53 ; op2 = 3 op1 = 5
     //      op1 - op2 = 5 - 3
      Operand op2 = operandStack.pop();
      Operand op1 = operandStack.pop();
      operandStack.push( oldOpr.execute( op1, op2 )); 
  }
  
  public Evaluator() {
    operandStack = new Stack<>();
    operatorStack = new Stack<>();
  }

  public int eval( String expression ) {
     int result = 0;
     
     //clear stacks before evaluating 
     operandStack.clear();
     operatorStack.clear();
     
     // push hash onto bottom of stack 
     operatorStack.push(Operator.operators.get("#"));
     
    String token;

    // The 3rd argument is true to indicate that the delimiters should be used
    // as tokens, too. But, we'll need to remember to filter out spaces.
    // ex : given "3+4" with true tokens are "3" "+" "4" 
    //      if third arg were false tokens would be "3" "4" 
    this.tokenizer = new StringTokenizer( expression, DELIMITERS, true );

    // initialize operator stack - necessary with operator priority schema
    // the priority of any operator in the operator stack other than
    // the usual mathematical operators - "+-*/" - should be less than the priority
    // of the usual operators

    // TODO Operator is abstract - this will need to be fixed:


    while ( this.tokenizer.hasMoreTokens() ) { // while tokenizer still has tokens
      // filter out spaces
      if ( !( token = this.tokenizer.nextToken() ).equals( " " )) { // if token != a space
        // check if token is an operand
        if ( Operand.check( token )) { // if token is an operand
          operandStack.push( new Operand( token )); //push token onto operand stack 
        } 
     
        else { // if token is not an operand 
          
         if ( !Operator.check( token )) { // if token is not an operator
            // ^^^^^^^ FIXME Is this allowed?!
            System.out.println( "*****invalid token******" );
            throw new RuntimeException("*****invalid token******");
          }

          // TODO Operator is abstract - these two lines will need to be fixed:
          // The Operator class should contain an instance of a HashMap,
          // and values will be instances of the Operators.  See Operator class
          // skeleton for an example.
         
           // how to access hashmap in Operators? Operator.operators
          Operator newOperator = Operator.operators.get(token);

          // while top of stack has greater (or equal) priority than the newOperator
          while ( (operatorStack.peek()).priority() >= newOperator.priority() ) { 

            Process(operatorStack.pop());
          
          }
         
          if(newOperator.equals(operators.get("("))){
              // change ( to pop(
              newOperator = operators.get("pop(");
          }
          
          operatorStack.push( newOperator );
          
          if(newOperator.equals(operators.get(")"))){
              operatorStack.pop();
              operatorStack.pop();
          }
        }
      }
    }

    // Control gets here when we've picked up all of the tokens; you must add
    // code to complete the evaluation - consider how the code given here
    // will evaluate the expression 1+2*3
    // When we have no more tokens to scan, the operand stack will contain 1 2
    // and the operator stack will have + * with 2 and * on the top;
    // ^^^ WHY isn't three at the top of the operand stack? Is it still in token var? 
    // In order to complete the evaluation we must empty the stacks (except
    // the init operator on the operator stack); that is, we should keep
    // evaluating the operator stack until it only contains the init operator;
    // Suggestion: create a method that takes an operator as argument and
    // then executes the while loop.
    
    
    while(operatorStack.peek().priority() != -1){
        Process(operatorStack.pop());
    }
    
    result = operandStack.pop().getValue(); 
    
    return result;
  }
}
