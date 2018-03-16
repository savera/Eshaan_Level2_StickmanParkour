import java.awt.Graphics;

public class Stickman extends GameObject {
	float speed;
	int yVelocity = 1;
	int ground = 840;
	boolean rightKey;
	boolean leftKey;
	boolean upkey;
	boolean jump;
	boolean onGround = true;

	Stickman(int x, int y, int height, int width) {
		super();
		speed = 5;
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
	}

	public int getyVelocity() {
		return yVelocity;
	}

	public void setyVelocity(int yVelocity) {
		this.yVelocity = yVelocity;
	}

	void update() {
		super.update();
		System.out.println (y + "THIS IS THE Y <--------------");
		if (rightKey) {
			System.out.println(speed);
			x += speed;
		}
		if (leftKey) {
			System.out.println(speed);
			x -= speed;
		}

		
		if (x >= 463) {
			x = 460;

		} else if (x <= 0) {
			x = 0;
		
		}
		
		if(y > 865) {
			isAlive = false;
		}

	}


	public void draw(Graphics g) {
		 g.drawImage(GamePanel.main2Img, x, y, width, height , null);
	}

}
