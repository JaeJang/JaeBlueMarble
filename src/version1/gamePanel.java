package version1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import version1.GetUserNamePanel.userInfo;

/**
 * @author JaeHyeok
 * @version 1.0
 */
public class gamePanel extends JPanel{
	
	
	
	
	public gamePanel(){
		
		JLabel back = new JLabel ();
		setLayout(new BorderLayout());
		add(back);
		userInfo user = new userInfo();
		back.setLayout(new FlowLayout());
		if(!user.isCreated()){
		
		back.add(new GetUserNamePanel());
		} else{
			for(int i=0; i < user.userNum(); i++){
				
				JLabel n = new JLabel(user.userList().get(i).getName());
				back.add(n);
			}
		}
		
	}

}
