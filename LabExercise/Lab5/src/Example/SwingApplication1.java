package Example;
import javax.swing.*;          
import java.awt.*;
import java.awt.event.*;

public class SwingApplication1 {

    private final static String FRAME_TEXT = "SwingApplication";

    public static void main(String[] args) {
        
        JFrame frame = new JFrame(FRAME_TEXT);
        myPanel contents = new myPanel();
        frame.add(contents, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(280,150);
        frame.setVisible(true);
    }
}

class myPanel extends JPanel implements ActionListener {

 	static final private long serialVersionUID = 1L;
	private final static String LABEL_TEXT = "Number of button clicks: ";
    private final static String BUTTON_TEXT = "I'm a Swing button!";
    private int numClicks = 0;
	JLabel label;
	final JTextField textField;
	JButton button;
	
    public myPanel() {

        label = new JLabel(LABEL_TEXT);
        textField = new JTextField(String.valueOf(numClicks));
        button = new JButton(BUTTON_TEXT);
        
        button.setMnemonic(KeyEvent.VK_G);
        button.addActionListener(this);

        setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));           
        setLayout(new GridLayout(0, 1));        
        add(button);
        add(label);
        add(textField);
    }

    public void actionPerformed(ActionEvent e) {
        numClicks++;
        textField.setText(String.valueOf(numClicks));
    }
}
