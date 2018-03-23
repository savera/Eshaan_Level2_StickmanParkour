
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	
	ArrayList<GameObject> objects;
	
	StickmanParkour stickmanParkour = new StickmanParkour();

	private int score = 0;

	long enemyTimer = 0;
	int enemySpawnTime = 700;

	static int[] lanes;

	public static void initLanes() {
		lanes = new int[] { 865, 865, 865, 865, 865, 865, 865, 865, 865, 865, 865, 865, 865, 865 };
	}

	public int getLanes(int i) {
		return lanes[i];
	}

	public void setLanes(int lane, int h) {
		lanes[lane] = h;
	}

	public ObjectManager() {
		initLanes();
		objects = new ArrayList<GameObject>();

	}

	public void addObject(GameObject o) {
		objects.add(o);
	}

	public void update() {
		for (int i = 0; i < objects.size(); i++) {
			GameObject o = objects.get(i);
			o.update();
		}
	}

	public void draw(Graphics g) {

		for (int i = 0; i < objects.size(); i++) {
			GameObject o = objects.get(i);
			o.draw(g);
		}
	}

	public void manageEnemies() {
		int enemyLane = new Random().nextInt(stickmanParkour.width) / 35;
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addObject(new FallingBlocks(enemyLane * 35, 0, 35, 35, enemyLane));
			enemyTimer = System.currentTimeMillis();
		}

	}

	public void checkCollision() {
		System.out.println(enemySpawnTime);
		for (int i = 0; i < objects.size(); i++) {
			for (int j = i + 1; j < objects.size(); j++) {
				GameObject stickman = objects.get(i);
				GameObject fallingBlock = objects.get(j);

				if (stickman instanceof Stickman) {

					if (stickman.collisionBox.intersects(fallingBlock.collisionBox)) {
						if (((FallingBlocks) fallingBlock).isRed) {

							stickman.y -= 6;

						} else {

						}
					}
					if (stickman instanceof Stickman) {
						if (stickman instanceof Stickman) {

							if (stickman.collisionBox.intersects(fallingBlock.collisionBox)
									|| stickman.collisionBox2.intersects(fallingBlock.collisionBox)
									|| stickman.collisionBox3.intersects(fallingBlock.collisionBox)
									|| stickman.collisionBox4.intersects(fallingBlock.collisionBox)) {
								if (!(((FallingBlocks) fallingBlock).isRed)
										&& !(((FallingBlocks) fallingBlock).isBlue) && !(((FallingBlocks) fallingBlock).isBlack)) {
									stickman.isAlive = false;

								}
							} else {

							}
						}
						
						if (stickman instanceof Stickman) {
							if (stickman.y <= 375) {
								enemySpawnTime = 225;
							} 
						}
						if ((stickman.collisionBox.intersects(fallingBlock.collisionBox))) {
							if (((FallingBlocks) fallingBlock).isBlue) {
								stickman.y -= 6;
								((Stickman) stickman).speed += 0.3;

							} else {

							}

						}
						if ((stickman.collisionBox.intersects(fallingBlock.collisionBox))) {
							if (((FallingBlocks) fallingBlock).isBlack) {
								enemySpawnTime -= 10;
								System.out.println("hi");
							}
						}
						if (stickman.collisionBox3.intersects(fallingBlock.collisionBox)) {
							if (((FallingBlocks) fallingBlock).isRed == false && ((FallingBlocks) fallingBlock).isBlue == false && ((FallingBlocks) fallingBlock).isBlack == false) {
								stickman.x -= 6;

							} else {

							}

						}
						if (stickman.collisionBox4.intersects(fallingBlock.collisionBox)) {
							if (((FallingBlocks) fallingBlock).isRed == false && ((FallingBlocks) fallingBlock).isBlue == false && ((FallingBlocks) fallingBlock).isBlack == false) {
								stickman.x += 6;

							} else {

							}
						}
					}
				}
			}
		}
	}

	public int getScore() {
		return score;
	}

	public void setScore(int s) {
		score = s;
	}

	public void reset() {
		objects.clear();
	}
}
