package gui;

import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.*; 
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*; 

public class CreateRoadSystem extends JFrame implements ChangeListener,ActionListener {
	 // frame 
    private JFrame frame, tempFrame; 
    // slider 
    private JSlider jSliderVehicles, jSliderJunctions; 
    // label 

    private JLabel lableVehicles, lableJunctions;
    private JPanel panel, tempPanel;
	private JButton jbnButtons[];
    private static final String[] jbnButtonsItems = { "Ok","Cancel"};
    // main class 
    public CreateRoadSystem() 
    { 
        
        // create a panel 
        panel = new JPanel(); 
        panel.setLayout(new GridLayout(6,1));
        // create a new frame 
   
        
        // create a slider 
        jSliderJunctions = new JSlider(3, 20, 3); 
  
        // paint the ticks and tarcks 
        jSliderJunctions.setPaintTrack(true); 
        jSliderJunctions.setPaintTicks(true); 
        jSliderJunctions.setPaintLabels(true); 
  
        // set spacing 
        jSliderJunctions.setMajorTickSpacing(1); 
        jSliderJunctions.setMinorTickSpacing(1); 

        // create label 
        lableJunctions = new JLabel(); 
        lableJunctions.setHorizontalAlignment(JLabel.CENTER);
        lableJunctions.setText("Numbers of junctions");
        
        /*
        // setChangeListener 
         jSliderJunctions.addChangeListener(roadSystem); 
       // set the text of label 
        lableJunctions.setText("value of Slider is =" + jSliderJunctions.getValue()); 
        */
        panel.add(lableJunctions);
        panel.add(jSliderJunctions); 
        
        /*******************************************************************************/


        // create a slider 
        jSliderVehicles = new JSlider(0, 50, 0); 
  
        // paint the ticks and tarcks 
        jSliderVehicles.setPaintTrack(true); 
        jSliderVehicles.setPaintTicks(true); 
        jSliderVehicles.setPaintLabels(true); 
  
        // set spacing 
        jSliderVehicles.setMajorTickSpacing(5); 
        jSliderVehicles.setMinorTickSpacing(1); 

        // create label and add to panel 
        lableVehicles = new JLabel(); 
        lableVehicles.setHorizontalAlignment(JLabel.CENTER);
        lableVehicles.setText("Numbers of vehicles");
    
        /*
        // setChangeListener 
        jSliderVehicles.addChangeListener(roadSystem); 
       // set the text of label 
        lableVehicles.setText("value of Slider is =" + jSliderVehicles.getValue()); 
        */
        panel.add(lableVehicles); 
        // add slider to panel
        panel.add(jSliderVehicles); 
        
        /*******************************************************************************/
        tempPanel = new JPanel(); 
        tempPanel.setLayout(new GridLayout(1,2));
		jbnButtons = new JButton[2];	
		for( int item=0;item<jbnButtons.length; item++) {
			jbnButtons[item] = new JButton(jbnButtonsItems[item]);
		}
	
		for( int item=0;item<jbnButtons.length; item++) {
			tempPanel.add(jbnButtons[item]);
		}


		getContentPane().add(tempPanel, BorderLayout.PAGE_END);
    	getContentPane().add(panel, BorderLayout.PAGE_START);
	
		for (int i=0; i<jbnButtons.length; i++){
			jbnButtons[i].addActionListener(this);
		}
        /*******************************************************************************/
		addWindowListener(new WindowAdapter() {
			public void windowClosed(WindowEvent e)
			{
				System.exit(0);
			}
		}
	);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        
        
    } 
    // if JSlider value is changed 
    public void stateChanged(ChangeEvent e) 
    { 
    	lableVehicles.setText("value of Slider is =" + jSliderVehicles.getValue()); 
    	lableJunctions.setText("value of Slider is =" + jSliderJunctions.getValue()); 
    } 
    
/*    public static void main(String[] args) 
    { 

  
        // create a object 
        CreateRoadSystem roadSystem = new CreateRoadSystem();
		Container contentPane = roadSystem.getContentPane();
		roadSystem.setTitle("Create road system");
		roadSystem.setSize(400, 300);
		roadSystem.setVisible(true);
		roadSystem.setResizable(true);
    }*/
	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i=0; i<jbnButtons.length; i++)
		{
			if(e.getSource() == jbnButtons[i])
			{
				switch(i)
				{
					case 0:
						System.exit(0);
						break;
					case 1:
						System.exit(0);
						break;

				}
			}

		}
		
	}
}
  

