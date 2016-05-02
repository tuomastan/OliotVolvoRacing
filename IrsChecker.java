package remoteControl;
import lejos.hardware.Button;
import lejos.hardware.sensor.EV3IRSensor;

public class IrsChecker extends Thread {
	private EV3IRSensor infraredSensor;
	private Motor motor;
	private SpecialEffects se;
	
	public IrsChecker(EV3IRSensor sensor,Motor motor,SpecialEffects se) {
		this.infraredSensor = sensor;
		this.motor = motor;
		this.se = se;
	}
	
	public void run() {
		while (!Button.ENTER.isDown()) {
			int remoteCommand = infraredSensor.getRemoteCommand(0);
			if (remoteCommand == 1) {
				motor.turnLeft();
			} else if (remoteCommand == 2) {
				motor.stop();
			} else if (remoteCommand == 3) {
				motor.turnRight();
			} else if (remoteCommand == 4) {
				motor.shootCatapult();
			} else if (remoteCommand == 5) {
				motor.moveForward();
			} else if (remoteCommand == 6) {
				motor.activateAutoPilot(infraredSensor);
			} else if (remoteCommand == 7) {
				se.lights();
			} else if (remoteCommand == 8) {
				motor.moveBack();
			}
		}
	}

}
