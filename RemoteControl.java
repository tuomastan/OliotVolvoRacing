package modes;
import motors.*;
import threads.IRSChecker;
import lejos.hardware.Button;
import lejos.utility.Delay;

/**
 * The RemoteControl class implements the robot's movement when used on remote control mode. 
 * @author Tuomas Tanskanen
 * @version 1.0 9.5.2016
 */
public class RemoteControl {
	
	public RemoteControl() {
	}
	
	/**
	 * This method reads commands sent from the remote controller
	 * and makes the robot move and act according to those commands.
	 * @param irs This parameter is used to receive commands from the remote controller.
	 * @param motors This parameter is used to move the robot around.
	 * @param cannon This parameter is used to operate the robot's cannon.
	 */
	
	public void drive(IRSChecker irs, Motors motors, Cannon cannon) {
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
				motors.stop();
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
			Delay.msDelay(200);
		}
	}
}
