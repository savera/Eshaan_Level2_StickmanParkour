import java.io.File;
import jaco.mp3.player.MP3Player;

public class SimplePlayer {
	MP3Player playMP3;

	public SimplePlayer(String song) {

		try {
			playMP3 = new MP3Player(new File(song));

			playMP3.play();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	void stop() {
		playMP3.pause();

	}

}
