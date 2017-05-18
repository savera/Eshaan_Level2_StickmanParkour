
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	ArrayList<GameObject> objects;

	private int score = 0;

	long enemyTimer = 0;
	int enemySpawnTime = 1000;

	static int[] lanes = { 865, 865, 865, 865, 865, 865, 865, 865, 865, 865, 865, 865, 865, 865 };

	public int getLanes(int i) {
		return lanes[i];
	}

	public void setLanes(int lane, int h) {
		lanes[lane] = h;
	}

	public ObjectManager() {
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

		// purgeObjects();
	}

	public void draw(Graphics g) {

		for (int i = 0; i < objects.size(); i++) {
			GameObject o = objects.get(i);
			o.draw(g);
		}
	}

	private void purgeObjects() {
		for (int i = 0; i < objects.size(); i++) {
			if (!objects.get(i).isAlive) {
				objects.remove(i);
			}
		}
	}

	public void manageEnemies() {
		int enemyLane = new Random().nextInt(Stickman_Parkour.width) / 35;
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addObject(new Falling_Blocks(enemyLane * 35, 0, 35, 35, enemyLane));
			enemyTimer = System.currentTimeMillis();
		}

	}

	public void checkCollision() {
		for (int i = 0; i < objects.size(); i++) {
			for (int j = i + 1; j < objects.size(); j++) {
				GameObject stickman = objects.get(i);
				GameObject fallingBlock = objects.get(j);

				if (stickman instanceof Stickman) {
					stickman = (Stickman)stickman;
					if (stickman.collisionBox3.intersects(fallingBlock.collisionBox) ) {
//						((Stickman) stickman).rightKey = false;
//					stickman.x=(fallingBlock.lane-1) * 35;
						stickman.x -= 5;
						System.out.println("collision");
						//stickman.x += 5;
						System.out.println(fallingBlock.y);
						
					}
					if(stickman.collisionBox4.intersects(fallingBlock.collisionBox)){
						stickman.x += 5;
						System.out.println("COLLISION");
					}
					if(stickman.collisionBox.intersects(fallingBlock.collisionBox)){
						stickman.y -= 35;
						((Stickman) stickman).setGravity(0);
						((Stickman) stickman).setyVelocity(0);
					}
					else{
						((Stickman) stickman).setGravity(1);
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
