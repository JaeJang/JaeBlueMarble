package version2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class SpaceTrip extends GameObject {
	
	Handler handler;
	User user1, user2;
	
	private int cityID;
	
	public SpaceTrip (double x, double y, int cityID, ID id, Handler handler){
		super(x, y, id);
		this.cityID = cityID;
		this.handler = handler;
	}
	
	public void tick(){
		if(Game.gameState == Game.STATE.Game){
			user1 = (User)handler.object.get(27);
			user2 = (User)handler.object.get(28);
			if(Game.turn == Game.TURN.Player1 && MouseInput.moved1){
				if(handler.user_city(user1.getUserLoca(), cityID, user1.getUserX(), user1.getUserY(), getPointX1(), getPointY())){
					MouseInput.moved1 = false;
					Game.turn = Game.TURN.Player2;
					MouseInput.rolled = 0;
				}
			}
			else if(Game.turn == Game.TURN.Player2 && MouseInput.moved2){
				if(handler.user_city(user2.getUserLoca(), cityID, user2.getUserX(), user2.getUserY(), getPointX2(), getPointY())){
					MouseInput.moved2 = false;
					Game.turn = Game.TURN.Player1;
					MouseInput.rolled = 0;
				}
			}
		}
	}
	public void render(Graphics g){
		Font fnt = new Font("Impact", 1, 25);
		g.setFont(fnt);
		g.setColor(new Color(0, 255, 0));
		g.drawString("Free Parking", 25, 30);
	}
	
	public int getPointX1(){
		return 50;
	}
	public int getPointX2(){
		return 100;
	}
	public int getPointY(){
		return 40;
	}
	public int getCityID(){
		return cityID;
	}

}
