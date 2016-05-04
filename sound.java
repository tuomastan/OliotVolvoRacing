package sound;

import java.io.File;
import lejos.hardware.Sound;
import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;

public class Main {

	public static void main(String[] args) {
		
		final File music = new File("theme.wav");
//		final Sound player = new Sound(music, 100);
		
		Sound.playSample(music, 100);
		Sound.setVolume(50);
		Delay.msDelay(5000);
		LCD.drawString("Bilet ohi", 0, 0);
		Delay.msDelay(500);
		LCD.clear();
	}

}
