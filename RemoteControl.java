package robotProject;
import lejos.hardware.Button;
import lejos.utility.Delay;

public class RemoteControl {
	private IRSChecker irs;
	private Motors motors;
	
	public RemoteControl(IRSChecker irs, Motors motors) {
		this.irs = irs;
		this.motors = motors;
	}
	
	public void run() {
		irs.start();
		while (!Button.ESCAPE.isDown()) {
			int cmd = irs.getRemoteCmd();
			switch(cmd) {
			case 1:
				motors.turnLeft();
				break;
			case 2:
				motors.stop();
				break;
			case 3:
				motors.turnRight();
				break;
			case 4:
				motors.shootCannon();
				break;
			case 5:
				motors.moveForward();
				break;
			case 8:
				motors.moveBack();
				break;
			default:
				break;
			}
			Delay.msDelay(1000);
		}
		irs.stopSampling();
		motors.closeMotors();
	}
}
