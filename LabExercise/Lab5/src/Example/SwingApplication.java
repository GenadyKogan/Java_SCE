package Example;
import javax.swing.*;          
import java.awt.*;
import java.awt.event.*;

public class SwingApplication {

    private final static String LABEL_TEXT = "Number of button clicks: ";
    private final static String BUTTON_TEXT = "I'm a Swing button!";
    private final static String FRAME_TEXT = "SwingApplication";
    private int numClicks = 0;

    public Component createComponents() {

        JLabel label = new JLabel(LABEL_TEXT);
        final JTextField textField = new JTextField(String.valueOf(numClicks));
        JButton button = new JButton(BUTTON_TEXT);
        
        button.setMnemonic(KeyEvent.VK_G);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                numClicks++;
                textField.setText(""+numClicks);//String.valueOf(numClicks));
            }
        });
        JPanel pane = new JPanel();
        pane.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));           
        pane.setLayout(new GridLayout(0, 1));        
        pane.add(button);
        pane.add(label);
        pane.add(textField);

        return pane;
    }

    public static void main(String[] args) {
       
        JFrame frame = new JFrame(FRAME_TEXT);
        SwingApplication app = new SwingApplication();
        Component contents = app.createComponents();
        frame.getContentPane().add(contents, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        //frame.setSize(280,150);
        frame.setVisible(true);
    }
}
