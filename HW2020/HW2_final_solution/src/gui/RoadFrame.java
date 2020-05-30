package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import components.Driving;
import utilities.Timer;
public class RoadFrame extends JFrame  implements ActionListener {
	private JSplitPane mainPanel  = new JSplitPane();
	private JPanel jplMaster;
	private JPanel topPanel=new JPanel();
	private JButton jbnButtons[];
	JLabel text =new JLabel();
	private JMenu jmenuFile, jmenuHelp,jmenuBackGround ,jmenuVehiclesColor;
	private JMenuItem jmenuitemExit, jmenuitemHelp,jmenuitemBlue,jmenuitemNone ;
	 private final JScrollPane scrollPane;
	Font f12 = new Font("Times New Roman",12, 12);
	Font f121 = new Font("Times New Roman", 12, 12);
	//private static final String[] vehiclesColor = { "Blue","Magenta","Orange","Random"};
	private JMenuItem  jmBlue, jmMagenta, jmOrange, jmRandom;
	private static final String[] backGround = { "Blue","None"};
	private static final String[] jbnButtonsItems1 = { "Create read system","Start","Stop","Resume","info"};
	private static int valJuncSlider;
	private int valueJunctions;
	private static InfoTable table;
	/*********************/
/**
 * defective constructor 
 */
	public RoadFrame () 
	{
		jmenuFile = new JMenu("File");
		jmenuFile.setFont(f121);
		jmenuFile.setMnemonic(KeyEvent.VK_H);
		
		jmenuitemExit = new JMenuItem("Exit");
		jmenuitemExit.setFont(f12);
		jmenuFile.add(jmenuitemExit);
		
		jmenuBackGround = new JMenu("BackGround");
		jmenuBackGround.setFont(f121);
		jmenuBackGround.setMnemonic(KeyEvent.VK_H);
		
		jmenuitemBlue=new JMenuItem("Blue");
		jmenuitemNone=new JMenuItem("None");
		jmenuBackGround.add(jmenuitemBlue);
		jmenuBackGround.add(jmenuitemNone);
		
		jmenuVehiclesColor = new JMenu("VehiclesColor");
		jmenuVehiclesColor.setFont(f121);
		jmenuVehiclesColor.setMnemonic(KeyEvent.VK_H);
	
		jmBlue=new JMenuItem("Blue");
		jmMagenta=new JMenuItem("Magenta");
		jmOrange=new JMenuItem("Orange");
		jmRandom=new JMenuItem("Random");	
		jmenuVehiclesColor.add(jmBlue);
		jmenuVehiclesColor.add(jmMagenta);		
		jmenuVehiclesColor.add(jmOrange);
		jmenuVehiclesColor.add(jmRandom);

		
		jmenuHelp = new JMenu("Help");
		jmenuHelp.setFont(f121);
		jmenuHelp.setMnemonic(KeyEvent.VK_H);
		jmenuitemHelp = new JMenuItem("Help");
		jmenuitemHelp.setFont(f12);
		jmenuHelp.add(jmenuitemHelp);

		JMenuBar mb = new JMenuBar();
		mb.add(jmenuFile);
		mb.add(jmenuBackGround);
		mb.add(jmenuVehiclesColor);
		mb.add(jmenuHelp);
		setJMenuBar(mb);

//======================================================================================

		jbnButtons = new JButton[5];		
		for( int item=0;item<5; item++) {
			jbnButtons[item] = new JButton(jbnButtonsItems1[item]);
		}
		getContentPane().add(mainPanel);
		scrollPane = new JScrollPane(); 
		jplMaster = new JPanel();
		mainPanel.setOrientation(JSplitPane.VERTICAL_SPLIT);
		mainPanel.setDividerLocation(200);
		mainPanel.setTopComponent(topPanel);
		mainPanel.setBottomComponent(jplMaster);


//======================================================================================

		jplMaster.setLayout(new GridLayout(1,5));
		for( int item=0;item<5; item++) {
			jplMaster.add(jbnButtons[item]);
		}
		getContentPane().add(jplMaster, BorderLayout.PAGE_END);

		for (int i=0; i<jbnButtons.length; i++){
			jbnButtons[i].addActionListener(this);
		}

		//  addActionListener

		jmenuitemExit.addActionListener(this);
		jmenuBackGround.addActionListener(this);
		jmenuitemBlue.addActionListener(this);
		jmenuitemNone.addActionListener(this);
		jmenuitemHelp.addActionListener(this);
		
		jmBlue.addActionListener(this);
		jmMagenta.addActionListener(this);
		jmOrange.addActionListener(this);
		jmRandom.addActionListener(this);

		addWindowListener(new WindowAdapter() {
				public void windowClosed(WindowEvent e)
				{
					System.exit(0);
				}
			}
		);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}	

