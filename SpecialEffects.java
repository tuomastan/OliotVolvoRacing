package remoteControl;

import lejos.hardware.Button;
import lejos.utility.Delay;

public class SpecialEffects {
	
	
	public void lights() {
		for (int i = 0 ; i < 10 ; i++) {
			Button.LEDPattern(1);
			Delay.msDelay(100);
			Button.LEDPattern(2);
			Delay.msDelay(100);
			Button.LEDPattern(3);
			Delay.msDelay(100);
		}
	}
}

