package version2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class GameOver {
	
	Handler handler;
	User user;
	private String winner;
	
	GameOver(Handler handler){
		this.handler = handler;
		
	}
	
	public void tick(){
		if(Game.gameState == Game.STATE.Game){
			int nCount = 0;
			if(User.user1Balance <= 0){
				for(int i = 0; i < handler.object.size(); i++){
					GameObject temp = handler.object.get(i);
					if(temp.getOwned() == 1) nCount++;
				}
				if(nCount == 0) {
					Game.display = Game.DISPLAY.End;
					winner = ((User)handler.object.get(28)).getName();
					
				}
			}
			if(User.user2Balance <= 0){
				for(int i = 0; i < handler.object.size(); i++){
					GameObject temp = handler.object.get(i);
					if(temp.getOwned() == 2) nCount++;
				}
				if(nCount == 0){
					Game.display = Game.DISPLAY.End;
					winner = ((User)handler.object.get(27)).getName();
				}
			}
		}
		
	}
	
	public void render(Graphics g){
		Font fnt = new Font("Impact", 2, 100);
		Font fnt2 = new Font("Impact", 2, 50);
		Font fnt3 = new Font("Impact", 2, 70);
		if(Game.display == Game.DISPLAY.End){
			g.setColor(new Color(0,0,0,230));
			g.fillRect(0, 220, 1370, 270);
			g.setColor(Color.white);
			g.setFont(fnt);
			g.drawString("GAME OVER", 400, 330);
			g.setFont(fnt2);
			g.drawString("The winner is ", 330,430);
			g.setFont(fnt3);
			g.setColor(new Color(0, 131, 255));
			g.drawString(winner, 660, 430);
			
		}
	}

}
