package main;
import modes.*;
import motors.*;
import threads.*;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3IRSensor;
import java.util.Random;
import lejos.hardware.lcd.LCD;
import lejos.hardware.Button;

/**
 * The Main class creates the objects and starts the IRSChecker thread.
 * It also implements the functionality for choosing the robot's mode.
 * After the user exits the while loop, it will stop the thread and close all the motors.
 * @author Tuomas Tanskanen
 * @version 1.0 9.5.2016
 */

public class Main {

	public static void main(String[] args) {
		EV3IRSensor irsSensor = new EV3IRSensor(SensorPort.S4);
		Random randomGenerator = new Random();
		Motors motors = new Motors();
		Cannon cannon = new Cannon();
		IRSChecker irs = new IRSChecker(irsSensor);
		RemoteControl rmt = new RemoteControl();
		AutoPilot ap = new AutoPilot();
		irs.start();
		while (Button.ENTER.isUp()) {
			LCD.drawString("Press right for", 0, 0);
			LCD.drawString("remote control", 0, 1);
			LCD.drawString("Press left", 0, 3);
			LCD.drawString("for autopilot", 0, 4);
			int keycode = Button.waitForAnyPress();
			if (keycode == 8) {
				LCD.clear();
				rmt.drive(irs,motors,cannon);
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
