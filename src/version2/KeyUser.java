package version2;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


import version2.Game.STATE;

public class KeyUser extends KeyAdapter {

	private Game game;
	private Handler handler;
	public static String USER1;
	public static String USER2;
	public static int CHANGE = 0;
	public static int CHARLENGTH = 0;

	public KeyUser(Handler handler, Game game) {
		this.handler = handler;
		this.game = game;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (game.gameState == STATE.Username) {
			USER1 += (char) key;

			if (key == KeyEvent.VK_BACK_SPACE) {
				if (USER1 != null) {
					USER1 = USER1.substring(0, USER1.length() - 2);
					CHARLENGTH -= 40;
				}
			} else
				CHARLENGTH += 40;
			if (key == KeyEvent.VK_ENTER) {
				if (CHANGE == 0) {

					String a = USER1.substring(4);
					handler.addObject(new User(50, 650, ID.Player1, handler, a, game));
					USER1 = null;
				} else if (CHANGE == 1) {
					String a = USER1.substring(4);
					handler.addObject(new User(100, 650, ID.Player2, handler, a, game));
				}

				CHANGE++;
				CHARLENGTH = 0;
			}
		}
		
		if (key == KeyEvent.VK_ESCAPE)
			System.exit(1);
	}

	public void KeyReleased(KeyEvent e) {

	}

	public String getUSER() {
		return USER1;
	}

}
