package robotProject;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.utility.Delay;

public class Motors {
	private EV3LargeRegulatedMotor motor1;
	private EV3LargeRegulatedMotor motor2;
	private EV3MediumRegulatedMotor motor3;	
	
	public Motors() {
		this.motor1 = new EV3LargeRegulatedMotor(MotorPort.B);
		this.motor2 = new EV3LargeRegulatedMotor(MotorPort.C);
		this.motor3 = new EV3MediumRegulatedMotor(MotorPort.A);
	}
	
	public void moveForward() {
		stop();
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
	}
	
	public void turnLeft() {
		stop();
		motor2.forward();
	}
	
	public void stop() {
		motor1.stop(true);
		motor2.stop();
	}
	
	public void shootCannon() {
		motor3.rotateTo(300);
		Delay.msDelay(200);
		motor3.rotateTo(0);
	}
	
	public void closeMotors() {
		motor1.close();
		motor2.close();
		motor3.close();
	}
}