package version2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.text.NumberFormat;
import java.util.Locale;

public class SocialWelfare extends GameObject {
	
	Handler handler;
	User user1, user2;
	NumberFormat fmt = NumberFormat.getCurrencyInstance(Locale.US);
	
	private int cityID;
	public static int welfareFund = 0;
	
	public SocialWelfare(double x, double y, int cityID, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		this.cityID = cityID;
	}

	public void tick() {
		if(Game.gameState == Game.STATE.Game){
			user1 = (User)handler.object.get(27);
			user2 = (User)handler.object.get(28);
			/*for(int i = 0; i < handler.object.size(); i ++){
				GameObject temp = handler.object.get(i);
				if(temp.getId() == ID.Player1) 
					user1 = (User)temp;
				else if(temp.getId() == ID.Player2)
					user2 = (User)temp;
			}*/
			
			if(Game.turn == Game.TURN.Player1 && MouseInput.moved1){
				if(handler.user_city(user1.getUserLoca(), cityID, user1.getUserX(), user1.getUserY(), getPointX1(), getPointY())){
					//turnOver(Game.TURN.Player2, User.user1Balance, MouseInput.moved1);
					User.user1Balance += welfareFund;
					welfareFund =0;
					MouseInput.moved1 = false;
					Game.turn = Game.TURN.Player2;
					MouseInput.rolled = 0;
				}
				
			} else if(Game.turn == Game.TURN.Player2 && MouseInput.moved2){
				if(handler.user_city(user2.getUserLoca(), cityID, user2.getUserX(), user2.getUserY(), getPointX2(), getPointY())){
					//turnOver(Game.TURN.Player1, User.user2Balance, MouseInput.moved2);
					User.user2Balance += welfareFund;
					welfareFund =0;
					MouseInput.moved2 = false;
					Game.turn = Game.TURN.Player1;
					MouseInput.rolled = 0;
				}
				
			}
		}
		
	}

	public void render(Graphics g) {
		fmt.setMaximumFractionDigits(0);
		Font fnt = new Font("Impact", 1, 25);
		g.setFont(fnt);
		g.setColor(new Color(0, 255, 0));
		g.drawString("Social Welfare", 876, 30);
		g.drawString("" + fmt.format(welfareFund), 930, 80);
		
	}
	
	public int getPointX1(){
		return 930;
	}
	public int getPointX2(){
		return 970;
		
	}
	public int getPointY(){
		return 40;
	}
	public int getCityID(){
		return cityID;
	}
	private void turnOver(Game.TURN player, int userBalance, boolean moved){
		userBalance += welfareFund;
		welfareFund =0;
		moved = false;
		Game.turn = player;
		MouseInput.rolled = 0;
	}
}
