package Example;
import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

import javax.swing.*;
public class LayoutManagers {

	public static void main(String[] args) {
        JFrame frame = new JFrame("Box Volume & Area");	
        JButton b1 = new JButton("Button1");
        JButton b2 = new JButton("Button2");
        JButton b3 = new JButton("Button3");
        JButton b4 = new JButton("Long-Named Button 4");
        JButton b5 = new JButton("5");
        JPanel panel1 = new JPanel();
        
        //frame.setLayout(new GridLayout(0, 1));
        panel1.add(b1);
        panel1.add(b2);
        panel1.add(b3);
        panel1.add(b4);
        panel1.add(b5);
        frame.add(panel1);
       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        //frame.setSize(280,150);
        frame.setVisible(true);
	}

}
