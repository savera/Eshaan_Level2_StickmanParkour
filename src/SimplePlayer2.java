import java.io.File;
import java.io.FileInputStream;

import jaco.mp3.player.MP3Player;

public class SimplePlayer2 {
	 MP3Player playMP3; 
    public SimplePlayer2(String song){

        try{

             FileInputStream fis = new FileInputStream(song);
              playMP3 = new  MP3Player(new File(song));

             playMP3.play();

        }  catch(Exception e){
             System.out.println(e);
           }
    }
    
    void stop() {
    	playMP3.pause();
    	
    }
    
    
}
