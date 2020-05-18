import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class CustomABOUTDialog extends JDialog implements ActionListener {
	JButton jbnOk;

	CustomABOUTDialog(JFrame parent, String title, boolean modal){
		super(parent, title, modal);
		setBackground(Color.black);
		
		JPanel p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));

		StringBuffer text = new StringBuffer();
		text.append("Calculator Information\n\n");
		text.append("Developer:	Hemanth\n");
		text.append("Version:	1.0");
		
		JTextArea jtAreaAbout = new JTextArea(5, 21);
		jtAreaAbout.setText(text.toString());
		jtAreaAbout.setFont(new Font("Times New Roman", 1, 13));
		jtAreaAbout.setEditable(false);

		p1.add(jtAreaAbout);
		p1.setBackground(Color.red);
		getContentPane().add(p1, BorderLayout.CENTER);

		JPanel p2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		jbnOk = new JButton(" OK ");
		jbnOk.addActionListener(this);

		p2.add(jbnOk);
		getContentPane().add(p2, BorderLayout.SOUTH);

		setLocation(408, 270);
		setResizable(false);

		addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e)
				{
					Window aboutDialog = e.getWindow();
					aboutDialog.dispose();
				}
			}
		);

		pack();
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == jbnOk)	{
			this.dispose();
		}
	}
	
}