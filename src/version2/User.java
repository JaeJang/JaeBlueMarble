package version2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import java.util.Locale;
import java.text.NumberFormat;

import version2.Game.STATE;
import version2.Game.TURN;

public class User extends GameObject {
	Handler handler;
	Game game;
	UserCityName usercityname;
	
	private int x, y;
	private String name;
	private ID id;
	private boolean isDoubled = false;
	private int x1_7, x2_7, y_7, x1_13, x2_13, y_13, x1_20, x2_20, y_20, 
				x1_0, x2_0, y_0;
	private final int BOXSIZE = 30;
	private final int BOXXPOSITION = 1070;
	

	NumberFormat fmt = NumberFormat.getCurrencyInstance(Locale.US);

	public static int user1Loca = 0;
	public static int user2Loca = 0;
	
	public static int user1Balance;
	public static int user2Balance;

	public User(double x, double y, ID id, Handler handler, String name, Game game) {
		super(x, y, id);

		this.x = (int) x;
		this.y = (int) y;

		this.name = name;
		this.handler = handler;
		this.id = id;
		this.game = game;
		user1Balance = 1000;
		user2Balance = 1000;
		usercityname = new UserCityName(handler, id);
	}

	@Override
	public void tick() {
		if (Game.turn == TURN.Player1 && id == ID.Player1) {

			if (MouseInput.rolled == 1) {
				int tempDice;

				tempDice = Dice.firstDice + Dice.secondDice;
				if (tempDice != 0 && tempDice == Dice.firstDice * 2) {
					isDoubled = true;
				}
				
				user1Loca += tempDice;
				MouseInput.moved1 = true;
				Dice.firstDice = 0;
				Dice.secondDice = 0;
				GameObject tempObject = handler.object.get(0);
				
				for (int i = 0; i < handler.object.size(); i++) {
					tempObject = handler.object.get(i);
					if (user1Loca == tempObject.getCityID()) {
						break;
					}
				}
				//7 13 20 0
				for(int i = 0; i < handler.object.size(); i++){
					GameObject temp = handler.object.get(i);
					if(temp.getCityID() == 7){
						x1_7 = temp.getPointX1();
						y_7 = temp.getPointY();
					}
					if(temp.getCityID() == 20){
						x1_20 = temp.getPointX1();
						y_20 = temp.getPointY();
					}
					if(temp.getCityID() == 13){
						x1_13 = temp.getPointX1();
						y_13 = temp.getPointY();
					}
					if(temp.getCityID() == 0){
						x1_0 = temp.getPointX1();
						y_0 = temp.getPointY();
					}
				}
				
				if(tempObject.getCityID() <= 7){
					if(x < tempObject.getPointX1()) velX = 2;
					else velX = 0;
				} else if(tempObject.getCityID() <= 13){
					if(x < x1_7){
						velX = 2;
					}
					else if(x >= x1_7 && y > tempObject.getPointY()){
						velX = 0; velY = -2;
					}
					else if(x >= x1_7 && y <= tempObject.getPointY()){
						velX = 0; velY = 0;
					}
				} else if(tempObject.getCityID() <= 20){
					if(x < x1_7){
						velX = 2;
					}
					else if(x >= x1_7 && y > y_20){
						velX = 0; velY = -2;
					}
					else if(x >= x1_7 && y <= y_20){
						velX = 0; velY = 0;
					}
					if(x > tempObject.getPointX1()&& y <= y_20){
						velX = -2; velY = 0;
					} 
					else if(x <= tempObject.getPointX1()){
						velX = 0 ;
					}
				} else if(tempObject.getCityID()<=25){
					if(x >= x1_7 && y > y_20){
						velX = 0; velY = -2;
					}
					else if(x >= x1_7 && y <= y_20){
						velX = 0; velY = 0;
					}
					else if(x > x1_20 && y <= y_20){
						velX = -2; velY = 0;
					}
					else if(x <= x1_20 && y <= y_20){
						velX = 0; velY = 0;
					}
					if(x <= x1_20 && y < tempObject.getPointY()){
						velX = 0; velY = 2;
					}
					else if(x <= x1_20 && y >= tempObject.getPointY()){
						velX = 0; velY = 0;
					}
				}
				if(user1Loca > 25){
					if(x > x1_20 && y <= y_20){
						velX = -2; velY = 0;
					}
					else if(x <= x1_20 && y <= y_20){
						velX = 0; velY = 0;
					}
					else if(x <= x1_20 && y < y_0){
						velX = 0; velY = 2;
					}
					else if(x <= x1_20 && y >= y_0){
						velX = 0; velY = 0;
						user1Loca = user1Loca - 26;
						user1Balance += 100;
					}
					 
				}
				
				
				x += velX;
				y += velY;
				
			}
			
		}
		if (Game.turn == Game.TURN.Player2 && id == ID.Player2) {

			if (MouseInput.rolled == 1) {
				int tempDice;

				tempDice = Dice.firstDice + Dice.secondDice;
				if (tempDice != 0 && tempDice == Dice.firstDice * 2) {
					isDoubled = true;
				}
				
				user2Loca += tempDice;
				MouseInput.moved2 = true;
				Dice.firstDice = 0;
				Dice.secondDice = 0;
				GameObject tempObject = handler.object.get(0);
				
				for (int i = 0; i < handler.object.size(); i++) {
					tempObject = handler.object.get(i);
					if (user2Loca == tempObject.getCityID()) {
						break;
					}
				}
				//7 13 20 0
				for(int i = 0; i < handler.object.size(); i++){
					GameObject temp = handler.object.get(i);
					if(temp.getCityID() == 7){
						x2_7 = temp.getPointX2();
						y_7 = temp.getPointY();
					}
					if(temp.getCityID() == 20){
						x2_20 = temp.getPointX2();
						y_20 = temp.getPointY();
					}
					if(temp.getCityID() == 13){
						x2_13 = temp.getPointX2();
						y_13 = temp.getPointY();
					}
					if(temp.getCityID() == 0){
						x2_0 = temp.getPointX2();
						y_0 = temp.getPointY();
					}
				}
				
				if(tempObject.getCityID() <= 7){
					if(x < tempObject.getPointX2()) velX = 2;
					else velX = 0;
				} else if(tempObject.getCityID() <= 13){
					if(x < x2_7){
						velX = 2;
					}
					else if(x >= x2_7 && y > tempObject.getPointY()){
						velX = 0; velY = -2;
					}
					else if(x >= x2_7 && y <= tempObject.getPointY()){
						velX = 0; velY = 0;
					}
				} else if(tempObject.getCityID() <= 20){
					if(x < x2_7){
						velX = 2;
					}
					else if(x >= x2_7 && y > y_20){
						velX = 0; velY = -2;
					}
					else if(x >= x2_7 && y <= y_20){
						velX = 0; velY = 0;
					}
					if(x > tempObject.getPointX2()&& y <= y_20){
						velX = -2; velY = 0;
					} 
					else if(x <= tempObject.getPointX2()){
						velX = 0 ;
					}
				} else if(tempObject.getCityID()<=25){
					if(x >= x2_7 && y > y_20){
						velX = 0; velY = -2;
					}
					else if(x >= x2_7 && y <= y_20){
						velX = 0; velY = 0;
					}
					else if(x > x2_20 && y <= y_20){
						velX = -2; velY = 0;
					}
					else if(x <= x2_20 && y <= y_20){
						velX = 0; velY = 0;
					}
					if(x <= x2_20 && y < tempObject.getPointY()){
						velX = 0; velY = 2;
					}
					else if(x <= x2_20 && y >= tempObject.getPointY()){
						velX = 0; velY = 0;
					}
				}
				if(user2Loca > 25){
					if(x > x2_20 && y <= y_20){
						velX = -2; velY = 0;
					}
					else if(x <= x2_20 && y <= y_20){
						velX = 0; velY = 0;
					}
					if(x <= x2_20 && y < y_0){
						velX = 0; velY = 2;
					}
					else if(x <= x2_20 && y >= y_0){
						velX = 0; velY = 0;
						user2Loca = user2Loca - 26;
						user2Balance += 100;
					}
					 
				}
				
				x += velX;
				y += velY;
				
			}
		} 
		/*if(Game.turn == Game.TURN.Player1) System.out.println("user1 X: " + x + "\nuser1 Y: " + y);
		if(Game.turn == Game.TURN.Player2) System.out.println("user2 X: " + x + "\nuser2 Y: " + y);*/

	}

