package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.JApplet;

import javax.swing.JProgressBar;
import javax.swing.event.*; 
import java.awt.*; 
import javax.swing.*; 

public class CreateRoadSystem extends JFrame implements ChangeListener {
	   // frame 
    private static JFrame frame; 
  
    // slider 
    private static JSlider jSliderVehicles; 
  
    // label 
    private static JLabel lableVehicles, lableJunctions;
    // main class 
    public static void main(String[] args) 
    { 
        // create a new frame 
    	frame = new JFrame("Create road system"); 
  
        // create a object 
        CreateRoadSystem roadSystem = new CreateRoadSystem();
        
        // create a panel 
        JPanel panel = new JPanel(); 
        panel.setLayout(new GridLayout(5,1));
        
        
        // create label 
        lableJunctions = new JLabel(); 
        lableJunctions.setHorizontalAlignment(JLabel.CENTER);
        lableJunctions.setText("Numbers of junctions");
        panel.add(lableJunctions);
        
        
        ///
        
        
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
        panel.add(lableVehicles); 
        
        // add slider to panel
        panel.add(jSliderVehicles); 
        frame.add(panel); 
  
        // set the size of frame 
        frame.setSize(300, 300); 
        frame.show(); 
        
        
        // setChangeListener 
        jSliderVehicles.addChangeListener(roadSystem);   
       // set the text of label 
        lableVehicles.setText("value of Slider is =" + jSliderVehicles.getValue()); 
    } 
    // if JSlider value is changed 
    public void stateChanged(ChangeEvent e) 
    { 
    	lableVehicles.setText("value of Slider is =" + jSliderVehicles.getValue()); 
    } 
}
  