	/**
	 * @param e - type ActionEvent
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
        CreateRoadSystem roadSystem = new CreateRoadSystem();
		Container contentPane = roadSystem.getContentPane();
		roadSystem.setTitle("Create road system");
		roadSystem.setSize(400, 300);
		if(e.getSource()==jmenuitemExit)
			System.exit(0);
		else if(e.getSource()==jmenuitemBlue) {
			topPanel.setBackground(Color.blue);
		}
		else if(e.getSource()==jmenuitemNone) {
			topPanel.setBackground(null);
		}
		else if(e.getSource()==jmenuitemHelp) {
			JDialog dlgAbout = new CustomABOUTDialog(this, "Sapir\n Gena\n", true);
			dlgAbout.setVisible(true);
		}
		else if(e.getSource()==jmBlue) {
            Color tempclr  = new Color(0, 0, 255);
            roadSystem.getGui().setColor(tempclr);
            roadSystem.getGui().repaint();

		}
		else if(e.getSource()==this.jmMagenta) {
            Color tempclr  = new Color(255, 0, 255);
            roadSystem.getGui().setColor(tempclr);
            roadSystem.getGui().repaint();
	
		}
		else if(e.getSource()==this.jmOrange) {
            Color tempclr  = new Color(255, 200, 0);
            roadSystem.getGui().setColor(tempclr);
            roadSystem.getGui().repaint();
		
		}
		else if(e.getSource()==jmRandom) {
            Color tempclr  = new Color(0, 255, 255);
            roadSystem.getGui().setColor(tempclr);
            roadSystem.getGui().repaint();
		
		}
		for (int i=0; i<jbnButtons.length; i++)
		{

			if(e.getSource() == jbnButtons[i])
			{
				
				switch(i)
				{
				// create road system button
					case 0:
						roadSystem.setVisible(true);
						roadSystem.setResizable(true);
						this.setVisible(false);
						this.setResizable(false);

						break;
				// start button
					case 1:
						
						roadSystem.setDrivingTime(0);
		                for (int j=0; j<10;j++) {

		                	roadSystem.getGui().repaint();
		                    for(Timer element: roadSystem.getAllTimedElements()) {
		                        element.incrementDrivingTime();
		                        roadSystem.getGui().repaint();
		                        
		                    }

		                }
						break;
				// stop button 
					case 2:
						                
	
						break;
				// resume button
					case 3:
						
						System.exit(0);
						break;
				// info button
					case 4:
		                if (roadSystem.isInfo() == true){
		                	roadSystem.setInfo(false);		
		                }
		                else{
		                    roadSystem.setInfo(true);
		                    roadSystem.setInfo(false);
		                    roadSystem.setTable(new InfoTable( roadSystem.getVehicles()));
		                }
						break;
				}
			}

		}
		
	}



	//======================================================================================

	public static void main(String args[]) {
		RoadFrame road = new RoadFrame();
		Container contentPane = road.getContentPane();
		road.setTitle("Road Systems");
		road.setSize(500, 500);
		road.setVisible(true);
		road.setResizable(true);

	}
	/**
	 * 
	 * @return mainPanel - type JSplitPane
	 */
	public JSplitPane getMainPanel() {
		return mainPanel;
	}
	/**
	 * 
	 * @return topPanel - type JPanel
	 */
	public JPanel getTopPanel() {
		return topPanel;
	}
	/**
	 * 
	 * @param topPanel - type JPanel
	 */
	public void setTopPanel(JPanel topPanel) {
		this.topPanel = topPanel;
	}





	

}