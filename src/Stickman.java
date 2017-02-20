import java.awt.Color;
import java.awt.Graphics;

public class Stickman extends GameObject {
	int speed;

	Stickman(int x, int y, int height, int width) {
		super();
		speed = 5;
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
	}

	int gravity = 1;
	int jumpPower = 25;
	int yVelocity = 0;
	int ground = 725;
	boolean rightKey;
	boolean leftKey;
	boolean upkey;
	boolean jump;

	void update() {

		if (rightKey) {
			// x = x + speed;
			x += speed;
			System.out.println("Right key");
		} else if (leftKey) {
			// x = x - speed;
			x -= speed;
			System.out.println("Left key");
		} else if (upkey) {
			Jump();
			System.out.println("up key " + y);

		}
		y -= yVelocity;
		yVelocity -= gravity;
		if (y > ground) {
			y = ground;
			jump = true;
		} else {
			jump = false;
		}
		if (x >= 960) {
			// x = 1000 - width;
			x = 960;

		} else if (x <= 0) {
			x = 0;
			// x = 10;
		}
	}

	void Jump() {
		if (jump == true) {
			yVelocity += jumpPower;
		}
	}

	void draw(Graphics g) {
		g.drawImage(GamePanel.mainImg, x, y, width, height, null);
//		g.setColor(Color.BLUE);
//		g.fillRect(x, y, width, height);
		// g.drawImage(, x, y, width, height, null);

	}

}
