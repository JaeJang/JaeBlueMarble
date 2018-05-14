package version2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.text.NumberFormat;
import java.util.Locale;

import version2.Game.DISPLAY;

public class GreenLine extends GameObject {

	private int x, y, cityID;
	private String name;
	private ID id;
	Handler handler;
	User user1, user2;
	NumberFormat fmt = NumberFormat.getCurrencyInstance(Locale.US);
	private int yCityWidth = MainBoard.yCityWidth;
	private int xBox = MainBoard.xBox;
	private int xPositon = MainBoard.greenXPosition;
	private int timer;
	private boolean sell = false;
	private boolean sellChoice = false;

	public GreenLine(double x, double y, int cityID, ID id, String name, Handler handler) {
		super(x, y, id);
		this.x = (int) x;
		this.y = (int) y;
		this.cityID = cityID;
		this.id = id;
		this.name = name;
		this.handler = handler;
		if (cityID == 8) buy = 100;
		if (cityID == 9) buy = 100;
		if (cityID == 10) buy = 110;
		if (cityID == 12) buy = 120;
		if (cityID == 8) rent = 120;
		if (cityID == 9) rent = 120;
		if (cityID == 10) rent = 130;
		if (cityID == 12) rent = 140;
		timer = 35;
	}

	public void tick() {
		/*
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject temp = handler.object.get(i);
			if (temp.getId() == ID.Player1) {
				user1 = (User) handler.object.get(i);

			} else if (temp.getId() == ID.Player2) {
				user2 = (User) handler.object.get(i);
			}
		}*/
		if (Game.gameState == Game.STATE.Game) {
			user1 = (User)handler.object.get(27);
			user2 = (User)handler.object.get(28);
			if (Game.turn == Game.TURN.Player1) {
				if (handler.user_city(user1.getUserLoca(), cityID, user1.getUserX(), user1.getUserY(), getPointX1(), getPointY())) {
					if (timer > 0) {
						timer--;
					} else if (timer <= 0) {
						if(MouseInput.moved1){
							if (owned == 0) {
								Game.display = DISPLAY.New;

							} else if (owned == 1) {
								MouseInput.moved1 = false;
								Game.turn = Game.TURN.Player2;
								MouseInput.rolled = 0;
							} else if (owned == 2) {
								Game.display = Game.DISPLAY.OwnedByTheOther;
							}
						}
						
					}
				}
				if(sellChoice){
					Game.display = Game.DISPLAY.Sell;
				}
			}
			if (Game.turn == Game.TURN.Player2) {
				if (handler.user_city(user2.getUserLoca(), cityID, user2.getUserX(), user2.getUserY(), getPointX2(), getPointY())) {
					if (timer > 0) {
						timer--;
					} else if (timer <= 0) {
						if(MouseInput.moved2){
							if (owned == 0) {
								Game.display = DISPLAY.New;
							} else if (owned == 1) {
								Game.display = Game.DISPLAY.OwnedByTheOther;
							} else if (owned == 2) {
								MouseInput.moved2 = false;
								Game.turn = Game.TURN.Player1;
								MouseInput.rolled = 0;
							}
						}
						
					}

				}
				if(sellChoice){
					Game.display = Game.DISPLAY.Sell;
				}
			}
		}
	}

	public void render(Graphics g) {
		Font fnt = new Font("Impact", 1, 15);
		Font fnt2 = new Font("Impact", 2, 60);
		Font fnt3 = new Font("Impact", 1, 35);
		Font fnt4 = new Font("Impact", 1, 25);
		fmt.setMaximumFractionDigits(0);
		if (cityID != 11) {
			g.setColor(Color.black);
			g.drawLine(x, y - yCityWidth, xBox, y - yCityWidth);
			g.setColor(new Color(0, 255, 203));
			g.fillRect(x, y - yCityWidth + 1, 30, yCityWidth - 1);
			g.setColor(Color.white);
			g.setFont(fnt);
			g.drawString(name, x+35, y- 70);
		}
		
		if (Game.display == DISPLAY.New) {

			g.setColor(new Color(0, 0, 0, 200));
			g.fillRect(5, 5, 1045, 695);
			g.setColor(new Color(0, 0, 0, 255));
			g.fillRect(340, 220, 400, 330);
			g.setColor(Color.white);
			g.drawRect(340, 150, 400, 400);
			g.setColor(new Color(0, 255, 203));
			g.fillRect(340, 150, 400, 70);
			g.setColor(Color.white);
			g.setFont(fnt2);
			g.drawString(name, 345, 200);
			g.setFont(fnt3);
			g.drawString("To bulid a hotel", 410, 280);
			g.drawString("" + fmt.format(buy), 500, 350);
			g.setColor(Color.white);
			g.fillRect(410, 450, 110, 50);
			g.fillRect(570, 450, 110, 50);
			g.setColor(Color.black);
			g.setFont(fnt4);
			g.drawString("BUY", 435, 485);
			g.drawString("CANCLE", 575, 485);
		}
		if(Game.display == Game.DISPLAY.OwnedByTheOther){
			g.setColor(new Color(0, 0, 0, 200));
			g.fillRect(5, 5, 1045, 695);
			g.setColor(new Color(0, 0, 0, 255));
			g.fillRect(340, 220, 400, 330);
			g.setColor(Color.white);
			g.drawRect(340, 150, 400, 400);
			g.setColor(new Color(0, 255, 203));
			g.fillRect(340, 150, 400, 70);
			g.setColor(Color.white);
			g.setFont(fnt2);
			g.drawString(name, 345, 200);
			g.setFont(fnt3);
			g.drawString("Pay a Rent", 450, 280);
			g.drawString("" + fmt.format(rent), 500, 350);
			g.setColor(Color.white);
			g.fillRect(470, 450, 150, 50);
			g.setColor(Color.black);
			g.setFont(fnt4);
			g.drawString("Damn, Okay", 473, 485);
		}
		if (Game.display == DISPLAY.Sell) {

			g.setColor(new Color(0, 0, 0, 200));
			g.fillRect(5, 5, 1045, 695);
			g.setColor(new Color(0, 0, 0, 255));
			g.fillRect(340, 220, 400, 330);
			g.setColor(Color.white);
			g.drawRect(340, 150, 400, 400);
			g.setColor(new Color(0, 255, 203));
			g.fillRect(340, 150, 400, 70);
			g.setColor(Color.white);
			g.setFont(fnt2);
			g.drawString(name, 345, 200);
			g.setFont(fnt3);
			g.drawString("Really want to sell?", 410, 280);
			g.drawString("" + fmt.format(buy), 500, 350);
			g.setColor(Color.white);
			g.fillRect(410, 450, 110, 50);
			g.fillRect(570, 450, 110, 50);
			g.setColor(Color.black);
			g.setFont(fnt4);
			g.drawString("SELL", 435, 485);
			g.drawString("CANCLE", 575, 485);
		}
		
	}
	
	public int getPointY(){
		return y - 55;
	}
	public int getPointX1(){
		return 930;
		
	}
	public int getPointX2(){
		return 970;
	}
	public int getCityID(){
		return cityID;
	}
	public String getName(){
		return name;
	}
	public int getBuy() {
		return buy;
	}
	public int getRent(){
		return rent;
	}
	public boolean setSell(boolean sell){
		return this.sell = sell;
	}
	public boolean setSellChoice(boolean sellChoice){
		return this.sellChoice = sellChoice;
	}
}
