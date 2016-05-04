package soundtest;

import java.io.File;

public class Sound extends Thread {
	/**
	 *  @param soundFile Make soundfile to integer to manage files
	 *  @param volume Volume of song/audio
	 *  @param sound
	 *  @param RIFF_HDR_SIZE soundfile has to be larger than 44 bits
	 */
	private int soundFile;
	private static int volume;
	private int sound;
	private static final int RIFF_HDR_SIZE = 44;
	
	public static int playSample (File file, int volume) {
		/**
		 * If file lenght is smaller than RIFF_HDR_SIZE
		 * song is not played
		 * @return -9 which is an error message for the machine
		 */
//		int offset = 0;
//		int sampleRate = 0;
//		int dataLen = 0;
		if (file.length() < RIFF_HDR_SIZE)
			return -9;
		
		/**
		 * @return playSample with file and set volume
		 */
		
		return playSample(file, volume);
		
	}
	
	/**
	 * @return playSample return just audiofile
	 */
	
	public static int playSample(File file) {
		return playSample(file, volume);
	}
	
	/**
	 * Own test for making a constructor 
	 * to play and return audiofile for main program
	 * @return
	 */
	
	public int Sound (File file) {
		this.sound = soundFile;
		return this.soundFile;
				
	}
	
	/**
	 * Sets volume for audiofile
	 * @return volume which is set
	 */
	
//	public int getVolume(){
//		return this.volume;
//	}
	
	
	
}
