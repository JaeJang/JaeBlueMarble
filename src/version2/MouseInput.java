package version2;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import version2.Game.STATE;

public class MouseInput extends MouseAdapter {

	private Handler handler;
	private Game game;
	Random r = new Random();
	GameObject temp2;

	public static int card;
	public static int rolled = 0;
	public static int desertIn1 = 1;
	public static int desertIn2 = 1;
	public static boolean moved1 = false;
	public static boolean moved2 = false;
	public static int sellSelected = 0;
	
	private final int BOXSIZE = 40;
	private final int BOXXPOSITION = 1070;
	private final int YELLOWNAME_Y1 = 95;
	private final int YELLOWNAME_Y2 = 450;
	private final int GREEN_Y1 = 155;
	private final int GREEN_Y2 = YELLOWNAME_Y2 + 60;
	private final int RED_Y1 = 215;
	private final int RED_Y2 = YELLOWNAME_Y2 + 120;
	private final int NAVY_Y1 = 275;
	private final int NAVY_Y2 = YELLOWNAME_Y2 + 180;
	private final int FONTHEIGHT = 15;

	public MouseInput(Handler handler, Game game) {
		this.handler = handler;
		this.game = game;
		card = r.nextInt(4) + 1;
	}

	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		if (Game.gameState == STATE.Username) {

			if (mouseOver(mx, my, 530, 200, 300, 100)) {

				if (handler.object.size() != 0) {
					Game.gameState = STATE.Game;
				}
			}
		}
		if (Game.gameState == STATE.Game) {
			GameObject temp = handler.object.get(0);
			
			if(Game.turn == Game.TURN.Player1 && Game.display != Game.DISPLAY.Sell){
				//istanbul - user1
				choosenCity(5, mx, my, BOXXPOSITION + 40, YELLOWNAME_Y1-15, 75, FONTHEIGHT);
				//cairo - user1
				choosenCity(6, mx, my, BOXXPOSITION + 130, YELLOWNAME_Y1-15, 49, FONTHEIGHT);
				//singapore - user1
				choosenCity(7, mx, my, BOXXPOSITION + 190, YELLOWNAME_Y1-15, 95, FONTHEIGHT);
				//Victoria - user1
				choosenCity(9, mx, my, BOXXPOSITION + 40, YELLOWNAME_Y1+23-15, 70, FONTHEIGHT);
				//Hong Kong - user1
				choosenCity(10, mx, my, BOXXPOSITION + 130, YELLOWNAME_Y1+23-15, 110, FONTHEIGHT);
				//Zurih - user1
				choosenCity(11, mx, my, BOXXPOSITION + 40, GREEN_Y1-15, 47, FONTHEIGHT);
				//Copenhagen - user1
				choosenCity(12, mx, my, BOXXPOSITION + 100, GREEN_Y1-15, 119, FONTHEIGHT);
				//Berlin - user1
				choosenCity(13, mx, my, BOXXPOSITION + 40, GREEN_Y1+23-15, 55, FONTHEIGHT);
				//Stockholm - user1
				choosenCity(15, mx, my, BOXXPOSITION + 110, GREEN_Y1+23-15, 100, FONTHEIGHT);
				//Sydney - user1
				choosenCity(16, mx, my, BOXXPOSITION + 40, RED_Y1-15, 70, FONTHEIGHT);
				//SaoPaulo - user1
				choosenCity(17, mx, my, BOXXPOSITION + 120, RED_Y1-15, 89, FONTHEIGHT);
				//Toronto - user1
				choosenCity(19, mx, my, BOXXPOSITION + 215, RED_Y1-15, 75, FONTHEIGHT);
				//Hawaii - user1
				choosenCity(20, mx, my, BOXXPOSITION + 40, RED_Y1+23-15, 60, FONTHEIGHT);
				//Madrid - user1
				choosenCity(21, mx, my, BOXXPOSITION + 120, RED_Y1+23-15, 65, FONTHEIGHT);
				//Tokyo - user1
				choosenCity(22, mx, my, BOXXPOSITION + 40, NAVY_Y1-15, 58, FONTHEIGHT);
				//Paris - user1
				choosenCity(23, mx, my, BOXXPOSITION + 110, NAVY_Y1-15, 48, FONTHEIGHT);
				//London - user1
				choosenCity(25, mx, my, BOXXPOSITION + 180, NAVY_Y1-15, 72, FONTHEIGHT);
				//Vancouver - user1
				choosenCity(26, mx, my, BOXXPOSITION + 40, NAVY_Y1+23-15, 100, FONTHEIGHT);
				
			}
			else if(Game.turn == Game.TURN.Player2 && Game.display != Game.DISPLAY.Sell){
				//istanbul - user2
				choosenCity(5, mx, my, BOXXPOSITION + 40, YELLOWNAME_Y2-15, 75, FONTHEIGHT);
				//cairo - user2
				choosenCity(6, mx, my, BOXXPOSITION + 130, YELLOWNAME_Y2-15, 49, FONTHEIGHT);
				//singapore - user2
				choosenCity(7, mx, my, BOXXPOSITION + 190, YELLOWNAME_Y2-15, 95, FONTHEIGHT);
				//Victoria - user2
				choosenCity(9, mx, my, BOXXPOSITION + 40, YELLOWNAME_Y2+23-15, 70, FONTHEIGHT);
				//Hong Kong - user2
				choosenCity(10, mx, my, BOXXPOSITION + 130, YELLOWNAME_Y2+23-15, 110, FONTHEIGHT);
				//Zurih - user2
				choosenCity(11, mx, my, BOXXPOSITION + 40, GREEN_Y2-15, 47, FONTHEIGHT);
				//Copenhagen - user2
				choosenCity(12, mx, my, BOXXPOSITION + 100, GREEN_Y2-15, 119, FONTHEIGHT);
				//Berlin - user2
				choosenCity(13, mx, my, BOXXPOSITION + 40, GREEN_Y2+23-15, 55, FONTHEIGHT);
				//Stockholm - user2
				choosenCity(15, mx, my, BOXXPOSITION + 110, GREEN_Y2+23-15, 100, FONTHEIGHT);
				//Sydney - user2
				choosenCity(16, mx, my, BOXXPOSITION + 40, RED_Y2-15, 70, FONTHEIGHT);
				//SaoPaulo - user2
				choosenCity(17, mx, my, BOXXPOSITION + 120, RED_Y2-15, 89, FONTHEIGHT);
				//Toronto - user2
				choosenCity(19, mx, my, BOXXPOSITION + 215, RED_Y2-15, 75, FONTHEIGHT);
				//Hawaii - user2
				choosenCity(20, mx, my, BOXXPOSITION + 40, RED_Y2+23-15, 60, FONTHEIGHT);
				//Madrid - user2
				choosenCity(21, mx, my, BOXXPOSITION + 120, RED_Y2+23-15, 65, FONTHEIGHT);
				//Tokyo - user2
				choosenCity(22, mx, my, BOXXPOSITION + 40, NAVY_Y2-15, 58, FONTHEIGHT);
				//Paris - user2
				choosenCity(23, mx, my, BOXXPOSITION + 110, NAVY_Y2-15, 48, FONTHEIGHT);
				//London - user2
				choosenCity(25, mx, my, BOXXPOSITION + 180, NAVY_Y2-15, 72, FONTHEIGHT);
				//Vancouver - user2
				choosenCity(26, mx, my, BOXXPOSITION + 40, NAVY_Y2+23-15, 100, FONTHEIGHT);
			}
			
			if(Game.display == Game.DISPLAY.Sell){
				if(mouseOver(mx, my, 410, 450, 110, 50)){
						sellCity(temp2); 
						if(User.user1Balance <= 0 || User.user2Balance <= 0) 
							Game.display = Game.DISPLAY.UnderBal;
						else{ 
							Game.display = Game.DISPLAY.Board;
							if(Game.turn == Game.TURN.Player1) Game.turn = Game.TURN.Player2;
							else Game.turn = Game.TURN.Player1;
							rolled = 0;
						}
				}
				if(mouseOver(mx, my, 570, 450, 110, 50)){
					temp2.setSellChoice(false); 
					if(User.user1Balance <= 0 || User.user2Balance <= 0) 
						Game.display = Game.DISPLAY.UnderBal;
					else {
						Game.display = Game.DISPLAY.Board;
						if(Game.turn == Game.TURN.Player1) Game.turn = Game.TURN.Player2;
						else Game.turn = Game.TURN.Player1;
						rolled = 0;
					}
				}
				
			}
			
			if (Game.display == Game.DISPLAY.Board) {
				if (rolled == 0) {
					if (mouseOver(mx, my, 580, 330,100,100)) {
						
						Dice.diceClicked = true;
						rolled = 1;
					}
				}
				if (mouseOver(mx, my, 695, 355, 80, 50)) {
					if(Game.turn == Game.TURN.Player1) Game.turn = Game.TURN.Player2;
					else if(Game.turn == Game.TURN.Player2) Game.turn = Game.TURN.Player2; 
					
				}
			}
			
			if (Game.display == Game.DISPLAY.New) {

				if (mouseOver(mx, my, 410, 450, 110, 50)) {
					if (Game.turn == Game.TURN.Player1) {
						buyingCity(temp, Game.TURN.Player1, User.user1Loca, handler);
						
					}
					if (Game.turn == Game.TURN.Player2) {
						buyingCity(temp, Game.TURN.Player2, User.user2Loca, handler);
						
					}
					if(User.user1Balance <= 0 || User.user2Balance <= 0){
						Game.display = Game.DISPLAY.UnderBal;
					}
					else{
						if (Game.turn == Game.TURN.Player1) Game.turn = Game.TURN.Player2;
						else if(Game.turn == Game.TURN.Player2) Game.turn = Game.TURN.Player1;
					}
					
				}

				if (mouseOver(mx, my, 570, 450, 110, 50)) {
					if (Game.turn == Game.TURN.Player1) {
						Game.turn = Game.TURN.Player2;
						rolled = 0;
						moved1 = false;
						
					} else if (Game.turn == Game.TURN.Player2) {
						Game.turn = Game.TURN.Player1;
						rolled = 0;
						moved2 = false;
					}
					Game.display = Game.DISPLAY.Board;
				}
			}
			
			
			if(Game.display == Game.DISPLAY.OwnedByTheOther){
				if(mouseOver(mx, my, 470, 450, 150, 50)){
					if(Game.turn == Game.TURN.Player1){
						rentCity(temp, Game.TURN.Player1, User.user1Loca, handler);
						if(User.user1Balance >= 0 ) {
							Game.turn = Game.TURN.Player2;
							rolled = 0;
							Game.display = Game.DISPLAY.Board;
						}else{
							Game.display = Game.DISPLAY.UnderBal;
							rolled = 2;
						}
						moved1 = false;
					}
					else if(Game.turn == Game.TURN.Player2){
						rentCity(temp, Game.TURN.Player2, User.user2Loca, handler);
						if(User.user2Balance >= 0){
							Game.turn = Game.TURN.Player1;
							rolled = 0;
							Game.display = Game.DISPLAY.Board;
						}else{
							Game.display = Game.DISPLAY.UnderBal;
							rolled = 2;
						}
						
						moved2 = false;
					}
					
				}
			}
			
			if(Game.display == Game.DISPLAY.BlueCard){
				if(mouseOver(mx, my, 470, 450, 150, 50)){
					bluecardTurnOver();
				}
			}
			
			if(Game.display == Game.DISPLAY.Desert1){
				if(mouseOver(mx, my, 470, 450, 150, 50)){
					if(Game.turn == Game.TURN.Player1){
						DesertIn(Game.TURN.Player1, 2);
					} else if(Game.turn == Game.TURN.Player2){
						DesertIn(Game.TURN.Player2, 2);
					}
				}
			}
			if(Game.display == Game.DISPLAY.Desert2){
				if(mouseOver(mx, my, 470, 450, 150, 50)){
					if(Game.turn == Game.TURN.Player1){
						DesertIn(Game.TURN.Player1, 0);
					} else if(Game.turn == Game.TURN.Player2){
						DesertIn(Game.TURN.Player2, 0);
					}
				}
			}

		}
	}

	public void mouseReleased(MouseEvent e) {
		if (Game.gameState == STATE.Game) {

		}
	}

	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if (mx > x && mx < x + width) {
			if (my > y && my < y + height) {
				return true;
			} else
				return false;
		} else
			return false;
	}
	
	
	//process of buying a city
	private void buyingCity(GameObject temp, Game.TURN player, int userLoca, Handler handler){
		for (int i = 0; i < handler.object.size(); i++) {
			temp = handler.object.get(i);
			if (temp.getCityID() == userLoca)
				break;
		}
		
		if(player == Game.TURN.Player1) {
			User.user1Balance -= temp.getBuy();
			temp.setOwned(1);
			moved1 = false;
		}
		else if(player == Game.TURN.Player2){
			User.user2Balance -= temp.getBuy();
			temp.setOwned(2);
			moved2 = false;
		}
		rolled = 0;
		Game.display = Game.DISPLAY.Board;
		
		
	}
	
	//calculate rent fee
	private void rentCity(GameObject temp, Game.TURN player, int userLoca, Handler handler){
		for (int i = 0; i < handler.object.size(); i++) {
			temp = handler.object.get(i);
			if (temp.getCityID() == userLoca)
				break;
		}
		
		if(player == Game.TURN.Player1){
			User.user1Balance -= temp.getRent();
			User.user2Balance += temp.getRent();
		}
		else if(player == Game.TURN.Player2){
			User.user2Balance -= temp.getRent();
			User.user1Balance += temp.getRent();
		}
		Game.display = Game.DISPLAY.Board;
	}
	
	//process of selling a city
	private void sellCity(GameObject temp){
		if(Game.turn == Game.TURN.Player1){
			User.user1Balance += temp.getBuy();
			temp.setOwned(0);
			temp.setSellChoice(false);
			System.out.println("sold city: "+temp2.getCityID());
		}
		else if(Game.turn == Game.TURN.Player2){
			User.user2Balance += temp.getBuy();
			temp.setOwned(0);
			temp.setSellChoice(false);
			System.out.println("sold city: "+temp2.getCityID());
		}
		
		
	}
	private void choosenCity(int cityID, int mx, int my, int x, int y, int width, int height){
		if(mouseOver(mx, my, x, y, width, height)){
			if(Game.turn == Game.TURN.Player1){
				temp2 = handler.object.get(cityID);
				System.out.println("Clicked: "+temp2.getCityID());
				System.out.println("owned: " + temp2.getOwned());
				if(temp2.getOwned() == 1) {
					temp2.setSellChoice(true);
					//System.out.println(temp2.getCityID());
				}
				
				
			}
			if(Game.turn == Game.TURN.Player2){
				temp2 = handler.object.get(cityID);
				if(temp2.getOwned() == 2) temp2.setSellChoice(true);
				System.out.println("Clicked: "+temp2.getCityID());
			}
			sellSelected = cityID;
			System.out.println(sellSelected);
		}
		
		
	}
	private void bluecardTurnOver(){
		if(card == 1){
			if(Game.turn == Game.TURN.Player1) {
				User.user1Balance += 200;
				Game.turn =Game.TURN.Player2;
				moved1 = false;
			}
			else {
				User.user2Balance += 200;
				Game.turn = Game.TURN.Player1;
				moved2 = false;
			}
		} else if(card ==2){
			if(Game.turn == Game.TURN.Player1){
				User.user1Balance -= 100;
				//Game.turn =Game.TURN.Player2;
				moved1 = false;
				if(User.user1Balance <= 0) 
					Game.display = Game.DISPLAY.UnderBal;
				else {
					Game.turn = Game.TURN.Player2;
				}
			}else {
				User.user2Balance -= 100;
				//Game.turn = Game.TURN.Player1;
				moved2 = false;
				if(User.user1Balance <= 0) 
					Game.display = Game.DISPLAY.UnderBal;
				else {
					Game.turn = Game.TURN.Player1;
				}
			}
		} else if(card == 3){
			if(Game.turn == Game.TURN.Player1){
				User.user1Balance += 100;
				Game.turn =Game.TURN.Player2;
				moved1 = false;
			}else {
				User.user2Balance += 100;
				Game.turn = Game.TURN.Player1;
				moved2 = false;
			}
		}else{
			if(Game.turn == Game.TURN.Player1){
				User.user1Balance -= 100;
				Game.turn =Game.TURN.Player2;
				moved1 = false;
			}else {
				User.user2Balance -= 100;
				Game.turn = Game.TURN.Player1;
				moved2 = false;
			}
			SocialWelfare.welfareFund += 100;
		}
		Game.display = Game.DISPLAY.Board;
		rolled = 0;
		card = r.nextInt(4) + 1;
	}
	private void DesertIn(Game.TURN turn, int desertIn){
		if(turn == Game.TURN.Player1){
			desertIn1 = desertIn;
			Game.turn = Game.TURN.Player2;
		} else if(turn == Game.TURN.Player2){
			desertIn2 = desertIn;
			Game.turn = Game.TURN.Player1;
		}
		Game.display = Game.DISPLAY.Board;
		rolled = 0;
	}
	

}