	@Override
	public void render(Graphics g) {

		Font fnt = new Font("arila", 1, 40);
		Font fnt2 = new Font("arila", 1, 20);
		Color color = new Color(0, 0, 0, 100);
		fmt.setMaximumFractionDigits(0);
		if (Game.gameState == STATE.Username) {
			g.setFont(fnt);
			g.setColor(Color.black);
			if (id == ID.Player1) {
				g.drawString("User1: " + name, 530, 450);
			} else if (id == ID.Player2) {
				g.drawString("User2: " + name, 530, 550);
			}
		}
		if (Game.gameState == STATE.Game) {
			g.setFont(fnt2);
			g.setColor(color);
			if (id == ID.Player1) {
				g.drawRect(1060, 10, 300, 340);
				g.fillRect(1060, 10, 300, 340);
				g.setColor(Color.white);
				g.drawString(name, 1070, 28);
				g.drawLine(1063, 32, 1357, 32);
				g.drawString("Balance: " + fmt.format(user1Balance), 1070, 55);
				ImageIcon icon = new ImageIcon("images/player1.png");
				g.drawImage(icon.getImage(), x, y, 40, 40, null);
				
			}
			if (id == ID.Player2) {

				g.drawRect(1060, 360, 300, 340);
				g.fillRect(1060, 360, 300, 340);
				g.setColor(Color.white);
				g.drawString(name, 1070, 378);
				g.drawLine(1063, 380, 1357, 380);
				g.drawString("Balance: " + fmt.format(user2Balance), 1070, 403);
				ImageIcon icon2 = new ImageIcon("images/player2.png");
				g.drawImage(icon2.getImage(), x, y, 40, 40, null);
				//usercityname.render(g);

			}
			
			usercityname.render(g);
			
			if (Game.turn == Game.TURN.Player1) {
				g.setColor(Color.red);
				g.drawRect(1060, 10, 300, 340);
				g.drawRect(1059, 9, 302, 342);
				g.drawRect(1058, 8, 304, 344);
				g.drawRect(1057, 7, 306, 346);
				g.drawRect(1056, 6, 308, 348);

			}
			else if (Game.turn == Game.TURN.Player2) {
				g.setColor(Color.red);
				g.drawRect(1060, 360, 300, 340);
				g.drawRect(1059, 359, 302, 342);
				g.drawRect(1058, 358, 304, 344);
				g.drawRect(1057, 357, 306, 346);
				g.drawRect(1056, 356, 308, 348);
			}
			
			
		}
	}

	@Override
	public int getPointX1() {
		return 0;
	}

	@Override
	public int getPointX2() {
		return 0;
	}

	@Override
	public int getPointY() {
		return 0;
	}

	@Override
	public int getCityID() {
		return 1000;
	}
	
	public int getUserX(){
		return x;
	}
	public int getUserY(){
		return y;
	}
	
	public int getUserLoca(){
		if(id == ID.Player1){
			return user1Loca;
		} else return user2Loca;
	}
	
	public int getUserBalance(){
		if(id == ID.Player1){
			return user1Balance;
		} else return user2Balance;
	}
	public String getName(){
		return name;
	}
	

}
