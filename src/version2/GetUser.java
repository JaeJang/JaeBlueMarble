package version2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import version2.Game.STATE;

public class GetUser{

	private Handler handler;
	Color color = new Color(0, 0, 0, 127);
	Color color2 = new Color(0, 0, 0, 170);
	Game game;

	public GetUser(Handler handler, Game game) {

		this.handler = handler;
		this.game = game;
	}

	

	public void tick() {
		if (KeyUser.CHANGE == 1) {
			// handler.addObject(new User(300, 300, ID.Player1, handler,
			// KeyUser.USER1));
		} else if (KeyUser.CHANGE == 2) {
			// handler.addObject(new User(500, 300, ID.Player2, handler,
			// KeyUser.USER1));
		}

	}

	public void render(Graphics g) {
		if (Game.gameState == STATE.Username) {
			if (KeyUser.USER1 != null) {
				String a = KeyUser.USER1.substring(4);
				Font fnt = new Font("arial", 1, 50);
				g.setFont(fnt);
				if (KeyUser.CHANGE == 0) {
					g.setColor(color);
					g.drawRect(280, 250, 280 + KeyUser.CHARLENGTH, 60);
					g.fillRect(280, 250, 280 + KeyUser.CHARLENGTH, 60);
					g.setColor(Color.white);
					g.drawString("User1: ", 300, 300);
					g.drawString(a, 500, 300);

				} else if (KeyUser.CHANGE == 1) {

					g.setColor(color);
					g.drawRect(280, 250, 280 + KeyUser.CHARLENGTH, 60);
					g.fillRect(280, 250, 280 + KeyUser.CHARLENGTH, 60);
					g.setColor(Color.white);
					g.drawString("User2: ", 300, 300);
					g.drawString(a, 500, 300);

				} else if (KeyUser.CHANGE > 1) {
					g.setColor(color2);
					g.drawRect(530, 200, 300, 100);
					g.fillRect(530, 200, 300, 100);
					g.setColor(Color.white);
					g.drawString("START", 600, 270);
				}

			}
		}
	}

}
