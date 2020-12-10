
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Popup
{
	public Popup(String message)
	{
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();

		frame.setSize(300, 125);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.add(panel);
		
		panel.setLayout(null);
		
		
		JLabel label = new JLabel(message);
		label.setBounds(15,  20,  220,  25);
		panel.add(label);
		
		JButton button = new JButton("Okay");
		button.setBounds(185, 50, 80, 25);
		button.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent evt)
					{
						frame.dispose();
					}
				});
		panel.add(button);
		
		frame.setTitle("ERROR");
		frame.setVisible(true);
	}
}
