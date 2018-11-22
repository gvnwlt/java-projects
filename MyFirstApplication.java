import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyFirstApplication {

	private JFrame frame;
	private JTextField nameTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFirstApplication window = new MyFirstApplication();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MyFirstApplication() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		frame.getContentPane().setForeground(Color.BLACK);
		frame.setBounds(100, 100, 639, 471);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton nameButton = new JButton("Click Me");
		nameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nameTextField.setText("Gavin Walters!"); 
			}
		});
		nameButton.setToolTipText("Java is fun!");
		nameButton.setBounds(0, 414, 633, 29);
		frame.getContentPane().add(nameButton);
		
		nameTextField = new JTextField();
		nameTextField.setEditable(false);
		nameTextField.setForeground(Color.GREEN);
		nameTextField.setBackground(Color.BLACK);
		nameTextField.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		nameTextField.setHorizontalAlignment(SwingConstants.CENTER);
		nameTextField.setText("My name is...");
		nameTextField.setBounds(0, 0, 639, 416);
		frame.getContentPane().add(nameTextField);
		nameTextField.setColumns(10);
	}
}
