package modes;
import motors.*;
import threads.IRSChecker;
import java.util.Random;
import lejos.hardware.Button;
import lejos.utility.Delay;

/**
 * The AutoPilot class implements the functionality of the autopilot mode.
 * @author Henri Juppi
 * @version 1.0 9.5.2016
 */
public class AutoPilot {
	
	public AutoPilot() {
	}
	
	/**
	 * A method that keeps the robot moving forward and measuring distance with infrared sensor.
	 * If the measured distance drops below 15 units the robot changes its direction
	 * that is randomized to left, right or backwards.
	 * The method will run until the escape button is pressed.
	 * @param motors Uses the motors for moving the robot
	 * @param irs Uses the infrared sensor for measuring distances
	 * @param rng Uses the random number between 0-2 to decide which direction the robot will turn
	 */
	
	public void autoPilot(Motors motors,IRSChecker irs,Random rng){
		while(Button.ESCAPE.isUp()){
			int random = rng.nextInt(3);
			motors.moveForward();
			if(irs.getDistance() < 15){
				motors.moveBack();
				Delay.msDelay(1000);
				if(random == 0){
					motors.turnRight();
					Delay.msDelay(1000);
				}else if(random == 1){
					motors.turnLeft();
					Delay.msDelay(1000);
				}else if(random == 2){
					motors.turnRight();
					Delay.msDelay(1000);
				}
			}
		}
		motors.stop();
	}
}
