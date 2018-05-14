package version1;

import java.awt.Frame;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

/**
 * @author JaeHyeok
 * @version
 */
public class BlueMarble {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame gameFrame = new JFrame("BlueMarble");
		Back frame = new Back();
		/*
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.getContentPane().add(new gamePanel());
		gameFrame.setExtendedState(Frame.MAXIMIZED_BOTH);
		gameFrame.pack();
		gameFrame.setVisible(true);*/
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.getContentPane().add(new gamePanel());
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.pack();
		frame.setVisible(true);

	}

}
