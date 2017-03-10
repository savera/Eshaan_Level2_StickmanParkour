import java.awt.Color;
import java.awt.Graphics;

public class GameObject {
	int x;
	int y;
	int width;
	int height;
	public boolean isAlive;

	void update() {
		// TODO Auto-generated method stub

	}

	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.black);
		g.fillRect(x, y, width,height);	
	}
}
