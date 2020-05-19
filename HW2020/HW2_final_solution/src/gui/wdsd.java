package gui;
import javax.swing.*;
import java.awt.*;

public class wdsd {

    public static void main(String[] args) {
        // creates the JFrame(a window with decorations)
        JFrame frame = new JFrame("Calculator"); 
        // stops the program when window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setSize(377, 350);

        // the main panel of the JFrame, 
        // remembet you cant add content directly to JFrame
        JPanel content = new JPanel(new GridLayout(4, 0)); 
        // panel for the text field
        JPanel textarea = new JPanel(new GridLayout(4, 0)); 
        // panel for the buttons, 
        // GridLayout(int rows, int cols, int horiz_gap, int vert_gap)
        JPanel buttonarea = new JPanel(new GridLayout(4, 5, 2, 2)); 

        //  the panel for the bigger bottom buttons
        JPanel secondbuttonarea = new JPanel(new GridLayout(1, 1, 2, 2)); 
        // the panel for the text on top
        JPanel label = new JPanel(); 
        content.add(label);
        content.add(textarea);
        content.add(buttonarea);
        content.add(secondbuttonarea);

        JLabel words = new JLabel("Polyashenko's Calculator", JLabel.CENTER);
        label.add(words);

        JTextField enterhere = new JTextField("0.", JTextField.CENTER);
        // will set the curser of the text bar on right side
        enterhere.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT); 
        textarea.add(enterhere);

        // makes a button called b1 with text in it
        JButton b1 = new JButton("BkSP"); 
        // adds the backspace button to the buttonarea panel
        buttonarea.add(b1); 
        JButton b2 = new JButton("CE");
        buttonarea.add(b2);
        JButton b3 = new JButton("C");
        buttonarea.add(b3);
        JButton b4 = new JButton("/");
        buttonarea.add(b4);
        JButton b5 = new JButton("sqrt");
        buttonarea.add(b5);
        JButton b6 = new JButton("7");
        buttonarea.add(b6);
        JButton b7 = new JButton("8");
        buttonarea.add(b7);
        JButton b8 = new JButton("9");
        buttonarea.add(b8);
        JButton b9 = new JButton("*");
        buttonarea.add(b9);
      //  JButton b10 = new JButton("%");
     //   buttonarea.add(b10);
        JButton b11 = new JButton("4");
        buttonarea.add(b11);
        JButton b12 = new JButton("5");
        buttonarea.add(b12);
        JButton b13 = new JButton("6");
        buttonarea.add(b13);
        JButton b14 = new JButton("-");
        buttonarea.add(b14);
        JButton b15 = new JButton("1/x");
        buttonarea.add(b15);
        JButton b16 = new JButton("1");
        buttonarea.add(b16);
        JButton b17 = new JButton("2");
        buttonarea.add(b17);
        JButton b18 = new JButton("3");
        buttonarea.add(b18);
        JButton b19 = new JButton("+");
        buttonarea.add(b19);
        JButton b20 = new JButton("+/-");
        buttonarea.add(b20);

        JButton b21 = new JButton("0");
        secondbuttonarea.add(b21);
        JButton b22 = new JButton(".");
        secondbuttonarea.add(b22);
        JButton b23 = new JButton("=");
        secondbuttonarea.add(b23);

        // adds the buttonarea panel to the main panel
        frame.getContentPane().add(content); 
        // makes the window visible, put at end of program
        frame.setVisible(true); 
    }
}