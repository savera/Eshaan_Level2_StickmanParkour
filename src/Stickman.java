import java.awt.Color;
import java.awt.Graphics;

public class Stickman extends GameObject {
	int speed;

	Stickman(int x, int y, int height, int width) {
		super();
		speed = 7;
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
	}

	int gravity = 1;
	int jumpPower = 5;
	int yVelocity = 0;
	int ground = 700;
	boolean rightKey;
	boolean leftKey;
	boolean upKey;

	void Jump() {
		yVelocity -= jumpPower;
	}

	void update() {
		if (y > ground) {
			y = ground;
			
		} else {
			yVelocity -= gravity;
		}
		if (rightKey) {
			// x = x + speed;
			x += speed;
			System.out.println("Right key");
		} else if (leftKey) {
			// x = x - speed;
			x -= speed;
			System.out.println("Left key");
		}
		 else if(upKey){
		// y = y - speed;
		 y -= yVelocity;
		 System.out.println("up key" + y);
		
		 }
	}

	void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
		// g.drawImage(, x, y, width, height, null);
		
	}
}
