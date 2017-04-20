import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Falling_Blocks extends GameObject {
	boolean left = true;
	boolean placed = false;

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
if(!placed){		
	y++;

		if (x <= 0) {
			left = false;
		}
		if (x >= 0) {
			left = true;
		}

		if (left) {
			y = y + new Random().nextInt(10);

		}

		if (y > ObjectManager.lanes[lane]) {
			y = ObjectManager.lanes[lane];
			placed = true;
			 ObjectManager.lanes[lane] -= height;
		}
}
		
	}

	public void draw(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(x, y, width, height);
	}
}