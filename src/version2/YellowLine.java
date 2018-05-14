package version2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.ImageIcon;

import version2.Game.DISPLAY;

public class YellowLine extends GameObject {

	Handler handler;
	User user1;
	User user2;

	NumberFormat fmt = NumberFormat.getCurrencyInstance(Locale.US);

	private String name;
	private ID id;
	private int cityID;
	private int x, y;
	private int xCityWidth = MainBoard.xCityWidth;
	private int yBox = MainBoard.yBox;
	private int yPosition = MainBoard.yellowYPosition;

	private int owned;
	private int timer;
	private int buy;
	private int rent;
	//private boolean sell = false;
	private boolean sellChoice;

	public YellowLine(double x, double y, int cityID, ID id, String name, Handler handler) {
		super(x, y, id);
		this.name = name;
		this.id = id;
		this.cityID = cityID;
		this.x = (int) x;
		this.y = (int) y;
		this.handler = handler;
		owned = 0;
		timer = 35;
		sellChoice = false;
		if (cityID == 1) buy = 50;
		if (cityID == 2) buy = 50;
		if (cityID == 3) buy = 60;
		if (cityID == 5) buy = 70;
		if (cityID == 6) buy = 70;
		if (cityID == 1) rent = 70;
		if (cityID == 2) rent = 70;
		if (cityID == 3) rent = 80;
		if (cityID == 5) rent = 90;
		if (cityID == 6) rent = 90;
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
			}
			if(sellChoice){
				Game.display = Game.DISPLAY.Sell;
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
		g.setColor(Color.black);
		if (cityID > 0 && cityID < 4) {
			g.drawLine(x + xCityWidth, y, x + xCityWidth, yBox);
			g.setColor(new Color(236, 255, 119));
			g.fillRect(x + 1, y, xCityWidth - 1, 30);
		} else if (cityID == 5 || cityID == 6) {
			g.drawLine(x + xCityWidth + 7, y, x + xCityWidth + 7, yBox);

			g.setColor(new Color(236, 255, 119));
			g.fillRect((x + 7) + 1, y, xCityWidth - 1, 30);

		}

		g.setColor(Color.white);
		g.setFont(fnt);
		if (cityID < 4) {
			g.drawString(name, x + 5, yPosition + 50);
		} else if (cityID > 4) {
			g.drawString(name, x + 5 + 7, yPosition + 50);
		}
		if (cityID == 5) {
			ImageIcon icon = new ImageIcon("images/canada.png");
			g.drawImage(icon.getImage(), x + 30, y + 53, 70, 40, null);
		}

		if (Game.display == DISPLAY.New) {

			g.setColor(new Color(0, 0, 0, 200));
			g.fillRect(5, 5, 1045, 695);
			g.setColor(new Color(0, 0, 0, 255));
			g.fillRect(340, 220, 400, 330);
			g.setColor(Color.white);
			g.drawRect(340, 150, 400, 400);
			g.setColor(new Color(236, 255, 119));
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
			g.setColor(new Color(236, 255, 119));
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
			g.setColor(new Color(236, 255, 119));
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

	public int getPointX1() {
		return x + 10;
	}

	public int getPointX2() {
		return x + 60;
	}

	public int getPointY() {
		return 650;
	}

	public int getCityID() {
		return cityID;
	}
	

	public int getOwned() {
		return owned;
	}

	public int getBuy() {
		return buy;
	}

	public void setOwned(int owned) {
		this.owned = owned;
	}
	
	public String getName(){
		return name;
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
