import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;


public class SongPlayer {
    private AdvancedPlayer playMP3;

    SongPlayer(String song) {
        try {
            playMP3 = new AdvancedPlayer(SongPlayer.class.getResourceAsStream(song));

            Runnable task = () -> {
                try {
                    playMP3.play();
                    playMP3.close();
                } catch (JavaLayerException e) {
                    e.printStackTrace();
                }
            };

            Thread thread = new Thread(task);
            thread.start();
        }
        catch(Exception exc){
            exc.printStackTrace();
            System.out.format("Failed to play the file: %s.\n", song);
		}
	}

	void stop() {
	    playMP3.close();
	}

}
