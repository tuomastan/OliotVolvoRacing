import lejos.hardware.Button;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;

public class Motors {
	private EV3LargeRegulatedMotor motor1;
	private EV3LargeRegulatedMotor motor2;
	private EV3LargeRegulatedMotor motor3;
	private EV3MediumRegulatedMotor motor4;	
	
	public Motors() {
		this.motor1 = new EV3LargeRegulatedMotor(MotorPort.B);
		this.motor2 = new EV3LargeRegulatedMotor(MotorPort.C);
		this.motor3 = new EV3LargeRegulatedMotor(MotorPort.A);
		this.motor4 = new EV3MediumRegulatedMotor(MotorPort.D);
	}
	
	public void moveForward() {
		stop();
		motor1.forward();
		motor2.forward();
	}
	
	public void autoMoveForward() {
		Button.LEDPattern(4);
		motor1.forward();
		motor2.forward();
	}
	
	public void moveBack() {
		stop();
		motor1.backward();
		motor2.backward();
	}
	
	public void turnRight() {
		stop();
		motor1.forward();
		motor2.backward();
	}
	
	public void turnLeft() {
		stop();
		motor2.forward();
		motor1.backward();
	}
	
	public void stop() {
		motor1.stop(true);
		motor2.stop();
	}
	
	public void shootCannon() {
		motor3.rotate(360);
	}
	
	public void rotateCannonLeft(){
		motor4.rotate(180);
	}
	
	public void rotateCannonRight(){
		motor4.rotate(-180);
	}
	
	public void closeMotors() {
		motor1.close();
		motor2.close();
		motor3.close();
		motor4.close();
	}
}
