package grupo2.ProjectES;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class LaunchPage implements ActionListener {

	JFrame frame = new JFrame();
	JButton btn1 = new JButton("Button");
	
	
	public LaunchPage() {
		
		btn1.setBounds(100,160,100,40);
		btn1.setFocusable(false);
		btn1.addActionListener(this);
		
		frame.add(btn1);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(520,520);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setLocation(550, 200);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btn1) {
			frame.dispose();
			NewWindow newWindow = new NewWindow();
		}
		
	}
}
