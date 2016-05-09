import lejos.hardware.Button;


public class DiscoLights extends Thread {
	private int keycode;
	
	public DiscoLights() {
		this.keycode = 0;
	}
	
	public int getKeycode() {
		return this.keycode;
	}
	
	public void run() {
		while (keycode == 0) {
			Button.LEDPattern(4);
		}

	}

}
