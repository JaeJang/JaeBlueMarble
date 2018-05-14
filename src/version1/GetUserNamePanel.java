package version1;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class GetUserNamePanel extends JPanel {
	
	private JLabel user1, user2, user3, user4;
	private JTextField username1, username2, username3, username4;
	private JButton submit;
	private static int submitted;
	public static ArrayList<Users> users = new ArrayList<Users>();
	public static String name1, name2, name3, name4;
	
	public GetUserNamePanel(){
		user1 = new JLabel("User1: ");
		user2 = new JLabel("User2: ");
		user3 = new JLabel("User3: ");
		user4 = new JLabel("User4: ");
		
		username1 = new JTextField(10);
		username2 = new JTextField(10);
		username3 = new JTextField(10);
		username4 = new JTextField(10);
		
		submit = new JButton("Submit");
		submit.addActionListener(new submitButtonListener());
		
		add(user1);
		add(username1);
		add(user2);
		add(username2);
		add(user3);
		add(username3);
		add(user4);
		add(username4);
		add(submit);
		
	}
	
	private class submitButtonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			name1 = username1.getText();
			name2 = username2.getText();
			name3 = username3.getText();
			name4 = username4.getText();
			saveUsername(name1);
			saveUsername(name2);
			saveUsername(name3);
			saveUsername(name4);
			
;		}
		
		private void saveUsername(String username){
			if(username != null || username != ""){
				Users u = new Users(username);
				users.add(u);
				u.setUsernumber();
			}
		}
	}
	
		static class userInfo{
		public ArrayList<Users> userList(){
			return users;
		}
		public int userNum(){
			return users.size();
		}
		public boolean isCreated(){
			return users != null;
		}
	}
	
	

}
