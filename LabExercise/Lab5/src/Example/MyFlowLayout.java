package Example;
import java.awt.*;
import javax.swing.*;

public class MyFlowLayout {

	public static void main(String[] args) {
        JFrame frame = new JFrame("MyFlowLayout");	

        //set the size of the window
    	//this.setSize(400, 150);

    	//create FlowLayout 
    	FlowLayout myFlowLayout = new FlowLayout();
    	//set the Alignment similar to word
    	myFlowLayout.setAlignment(FlowLayout.CENTER);

    	//Sets the horizontal gap between components
    	myFlowLayout.setHgap(20);
    	//Sets the vertical gap between components
    	myFlowLayout.setVgap(20); 
    	//Sets the LayoutManager to the Layout
    	frame.setLayout(myFlowLayout); 

    	//create a JButton with the text "Add"
    	JButton addToNumberButton= new JButton("Add");
    	//Don't use setBounds() ,use setPreferredSize() instead
    	addToNumberButton.setPreferredSize(new Dimension(80,23));
    	//add ActionListener, if the Button press the
    	//actionPerformed will called
    	//addToNumberButton.addActionListener(frame);      
    	//add the Button to MyFrame
    	frame.getContentPane().add(addToNumberButton); 
    	JTextField myTextField1 = new JTextField("number");
    	myTextField1.setPreferredSize(new Dimension(80,23));
    	frame.getContentPane().add(myTextField1);

    	JTextField myTextField2 = new JTextField("number");
    	myTextField2.setPreferredSize(new Dimension(80,23));
    	frame.getContentPane().add(myTextField2);

    	JLabel myLabel = new JLabel("sum");
    	myLabel.setPreferredSize(new Dimension(80,23));
    	frame.getContentPane().add(myLabel);

    	JButton bCount = new JButton("Count");
    	//bCount.addActionListener(this);
    	frame.add(bCount);
    	//if size not specific , the size will by according to the text  

       //set the size of the window according to the components
    	//this.pack();
       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        //frame.setSize(400,150);
        frame.setVisible(true);

	}

}
