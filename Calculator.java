import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {
    JTextField display;

    // Constructor: This is where we will set up the window
    public  Calculator() {
        setTitle("Calculator");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);// We will manually place components
        
        // Create a text field for displaying numbers and results
        display = new JTextField();
        display.setBounds(30, 30, 330, 50);           // Position and size (x, y, width, height)
        display.setEditable(false);                                   // User cannot type directly
        display.setFont(new Font("Arial", Font.BOLD, 24));   // Make text bigger
        add(display);                                                   // Add to the window
        
        // Array of button labels
        String[] buttons = {
            "7","8","9","/",
            "4","5","6","*",
            "1","2","3","-",
            "0","C","=","+"
        };

        // Starting positions
        int x = 30;
        int y = 100; // Start below the display
        int z = 0;  // Index for buttons array 

        for(int j=0; j < 4; ++j){
            for(int i=z; i < (z+4); ++i) { 
                JButton btn = new JButton(buttons[i]);                            // Create button
                btn.setBounds(x, y, 70, 50);                      // Position and size
                btn.setFont(new Font("Arial", Font.BOLD, 20));       // Font size
                btn.addActionListener(this);                                    // Add action listener
                add(btn);                                                       // Add to window 

                x += 86; // Move x position for next button
            }
            y += 60; // Move to next row
            z += 4; // Move to next set of buttons
            x = 30; // Reset x position for new row
        }
                                                                                                 
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String value = e.getActionCommand();
        display.setText(display.getText() + value);
    }

    public static void main(String[] args) {
        // Create the window
        Calculator calc = new Calculator();
        calc.setVisible(true);                                  // Make it visible
    }
}
