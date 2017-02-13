import java.awt.Graphics;
import java.util.Random;

public class Invaders extends GameObject {
	boolean left = true;

	Invaders(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
	}

	void update() {
		super.update();
		y++;

		if (x <= 0) {
			left = false;
		}
		if (x >= 500 - width) {
			left = true;
		}

		if (left) {
			x = x - new Random().nextInt(5);

		} else {
			x = x + new Random().nextInt(5);

		}
	}

	void draw(Graphics g) {
		g.drawRect(x, y, width, height);

	}
}
