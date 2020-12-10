
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import project.InvoiceController;
import project.WarehouseController;

public class LoginBoundary
{
	private static String password = "password";
	
	public LoginBoundary() 
	{
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();

		frame.setSize(300, 120);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		
		panel.setLayout(null);
		
		
		JLabel label = new JLabel("Password:");
		label.setBounds(15,  20,  80,  25);
		panel.add(label);

		JPasswordField passwordField = new JPasswordField(20);
		passwordField.setBounds(100, 20, 165, 25);
		panel.add(passwordField);
		
		JButton button = new JButton("Enter");
		button.setBounds(185, 50, 80, 25);
		button.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent evt)
					{
						if(java.util.Arrays.equals(passwordField.getPassword(), password.toCharArray()))
						{
							frame.dispose();
							new MenuBoundary();
						}
						//TODO: Open MenuBoundary
						else
							new Popup("The password is incorrect.");
					}
				});
		panel.add(button);
		
		frame.setTitle("Login");
		frame.setVisible(true);
		
		
		frame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                InvoiceController.serializeJSON();
                WarehouseController.serializeJSON();
                System.out.println("Closing...");
            }
        });

	}
	
	//TODO: Make password mutable 
	public void resetPassword(String newPassword)
	{
		
	}
	
	
}
