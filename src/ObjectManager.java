
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	ArrayList<GameObject> objects;

	private int score = 0;

	long enemyTimer = 0;
	int enemySpawnTime = 700;

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
		System.out.println(enemySpawnTime);
		for (int i = 0; i < objects.size(); i++) {
			for (int j = i + 1; j < objects.size(); j++) {
				GameObject stickman = objects.get(i);
				GameObject fallingBlock = objects.get(j);

				if (stickman instanceof Stickman) {

					if (stickman.collisionBox.intersects(fallingBlock.collisionBox)) {
						if (((Falling_Blocks) fallingBlock).isRed) {
							//FIX DOWN BELOW - FIXED
							stickman.y -= 6;
							//FIX UP ABOVE - FIXED
							
							// ((Falling_Blocks) fallingBlock).isRed = false;
						} else {

						}
					}
					if (stickman instanceof Stickman) {

						if (stickman.collisionBox.intersects(fallingBlock.collisionBox)
								|| stickman.collisionBox2.intersects(fallingBlock.collisionBox)
								|| stickman.collisionBox3.intersects(fallingBlock.collisionBox)
								|| stickman.collisionBox4.intersects(fallingBlock.collisionBox)) {
							if (!(((Falling_Blocks) fallingBlock).isRed) && !(((Falling_Blocks) fallingBlock).isBlue)) {
								stickman.isAlive = false;
								//System.out.println("DEAD");
							}
						} else {

						}
					}
					if (stickman instanceof Stickman){
						if (stickman.y > 220) {
							enemySpawnTime =700;
						}
					
					}
					if (stickman instanceof Stickman){
						if (stickman.y <= 225) {
							enemySpawnTime =225;
						}
						else {
							enemySpawnTime = enemySpawnTime;
						}
					}
					if ((stickman.collisionBox.intersects(fallingBlock.collisionBox))) {
						if (((Falling_Blocks) fallingBlock).isBlue) {
							stickman.y -= 6;
							((Stickman) stickman).speed += 2;
							//((Falling_Blocks) fallingBlock).isBlue = false;
						} else {

						}
					}
					if (stickman.collisionBox3.intersects(fallingBlock.collisionBox)) {
						if (((Falling_Blocks) fallingBlock).isRed == false) {
							stickman.x -= 5;
							//System.out.println("collision");
							// stickman.x += 5;
							//System.out.println(fallingBlock.y);
						} else {

						}

					}
					if (stickman.collisionBox4.intersects(fallingBlock.collisionBox)) {
						if (((Falling_Blocks) fallingBlock).isRed == false) {
							stickman.x += 5;
							//System.out.println("COLLISION");
						} else {

						}

					}

					// if
					// (stickman.collisionBox6.intersects(fallingBlock.collisionBox))
					// {
					// ((Stickman) stickman).setyVelocity(5);
					// }
					// else
					// if(stickman.collisionBox5.intersects(fallingBlock.collisionBox)){
					// //stickman.y -= 35;
					// ((Stickman) stickman).onGround = true;
					//
					// }
					else {
						// ((Stickman) stickman).onGround = false;
						// ((Stickman) stickman).setGravity(1);
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
