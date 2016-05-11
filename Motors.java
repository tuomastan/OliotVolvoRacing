package motors;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;

/**
 * The Motors class implements the functionality of the motors used for moving around.
 * @author Tuomas Tanskanen
 * @version 1.0 9.5.2016
 */

public class Motors {
	private EV3LargeRegulatedMotor motor1;
	private EV3LargeRegulatedMotor motor2;
	
	public Motors() {
		this.motor1 = new EV3LargeRegulatedMotor(MotorPort.B);
		this.motor2 = new EV3LargeRegulatedMotor(MotorPort.C);
	}
	
	/**
	 * This method makes the two motors rotate forward thus making the robot move forward.
	 */
	
	public void moveForward() {
		motor1.forward();
		motor2.forward();
	}
	
	/**
	 * This method makes the two motors rotate backward thus making the robot move backward. 
	 */
	
	public void moveBack() {
		stop();
		motor1.backward();
		motor2.backward();
	}
	
	/**
	 * This method makes the left motor to rotate forward and the right motor to rotate backward
	 * thus making the robot turn right.
	 */
	
	public void turnRight() {
		stop();
		motor1.forward();
		motor2.backward();
	}
	
	/**
	 * This method makes the right motor to rotate forward and the left motor to rotate backward
	 * thus making the robot turn left.
	 */
	
	public void turnLeft() {
		stop();
		motor2.forward();
		motor1.backward();
	}
	
	/**
	 * This method stops the rotation of the two motors thus making the robot stop.
	 */
	
	public void stop() {
		motor1.stop(true);
		motor2.stop();
	}
	
	/**
	 * This method closes the motors.
	 */
	
	public void closeMotors() {
		motor1.close();
		motor2.close();
	}
}
