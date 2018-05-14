package version2;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends Canvas {
	
	JFrame frame;
	public Window(String title, Game game){
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(game);
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.setVisible(true);
		game.start();
	}
	
	public void add(JPanel jpanel){
		frame.add(jpanel);
	}

}
