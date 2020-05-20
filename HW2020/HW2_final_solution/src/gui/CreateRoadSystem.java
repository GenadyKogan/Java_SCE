package gui;

import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.*; 
import java.awt.*; 
import javax.swing.*; 

public class CreateRoadSystem extends JFrame implements ChangeListener {
	 // frame 
    private static JFrame frame; 
    // slider 
    private static JSlider jSliderVehicles, jSliderJunctions; 
    // label 
    private  static JLabel lableVehicles, lableJunctions;
    private  static JPanel panel, tempPanel;
	private static JButton jbnButtons[];
    private static final String[] jbnButtonsItems = { "Ok","Cancel"};
    // main class 
    public static void main(String[] args) 
    { 
        // create a new frame 
    	frame = new JFrame("Create road system"); 
  
        // create a object 
        CreateRoadSystem roadSystem = new CreateRoadSystem();
        
        // create a panel 
        panel = new JPanel(); 
        panel.setLayout(new GridLayout(6,1));
        
        
        // create a slider 
        jSliderJunctions = new JSlider(3, 20, 3); 
  //
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
        jSliderVehicles = new JSlider(0, 50, 10); 
  
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
		tempPanel.setLayout(new GridLayout(1,5));
		for( int item=0;item<jbnButtons.length; item++) {
			tempPanel.add(jbnButtons[item]);
		}
	
        panel.add(tempPanel); 
        /*******************************************************************************/
        
        
        
        
        
        
        
        
        
        
        frame.add(panel); 
        // set the size of frame 
        frame.setSize(400, 300); 
        frame.show(); 
        
        

        
        
    } 
    // if JSlider value is changed 
    public void stateChanged(ChangeEvent e) 
    { 
    	lableVehicles.setText("value of Slider is =" + jSliderVehicles.getValue()); 
    	lableJunctions.setText("value of Slider is =" + jSliderJunctions.getValue()); 
    } 
}
  

