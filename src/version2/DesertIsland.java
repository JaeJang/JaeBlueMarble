package version2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;

public class DesertIsland extends GameObject {
	
	Handler handler;
	User user1, user2;
	
	private int cityID;
	private int timer = 35;
	
	public DesertIsland(double x, double y, int cityID, ID id, Handler handler){
		super(x, y, id);
		this.handler = handler;
		this.cityID = cityID;
	}
	
	public void tick(){/*
		for(int i = 0; i < handler.object.size(); i ++){
			GameObject temp = handler.object.get(i);
			if(temp.getId() == ID.Player1) 
				user1 = (User)temp;
			else if(temp.getId() == ID.Player2)
				user2 = (User)temp;
		}
		*/
		if(Game.gameState == Game.STATE.Game){
			user1 = (User)handler.object.get(27);
			user2 = (User)handler.object.get(28);
			if(Game.turn == Game.TURN.Player1 && MouseInput.moved1){
				if(handler.user_city(user1.getUserLoca(), cityID, user1.getUserX(), user1.getUserY(), getPointX1(), getPointY())){
					if(timer > 0){
						--timer;
					}else{
						if(MouseInput.desertIn1 == 1) 
							Game.display = Game.DISPLAY.Desert1;
						else if(MouseInput.desertIn1 == 2)
							Game.display = Game.DISPLAY.Desert2;
					}
				}
			}
			if(Game.turn == Game.TURN.Player2 && MouseInput.moved2){
				if(handler.user_city(user2.getUserLoca(), cityID, user2.getUserX(), user2.getUserY(), getPointX2(), getPointY())){
					if(timer > 0){
						--timer;
					}else{
						if(MouseInput.desertIn2 == 1) 
							Game.display = Game.DISPLAY.Desert1;
						else if(MouseInput.desertIn2 == 2)
							Game.display = Game.DISPLAY.Desert2;
					}
				}
			}
		}
		
	}
	public void render(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		
		Font fnt = new Font("Impact", 1, 25);
		Font fnt2 = new Font("Impact", 2, 60);
		Font fnt3 = new Font("Impact", 1, 35);
		Font fnt4 = new Font("Impact", 1, 25);
		g.setFont(fnt);
		g.setColor(new Color(0, 255, 0));
		g.drawString("Desert Island", 880, 600);
		//g.drawString("Island", 910, 640);
		ImageIcon icon = new ImageIcon("images/desert_island.jpg");
		g.drawImage(icon.getImage(), 911, 618, 100, 80, null);
		
		if(Game.display == Game.DISPLAY.Desert1){
			g.setColor(new Color(0, 0, 0, 200));
			g.fillRect(5, 5, 1045, 695);
			g.setColor(new Color(0, 0, 0, 255));
			g.fillRect(340, 220, 400, 330);
			g.setColor(Color.white);
			g.drawRect(340, 150, 400, 400);
			g.setColor(Color.yellow);
			g.fillRect(340, 150, 400, 70);
			g.setColor(Color.white);
			g.setFont(fnt2);
			g.drawString("Desert Island", 345, 200);
			g.setFont(fnt3);
			g.drawString("You can't play next turn", 355, 280);
			g.setColor(Color.white);
			g.fillRect(470, 450, 150, 50);
			g.setColor(Color.black);
			g.setFont(fnt4);
			g.drawString("Okay", 515, 485);
		}
		
		if(Game.display == Game.DISPLAY.Desert2){
			g.setColor(new Color(0, 0, 0, 200));
			g.fillRect(5, 5, 1045, 695);
			g.setColor(new Color(0, 0, 0, 255));
			g.fillRect(340, 220, 400, 330);
			g.setColor(Color.white);
			g.drawRect(340, 150, 400, 400);
			g.setColor(Color.yellow);
			g.fillRect(340, 150, 400, 70);
			g.setColor(Color.white);
			g.setFont(fnt2);
			g.drawString("Desert Island", 345, 200);
			g.setFont(fnt3);
			g.drawString("You can play next turn", 365, 280);
			g.setColor(Color.white);
			g.fillRect(470, 450, 150, 50);
			g.setColor(Color.black);
			g.setFont(fnt4);
			g.drawString("Okay", 515, 485);
		}
	}
	
	public int getPointX1(){
		return 930;
	}
	public int getPointX2(){
		return 970;
	}
	public int getPointY(){
		return 650;
	}
	public int getCityID(){
		return cityID;
	}
}
