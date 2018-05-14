package version2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//http://blog.naver.com/PostView.nhn?blogId=javaking75&logNo=140173265821
public class Back extends JFrame {
	JScrollPane scrollPane;
	ImageIcon icon;

	public Back() {
		icon = new ImageIcon("C:/Users/JaeHyeok/Desktop/images/background.jpg");
		JPanel background = new JPanel() {

			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}

		};
		scrollPane = new JScrollPane(background);
		setContentPane(scrollPane);
	}
}
