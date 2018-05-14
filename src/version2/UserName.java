package version2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class UserName {
	
	Color color = new Color(0,0,0,127);
	
	UserName(){
		
	}
	
	public void tick(){
		
	}
	
	public void render(Graphics g){
		
		g.setColor(color);
		g.drawRect(450, 35, 480, 100);
		g.fillRect(450, 35, 480, 100);
		Font fnt = new Font("arial", 1, 50);
		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawString("Enter your name", 500, 100);
		
	}

}
