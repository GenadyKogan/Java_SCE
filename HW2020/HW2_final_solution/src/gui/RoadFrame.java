package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
//hhhddd
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

public class RoadFrame extends JFrame implements ActionListener{
	boolean clearOnNextDigit, percent;
	double lastNumber;
	String lastOperator;
	private JLabel jlbOutput;
	private JButton jbnButtons[];
	private JPanel jplMaster, jplBackSpace, jplControl;


	private JMenu jmenuFile, jmenuHelp;
	private JMenuItem jmenuitemExit, jmenuitemAbout;

	Font f12 = new Font("Times New Roman",12, 12);
	Font f121 = new Font("Times New Roman", 12, 12);
	
	public RoadFrame() 
	{

		jmenuFile = new JMenu("File");
		jmenuFile.setFont(f121);
		
		jmenuitemExit = new JMenuItem("Exit");
		jmenuitemExit.setFont(f12);

		jmenuFile.add(jmenuitemExit);

		jmenuHelp = new JMenu("Help");
		jmenuHelp.setFont(f121);
		jmenuHelp.setMnemonic(KeyEvent.VK_H);

		jmenuitemAbout = new JMenuItem("About Calculator");
		jmenuitemAbout.setFont(f12);
		jmenuHelp.add(jmenuitemAbout);
		
		JMenuBar mb = new JMenuBar();
		mb.add(jmenuFile);
		mb.add(jmenuHelp);
		setJMenuBar(mb);

		jplMaster = new JPanel();

		




	

		addWindowListener(new WindowAdapter() {

				public void windowClosed(WindowEvent e)
				{
					System.exit(0);
				}
			}
		);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}	


	public void actionPerformed(ActionEvent e){
		


	}





	public static void main(String args[]) {
		RoadFrame calci = new RoadFrame();
		calci.setTitle("Java Swing Calculator");
		calci.setSize(232, 217);
	
		calci.setLocation(422, 250);
		calci.setVisible(true);
	//	calci.setResizable(false);
	}


}	



