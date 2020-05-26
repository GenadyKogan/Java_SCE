package gui;

import javax.swing.border.TitledBorder;
import javax.swing.event.*; 

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import gui.RoadFrame;
import javax.swing.*; 

import java.awt.geom.Ellipse2D;

import javax.swing.*;


import java.util.Arrays;
import java.util.Hashtable;
import java.util.Random;
////
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import components.Driving;
import components.Road;
public class CreateRoadSystem extends JFrame implements ActionListener {
	 // frame 
    private JFrame frame, tempFrame; 
    // slider 
    private JSlider jSliderVehicles, jSliderJunctions; 
    // label 
    private JLabel lableVehicles, lableJunctions;
	private JPanel panel, tempPanel;
	private JButton jbnButtons[];
	private static final String[] jbnButtonsItems = { "Ok","Cancel"};
	Driving d= new Driving(3,0);
	Hashtable<Integer, JLabel> position = new Hashtable<Integer, JLabel>();

	// main class 
    public CreateRoadSystem() 
    { 

        
        // create a panel 
        panel = new JPanel(); 
        panel.setLayout(new GridLayout(6,1));
        // create a new frame 
   
        /*******************************************************************************/

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

        

        
	    // Add positions label in the slider
	    for(int i=3;i<=20;i++)
	    	position.put(i, new JLabel(""+i));
	    // Set the label to be drawn
	    this.jSliderJunctions.setLabelTable(position);
	   
	    // Add change listener to the slider
	    this.jSliderJunctions.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent e) {
	        	lableJunctions.setText("Value of the slider is: " + ((JSlider)e.getSource()).getValue());
	            int valueJunctions =(int)getjSliderJunctions().getValue();
	            System.out.println("ddd"+valueJunctions);
	        	
	        }
	    });
	        
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
    
        // Add positions label in the slider
	    Hashtable<Integer, JLabel> position2 = new Hashtable<Integer, JLabel>();
	    for(int i=0,index=0;i<=50;i++)
	    {
	    	position2.put(index, new JLabel(""+index));
	    	index+=5;
	    }
	  
	    // Set the label to be drawn
	    this.jSliderVehicles.setLabelTable(position2);
	     
	    // Add change listener to the slider
	    this.jSliderVehicles.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent e) {
	        	lableVehicles.setText("Value of the slider is: " + ((JSlider)e.getSource()).getValue());
	            int valueVehicles =(int)getjSliderVehicles().getValue();
	            System.out.println("ddd"+valueVehicles);
	        }
	       
	    });
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

	/*******************************************************************************/
/*
   public static void main(String[] args) 
    { 
	//
  
        // create a object 
        CreateRoadSystem roadSystem = new CreateRoadSystem();
		Container contentPane = roadSystem.getContentPane();
		roadSystem.setTitle("Create road system");
		roadSystem.setSize(400, 300);
		roadSystem.setVisible(true);
	//	roadSystem.setResizable(true);
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

						RoadFrame road = new RoadFrame();
						Container contentPane = road.getContentPane();
						road.setTitle("Create road system");
						road.setSize(800, 600);
						Graph g=new Graph();
					
						road.setTopPanel(g);
			        	road.getMainPanel().setTopComponent(road.getTopPanel());
			        	road.setResizable(true);
			        	road.setVisible(true);
						break;
					case 1:
						this.jSliderJunctions.setValue(3);
						this.jSliderVehicles.setValue(0);
					
						break;

				}
			}

		}
		
	}


/********************************************************************************/

    public JSlider getjSliderJunctions() {
		return jSliderJunctions;
	}

	public JSlider getjSliderVehicles() {
		return jSliderVehicles;
	}

	public JLabel getLableVehicles() {
		return lableVehicles;
	}

	public JLabel getLableJunctions() {
		return lableJunctions;
	}


/********************************************************************************/

}
  

