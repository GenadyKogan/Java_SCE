package gui;

import javax.swing.border.TitledBorder;
import javax.swing.event.*; 

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import gui.RoadFrame;
import utilities.Timer;

import javax.swing.*; 
///
import java.awt.geom.Ellipse2D;

import javax.swing.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Random;
////
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import components.Driving;
import components.Map;
import components.Road;
import components.TrafficLights;
import components.Vehicle;
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

	Hashtable<Integer, JLabel> position = new Hashtable<Integer, JLabel>();
	private int valueJunctions;
	
	private int valueVehicles;
	// main class 
	
	
    private static InfoTable table;
    private static int drivingTime;
    private static ArrayList<Timer> allTimedElements;
    private static Map drivermap;
    private static ArrayList<Vehicle> vehicles;
    private static boolean infoflag = false;
    private static graphGui map;
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
	           
	        	setValueJunctions((int)getjSliderJunctions().getValue());
	        	//int valueJunctions =(int)getjSliderJunctions().getValue();
	            //System.out.println("Junction "+getValueJunctions());
	        	
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
	            //int valueVehicles =(int)getjSliderVehicles().getValue();
	           // System.out.println("vehicle"+valueVehicles);
	            setValueVehicles((int)getjSliderVehicles().getValue());
	            //System.out.println("vehicle "+getValueVehicles());
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
			RoadFrame road = new RoadFrame();
			Container contentPane = road.getContentPane();
			road.setTitle("Create road system");
			road.setSize(800, 600);
        	
			if(e.getSource() == jbnButtons[i])
			{
				
				switch(i)
				{
					case 0:


			        	drivermap =new Map(this.getValueJunctions());
			        	vehicles=new ArrayList<Vehicle>();

		                while(vehicles.size()<getValueVehicles()) {
		                    Road temp=drivermap.getRoads().get(getRandomInt(0,drivermap.getRoads().size()));//random road from the map
		                    if( temp.getEnabled())
		                        vehicles.add(new Vehicle(temp));
		                }
		                
		                allTimedElements=new ArrayList<Timer>();
		                allTimedElements.addAll(vehicles);

		                for (TrafficLights light: drivermap.getLights()) {
		                    if (light.getTrafficLightsOn()) {
		                        allTimedElements.add(light);
		                    }
		                }

		                map = new graphGui(drivermap.getJunctions(),vehicles);
		                for (int j = 0;j<drivermap.getJunctions().size();j++){
		          

		                    System.out.println("Junc number "+ j + "X and Y:");

		                    System.out.println(drivermap.getJunctions().get(j).getX());
		                    System.out.println(drivermap.getJunctions().get(j).getY());
		                
		                }
		                

		            //    table = new InfoTable(vehicles);
		             //   table.setVisible(false);
		             
		                
		    			road.setTopPanel(map);
				        road.getMainPanel().setTopComponent(road.getTopPanel());
				        road.setResizable(true);
				        road.setVisible(true);


						break;
					case 1:
		                this.setVisible(false);
		            	this.setResizable(false);
						break;

				}
			}

		}
		
	}


public void setjSliderVehicles(JSlider jSliderVehicles) {
		this.jSliderVehicles = jSliderVehicles;
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

	public int getValueJunctions() {
		return valueJunctions;
	}

	public void setValueJunctions(int valueJunctions) {
		this.valueJunctions = valueJunctions;
	}

	public int getValueVehicles() {
		return valueVehicles;
	}

	public void setValueVehicles(int valueVehicles) {
		this.valueVehicles = valueVehicles;
	}

    private static int getRandomInt(int minimum, int maximum) {
        return new Random().nextInt(maximum-minimum)+minimum;
    }

	public static int getDrivingTime() {
		return drivingTime;
	}

	public static void setDrivingTime(int drivingTime) {
		CreateRoadSystem.drivingTime = drivingTime;
	}

	public static ArrayList<Timer> getAllTimedElements() {
		return allTimedElements;
	}

	public static void setAllTimedElements(ArrayList<Timer> allTimedElements) {
		CreateRoadSystem.allTimedElements = allTimedElements;
	}

	public static Map getDrivermap() {
		return drivermap;
	}

	public static void setDrivermap(Map drivermap) {
		CreateRoadSystem.drivermap = drivermap;
	}

	public static ArrayList<Vehicle> getVehicles() {
		return vehicles;
	}

	public static void setVehicles(ArrayList<Vehicle> vehicles) {
		CreateRoadSystem.vehicles = vehicles;
	}

	public static boolean isInfoflag() {
		return infoflag;
	}

	public static void setInfoflag(boolean infoflag) {
		CreateRoadSystem.infoflag = infoflag;
	}

	public static graphGui getMap() {
		return map;
	}

	public static void setMap(graphGui map) {
		CreateRoadSystem.map = map;
	}

	public static InfoTable getTable() {
		return table;
	}

	public static void setTable(InfoTable table) {
		CreateRoadSystem.table = table;
	}
    
    
/********************************************************************************/

}
  

