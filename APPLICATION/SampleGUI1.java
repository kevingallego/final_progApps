import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SampleGUI1 {
	public static void main(String[] args) {
		// set container name
		JFrame frame = new JFrame("OOP1 class");

		// set layout
		frame.setLayout(new FlowLayout(FlowLayout.LEFT));

		// label for name and age
		JLabel nameLbl = new JLabel("Name: ");
		JLabel ageLbl = new JLabel("Age: ");

		// text fields for name and age
		final JTextField nameTf = new JTextField(5);
		final JTextField ageTf = new JTextField(2);

		// go button
		JButton goBtn = new JButton("Go");

		// array of button
		JButton[] buttons = new JButton[20];

		// event handler
		goBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int age;
				age = Integer.parseInt(ageTf.getText());
				int i;
				for(i = 0; i < age; i++) {
					System.out.println("Hello " + nameTf.getText());
				}
				JOptionPane.showMessageDialog(null, "Hello " + nameTf.getText(), "Simple", 0);
			}
		});

		// add objects to container
		frame.add(nameLbl);
		frame.add(nameTf);
		frame.add(ageLbl);
		frame.add(ageTf);
		frame.add(goBtn);

		// set size
		frame.setSize(500, 400);

		// set visibility
		frame.setVisible(true);
	}
}