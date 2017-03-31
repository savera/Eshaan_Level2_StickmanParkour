import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Falling_Blocks extends GameObject {
	boolean left = true;

	Falling_Blocks(int x, int y, int width, int height, int lane) {
		super();
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		this.lane = lane;
	}

	void update() {
		super.update();
		System.out.println(x + "." + y + ".");
		y++;

		if (x <= 0) {
			left = false;
		}
		if (x >= 0) {
			left = true;
		}

		if (left) {
			y = y + new Random().nextInt(5);

		}

		// else {
		// y = y+new Random().nextInt(5);
		//
		// }
		if (y >= 844) {
			y = 844;
		}
	}

	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(x, y, width, height);
	}
}
