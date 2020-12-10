
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import project.Product;
import project.WarehouseController;

public class CreateNewWarehouseBoundary
{//Name, Address, phone number

	JTextField nameField;
	JTextField addressField;
	JTextField cityField;
	JTextField stateField;
	JTextField zipField;
	JTextField phoneField;
	
	JFrame frame;

	public CreateNewWarehouseBoundary()
	{
		
		frame = new JFrame();
		JPanel panel = new JPanel();

		frame.setSize(300, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		panel.setLayout(null);

		JLabel nameLabel = new JLabel("Warehouse Name:");
		nameLabel.setBounds(10,  25,  120,  25);
		panel.add(nameLabel);
		
		nameField = new JTextField();
		nameField.setBounds(150,  25,  120,  25);
		panel.add(nameField);

		JLabel addressLabel = new JLabel("Street Address:");
		addressLabel.setBounds(10,  75,  120,  25);
		panel.add(addressLabel);
		
		addressField = new JTextField();
		addressField.setBounds(150,  75,  120,  25);
		panel.add(addressField);

		JLabel cityLabel = new JLabel("City:");
		cityLabel.setBounds(10,  125,  120,  25);
		panel.add(cityLabel);
		
		cityField = new JTextField();
		cityField.setBounds(150,  125,  120,  25);
		panel.add(cityField);

		JLabel stateLabel = new JLabel("State:");
		stateLabel.setBounds(10,  175,  120,  25);
		panel.add(stateLabel);
		
		stateField = new JTextField();
		stateField.setBounds(150,  175,  120,  25);
		panel.add(stateField);

		JLabel zipLabel = new JLabel("Zip Code:");
		zipLabel.setBounds(10,  225,  120,  25);
		panel.add(zipLabel);
		
		zipField = new JTextField();
		zipField.setBounds(150,  225,  120,  25);
		panel.add(zipField);

		JLabel phoneLabel = new JLabel("Phone Number:");
		phoneLabel.setBounds(10,  275,  120,  25);
		panel.add(phoneLabel);
		
		phoneField = new JTextField();
		phoneField.setBounds(150,  275,  120,  25);
		panel.add(phoneField);
		
		

		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBounds(10, 325, 80, 25);
		cancelButton.addActionListener(new CancelAction());
		panel.add(cancelButton);
		
		JButton enterButton = new JButton("Enter");
		enterButton.setBounds(190, 325, 80, 25);
		enterButton.addActionListener(new EnterAction());
		panel.add(enterButton);
		
		
		
		frame.setTitle("Create New Warehouse");
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
			if(WarehouseController.addWarehouse(new HashMap<Product, Integer>(), nameField.getText(), addressField.getText(), cityField.getText(), stateField.getText(), zipField.getText(), phoneField.getText(), ""))
			{
				frame.dispose();
				new MenuBoundary();
			}
			else
				new Popup("Error: Warehouse name already exists");
		}
	}
}
