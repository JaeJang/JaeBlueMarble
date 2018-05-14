package version2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GetUserName extends JPanel{
	
	private JLabel user1, user2;
	private JTextField username1, username2;
	private JButton submit;
	private JPanel jpanel = new JPanel();
	
	
	public GetUserName(){
		user1 = new JLabel("User1: ");
		user2 = new JLabel("User2: ");
		
		username1 = new JTextField(10);
		username2 = new JTextField(10);
		
		
		submit = new JButton("Submit");
		submit.addActionListener(new submitButtonLisener());
		
		add(user1);
		add(username1);
		add(user2);
		add(username2);
		add(submit);
	}
	
	private class submitButtonLisener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			
		}
	}
}
