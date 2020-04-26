package Example;
import java.awt.*;
import javax.swing.*;

public class MyCompositionLayoutManagers {

	public static void main(String[] args) {
        JFrame frame = new JFrame("MyCompositionLayoutManagers");	
      //create BorderLayout
    	BorderLayout myBorderLayout = new BorderLayout();
    	//Sets the LayoutManager to the Layout
    	frame.setLayout(myBorderLayout);

    	//create JPanel whit BorderLayout
    	JPanel myPanel = new JPanel();
    	myPanel.setLayout(new FlowLayout());
    	//add Button to the Panel
    	myPanel.add(new JButton("North 1"));
    	myPanel.add(new JButton("North 2"));
    	myPanel.add(new JButton("North 3"));

    	//add Panel to the NORTH
    	frame.add(myPanel,BorderLayout.NORTH);
    	//add Button to the SOUTH
    	frame.add(new JButton("South"),BorderLayout.SOUTH);
    	//add Button to the EAST
    	frame.add(new JButton("East"), BorderLayout.EAST);
    	//add Button to the WEST
    	frame.add(new JButton("West"), BorderLayout.WEST);
    	//add Button to the CENTER
    	frame.add(new JButton("Center"),BorderLayout.CENTER);
    	frame.pack();
       
		frame.setVisible(true);        
	}

}
