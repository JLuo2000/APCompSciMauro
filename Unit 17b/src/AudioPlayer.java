import java.io.*;

import javax.sound.sampled.AudioFormat;
//import sun.audio.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
public class AudioPlayer {
	
	private Clip clip;
	private File audiofile;
	private String filename;
	private boolean isPlaying;
	private long fileLength;
	
	public AudioPlayer(String file) throws UnsupportedAudioFileException, IOException {
		filename = file;
		audiofile = new File(filename).getAbsoluteFile();
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audiofile);
	    AudioFormat format = audioInputStream.getFormat();
	    long audioFileLength = file.length();
	    int frameSize = format.getFrameSize();
	    float frameRate = format.getFrameRate();
	    fileLength = (long) ((audioFileLength / (frameSize * frameRate)) * 1000);
	}
	public void play()  {
		try {
			isPlaying = true;
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audiofile);
	        clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start();
	    } catch(Exception ex) {
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace();
	    }
	}
	public void playMusic()  {
		try {
			isPlaying = true;
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audiofile);
	        clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.loop(100000);

	    } catch(Exception ex) {
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace();
	    }
	}
	public void stop() {
		isPlaying = false;
		clip.stop();
		clip.close();
	}
	public long getAudioLength() {
		return fileLength;
	}
}
