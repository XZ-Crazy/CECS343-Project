
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import project.InvoiceController;

public class CreateNewSalespersonBoundary
{
	JTextField nameField;
	JTextField rateField;
	
	JFrame frame;
	public CreateNewSalespersonBoundary()
	{
		frame = new JFrame();
		JPanel panel = new JPanel();

		frame.setSize(300, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		panel.setLayout(null);

		JLabel nameLabel = new JLabel("Salesperson Name:");
		nameLabel.setBounds(10,  25,  120,  25);
		panel.add(nameLabel);
		
		nameField = new JTextField();
		nameField.setBounds(150,  25,  120,  25);
		panel.add(nameField);

		JLabel rateLabel = new JLabel("Commission Rate:");
		rateLabel.setBounds(10,  75,  120,  25);
		panel.add(rateLabel);
		
		rateField = new JTextField();
		rateField.setBounds(150,  75,  120,  25);
		panel.add(rateField);

		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBounds(10, 125, 80, 25);
		cancelButton.addActionListener(new CancelAction());
		panel.add(cancelButton);
		
		JButton enterButton = new JButton("Enter");
		enterButton.setBounds(190, 125, 80, 25);
		enterButton.addActionListener(new EnterAction());
		panel.add(enterButton);
		
		
		
		frame.setTitle("Create New Salesperson");
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
			if(InvoiceController.addSalesperson(nameField.getText(), 0, 0, Float.parseFloat(rateField.getText())))
			{
				frame.dispose();
				new MenuBoundary();
			}
			else
				new Popup("Error: Salesperson name already exists");
		}
	}
}
