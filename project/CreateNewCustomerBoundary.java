
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import project.InvoiceController;

public class CreateNewCustomerBoundary
{
	JTextField nameField;
	JTextField taxField;
	JFrame frame;
	public CreateNewCustomerBoundary()
	{
		frame = new JFrame();
		
		JPanel panel = new JPanel();

		frame.setSize(300, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		panel.setLayout(null);

		JLabel nameLabel = new JLabel("Customer Name:");
		nameLabel.setBounds(10,  25,  120,  25);
		panel.add(nameLabel);
		
		nameField = new JTextField();
		nameField.setBounds(150,  25,  120,  25);
		panel.add(nameField);

		JLabel taxLabel = new JLabel("Tax Percentage:");
		taxLabel.setBounds(10,  75,  120,  25);
		panel.add(taxLabel);
		
		taxField = new JTextField();
		taxField.setBounds(150,  75,  120,  25);
		panel.add(taxField);

		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBounds(10, 125, 80, 25);
		cancelButton.addActionListener(new CancelAction());
		panel.add(cancelButton);
		
		JButton enterButton = new JButton("Enter");
		enterButton.setBounds(190, 125, 80, 25);
		enterButton.addActionListener(new EnterAction());
		panel.add(enterButton);
		
		
		
		frame.setTitle("Create New Customer");
		frame.setVisible(true);
	}
	
	

	class CancelAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event) {
			frame.dispose();
			new MenuBoundary();
		}
	}

	class EnterAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event) {
			if(InvoiceController.addCustomer(nameField.getText(), Float.parseFloat(taxField.getText())))
			{
				frame.dispose();
				new MenuBoundary();
			}
			else
				new Popup("Error: Customer name already exists");
		}
	}
	
}
