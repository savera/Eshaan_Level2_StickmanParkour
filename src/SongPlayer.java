import java.io.File;
import jaco.mp3.player.MP3Player;

public class SongPlayer {
	MP3Player playMP3;

	public SongPlayer(String song) {
		try {
			playMP3 = new MP3Player(new File(this.getClass().getResource(song).getFile()));
			playMP3.play();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	void stop() {
		playMP3.pause();

	}

}
