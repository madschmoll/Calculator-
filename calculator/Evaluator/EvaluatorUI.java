package Evaluator;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EvaluatorUI extends JFrame implements ActionListener {

    private TextField txField = new TextField();
    private Panel buttonPanel = new Panel();

    // total of 20 buttons on the calculator,
    // numbered from left to right, top to bottom
    // bText[] array contains the text for corresponding buttons
    private static final String[] bText = {
        "7", "8", "9", "+", "4", "5", "6", "- ", "1", "2", "3",
        "*", "0", "^", "=", "/", "(", ")", "C", "CE"
    };

    /**
     * C  is for clear, clears entire expression
     * CE is for clear expression, clears last entry up until the last operator.
     */
    private Button[] buttons = new Button[bText.length];

    public static void main(String argv[]) {
        EvaluatorUI calc = new EvaluatorUI();
    }

    public EvaluatorUI() {
        // switch from flow layout to border layout 
        setLayout(new BorderLayout());
        this.txField.setPreferredSize(new Dimension(600, 50));
        this.txField.setFont(new Font("Courier", Font.BOLD, 28));

        // add text box
        add(txField, BorderLayout.NORTH);
        txField.setEditable(false); // text box is not editable

        // add buttons
        add(buttonPanel, BorderLayout.CENTER);
        buttonPanel.setLayout(new GridLayout(5, 
                4));

        //create 20 buttons with corresponding text in bText[] array
        Button bt;
        for (int i = 0; i < EvaluatorUI.bText.length; i++) {
            bt = new Button(bText[i]);
            bt.setFont(new Font("Courier", Font.BOLD, 28));
            buttons[i] = bt;
        }

        //add buttons to button panel 
        // although button grid is two dimensional, 
        // we only need a one dimen for loop bc it will automatically go
        // to the next row.
        for (int i = 0; i < EvaluatorUI.bText.length; i++) {
            buttonPanel.add(buttons[i]);
        }

        //set up buttons to listen for mouse input
        for (int i = 0; i < EvaluatorUI.bText.length; i++) {
            buttons[i].addActionListener(this); 
        }

        setTitle("Calculator");
        setSize(400, 400);
        setLocationByPlatform(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    // above should only be changed for design (unnecessary)
    // below is the only method that should be changed 
    public void actionPerformed(ActionEvent arg0) {
        
        // display whatever button you press in the text box
        // note - "=" , "C" , "CE" should not appear in text box
        // getText + getAction will print whatever you have pressed as well
        // do not print "=" , "C" , "CE"
       // if(!(arg0.getActionCommand()).equals("C") && !(arg0.getActionCommand()).equals("=") && !(arg0.getActionCommand()).equals("CE")){
            this.txField.setText( this.txField.getText() + arg0.getActionCommand() );  
        //}
        
        // add functionality to buttons 
        
        // once = is pressed , send expression to eval
        if((arg0.getActionCommand()).equals("=")){
            Evaluator eva = new Evaluator();
            String expr = txField.getText();
            this.txField.setText( String.valueOf( eva.eval(expr) ) );
        }
        
        
        // once C is pressed , delete the previous button pressed 
        if((arg0.getActionCommand()).equals("C")){
            String currExpr = txField.getText();
            int length = currExpr.length();
            this.txField.setText(currExpr.substring(0, (length - 1)));
        }
        
        
        
        // once CE is pressed , delete the entire expression 
        if((arg0.getActionCommand()).equals("CE")){
            this.txField.setText(""); // clears text field
        }
       
        
    }
}
