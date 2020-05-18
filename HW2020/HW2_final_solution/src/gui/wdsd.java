package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;


import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class wdsd  extends JPanel{
	   private static final String TITLE_TEXT = "Use The Buttons Below To Manage Transactions";
	   private static final String[] BTN_TEXTS = { "Create a New Account",
	         "Load a Trans from a File", "Add New Transactions",
	         "Search Transactions", "Sort Transactions",
	         "View/Delete Transactions", "Backup Transaction", "Exit" };
	   private static final int TITLE_POINTS = 24;

	   public wdsd() {
	      JLabel titleLabel = new JLabel(TITLE_TEXT, SwingConstants.CENTER);
	      titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD,
	            TITLE_POINTS));
	      JPanel titlePanel = new JPanel();
	      titlePanel.add(titleLabel); // put it in a JPanel so it will expand to fill BoxLayout

	      JPanel accountBalancePanel = new JPanel();
	      accountBalancePanel.add(new JLabel("Account Name:"));
	      accountBalancePanel.add(new JTextField(10));
	      accountBalancePanel.add(Box.createHorizontalStrut(20));
	      accountBalancePanel.add(new JLabel("Balance:"));
	      accountBalancePanel.add(new JTextField(10));

	      JPanel northPanel = new JPanel();
	      northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.PAGE_AXIS));
	      northPanel.add(titlePanel);
	      northPanel.add(accountBalancePanel);

	      JPanel southBtnPanel = new JPanel(new GridLayout(2, 4, 1, 1));
	      for (String btnText : BTN_TEXTS) {
	         southBtnPanel.add(new JButton(btnText));
	      }

	      setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
	      setLayout(new BorderLayout());
	      add(northPanel, BorderLayout.NORTH);
	      add(Box.createRigidArea(new Dimension(400, 400))); // just an empty placeholder
	      add(southBtnPanel, BorderLayout.SOUTH);
	   }

	   private static void createAndShowGui() {
		   RoadFrame mainPanel = new RoadFrame();

	      JFrame frame = new JFrame("Nested Panels Example");
	      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	      frame.getContentPane().add(mainPanel);
	      frame.pack();
	      frame.setLocationByPlatform(true);
	      frame.setVisible(true);
	   }

	   public static void main(String[] args) {
	      SwingUtilities.invokeLater(new Runnable() {
	         public void run() {
	            createAndShowGui();
	         }
	      });
	   }
}
