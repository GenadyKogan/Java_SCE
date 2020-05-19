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

//hhhhh
import javax.swing.*;


public class RoadFrame extends JFrame {

	//private JPanel jplMaster;
	//private JButton jbnButtons[];

	private JMenu jmenuFile, jmenuHelp,jmenuBackGround ,jmenuVehiclesColor;
	private JMenuItem jmenuitemExit, jmenuitemHelp ;

	Font f12 = new Font("Times New Roman",12, 12);
	Font f121 = new Font("Times New Roman", 12, 12);
	private static final String[] vehiclesColor = { "Blue","Magenta","Orange","Random"};
	private static final String[] backGround = { "Blue","None"};
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
	      for (String btnText : backGround) {
	    	  jmenuBackGround.add(btnText);
		  }

		
		jmenuVehiclesColor = new JMenu("VehiclesColor");
		jmenuVehiclesColor.setFont(f121);
	      for (String btnText : vehiclesColor) {
	    	  jmenuVehiclesColor.add(btnText);
		  }
////
		
		
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

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	/*	JPanel jplButtons = new JPanel();
		jplMaster = new JPanel();
		jplButtons.setLayout(new GridLayout(4, 5, 2, 2));

		
		for (int i=0; i<=9; i++)
		{
			jbnButtons[i] = new JButton(String.valueOf(i));
		}
		jbnButtons[18] = new JButton("1/x");
		jplButtons.add(jbnButtons[18]);
		jplMaster.setLayout(new BorderLayout(2,2));

		jplMaster.add(jplButtons, BorderLayout.SOUTH);
		
		
		getContentPane().add(jplMaster, BorderLayout.SOUTH);
		requestFocus();*/
		
		
		
		
		
		
		
		addWindowListener(new WindowAdapter() {

				public void windowClosed(WindowEvent e)
				{
					System.exit(0);
				}
			}
		);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}	

	public static void main(String args[]) {
		RoadFrame road = new RoadFrame();
	//	Container contentPane = road.getContentPane();
		road.setTitle("Java Swing Calculator");
		road.setSize(232, 212);
	//	road.pack();
		road.setLocation(422, 250);
		road.setVisible(true);
	//	road.setResizable(false);
	}

}






