
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import project.InvoiceController;
import project.WarehouseController;

public class CreateNewProductBoundary
{
	JTextField nameField;
	JTextField priceField;
	JTextField costField;
	JFrame frame;
	public CreateNewProductBoundary()
	{
		frame = new JFrame();
		JPanel panel = new JPanel();

		frame.setSize(300, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		panel.setLayout(null);

		JLabel nameLabel = new JLabel("Product Name:");
		nameLabel.setBounds(10,  25,  120,  25);
		panel.add(nameLabel);
		
		nameField = new JTextField();
		nameField.setBounds(150,  25,  120,  25);
		panel.add(nameField);

		JLabel priceLabel = new JLabel("Selling Price:");
		priceLabel.setBounds(10,  75,  120,  25);
		panel.add(priceLabel);
		
		priceField = new JTextField();
		priceField.setBounds(150,  75,  120,  25);
		panel.add(priceField);

		JLabel costLabel = new JLabel("Cost Price:");
		costLabel.setBounds(10,  125,  120,  25);
		panel.add(costLabel);
		
		costField = new JTextField();
		costField.setBounds(150,  125,  120,  25);
		panel.add(costField);

		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBounds(10, 175, 80, 25);
		cancelButton.addActionListener(new CancelAction());
		panel.add(cancelButton);
		
		JButton enterButton = new JButton("Enter");
		enterButton.setBounds(190, 175, 80, 25);
		enterButton.addActionListener(new EnterAction());
		panel.add(enterButton);
		
		
		
		frame.setTitle("Create New Product");
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
			if(WarehouseController.addProduct(nameField.getText(), Float.parseFloat(priceField.getText()), Float.parseFloat(costField.getText())))
			{
				frame.dispose();
				new MenuBoundary();
			}
			else
				new Popup("Error: Product name already exists");
		}
	}

}
