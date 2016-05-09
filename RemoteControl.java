import lejos.hardware.Button;
import lejos.utility.Delay;

public class RemoteControl {
	
	public RemoteControl() {
	}
	
	public void run(IRSChecker irs, Motors motors, Cannon cannon) {
		while (Button.ESCAPE.isUp()) {	
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
				cannon.shootCannon();
				break;
			case 5:
				motors.moveForward();
				break;
			case 6:
				cannon.rotateCannonLeft();
				break;
			case 7:
				cannon.rotateCannonRight();
				break;
			case 8:
				motors.moveBack();
				break;
			default:
				break;
			}
			Delay.msDelay(500);
		}
	}
}
