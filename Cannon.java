package motors;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;

/**
 * The Cannon class implements the functionality of the robot's cannon.
 * @author Niko Hölttä
 * @version 1.0 9.5.2016
 */

public class Cannon {
	private EV3LargeRegulatedMotor motor3;
	private EV3MediumRegulatedMotor motor4;
	
	public Cannon() {
		this.motor3 = new EV3LargeRegulatedMotor(MotorPort.A);
		this.motor4 = new EV3MediumRegulatedMotor(MotorPort.D);
	}
	
	/**
	 * This method rotates the motor3 360 degrees thus making the robot shoot the cannon.
	 */
	
	public void shootCannon() {
		motor3.rotate(360);
	}
	
	/**
	 * This method rotates the motor4 180 degrees thus making the cannon turn left.
	 */
	
	public void rotateCannonLeft(){
		motor4.rotate(60);
	}
	
	/**
	 * This method rotates the motor4 -180 degrees thus making the cannon turn right.
	 */
	
	public void rotateCannonRight(){
		motor4.rotate(-60);
	}
	
	/**
	 * This method closes the cannon's motors.
	 */
	
	public void closeCannonMotors() {
		motor3.close();
		motor4.close();
	}
}
