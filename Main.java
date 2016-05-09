import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.hardware.Sound;
import java.util.Random;
import lejos.hardware.lcd.LCD;
import lejos.hardware.Button;
import java.io.File;

public class Main {

	public static void main(String[] args) {
		EV3IRSensor irsSensor = new EV3IRSensor(SensorPort.S4);
		DiscoLights lights = new DiscoLights();
		Random randomGenerator = new Random();
		Motors motors = new Motors();
		Cannon cannon = new Cannon();
		IRSChecker irs = new IRSChecker(irsSensor);
		RemoteControl rmt = new RemoteControl();
		AutoPilot ap = new AutoPilot();
		irs.start();
		File music = new File("Motor start.wav");
		Sound.playSample(music, 70);
		while (Button.ENTER.isUp()) {
			LCD.drawString("Press right for", 0, 0);
			LCD.drawString("remote control", 0, 1);
			LCD.drawString("Press left", 0, 3);
			LCD.drawString("for autopilot", 0, 4);
			int keycode = Button.waitForAnyPress();
			if (keycode == 8) {
				lights.start();
				LCD.clear();
				rmt.run(irs,motors,cannon);
			} else if (keycode == 16) {
				LCD.clear();
				ap.autoPilot(motors,irs,randomGenerator);
			}
		}
		irs.stopSampling();
		motors.closeMotors();
		cannon.closeCannonMotors();
	}
}
