package version2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class UnderBalance {
	
	public UnderBalance(){
		
	}
	
	public void render(Graphics g){
		if(Game.display == Game.DISPLAY.UnderBal){
			Font fnt5 = new Font("arila", 3, 100);
			g.setColor(new Color(0, 0, 0, 200));
			g.fillRect(5, 5, 1045, 695);
			g.setColor(Color.white);
			g.setFont(fnt5);
			g.drawString("PAY A DEBT", 200, 300);
			g.drawString("SELL A CITY", 200, 400);
			
		}
	}
}
