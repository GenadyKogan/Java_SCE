package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


import javax.swing.*;


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
	private static final String[] vehiclesColor = { "Blue","Magenta","Orange","Random"};
	private static final String[] backGround = { "Blue","None"};
	private static final String[] jbnButtonsItems = { "Create read system","Start","Stop","Resume","info"};
	
	

	/*************************************************************/

	public RoadFrame() 
	{

		jmenuFile = new JMenu("File");
		jmenuFile.setFont(f121);
		jmenuFile.setMnemonic(KeyEvent.VK_H);
		jmenuitemExit = new JMenuItem("Exit");
		jmenuitemExit.setFont(f12);
		jmenuFile.add(jmenuitemExit);

	
		jmenuBackGround = new JMenu("BackGround");
		jmenuBackGround.setFont(f121);
		jmenuFile.setMnemonic(KeyEvent.VK_H);
		jmenuitemBlue=new JMenuItem("Blue");
		jmenuitemNone=new JMenuItem("None");
		jmenuBackGround.add(jmenuitemBlue);
		jmenuBackGround.add(jmenuitemNone);
		
//	      for (String btnText : backGround) {
//	    	  jmenuBackGround.add(btnText);
//		  }


		jmenuVehiclesColor = new JMenu("VehiclesColor");
		jmenuVehiclesColor.setFont(f121);
	      for (String btnText : vehiclesColor) {
	    	  jmenuVehiclesColor.add(btnText);
		  }

		
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
			jbnButtons[item] = new JButton(jbnButtonsItems[item]);
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
	//  addActionListener
		addWindowListener(new WindowAdapter() {

				public void windowClosed(WindowEvent e)
				{
					System.exit(0);
				}
			}
		);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jmenuitemExit)
			System.exit(0);
		else if(e.getSource()==jmenuitemBlue) {
			topPanel.setBackground(Color.blue);
		}
		else if(e.getSource()==jmenuitemNone) {
			topPanel.setBackground(null);
	}
	}

	public static void main(String args[]) {
		RoadFrame road = new RoadFrame();
		Container contentPane = road.getContentPane();
		road.setTitle("Java Swing Calculator");
		road.setSize(500, 500);
		road.setVisible(true);
		road.setResizable(true);
	}



	
}







