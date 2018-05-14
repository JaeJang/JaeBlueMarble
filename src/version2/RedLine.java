package version2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.text.NumberFormat;
import java.util.Locale;

import version2.Game.DISPLAY;

public class RedLine extends GameObject {
	
	Handler handler;
	User user1, user2;

	private int x, y, cityID;
	private String name;
	private ID id;
	private int xCityWidth = MainBoard.xCityWidth;
	private int yTop = MainBoard.yTop;
	private int yPosition = MainBoard.redYPosition;
	private int timer;private boolean sell = false;
	private boolean sellChoice = false;
	NumberFormat fmt = NumberFormat.getCurrencyInstance(Locale.US);

	public RedLine(double x, double y, int cityID, ID id, String name, Handler handler) {
		super(x, y, id);
		this.x = (int) x;
		this.y = (int) y;
		this.cityID = cityID;
		this.id = id;
		this.name = name;
		this.handler = handler;
		if (cityID == 14) buy = 150;
		if (cityID == 15) buy = 150;
		if (cityID == 17) buy = 160;
		if (cityID == 18) buy = 170;
		if (cityID == 19) buy = 170;
		if (cityID == 14) rent = 170;
		if (cityID == 15) rent = 170;
		if (cityID == 17) rent = 180;
		if (cityID == 18) rent = 190;
		if (cityID == 19) rent = 190;
		timer = 35;
	}

	@Override
	public void tick() {/*
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

	@Override
	public void render(Graphics g) {
		fmt.setMaximumFractionDigits(0);
		Font fnt = new Font("Impact", 1, 15);
		Font fnt2 = new Font("Impact", 2, 60);
		Font fnt3 = new Font("Impact", 1, 35);
		Font fnt4 = new Font("Impact", 1, 25);
		NumberFormat fmt = NumberFormat.getCurrencyInstance(Locale.US);
		g.setFont(fnt);
		g.setColor(Color.black);
		if (cityID < 16) {
			g.drawLine(x - xCityWidth, y, x - xCityWidth, yTop);
			g.setColor(new Color(255, 0, 123));
			g.fillRect(x - xCityWidth + 1, y - 30, xCityWidth - 1, 30);
			g.setColor(Color.white);
			g.drawString(name, x-105, y - 110);
		} else {
			g.drawLine(x - xCityWidth - 7 , y, x - xCityWidth -7, yTop);
			g.setColor(new Color(255, 0, 123));
			g.fillRect(x - xCityWidth + 1 - 7, y - 30, xCityWidth - 1, 30);
			g.setColor(Color.white);
			g.drawString(name, x-105 - 7, y - 110);
		}
		
		if (Game.display == DISPLAY.New) {

			g.setColor(new Color(0, 0, 0, 200));
			g.fillRect(5, 5, 1045, 695);
			g.setColor(new Color(0, 0, 0, 255));
			g.fillRect(340, 220, 400, 330);
			g.setColor(Color.white);
			g.drawRect(340, 150, 400, 400);
			g.setColor(new Color(255, 0, 123));
			g.fillRect(340, 150, 400, 70);
			g.setColor(Color.white);
			g.setFont(fnt2);
			g.drawString(name, 345, 200);
			g.setFont(fnt3);
			g.drawString("To bulid a hotel", 410, 280);
			g.drawString("" + fmt.format(buy), 470, 350);
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
			g.setColor(new Color(255, 0, 123));
			g.fillRect(340, 150, 400, 70);
			g.setColor(Color.white);
			g.setFont(fnt2);
			g.drawString(name, 345, 200);
			g.setFont(fnt3);
			g.drawString("Pay a Rent", 450, 280);
			g.drawString("" + fmt.format(rent), 470, 350);
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
			g.setColor(new Color(255, 0, 123));
			g.fillRect(340, 150, 400, 70);
			g.setColor(Color.white);
			g.setFont(fnt2);
			g.drawString(name, 345, 200);
			g.setFont(fnt3);
			g.drawString("Really want to sell?", 410, 280);
			g.drawString("" + fmt.format(buy), 470, 350);
			g.setColor(Color.white);
			g.fillRect(410, 450, 110, 50);
			g.fillRect(570, 450, 110, 50);
			g.setColor(Color.black);
			g.setFont(fnt4);
			g.drawString("SELL", 435, 485);
			g.drawString("CANCLE", 575, 485);
		}
	}
	
	public int getPointX1(){
		return x - 100;
	}
	public int getPointX2(){
		return x - 50;
	}
	public int getPointY(){
		return 40;
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
