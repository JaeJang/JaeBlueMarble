package version2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class StartPoint extends GameObject {
	
	Handler handler;
	User user1, user2;
	private ID id;
	private int cityID;
	
	public StartPoint(double x, double y,int cityID, ID id, Handler handler){
		super(x, y, id);
		this.id = id;
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
		Font fnt = new Font("Impact", 1, 45);
		
		g.setFont(fnt);
		g.setColor(new Color(0, 255, 0));
		g.drawString("START", 20, 620);
	}

	@Override
	public int getPointX1() {
		return 50;
	}

	@Override
	public int getPointX2() {
		return 100;
	}

	@Override
	public int getPointY() {
		return 650;
	}

	@Override
	public int getCityID() {
		return 0;
	}

}
