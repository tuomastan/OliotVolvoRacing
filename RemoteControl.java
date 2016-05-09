import lejos.hardware.Button;
import lejos.utility.Delay;

public class RemoteControl {
	
	public RemoteControl() {
	}
	
	public void run(IRSChecker irs, Motors motors) {
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
				motors.shootCannon();
				break;
			case 5:
				motors.moveForward();
				break;
			case 6:
				motors.rotateCannonLeft();
				break;
			case 7:
				motors.rotateCannonRight();
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
