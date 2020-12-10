

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import GUI.AddStockBoundary.CancelAction;
import GUI.AddStockBoundary.EnterAction;
import project.InvoiceController;
import project.Product;
import project.WarehouseController;

public class MakePaymentBoundary
{

	JComboBox invoiceField;
	JTextField paymentField;
	
	JFrame frame;
	@SuppressWarnings("unchecked")
	public MakePaymentBoundary()
	{
		frame = new JFrame();
		JPanel panel = new JPanel();

		frame.setSize(300, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		panel.setLayout(null);

		JLabel invoiceLabel = new JLabel("Select Invoice:");
		invoiceLabel.setBounds(10,  25,  120,  25);
		panel.add(invoiceLabel);
		
		String[] invoiceOptions = new String[InvoiceController.getInvoices().size()];
		for(int i = 0; i < invoiceOptions.length; i++)
			invoiceOptions[i] = InvoiceController.getInvoices().get(i).getCustomer().getName();
		invoiceField = new JComboBox(invoiceOptions);
		invoiceField.setBounds(150,  25,  120,  25);
		panel.add(invoiceField);

		JLabel paymentLabel = new JLabel("Payment Amount:");
		paymentLabel.setBounds(10,  125,  120,  25);
		panel.add(paymentLabel);
		
		paymentField = new JTextField();
		paymentField.setBounds(150,  125,  120,  25);
		panel.add(paymentField);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBounds(10, 175, 80, 25);
		cancelButton.addActionListener(new CancelAction());
		panel.add(cancelButton);
		
		JButton enterButton = new JButton("Enter");
		enterButton.setBounds(190, 175, 80, 25);
		enterButton.addActionListener(new EnterAction());
		panel.add(enterButton);
		
		
		
		frame.setTitle("Make Payment");
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
			InvoiceController.makePayment(InvoiceController.getInvoices().get(invoiceField.getSelectedIndex()), Float.parseFloat(paymentField.getText()));
			frame.dispose();
			new MenuBoundary();
		}
	}
}
